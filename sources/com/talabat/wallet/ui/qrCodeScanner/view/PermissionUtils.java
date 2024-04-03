package com.talabat.wallet.ui.qrCodeScanner.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.ActivityCompat;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/view/PermissionUtils;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/view/PermissionUtils$Companion;", "", "()V", "getRationaleDisplayStatus", "", "context", "Landroid/content/Context;", "permission", "", "neverAskAgainSelected", "activity", "Landroid/app/Activity;", "setShouldShowStatus", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getRationaleDisplayStatus(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
            return context.getSharedPreferences("CAMERA_PREFERENCES", 0).getBoolean(str, false);
        }

        public final boolean neverAskAgainSelected(@Nullable Activity activity, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
            if (activity == null || PermissionUtils.Companion.getRationaleDisplayStatus(activity, str) == ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
            return true;
        }

        public final void setShouldShowStatus(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
            SharedPreferences.Editor edit = context.getSharedPreferences("CAMERA_PREFERENCES", 0).edit();
            edit.putBoolean(str, true);
            edit.apply();
        }
    }
}
