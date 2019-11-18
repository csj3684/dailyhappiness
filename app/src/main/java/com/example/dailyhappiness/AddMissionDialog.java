package com.example.dailyhappiness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMissionDialog extends Dialog{

    private Button btnOk;
    private Button btnCancel;
    private EditText missionName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 밖의 화면은 흐리게 만들어줌
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        //사이즈조절
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.activity_add_mission_dialog);

        btnOk=findViewById(R.id.btnOk);
        btnCancel=findViewById(R.id.btnCancel);

        //클릭 리스너 셋팅
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                missionName = findViewById(R.id.edtMission);
                MissionCandidateActivity mca = new MissionCandidateActivity();
                Log.i("호호",missionName.getText().toString());
                mca.setMission(missionName.getText().toString());
                //mca.insertMissionCandidate(Account.getUserIndex(), missionName.getText().toString());
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    //생성자 생성
    public AddMissionDialog(@NonNull Context context) {
        super(context);
    }

}
