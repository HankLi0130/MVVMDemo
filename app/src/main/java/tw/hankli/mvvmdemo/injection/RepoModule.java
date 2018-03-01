package tw.hankli.mvvmdemo.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tw.hankli.mvvmdemo.model.LoginApi;
import tw.hankli.mvvmdemo.model.LoginRepository;

/**
 * Created by hank on 01/03/2018.
 */
@Module
public class RepoModule {

    @Provides
    @Singleton
    LoginRepository provideLoginRepository(LoginApi loginApi) {
        return new LoginRepository(loginApi);
    }
}
