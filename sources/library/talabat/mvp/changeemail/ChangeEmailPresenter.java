package library.talabat.mvp.changeemail;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.TalabatUtils;

public class ChangeEmailPresenter implements IChangeEmailPresenter, ChangeEmailListener {
    private ChangeEmailView changeEmailView;
    private IChangeEmailInteractor iChangeEmailInteractor;

    public ChangeEmailPresenter(AppVersionProvider appVersionProvider, ChangeEmailView changeEmailView2) {
        this.changeEmailView = changeEmailView2;
        this.iChangeEmailInteractor = new ChangeEmailInteractor(appVersionProvider, this);
    }

    public void onDataError() {
        this.changeEmailView.onDataError();
    }

    public void onDestroy() {
        this.changeEmailView = null;
        if (this.iChangeEmailInteractor != null) {
            this.iChangeEmailInteractor = null;
        }
    }

    public void onEmailChangeFailed(String str) {
        this.changeEmailView.onEmailRequestFailed(str);
    }

    public void onEmailRequestSuccess(String str) {
        this.changeEmailView.onEmailRequestSuccess(str);
    }

    public void onNetworkError() {
        this.changeEmailView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.changeEmailView.onServerError(volleyError);
    }

    public void validateAndRequest() {
        boolean z11;
        String currentPassword = this.changeEmailView.getCurrentPassword();
        String newEmail = this.changeEmailView.getNewEmail();
        String retypedEmail = this.changeEmailView.getRetypedEmail();
        boolean z12 = false;
        if (newEmail.equals("")) {
            this.changeEmailView.onValidationError(20);
            z11 = false;
        } else {
            z11 = true;
        }
        if (retypedEmail.equals("")) {
            this.changeEmailView.onValidationError(21);
            z11 = false;
        }
        if (currentPassword.equals("")) {
            this.changeEmailView.onValidationError(22);
        } else {
            z12 = z11;
        }
        if (!z12) {
            return;
        }
        if (!newEmail.equals(retypedEmail)) {
            this.changeEmailView.onValidationError(23);
        } else if (!TalabatUtils.isValidEmail(newEmail)) {
            this.changeEmailView.onValidationError(24);
        } else {
            this.changeEmailView.onValidationSuccess();
            this.iChangeEmailInteractor.sendChangeEmailRequest(newEmail, currentPassword);
        }
    }
}
