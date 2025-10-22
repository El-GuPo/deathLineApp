package com.ru.elgupo.deathlineapp.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ru.elgupo.deathlineapp.repository.AuthRepository;
import com.ru.elgupo.deathlineapp.repository.AuthRepositoryImpl;

public class AuthViewModel extends AndroidViewModel {

    private AuthRepository authRepository;
    public MutableLiveData<Boolean> isAuthenticated = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();


    public AuthViewModel(@NonNull Application application) {
        super(application);
        authRepository = new AuthRepositoryImpl();
    }

    public Long login(String email, String password) {
        isAuthenticated.setValue(true);
        return authRepository.login(email, password);
    }

}
