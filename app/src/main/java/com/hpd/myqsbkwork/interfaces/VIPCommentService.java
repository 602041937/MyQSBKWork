package com.hpd.myqsbkwork.interfaces;

import com.hpd.myqsbkwork.models.VIPCommentResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by jash
 * Date: 15-12-29
 * Time: 下午2:09
 */
public interface VIPCommentService {
    @GET("article/{id}/comments")
    Call<VIPCommentResponse> getList(@Path("id") String id, @Query("page") int page);
}
