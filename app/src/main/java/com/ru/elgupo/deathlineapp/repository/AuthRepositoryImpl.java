package com.ru.elgupo.deathlineapp.repository;

import com.ru.elgupo.deathlineapp.model.User;

public class AuthRepositoryImpl implements AuthRepository{
    @Override
    public boolean login(String email, String password) {
        // TODO: поиск пользователя
        return !email.isEmpty() && !password.isEmpty() && password.length() >= 3;
    }

    @Override
    public Long getUserId(String email) {
        // TODO: вернуть ID пользователя
        return null;
    }
}
