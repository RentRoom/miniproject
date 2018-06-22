package com.Service;

import com.Model.Room;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface DbService {
    @GET("room/getRoomList")
    Observable<List<Room>> getRoomList();

//    @POST("user/login")
//    Observable<Result> login(@Body Map<String,String> para);
}
