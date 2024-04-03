package j$.util;

import j$.util.function.Function;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: j$.util.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0114c implements Comparator, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28604a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f28605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f28606c;

    public /* synthetic */ C0114c(Comparator comparator, Object obj, int i11) {
        this.f28604a = i11;
        this.f28605b = comparator;
        this.f28606c = obj;
    }

    public final int compare(Object obj, Object obj2) {
        int i11 = this.f28604a;
        Comparator comparator = this.f28605b;
        Object obj3 = this.f28606c;
        switch (i11) {
            case 0:
                Comparator comparator2 = (Comparator) obj3;
                int compare = comparator.compare(obj, obj2);
                return compare != 0 ? compare : comparator2.compare(obj, obj2);
            default:
                Function function = (Function) obj3;
                return comparator.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
