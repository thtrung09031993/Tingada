package hci201.tingada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final Button btnFind = (Button) findViewById(R.id.btnFind);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtStatus = (TextView) findViewById(R.id.txtStatus);
                txtStatus.setText("Looking for people nearby...");

                btnFind.setVisibility(View.GONE);
            }
        });
    }

    public void clickToProfile(View view) {
    }

    public void clickToContact(View view) {
    }

}
