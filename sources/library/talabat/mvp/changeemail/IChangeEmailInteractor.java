package library.talabat.mvp.changeemail;

import library.talabat.mvp.IGlobalInteractor;

public interface IChangeEmailInteractor extends IGlobalInteractor {
    void sendChangeEmailRequest(String str, String str2);
}
