package id.scode.exercise02MyIntent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_intent_result.*

class IntentResultActivityK : AppCompatActivity() {

    var EXTRA_SELECTED_VALUE = "extra_selected_value"
    var RESULT_CODE = 110

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_result)

        btn_choose_number.setOnClickListener{

            if (exercise_intent_radioGroup.checkedRadioButtonId != 0) {
                var value = 0
                when (exercise_intent_radioGroup.checkedRadioButtonId) {
                    R.id.btn_radio_satu -> value = 50
                    R.id.btn_radio_dua -> value = 100
                    R.id.btn_radio_tiga -> value = 150
                    R.id.btn_radio_empat -> value = 200
                }
                // getintent
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }

        }

    }
}
