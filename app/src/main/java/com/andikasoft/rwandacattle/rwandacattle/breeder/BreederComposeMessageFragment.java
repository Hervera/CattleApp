package com.andikasoft.rwandacattle.rwandacattle.breeder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andikasoft.rwandacattle.rwandacattle.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreederComposeMessageFragment extends Fragment {


    public BreederComposeMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.breeder_compose_message_fragment, container, false);
    }

}
