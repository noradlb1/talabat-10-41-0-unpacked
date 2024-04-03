package com.instabug.library.sessionV3.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import com.instabug.library.internal.sharedpreferences.PreferencesProperty;
import com.instabug.library.settings.SettingsManager;
import org.jetbrains.annotations.Nullable;

public final class a extends PreferencesProperty {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f51788b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, Object obj) {
        super(str, obj);
        this.f51788b = obj;
    }

    @Nullable
    public SharedPreferences getPref() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return CoreServiceLocator.getInstabugSharedPreferences(applicationContext, SettingsManager.INSTABUG_SHARED_PREF_NAME);
    }
}
