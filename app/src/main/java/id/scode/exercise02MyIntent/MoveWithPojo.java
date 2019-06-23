package id.scode.exercise02MyIntent;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.exercise02Pojo02.Person;
import id.scode.scholarshipexpertscodeidev.R;

public class MoveWithPojo extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_pojo);

        TextView tvTextPojo = findViewById(R.id.textPojoObjectMove);

        //calling class pojo Person to take parcelable
        Person myPersonPojo = getIntent().getParcelableExtra(EXTRA_PERSON);

        //sout text will be
        String text = "\nName     :" +myPersonPojo.getName()
                    + "\nEmail    :" +myPersonPojo.getEmail()
                    + "\nAge      :" +myPersonPojo.getAge()
                    + "\nLocation :"+myPersonPojo.getCity();

        //set it to textView
        tvTextPojo.setText(text);
    }
}
