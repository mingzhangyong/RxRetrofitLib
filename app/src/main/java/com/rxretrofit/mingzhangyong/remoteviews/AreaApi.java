package com.rxretrofit.mingzhangyong.remoteviews;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by DeathKnightMo on 15-3-11.
 */
public interface AreaApi {
    @GET("news/api/areas")
    Observable<List<Area>> getNewsAreas();
}
