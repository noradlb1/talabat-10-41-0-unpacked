package com.talabat.userandlocation.compliance.verification.presentation.impl;

import android.content.res.Resources;
import com.talabat.localization.R;
import com.talabat.userandlocation.compliance.verification.presentation.StringProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/impl/StringProviderImpl;", "Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "continueToCheckoutButtonText", "", "getContinueToCheckoutButtonText", "()Ljava/lang/String;", "createAccountButtonText", "getCreateAccountButtonText", "emailErrorMessage", "getEmailErrorMessage", "existingUserSecondaryTitle", "getExistingUserSecondaryTitle", "existingUserTitle", "getExistingUserTitle", "nameErrorMessage", "getNameErrorMessage", "newUserTitle", "getNewUserTitle", "requiredErrorMessage", "getRequiredErrorMessage", "screenTitle", "getScreenTitle", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringProviderImpl implements StringProvider {
    @NotNull
    private final Resources resources;

    public StringProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    @NotNull
    public String getContinueToCheckoutButtonText() {
        String string = this.resources.getString(R.string.continue_to_checkout);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.continue_to_checkout)");
        return string;
    }

    @NotNull
    public String getCreateAccountButtonText() {
        String string = this.resources.getString(R.string.create_account);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.….R.string.create_account)");
        return string;
    }

    @NotNull
    public String getEmailErrorMessage() {
        String string = this.resources.getString(R.string.email_pattern_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ring.email_pattern_error)");
        return string;
    }

    @NotNull
    public String getExistingUserSecondaryTitle() {
        String string = this.resources.getString(R.string.please_verify_your_identity);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ase_verify_your_identity)");
        return string;
    }

    @NotNull
    public String getExistingUserTitle() {
        String string = this.resources.getString(R.string.welcome_back_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…tring.welcome_back_title)");
        return string;
    }

    @NotNull
    public String getNameErrorMessage() {
        String string = this.resources.getString(R.string.name_length_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.name_length_error)");
        return string;
    }

    @NotNull
    public String getNewUserTitle() {
        String string = this.resources.getString(R.string.create_your_account);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ring.create_your_account)");
        return string;
    }

    @NotNull
    public String getRequiredErrorMessage() {
        String string = this.resources.getString(R.string.required);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…zation.R.string.required)");
        return string;
    }

    @NotNull
    public String getScreenTitle() {
        String string = this.resources.getString(R.string.welcome_to_talabat);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…tring.welcome_to_talabat)");
        return string;
    }
}
