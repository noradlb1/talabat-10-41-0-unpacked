package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

public final /* synthetic */ class C3 implements C0152f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28906a;

    public /* synthetic */ C3(int i11) {
        this.f28906a = i11;
    }

    public final void accept(long j11) {
    }

    public final C0152f0 i(C0152f0 f0Var) {
        switch (this.f28906a) {
            case 0:
                Objects.requireNonNull(f0Var);
                return new C0146c0(this, f0Var);
            default:
                Objects.requireNonNull(f0Var);
                return new C0146c0(this, f0Var);
        }
    }
}
