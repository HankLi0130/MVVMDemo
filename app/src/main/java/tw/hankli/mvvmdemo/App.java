package tw.hankli.mvvmdemo;

import android.app.Application;

import tw.hankli.mvvmdemo.injection.AppComponent;
import tw.hankli.mvvmdemo.injection.AppModule;
import tw.hankli.mvvmdemo.injection.DaggerAppComponent;

/**
 * Created by hank on 01/03/2018.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
