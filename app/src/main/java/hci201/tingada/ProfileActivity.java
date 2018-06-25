package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {

    CheckBox chkMusic, chkMovie, chkSport, chkReading;
    LinearLayout musicGenres, movieGenres, sportGenres, readingGenres;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_profile);
        chkMusic = findViewById(R.id.chkMusic);
        chkMovie = findViewById(R.id.chkMovie);
        chkSport = findViewById(R.id.chkSport);
        chkReading = findViewById(R.id.chkReading);
        musicGenres = findViewById(R.id.musicGenres);
        movieGenres = findViewById(R.id.movieGenres);
        sportGenres = findViewById(R.id.sportGenres);
        readingGenres = findViewById(R.id.readingGenres);
        btnSave = findViewById(R.id.btnSaveProfile);

        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    musicGenres.setVisibility(View.VISIBLE);
                }
                else {
                    musicGenres.setVisibility(View.GONE);
                }
            }
        });

        chkMovie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    movieGenres.setVisibility(View.VISIBLE);
                }
                else {
                    movieGenres.setVisibility(View.GONE);
                }
            }
        });

        chkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sportGenres.setVisibility(View.VISIBLE);
                }
                else {
                    sportGenres.setVisibility(View.GONE);
                }
            }
        });

        chkReading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    readingGenres.setVisibility(View.VISIBLE);
                }
                else {
                    readingGenres.setVisibility(View.GONE);
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Profile saved successfully!", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void clickToBackSettingProfilePage(View view) {
        finish();
    }
}
