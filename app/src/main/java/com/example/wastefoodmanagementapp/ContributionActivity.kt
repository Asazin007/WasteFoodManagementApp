package com.example.wastefoodmanagementapp

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.wastefoodmanagementapp.databinding.ActivityContributionBinding

class ContributionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContributionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContributionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var myData = intent.getStringExtra("arrList_fname").toString()

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title =myData
    }
}