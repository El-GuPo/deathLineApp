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

    public void login(String email, String password) {
        if (authRepository.login(email, password)) {
            isAuthenticated.setValue(true);
        } else {
            errorMessage.setValue("Неверные данные");
        }
    }

}
