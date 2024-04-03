package com.talabat.userandlocation.login.presentation.provider.impl;

import android.content.res.Resources;
import com.talabat.localization.R;
import com.talabat.userandlocation.login.presentation.provider.EnterEmailStringProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/login/presentation/provider/impl/EnterEmailStringProviderImpl;", "Lcom/talabat/userandlocation/login/presentation/provider/EnterEmailStringProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "emailFormatIsInvalid", "", "getEmailFormatIsInvalid", "()Ljava/lang/String;", "emailIsRequired", "getEmailIsRequired", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailStringProviderImpl implements EnterEmailStringProvider {
    @NotNull
    private final Resources resources;

    public EnterEmailStringProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    @NotNull
    public String getEmailFormatIsInvalid() {
        String string = this.resources.getString(R.string.enter_valid_email);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.enter_valid_email)");
        return string;
    }

    @NotNull
    public String getEmailIsRequired() {
        String string = this.resources.getString(R.string.required);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…zation.R.string.required)");
        return string;
    }
}
