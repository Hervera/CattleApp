package com.andikasoft.rwandacattle.rwandacattle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class BreederAddAnimalFragment extends Fragment {


    public BreederAddAnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.breeder_add_animal_fragment, container, false);

        Spinner staticSpinner = (Spinner) v.findViewById(R.id.animal_category_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.animal_categories_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);


        Spinner animalGenderStaticSpinner = (Spinner) v.findViewById(R.id.animal_gender_spinner);
        ArrayAdapter<CharSequence> genderStaticAdapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.animal_gender_array, android.R.layout.simple_spinner_item);
        genderStaticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalGenderStaticSpinner.setAdapter(genderStaticAdapter);

        animalGenderStaticSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner animalSizeStaticSpinner = (Spinner) v.findViewById(R.id.animal_size_spinner);
        animalSizeStaticSpinner.setPrompt("Size");
        ArrayAdapter<CharSequence> sizeStaticAdapter = ArrayAdapter
                .createFromResource(this.getActivity(), R.array.animal_size_array,
                        android.R.layout.simple_spinner_item);
        sizeStaticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalSizeStaticSpinner.setAdapter(sizeStaticAdapter);

        return v;
    }

}
