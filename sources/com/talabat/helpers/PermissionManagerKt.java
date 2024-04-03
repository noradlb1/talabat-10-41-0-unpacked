package com.talabat.helpers;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.EventType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zr.o;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "Landroidx/appcompat/app/AppCompatActivity;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PermissionManagerKt {
    @NotNull
    public static final ActivityResultLauncher<String> notificationPermissionLauncher(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        ActivityResultLauncher<String> registerForActivityResult = appCompatActivity.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new o());
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…        )\n        }\n    }");
        return registerForActivityResult;
    }

    /* access modifiers changed from: private */
    /* renamed from: notificationPermissionLauncher$lambda-0  reason: not valid java name */
    public static final void m10625notificationPermissionLauncher$lambda0(boolean z11) {
        if (!z11) {
            ObservabilityManager.trackEvent("push_notification_permission_opt_out", EventType.UnExpectedScenario.name(), (Map<String, String>) MapsKt__MapsKt.emptyMap());
        }
    }
}
