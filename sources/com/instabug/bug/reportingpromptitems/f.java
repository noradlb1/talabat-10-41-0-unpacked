package com.instabug.bug.reportingpromptitems;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;

class f implements PluginPromptOption.OnInvocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f45715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f45716b;

    public f(g gVar, Context context) {
        this.f45716b = gVar;
        this.f45715a = context;
    }

    public void onInvoke(@Nullable Uri uri, String... strArr) {
        this.f45716b.g(this.f45715a, uri, strArr);
    }
}
