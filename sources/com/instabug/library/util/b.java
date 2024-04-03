package com.instabug.library.util;

import android.net.Uri;
import com.instabug.library.util.BitmapUtils;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f52052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f52053c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BitmapUtils.c f52054d;

    public b(BitmapUtils.c cVar, boolean z11, Uri uri) {
        this.f52054d = cVar;
        this.f52052b = z11;
        this.f52053c = uri;
    }

    public void run() {
        Uri uri;
        if (!this.f52052b || (uri = this.f52053c) == null) {
            this.f52054d.f52028d.onError(new Throwable("Uri equal null"));
        } else {
            this.f52054d.f52028d.onSuccess(uri);
        }
    }
}
