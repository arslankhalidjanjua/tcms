package com.example.tcmsstaticdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AdminLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private AppCompatImageView menuIcon;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    FrameLayout holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        menuIcon = findViewById(R.id.acivIcon);
        drawerLayout = findViewById(R.id.drawerlayout);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.account_navigation_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);

        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case  R.id.nav_dash:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, DashboardFragment.newInstance());
                        fragmentTransaction.addToBackStack("dash");
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                        break;
                    case  R.id.nav_account:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.fragmentContainer, AccountFragment1.newInstance());
                        fragmentTransaction1.addToBackStack("account");
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction1.commit();
                        break;
                }
                return true;
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, DashboardFragment.newInstance());
        fragmentTransaction.addToBackStack("dash");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //
        int id = menuItem.getItemId();
        if (id == R.id.nav_refer) {
            // DO your stuff
            //   Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.drawerlayout,
                    new NavFragment()).commit();
        }
//can you hold already net is disturbing me
        return false;
    }
}
//good sir ji done bas aap rest keran
//mei isme view pagfer kerta hn sirok