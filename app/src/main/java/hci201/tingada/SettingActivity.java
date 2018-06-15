package hci201.tingada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import hci201.tingada.R;

public class SettingActivity extends AppCompatActivity {

    Switch  menSwt = (Switch) findViewById(R.id.menSwt);
    Switch  womenSwt = (Switch) findViewById(R.id.womenSwt);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        menSwt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    womenSwt.setChecked(false);
                } else {
                    womenSwt.setChecked(true);
                }
            }
        });
        womenSwt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    menSwt.setChecked(false);
                } else {
                    menSwt.setChecked(true);
                }
            }
        });
    }

    public void clickToBackSettingProfilePage(View view) {
    }


}
