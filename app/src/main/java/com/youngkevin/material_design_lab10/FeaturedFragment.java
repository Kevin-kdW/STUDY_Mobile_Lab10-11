package com.youngkevin.material_design_lab10;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FeaturedFragment extends Fragment {
    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featured,container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        //populate arrays from dataset
        String[] locationNames = new String[Locations.location.length];
        int[] imageIds = new int[Locations.location.length];
        for(int i = 0; i < Locations.location.length; i++)
        {
            locationNames[i] = Locations.location[i].getName();
            imageIds[i] = Locations.location[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(locationNames, imageIds);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
