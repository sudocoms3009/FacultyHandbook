package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoursesMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_main);
        getSupportActionBar().hide();

        loadFragment(new AdmissionFragment());


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            public boolean onNavigationItemSelected(MenuItem item){

                Fragment fragment;


                switch (item.getItemId()){
                    case R.id.admission:
                        fragment = new AdmissionFragment();
                        loadFragment(fragment);

                        break;

                    case R.id.first_year:
                        fragment = new YOS1Fragment();
                        loadFragment(fragment);

                        break;

                    case R.id.second_year:
                        fragment = new YOS2Fragment();
                        loadFragment(fragment);

                        break;

                    case R.id.third_year:
                        fragment = new YOS3Fragment();
                        loadFragment(fragment);

                        break;



                }
                return true;

            }
        });
    }

    private void loadFragment(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
