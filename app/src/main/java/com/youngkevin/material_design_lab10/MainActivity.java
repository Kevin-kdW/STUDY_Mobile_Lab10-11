package com.youngkevin.material_design_lab10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    public void onFabClick(View view){
        CharSequence text = "Item completed";
        int duration = Snackbar.LENGTH_SHORT;
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);
        snackbar.setAction(("Add"), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform action here
                snackbar.dismiss();
                Toast toast = Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        snackbar.show();
    }

    private class SectionsPagerAdapter extends FragmentStateAdapter {
        public SectionsPagerAdapter(FragmentActivity fa){
            super(fa);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch(position){
                case 0:
                    return new TopFragment();
                case 1:
                    return new FeaturedFragment();
                case 2:
                    return new AttractionFragment();
                case 3:
                    return new RestaurantFragment();
                case 4:
                    return new HotelFragment();
                default:
                    return null;
            }
        }
        @Override
        public int getItemCount() {
            return 5;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->
        {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.baseline_home_24); //You can set your own tab titles here
                    break;
                case 1:
                    tab.setIcon(R.drawable.baseline_location_city_24);
                    break;
                case 2:
                    tab.setIcon(R.drawable.baseline_restaurant);
                    break;
                case 3:
                    tab.setIcon(R.drawable.baseline_hotel_24);
                    break;
                case 4:
                    tab.setIcon(R.drawable.baseline_add_24);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
        }).attach();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);


    }
}