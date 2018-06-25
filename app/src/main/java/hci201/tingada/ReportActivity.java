package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    ImageButton btnBack;
    Button btnConfirm;
    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_report);
        txtUser = findViewById(R.id.userReport);
        txtUser.setText(getIntent().getStringExtra("reportedUser"));

        //Back
        btnBack = findViewById(R.id.btnBackReport);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Confirm
        btnConfirm = findViewById(R.id.btnConfirmReport);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("person", txtUser.getText().toString());
                intent.putExtra("reported", 1);
                startActivity(intent);
            }
        });

    }
}
