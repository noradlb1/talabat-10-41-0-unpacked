package com.talabat.helpers;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.helpers.GlobalConstants;
import datamodels.Token;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/helpers/SetAppBrandPrefValues;", "", "()V", "setUserTokenIfLoggedIn", "", "context", "Landroid/content/Context;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetAppBrandPrefValues {
    @NotNull
    public static final SetAppBrandPrefValues INSTANCE = new SetAppBrandPrefValues();

    private SetAppBrandPrefValues() {
    }

    public final void setUserTokenIfLoggedIn(@Nullable Context context) {
        SharedPreferences sharedPreferences;
        Object obj;
        if (GlobalDataModel.token == null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            boolean z11 = false;
            String str = null;
            if (context != null) {
                sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
            } else {
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                str = sharedPreferences.getString(LegacyTokenLocalDataSourceImpl.KEY, "");
            }
            if (str == null || str.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                Class cls = Token.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str, cls);
                }
                GlobalDataModel.token = (Token) obj;
            }
        }
    }
}
