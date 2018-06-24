package com.Service;

import com.Model.Message;
import com.Model.Room;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface DbService {
    @GET("getRoomList")
    Observable<List<Room>> getRoomList(@Query("subject") int subject);


    @POST("login")
    @FormUrlEncoded
    Observable<Boolean> login(@Field("rtx") String rtx, @Field("outlookPwd") String pwd);

    @GET("getRoomByRoomId")
    Observable<Room> getRoombyRoomId(@Query("roomId") int i);

    @POST("addNewRoom")
    Observable<Boolean> addRoom(@Query("publishTime") int publishTime,@Query("location") String location,@Query("rentWay") int rentway,@Query("subject") int subject,
                                     @Query("rtx") String rtx,@Query("money") int money,@Query("deadline") int deadline,@Query("description") String description);

    @GET("addMessage")
    Observable<Boolean> addMessage(@Query("fromRtx") String fromRtx,@Query("toRtx") String toRTx,@Query("message") String message);

    @GET("getMessageList")
    Observable<List<Message>> getMessageList(@Query("rtx") String rtx);
}
