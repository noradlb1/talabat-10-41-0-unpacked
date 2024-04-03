package okio.internal;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ZipEntry zipEntry : CollectionsKt___CollectionsKt.sortedWith(list, new ZipKt$buildIndex$$inlined$sortedBy$1())) {
            if (((ZipEntry) linkedHashMap.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) linkedHashMap.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry5 = zipEntry3;
                    linkedHashMap.put(parent, zipEntry5);
                    zipEntry5.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry5;
                }
            }
        }
        return linkedHashMap;
    }

    private static final Long dosDateTimeToEpochMillis(int i11, int i12) {
        if (i12 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i11 >> 9) & 127) + 1980, ((i11 >> 5) & 15) - 1, i11 & 31, (i12 >> 11) & 31, (i12 >> 5) & 63, (i12 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i11) {
        String num = Integer.toString(i11, CharsKt__CharJVMKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.stringPlus("0x", num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        r11 = readEocdRecord(r14);
        r12 = r14.readUtf8((long) r11.getCommentByteCount());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r14.close();
        r8 = r8 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a5, code lost:
        if (r8 <= 0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        r8 = okio.Okio.buffer(r3.source(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r9 = (okio.BufferedSource) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
        if (r9.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        r13 = r9.readIntLe();
        r14 = r9.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c9, code lost:
        if (r9.readIntLe() != 1) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
        if (r13 != 0) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cd, code lost:
        r4 = okio.Okio.buffer(r3.source(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r9 = (okio.BufferedSource) r4;
        r13 = r9.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (r13 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        r9 = readZip64EocdRecord(r9, r11);
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ec, code lost:
        r11 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0112, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0113, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0116, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0117, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0123, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0124, code lost:
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012b, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0132, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0133, code lost:
        r4 = new java.util.ArrayList();
        r8 = okio.Okio.buffer(r3.source(r11.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r9 = (okio.BufferedSource) r8;
        r13 = r11.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014f, code lost:
        if (0 >= r13) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0151, code lost:
        r5 = r5 + 1;
        r10 = readEntry(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0162, code lost:
        if (r10.getOffset() >= r11.getCentralDirectoryOffset()) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
        if (r2.invoke(r10).booleanValue() == false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0170, code lost:
        r4.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0175, code lost:
        if (r5 < r13) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017f, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0180, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r4), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x018e, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0191, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0192, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0193, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0195, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0196, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x019a, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(@org.jetbrains.annotations.NotNull okio.Path r19, @org.jetbrains.annotations.NotNull okio.FileSystem r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r21) throws java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            okio.FileHandle r3 = r1.openReadOnly(r0)
            r4 = 1
            r5 = 0
            r7 = 0
            okio.Source r8 = okio.FileHandle.source$default(r3, r5, r4, r7)     // Catch:{ all -> 0x01d1 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ all -> 0x01d1 }
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x01d1 }
            r9 = r8
            okio.BufferedSource r9 = (okio.BufferedSource) r9     // Catch:{ all -> 0x01c8 }
            int r9 = r9.readIntLe()     // Catch:{ all -> 0x01c8 }
            java.lang.String r10 = " but was "
            r11 = 101010256(0x6054b50, float:2.506985E-35)
            r12 = 67324752(0x4034b50, float:1.5433558E-36)
            if (r9 == r12) goto L_0x0067
            if (r9 != r11) goto L_0x0042
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = "unsupported zip: empty"
            r0.<init>(r1)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x0042:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r1.<init>()     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = "not a zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = getHex(r12)     // Catch:{ all -> 0x01c8 }
            r1.append(r2)     // Catch:{ all -> 0x01c8 }
            r1.append(r10)     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = getHex(r9)     // Catch:{ all -> 0x01c8 }
            r1.append(r2)     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c8 }
            r0.<init>(r1)     // Catch:{ all -> 0x01c8 }
            throw r0     // Catch:{ all -> 0x01c8 }
        L_0x0067:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01c8 }
            kotlin.io.CloseableKt.closeFinally(r8, r7)     // Catch:{ all -> 0x01d1 }
            long r8 = r3.size()     // Catch:{ all -> 0x01d1 }
            r12 = 22
            long r12 = (long) r12     // Catch:{ all -> 0x01d1 }
            long r8 = r8 - r12
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x01b4
            r12 = 65536(0x10000, double:3.2379E-319)
            long r12 = r8 - r12
            long r12 = java.lang.Math.max(r12, r5)     // Catch:{ all -> 0x01d1 }
        L_0x0081:
            okio.Source r14 = r3.source(r8)     // Catch:{ all -> 0x01d1 }
            okio.BufferedSource r14 = okio.Okio.buffer((okio.Source) r14)     // Catch:{ all -> 0x01d1 }
            int r15 = r14.readIntLe()     // Catch:{ all -> 0x01af }
            if (r15 != r11) goto L_0x019b
            okio.internal.EocdRecord r11 = readEocdRecord(r14)     // Catch:{ all -> 0x01af }
            int r12 = r11.getCommentByteCount()     // Catch:{ all -> 0x01af }
            long r12 = (long) r12     // Catch:{ all -> 0x01af }
            java.lang.String r12 = r14.readUtf8(r12)     // Catch:{ all -> 0x01af }
            r14.close()     // Catch:{ all -> 0x01d1 }
            r13 = 20
            long r13 = (long) r13     // Catch:{ all -> 0x01d1 }
            long r8 = r8 - r13
            int r13 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x0133
            okio.Source r8 = r3.source(r8)     // Catch:{ all -> 0x01d1 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ all -> 0x01d1 }
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x01d1 }
            r9 = r8
            okio.BufferedSource r9 = (okio.BufferedSource) r9     // Catch:{ all -> 0x012a }
            int r13 = r9.readIntLe()     // Catch:{ all -> 0x012a }
            r14 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r13 != r14) goto L_0x0124
            int r13 = r9.readIntLe()     // Catch:{ all -> 0x012a }
            long r14 = r9.readLongLe()     // Catch:{ all -> 0x012a }
            int r9 = r9.readIntLe()     // Catch:{ all -> 0x012a }
            if (r9 != r4) goto L_0x011c
            if (r13 != 0) goto L_0x011c
            okio.Source r4 = r3.source(r14)     // Catch:{ all -> 0x012a }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x012a }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x012a }
            r9 = r4
            okio.BufferedSource r9 = (okio.BufferedSource) r9     // Catch:{ all -> 0x0113 }
            int r13 = r9.readIntLe()     // Catch:{ all -> 0x0113 }
            r14 = 101075792(0x6064b50, float:2.525793E-35)
            if (r13 != r14) goto L_0x00ee
            okio.internal.EocdRecord r9 = readZip64EocdRecord(r9, r11)     // Catch:{ all -> 0x0113 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0113 }
            kotlin.io.CloseableKt.closeFinally(r4, r7)     // Catch:{ all -> 0x012a }
            r11 = r9
            goto L_0x0124
        L_0x00ee:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r1.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = getHex(r14)     // Catch:{ all -> 0x0113 }
            r1.append(r2)     // Catch:{ all -> 0x0113 }
            r1.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = getHex(r13)     // Catch:{ all -> 0x0113 }
            r1.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0113 }
            r0.<init>(r1)     // Catch:{ all -> 0x0113 }
            throw r0     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x012a }
            throw r2     // Catch:{ all -> 0x012a }
        L_0x011c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012a }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x012a }
            throw r0     // Catch:{ all -> 0x012a }
        L_0x0124:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x012a }
            kotlin.io.CloseableKt.closeFinally(r8, r7)     // Catch:{ all -> 0x01d1 }
            goto L_0x0133
        L_0x012a:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x012d }
        L_0x012d:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r8, r1)     // Catch:{ all -> 0x01d1 }
            throw r2     // Catch:{ all -> 0x01d1 }
        L_0x0133:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x01d1 }
            r4.<init>()     // Catch:{ all -> 0x01d1 }
            long r8 = r11.getCentralDirectoryOffset()     // Catch:{ all -> 0x01d1 }
            okio.Source r8 = r3.source(r8)     // Catch:{ all -> 0x01d1 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ all -> 0x01d1 }
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x01d1 }
            r9 = r8
            okio.BufferedSource r9 = (okio.BufferedSource) r9     // Catch:{ all -> 0x0192 }
            long r13 = r11.getEntryCount()     // Catch:{ all -> 0x0192 }
            int r10 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r10 >= 0) goto L_0x0180
        L_0x0151:
            r15 = 1
            long r5 = r5 + r15
            okio.internal.ZipEntry r10 = readEntry(r9)     // Catch:{ all -> 0x0192 }
            long r15 = r10.getOffset()     // Catch:{ all -> 0x0192 }
            long r17 = r11.getCentralDirectoryOffset()     // Catch:{ all -> 0x0192 }
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0178
            java.lang.Object r15 = r2.invoke(r10)     // Catch:{ all -> 0x0192 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x0192 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x0192 }
            if (r15 == 0) goto L_0x0173
            r4.add(r10)     // Catch:{ all -> 0x0192 }
        L_0x0173:
            int r10 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r10 < 0) goto L_0x0151
            goto L_0x0180
        L_0x0178:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0192 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0180:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0192 }
            kotlin.io.CloseableKt.closeFinally(r8, r7)     // Catch:{ all -> 0x01d1 }
            java.util.Map r2 = buildIndex(r4)     // Catch:{ all -> 0x01d1 }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x01d1 }
            r4.<init>(r0, r1, r2, r12)     // Catch:{ all -> 0x01d1 }
            kotlin.io.CloseableKt.closeFinally(r3, r7)
            return r4
        L_0x0192:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0195 }
        L_0x0195:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r8, r1)     // Catch:{ all -> 0x01d1 }
            throw r2     // Catch:{ all -> 0x01d1 }
        L_0x019b:
            r14.close()     // Catch:{ all -> 0x01d1 }
            r14 = -1
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x01a7
            goto L_0x0081
        L_0x01a7:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01d1 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x01d1 }
            throw r0     // Catch:{ all -> 0x01d1 }
        L_0x01af:
            r0 = move-exception
            r14.close()     // Catch:{ all -> 0x01d1 }
            throw r0     // Catch:{ all -> 0x01d1 }
        L_0x01b4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01d1 }
            java.lang.String r1 = "not a zip: size="
            long r4 = r3.size()     // Catch:{ all -> 0x01d1 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01d1 }
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)     // Catch:{ all -> 0x01d1 }
            r0.<init>(r1)     // Catch:{ all -> 0x01d1 }
            throw r0     // Catch:{ all -> 0x01d1 }
        L_0x01c8:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01cb }
        L_0x01cb:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r8, r1)     // Catch:{ all -> 0x01d1 }
            throw r2     // Catch:{ all -> 0x01d1 }
        L_0x01d1:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01d4 }
        L_0x01d4:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i11, Object obj) throws IOException {
        if ((i11 & 4) != 0) {
            function1 = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry readEntry(@NotNull BufferedSource bufferedSource) throws IOException {
        Ref.LongRef longRef;
        long j11;
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & UShort.MAX_VALUE, bufferedSource.readShortLe() & UShort.MAX_VALUE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef4 = new Ref.LongRef();
                longRef4.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt__StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    if (longRef3.element == 4294967295L) {
                        j11 = ((long) 8) + 0;
                        longRef = longRef4;
                    } else {
                        longRef = longRef4;
                        j11 = 0;
                    }
                    if (longRef2.element == 4294967295L) {
                        j11 += (long) 8;
                    }
                    String str = readUtf8;
                    Ref.LongRef longRef5 = longRef;
                    if (longRef5.element == 4294967295L) {
                        j11 += (long) 8;
                    }
                    long j12 = j11;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Long l11 = dosDateTimeToEpochMillis;
                    ZipKt$readEntry$1 zipKt$readEntry$1 = r0;
                    long j13 = readIntLe2;
                    short s11 = readShortLe2;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    String str2 = str;
                    Ref.LongRef longRef6 = longRef5;
                    short s12 = readShortLe5;
                    ZipKt$readEntry$1 zipKt$readEntry$12 = new ZipKt$readEntry$1(booleanRef, j12, longRef3, bufferedSource, longRef2, longRef6);
                    readExtra(bufferedSource2, readShortLe4, zipKt$readEntry$1);
                    if (j12 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(str3), StringsKt__StringsJVMKt.endsWith$default(str3, "/", false, 2, (Object) null), bufferedSource2.readUtf8((long) s12), j13, longRef2.element, longRef3.element, s11, l11, longRef6.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, 4294967295L & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i11, Function2<? super Integer, ? super Long, Unit> function2) {
        long j11 = (long) i11;
        while (j11 != 0) {
            if (j11 >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j12 = j11 - ((long) 4);
                if (j12 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i12 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i12 >= 0) {
                        if (i12 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j11 = j12 - readShortLe2;
                    } else {
                        throw new IOException(Intrinsics.stringPlus("unsupported zip: too many bytes processed for ", Integer.valueOf(readShortLe)));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        T t11;
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (fileMetadata == null) {
            t11 = null;
        } else {
            t11 = fileMetadata.getLastModifiedAtMillis();
        }
        objectRef.element = t11;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }
}
