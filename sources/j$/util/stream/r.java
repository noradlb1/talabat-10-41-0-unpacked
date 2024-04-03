package j$.util.stream;

import java.util.HashSet;

final class r extends C0252l2 {

    /* renamed from: b  reason: collision with root package name */
    HashSet f29208b;

    r(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(Object obj) {
        if (!this.f29208b.contains(obj)) {
            this.f29208b.add(obj);
            this.f29177a.accept(obj);
        }
    }

    public final void end() {
        this.f29208b = null;
        this.f29177a.end();
    }

    public final void f(long j11) {
        this.f29208b = new HashSet();
        this.f29177a.f(-1);
    }
}
