package id.scode.exercise02Pojo02

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Dani on 11/2/2018.
 * Yogi Arif Widodo
 */

@Parcelize
data class PersonK(var name: String?, var age: String?, var email: String?, var city: String?) : Parcelable



