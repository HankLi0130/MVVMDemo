package tw.hankli.mvvmdemo.model;

/**
 * Created by hank on 12/02/2018.
 * 純服務區
 */

public class LoginApi {

    public boolean login(String username, String password) {
        // TODO 呼叫遠端，驗證身份
        return validate(username, password);
    }

    private boolean validate(String username, String password) {
        if (username.equals("1234") && password.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
