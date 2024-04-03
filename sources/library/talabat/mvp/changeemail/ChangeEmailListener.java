package library.talabat.mvp.changeemail;

import library.talabat.mvp.IGlobalListener;

public interface ChangeEmailListener extends IGlobalListener {
    void onEmailChangeFailed(String str);

    void onEmailRequestSuccess(String str);
}
