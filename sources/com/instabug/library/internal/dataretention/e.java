package com.instabug.library.internal.dataretention;

import androidx.annotation.NonNull;

class e extends f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50968a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50969b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50970c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j f50971d;

    public e(String str, String str2, String str3, j jVar) {
        this.f50968a = str;
        this.f50969b = str2;
        this.f50970c = str3;
        this.f50971d = jVar;
    }

    public j b() {
        return this.f50971d;
    }

    @NonNull
    public n c() {
        return new m().a(this.f50968a, this.f50969b, this.f50970c);
    }
}
