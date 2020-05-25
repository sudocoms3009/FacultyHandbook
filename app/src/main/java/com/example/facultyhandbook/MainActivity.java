package com.example.facultyhandbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Handler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    ImageView getSearch;
    EditText edtSearch;
    ImageView dropdown;
    SharedPreferences mPreferences;
    CardView science, commerce, engineering, health, humanities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getSearch = findViewById(R.id.get_search);
        edtSearch = findViewById(R.id.edtSearch);
        dropdown = findViewById(R.id.dropdown);

        science = findViewById(R.id.science);
        commerce = findViewById(R.id.commerce);
        engineering = findViewById(R.id.engineering);
        health = findViewById(R.id.health);
        humanities = findViewById(R.id.humanity);

        getSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearch.setVisibility(View.VISIBLE);
            }
        });

        edtSearch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                edtSearch.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScienceActivity.class);
                startActivity(intent);
            }
        });

        commerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommerceActivity.class);
                startActivity(intent);
            }
        });
        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EngineeringActivity.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthActivity.class);
                startActivity(intent);
            }
        });

        humanities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HumanitiesActivity.class);
                startActivity(intent);
            }
        });


        dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), dropdown);
                dropDownMenu.getMenuInflater().inflate(R.menu.dropdown_menu, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){

                            case R.id.settings:

                                return true;
                            case R.id.logout:
                        /*        mPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                                SharedPreferences.Editor editor=mPreferences.edit();
                                editor.remove("Email");
                                editor.remove("PassWord");
                                editor.commit();
                                Message myMessage=new Message();
                                myMessage.obj="NOTSUCCESS";
                                //handler.sendMessage(myMessage);
                                finish();*/

                                return true;

                            default:
                                //return super.onMenuItemSelected(menuItem);
                        }
                        // Toast.makeText(getApplicationContext(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                dropDownMenu.show();
            }
        });

    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}
