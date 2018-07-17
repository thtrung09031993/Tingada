package hci201.tingada;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindLoverFragment extends Fragment {
    CheckBox chkMusic, chkMovie, chkSport, chkReading;
    LinearLayout musicGenres, movieGenres, sportGenres, readingGenres;

    public FindLoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_find_lover, container, false);
        Button btnFind = (Button) layout.findViewById(R.id.btnFind);
        chkMusic = layout.findViewById(R.id.chkMusic);
        chkMovie = layout.findViewById(R.id.chkMovie);
        chkSport = layout.findViewById(R.id.chkSport);
        chkReading = layout.findViewById(R.id.chkReading);
        musicGenres = layout.findViewById(R.id.musicGenres);
        movieGenres = layout.findViewById(R.id.movieGenres);
        sportGenres = layout.findViewById(R.id.sportGenres);
        readingGenres = layout.findViewById(R.id.readingGenres);
        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    musicGenres.setVisibility(View.VISIBLE);
                }
                else {
                    musicGenres.setVisibility(View.GONE);
                }
            }
        });

        chkMovie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    movieGenres.setVisibility(View.VISIBLE);
                }
                else {
                    movieGenres.setVisibility(View.GONE);
                }
            }
        });

        chkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sportGenres.setVisibility(View.VISIBLE);
                }
                else {
                    sportGenres.setVisibility(View.GONE);
                }
            }
        });

        chkReading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    readingGenres.setVisibility(View.VISIBLE);
                }
                else {
                    readingGenres.setVisibility(View.GONE);
                }
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.container);
                TabAdapter adapter = (TabAdapter) viewPager.getAdapter();
                adapter.replaceFragmentAtPosition(new SearchProcessFragment(), 1);
                adapter.notifyDataSetChanged();
            }
        });
        return layout;
    }

}
