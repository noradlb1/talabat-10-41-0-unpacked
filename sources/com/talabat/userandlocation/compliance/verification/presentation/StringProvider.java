package com.talabat.userandlocation.compliance.verification.presentation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;", "", "continueToCheckoutButtonText", "", "getContinueToCheckoutButtonText", "()Ljava/lang/String;", "createAccountButtonText", "getCreateAccountButtonText", "emailErrorMessage", "getEmailErrorMessage", "existingUserSecondaryTitle", "getExistingUserSecondaryTitle", "existingUserTitle", "getExistingUserTitle", "nameErrorMessage", "getNameErrorMessage", "newUserTitle", "getNewUserTitle", "requiredErrorMessage", "getRequiredErrorMessage", "screenTitle", "getScreenTitle", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StringProvider {
    @NotNull
    String getContinueToCheckoutButtonText();

    @NotNull
    String getCreateAccountButtonText();

    @NotNull
    String getEmailErrorMessage();

    @NotNull
    String getExistingUserSecondaryTitle();

    @NotNull
    String getExistingUserTitle();

    @NotNull
    String getNameErrorMessage();

    @NotNull
    String getNewUserTitle();

    @NotNull
    String getRequiredErrorMessage();

    @NotNull
    String getScreenTitle();
}
