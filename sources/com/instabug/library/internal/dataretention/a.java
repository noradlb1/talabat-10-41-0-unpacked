package com.instabug.library.internal.dataretention;

import com.instabug.library.internal.dataretention.core.c;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set f50962a = new HashSet();

    public a a(c cVar) {
        this.f50962a.add(cVar);
        return this;
    }

    public b a() {
        return new b(this.f50962a);
    }
}
