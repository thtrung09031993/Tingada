package hci201.tingada;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoundResultFragment extends Fragment {

    ImageView btnShowInfo, downBtn, localImg, delBtn, loveBtn, likeBtn;
    ViewPager mainImg;
    TextView txtName, txtKm, txtSchool, txtSuit;
    ViewPager viewPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Integer> imagesArray = new ArrayList<Integer>();
    public FoundResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_found_result, container, false);
        final LinearLayout layout1 = (LinearLayout) inflater.inflate(R.layout.activity_lover_image_slider, container, false);
        viewPager = (ViewPager) layout.findViewById(R.id.sliderLoverImg);
        LoverImageSliderActivity loverActivity = new LoverImageSliderActivity(getContext());
        viewPager.setAdapter(loverActivity);
        delBtn = (ImageView) layout.findViewById(R.id.loverDelBtn);
        loveBtn = (ImageView) layout.findViewById(R.id.loverLoveBtn);
        likeBtn = (ImageView) layout.findViewById(R.id.loverLikeBtn);
        NUM_PAGES = loverActivity.getCount();
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (currentPage == (NUM_PAGES - 1)) {
                   currentPage = -1;
               }
               viewPager.setCurrentItem(++currentPage, true);
                Toast.makeText(getContext(), "This person will be removed in my matching list", Toast.LENGTH_SHORT).show();
            }
        });
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(layout.getContext(), NotificationActivity.class));
            }
        });

        loveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentPage == 0) {
                    currentPage = NUM_PAGES;
                }
                viewPager.setCurrentItem(--currentPage, true);
                Toast.makeText(getContext(), "You have added her. Waiting for confirm", Toast.LENGTH_SHORT).show();

            }
        });

        btnShowInfo = (ImageView) layout.findViewById(R.id.infoBtn);
        downBtn = (ImageView) layout.findViewById(R.id.downBtn);
        txtName = (TextView) layout.findViewById(R.id.txtName);
        txtSchool = (TextView) layout.findViewById(R.id.txtSchool);
        txtSuit = (TextView) layout.findViewById(R.id.txtSuitable);
        mainImg = (ViewPager) layout.findViewById(R.id.sliderLoverImg);
        localImg = (ImageView) layout.findViewById(R.id.localImg);
        txtKm = (TextView) layout.findViewById(R.id.txtKm);
        btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mainImg.requestLayout();
               mainImg.getLayoutParams().height = 1100;
               txtName.setTextColor(Color.parseColor("BLACK"));
               txtSchool.setVisibility(View.INVISIBLE);
               txtSuit.setVisibility(View.INVISIBLE);
               localImg.setVisibility(View.VISIBLE);
               txtKm.setVisibility(View.VISIBLE);
               downBtn.setVisibility(View.VISIBLE);
               btnShowInfo.setVisibility(View.INVISIBLE);

            }
        });
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShowInfo.setVisibility(View.VISIBLE);
                downBtn.setVisibility(View.INVISIBLE);
                localImg.setVisibility(View.INVISIBLE);
                txtKm.setVisibility(View.INVISIBLE);
                mainImg.requestLayout();
                mainImg.getLayoutParams().height = 1900;
                txtName.setTextColor(Color.parseColor("WHITE"));
                txtSchool.setVisibility(View.VISIBLE);
                txtSuit.setVisibility(View.VISIBLE);
            }
        });


        return layout;
    }


}
