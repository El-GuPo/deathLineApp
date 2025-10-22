package com.ru.elgupo.deathlineapp.services.deadlines;
import retrofit2.Call;
import retrofit2.http.*;

import com.ru.elgupo.deathlineapp.services.dto.DeadlineDto;
import java.time.Instant;
import java.util.List;

public interface DeadlinesApi {
    @GET("/deadlines/get_deadlines_for_user")
    Call<List<DeadlineDto>> getDeadlinesForUser(
            @Query("userId") Long userId,
            @Query("from") Instant from,
            @Query("to") Instant to
    );

    @POST("/deadlines/create_deadline_for_user")
    Call<DeadlineDto> createDeadlineForUser(
            @Query("userId") Long userId,
            @Body DeadlineDto deadline
    );

    @POST("/deadlines/delete_deadline_for_user")
    Call<Void> deleteDeadlineForUser(@Query("deadlineId") Long deadlineId);
}
