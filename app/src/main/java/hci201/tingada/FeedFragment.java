package hci201.tingada;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {


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
        return layout;
    }

}
