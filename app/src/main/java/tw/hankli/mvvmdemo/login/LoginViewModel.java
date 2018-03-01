package tw.hankli.mvvmdemo.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Completable;
import tw.hankli.mvvmdemo.App;
import tw.hankli.mvvmdemo.model.LoginRepository;

/**
 * Created by hank on 13/02/2018.
 */

public class LoginViewModel extends AndroidViewModel {

    @Inject
    LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        ((App) application).getAppComponent().inject(this);
    }

    public Completable login(String username, String password) {

        return loginRepository.loginByApi(username, password);

    }
}
