package hci201.tingada;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    RecyclerView rvFeed;
    FeedAdapter feedAdapter;
    LinearLayoutManager feedLLM;
    List<String> feedData;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final LinearLayout layout = (LinearLayout)  inflater.inflate(R.layout.fragment_feed, container, false);
        TextView txtMessage = layout.findViewById(R.id.txtMessage);
        txtMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
                TabAdapter adapter = (TabAdapter) viewPager.getAdapter();
                adapter.replaceFragmentAtPosition(new MatchingFragment(), 2);
                adapter.notifyDataSetChanged();
            }
        });

        //add Recycler view
        rvFeed = layout.findViewById(R.id.rvFeed);
        feedData = new ArrayList<>();
        feedData.add("Alpha");
        feedData.add("Beta");
        feedData.add("Gamma");
        feedData.add("Delta");
        feedData.add("Omega");
        feedData.add("Hexa");
        feedAdapter = new FeedAdapter(feedData);
        feedLLM = new LinearLayoutManager(getContext());
        feedLLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvFeed.setLayoutManager(feedLLM);
        rvFeed.setAdapter(feedAdapter);

        return layout;
    }

}
