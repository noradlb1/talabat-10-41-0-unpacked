package net.bytebuddy.dynamic;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Nexus extends WeakReference<ClassLoader> {
    private static final ReferenceQueue<ClassLoader> NO_QUEUE = null;
    public static final String PROPERTY = "net.bytebuddy.nexus.disabled";
    private static final ConcurrentMap<Nexus, Object> TYPE_INITIALIZERS = new ConcurrentHashMap();
    private final int classLoaderHashCode;
    private final int identification;

    /* renamed from: name  reason: collision with root package name */
    private final String f27174name;

    private Nexus(Class<?> cls, int i11) {
        this(nonAnonymous(cls.getName()), cls.getClassLoader(), NO_QUEUE, i11);
    }

    public static void clean(Reference<? super ClassLoader> reference) {
        TYPE_INITIALIZERS.remove(reference);
    }

    public static void initialize(Class<?> cls, int i11) throws Exception {
        Object remove = TYPE_INITIALIZERS.remove(new Nexus(cls, i11));
        if (remove != null) {
            Class.forName("net.bytebuddy.implementation.LoadedTypeInitializer", true, remove.getClass().getClassLoader()).getMethod("onLoad", new Class[]{Class.class}).invoke(remove, new Object[]{cls});
        }
    }

    private static String nonAnonymous(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static void register(String str, ClassLoader classLoader, ReferenceQueue<? super ClassLoader> referenceQueue, int i11, Object obj) {
        TYPE_INITIALIZERS.put(new Nexus(str, classLoader, referenceQueue, i11), obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nexus nexus = (Nexus) obj;
        if (this.classLoaderHashCode == nexus.classLoaderHashCode && this.identification == nexus.identification && this.f27174name.equals(nexus.f27174name) && get() == nexus.get()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f27174name.hashCode() * 31) + this.classLoaderHashCode) * 31) + this.identification;
    }

    public String toString() {
        return "Nexus{name='" + this.f27174name + '\'' + ", classLoaderHashCode=" + this.classLoaderHashCode + ", identification=" + this.identification + ", classLoader=" + get() + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Nexus(String str, ClassLoader classLoader, ReferenceQueue<? super ClassLoader> referenceQueue, int i11) {
        super(classLoader, classLoader == null ? null : referenceQueue);
        this.f27174name = str;
        this.classLoaderHashCode = System.identityHashCode(classLoader);
        this.identification = i11;
    }
}
