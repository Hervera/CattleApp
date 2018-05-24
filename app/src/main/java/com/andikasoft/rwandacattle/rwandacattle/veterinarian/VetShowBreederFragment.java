package com.andikasoft.rwandacattle.rwandacattle.veterinarian;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andikasoft.rwandacattle.rwandacattle.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VetShowBreederFragment extends Fragment {


    public VetShowBreederFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vet_show_breeder_fragment, container, false);
    }

}
