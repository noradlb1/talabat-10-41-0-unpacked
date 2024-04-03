package j$.util.stream;

import j$.util.Collection;
import j$.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

final class L2 extends D2 {

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f28971d;

    L2(C0272p2 p2Var, Comparator comparator) {
        super(p2Var, comparator);
    }

    public final void accept(Object obj) {
        this.f28971d.add(obj);
    }

    public final void end() {
        List.EL.sort(this.f28971d, this.f28913b);
        C0272p2 p2Var = this.f29177a;
        p2Var.f((long) this.f28971d.size());
        if (!this.f28914c) {
            ArrayList<Object> arrayList = this.f28971d;
            C0194a aVar = new C0194a(5, p2Var);
            if (arrayList instanceof Collection) {
                ((Collection) arrayList).forEach(aVar);
            } else {
                for (Object accept : arrayList) {
                    aVar.accept(accept);
                }
            }
        } else {
            Iterator it = this.f28971d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (p2Var.h()) {
                    break;
                }
                p2Var.accept(next);
            }
        }
        p2Var.end();
        this.f28971d = null;
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28971d = j11 >= 0 ? new ArrayList((int) j11) : new ArrayList();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
