package com.talabat.core.flutter.channels.impl.data.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/sharedprefs/SharedPreferencesChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/sharedprefs/SharedPreferencesChannelCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSharedPreferences", "Landroid/content/SharedPreferences;", "name", "", "getString", "key", "defaultValue", "sharedPreferencesName", "setString", "", "value", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SharedPreferencesChannelCallbackImpl implements SharedPreferencesChannelCallback {
    @NotNull
    private final Context context;

    @Inject
    public SharedPreferencesChannelCallbackImpl(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final SharedPreferences getSharedPreferences(String str) {
        Context context2 = this.context;
        if (str == null) {
            str = SharedPreferencesManager.TALABAT_PREFERENCE;
        }
        SharedPreferences sharedPreferences = context2.getSharedPreferences(str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        return sharedPreferences;
    }

    @Nullable
    public String getString(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getSharedPreferences(str3).getString(str, str2);
    }

    public void setString(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "key");
        getSharedPreferences(str3).edit().putString(str, str2).commit();
    }
}
