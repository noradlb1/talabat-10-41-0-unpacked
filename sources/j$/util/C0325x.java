package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/* renamed from: j$.util.x  reason: case insensitive filesystem */
final class C0325x extends X {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ SortedSet f29299f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0325x(SortedSet sortedSet, Collection collection) {
        super(21, collection);
        this.f29299f = sortedSet;
    }

    public final Comparator getComparator() {
        return this.f29299f.comparator();
    }
}
