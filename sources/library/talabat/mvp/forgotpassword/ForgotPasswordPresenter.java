package library.talabat.mvp.forgotpassword;

import JsonModels.Response.PasswordResponse;
import com.android.volley.VolleyError;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatUtils;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.gtm.TrackingUtils;

public class ForgotPasswordPresenter implements IForgotPasswordPresenter, ForgotPasswordListener {
    private ForgotPasswordView forgotPasswordView;
    private IForgotPasswordInteractor iForgotPasswordInteractor;
    private boolean isForgotPasswordForMobileNumberLogin;

    public ForgotPasswordPresenter(ForgotPasswordView forgotPasswordView2, IForgotPasswordInteractor iForgotPasswordInteractor2) {
        this.forgotPasswordView = forgotPasswordView2;
        this.iForgotPasswordInteractor = iForgotPasswordInteractor2;
    }

    private void validateEmailAddressAndSendRequest() {
        String email = this.forgotPasswordView.getEmail();
        if (email.equals("")) {
            this.forgotPasswordView.onValidationError(10);
        } else if (!TalabatUtils.isValidEmail(email)) {
            this.forgotPasswordView.onValidationError(11);
        } else {
            this.forgotPasswordView.loading();
            this.iForgotPasswordInteractor.sendPasswordRequest(email);
        }
    }

    private void validateMobileNumberAndSendRequest(@NotNull String str) {
        if (str.isEmpty()) {
            this.forgotPasswordView.onValidationError(12);
            return;
        }
        this.forgotPasswordView.startLodingPopup();
        this.iForgotPasswordInteractor.sendPasswordRequestForMobileNumber(str);
    }

    public void onCreate(boolean z11) {
        this.isForgotPasswordForMobileNumberLogin = z11;
        if (z11) {
            this.forgotPasswordView.hideEmailField();
            this.forgotPasswordView.showMobileNumberField(GlobalConstants.IRAQ_COUNTRY_CODE);
        }
    }

    public void onDataError() {
        this.forgotPasswordView.onDataError();
        AppTracker.onPasswordResetSubmit(this.forgotPasswordView.getContext(), "", "Forgot Password Screen", TrackingUtils.ResetPasswordOption.Failed.getValue(), TrackingUtils.INSTANCE.getResetAuthException());
    }

    public void onDestroy() {
        this.forgotPasswordView = null;
        IForgotPasswordInteractor iForgotPasswordInteractor2 = this.iForgotPasswordInteractor;
        if (iForgotPasswordInteractor2 != null) {
            iForgotPasswordInteractor2.unregister();
        }
        this.iForgotPasswordInteractor = null;
    }

    public void onNetworkError() {
        this.forgotPasswordView.onNetworkError();
    }

    public void onRequestPasswordSuccess(PasswordResponse passwordResponse) {
        this.forgotPasswordView.onRequestPasswordSuccess(passwordResponse);
    }

    public void onServerError(VolleyError volleyError) {
        this.forgotPasswordView.onServerError(volleyError);
    }

    public void validateAndRequest(@NotNull String str) {
        if (this.isForgotPasswordForMobileNumberLogin) {
            validateMobileNumberAndSendRequest(str);
        } else {
            validateEmailAddressAndSendRequest();
        }
    }
}
