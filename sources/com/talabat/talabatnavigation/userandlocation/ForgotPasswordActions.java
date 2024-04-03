package com.talabat.talabatnavigation.userandlocation;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatnavigation/userandlocation/ForgotPasswordActions;", "", "()V", "ACTION_OPEN_SCREEN", "", "createOpenScreenModel", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ForgotPasswordActions {
    @NotNull
    private static final String ACTION_OPEN_SCREEN = "talabat.action.userandlocation.ForgotPassword";
    @NotNull
    public static final ForgotPasswordActions INSTANCE = new ForgotPasswordActions();

    private ForgotPasswordActions() {
    }

    @NotNull
    public final NavigatorModel createOpenScreenModel() {
        return new NavigatorModel(ACTION_OPEN_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }
}
