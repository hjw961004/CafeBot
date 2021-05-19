package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class FragmentCaffeine extends Fragment {
    int subcategoryState = 0;
    RadioGroup radioGroup;

    OnTimePickerSetListener onTimePickerSetListner;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnTimePickerSetListener){
            onTimePickerSetListner = (OnTimePickerSetListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_caffeine, container, false);

        radioGroup = (RadioGroup)rootView.findViewById(R.id.radioGroup6);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Espresso :
                        subcategoryState = 5;
                        onTimePickerSetListner.onTimePickerSet(subcategoryState);
                        break;
                    case R.id.coldbrew :
                        subcategoryState = 6;
                        onTimePickerSetListner.onTimePickerSet(subcategoryState);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}