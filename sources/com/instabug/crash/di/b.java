package com.instabug.crash.di;

import android.content.SharedPreferences;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import org.jetbrains.annotations.Nullable;

public final class b extends PreferencesProperty {
    public b(String str, Object obj) {
        super(str, obj);
    }

    @Nullable
    public SharedPreferences getPref() {
        return d.f46399a.d();
    }
}
