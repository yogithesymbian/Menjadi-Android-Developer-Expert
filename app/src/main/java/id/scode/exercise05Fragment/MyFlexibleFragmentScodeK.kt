package id.scode.exercise05Fragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.scode.scholarshipexpertscodeidev.R

class MyFlexibleFragmentScodeK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_flexible_fragment_scode_k)

        // instance fragmentManager
        val mFragmentManager = supportFragmentManager
        // fragment transaction to operate add(), replace(), commit() , etc
        val mFragmentTransaction = mFragmentManager.beginTransaction()

        Log.d("INSTANCE", "Method di instance [ScodeFragment]")
        // create object fragment
        val mHomeFragment = HomeFragment()

        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
        if (fragment !is HomeFragment) {
            // add()
            mFragmentTransaction.add(R.id.allfragment_container, mHomeFragment, HomeFragment::class.java.simpleName)

            Log.d("MyFlexibleFragment", "Fragment Name" + HomeFragment::class.java.simpleName)

            //commit()
            mFragmentTransaction.commit()
        }
    }
}
