package j$.util.stream;

import j$.util.Optional;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;

final class I1 implements S1 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f28940a;

    /* renamed from: b  reason: collision with root package name */
    private Object f28941b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f28942c;

    I1(BinaryOperator binaryOperator) {
        this.f28942c = binaryOperator;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final void accept(Object obj) {
        if (this.f28940a) {
            this.f28940a = false;
        } else {
            obj = this.f28942c.apply(this.f28941b, obj);
        }
        this.f28941b = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f28940a = true;
        this.f28941b = null;
    }

    public final Object get() {
        return this.f28940a ? Optional.empty() : Optional.of(this.f28941b);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        I1 i12 = (I1) s12;
        if (!i12.f28940a) {
            accept(i12.f28941b);
        }
    }
}
