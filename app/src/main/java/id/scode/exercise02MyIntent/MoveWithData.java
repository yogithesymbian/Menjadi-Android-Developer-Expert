package id.scode.exercise02MyIntent;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.scholarshipexpertscodeidev.R;

public class MoveWithData extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_AGE = "extra_age";
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_LANGUAGE = "extra_language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        TextView tvTextDataIntent = findViewById(R.id.transceive_data); //transceive data
        tvTextDataIntent.setOnClickListener(this);

        //==========================
        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,  0);
        String languageYogi = getIntent().getStringExtra(EXTRA_LANGUAGE);

        String textData = "\nNama : "+nama
                + "\nAge : "+age
                + "\nLanguage : "+languageYogi;

        tvTextDataIntent.setText(textData);

    }

    @Override
    public void onClick(View v) {

    }
}
