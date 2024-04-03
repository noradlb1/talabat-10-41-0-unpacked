package com.instabug.library.internal.dataretention;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.core.plugin.c;
import com.instabug.library.internal.dataretention.core.d;
import com.instabug.library.internal.dataretention.core.e;
import com.instabug.library.user.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public final class b {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Set f50963a;

    public b(Set set) {
        this.f50963a = set;
    }

    public static a a() {
        return new a();
    }

    @Deprecated
    public static d c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f.d());
        arrayList.addAll(c.b());
        return new d(arrayList);
    }

    @WorkerThread
    @NonNull
    public e b() {
        LinkedList linkedList = new LinkedList();
        for (com.instabug.library.internal.dataretention.core.c a11 : this.f50963a) {
            linkedList.addAll(a11.a());
        }
        return new d(linkedList);
    }
}
