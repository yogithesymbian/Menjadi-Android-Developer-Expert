package id.scode.submission


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import id.scode.exercise04ReyclerView.*
import id.scode.scholarshipexpertscodeidev.R
import kotlinx.android.synthetic.main.activity_submission_home.*
import java.util.ArrayList

private val MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1

class SubmissionHome : AppCompatActivity() {
    val yogi = ListView()
    val aboutMe = DicodingProfile()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                menDua()
                Log.d("HOME", "Clicked Home")
                return@OnNavigationItemSelectedListener true
            }
//            Setelah dibaca jangan lupa diamalkan ya....
            R.id.navigation_dashboard -> {
//                message.setText(R.string.title_dashboard)
                feature(navigation)
                Log.d("HOME", "Clicked Buku Tersimpan")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
//                message.setText(R.string.title_notifications)
//                menTiga()
                val intent = Intent(this, DicodingProfile::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

//    private fun menTiga()
//    {
//
//    }

    private fun feature(view: View) {
        val snackbar = Snackbar.make(view, "[Feature Buku Terismpan] Ongoing", Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS)


                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }


        rv_category.setHasFixedSize(true)

//        yogi.list = ArrayList<Presiden>()
//        yogi.list.addAll(PresidenData.getListData())

        yogi.listDua = ArrayList<BookSubmission>()
        yogi.listDua.addAll(DataBookSubmission.getListData())

        menDua()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_CONTACTS -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }// other 'case' lines to check for other
        // permissions this app might request.
    }

    //    private fun menSatu() {
//        rv_category.layoutManager = LinearLayoutManager(this)
//        val adapterCardView = AdapterCardView(this)
//        adapterCardView.listPresident = yogi.list
//        rv_category.adapter = adapterCardView
//
//    }
    private fun menDua() {
        rv_category.layoutManager = LinearLayoutManager(this)
        val adapterSubmission = AdapterSubmission(this)
        adapterSubmission.listBookSubmission = yogi.listDua
        rv_category.adapter = adapterSubmission

        ItemClickSupport.addTo(rv_category).setmOnItemClickListener { recyclerView, position, v -> showSelectedBook(yogi.listDua[position]) }

    }
    fun showSelectedBook (bookSubmission: BookSubmission) {
        Toast.makeText(this, "Kamu Memilih " + bookSubmission.judulBuku, Toast.LENGTH_SHORT).show()


        val intent = Intent(this@SubmissionHome, FullscreenActivity::class.java)
        intent.putExtra(FullscreenActivity.EXTRA_BOOK, bookSubmission)
        intent.putExtra(FullscreenActivity.EXTRA_IMG, bookSubmission.spoiler)
        startActivity(intent)

    }
}
