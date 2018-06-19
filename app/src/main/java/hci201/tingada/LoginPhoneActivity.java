package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPhoneActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);
    }

    public void clickToSendPhone(View view) {
        btnSend = (Button) findViewById(R.id.btnSendPhone);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        if (txtPhone.getText().toString() == null || txtPhone.getText().toString() == "" ||
                txtPhone.getText().toString().length() > 12 || txtPhone.getText().toString().length() < 1) {
            Toast.makeText(this, "Phone is invaild!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sent code confirm to phone number " + txtPhone.getText().toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ConfirmActivity.class);
            intent.putExtra("phoneNumber", txtPhone.getText().toString());
            startActivity(intent);
        }
    }
}
