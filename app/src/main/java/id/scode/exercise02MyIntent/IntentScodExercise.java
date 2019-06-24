package id.scode.exercise02MyIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
//import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.exercise02Pojo02.Person;
import id.scode.scholarshipexpertscodeidev.R;

public class IntentScodExercise extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "INTENT Activity";

    private int REQUEST_CODE = 100;

    private TextView textResultIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_scod_exercise);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithData = findViewById(R.id.btn_move_w_data);
        btnMoveWithData.setOnClickListener(this);

        //P O J O -- GETTER AND SETTER == PARCELABLE
        Button btnMoveWithPojoObject = findViewById(R.id.btn_move_w_object);
        btnMoveWithPojoObject.setOnClickListener(this);

        Button btnDialIntentExplicit = findViewById(R.id.btn_move_dial_num);
        btnDialIntentExplicit.setOnClickListener(this);

        //============I N T E N T ==== R E S U L T

        Button moveWithResult = findViewById(R.id.btn_move_activity_result);
        moveWithResult.setOnClickListener(this);

        textResultIntent = findViewById(R.id.text_result_intent);

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == IntentResultActivity.RESULT_CODE )
            {
                int selectedValue = data.getIntExtra(IntentResultActivity.EXTRA_SELECTED_VALUE, 0);
                textResultIntent.setText("Result : " +selectedValue);
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_move_activity:
                Log.d(TAG,"Button Activity Clicked");
                //                                              this ini / asal     / tujuan activity
                Intent moveIntent = new Intent(IntentScodExercise.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_w_data:
                Log.d(TAG, "Button Activity Move With Data Clicked");
                Intent moveIntentWithData = new Intent(IntentScodExercise.this, MoveWithData.class);

                moveIntentWithData.putExtra(MoveWithData.EXTRA_NAME,"Dicoding Academy Yogi");
                moveIntentWithData.putExtra(MoveWithData.EXTRA_AGE,19);
                moveIntentWithData.putExtra(MoveWithData.EXTRA_LANGUAGE,"Kotlin, Java, NodeJs, Javascript, C++, VB.NET, and etc");

                startActivity(moveIntentWithData);
                break;
            case R.id.btn_move_dial_num:
                Log.d(TAG,"Button Activity Move Explicit Intent");

                String phoneNum = "081545778612";
                //                                                           tel: is a schema xml
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNum));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_w_object:

                Log.d(TAG,"Button Activity Move With Pojo");

                Person myPersonPojoCalling = new Person();
                myPersonPojoCalling.setName("DicodingAcademy Yogi");
                myPersonPojoCalling.setEmail("yogirenbox33@gmail.com");
                myPersonPojoCalling.setAge(19);
                myPersonPojoCalling.setCity("ID East Borneo");

                Intent moveWithObjetPojo = new Intent(IntentScodExercise.this, MoveWithPojo.class);
                moveWithObjetPojo.putExtra(MoveWithPojo.EXTRA_PERSON, myPersonPojoCalling);
                startActivity(moveWithObjetPojo);
                break;
            case R.id.btn_move_activity_result:
                Log.d(TAG,"Button Activity Move With Result");
                Intent moveWithResultData = new Intent(IntentScodExercise.this, IntentResultActivity.class);
                startActivityForResult(moveWithResultData, REQUEST_CODE);
                break;

        }
    }
}
