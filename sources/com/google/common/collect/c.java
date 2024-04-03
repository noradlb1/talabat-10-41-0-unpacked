package com.google.common.collect;

import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f44644b;

    public /* synthetic */ c(Comparator comparator) {
        this.f44644b = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f44644b.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
