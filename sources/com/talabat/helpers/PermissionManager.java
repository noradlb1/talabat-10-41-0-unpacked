package com.talabat.helpers;

import androidx.activity.result.ActivityResultLauncher;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/helpers/PermissionManager;", "", "()V", "requestPermission", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "permission", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionManager {
    @NotNull
    public static final PermissionManager INSTANCE = new PermissionManager();

    private PermissionManager() {
    }

    public final void requestPermission(@NotNull ActivityResultLauncher<String> activityResultLauncher, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "permissionLauncher");
        Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
        activityResultLauncher.launch(str);
    }
}
