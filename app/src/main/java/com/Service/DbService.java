package com.Service;

import com.Model.Room;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface DbService {
    @GET("room/getRoomList")
    Observable<List<Room>> getRoomList();


    @POST("user/login")
    @FormUrlEncoded
    Observable<Boolean> login(@Field("rtx") String rtx, @Field("outlookPwd") String pwd);

    @GET("room/getRoomByRoomId")
    Observable<Room> getRoombyRoomId(@Query("roomId") int i);
}
