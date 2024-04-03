package net.bytebuddy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AnnotatedElement;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public class JavaModule implements NamedElement.WithOptionalName, AnnotationSource {
    private static final boolean ACCESS_CONTROLLER;
    public static final JavaModule UNSUPPORTED = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Resolver f27510b = ((Resolver) doPrivileged(JavaDispatcher.of(Resolver.class)));

    /* renamed from: c  reason: collision with root package name */
    public static final Module f27511c = ((Module) doPrivileged(JavaDispatcher.of(Module.class)));
    private final AnnotatedElement module;

    @JavaDispatcher.Proxied("java.lang.Module")
    public interface Module {
        @JavaDispatcher.Proxied("canRead")
        boolean canRead(Object obj, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        @JavaDispatcher.Proxied("getClassLoader")
        ClassLoader getClassLoader(Object obj);

        @JavaDispatcher.Proxied("getName")
        String getName(Object obj);

        @JavaDispatcher.Proxied("getResourceAsStream")
        InputStream getResourceAsStream(Object obj, String str) throws IOException;

        @JavaDispatcher.Proxied("isExported")
        boolean isExported(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);

        @JavaDispatcher.Proxied("isInstance")
        @JavaDispatcher.Instance
        boolean isInstance(Object obj);

        @JavaDispatcher.Proxied("isNamed")
        boolean isNamed(Object obj);

        @JavaDispatcher.Proxied("isOpen")
        boolean isOpen(Object obj, String str, @JavaDispatcher.Proxied("java.lang.Module") Object obj2);
    }

    @JavaDispatcher.Proxied("java.lang.Class")
    public interface Resolver {
        @JavaDispatcher.Proxied("getModule")
        @JavaDispatcher.Defaults
        Object getModule(Class<?> cls);
    }

    static {
        boolean z11 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z11 = true;
        }
        ACCESS_CONTROLLER = z11;
    }

    public JavaModule(AnnotatedElement annotatedElement) {
        this.module = annotatedElement;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        if (ACCESS_CONTROLLER) {
            return AccessController.doPrivileged(privilegedAction);
        }
        return privilegedAction.run();
    }

    public static boolean isSupported() {
        return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9);
    }

    public static JavaModule of(Object obj) {
        if (f27511c.isInstance(obj)) {
            return new JavaModule((AnnotatedElement) obj);
        }
        throw new IllegalArgumentException("Not a Java module: " + obj);
    }

    public static JavaModule ofType(Class<?> cls) {
        Object module2 = f27510b.getModule(cls);
        if (module2 == null) {
            return UNSUPPORTED;
        }
        return new JavaModule((AnnotatedElement) module2);
    }

    public boolean canRead(JavaModule javaModule) {
        return f27511c.canRead(this.module, javaModule.unwrap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaModule)) {
            return false;
        }
        return this.module.equals(((JavaModule) obj).module);
    }

    public String getActualName() {
        return f27511c.getName(this.module);
    }

    public ClassLoader getClassLoader() {
        return f27511c.getClassLoader(this.module);
    }

    public AnnotationList getDeclaredAnnotations() {
        return new AnnotationList.ForLoadedAnnotations(this.module.getDeclaredAnnotations());
    }

    public InputStream getResourceAsStream(String str) throws IOException {
        return f27511c.getResourceAsStream(this.module, str);
    }

    public int hashCode() {
        return this.module.hashCode();
    }

    public boolean isExported(PackageDescription packageDescription, JavaModule javaModule) {
        return packageDescription == null || f27511c.isExported(this.module, packageDescription.getName(), javaModule.unwrap());
    }

    public boolean isNamed() {
        return f27511c.isNamed(this.module);
    }

    public boolean isOpened(PackageDescription packageDescription, JavaModule javaModule) {
        return packageDescription == null || f27511c.isOpen(this.module, packageDescription.getName(), javaModule.unwrap());
    }

    public String toString() {
        return this.module.toString();
    }

    public Object unwrap() {
        return this.module;
    }
}
