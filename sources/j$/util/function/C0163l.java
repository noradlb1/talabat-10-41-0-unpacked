package j$.util.function;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.function.l  reason: case insensitive filesystem */
public final /* synthetic */ class C0163l implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0165m f28854a;

    private /* synthetic */ C0163l(C0165m mVar) {
        this.f28854a = mVar;
    }

    public static /* synthetic */ DoubleConsumer a(C0165m mVar) {
        if (mVar == null) {
            return null;
        }
        return mVar instanceof C0161k ? ((C0161k) mVar).f28852a : new C0163l(mVar);
    }

    public final /* synthetic */ void accept(double d11) {
        this.f28854a.accept(d11);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a(this.f28854a.m(C0161k.a(doubleConsumer)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0165m mVar = this.f28854a;
        if (obj instanceof C0163l) {
            obj = ((C0163l) obj).f28854a;
        }
        return mVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28854a.hashCode();
    }
}
