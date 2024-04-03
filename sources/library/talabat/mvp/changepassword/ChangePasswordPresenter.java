package library.talabat.mvp.changepassword;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;

public class ChangePasswordPresenter implements IChangePasswordPresenter, ChangePasswordListener {
    private ChangePasswordView changePasswordView;
    private IChangePasswordInteractor iChangePasswordInteractor;
    private final ITalabatFeatureFlag talabatFeatureFlag;
    private final Validator validator;

    public ChangePasswordPresenter(AppVersionProvider appVersionProvider, ChangePasswordView changePasswordView2, Validator validator2, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.changePasswordView = changePasswordView2;
        this.validator = validator2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.iChangePasswordInteractor = new ChangePasswordInteractor(appVersionProvider, this);
    }

    public boolean isAdvancedPasswordValidationEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_USE_COMPLEX_PASSWORD_RULE, false);
    }

    public void onDataError() {
        this.changePasswordView.onDataError();
    }

    public void onDestroy() {
        this.changePasswordView = null;
        IChangePasswordInteractor iChangePasswordInteractor2 = this.iChangePasswordInteractor;
        if (iChangePasswordInteractor2 != null) {
            iChangePasswordInteractor2.unregister();
        }
        this.iChangePasswordInteractor = null;
    }

    public void onNetworkError() {
        this.changePasswordView.onNetworkError();
    }

    public void onPasswordChangeFailed(String str) {
        this.changePasswordView.onPasswordRequestFailed(str);
    }

    public void onPasswordRequestSuccess(String str) {
        this.changePasswordView.onPasswordRequestSuccess(str);
    }

    public void onServerError(VolleyError volleyError) {
        this.changePasswordView.onServerError(volleyError);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void validateAndRequest() {
        /*
            r7 = this;
            library.talabat.mvp.changepassword.ChangePasswordView r0 = r7.changePasswordView
            java.lang.String r0 = r0.getCurrentPassword()
            library.talabat.mvp.changepassword.ChangePasswordView r1 = r7.changePasswordView
            java.lang.String r1 = r1.getNewPassword()
            library.talabat.mvp.changepassword.ChangePasswordView r2 = r7.changePasswordView
            java.lang.String r2 = r2.getRetypedPassword()
            java.lang.String r3 = ""
            boolean r4 = r0.equals(r3)
            r5 = 0
            if (r4 == 0) goto L_0x0024
            library.talabat.mvp.changepassword.ChangePasswordView r4 = r7.changePasswordView
            r6 = 30
            r4.onValidationError(r6)
            r4 = r5
            goto L_0x0025
        L_0x0024:
            r4 = 1
        L_0x0025:
            boolean r6 = r7.isAdvancedPasswordValidationEnabled()
            if (r6 == 0) goto L_0x003b
            library.talabat.mvp.changepassword.Validator r6 = r7.validator
            boolean r6 = r6.validate(r1)
            if (r6 != 0) goto L_0x0049
            library.talabat.mvp.changepassword.ChangePasswordView r4 = r7.changePasswordView
            r6 = 35
            r4.onValidationError(r6)
            goto L_0x0048
        L_0x003b:
            boolean r6 = r1.equals(r3)
            if (r6 == 0) goto L_0x0049
            library.talabat.mvp.changepassword.ChangePasswordView r4 = r7.changePasswordView
            r6 = 31
            r4.onValidationError(r6)
        L_0x0048:
            r4 = r5
        L_0x0049:
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0057
            library.talabat.mvp.changepassword.ChangePasswordView r3 = r7.changePasswordView
            r4 = 32
            r3.onValidationError(r4)
            goto L_0x0058
        L_0x0057:
            r5 = r4
        L_0x0058:
            if (r5 == 0) goto L_0x0087
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0068
            library.talabat.mvp.changepassword.ChangePasswordView r0 = r7.changePasswordView
            r1 = 34
            r0.onValidationError(r1)
            goto L_0x0087
        L_0x0068:
            boolean r2 = r7.isAdvancedPasswordValidationEnabled()
            if (r2 != 0) goto L_0x007d
            int r2 = r1.length()
            r3 = 6
            if (r2 >= r3) goto L_0x007d
            library.talabat.mvp.changepassword.ChangePasswordView r0 = r7.changePasswordView
            r1 = 33
            r0.onValidationError(r1)
            goto L_0x0087
        L_0x007d:
            library.talabat.mvp.changepassword.ChangePasswordView r2 = r7.changePasswordView
            r2.onValidationSuccess()
            library.talabat.mvp.changepassword.IChangePasswordInteractor r2 = r7.iChangePasswordInteractor
            r2.sendChangePasswordRequest(r0, r1)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.changepassword.ChangePasswordPresenter.validateAndRequest():void");
    }
}
