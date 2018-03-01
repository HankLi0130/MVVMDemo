package tw.hankli.mvvmdemo.login;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tw.hankli.mvvmdemo.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private LoginViewModel viewModel;

    private ProgressDialog dialog;

    @BindView(R.id.txt_username)
    TextView txtUsername;

    @BindView(R.id.txt_password)
    TextView txtPassword;

    @OnClick(R.id.btn_login)
    void login() {

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        login(username, password);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        dialog = new ProgressDialog(this);
    }

    private void login(String username, String password) {

        dialog.show();

        viewModel.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> dialog.dismiss())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        // 登入成功
                        loginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "Error: " + e);

                        // 登入失敗
                        loginFail();
                    }
                });
    }

    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
    }

    public void loginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_LONG).show();
    }
}
