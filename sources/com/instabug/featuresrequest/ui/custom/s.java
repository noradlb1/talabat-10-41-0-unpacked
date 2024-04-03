package com.instabug.featuresrequest.ui.custom;

import java.lang.ref.WeakReference;

class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f46723a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f46724b;

    public s(int i11, r rVar) {
        this.f46723a = new WeakReference(rVar);
        this.f46724b = i11;
    }

    public boolean c(r rVar) {
        return rVar != null && this.f46723a.get() == rVar;
    }
}
