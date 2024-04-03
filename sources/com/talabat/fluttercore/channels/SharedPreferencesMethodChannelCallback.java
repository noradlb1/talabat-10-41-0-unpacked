package com.talabat.fluttercore.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/fluttercore/channels/SharedPreferencesMethodChannelCallback;", "", "getString", "", "key", "defaultValue", "sharedPreferencesName", "setString", "", "value", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SharedPreferencesMethodChannelCallback {
    @Nullable
    String getString(@NotNull String str, @Nullable String str2, @Nullable String str3);

    void setString(@NotNull String str, @Nullable String str2, @Nullable String str3);
}
