package id.scode.exercise02MyIntent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithDataK : AppCompatActivity() {


    companion object {
        var EXTRA_AGE = "extra_age"
        var EXTRA_NAME = "extra_name"
        var EXTRA_LANGUAGE = "extra_language"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        /**
         * GET DATA FROM FIRST IN
         */
        val nama = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val languageYogi = intent.getStringExtra(EXTRA_LANGUAGE)

        /**
         * SET DATA
         */

        val textData = ("\nNama : " + nama
                + "\nAge : " + age
                + "\nLanguage : " + languageYogi)

        text_transceive_data.text = textData
    }
}
