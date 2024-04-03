package com.instabug.library.networkv2.service.userattributes;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.model.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final e f51706a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f51707b;

    public g(e eVar, b bVar) {
        this.f51706a = eVar;
        this.f51707b = bVar;
    }

    @VisibleForTesting
    public List b(List list, String str, boolean z11, int i11) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((l) it.next()).a().a(z11).a(str).a(i11).a());
        }
        return arrayList;
    }

    public void c(String str, String str2) {
        this.f51706a.b(this.f51706a.a(str2), new f(this, str));
    }
}
