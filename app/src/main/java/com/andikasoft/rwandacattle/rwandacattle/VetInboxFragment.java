package com.andikasoft.rwandacattle.rwandacattle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class VetInboxFragment extends Fragment {
    FragmentTransaction fragmentTransaction;

    public VetInboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.vet_inbox_fragment, container, false);

        FloatingActionButton fab = v.findViewById(R.id.fab_vet_new_message);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.vet_main_container, new VetComposeMessageFragment());
//                fragmentTransaction.commit();

                Fragment someFragment = new VetComposeMessageFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.vet_main_container,someFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        return v;
    }

}
