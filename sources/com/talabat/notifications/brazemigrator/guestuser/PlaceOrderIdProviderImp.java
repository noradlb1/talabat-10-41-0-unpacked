package com.talabat.notifications.brazemigrator.guestuser;

import android.app.Application;
import android.content.SharedPreferences;
import com.talabat.notifications.brazemigrator.BrazeUserMigratorConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.checkout.PlaceOrderUIDProvider;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/PlaceOrderIdProviderImp;", "Llibrary/talabat/mvp/checkout/PlaceOrderUIDProvider;", "applicationContext", "Landroid/app/Application;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/app/Application;Landroid/content/SharedPreferences;)V", "getOrderId", "", "providePlaceOrderUID", "isQuickUser", "", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlaceOrderIdProviderImp implements PlaceOrderUIDProvider {
    @NotNull
    private final Application applicationContext;
    @NotNull
    private final SharedPreferences preferences;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlaceOrderIdProviderImp(@NotNull Application application) {
        this(application, (SharedPreferences) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(application, "applicationContext");
    }

    @JvmOverloads
    public PlaceOrderIdProviderImp(@NotNull Application application, @NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        this.applicationContext = application;
        this.preferences = sharedPreferences;
    }

    private final String getOrderId() {
        return this.preferences.getString(BrazeUserMigratorConfig.APP_BOY_USER_ID_KEY, "");
    }

    @NotNull
    public String providePlaceOrderUID(boolean z11) {
        return String.valueOf(getOrderId());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PlaceOrderIdProviderImp(android.app.Application r1, android.content.SharedPreferences r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0010
            java.lang.String r2 = "talabat"
            r3 = 0
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r3)
            java.lang.String r3 = "applicationContext.getSh…ontext.MODE_PRIVATE\n    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0010:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.notifications.brazemigrator.guestuser.PlaceOrderIdProviderImp.<init>(android.app.Application, android.content.SharedPreferences, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
