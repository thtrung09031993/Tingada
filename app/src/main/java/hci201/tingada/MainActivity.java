package hci201.tingada;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    private TextView txtTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.sliderImg);
        SliderImgLoginActivity sliderImgLoginActivity = new SliderImgLoginActivity(this);
        viewPager.setAdapter(sliderImgLoginActivity);
    }

    public void clickToLoginFB(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public void clickToLoginPhone(View view) {
        Intent intent = new Intent(this, LoginPhoneActivity.class);
        startActivity(intent);
    }
}
