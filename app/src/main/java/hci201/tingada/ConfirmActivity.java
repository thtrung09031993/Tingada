package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {
    private Button btnNext;
    private TextView txtC1;
    private TextView txtC2;
    private TextView txtC3;
    private TextView txtC4;
    private TextView txtResend;
    private String confirmCode = "1111";
    private TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        String phone = intent.getExtras().getString("phoneNumber");
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtPhone.setText(phone);

    }

    public void clickToConfirmPhone(View view) {
        btnNext = (Button) findViewById(R.id.btnNextPhone);
        txtC1 = (TextView) findViewById(R.id.txtConfirm1);
        txtC2 = (TextView) findViewById(R.id.txtConfirm2);
        txtC3 = (TextView) findViewById(R.id.txtConfirm3);
        txtC4 = (TextView) findViewById(R.id.txtConfirm4);
        String tmp = txtC1.getText().toString() + txtC2.getText().toString() + txtC3.getText().toString() + txtC4.getText().toString();
        System.out.println(tmp);
        if (tmp.equals(confirmCode)) {
            Toast.makeText(this, "Confirm successfully!", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this, HomeActivity.class);
            //startActivity(intent);
        } else {
            Toast.makeText(this, "Wrong confirm code!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickToResend(View view) {
        Intent intent = new Intent(this, LoginPhoneActivity.class);
        startActivity(intent);
    }
}
