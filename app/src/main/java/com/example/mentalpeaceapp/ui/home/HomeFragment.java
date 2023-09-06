package com.example.mentalpeaceapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mentalpeaceapp.R;
import com.example.mentalpeaceapp.databinding.FragmentHomeBinding;
import com.example.mentalpeaceapp.ui.AudioTherapyActivity;
import com.example.mentalpeaceapp.ui.ConsultDocActivity;
import com.example.mentalpeaceapp.ui.ReadingTherapyActivity;
import com.example.mentalpeaceapp.ui.YogaTherapyActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textQues;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent = new Intent();
        binding.audioCv.setOnClickListener(v -> {
            intent.setClass(getActivity(),AudioTherapyActivity.class);
            startActivity(intent);
        });
        binding.readingCv.setOnClickListener(v -> {
            intent.setClass(getActivity(), ReadingTherapyActivity.class);
            startActivity(intent);
        });
        binding.yogaCv.setOnClickListener(v -> {
            intent.setClass(getActivity(), YogaTherapyActivity.class);
            startActivity(intent);
        });
        binding.doctorCv.setOnClickListener(v -> {
            intent.setClass(getActivity(), ConsultDocActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}