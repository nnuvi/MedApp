package com.nv.medapp.core.model

import android.os.Parcelable
import com.google.firebase.database.PropertyName

data class DoctorModel(

    @get:PropertyName("Address")
    @set:PropertyName("Address")
    var address: String = "",

    @get:PropertyName("Biography")
    @set:PropertyName("Biography")
    var biography: String = "",

    @get:PropertyName("Expriense")
    @set:PropertyName("Expriense")
    var experience: Int = 0,

    @get:PropertyName("Id")
    @set:PropertyName("Id")
    var id: Int = 0,

    @get:PropertyName("Location")
    @set:PropertyName("Location")
    var location: String = "",

    @get:PropertyName("Mobile")
    @set:PropertyName("Mobile")
    var mobile: String = "",

    @get:PropertyName("Name")
    @set:PropertyName("Name")
    var name: String = "",

    @get:PropertyName("Patiens")
    @set:PropertyName("Patiens")
    var patients: String = "",

    @get:PropertyName("Picture")
    @set:PropertyName("Picture")
    var picture: String = "",

    @get:PropertyName("Rating")
    @set:PropertyName("Rating")
    var rating: Double = 0.0,

    @get:PropertyName("Site")
    @set:PropertyName("Site")
    var site: String = "",

    @get:PropertyName("Special")
    @set:PropertyName("Special")
    var special: String = ""

)