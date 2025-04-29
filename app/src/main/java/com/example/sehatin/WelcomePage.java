    package com.example.sehatin;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;

    import androidx.appcompat.app.AppCompatActivity;

    public class WelcomePage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome_page);

            ImageView startButton = findViewById(R.id.startbutton);

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent untuk pindah ke LoginMenu
                    Intent intent = new Intent(WelcomePage.this, RegisterOption.class);
                    startActivity(intent);
                }
            });
        }
    }
