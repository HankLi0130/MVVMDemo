package tw.hankli.mvvmdemo.model;

import io.reactivex.Completable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hank on 12/02/2018.
 * 純服務區
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("/validation")
    Completable validate(@Field("username") String username, @Field("password") String password);
}
