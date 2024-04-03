package com.instabug.bug.reportingpromptitems;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;

class a implements PluginPromptOption.OnInvocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f45711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f45712b;

    public a(b bVar, Context context) {
        this.f45712b = bVar;
        this.f45711a = context;
    }

    public void onInvoke(@Nullable Uri uri, String... strArr) {
        this.f45712b.g(this.f45711a, uri, strArr);
    }
}
