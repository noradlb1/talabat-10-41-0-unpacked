package com.instabug.library.internal.dataretention.files;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.dataretention.core.b;
import com.instabug.library.internal.dataretention.core.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class d extends c {
    public d(@NonNull e eVar) {
        super(eVar);
    }

    public static d b() {
        return new d(new e());
    }

    @NonNull
    public Collection a() {
        LinkedList linkedList = new LinkedList();
        for (c b11 : this.f50965a.a()) {
            linkedList.addAll(b(b11));
        }
        return linkedList;
    }

    @VisibleForTesting
    @NonNull
    public Collection c(j jVar, b bVar) {
        Collection a11 = jVar.a();
        if (bVar.b()) {
            return d(a11);
        }
        return d(new HashSet(e(a11, bVar.a())));
    }

    @NonNull
    public Collection d(Collection collection) {
        LinkedList linkedList = new LinkedList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedList.add(new a((f) it.next()));
        }
        return linkedList;
    }

    @VisibleForTesting
    @NonNull
    public Collection e(Collection collection, long j11) {
        LinkedList linkedList = new LinkedList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.b() > j11) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    @VisibleForTesting
    @NonNull
    public Collection b(c cVar) {
        return c(cVar.b(), cVar.a());
    }
}
