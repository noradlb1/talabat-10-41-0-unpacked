package g30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f62075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Extension f62077c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f62078d;

    public /* synthetic */ b(MutableExtensionRegistry mutableExtensionRegistry, String str, Extension extension, Object obj) {
        this.f62075a = mutableExtensionRegistry;
        this.f62076b = str;
        this.f62077c = extension;
        this.f62078d = obj;
    }

    public final Object get() {
        return this.f62075a.lambda$registerExtension$0(this.f62076b, this.f62077c, this.f62078d);
    }
}
