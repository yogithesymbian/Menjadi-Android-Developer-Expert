package id.scode.exercise01Newbie

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_exercise_latihan_satu.*


class ExerciseLatihanSatuK : AppCompatActivity() {


    private val STATE_RESULT = "state_hasilnya"


    /**
     * BundleSave
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, text_hasil.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_latihan_satu)

        if (savedInstanceState != null) {
            val resultInstance = savedInstanceState.getString(STATE_RESULT)
            text_hasil.text = resultInstance
        }


        button_hasil_exercise.setOnClickListener {

            val lengthScode = input_edit_length_value.text.toString().trim { it <= ' ' }
            val widthScode = input_edit_width_value.text.toString().trim { it <= ' ' }
            val heighScode = input_edit_height_value.text.toString().trim { it <= ' ' }


            var adEmptyField = false

            if (TextUtils.isEmpty(lengthScode)) {
                adEmptyField = true
                input_edit_length_value.error = "Silahkan di isi cuk, gak oleh kosong"
            } else if (!isDouble(lengthScode)) {
                input_edit_length_value.error = "Field ini harus berupa nomor valid"
            }//function (string var)
            //======================
            if (TextUtils.isEmpty(widthScode)) {
                adEmptyField = true
                input_edit_width_value.error = "Silahkan di isi cuk, gak bleh kosong"
            } else if (!isDouble(widthScode)) {
                input_edit_width_value.error = "Field ini harus berupa nomor valid"
            }
            //========================
            if (TextUtils.isEmpty(heighScode)) {
                adEmptyField = true
                input_edit_height_value.error = "Silahkan di isi cuk, gak boleh kosong"
            } else if (!isDouble(heighScode)) {
                input_edit_height_value.error = "Field ini harus berupa nomor valid"
            }
            if (!adEmptyField) {
                val lS = java.lang.Double.parseDouble(lengthScode)
                val wS = java.lang.Double.parseDouble(widthScode)
                val hS = java.lang.Double.parseDouble(heighScode)

                val oprScode = lS * wS * hS

                text_hasil.text = oprScode.toString()
            }
        }


    }

    private fun isDouble(str: String): Boolean {
        return try {
            java.lang.Double.parseDouble(str)
            true
        } catch (e: NumberFormatException) {
            false
        }

    }
}
