package id.scode.exercise05Fragment;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import id.scode.scholarshipexpertscodeidev.R;

public class MyFlexibleFragmentScode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flexible_fragment_scode);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Log.d("INSTANCE", "Method di instance [ScodeFragment]");
        ScodeFragment scodeFragment = new ScodeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(ScodeFragment.class.getSimpleName());
        if (!(fragment instanceof ScodeFragment))
        {
            fragmentTransaction.add(R.id.frame_container, scodeFragment, ScodeFragment.class.getSimpleName());

            Log.d("MyFlexibleFragment","Fragment Name" +ScodeFragment.class.getSimpleName());

            fragmentTransaction.commit();
        }

    }
}
