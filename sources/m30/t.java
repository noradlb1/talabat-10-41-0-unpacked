package m30;

import j$.util.function.Supplier;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26884a;

    public /* synthetic */ t(String str) {
        this.f26884a = str;
    }

    public final Object get() {
        return String.format("Tag name [%s] must be syntactically valid", new Object[]{this.f26884a});
    }
}
