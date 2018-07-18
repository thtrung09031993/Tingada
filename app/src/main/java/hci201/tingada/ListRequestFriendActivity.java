package hci201.tingada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListRequestFriendActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_request_friend);
        recyclerView = findViewById(R.id.rv_request);
        ArrayList<String> data = new ArrayList<>();
        data.add("Alpha");data.add("Beta");data.add("Gamma");data.add("Delta");data.add("Omega");data.add("Hexa");
        final ListRequestAdapter list = new ListRequestAdapter(data);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(list);
        list.setItemClickListener(new ItemClickListener<Integer>() {
            @Override
            public void onAccept(Integer pos) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("person", list.getData(pos));
                startActivity(intent);
                list.remove(pos);
                list.notifyDataSetChanged();
            }

            @Override
            public void onReject(Integer pos) {
                list.remove(pos);
                list.notifyDataSetChanged();
            }
        });
    }
}
