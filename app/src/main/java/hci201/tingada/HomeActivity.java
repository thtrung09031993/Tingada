package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final Button btnFind = (Button) findViewById(R.id.btnFind);
        init();
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtStatus = (TextView) findViewById(R.id.txtStatus);
                txtStatus.setText("Looking for people nearby...");

                btnFind.setVisibility(View.GONE);
                ImageView imgMagnifier = (ImageView) findViewById(R.id.imgMagnifier);
                imgMagnifier.setVisibility(View.VISIBLE);
                Thread searchProcess = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            startActivity(new Intent(getApplicationContext(), TabHomeActivity.class));
                            finish();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                searchProcess.start();
            }
        });
    }

    private void init(){
        ImageButton btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        ImageButton btnContact = (ImageButton) findViewById(R.id.btnContact);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(),SettingActivity.class));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(getApplicationContext(),ContactView.class));
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
}
