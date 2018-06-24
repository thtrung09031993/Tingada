package hci201.tingada;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class SearchProcessFragment extends Fragment {

    public Handler handler = new Handler();

    public SearchProcessFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_search_process, container, false);
        ImageView imgSearch = layout.findViewById(R.id.imgSearch);
        Glide.with(this).load(R.drawable.heart_search).into(imgSearch);
        final  Runnable switchView = new Runnable() {
            @Override
            public void run() {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
                TabAdapter adapter = (TabAdapter) viewPager.getAdapter();
                adapter.replaceFragmentAtPosition(new FindLoverFragment(), 1);
                adapter.notifyDataSetChanged();
            }
        };
        handler.postDelayed(switchView, 3000);
        return layout;
    }


}
