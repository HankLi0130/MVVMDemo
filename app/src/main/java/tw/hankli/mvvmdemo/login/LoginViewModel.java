package tw.hankli.mvvmdemo.login;

import android.arch.lifecycle.ViewModel;

import io.reactivex.Single;
import tw.hankli.mvvmdemo.model.LoginRepository;

/**
 * Created by hank on 13/02/2018.
 */

public class LoginViewModel extends ViewModel {

    private LoginRepository loginRepository;

    public LoginViewModel() {

        // TODO 可使用 DI Library 注入
        loginRepository = new LoginRepository();
    }

    public Single<Boolean> login(String username, String password) {

        return loginRepository.loginByApi(username, password);

    }
}
