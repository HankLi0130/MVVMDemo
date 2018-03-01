package tw.hankli.mvvmdemo.model;

import io.reactivex.Completable;

/**
 * Created by hank on 12/02/2018.
 * 複合服務區
 */

public class LoginRepository {

    private LoginApi loginApi;

    public LoginRepository(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    public Completable loginByApi(String username, String password) {
        return loginApi.validate(username, password);
    }
}
