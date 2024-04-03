package com.instabug.library.invocation;

import android.net.Uri;
import com.instabug.library.core.InitialScreenshotHelper;
import com.instabug.library.core.plugin.PluginPromptOption;

class c implements InitialScreenshotHelper.InitialScreenshotCapturingListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginPromptOption f51286a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f51287b;

    public c(d dVar, PluginPromptOption pluginPromptOption) {
        this.f51287b = dVar;
        this.f51286a = pluginPromptOption;
    }

    public void onScreenshotCapturedSuccessfully(Uri uri) {
        this.f51287b.c(uri, this.f51286a);
    }

    public void onScreenshotCapturingFailed(Throwable th2) {
        this.f51287b.c((Uri) null, this.f51286a);
    }
}
