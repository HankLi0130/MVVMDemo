package tw.hankli.mvvmdemo.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hank on 01/03/2018.
 */
@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return appContext;
    }

    // SharedPreference等...
}
