package j$.util.function;

import java.util.Objects;

/* renamed from: j$.util.function.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0159j implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0165m f28849a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0165m f28850b;

    public /* synthetic */ C0159j(C0165m mVar, C0165m mVar2) {
        this.f28849a = mVar;
        this.f28850b = mVar2;
    }

    public final void accept(double d11) {
        this.f28849a.accept(d11);
        this.f28850b.accept(d11);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }
}
