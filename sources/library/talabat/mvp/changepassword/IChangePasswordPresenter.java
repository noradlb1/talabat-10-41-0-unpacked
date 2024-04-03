package library.talabat.mvp.changepassword;

import library.talabat.mvp.IGlobalPresenter;

public interface IChangePasswordPresenter extends IGlobalPresenter {
    boolean isAdvancedPasswordValidationEnabled();

    void validateAndRequest();
}
