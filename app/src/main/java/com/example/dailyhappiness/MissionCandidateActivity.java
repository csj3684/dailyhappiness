package com.example.dailyhappiness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.dailyhappiness.databinding.ActivityMissionCandidateBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MissionCandidateActivity extends AppCompatActivity {
    public static Context context;

    ActivityMissionCandidateBinding binding;

    private RetroClient retroClient;
    private ArrayList<MissionCandidate> missionCandidateArray;

    MissionCandidateListAdapter missionCandidateListAdapter;

    private AddMissionDialog addMissionDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mission_candidate);
        binding.setActivity(this);
        retroClient = RetroClient.getInstance(this).createBaseApi();
        missionCandidateArray = new ArrayList<MissionCandidate>();
        getMissionCandidate(Account.userIndex,0,1);

        addMissionDialog = new AddMissionDialog(this);

        // 커스텀 다이얼로그 호출
        binding.iBtnAddMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //파라미터에 리스너 등록
                addMissionDialog.show();


            }




//            private View.OnClickListener okListener = new View.OnClickListener() {
//                public void onClick(View v) {
//                    //EditText edtMission = findViewById(R.id.edtMission);
//                   // String mission = edtMission.getText().toString();
//
//                    Toast.makeText(getApplicationContext(),mission+"ghgh",Toast.LENGTH_SHORT).show();
//                    addMissionDialog.dismiss();
//                }
//            };
//
//            private View.OnClickListener cancelListener = new View.OnClickListener() {
//                public void onClick(View v) {
//                    Toast.makeText(MissionCandidateActivity.this, "취소하셨습니다", Toast.LENGTH_SHORT).show();
//                    addMissionDialog.dismiss();
//                }
//            };



        });

        binding.iBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    /*
    * userIndex : 사용자 번호
    * count : 여태까지 몇개의 미션 후보를 가져왔는지. 리뷰 리스트랑 똑같음.
    * mode : 1이면 최신순, 0이면 좋아요가 많은 순.
    * */
    public void getMissionCandidate(String userIndex,int count, int mode){
        retroClient.getMissionCandidate(userIndex,count,mode,new RetroCallback<JsonArray>(){

            @Override
            public void onError(Throwable t) {
                Log.i("에드리뷰리스트","확인3");

            }

            @Override
            public void onSuccess(int code, JsonArray receivedData) {
                missionCandidateArray.clear();
                for(int i =0; i<receivedData.size(); i++){
                    JsonObject missionCandidate = (JsonObject) receivedData.get(i);
                    String user = missionCandidate.get("user").getAsString();//유저 아이디
                    String missionName = missionCandidate.get("missionName").getAsString(); //: 미션 내용
                    int index = missionCandidate.get("missionCandidateIndex").getAsInt(); //: 미션 후보 인덱스
                    int likes = missionCandidate.get("totalLikes").getAsInt(); //: 좋아요 수
                    int dislikes = missionCandidate.get("totalDislikes").getAsInt();  //: 싫어요 수
                    int duplicateCount = missionCandidate.get("totalDuplicateCount").getAsInt(); //: 중복체크 수
                    int likeChecked = missionCandidate.get("userLikes").getAsInt();  //: 유저가 좋아요 눌렀는지
                    int dislikeChecked =missionCandidate.get("userDislikes").getAsInt(); //: 유저가 싫어요 눌렀는지
                    int duplicateChecked =missionCandidate.get("userDuplicateCount").getAsInt(); //: 유저가 중복 눌렀는지
                    missionCandidateArray.add(new MissionCandidate(user,missionName,index,likes,dislikes,duplicateCount,likeChecked,dislikeChecked,duplicateChecked));


                }
                
                missionCandidateListAdapter = new MissionCandidateListAdapter(missionCandidateArray,MissionCandidateActivity.this);
                Log.d("dd", missionCandidateArray.size()+"개");


                Log.i("에드리뷰리스트","확인");
                binding.lvView.setAdapter(missionCandidateListAdapter);
            }

            @Override
            public void onFailure(int code) {
                Log.i("에드리뷰리스트","확인2");
            }
        });
    }


}

