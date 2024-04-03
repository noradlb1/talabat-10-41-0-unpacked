package org.junit.platform.commons.util;

import j$.util.Collection;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import l30.a0;
import l30.b0;
import l30.z;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class ClasspathScanner {
    private static final char CLASSPATH_RESOURCE_PATH_SEPARATOR = '/';
    private static final String CLASSPATH_RESOURCE_PATH_SEPARATOR_STRING = String.valueOf(CLASSPATH_RESOURCE_PATH_SEPARATOR);
    private static final String MALFORMED_CLASS_NAME_ERROR_MESSAGE = "Malformed class name";
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final String PACKAGE_SEPARATOR_STRING = String.valueOf('.');
    private static final Logger logger = LoggerFactory.getLogger(ClasspathScanner.class);
    private final Supplier<ClassLoader> classLoaderSupplier;
    private final BiFunction<String, ClassLoader, Try<Class<?>>> loadClass;

    public ClasspathScanner(Supplier<ClassLoader> supplier, BiFunction<String, ClassLoader, Try<Class<?>>> biFunction) {
        this.classLoaderSupplier = supplier;
        this.loadClass = biFunction;
    }

    private String determineFullyQualifiedClassName(Path path, String str, Path path2) {
        return (String) Stream.CC.of((T[]) new String[]{str, determineSubpackageName(path, path2), determineSimpleClassName(path2)}).filter(new c()).collect(Collectors.joining(PACKAGE_SEPARATOR_STRING));
    }

    private String determineSimpleClassName(Path path) {
        String a11 = path.getFileName().toString();
        return a11.substring(0, a11.length() - 6);
    }

    private String determineSubpackageName(Path path, Path path2) {
        Path a11 = path.relativize(path2.getParent());
        String a12 = path.getFileSystem().getSeparator();
        String replace = a11.toString().replace(a12, PACKAGE_SEPARATOR_STRING);
        if (replace.endsWith(a12)) {
            return replace.substring(0, replace.length() - a12.length());
        }
        return replace;
    }

    private List<Class<?>> findClassesForPath(Path path, String str, ClassFilter classFilter) {
        Preconditions.condition(Files.exists(path, new LinkOption[0]), (Supplier<String>) new i(path));
        ArrayList arrayList = new ArrayList();
        try {
            Path unused = Files.walkFileTree(path, new ClassFileVisitor(new j(this, path, str, classFilter, arrayList)));
        } catch (IOException e11) {
            logger.warn(e11, new k(path));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: findClassesForUri */
    public List<Class<?>> lambda$findClassesForUris$0(URI uri, String str, ClassFilter classFilter) {
        CloseablePath g11;
        try {
            g11 = CloseablePath.g(uri);
            List<Class<?>> findClassesForPath = findClassesForPath(g11.getPath(), str, classFilter);
            g11.close();
            return findClassesForPath;
        } catch (PreconditionViolationException e11) {
            throw e11;
        } catch (Exception e12) {
            logger.warn(e12, new d(uri));
            return Collections.emptyList();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private List<Class<?>> findClassesForUris(List<URI> list, String str, ClassFilter classFilter) {
        return (List) Collection.EL.stream(list).map(new l(this, str, classFilter)).flatMap(new b0()).distinct().collect(Collectors.toList());
    }

    private ClassLoader getClassLoader() {
        return this.classLoaderSupplier.get();
    }

    private List<URI> getRootUrisForPackage(String str) {
        try {
            Enumeration<URL> resources = getClassLoader().getResources(packagePath(str));
            ArrayList arrayList = new ArrayList();
            while (resources.hasMoreElements()) {
                arrayList.add(resources.nextElement().toURI());
            }
            return arrayList;
        } catch (Exception e11) {
            logger.warn(e11, new h(str));
            return Collections.emptyList();
        }
    }

    private List<URI> getRootUrisForPackageNameOnClassPathAndModulePath(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(getRootUrisForPackage(str));
        if (!str.isEmpty()) {
            String str2 = PACKAGE_SEPARATOR_STRING;
            if (!str.endsWith(str2)) {
                Collection.EL.stream(getRootUrisForPackage(str + str2)).map(new f()).forEach(new a0(linkedHashSet));
            }
        }
        return new ArrayList(linkedHashSet);
    }

    private void handleInternalError(Path path, String str, InternalError internalError) {
        if (MALFORMED_CLASS_NAME_ERROR_MESSAGE.equals(internalError.getMessage())) {
            logMalformedClassName(path, str, internalError);
        } else {
            logGenericFileProcessingException(path, internalError);
        }
    }

    private void handleThrowable(Path path, Throwable th2) {
        UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
        logGenericFileProcessingException(path, th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$determineFullyQualifiedClassName$5(String str) {
        return !str.isEmpty();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findClassesForPath$2(Path path) {
        return "baseDir must exist: " + path;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$findClassesForPath$3(Path path, String str, ClassFilter classFilter, List list, Path path2) {
        Objects.requireNonNull(list);
        processClassFileSafely(path, str, classFilter, path2, new z(list));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findClassesForPath$4(Path path) {
        return "I/O error scanning files in " + path;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findClassesForUri$1(URI uri) {
        return "Error scanning files for URI " + uri;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$getRootUrisForPackage$8(String str) {
        return "Error reading URIs from class loader for base package " + str;
    }

    private void logGenericFileProcessingException(Path path, Throwable th2) {
        logger.debug(th2, new g(path));
    }

    private void logMalformedClassName(Path path, String str, InternalError internalError) {
        try {
            logger.debug(internalError, new e(path, str));
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            internalError.addSuppressed(th2);
            logGenericFileProcessingException(path, internalError);
        }
    }

    private static String packagePath(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return str.replace('.', CLASSPATH_RESOURCE_PATH_SEPARATOR);
    }

    private void processClassFileSafely(Path path, String str, ClassFilter classFilter, Path path2, Consumer<Class<?>> consumer) {
        String determineFullyQualifiedClassName;
        try {
            determineFullyQualifiedClassName = determineFullyQualifiedClassName(path, str, path2);
            if (classFilter.match(determineFullyQualifiedClassName)) {
                this.loadClass.apply(determineFullyQualifiedClassName, getClassLoader()).toOptional().filter(classFilter).ifPresent(consumer);
            }
        } catch (InternalError e11) {
            handleInternalError(path2, determineFullyQualifiedClassName, e11);
        } catch (Throwable th2) {
            handleThrowable(path2, th2);
        }
    }

    /* access modifiers changed from: private */
    public static URI removeTrailingClasspathResourcePathSeparator(URI uri) {
        String uri2 = uri.toString();
        if (uri2.endsWith(CLASSPATH_RESOURCE_PATH_SEPARATOR_STRING)) {
            return URI.create(uri2.substring(0, uri2.length() - 1));
        }
        return uri;
    }

    public List<Class<?>> k(URI uri, ClassFilter classFilter) {
        Preconditions.notNull(uri, "root must not be null");
        Preconditions.notNull(classFilter, "classFilter must not be null");
        return lambda$findClassesForUris$0(uri, "", classFilter);
    }

    public List<Class<?>> l(String str, ClassFilter classFilter) {
        boolean z11;
        if ("".equals(str) || StringUtils.isNotBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "basePackageName must not be null or blank");
        Preconditions.notNull(classFilter, "classFilter must not be null");
        String trim = str.trim();
        return findClassesForUris(getRootUrisForPackageNameOnClassPathAndModulePath(trim), trim, classFilter);
    }
}
