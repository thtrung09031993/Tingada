package hci201.tingada;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingProfileFragment extends Fragment {
    Button settingBtn;

    public SettingProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting_profile, container, false);
//        settingBtn = (Button) view.findViewById(R.id.settingBtn);
//        settingBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), SettingActivity.class));
//            }
//        });
//        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.frameSettingProfile);
//        layout.addView(view);
        return view;
    }

}
