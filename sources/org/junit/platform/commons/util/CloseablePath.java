package org.junit.platform.commons.util;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

final class CloseablePath implements Closeable {
    private static final String FILE_URI_SCHEME = "file";
    private static final String JAR_FILE_EXTENSION = ".jar";
    private static final String JAR_URI_SCHEME = "jar";
    private static final String JAR_URI_SEPARATOR = "!";
    private static final ConcurrentMap<URI, ManagedFileSystem> MANAGED_FILE_SYSTEMS = new ConcurrentHashMap();
    private static final Closeable NULL_CLOSEABLE = new n();
    private final Closeable delegate;
    private final Path path;

    public static class ManagedFileSystem {
        /* access modifiers changed from: private */
        public final FileSystem fileSystem;
        private final URI jarUri;
        private final AtomicInteger referenceCount = new AtomicInteger(1);

        public ManagedFileSystem(URI uri) {
            this.jarUri = uri;
            try {
                this.fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
            } catch (IOException e11) {
                throw new UncheckedIOException("Failed to create file system for " + uri, e11);
            }
        }

        private void close() {
            try {
                this.fileSystem.close();
            } catch (IOException e11) {
                throw new UncheckedIOException("Failed to close file system for " + this.jarUri, e11);
            }
        }

        /* access modifiers changed from: private */
        public ManagedFileSystem release() {
            if (this.referenceCount.decrementAndGet() != 0) {
                return this;
            }
            close();
            return null;
        }

        /* access modifiers changed from: private */
        public ManagedFileSystem retain() {
            this.referenceCount.incrementAndGet();
            return this;
        }
    }

    private CloseablePath(Path path2, Closeable closeable) {
        this.path = path2;
        this.delegate = closeable;
    }

    private static CloseablePath createForJarFileSystem(URI uri, Function<FileSystem, Path> function) {
        ManagedFileSystem managedFileSystem = (ManagedFileSystem) ConcurrentMap.EL.compute(MANAGED_FILE_SYSTEMS, uri, new o(uri));
        return new CloseablePath(function.apply(managedFileSystem.fileSystem), new p(uri, managedFileSystem));
    }

    public static CloseablePath g(URI uri) throws URISyntaxException {
        if ("jar".equals(uri.getScheme())) {
            String[] split = uri.toString().split(JAR_URI_SEPARATOR);
            return createForJarFileSystem(new URI(split[0]), new q(split[1]));
        } else if (!uri.getScheme().equals("file") || !uri.getPath().endsWith(JAR_FILE_EXTENSION)) {
            return new CloseablePath(Paths.get(uri), NULL_CLOSEABLE);
        } else {
            return createForJarFileSystem(new URI("jar:" + uri), new r());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Path lambda$create$2(FileSystem fileSystem) {
        return (Path) fileSystem.getRootDirectories().iterator().next();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ManagedFileSystem lambda$createForJarFileSystem$3(URI uri, URI uri2, ManagedFileSystem managedFileSystem) {
        return managedFileSystem == null ? new ManagedFileSystem(uri) : managedFileSystem.retain();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() throws IOException {
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public Path getPath() {
        return this.path;
    }
}
