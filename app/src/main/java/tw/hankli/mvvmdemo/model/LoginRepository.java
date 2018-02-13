package tw.hankli.mvvmdemo.model;

import io.reactivex.Single;

/**
 * Created by hank on 12/02/2018.
 * 複合服務區
 */

public class LoginRepository {

    private LoginApi loginApi;

    public LoginRepository() {
        // TODO 可使用 DI Library 注入
        loginApi = new LoginApi();
    }

    public Single<Boolean> loginByApi(String username, String password) {
        return Single.create(emitter -> {
            if (loginApi.login(username, password)) {
                emitter.onSuccess(true);
            } else {
                emitter.onSuccess(false);
            }
        });
    }
}
