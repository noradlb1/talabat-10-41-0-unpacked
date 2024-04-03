package z20;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class d {
    @API(since = "5.1", status = API.Status.STABLE)
    public static Object a(ExtensionContext.Store store, Class cls) {
        return store.getOrComputeIfAbsent(cls, new c(), cls);
    }

    @API(since = "5.5", status = API.Status.STABLE)
    public static Object b(ExtensionContext.Store store, Object obj, Class cls, Object obj2) {
        Object obj3 = store.get(obj, cls);
        return obj3 != null ? obj3 : obj2;
    }
}
