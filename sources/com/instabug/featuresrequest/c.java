package com.instabug.featuresrequest;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.featuresrequest.settings.a;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final CompositeDisposable f46517a = new CompositeDisposable();

    public static long a() {
        return a.a().b();
    }

    @Nullable
    private static String a(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REQUEST_FEATURE_DESCRIPTION, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.ib_fr_request_feature_description, context));
    }

    public static ArrayList b(Context context) {
        ArrayList arrayList = new ArrayList(1);
        if (a.a().e()) {
            PluginPromptOption pluginPromptOption = new PluginPromptOption();
            pluginPromptOption.setInvocationMode(5);
            pluginPromptOption.setPromptOptionIdentifier(5);
            pluginPromptOption.setOrder(3);
            pluginPromptOption.setIcon(R.drawable.ibg_core_ic_request_feature);
            pluginPromptOption.setTitle(c(context));
            pluginPromptOption.setDescription(a(context));
            pluginPromptOption.setOnInvocationListener(new b(context));
            arrayList.add(pluginPromptOption);
        }
        return arrayList;
    }

    public static void b() {
        f46517a.clear();
    }

    @Nullable
    private static String c(Context context) {
        return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REQUEST_FEATURE, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.instabug_str_request_feature, context));
    }

    public static void d(Context context) {
        com.instabug.featuresrequest.settings.c.a(context);
    }
}
