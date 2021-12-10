package com.example.agromarket;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agromarket.databinding.FragmentFourBinding;
import com.example.agromarket.databinding.FragmentThirdBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourFragment extends Fragment {

    private FragmentFourBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFourBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String instructions = bundle.getString("instructions");
        Log.d("prueba", instructions);
        binding.textViewInstruction.setText(instructions);
    }

}