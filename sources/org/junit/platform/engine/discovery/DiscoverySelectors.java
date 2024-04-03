package org.junit.platform.engine.discovery;

import j$.util.Collection;
import j$.util.function.Supplier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import n30.c;
import n30.d;
import n30.e;
import n30.f;
import n30.g;
import n30.h;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.CollectionUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.UniqueId;

@API(since = "1.0", status = API.Status.STABLE)
public final class DiscoverySelectors {
    private DiscoverySelectors() {
    }

    public static ClassSelector selectClass(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return new ClassSelector(cls);
    }

    public static ClasspathResourceSelector selectClasspathResource(String str) {
        return selectClasspathResource(str, (FilePosition) null);
    }

    public static List<ClasspathRootSelector> selectClasspathRoots(Set<Path> set) {
        Preconditions.notNull(set, "classpathRoots must not be null");
        return (List) Collection.EL.stream(set).filter(new f()).map(new g()).map(new h()).collect(CollectionUtils.toUnmodifiableList());
    }

    public static DirectorySelector selectDirectory(String str) {
        Preconditions.notBlank(str, "Directory path must not be null or blank");
        return new DirectorySelector(str);
    }

    public static FileSelector selectFile(String str) {
        return selectFile(str, (FilePosition) null);
    }

    @API(since = "1.9", status = API.Status.EXPERIMENTAL)
    public static IterationSelector selectIteration(DiscoverySelector discoverySelector, int... iArr) {
        Preconditions.notNull(discoverySelector, "Parent selector must not be null");
        Preconditions.notEmpty(iArr, "iteration indices must not be empty");
        return new IterationSelector(discoverySelector, iArr);
    }

    public static MethodSelector selectMethod(String str) throws PreconditionViolationException {
        String[] parseFullyQualifiedMethodName = ReflectionUtils.parseFullyQualifiedMethodName(str);
        return selectMethod(parseFullyQualifiedMethodName[0], parseFullyQualifiedMethodName[1], parseFullyQualifiedMethodName[2]);
    }

    @API(since = "1.1", status = API.Status.EXPERIMENTAL)
    public static ModuleSelector selectModule(String str) {
        Preconditions.notBlank(str, "Module name must not be null or blank");
        return new ModuleSelector(str.trim());
    }

    @API(since = "1.1", status = API.Status.EXPERIMENTAL)
    public static List<ModuleSelector> selectModules(Set<String> set) {
        Preconditions.notNull(set, "Module names must not be null");
        Preconditions.containsNoNullElements(set, "Individual module name must not be null");
        return (List) Collection.EL.stream(set).map(new d()).collect(CollectionUtils.toUnmodifiableList());
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedClassSelector selectNestedClass(List<Class<?>> list, Class<?> cls) {
        Preconditions.notEmpty(list, "Enclosing classes must not be null or empty");
        Preconditions.notNull(cls, "Nested class must not be null");
        return new NestedClassSelector(list, cls);
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedMethodSelector selectNestedMethod(List<String> list, String str, String str2) {
        Preconditions.notEmpty(list, "Enclosing class names must not be null or empty");
        Preconditions.notBlank(str, "Nested class name must not be null or blank");
        Preconditions.notBlank(str2, "Method name must not be null or blank");
        return new NestedMethodSelector(list, str, str2);
    }

    public static PackageSelector selectPackage(String str) {
        boolean z11;
        Preconditions.notNull(str, "Package name must not be null");
        if (str.isEmpty() || !str.trim().isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "Package name must not contain only whitespace");
        return new PackageSelector(str.trim());
    }

    public static UniqueIdSelector selectUniqueId(UniqueId uniqueId) {
        Preconditions.notNull(uniqueId, "UniqueId must not be null");
        return new UniqueIdSelector(uniqueId);
    }

    public static UriSelector selectUri(String str) {
        Preconditions.notBlank(str, "URI must not be null or blank");
        try {
            return new UriSelector(new URI(str));
        } catch (URISyntaxException e11) {
            throw new PreconditionViolationException("Failed to create a java.net.URI from: " + str, e11);
        }
    }

    public static ClasspathResourceSelector selectClasspathResource(String str, FilePosition filePosition) {
        Preconditions.notBlank(str, "Classpath resource name must not be null or blank");
        return new ClasspathResourceSelector(str, filePosition);
    }

    public static FileSelector selectFile(File file) {
        return selectFile(file, (FilePosition) null);
    }

    public static ClassSelector selectClass(String str) {
        Preconditions.notBlank(str, "Class name must not be null or blank");
        return new ClassSelector(str);
    }

    public static DirectorySelector selectDirectory(File file) {
        Preconditions.notNull(file, "Directory must not be null");
        Preconditions.condition(file.isDirectory(), (Supplier<String>) new c(file));
        try {
            return new DirectorySelector(file.getCanonicalPath());
        } catch (IOException e11) {
            throw new PreconditionViolationException("Failed to retrieve canonical path for directory: " + file, e11);
        }
    }

    public static FileSelector selectFile(String str, FilePosition filePosition) {
        Preconditions.notBlank(str, "File path must not be null or blank");
        return new FileSelector(str, filePosition);
    }

    public static MethodSelector selectMethod(String str, String str2) {
        Preconditions.notBlank(str, "Class name must not be null or blank");
        Preconditions.notBlank(str2, "Method name must not be null or blank");
        return new MethodSelector(str, str2);
    }

    public static UniqueIdSelector selectUniqueId(String str) {
        Preconditions.notBlank(str, "Unique ID must not be null or blank");
        return new UniqueIdSelector(UniqueId.parse(str));
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedClassSelector selectNestedClass(List<String> list, String str) {
        Preconditions.notEmpty(list, "Enclosing class names must not be null or empty");
        Preconditions.notBlank(str, "Nested class name must not be null or blank");
        return new NestedClassSelector(list, str);
    }

    public static UriSelector selectUri(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        return new UriSelector(uri);
    }

    public static FileSelector selectFile(File file, FilePosition filePosition) {
        Preconditions.notNull(file, "File must not be null");
        Preconditions.condition(file.isFile(), (Supplier<String>) new e(file));
        try {
            return new FileSelector(file.getCanonicalPath(), filePosition);
        } catch (IOException e11) {
            throw new PreconditionViolationException("Failed to retrieve canonical path for file: " + file, e11);
        }
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedMethodSelector selectNestedMethod(List<String> list, String str, String str2, String str3) {
        Preconditions.notEmpty(list, "Enclosing class names must not be null or empty");
        Preconditions.notBlank(str, "Nested class name must not be null or blank");
        Preconditions.notBlank(str2, "Method name must not be null or blank");
        Preconditions.notNull(str3, "Parameter types must not be null");
        return new NestedMethodSelector(list, str, str2, str3);
    }

    public static MethodSelector selectMethod(String str, String str2, String str3) {
        Preconditions.notBlank(str, "Class name must not be null or blank");
        Preconditions.notBlank(str2, "Method name must not be null or blank");
        Preconditions.notNull(str3, "Parameter types must not be null");
        return new MethodSelector(str, str2, str3.trim());
    }

    public static MethodSelector selectMethod(Class<?> cls, String str) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        return new MethodSelector(cls, str);
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedMethodSelector selectNestedMethod(List<Class<?>> list, Class<?> cls, String str) {
        Preconditions.notEmpty(list, "Enclosing classes must not be null or empty");
        Preconditions.notNull(cls, "Nested class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        return new NestedMethodSelector(list, cls, str);
    }

    public static MethodSelector selectMethod(Class<?> cls, String str, String str2) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        Preconditions.notNull(str2, "Parameter types must not be null");
        return new MethodSelector(cls, str, str2.trim());
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedMethodSelector selectNestedMethod(List<Class<?>> list, Class<?> cls, String str, String str2) {
        Preconditions.notEmpty(list, "Enclosing classes must not be null or empty");
        Preconditions.notNull(cls, "Nested class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        Preconditions.notNull(str2, "Parameter types must not be null");
        return new NestedMethodSelector(list, cls, str, str2);
    }

    public static MethodSelector selectMethod(Class<?> cls, Method method) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(method, "Method must not be null");
        return new MethodSelector(cls, method);
    }

    @API(since = "1.6", status = API.Status.STABLE)
    public static NestedMethodSelector selectNestedMethod(List<Class<?>> list, Class<?> cls, Method method) {
        Preconditions.notEmpty(list, "Enclosing classes must not be null or empty");
        Preconditions.notNull(cls, "Nested class must not be null");
        Preconditions.notNull(method, "Method must not be null");
        return new NestedMethodSelector(list, cls, method);
    }
}
