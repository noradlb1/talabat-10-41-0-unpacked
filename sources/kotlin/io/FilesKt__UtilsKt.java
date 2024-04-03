package kotlin.io;

import com.facebook.appevents.codeless.internal.Constants;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009c A[Catch:{ TerminateException -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean copyRecursively(@org.jetbrains.annotations.NotNull java.io.File r11, @org.jetbrains.annotations.NotNull java.io.File r12, boolean r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onError"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x002e
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r5 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r7 = 2
            r8 = 0
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.invoke(r11, r12)
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            return r1
        L_0x002e:
            kotlin.io.FileTreeWalk r0 = kotlin.io.FilesKt__FileTreeWalkKt.walkTopDown(r11)     // Catch:{ TerminateException -> 0x00dc }
            kotlin.io.FilesKt__UtilsKt$copyRecursively$2 r3 = new kotlin.io.FilesKt__UtilsKt$copyRecursively$2     // Catch:{ TerminateException -> 0x00dc }
            r3.<init>(r14)     // Catch:{ TerminateException -> 0x00dc }
            kotlin.io.FileTreeWalk r0 = r0.onFail(r3)     // Catch:{ TerminateException -> 0x00dc }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ TerminateException -> 0x00dc }
        L_0x003f:
            boolean r3 = r0.hasNext()     // Catch:{ TerminateException -> 0x00dc }
            if (r3 == 0) goto L_0x00db
            java.lang.Object r3 = r0.next()     // Catch:{ TerminateException -> 0x00dc }
            java.io.File r3 = (java.io.File) r3     // Catch:{ TerminateException -> 0x00dc }
            boolean r4 = r3.exists()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 != 0) goto L_0x0066
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch:{ TerminateException -> 0x00dc }
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00dc }
            java.lang.Object r3 = r14.invoke(r3, r10)     // Catch:{ TerminateException -> 0x00dc }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00dc }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x0066:
            java.lang.String r4 = toRelativeString(r3, r11)     // Catch:{ TerminateException -> 0x00dc }
            java.io.File r5 = new java.io.File     // Catch:{ TerminateException -> 0x00dc }
            r5.<init>(r12, r4)     // Catch:{ TerminateException -> 0x00dc }
            boolean r4 = r5.exists()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 == 0) goto L_0x00ac
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 == 0) goto L_0x0081
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 != 0) goto L_0x00ac
        L_0x0081:
            if (r13 != 0) goto L_0x0085
        L_0x0083:
            r4 = r1
            goto L_0x009a
        L_0x0085:
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 == 0) goto L_0x0092
            boolean r4 = deleteRecursively(r5)     // Catch:{ TerminateException -> 0x00dc }
            if (r4 != 0) goto L_0x0099
            goto L_0x0083
        L_0x0092:
            boolean r4 = r5.delete()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 != 0) goto L_0x0099
            goto L_0x0083
        L_0x0099:
            r4 = r2
        L_0x009a:
            if (r4 == 0) goto L_0x00ac
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch:{ TerminateException -> 0x00dc }
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch:{ TerminateException -> 0x00dc }
            java.lang.Object r3 = r14.invoke(r5, r4)     // Catch:{ TerminateException -> 0x00dc }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00dc }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x00ac:
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00dc }
            if (r4 == 0) goto L_0x00b6
            r5.mkdirs()     // Catch:{ TerminateException -> 0x00dc }
            goto L_0x003f
        L_0x00b6:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = copyTo$default(r4, r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00dc }
            long r4 = r4.length()     // Catch:{ TerminateException -> 0x00dc }
            long r6 = r3.length()     // Catch:{ TerminateException -> 0x00dc }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x003f
            java.io.IOException r4 = new java.io.IOException     // Catch:{ TerminateException -> 0x00dc }
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch:{ TerminateException -> 0x00dc }
            java.lang.Object r3 = r14.invoke(r3, r4)     // Catch:{ TerminateException -> 0x00dc }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00dc }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x00db:
            return r1
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyRecursively(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z11, Function2 function2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            function2 = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return copyRecursively(file, file2, z11, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006c, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006f, code lost:
        throw r7;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File copyTo(@org.jetbrains.annotations.NotNull java.io.File r6, @org.jetbrains.annotations.NotNull java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0070
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x0027
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0027:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x002f:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x0044
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x003c
            goto L_0x0061
        L_0x003c:
            kotlin.io.FileSystemException r8 = new kotlin.io.FileSystemException
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0044:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x004d
            r8.mkdirs()
        L_0x004d:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0069 }
            r6.<init>(r7)     // Catch:{ all -> 0x0069 }
            kotlin.io.ByteStreamsKt.copyTo(r8, r6, r9)     // Catch:{ all -> 0x0062 }
            r9 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r9)     // Catch:{ all -> 0x0069 }
            kotlin.io.CloseableKt.closeFinally(r8, r9)
        L_0x0061:
            return r7
        L_0x0062:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r7)     // Catch:{ all -> 0x0069 }
            throw r9     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x006b }
        L_0x006b:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            throw r7
        L_0x0070:
            kotlin.io.NoSuchFileException r7 = new kotlin.io.NoSuchFileException
            r2 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r4 = 2
            r5 = 0
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.copyTo(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 8192;
        }
        return copyTo(file, file2, z11, i11);
    }

    @NotNull
    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "tmp";
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    @NotNull
    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "tmp";
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static boolean deleteRecursively(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Iterator it = FilesKt__FileTreeWalkKt.walkBottomUp(file).iterator();
        while (true) {
            boolean z11 = true;
            while (true) {
                if (!it.hasNext()) {
                    return z11;
                }
                File file2 = (File) it.next();
                if (file2.delete() || !file2.exists()) {
                    if (z11) {
                    }
                }
                z11 = false;
            }
        }
    }

    public static final boolean endsWith(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual((Object) file, (Object) file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    @NotNull
    public static String getExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        return StringsKt__StringsKt.substringAfterLast(name2, '.', "");
    }

    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "path");
            return StringsKt__StringsJVMKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        return path2;
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name2, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, (String) null, 2, (Object) null);
    }

    @NotNull
    public static final File normalize(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        File root = components.getRoot();
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt((List<? extends File>) components.getSegments()), str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt((List<? extends File>) filePathComponents.getSegments()));
    }

    @NotNull
    public static final File relativeTo(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, TtmlNode.RUBY_BASE);
        return new File(toRelativeString(file, file2));
    }

    @Nullable
    public static final File relativeToOrNull(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, TtmlNode.RUBY_BASE);
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    @NotNull
    public static final File relativeToOrSelf(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, TtmlNode.RUBY_BASE);
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return file;
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, Constants.PATH_TYPE_RELATIVE);
        if (FilesKt__FilePathComponentsKt.isRooted(file2)) {
            return file2;
        }
        String file3 = file.toString();
        Intrinsics.checkNotNullExpressionValue(file3, "this.toString()");
        if ((file3.length() == 0) || StringsKt__StringsKt.endsWith$default((CharSequence) file3, File.separatorChar, false, 2, (Object) null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, Constants.PATH_TYPE_RELATIVE);
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final boolean startsWith(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        if (Intrinsics.areEqual((Object) components.getRoot(), (Object) components2.getRoot()) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    @NotNull
    public static final String toRelativeString(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, TtmlNode.RUBY_BASE);
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt.getRoot(), (Object) normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        int size2 = normalize$FilesKt__UtilsKt.getSize();
        int min = Math.min(size2, size);
        int i11 = 0;
        while (i11 < min && Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt.getSegments().get(i11), (Object) normalize$FilesKt__UtilsKt2.getSegments().get(i11))) {
            i11++;
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = size - 1;
        if (i11 <= i12) {
            while (!Intrinsics.areEqual((Object) normalize$FilesKt__UtilsKt2.getSegments().get(i12).getName(), (Object) "..")) {
                sb2.append("..");
                if (i12 != i11) {
                    sb2.append(File.separatorChar);
                }
                if (i12 != i11) {
                    i12--;
                }
            }
            return null;
        }
        if (i11 < size2) {
            if (i11 < size) {
                sb2.append(File.separatorChar);
            }
            String str = File.separator;
            Intrinsics.checkNotNullExpressionValue(str, "separator");
            Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(CollectionsKt___CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i11), sb2, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
        }
        return sb2.toString();
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name2 = file.getName();
            if (!Intrinsics.areEqual((Object) name2, (Object) RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                if (!Intrinsics.areEqual((Object) name2, (Object) "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || Intrinsics.areEqual((Object) ((File) CollectionsKt___CollectionsKt.last(arrayList)).getName(), (Object) "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.PATH_TYPE_RELATIVE);
        return resolve(file, new File(str));
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.PATH_TYPE_RELATIVE);
        return resolveSibling(file, new File(str));
    }

    public static final boolean startsWith(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, "other");
        return startsWith(file, new File(str));
    }

    public static final boolean endsWith(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, "other");
        return endsWith(file, new File(str));
    }
}
