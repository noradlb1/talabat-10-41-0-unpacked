package library.talabat.mvp.changepassword;

import library.talabat.mvp.IGlobalListener;

public interface ChangePasswordListener extends IGlobalListener {
    void onPasswordChangeFailed(String str);

    void onPasswordRequestSuccess(String str);
}
