package id.scode.exercise02MyIntent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.scode.exercise02Pojo02.PersonK
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_intent_scod_exercise.*

class IntentScodExerciseK : AppCompatActivity() {


    private val TAG = "INTENT Activity"

    companion object {

        private val REQUEST_CODE = 100

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_scod_exercise)

        /**
         * explicit
         * =============================================
         * intent move
         */
        btn_move_activity.setOnClickListener {
            Log.d(TAG, "Button Activity Clicked")
            //                                              this ini / asal     / tujuan activity
            val moveIntent = Intent(this@IntentScodExerciseK, MoveActivityK::class.java)
            startActivity(moveIntent)
        }

        /**
         * explicit
         * ============================================
         * intent move with data
         */

        btn_move_w_data.setOnClickListener {
            Log.d(TAG, "Button Activity Move With Data Clicked")
            val moveIntentWithData = Intent(this@IntentScodExerciseK, MoveWithDataK::class.java)

            moveIntentWithData.putExtra(MoveWithDataK.EXTRA_NAME, "Dicoding Academy Yogi")
            moveIntentWithData.putExtra(MoveWithDataK.EXTRA_AGE, 19)
            moveIntentWithData.putExtra(
                MoveWithDataK.EXTRA_LANGUAGE,
                "Kotlin, Java, NodeJs, Javascript, C++, VB.NET, and etc"
            )

            startActivity(moveIntentWithData)
        }

        /**
         * explicit
         * ============================================
         * intent move with object data
         */

        btn_move_w_object.setOnClickListener {
            Log.d(TAG, "Button Activity Move With Pojo")

            val myPersonPojoCalling = PersonK("DicodingAcademy Yogi", "19", "yogirenbox33@gmail.com", "ID East Borneo")

            val moveWithObjetPojo = Intent(this@IntentScodExerciseK, MoveWithPojoK::class.java)
            moveWithObjetPojo.putExtra(MoveWithPojoK.EXTRA_PERSON, myPersonPojoCalling)
            startActivity(moveWithObjetPojo)

        }

        /**
         * implicit
         * ============================================
         * intent move Dial Number
         */

        btn_move_dial_num.setOnClickListener {
            Log.d(TAG, "Button Activity Move Explicit Intent")

            val phoneNum = "081545778612"
            //                                                           tel: is a schema xml
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNum"))
            startActivity(dialPhoneIntent)
        }

        /**
         * Explicit
         * ============================================
         * intent move for result
         */
        btn_move_activity_result.setOnClickListener {
            Log.d(TAG, "Button Activity Move With Result")
            val moveWithResultData = Intent(this@IntentScodExerciseK, IntentResultActivityK::class.java)
            startActivityForResult(moveWithResultData, REQUEST_CODE)
        }
    }

    /**
     * Explicit
     * ============================================
     * intent move for result
     * R-E-S-U-L-T
     */
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == IntentResultActivity.RESULT_CODE) {
                val selectedValue = data!!.getIntExtra(IntentResultActivity.EXTRA_SELECTED_VALUE, 0)
                text_result_intent.text = "Hasil : $selectedValue"
            }
        }
    }

}
