package com.instabug.bug.reportingpromptitems;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.core.plugin.PluginPromptOption;

class d implements PluginPromptOption.OnInvocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f45713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f45714b;

    public d(e eVar, Context context) {
        this.f45714b = eVar;
        this.f45713a = context;
    }

    public void onInvoke(@Nullable Uri uri, String... strArr) {
        this.f45714b.g(this.f45713a, uri, strArr);
    }
}
