package br.com.solimar.desafiomobfiq.services;

import br.com.solimar.desafiomobfiq.models.ResultadoJson;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Solimar on 04/07/2017.
 */

public interface MobfiqService {

    @POST
    @FormUrlEncoded
    Observable<Response<ResultadoJson>> search(@Field("Query") String query, @Field("Offset") int offSet, @Field("Size") int size);

    @GET("StorePreference/CategoryTree/")
    Observable<Response<Object>> listCategorias();
}
