package br.com.solimar.desafiomobfiq.connections;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Solimar on 04/07/2017.
 */

public class RetrofitConnection <T> {

    public static final String ENDPOINT = "https://desafio.mobfiq.com.br/";


    public static <S> S createRetrofitService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ENDPOINT)
                .build();

        return retrofit.create(serviceClass);
    }
}