package id.scode.exercise03ViewAndViewgroup;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.scholarshipexpertscodeidev.R;

public class ViewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);

        if (getSupportActionBar() !=null)
        {
            getSupportActionBar().setTitle("Google Pixel");
        }
    }
}
