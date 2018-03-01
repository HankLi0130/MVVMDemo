package tw.hankli.mvvmdemo.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import tw.hankli.mvvmdemo.login.LoginViewModel;

/**
 * Created by hank on 01/03/2018.
 */
@Singleton
@Component(modules = {AppModule.class, RemoteModule.class, RepoModule.class})
public interface AppComponent {

    Context getAppContext();

    void inject(LoginViewModel viewModel);
}
