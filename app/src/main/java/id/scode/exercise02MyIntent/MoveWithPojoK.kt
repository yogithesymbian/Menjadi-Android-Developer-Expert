package id.scode.exercise02MyIntent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.scode.exercise02Pojo02.PersonK
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_move_with_pojo.*

class MoveWithPojoK : AppCompatActivity() {

    companion object {
        var EXTRA_PERSON = "extra_person"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_pojo)

        //calling class pojo Person to take parcelable
        val myPersonPojo = intent.getParcelableExtra<PersonK>(EXTRA_PERSON)

        //sout text will be
        val text = ("\nName     :" + myPersonPojo.name
                + "\nEmail    :" + myPersonPojo.email
                + "\nAge      :" + myPersonPojo.age
                + "\nLocation :" + myPersonPojo.city)

        text_data_move_w_pojo.text = text
    }
}
