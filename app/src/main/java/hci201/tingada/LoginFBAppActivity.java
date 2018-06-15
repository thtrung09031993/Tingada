package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginFBAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fbapp);
    }

    public void clickToLoginFBHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    public void clickToBackLoginPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
