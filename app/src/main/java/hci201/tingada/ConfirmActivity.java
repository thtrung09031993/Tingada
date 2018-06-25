package hci201.tingada;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {
    private Button btnNext;
    private EditText txtC1, txtC2, txtC3, txtC4;
    private TextView txtResend;
    private String confirmCode = "1111";
    private TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        String phone = intent.getExtras().getString("phoneNumber");
        txtPhone = findViewById(R.id.txtPhone);
        txtPhone.setText(phone);

        txtC1 = findViewById(R.id.txtConfirm1);
        txtC2 = findViewById(R.id.txtConfirm2);
        txtC3 = findViewById(R.id.txtConfirm3);
        txtC4 = findViewById(R.id.txtConfirm4);
        btnNext = findViewById(R.id.btnNextPhone);


        txtC1.requestFocus();

        txtC1.addTextChangedListener(new CodeWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!txtC1.getText().toString().isEmpty()){
                    txtC2.requestFocus();
                }
            }
        });
        txtC2.addTextChangedListener(new CodeWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!txtC2.getText().toString().isEmpty()){
                    txtC3.requestFocus();
                }
                else {
                    txtC1.requestFocus();
                }
            }
        });
        txtC3.addTextChangedListener(new CodeWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!txtC3.getText().toString().isEmpty()){
                    txtC4.requestFocus();
                }
                else {
                    txtC2.requestFocus();
                }
            }
        });
        txtC4.addTextChangedListener(new CodeWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!txtC4.getText().toString().isEmpty()){
                    btnNext.setBackgroundResource(R.color.tingada);
                }
                else {
                    txtC3.requestFocus();
                }
            }
        });

    }

    public void clickToConfirmPhone(View view) {
        String tmp = txtC1.getText().toString() + txtC2.getText().toString() + txtC3.getText().toString() + txtC4.getText().toString();
        System.out.println(tmp);
        if (tmp.equals(confirmCode)) {
            Toast.makeText(this, "Confirm successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TabHomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Wrong confirm code!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickToResend(View view) {
        Intent intent = new Intent(this, LoginPhoneActivity.class);
        startActivity(intent);
    }
}
