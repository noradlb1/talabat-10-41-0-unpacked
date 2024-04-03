package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.c0  reason: case insensitive filesystem */
public final /* synthetic */ class C0146c0 implements C0152f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0152f0 f28837a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0152f0 f28838b;

    public /* synthetic */ C0146c0(C0152f0 f0Var, C0152f0 f0Var2) {
        this.f28837a = f0Var;
        this.f28838b = f0Var2;
    }

    public final void accept(long j11) {
        this.f28837a.accept(j11);
        this.f28838b.accept(j11);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }
}
