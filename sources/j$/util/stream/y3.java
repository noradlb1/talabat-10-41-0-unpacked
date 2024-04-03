package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

public final /* synthetic */ class y3 implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29284a;

    public /* synthetic */ y3(int i11) {
        this.f29284a = i11;
    }

    public final void accept(double d11) {
    }

    public final C0165m m(C0165m mVar) {
        switch (this.f29284a) {
            case 0:
                Objects.requireNonNull(mVar);
                return new C0159j(this, mVar);
            default:
                Objects.requireNonNull(mVar);
                return new C0159j(this, mVar);
        }
    }
}
