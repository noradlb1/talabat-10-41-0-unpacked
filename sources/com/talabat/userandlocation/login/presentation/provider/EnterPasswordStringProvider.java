package com.talabat.userandlocation.login.presentation.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/talabat/userandlocation/login/presentation/provider/EnterPasswordStringProvider;", "", "genericErrorMessage", "", "getGenericErrorMessage", "()Ljava/lang/String;", "invalidCredentialsMessage", "getInvalidCredentialsMessage", "loginSuccessToastMessage", "getLoginSuccessToastMessage", "passwordIsRequired", "getPasswordIsRequired", "passwordLengthIsInvalid", "getPasswordLengthIsInvalid", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface EnterPasswordStringProvider {
    @NotNull
    String getGenericErrorMessage();

    @NotNull
    String getInvalidCredentialsMessage();

    @NotNull
    String getLoginSuccessToastMessage();

    @NotNull
    String getPasswordIsRequired();

    @NotNull
    String getPasswordLengthIsInvalid();
}
