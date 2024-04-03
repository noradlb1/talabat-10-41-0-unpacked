package com.instabug.featuresrequest.ui.base.featureslist;

import android.os.Handler;
import android.os.Looper;
import com.instabug.featuresrequest.models.d;
import io.reactivex.functions.Consumer;

class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f46656b;

    public m(n nVar) {
        this.f46656b = nVar;
    }

    /* renamed from: a */
    public void accept(d dVar) {
        if (this.f46656b.f46659g.b() != null && !this.f46656b.f46659g.b().isEmpty()) {
            new Handler(Looper.getMainLooper()).postDelayed(new l(this), 1000);
        }
    }
}
