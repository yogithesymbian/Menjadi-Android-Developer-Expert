package id.scode.scholarshipexpertscodeidev

import android.content.Intent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.scode.exercise01Newbie.ExerciseLatihanSatu
import id.scode.exercise02MyIntent.IntentScodExercise
import id.scode.exercise03ViewAndViewgroup.ViewGroupActivity
import id.scode.exercise04ReyclerView.ListView
import id.scode.exercise05Fragment.MyFlexibleFragmentScode
import id.scode.submission.SubmissionHome
import kotlinx.android.synthetic.main.activity_main_scode_idev.*


class MainActivityScodeIdev : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_scode_idev)

        btnActOpertorScode.setOnClickListener{
            Log.d("MainActivity","Button Operator Clicked")
            val exerciseOne = Intent(this, ExerciseLatihanSatu::class.java)
            startActivity(exerciseOne)
        }

        btnMyIntentScode.setOnClickListener{
            Log.d("MainActivity","Button My Intent Clicked")
            val exerciseTwo = Intent(this, IntentScodExercise::class.java)
            startActivity(exerciseTwo)
        }

        btnViewAndViewgroups.setOnClickListener{
            Log.d("MainActivity","Button View and ViewGroups Clicked")
            val exerciseThree = Intent(this, ViewGroupActivity::class.java)
            startActivity(exerciseThree)
        }
        btnRecycleView.setOnClickListener{
            Log.d("MainActivity","Button Recycle View Clicked")
            val rv = Intent(this, ListView::class.java)
            startActivity(rv)
        }
        btnFragment.setOnClickListener{
            val fm = Intent(this, MyFlexibleFragmentScode::class.java)
            startActivity(fm)
        }

        btnSubmission.setOnClickListener{
            startActivity(Intent(this@MainActivityScodeIdev, SubmissionHome::class.java))
        }

    }
}
