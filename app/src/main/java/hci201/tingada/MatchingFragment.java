package hci201.tingada;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchingFragment extends Fragment {


    public MatchingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_matching, container, false);
        layout.findViewById(R.id.edtSearch).clearFocus();

        TextView txtFeed = layout.findViewById(R.id.txtFeed);
        txtFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
                TabAdapter adapter = (TabAdapter) viewPager.getAdapter();
                adapter.replaceFragmentAtPosition(new FeedFragment(), 2);
                adapter.notifyDataSetChanged();
            }
        });

        RecyclerView recyclerViewMatch = (RecyclerView) layout.findViewById(R.id.rvMatch);
        List<String> matchData = new ArrayList<>();
        matchData.add("Alpha");
        matchData.add("Beta");
        matchData.add("Gamma");
        matchData.add("Lambda");
        matchData.add("Penta");
        matchData.add("Hexa");
        matchData.add("Quadra");
        MatchAdapter matchAdapter = new MatchAdapter(matchData);
        matchAdapter.setOnItemClickedListener(new MatchAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String username) {
                Intent intent = new Intent(getContext(), ChatActivity.class);
                intent.putExtra("person", username);
                startActivity(intent);
            }
        });
        LinearLayoutManager matchLLM = new LinearLayoutManager(getContext());
        matchLLM.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewMatch.setLayoutManager(matchLLM);
        recyclerViewMatch.setAdapter(matchAdapter);


//        ImageButton btnPurchase = layout.findViewById(R.id.btnPurchase);
//        btnPurchase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), PurchaseActivity.class));
//            }
//        });

        RecyclerView recyclerViewMessage = (RecyclerView) layout.findViewById(R.id.rvMessage);
        List<String> messageData = new ArrayList<>();
        messageData.add("Alpha");
        messageData.add("Beta");
        messageData.add("Gamma");
        messageData.add("Lambda");
        messageData.add("Penta");
        messageData.add("Hexa");
        messageData.add("Quadra");
        MessageAdapter messageAdapter = new MessageAdapter(messageData);
        messageAdapter.setOnItemClickedListener(new MessageAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String username) {
                Intent intent = new Intent(getContext(), ChatActivity.class);
                intent.putExtra("person", username);
                startActivity(intent);
            }
        });
        LinearLayoutManager messageLLM = new LinearLayoutManager(getContext());
        messageLLM.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMessage.setLayoutManager(messageLLM);
        recyclerViewMessage.setAdapter(messageAdapter);


        return layout;
    }

}
