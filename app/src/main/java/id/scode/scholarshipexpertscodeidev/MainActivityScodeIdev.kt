package id.scode.scholarshipexpertscodeidev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.scode.exercise01Newbie.ExerciseLatihanSatuK
import id.scode.exercise02MyIntent.IntentScodExerciseK
import id.scode.exercise03ViewAndViewgroup.ViewGroupActivity
import id.scode.exercise04ReyclerView.ListView
import id.scode.exercise05Fragment.MyFlexibleFragmentScode
import id.scode.submission.SubmissionHome
import kotlinx.android.synthetic.main.activity_main_scode_idev.*


class MainActivityScodeIdev : AppCompatActivity()
{

    private val tag = "MainActivityScodeIdev"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_scode_idev)

        /**
         * Belajar Android Pemula
         * ================================================================================
         */

        btnActOpertorScode.setOnClickListener{
            Log.d("MainActivity","Button Operator Clicked")
            val exerciseOne = Intent(this@MainActivityScodeIdev, ExerciseLatihanSatuK::class.java)
            startActivity(exerciseOne)
        }

        btnMyIntentScode.setOnClickListener{
            Log.d("MainActivity","Button My Intent Clicked")
            val exerciseTwo = Intent(this@MainActivityScodeIdev , IntentScodExerciseK::class.java)
            startActivity(exerciseTwo)
        }

        btnViewAndViewgroups.setOnClickListener{
            Log.d("MainActivity","Button View and ViewGroups Clicked")
            val exerciseThree = Intent(this@MainActivityScodeIdev, ViewGroupActivity::class.java)
            startActivity(exerciseThree)
        }
        btnRecycleView.setOnClickListener{
            Log.d("MainActivity","Button Recycle View Clicked")
            val rv = Intent(this@MainActivityScodeIdev, ListView::class.java)
            startActivity(rv)
        }


        btnSubmission.setOnClickListener{
            startActivity(Intent(this@MainActivityScodeIdev, SubmissionHome::class.java))
        }

        /**
         * Belajar Menjadi Android Developer Expert
         * ========================================================================
         */

        btnFragment.setOnClickListener{
            val fm = Intent(this@MainActivityScodeIdev, MyFlexibleFragmentScode::class.java)
            startActivity(fm)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }
}
