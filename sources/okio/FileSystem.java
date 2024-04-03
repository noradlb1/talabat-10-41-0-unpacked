package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(¢\u0006\u0002\b*H\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u0002\u0007\n\u0005\b20\u0001¨\u00065"}, d2 = {"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class FileSystem {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FileSystem RESOURCES;
    @NotNull
    @JvmField
    public static final FileSystem SYSTEM;
    @NotNull
    @JvmField
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: -write$default  reason: not valid java name */
    public static /* synthetic */ Object m8062write$default(FileSystem fileSystem, Path path, boolean z11, Function1 function1, int i11, Object obj) throws IOException {
        Object obj2;
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            Intrinsics.checkNotNullParameter(path, "file");
            Intrinsics.checkNotNullParameter(function1, "writerAction");
            BufferedSink buffer = Okio.buffer(fileSystem.sink(path, z11));
            Throwable th2 = null;
            try {
                obj2 = function1.invoke(buffer);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                obj2 = null;
                th2 = th4;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th5) {
                    if (th2 == null) {
                        th2 = th5;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th2, th5);
                    }
                }
            }
            if (th2 == null) {
                Intrinsics.checkNotNull(obj2);
                return obj2;
            }
            throw th2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        FileSystem fileSystem;
        try {
            Class.forName("java.nio.file.Files");
            fileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            fileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = fileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.appendingSink(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.createDirectories(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.createDirectory(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.delete(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            fileSystem.deleteRecursively(path, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.listRecursively(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z11, boolean z12, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            return fileSystem.openReadWrite(path, z11, z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return fileSystem.sink(path, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    @JvmName(name = "-read")
    /* renamed from: -read  reason: not valid java name */
    public final <T> T m8063read(@NotNull Path path, @NotNull Function1<? super BufferedSource, ? extends T> function1) throws IOException {
        T t11;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "readerAction");
        Closeable buffer = Okio.buffer(source(path));
        Throwable th2 = null;
        try {
            t11 = function1.invoke((BufferedSource) buffer);
        } catch (Throwable th3) {
            th2 = th3;
            t11 = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th4);
                }
            }
        }
        if (th2 == null) {
            Intrinsics.checkNotNull(t11);
            return t11;
        }
        throw th2;
    }

    @JvmName(name = "-write")
    /* renamed from: -write  reason: not valid java name */
    public final <T> T m8064write(@NotNull Path path, boolean z11, @NotNull Function1<? super BufferedSink, ? extends T> function1) throws IOException {
        T t11;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(path, z11));
        Throwable th2 = null;
        try {
            t11 = function1.invoke(buffer);
        } catch (Throwable th3) {
            Throwable th4 = th3;
            t11 = null;
            th2 = th4;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th5) {
                if (th2 == null) {
                    th2 = th5;
                } else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th5);
                }
            }
        }
        if (th2 == null) {
            Intrinsics.checkNotNull(t11);
            return t11;
        }
        throw th2;
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return appendingSink(path, false);
    }

    @NotNull
    public abstract Sink appendingSink(@NotNull Path path, boolean z11) throws IOException;

    public abstract void atomicMove(@NotNull Path path, @NotNull Path path2) throws IOException;

    @NotNull
    public abstract Path canonicalize(@NotNull Path path) throws IOException;

    public void copy(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        _FileSystemKt.commonCopy(this, path, path2);
    }

    public final void createDirectories(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        _FileSystemKt.commonCreateDirectories(this, path, z11);
    }

    public final void createDirectory(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        createDirectory(path, false);
    }

    public abstract void createDirectory(@NotNull Path path, boolean z11) throws IOException;

    public abstract void createSymlink(@NotNull Path path, @NotNull Path path2) throws IOException;

    public final void delete(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public abstract void delete(@NotNull Path path, boolean z11) throws IOException;

    public void deleteRecursively(@NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, path, z11);
    }

    public final boolean exists(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonExists(this, path);
    }

    @NotNull
    public abstract List<Path> list(@NotNull Path path) throws IOException;

    @Nullable
    public abstract List<Path> listOrNull(@NotNull Path path);

    @NotNull
    public Sequence<Path> listRecursively(@NotNull Path path, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return _FileSystemKt.commonListRecursively(this, path, z11);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonMetadata(this, path);
    }

    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull Path path) throws IOException;

    @NotNull
    public abstract FileHandle openReadOnly(@NotNull Path path) throws IOException;

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return openReadWrite(path, false, false);
    }

    @NotNull
    public abstract FileHandle openReadWrite(@NotNull Path path, boolean z11, boolean z12) throws IOException;

    @NotNull
    public final Sink sink(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return sink(path, false);
    }

    @NotNull
    public abstract Sink sink(@NotNull Path path, boolean z11) throws IOException;

    @NotNull
    public abstract Source source(@NotNull Path path) throws IOException;

    public final void createDirectories(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        createDirectories(path, false);
    }

    public final void deleteRecursively(@NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        deleteRecursively(path, false);
    }

    @NotNull
    public final Sequence<Path> listRecursively(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return listRecursively(path, false);
    }
}
