package com.ru.elgupo.deathlineapp.services.deadlines;

import com.ru.elgupo.deathlineapp.services.deadlines.DeadlinesApi;
import com.ru.elgupo.deathlineapp.services.dto.DeadlineDto;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DeadlinesApiClinet {
    private final DeadlinesApi api;

    public DeadlinesApiClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        api = retrofit.create(DeadlinesApi.class);
    }

    public DeadlinesApi getApi() {
        return api;
    }
}
