package com.example.sehatin;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private Uri photoUri;
    private File photoFile;
    public String userEmail;
    public String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Ambil semua TextView dari layout
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView caloriesMax = findViewById(R.id.caloriesMax);
        TextView proteinMax = findViewById(R.id.proteinMax);
        TextView carbsMax = findViewById(R.id.carbsMax);
        TextView fatMax = findViewById(R.id.fatsMax);
        TextView heightView = findViewById(R.id.heightView);
        TextView weightView = findViewById(R.id.weightView);

        // Ambil data dari Intent
        Intent intent = getIntent();
        userEmail = intent.getStringExtra("USER_EMAIL");
        userPassword = intent.getStringExtra("USER_PASSWORD");

        databaseHelper userDataDB = new databaseHelper(MainPage.this);
        Cursor userDataCursor = userDataDB.searchUserData(userEmail, userPassword);

        userDataCursor.moveToFirst();
        String userName = userDataCursor.getString(1);
        String userWeight = userDataCursor.getString(8);
        String userHeight = userDataCursor.getString(7);
        String userMaxCalorieIntake = userDataCursor.getString(10);
        String userMaxProtein = userDataCursor.getString(11);
        String userMaxFat = userDataCursor.getString(12);
        String userMaxCarb = userDataCursor.getString(13);

        /* Jika tidak ada data dari Intent, ambil dari SharedPreferences
        if (userName == null || userName.isEmpty()) {
            SharedPreferences sharedPref = getSharedPreferences("user_data", MODE_PRIVATE);
            userName = sharedPref.getString("USER_NAME", "Username");
        }
        */

        // Setel data ke TextView
        usernameTextView.setText(userName);
        caloriesMax.setText(userMaxCalorieIntake);
        proteinMax.setText(String.valueOf(userMaxProtein));
        carbsMax.setText(String.valueOf(userMaxCarb));
        fatMax.setText(String.valueOf(userMaxFat));
        heightView.setText(userHeight);
        weightView.setText(userWeight);

        // Tombol rekomendasi membuka fragment
        ImageView recommendButton = findViewById(R.id.recommend_button);
        recommendButton.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecommendFragment()).addToBackStack(null).commit();
        });

        // Tombol kamera
        ImageView cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        REQUEST_CAMERA_PERMISSION);
            } else {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                photoFile = createImageFile();
                if (photoFile != null) {
                    photoUri = FileProvider.getUriForFile(this,
                            getPackageName() + ".provider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                Toast.makeText(this, "Gagal membuat file gambar", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Kamera tidak tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName, ".jpg", storageDir);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, "Izin kamera ditolak", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
