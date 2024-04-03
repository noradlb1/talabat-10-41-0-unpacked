package n30;

import j$.util.function.Supplier;
import org.junit.platform.engine.discovery.FilePosition;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26901a;

    public /* synthetic */ i(String str) {
        this.f26901a = str;
    }

    public final Object get() {
        return FilePosition.lambda$fromQuery$0(this.f26901a);
    }
}
