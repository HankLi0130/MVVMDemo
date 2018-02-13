package tw.hankli.mvvmdemo.login;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import tw.hankli.mvvmdemo.R;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel viewModel;

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            login(username, password);
        });
    }

    private void login(String username, String password) {

        viewModel.login(username, password)
                .subscribe(isSuccess -> {
                    if (isSuccess) {
                        loginSuccess();
                    } else {
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
