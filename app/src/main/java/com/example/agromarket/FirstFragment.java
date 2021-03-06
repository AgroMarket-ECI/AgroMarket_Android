package com.example.agromarket;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.agromarket.databinding.FragmentFirstBinding;
import com.example.agromarket.network.RetrofitGenerator;
import com.example.agromarket.network.dto.auth.LoginDto;
import com.example.agromarket.network.dto.auth.TokenDto;
import com.example.agromarket.network.dto.user.UserDto;
import com.example.agromarket.network.service.auth.AuthService;
import com.example.agromarket.network.service.user.UserService;
import com.example.agromarket.network.storage.SharedPreferenceStorage;
import com.example.agromarket.network.storage.Storage;

import java.util.List;

import retrofit2.Retrofit;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Storage storage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLoging.setOnClickListener(view1 -> {
            //NavHostFragment.findNavController(FirstFragment.this)
            //.navigate(R.id.action_FirstFragment_to_SecondFragment));
            if(validLoginForm()){
                sendAuthRequest();
            }
            sendAuthRequest();
            //sendUserRequest();
        });
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("SHARED_preferences", Context.MODE_PRIVATE);
        storage = new SharedPreferenceStorage(sharedPreferences);
    }

    private boolean validLoginForm() {
        Editable usernNameText = binding.inputUsername.getText();
        Editable passwordNameText = binding.inputPassword.getText();
        if(usernNameText.length()==0 && !Patterns.EMAIL_ADDRESS.matcher(usernNameText).matches()){
            binding.inputUsername.setError(getString(R.string.invalid_email));
        }else if (passwordNameText.length()==0){
            binding.inputUsername.setError(null);
            binding.inputPassword.setError(getString(R.string.invalid_password));
        }else{
            binding.inputUsername.setError(null);
            binding.inputPassword.setError(null);
            return true;
        }
        return false;
    }

    private void sendAuthRequest() {
        Retrofit retrofit = RetrofitGenerator.getInstance(storage);
        AuthService authService = retrofit.create(AuthService.class);
        //LoginDto loginDto = new LoginDto("demoYarit@mail.escuelaing.edu.co", "123451");
        LoginDto loginDto = new LoginDto(binding.inputUsername.getText().toString(), binding.inputPassword.getText().toString());
        Action1<TokenDto> successAction = tokenDto -> onAuthSuccess(tokenDto.getToken());
        Action1<Throwable> failedAction = throwable -> Log.e("Developer", "Auth error", throwable);
        authService.auth(loginDto)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(ContextCompat.getMainExecutor(requireContext())))
                .subscribe(successAction, failedAction);
    }

    private void sendUserRequest() {
        Retrofit retrofit = RetrofitGenerator.getInstance(storage);
        UserService userService = retrofit.create(UserService.class);
        sendListUserRequest(userService);
    }

    private void sendListUserRequest(UserService userService) {
        Action1<List<UserDto>> successAction = this::onSuccessListUser;
        Action1<Throwable> failedAction = throwable -> Log.e("Developer", "User error", throwable);
        userService.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(ContextCompat.getMainExecutor(requireContext())))
                .subscribe(successAction, failedAction);
    }

    private void onSuccessListUser(List<UserDto> users){
        Log.d("Developer","Users: " + users);
        //binding.textviewFirst.setText(users.toString());
    }


    private void onAuthSuccess(String token){
        Log.d("Developer","TokenDto: " + token);
        storage.saveToken(token); //Value of token its lost if the app is uninstalled M
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}