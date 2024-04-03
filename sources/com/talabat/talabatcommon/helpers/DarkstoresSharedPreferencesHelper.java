package com.talabat.talabatcommon.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/helpers/DarkstoresSharedPreferencesHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "resetDsCart", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresSharedPreferencesHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PREFERENCES_NAME = "darkstores_preferences";
    @NotNull
    private static final String RESET_DS_CART = "reset_ds_cart";
    @NotNull
    private final Context context;
    @Nullable
    private SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/helpers/DarkstoresSharedPreferencesHelper$Companion;", "", "()V", "PREFERENCES_NAME", "", "RESET_DS_CART", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DarkstoresSharedPreferencesHelper(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.sharedPreferences = context2.getSharedPreferences(PREFERENCES_NAME, 0);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public final void resetDsCart() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        if (sharedPreferences2 != null) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            Intrinsics.checkNotNullExpressionValue(edit, "editor");
            edit.putBoolean(RESET_DS_CART, true);
            edit.apply();
        }
    }

    public final void setSharedPreferences(@Nullable SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }
}
