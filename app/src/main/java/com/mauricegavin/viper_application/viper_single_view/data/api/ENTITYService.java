package com.mauricegavin.viper_application.viper_single_view.data.api;

import com.mauricegavin.viper_application.viper_single_view.data.entities.ENTITY;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * API Endpoint for retrieving ENTITYs.
 * API Documentation:
 */
public interface ENTITYService {

    /**
     * @return list of ENTITYs
     */
    @GET("/v2/ENTITY_PATH")
    Observable<List<ENTITY>> getENTITYs();

    @FormUrlEncoded
    @POST("/v2/ENTITY_PATH")
    Observable<ENTITY> createENTITY(@Field("param1") String param1);

    @FormUrlEncoded
    @PATCH("/v2/ENTITY_PATH/{id}")
    Observable<ENTITY> updateDefaultENTITY(@Path("id") String id,
                                           @Field("param1") String param1);
}
