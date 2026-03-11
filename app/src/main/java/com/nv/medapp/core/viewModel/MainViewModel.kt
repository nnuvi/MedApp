package com.nv.medapp.core.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.nv.medapp.core.model.CategoryModel
import android.util.Log
import com.nv.medapp.core.model.DoctorModel


class MainViewModel: ViewModel() {
    private val db = FirebaseDatabase.getInstance()
    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories: LiveData<List<CategoryModel>> = _categories

    private var categoryLoaded = false

    fun loadCategories(force: Boolean = false) {
        if (categoryLoaded && !force) return

        categoryLoaded = true

        val ref = db.getReference("Category")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("MainViewModel", "DataSnapshot received: ${snapshot.childrenCount}")

                val categories = mutableListOf<CategoryModel>()

                for (child in snapshot.children) {
                    Log.d("MainViewModel", "Child: ${child.value}")

//                    child.getValue(CategoryModel::class.java)?.let {
//                        Log.d("MainViewModel", "Parsed Category: $it")
//                        categories.add(it)
//                    }
                    val id = child.child("Id").getValue(Int::class.java) ?: 0
                    val name = child.child("Name").getValue(String::class.java) ?: ""
                    val icon = child.child("Picture").getValue(String::class.java) ?: ""

                    Log.d("MainViewModel", "Mapped: $id, $name, $icon")

                    val category = CategoryModel(
                        id = id,
                        name = name,
                        icon = icon
                    )
                    categories.add(category)
                }
                _categories.value = categories
            }


            override fun onCancelled(error: DatabaseError) {
                categoryLoaded = false
            }
        })
    }

    private val _doctors = MutableLiveData<List<DoctorModel>>()
    val doctors: LiveData<List<DoctorModel>> = _doctors

    private val _selectedDoctor = MutableLiveData<DoctorModel>()
    val selectedDoctor: LiveData<DoctorModel> = _selectedDoctor

    fun selectDoctor(doctor: DoctorModel) {
        _selectedDoctor.value = doctor
    }

    private var doctorLoaded = false

    fun loadDoctors(force: Boolean = false) {
        if (doctorLoaded && !force) return

        doctorLoaded = true

        val ref = db.getReference("Doctors")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("MainViewModelDoctor", "DataSnapshot received: ${snapshot.childrenCount}")

                val doctors = mutableListOf<DoctorModel>()

                for (child in snapshot.children) {
                    Log.d("MainViewModelDoctor", "Child: ${child.value}")

//                    child.getValue(CategoryModel::class.java)?.let {
//                        Log.d("MainViewModel", "Parsed Category: $it")
//                        categories.add(it)
//                    }
                    val id = child.child("Id").getValue(Int::class.java) ?: 0
                    val name = child.child("Name").getValue(String::class.java) ?: ""
                    val address = child.child("Address").getValue(String::class.java) ?: ""
                    val biography = child.child("Biography").getValue(String::class.java) ?: ""
                    val experience = child.child("Expriense").getValue(Int::class.java) ?: 0
                    val location = child.child("Location").getValue(String::class.java) ?: ""
                    val mobile = child.child("Mobile").getValue(String::class.java) ?: ""
                    val patients = child.child("Patiens").getValue(String::class.java) ?: ""
                    val picture = child.child("Picture").getValue(String::class.java) ?: ""
                    val rating = child.child("Rating").getValue(Double::class.java) ?: 0.0
                    val site = child.child("Site").getValue(String::class.java) ?: ""
                    val special = child.child("Special").getValue(String::class.java) ?: ""

                    Log.d("MainViewModel", "Mapped: $id, $name, $picture")

                    val doctor = DoctorModel(
                        address = address,
                        biography = biography,
                        experience = experience,
                        id = id,
                        location = location,
                        mobile = mobile,
                        name = name,
                        patients = patients,
                        picture = picture,
                        rating = rating,
                        site = site,
                        special = special
                    )
                    doctors.add(doctor)
                }
                _doctors.value = doctors
            }
            override fun onCancelled(error: DatabaseError) {
                doctorLoaded = false
            }
        })
    }
}