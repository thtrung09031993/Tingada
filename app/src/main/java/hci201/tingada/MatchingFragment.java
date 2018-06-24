package hci201.tingada;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


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
        final LinearLayout layout = (LinearLayout)  inflater.inflate(R.layout.fragment_matching, container, false);
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
        return layout;
    }

}
