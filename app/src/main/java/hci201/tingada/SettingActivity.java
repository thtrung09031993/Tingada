package hci201.tingada;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import hci201.tingada.R;

public class SettingActivity extends AppCompatActivity {

    Switch  menSwt;
    Switch  womenSwt;
    SeekBar distanceSeek;
    TextView txtDistance;
    TextView unit;
    Button btnKM;
    Button btnMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        switchGender();
        setDistance();
    }

    public void switchGender() {
        menSwt = (Switch) findViewById(R.id.menSwt);
        womenSwt = (Switch) findViewById(R.id.womenSwt);
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
    public void setDistance() {
        distanceSeek = (SeekBar) findViewById(R.id.distanceSeek);
        distanceSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtDistance = (TextView) findViewById(R.id.textDistance);
                txtDistance.setText(progressChangedValue + "");
            }
        });
    }

    public void clickToSetKM(View view) {
        txtDistance = (TextView) findViewById(R.id.textDistance);
        unit = (TextView) findViewById(R.id.unit);
        btnKM = (Button) findViewById(R.id.btnKM);
        btnMI = (Button) findViewById(R.id.btnMI);
        btnKM.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnMI.setBackgroundColor(getResources().getColor(R.color.colorText));
        txtDistance.setText(Double.parseDouble(txtDistance.getText().toString()) / 1000 + "");
        unit.setText("Km.");
    }

    public void clickToSetMI(View view) {
        txtDistance = (TextView) findViewById(R.id.textDistance);
        unit = (TextView) findViewById(R.id.unit);
        btnKM = (Button) findViewById(R.id.btnKM);
        btnMI = (Button) findViewById(R.id.btnMI);
        btnMI.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btnKM.setBackgroundColor(getResources().getColor(R.color.colorText));
        txtDistance.setText(Double.parseDouble(txtDistance.getText().toString()) * 1000 + "");
        unit.setText("Mi.");
    }
}
