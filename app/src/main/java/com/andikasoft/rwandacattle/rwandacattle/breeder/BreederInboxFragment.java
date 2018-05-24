package com.andikasoft.rwandacattle.rwandacattle.breeder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andikasoft.rwandacattle.rwandacattle.R;

public class BreederInboxFragment extends Fragment {
    FragmentTransaction fragmentTransaction;

    public BreederInboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.breeder_inbox_fragment, container, false);

        FloatingActionButton fab = v.findViewById(R.id.fab_breeder_new_message);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new BreederComposeMessageFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.breeder_main_container,someFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


}
