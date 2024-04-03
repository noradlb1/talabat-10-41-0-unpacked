package com.instabug.library.instacapture;

import android.graphics.Bitmap;
import com.instabug.library.instacapture.listener.a;
import io.reactivex.functions.Consumer;

class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f34372b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f34373c;

    public b(d dVar, a aVar) {
        this.f34373c = dVar;
        this.f34372b = aVar;
    }

    /* renamed from: a */
    public void accept(Bitmap bitmap) throws Exception {
        a aVar = this.f34372b;
        if (aVar != null) {
            aVar.a(bitmap);
        }
        this.f34373c.a(this.f34372b);
        this.f34373c.b();
    }
}
