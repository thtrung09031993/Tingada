package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_purchase);

        final LinearLayout layout12 = findViewById(R.id.layout12Month);
        final LinearLayout layout6 = findViewById(R.id.layout6Month);
        final LinearLayout layout1 = findViewById(R.id.layout1Month);

        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout12.setBackground(getDrawable(R.drawable.border));
                layout6.setBackgroundResource(0);
                layout1.setBackgroundResource(0);
            }
        });

        layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout6.setBackground(getDrawable(R.drawable.border));
                layout12.setBackgroundResource(0);
                layout1.setBackgroundResource(0);
            }
        });

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setBackground(getDrawable(R.drawable.border));
                layout6.setBackgroundResource(0);
                layout12.setBackgroundResource(0);
            }
        });

        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
