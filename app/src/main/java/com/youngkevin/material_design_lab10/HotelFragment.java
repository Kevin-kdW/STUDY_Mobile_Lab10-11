package com.youngkevin.material_design_lab10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class HotelFragment extends Fragment {
    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        String[] locationNames = new String[Locations.location.length];
        int[] imageIds = new int[Locations.location.length];
        for(int i = 0; i < Locations.location.length; i++){
            locationNames[i] = Locations.location[i].getName();
            imageIds[i] = Locations.location[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapterImage = new CaptionedImagesAdapter(locationNames, imageIds);
        recyclerView.setAdapter(adapterImage);

        // You can specify your desired layout manager here
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}