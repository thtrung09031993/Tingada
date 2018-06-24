package hci201.tingada;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView rvChatScreen;
    ChatScreenAdapter chatScreenAdapter;
    LinearLayoutManager chatLLM;
    TextView txtGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        txtGreet = findViewById(R.id.txtGreet);
        txtGreet.setText(getIntent().getStringExtra("person"));

        if (getIntent().getIntExtra("reported", 0) == 1){
            Toast.makeText(getApplicationContext(), "Your report has been recorded!", Toast.LENGTH_LONG).show();
        }

        Spinner spinner = findViewById(R.id.spinner);
        final String[] paths = {"", "Report"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, paths){
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View v = null;

                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }

                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        //Chat Screen
        rvChatScreen = findViewById(R.id.rvChatScreen);
        List<String> chatData = new ArrayList<>();
        chatData.add("Hello");
        chatData.add("How are you!");
        chatData.add("I miss you so much!");
        chatData.add("Mùa xuân có em như chưa bắt đầu\n" +
                "Và cơn gió như khẽ mơn man lay từng nhành hoa rơi\n" +
                "Em đã bước tới như em đã từng\n" +
                "Chạy trốn với anh trên cánh đồng xanh.\n" +
                "\n");
        chatData.add("Mùa xuân có em như chưa bắt đầu\n" +
                "Và cơn gió như khẽ mơn man lay từng nhành hoa rơi\n" +
                "Em đã bước tới như em đã từng\n" +
                "Chạy trốn với anh trên cánh đồng xanh.\n" +
                "\n");
        chatData.add("Mùa xuân có em như chưa bắt đầu\n" +
                "Và cơn gió như khẽ mơn man lay từng nhành hoa rơi\n" +
                "Em đã bước tới như em đã từng\n" +
                "Chạy trốn với anh trên cánh đồng xanh.\n" +
                "\n");
        chatScreenAdapter = new ChatScreenAdapter(chatData);
        chatLLM = new LinearLayoutManager(getApplicationContext());
        chatLLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvChatScreen.setLayoutManager(chatLLM);
        rvChatScreen.setAdapter(chatScreenAdapter);

        //Button back
        ImageButton btnBack = findViewById(R.id.btnBackChat);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TabHomeActivity.class);
                intent.putExtra("tab", 2);
                startActivity(intent);
            }
        });

        //Send message
        ImageButton btnSend = findViewById(R.id.btnSendMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtMessage = findViewById(R.id.edtMessage);
                String message= edtMessage.getText().toString();
                if (!message.isEmpty()){
                    chatScreenAdapter.addMoreItems(message);
                    chatScreenAdapter.notifyItemInserted(chatScreenAdapter.getItemCount() - 1);
                    rvChatScreen.smoothScrollToPosition(chatScreenAdapter.getItemCount() - 1);
                    View view = getCurrentFocus();
                    if (view != null) { // clear text field and hide keyboard
                        edtMessage.setText("");
                        view.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 1:
                parent.setSelection(0);
                Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                intent.putExtra("reportedUser", txtGreet.getText().toString());
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        View view = getCurrentFocus();
        if (view != null) { // clear text field and hide keyboard
            view.clearFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
