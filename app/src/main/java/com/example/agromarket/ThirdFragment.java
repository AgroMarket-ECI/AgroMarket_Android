package com.example.agromarket;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agromarket.databinding.FragmentThirdBinding;
import com.example.agromarket.network.RetrofitGenerator;
import com.example.agromarket.network.dto.model.DiseaseDto;
import com.example.agromarket.network.dto.model.TreatmentDto;
import com.example.agromarket.network.service.recommendation.RecommendationService;
import com.example.agromarket.network.storage.Storage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ThirdFragment extends Fragment {


    private FragmentThirdBinding binding;
    private Storage storage;
    private TreatmentAdapter mAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        String namePlant = getArguments().getString("planta");
        getTreatments(namePlant);
        getDisease(namePlant);
    }

    public void getTreatments(String name){
        Retrofit retrofit = RetrofitGenerator.getInstance(storage);
        RecommendationService recommendationService = retrofit.create(RecommendationService.class);
        Action1<List<TreatmentDto>> successAction = treatmentDtos -> onRecomendtionSuccess(treatmentDtos);
        Action1<Throwable> failedAction = throwable -> Log.e("Developer", "Auth error", throwable);
        recommendationService.recommendationsByImage(name+".jpg")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(ContextCompat.getMainExecutor(requireContext())))
                .subscribe(successAction, failedAction);

    }

    private void onRecomendtionSuccess(List<TreatmentDto> treatments) {
        RecyclerView rv = (RecyclerView) binding.recyclerView;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(linearLayoutManager);
        ArrayList<TreatmentDto> tratamientos = new ArrayList<>(treatments);
        mAdapter = new TreatmentAdapter(tratamientos,ThirdFragment.this);
        rv.setAdapter(mAdapter);
    }

    public void getDisease(String name){
        Retrofit retrofit = RetrofitGenerator.getInstance(storage);
        RecommendationService recommendationService = retrofit.create(RecommendationService.class);
        Action1<DiseaseDto> successAction = diseaseDto -> onDiseaseSucccess(diseaseDto);
        Action1<Throwable> failedAction = throwable -> Log.e("Developer", "Auth error", throwable);
        recommendationService.infoDiseaseByImage(name+".jpg")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(ContextCompat.getMainExecutor(requireContext())))
                .subscribe(successAction, failedAction);
    }

    private void onDiseaseSucccess(DiseaseDto diseaseDto) {
        TextView tvProblem = (TextView) binding.tvProblema;
        tvProblem.setText(diseaseDto.getDescription());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}