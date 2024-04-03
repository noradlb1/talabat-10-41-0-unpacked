package com.deliveryhero.customerchat.commons;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\bJ\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/customerchat/commons/ChatPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preference", "Landroid/content/SharedPreferences;", "getBoolean", "", "key", "", "defaultValue", "getDeviceUUID", "getPermissionDeniedJustNow", "getString", "saveBoolean", "", "value", "saveDeviceUUID", "deviceUUID", "saveString", "setPermissionDeniedJustNow", "isDeniedJustNow", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatPreferences {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DEVICE_UUID = "DEVICE_UUID";
    @NotNull
    private static final String IS_PERMISSION_DENIED_PERMANENTLY_JUST_NOW = "IS_PERMISSION_DENIED_PERMANENTLY_JUST_NOW";
    @NotNull
    private final SharedPreferences preference;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/customerchat/commons/ChatPreferences$Companion;", "", "()V", "DEVICE_UUID", "", "IS_PERMISSION_DENIED_PERMANENTLY_JUST_NOW", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(context)");
        this.preference = defaultSharedPreferences;
    }

    private final boolean getBoolean(String str, boolean z11) {
        return this.preference.getBoolean(str, z11);
    }

    private final String getString(String str, String str2) {
        return this.preference.getString(str, str2);
    }

    private final void saveBoolean(String str, boolean z11) {
        SharedPreferences.Editor edit = this.preference.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean(str, z11);
        edit.apply();
    }

    private final void saveString(String str, String str2) {
        SharedPreferences.Editor edit = this.preference.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putString(str, str2);
        edit.apply();
    }

    @Nullable
    public final String getDeviceUUID() {
        return getString(DEVICE_UUID, (String) null);
    }

    public final boolean getPermissionDeniedJustNow() {
        return getBoolean(IS_PERMISSION_DENIED_PERMANENTLY_JUST_NOW, true);
    }

    public final void saveDeviceUUID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "deviceUUID");
        saveString(DEVICE_UUID, str);
    }

    public final void setPermissionDeniedJustNow(boolean z11) {
        saveBoolean(IS_PERMISSION_DENIED_PERMANENTLY_JUST_NOW, z11);
    }
}
