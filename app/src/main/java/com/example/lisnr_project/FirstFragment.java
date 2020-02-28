package com.example.lisnr_project;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class FirstFragment extends Fragment {

    TextView showCount;
    TextView showButtonText;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        showCount = fragmentFirstLayout.findViewById(R.id.editCount);
        showButtonText = fragmentFirstLayout.findViewById(R.id.button_first);
        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }

            private void countMe(View view){
                String countString = showCount.getText().toString();
                int count = Integer.parseInt(countString);
                count++;
                showCount.setText(Integer.toString(count));

                if(count % 2 == 0){
                    view.findViewById(R.id.button_first).setBackgroundColor(Color.BLUE);
                }
                else{
                    view.findViewById(R.id.button_first).setBackgroundColor(Color.RED);
                }
                if(count >= 10){
                    showButtonText.setText("OUCH!!!");
                }
                if(count >= 20){
                    int rand = new Random().nextInt((1000 - 1) + 1);
                    showButtonText.setText(String.valueOf(rand));
                }
            }
        });
    }
}