package com.youngkevin.material_design_lab10;

import androidx.annotation.NonNull;

import com.youngkevin.material_design_lab10.R;

public class Locations {
    private String name;
    private int imageResourceId;

    public static final Locations[] location = {
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
            new Locations("Queens Park", R.drawable.baseline_location_city_24),
    };

    public Locations(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
