package com.instabug.library.internal.dataretention;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.List;

class l extends n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50982a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50983b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50984c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f50985d;

    public l(m mVar, String str, String str2, String str3) {
        this.f50985d = mVar;
        this.f50982a = str;
        this.f50983b = str2;
        this.f50984c = str3;
    }

    @WorkerThread
    @NonNull
    public List a() {
        return this.f50985d.b(this.f50982a, this.f50983b, this.f50984c);
    }

    @NonNull
    public String b() {
        return this.f50982a;
    }
}
