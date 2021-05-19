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

public class FragmentBlended extends Fragment {
    int blendedState = 0;
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_blended, container, false);

        radioGroup = (RadioGroup)rootView.findViewById(R.id.radioGroup5);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.frappe :
                        blendedState = 1;
                        onTimePickerSetListner.onTimePickerSet(blendedState);
                        break;
                    case R.id.shake :
                        blendedState = 2;
                        onTimePickerSetListner.onTimePickerSet(blendedState);
                        break;
                    case R.id.smoothie :
                        blendedState = 3;
                        onTimePickerSetListner.onTimePickerSet(blendedState);
                        break;
                    case R.id.juice :
                        blendedState = 4;
                        onTimePickerSetListner.onTimePickerSet(blendedState);
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