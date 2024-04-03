package com.instabug.library.ui.promptoptions;

import android.app.Activity;
import android.net.Uri;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;
import java.util.ArrayList;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f51988b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51989c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Uri f51990d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArrayList f51991e;

    public a(b bVar, Activity activity, String str, Uri uri, ArrayList arrayList) {
        this.f51988b = activity;
        this.f51989c = str;
        this.f51990d = uri;
        this.f51991e = arrayList;
    }

    public void run() {
        this.f51988b.startActivity(InstabugDialogActivity.getIntent(this.f51988b, this.f51989c, this.f51990d, this.f51991e, false));
    }
}
