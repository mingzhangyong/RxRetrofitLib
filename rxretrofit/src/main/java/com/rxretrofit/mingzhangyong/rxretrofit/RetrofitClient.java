package com.rxretrofit.mingzhangyong.rxretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zx on 2017/6/14.
 */

public class RetrofitClient {
    private Retrofit retrofit;
    public static final String CONTENT_TYPE_JSON = "Content-type:application/json; charset=utf-8";
    public static final String StrRxForNull = "isNull";
    private final String TAG ="intercept()->";


    private RetrofitClient(String apiHost){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:sss")
                .create();
        /**
         * 设置log级别
         *     NONE：不记录
         *     BASIC:请求/响应行
         *     HEADERS：请求/响应行 + 头
         *     BODY 请求/响应行 + 头 + 体
         */
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);


//        Interceptor logginInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request().newBuilder().addHeader("Accept-Encoding", "gzip").build();
//                long startTime = System.currentTimeMillis();
//                okhttp3.Response response = chain.proceed(chain.request());
//                long endTime = System.currentTimeMillis();
//                long duration=endTime-startTime;
//                okhttp3.MediaType mediaType = response.body().contentType();
//                String content = response.body().string();
//                Log.d(TAG,"\n");
//                Log.d(TAG,"----------Start----------------");
//                Log.d(TAG, "| "+request.toString());
//                Headers headers = request.headers();
//                for (int i = 0, count = headers.size(); i < count; i++) {
//                    String name = headers.name(i);
//                    if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
//                        Log.d(TAG,name + ": " + headers.value(i));
//                    }
//                }
//                String method=request.method();
//                if("POST".equals(method)){
//                    StringBuilder sb = new StringBuilder();
//                    if (request.body() instanceof FormBody) {
//                        FormBody body = (FormBody) request.body();
//                        for (int i = 0; i < body.size(); i++) {
//                            sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
//                        }
//                        sb.delete(sb.length() - 1, sb.length());
//                        Log.d(TAG, "| RequestParams:{"+sb.toString()+"}");
//                    }
//                }
//                Log.d(TAG, "| Response:" + content);
//                Log.d(TAG,"----------End:"+duration+"毫秒----------");
//                return response.newBuilder()
//                        .body(okhttp3.ResponseBody.create(mediaType, content))
//                        .build();
//            }
//        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(apiHost)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }


    private static class SingletonHolder{
        private static RetrofitClient retrofitClient = null;

        private SingletonHolder(){}
        private static RetrofitClient getInstance(String apiHost){
            if (retrofitClient==null){
                synchronized (RetrofitClient.class){
                    if (retrofitClient==null){
                        retrofitClient = new RetrofitClient(apiHost);
                    }
                }
            }
            return retrofitClient;
        }
    }
    /**
     * 获取RetrofitClient
     * @return
     */
    public static RetrofitClient getInstance(String apiHost){
        return SingletonHolder.getInstance(apiHost);
    }
    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }
}
