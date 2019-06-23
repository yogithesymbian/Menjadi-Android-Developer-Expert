package id.scode.TugasYogi

import android.os.Bundle

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import id.scode.exercise05Fragment.ScodeFragment
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_past_perfect.*

class PastPerfect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past_perfect)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Hai Miss Oscar :D", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val scodeFragment = ScodeFragment()

        val fragment = fragmentManager.findFragmentByTag(ScodeFragment::class.java.simpleName)
        if (fragment !is ScodeFragment)
        {
            fragmentTransaction.add(R.id.frame_container, scodeFragment, ScodeFragment::class.java.simpleName)
            Log.d("MyFlexibleFragment", "Fragment Name" + ScodeFragment::class.java.simpleName)
            fragmentTransaction.commit()
        }

    }
}
