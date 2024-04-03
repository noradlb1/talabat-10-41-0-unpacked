package com.instabug.library.util;

import android.net.Uri;
import com.instabug.library.util.BitmapUtils;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f52061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f52062c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BitmapUtils.g f52063d;

    public f(BitmapUtils.g gVar, boolean z11, Uri uri) {
        this.f52063d = gVar;
        this.f52061b = z11;
        this.f52062c = uri;
    }

    public void run() {
        BitmapUtils.OnSaveBitmapCallback onSaveBitmapCallback;
        if (this.f52061b && (onSaveBitmapCallback = this.f52063d.f52042e) != null) {
            onSaveBitmapCallback.onSuccess(this.f52062c);
        }
    }
}
