package br.com.solimar.desafiomobfiq.services;

import java.util.List;

import br.com.solimar.desafiomobfiq.models.Category;
import br.com.solimar.desafiomobfiq.models.ResultadoJsonCategory;
import br.com.solimar.desafiomobfiq.models.ResultadoJsonProducts;
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

    @POST("Search/Criteria/")
    @FormUrlEncoded
    Observable<Response<ResultadoJsonProducts>> search(@Field("Query") String query, @Field("Offset") int offSet, @Field("Size") int size);

    @GET("StorePreference/CategoryTree/")
    Observable<Response<ResultadoJsonCategory>> listCategorias();
}
