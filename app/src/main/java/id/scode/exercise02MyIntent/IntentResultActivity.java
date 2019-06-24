package id.scode.exercise02MyIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.scholarshipexpertscodeidev.R;

public class IntentResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    private RadioGroup radioNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);

        Button chooseResult = findViewById(R.id.btn_choose_number);
        chooseResult.setOnClickListener(this);

        radioNum = findViewById(R.id.exercise_intent_radioGroup);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.btn_choose_number)
        {
            if (radioNum.getCheckedRadioButtonId()!= 0)
            {
                int value = 0;
                switch (radioNum.getCheckedRadioButtonId())
                {
                    case R.id.btn_radio_satu:
                        value = 50;
                        break;
                    case R.id.btn_radio_dua:
                        value = 100;
                        break;
                    case R.id.btn_radio_tiga:
                        value = 150;
                        break;
                    case R.id.btn_radio_empat:
                        value = 200;
                        break;
                }
                // getintent
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
