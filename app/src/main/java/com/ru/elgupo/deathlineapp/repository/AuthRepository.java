package com.ru.elgupo.deathlineapp.repository;

import com.ru.elgupo.deathlineapp.model.User;

public interface AuthRepository {

    Long login(String email, String password);
}
