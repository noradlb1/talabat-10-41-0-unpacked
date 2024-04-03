package com.talabat.userandlocation.login.presentation.provider.impl;

import android.content.res.Resources;
import com.talabat.localization.R;
import com.talabat.userandlocation.login.presentation.provider.EnterPasswordStringProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/userandlocation/login/presentation/provider/impl/EnterPasswordStringProviderImpl;", "Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "genericErrorMessage", "", "getGenericErrorMessage", "()Ljava/lang/String;", "invalidCredentialsMessage", "getInvalidCredentialsMessage", "loginSuccessToastMessage", "getLoginSuccessToastMessage", "passwordIsRequired", "getPasswordIsRequired", "passwordLengthIsInvalid", "getPasswordLengthIsInvalid", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterPasswordStringProviderImpl implements EnterPasswordStringProvider {
    @NotNull
    private final Resources resources;

    public EnterPasswordStringProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    @NotNull
    public String getGenericErrorMessage() {
        String string = this.resources.getString(R.string.sorry_something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
        return string;
    }

    @NotNull
    public String getInvalidCredentialsMessage() {
        String string = this.resources.getString(R.string.invalid_credentials_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…redentials_error_message)");
        return string;
    }

    @NotNull
    public String getLoginSuccessToastMessage() {
        String string = this.resources.getString(R.string.logged_in);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ation.R.string.logged_in)");
        return string;
    }

    @NotNull
    public String getPasswordIsRequired() {
        String string = this.resources.getString(R.string.required);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…zation.R.string.required)");
        return string;
    }

    @NotNull
    public String getPasswordLengthIsInvalid() {
        String string = this.resources.getString(R.string.enter_min_six_characters);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…enter_min_six_characters)");
        return string;
    }
}
