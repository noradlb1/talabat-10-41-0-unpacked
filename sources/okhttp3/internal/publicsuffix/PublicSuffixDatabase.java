package okhttp3.internal.publicsuffix;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PublicSuffixDatabase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    private static final List<String> PREVAILING_RULE = CollectionsKt__CollectionsJVMKt.listOf("*");
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    @NotNull
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    @NotNull
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i11) {
            int i12;
            boolean z11;
            int i13;
            int and;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i14 = 0;
            while (i14 < length) {
                int i15 = (i14 + length) / 2;
                while (i15 > -1 && bArr3[i15] != 10) {
                    i15--;
                }
                int i16 = i15 + 1;
                int i17 = 1;
                while (true) {
                    i12 = i16 + i17;
                    if (bArr3[i12] == 10) {
                        break;
                    }
                    i17++;
                }
                int i18 = i12 - i16;
                int i19 = i11;
                boolean z12 = false;
                int i21 = 0;
                int i22 = 0;
                while (true) {
                    if (z12) {
                        i13 = 46;
                        z11 = false;
                    } else {
                        z11 = z12;
                        i13 = Util.and(bArr4[i19][i21], 255);
                    }
                    and = i13 - Util.and(bArr3[i16 + i22], 255);
                    if (and == 0) {
                        i22++;
                        i21++;
                        if (i22 == i18) {
                            break;
                        } else if (bArr4[i19].length != i21) {
                            z12 = z11;
                        } else if (i19 == bArr4.length - 1) {
                            break;
                        } else {
                            i19++;
                            i21 = -1;
                            z12 = true;
                        }
                    } else {
                        break;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i23 = i18 - i22;
                        int length2 = bArr4[i19].length - i21;
                        int length3 = bArr4.length;
                        for (int i24 = i19 + 1; i24 < length3; i24++) {
                            length2 += bArr4[i24].length;
                        }
                        if (length2 >= i23) {
                            if (length2 <= i23) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr3, i16, i18, charset);
                            }
                        }
                    }
                    i14 = i12 + 1;
                }
                length = i16 - 1;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        boolean z11;
        List<String> list2;
        String str;
        String str2;
        String str3;
        List<String> list3;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int size = list.size();
            byte[][] bArr = new byte[size][];
            for (int i11 = 0; i11 < size; i11++) {
                Charset charset = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                byte[] bytes = list.get(i11).getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i11] = bytes;
            }
            int i12 = 0;
            while (true) {
                list2 = null;
                if (i12 >= size) {
                    str = null;
                    break;
                }
                int i13 = i12 + 1;
                Companion companion = Companion;
                byte[] bArr2 = this.publicSuffixListBytes;
                if (bArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr2 = null;
                }
                String access$binarySearch = companion.binarySearch(bArr2, bArr, i12);
                if (access$binarySearch != null) {
                    str = access$binarySearch;
                    break;
                }
                i12 = i13;
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    int i15 = i14 + 1;
                    bArr3[i14] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String access$binarySearch2 = companion2.binarySearch(bArr4, bArr3, i14);
                    if (access$binarySearch2 != null) {
                        str2 = access$binarySearch2;
                        break;
                    }
                    i14 = i15;
                }
            }
            str2 = null;
            if (str2 != null) {
                int i16 = size - 1;
                int i17 = 0;
                while (true) {
                    if (i17 >= i16) {
                        break;
                    }
                    int i18 = i17 + 1;
                    Companion companion3 = Companion;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    str3 = companion3.binarySearch(bArr5, bArr, i17);
                    if (str3 != null) {
                        break;
                    }
                    i17 = i18;
                }
            }
            str3 = null;
            if (str3 != null) {
                return StringsKt__StringsKt.split$default((CharSequence) Intrinsics.stringPlus("!", str3), new char[]{'.'}, false, 0, 6, (Object) null);
            } else if (str == null && str2 == null) {
                return PREVAILING_RULE;
            } else {
                if (str == null) {
                    list3 = null;
                } else {
                    list3 = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
                }
                if (list3 == null) {
                    list3 = CollectionsKt__CollectionsKt.emptyList();
                }
                if (str2 != null) {
                    list2 = StringsKt__StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null);
                }
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                if (list3.size() > list2.size()) {
                    return list3;
                }
                return list2;
            }
        } else {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r5 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            okio.GzipSource r1 = new okio.GzipSource
            okio.Source r0 = okio.Okio.source((java.io.InputStream) r0)
            r1.<init>(r0)
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            okio.BufferedSource r1 = (okio.BufferedSource) r1     // Catch:{ all -> 0x004a }
            int r2 = r1.readInt()     // Catch:{ all -> 0x004a }
            long r2 = (long) r2     // Catch:{ all -> 0x004a }
            byte[] r2 = r1.readByteArray(r2)     // Catch:{ all -> 0x004a }
            int r3 = r1.readInt()     // Catch:{ all -> 0x004a }
            long r3 = (long) r3     // Catch:{ all -> 0x004a }
            byte[] r1 = r1.readByteArray(r3)     // Catch:{ all -> 0x004a }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            monitor-enter(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0047 }
            r5.publicSuffixListBytes = r2     // Catch:{ all -> 0x0047 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0047 }
            r5.publicSuffixExceptionListBytes = r1     // Catch:{ all -> 0x0047 }
            monitor-exit(r5)
            java.util.concurrent.CountDownLatch r0 = r5.readCompleteLatch
            r0.countDown()
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x004a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004c }
        L_0x004c:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002c
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private final List<String> splitDomain(String str) {
        List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt___CollectionsKt.last(split$default), (Object) "")) {
            return CollectionsKt___CollectionsKt.dropLast(split$default, 1);
        }
        return split$default;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String str) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            i12 = splitDomain.size();
            i11 = findMatchingRule.size();
        } else {
            i12 = splitDomain.size();
            i11 = findMatchingRule.size() + 1;
        }
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.drop(CollectionsKt___CollectionsKt.asSequence(splitDomain(str)), i12 - i11), RealDiscoveryConfigurationRepository.VERSION_DELIMETER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final void setListBytes(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
