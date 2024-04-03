package com.talabat.talabatnavigation.userandlocation;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatnavigation/userandlocation/ComplianceVerificationActions;", "", "()V", "ACTION_OPEN_SCREEN", "", "createOpenScreenModelForResult", "Lcom/talabat/talabatnavigation/base/NavigatorModelForResult;", "requestCode", "", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationActions {
    @NotNull
    private static final String ACTION_OPEN_SCREEN = "talabat.action.userandlocation.compliance.verification";
    @NotNull
    public static final ComplianceVerificationActions INSTANCE = new ComplianceVerificationActions();

    private ComplianceVerificationActions() {
    }

    @NotNull
    public final NavigatorModelForResult createOpenScreenModelForResult(int i11) {
        return new NavigatorModelForResult(ACTION_OPEN_SCREEN, (Bundle) null, (Function1) null, i11, 6, (DefaultConstructorMarker) null);
    }
}
