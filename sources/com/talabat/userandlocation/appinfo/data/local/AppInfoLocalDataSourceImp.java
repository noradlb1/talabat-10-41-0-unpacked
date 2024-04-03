package com.talabat.userandlocation.appinfo.data.local;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSourceImp;", "Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSource;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "invalidateAppInfoCash", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoLocalDataSourceImp implements AppInfoLocalDataSource {
    @NotNull
    private final SharedPreferences sharedPreferences;

    public AppInfoLocalDataSourceImp() {
        this((SharedPreferences) null, 1, (DefaultConstructorMarker) null);
    }

    public AppInfoLocalDataSourceImp(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    public void invalidateAppInfoCash() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.remove("appInfoPreferenceKey");
        edit.apply();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppInfoLocalDataSourceImp(android.content.SharedPreferences r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0016
            android.app.Application r1 = com.talabat.lib.Integration.getAppContext()
            java.lang.String r2 = com.talabat.helpers.GlobalConstants.PrefsConstants.getNAME()
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            java.lang.String r2 = "getAppContext().getShare…(), Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0016:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSourceImp.<init>(android.content.SharedPreferences, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
