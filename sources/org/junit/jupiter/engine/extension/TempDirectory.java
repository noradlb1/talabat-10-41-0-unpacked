package org.junit.jupiter.engine.extension;

import d30.r0;
import d30.s0;
import g30.i;
import g30.k;
import g30.l;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.engine.config.EnumConfigurationParameterConverter;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.ReflectionUtils;

class TempDirectory implements BeforeAllCallback, BeforeEachCallback, ParameterResolver {
    private static final String KEY = "temp.dir";
    private static final String TEMP_DIR_PREFIX = "junit";

    /* renamed from: a  reason: collision with root package name */
    public static final ExtensionContext.Namespace f62577a = ExtensionContext.Namespace.create(TempDirectory.class);
    private final JupiterConfiguration configuration;

    public static class CloseablePath implements ExtensionContext.Store.CloseableResource {
        private static final Logger logger = LoggerFactory.getLogger(CloseablePath.class);
        private final CleanupMode cleanupMode;
        /* access modifiers changed from: private */
        public final Path dir;
        private final ExtensionContext executionContext;

        public CloseablePath(Path path, CleanupMode cleanupMode2, ExtensionContext extensionContext) {
            this.dir = path;
            this.cleanupMode = cleanupMode2;
            this.executionContext = extensionContext;
        }

        private IOException createIOExceptionWithAttachedFailures(SortedMap<Path, IOException> sortedMap) {
            IOException iOException = new IOException("Failed to delete temp directory " + this.dir.toAbsolutePath() + ". The following paths could not be deleted (see suppressed exceptions for details): " + ((String) Collection.EL.stream(sortedMap.keySet()).map(new m(this)).map(new n(this)).map(new k()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR))));
            Iterable.EL.forEach(sortedMap.values(), new l(iOException));
            return iOException;
        }

        private SortedMap<Path, IOException> deleteAllFilesAndDirectories(final FileOperations fileOperations) throws IOException {
            if (Files.notExists(this.dir, new LinkOption[0])) {
                return Collections.emptySortedMap();
            }
            final TreeMap treeMap = new TreeMap();
            final HashSet hashSet = new HashSet();
            resetPermissions(this.dir);
            Path unused = Files.walkFileTree(this.dir, new SimpleFileVisitor<Path>() {
                private FileVisitResult deleteAndContinue(Path path) {
                    try {
                        fileOperations.delete(path);
                    } catch (NoSuchFileException unused) {
                    } catch (DirectoryNotEmptyException e11) {
                        treeMap.put(path, e11);
                    } catch (IOException e12) {
                        resetPermissionsAndTryToDeleteAgain(path, e12);
                    }
                    return FileVisitResult.CONTINUE;
                }

                private void resetPermissionsAndTryToDeleteAgain(Path path, IOException iOException) {
                    if (hashSet.add(path)) {
                        try {
                            CloseablePath.resetPermissions(path);
                            if (Files.isDirectory(path, new LinkOption[0])) {
                                Path unused = Files.walkFileTree(path, this);
                            } else {
                                fileOperations.delete(path);
                            }
                        } catch (Exception e11) {
                            iOException.addSuppressed(e11);
                        }
                    } else {
                        treeMap.put(path, iOException);
                    }
                }

                public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
                    return deleteAndContinue(path);
                }

                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
                    if (!path.equals(CloseablePath.this.dir)) {
                        CloseablePath.resetPermissions(path);
                    }
                    return FileVisitResult.CONTINUE;
                }

                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
                    return deleteAndContinue(path);
                }

                public FileVisitResult visitFileFailed(Path path, IOException iOException) {
                    resetPermissionsAndTryToDeleteAgain(path, iOException);
                    return FileVisitResult.CONTINUE;
                }
            });
            return treeMap;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$close$0() {
            return "Skipping cleanup of temp dir " + this.dir + " due to cleanup mode configuration.";
        }

        /* access modifiers changed from: private */
        public Path relativizeSafely(Path path) {
            try {
                return this.dir.relativize(path);
            } catch (IllegalArgumentException unused) {
                return path;
            }
        }

        /* access modifiers changed from: private */
        public static void resetPermissions(Path path) {
            File a11 = path.toFile();
            a11.setReadable(true);
            a11.setWritable(true);
            if (Files.isDirectory(path, new LinkOption[0])) {
                a11.setExecutable(true);
            }
        }

        /* access modifiers changed from: private */
        public Path tryToDeleteOnExit(Path path) {
            try {
                path.toFile().deleteOnExit();
            } catch (UnsupportedOperationException unused) {
            }
            return path;
        }

        public void close() throws IOException {
            CleanupMode cleanupMode2 = this.cleanupMode;
            if (cleanupMode2 == CleanupMode.NEVER || (cleanupMode2 == CleanupMode.ON_SUCCESS && this.executionContext.getExecutionException().isPresent())) {
                logger.info(new l(this));
                return;
            }
            SortedMap<Path, IOException> deleteAllFilesAndDirectories = deleteAllFilesAndDirectories((FileOperations) this.executionContext.getStore(TempDirectory.f62577a).getOrDefault("file.operations", FileOperations.class, FileOperations.DEFAULT));
            if (!deleteAllFilesAndDirectories.isEmpty()) {
                throw createIOExceptionWithAttachedFailures(deleteAllFilesAndDirectories);
            }
        }

        public Path f() {
            return this.dir;
        }
    }

    public interface FileOperations {
        public static final FileOperations DEFAULT = new o();

        void delete(Path path) throws IOException;
    }

    public enum Scope {
        PER_CONTEXT,
        PER_DECLARATION
    }

    public TempDirectory(JupiterConfiguration jupiterConfiguration) {
        this.configuration = jupiterConfiguration;
    }

    private void assertNonFinalField(Field field) {
        if (ReflectionUtils.isFinal((Member) field)) {
            throw new ExtensionConfigurationException("@TempDir field [" + field + "] must not be declared as final.");
        }
    }

    private void assertSupportedType(String str, Class<?> cls) {
        Class cls2;
        if (cls != Path.class && cls != (cls2 = File.class)) {
            throw new ExtensionConfigurationException("Can only resolve @TempDir " + str + " of type " + Path.class.getName() + " or " + cls2.getName() + " but was: " + cls.getName());
        }
    }

    private CleanupMode determineCleanupMode(TempDir tempDir) {
        CleanupMode cleanup = tempDir.cleanup();
        if (cleanup == CleanupMode.DEFAULT) {
            return this.configuration.getDefaultTempDirCleanupMode();
        }
        return cleanup;
    }

    private CleanupMode determineCleanupModeForField(Field field) {
        return determineCleanupMode((TempDir) AnnotationUtils.findAnnotation((AnnotatedElement) field, TempDir.class).orElseThrow(new h(field)));
    }

    private CleanupMode determineCleanupModeForParameter(ParameterContext parameterContext) {
        return determineCleanupMode((TempDir) parameterContext.findAnnotation(TempDir.class).orElseThrow(new j(parameterContext)));
    }

    public static CloseablePath g(CleanupMode cleanupMode, ExtensionContext extensionContext) {
        try {
            return new CloseablePath(Files.createTempDirectory(TEMP_DIR_PREFIX, new FileAttribute[0]), cleanupMode, extensionContext);
        } catch (Exception e11) {
            throw new ExtensionConfigurationException("Failed to create default temp directory", e11);
        }
    }

    private Object getPathOrFile(AnnotatedElement annotatedElement, Class<?> cls, CleanupMode cleanupMode, ExtensionContext extensionContext) {
        ExtensionContext.Namespace namespace;
        if (getScope(extensionContext) == Scope.PER_DECLARATION) {
            namespace = f62577a.append(annotatedElement);
        } else {
            namespace = f62577a;
        }
        Path f11 = ((CloseablePath) extensionContext.getStore(namespace).getOrComputeIfAbsent(KEY, new i(cleanupMode, extensionContext), CloseablePath.class)).f();
        if (cls == Path.class) {
            return f11;
        }
        return f11.toFile();
    }

    private Scope getScope(ExtensionContext extensionContext) {
        ExtensionContext.Store store = extensionContext.getRoot().getStore(f62577a);
        g gVar = new g(extensionContext);
        Class<Scope> cls = Scope.class;
        return (Scope) store.getOrComputeIfAbsent(cls, gVar, cls);
    }

    private void injectFields(ExtensionContext extensionContext, Object obj, Class<?> cls, Predicate<Field> predicate) {
        Iterable.EL.forEach(AnnotationUtils.findAnnotatedFields(cls, TempDir.class, predicate), new f(this, obj, extensionContext));
    }

    /* access modifiers changed from: private */
    /* renamed from: injectInstanceFields */
    public void lambda$beforeEach$0(ExtensionContext extensionContext, Object obj) {
        injectFields(extensionContext, obj, obj.getClass(), new s0());
    }

    private void injectStaticFields(ExtensionContext extensionContext, Class<?> cls) {
        injectFields(extensionContext, (Object) null, cls, new r0());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$determineCleanupModeForField$2(Field field) {
        return new JUnitException("Field " + field + " must be annotated with @TempDir");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$determineCleanupModeForParameter$3(ParameterContext parameterContext) {
        return new JUnitException("Parameter " + parameterContext.getParameter() + " must be annotated with @TempDir");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Scope lambda$getScope$5(ExtensionContext extensionContext, Class cls) {
        EnumConfigurationParameterConverter enumConfigurationParameterConverter = new EnumConfigurationParameterConverter(Scope.class, "@TempDir scope");
        Objects.requireNonNull(extensionContext);
        return (Scope) enumConfigurationParameterConverter.get("junit.jupiter.tempdir.scope", new i(extensionContext), Scope.PER_DECLARATION);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$injectFields$1(Object obj, ExtensionContext extensionContext, Field field) {
        assertNonFinalField(field);
        assertSupportedType("field", field.getType());
        try {
            ((Field) ReflectionUtils.makeAccessible(field)).set(obj, getPathOrFile(field, field.getType(), determineCleanupModeForField(field), extensionContext));
        } catch (Throwable th2) {
            ExceptionUtils.throwAsUncheckedException(th2);
        }
    }

    public void beforeAll(ExtensionContext extensionContext) {
        injectStaticFields(extensionContext, extensionContext.getRequiredTestClass());
    }

    public void beforeEach(ExtensionContext extensionContext) {
        Iterable.EL.forEach(extensionContext.getRequiredTestInstances().getAllInstances(), new k(this, extensionContext));
    }

    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        Class a11 = parameterContext.getParameter().getType();
        assertSupportedType("parameter", a11);
        return getPathOrFile(parameterContext.getParameter(), a11, determineCleanupModeForParameter(parameterContext), extensionContext);
    }

    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        boolean isAnnotated = parameterContext.isAnnotated(TempDir.class);
        if (!isAnnotated || !(parameterContext.getDeclaringExecutable() instanceof Constructor)) {
            return isAnnotated;
        }
        throw new ParameterResolutionException("@TempDir is not supported on constructor parameters. Please use field injection instead.");
    }
}
