package okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _FileSystemKt {
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
        if (r0 != false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00db, code lost:
        if (r14 != 0) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dd, code lost:
        r6.addLast(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e4, code lost:
        r13 = r12;
        r12 = r11;
        r11 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0128, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0129, code lost:
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012a, code lost:
        r11.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012d, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f1 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0121 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super okio.Path> r17, @org.jetbrains.annotations.NotNull okio.FileSystem r18, @org.jetbrains.annotations.NotNull kotlin.collections.ArrayDeque<okio.Path> r19, @org.jetbrains.annotations.NotNull okio.Path r20, boolean r21, boolean r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r0 = r17
            r1 = r20
            r2 = r22
            r3 = r23
            boolean r4 = r3 instanceof okio.internal._FileSystemKt$collectRecursively$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            okio.internal._FileSystemKt$collectRecursively$1 r4 = (okio.internal._FileSystemKt$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            okio.internal._FileSystemKt$collectRecursively$1 r4 = new okio.internal._FileSystemKt$collectRecursively$1
            r4.<init>(r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x007f
            if (r6 == r10) goto L_0x0061
            if (r6 == r9) goto L_0x0041
            if (r6 != r8) goto L_0x0039
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0148
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r11 = r4.L$2
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r4.L$1
            okio.FileSystem r12 = (okio.FileSystem) r12
            java.lang.Object r13 = r4.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            goto L_0x00eb
        L_0x005e:
            r0 = move-exception
            goto L_0x012a
        L_0x0061:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r11 = r4.L$1
            okio.FileSystem r11 = (okio.FileSystem) r11
            java.lang.Object r12 = r4.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r3)
            r16 = r2
            r2 = r0
            r0 = r1
            r1 = r16
            goto L_0x00a8
        L_0x007f:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r2 != 0) goto L_0x009f
            r4.L$0 = r0
            r3 = r18
            r4.L$1 = r3
            r6 = r19
            r4.L$2 = r6
            r4.L$3 = r1
            r11 = r21
            r4.Z$0 = r11
            r4.Z$1 = r2
            r4.label = r10
            java.lang.Object r12 = r0.yield(r1, r4)
            if (r12 != r5) goto L_0x00a5
            return r5
        L_0x009f:
            r3 = r18
            r6 = r19
            r11 = r21
        L_0x00a5:
            r12 = r0
            r0 = r11
            r11 = r3
        L_0x00a8:
            java.util.List r3 = r11.listOrNull(r1)
            if (r3 != 0) goto L_0x00b2
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x00b2:
            r13 = r3
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r13 = r13.isEmpty()
            r13 = r13 ^ r10
            if (r13 == 0) goto L_0x0132
            r13 = r1
            r14 = r7
        L_0x00be:
            if (r0 == 0) goto L_0x00d3
            boolean r15 = r6.contains(r13)
            if (r15 != 0) goto L_0x00c7
            goto L_0x00d3
        L_0x00c7:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "symlink cycle at "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x00d3:
            okio.Path r15 = symlinkTarget(r11, r13)
            if (r15 != 0) goto L_0x012e
            if (r0 != 0) goto L_0x00dd
            if (r14 != 0) goto L_0x0132
        L_0x00dd:
            r6.addLast(r13)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0128 }
            r13 = r12
            r12 = r11
            r11 = r6
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r3
        L_0x00eb:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0121
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005e }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00fb
            r14 = r10
            goto L_0x00fc
        L_0x00fb:
            r14 = r7
        L_0x00fc:
            r4.L$0 = r13     // Catch:{ all -> 0x005e }
            r4.L$1 = r12     // Catch:{ all -> 0x005e }
            r4.L$2 = r11     // Catch:{ all -> 0x005e }
            r4.L$3 = r6     // Catch:{ all -> 0x005e }
            r4.L$4 = r2     // Catch:{ all -> 0x005e }
            r4.Z$0 = r1     // Catch:{ all -> 0x005e }
            r4.Z$1 = r0     // Catch:{ all -> 0x005e }
            r4.label = r9     // Catch:{ all -> 0x005e }
            r17 = r13
            r18 = r12
            r19 = r11
            r20 = r3
            r21 = r1
            r22 = r14
            r23 = r4
            java.lang.Object r3 = collectRecursively(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x005e }
            if (r3 != r5) goto L_0x00eb
            return r5
        L_0x0121:
            r11.removeLast()
            r2 = r0
            r1 = r6
            r12 = r13
            goto L_0x0132
        L_0x0128:
            r0 = move-exception
            r11 = r6
        L_0x012a:
            r11.removeLast()
            throw r0
        L_0x012e:
            int r14 = r14 + 1
            r13 = r15
            goto L_0x00be
        L_0x0132:
            if (r2 == 0) goto L_0x014b
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            java.lang.Object r0 = r12.yield(r1, r4)
            if (r0 != r5) goto L_0x0148
            return r5
        L_0x0148:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void commonCopy(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull Path path2) throws IOException {
        Long l11;
        Long l12;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        Closeable source = fileSystem.source(path);
        Throwable th2 = null;
        try {
            Source source2 = (Source) source;
            BufferedSink buffer = Okio.buffer(fileSystem.sink(path2));
            try {
                l12 = Long.valueOf(buffer.writeAll(source2));
                th = null;
            } catch (Throwable th3) {
                th = th3;
                l12 = null;
            }
            if (buffer != null) {
                buffer.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            l11 = null;
        }
        if (th == null) {
            Intrinsics.checkNotNull(l12);
            l11 = Long.valueOf(l12.longValue());
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th5) {
                    if (th2 == null) {
                        th2 = th5;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th2, th5);
                    }
                }
            }
            if (th2 == null) {
                Intrinsics.checkNotNull(l11);
                return;
            }
            throw th2;
        }
        throw th;
    }

    public static final void commonCreateDirectories(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z11 || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                fileSystem.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exist.");
    }

    public static final void commonDeleteRecursively(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z11) throws IOException {
        boolean z12;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        Iterator it = SequencesKt__SequenceBuilderKt.sequence(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super _FileSystemKt$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it.hasNext()) {
            Path path2 = (Path) it.next();
            if (!z11 || it.hasNext()) {
                z12 = false;
            } else {
                z12 = true;
            }
            fileSystem.delete(path2, z12);
        }
    }

    public static final boolean commonExists(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fileSystem.metadataOrNull(path) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt__SequenceBuilderKt.sequence(new _FileSystemKt$commonListRecursively$1(path, fileSystem, z11, (Continuation<? super _FileSystemKt$commonListRecursively$1>) null));
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("no such file: ", path));
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }
}
