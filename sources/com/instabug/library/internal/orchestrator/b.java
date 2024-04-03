package com.instabug.library.internal.orchestrator;

import androidx.annotation.NonNull;
import com.instabug.library.internal.dataretention.a;
import com.instabug.library.internal.dataretention.core.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class b implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f50993a;

    public b(@NonNull c cVar, @NonNull c... cVarArr) {
        if (cVarArr.length == 0) {
            this.f50993a = Collections.singleton(cVar);
            return;
        }
        LinkedList linkedList = new LinkedList();
        this.f50993a = linkedList;
        linkedList.add(cVar);
        linkedList.addAll(Arrays.asList(cVarArr));
    }

    public void run() {
        a a11 = com.instabug.library.internal.dataretention.b.a();
        for (c a12 : this.f50993a) {
            a11.a(a12);
        }
        a11.a().b().dispose();
    }
}
