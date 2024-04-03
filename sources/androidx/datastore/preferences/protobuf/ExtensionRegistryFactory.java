package androidx.datastore.preferences.protobuf;

import net.bytebuddy.implementation.auxiliary.TypeProxy;

final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f35768a = b();

    public static boolean a(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = f35768a;
        if (cls == null || !cls.isAssignableFrom(extensionRegistryLite.getClass())) {
            return false;
        }
        return true;
    }

    public static Class<?> b() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static ExtensionRegistryLite create() {
        if (f35768a != null) {
            try {
                return invokeSubclassFactory(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME);
            } catch (Exception unused) {
            }
        }
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        if (f35768a != null) {
            try {
                return invokeSubclassFactory("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return ExtensionRegistryLite.f35769a;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String str) throws Exception {
        return (ExtensionRegistryLite) f35768a.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
