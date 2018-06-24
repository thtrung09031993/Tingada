package hci201.tingada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        TextView txtGreet = findViewById(R.id.txtGreet);
        txtGreet.setText(getIntent().getStringExtra("person"));

        
    }
}
