package com.talabat.feature.tpro.presentation.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "getSubscriptionStatus", "", "getUserStatus", "isSubscribed", "", "resetSubscriptionStatus", "", "resetUserStatus", "saveSubscriptionStatus", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionSharedPrefManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String STATUS = "tpro_payment_result";
    @NotNull
    public static final String SUBSCRIBED_SUCCESS_REFRESH = "success_refresh";
    @NotNull
    public static final String SUBSCRIPTION_STATUS = "tpro_subscription_state";
    @Nullable
    private SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager$Companion;", "", "()V", "STATUS", "", "SUBSCRIBED_SUCCESS_REFRESH", "SUBSCRIPTION_STATUS", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SubscriptionSharedPrefManager(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences(SharedPreferencesManager.TALABAT_PREFERENCE, 0);
    }

    private final String getSubscriptionStatus() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString(SUBSCRIPTION_STATUS, "") : null;
        return string == null ? "" : string;
    }

    @Nullable
    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    @NotNull
    public final String getUserStatus() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString(STATUS, "") : null;
        return string == null ? "" : string;
    }

    public final boolean isSubscribed() {
        return Intrinsics.areEqual((Object) getSubscriptionStatus(), (Object) SUBSCRIBED_SUCCESS_REFRESH);
    }

    public final void resetSubscriptionStatus() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            Intrinsics.checkNotNullExpressionValue(edit, "editor");
            edit.putString(SUBSCRIPTION_STATUS, "");
            edit.apply();
        }
    }

    public final void resetUserStatus() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            Intrinsics.checkNotNullExpressionValue(edit, "editor");
            edit.putString(STATUS, "");
            edit.apply();
        }
    }

    public final void saveSubscriptionStatus() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            Intrinsics.checkNotNullExpressionValue(edit, "editor");
            edit.putString(SUBSCRIPTION_STATUS, SUBSCRIBED_SUCCESS_REFRESH);
            edit.apply();
        }
    }

    public final void setSharedPreferences(@Nullable SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }
}
