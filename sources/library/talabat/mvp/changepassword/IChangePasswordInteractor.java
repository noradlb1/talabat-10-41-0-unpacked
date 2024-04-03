package library.talabat.mvp.changepassword;

import library.talabat.mvp.IGlobalInteractor;

public interface IChangePasswordInteractor extends IGlobalInteractor {
    void sendChangePasswordRequest(String str, String str2);
}
