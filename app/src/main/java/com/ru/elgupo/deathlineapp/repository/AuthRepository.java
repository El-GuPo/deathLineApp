package com.ru.elgupo.deathlineapp.repository;

import com.ru.elgupo.deathlineapp.model.User;

public interface AuthRepository {

    boolean login(String email, String password);

    Long getUserId(String email);
}
