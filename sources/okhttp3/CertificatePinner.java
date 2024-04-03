package okhttp3;

import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.flutter.map.constants.Param;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000¢\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CertificatePinner {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final CertificatePinner DEFAULT = new Builder().build();
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @NotNull
    private final Set<Pin> pins;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @NotNull
        private final List<Pin> pins = new ArrayList();

        @NotNull
        public final Builder add(@NotNull String str, @NotNull String... strArr) {
            Intrinsics.checkNotNullParameter(str, Param.PATTERN);
            Intrinsics.checkNotNullParameter(strArr, "pins");
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                String str2 = strArr[i11];
                i11++;
                getPins().add(new Pin(str, str2));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.toSet(this.pins), (CertificateChainCleaner) null, 2, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", "", "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return Intrinsics.stringPlus("sha256/", sha256Hash((X509Certificate) certificate).base64());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.Companion;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha256();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "getHashAlgorithm", "()Ljava/lang/String;", "getPattern", "equals", "", "other", "hashCode", "", "matchesCertificate", "certificate", "Ljava/security/cert/X509Certificate;", "matchesHostname", "hostname", "toString", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Pin {
        @NotNull
        private final ByteString hash;
        @NotNull
        private final String hashAlgorithm;
        @NotNull
        private final String pattern;

        public Pin(@NotNull String str, @NotNull String str2) {
            boolean z11;
            Intrinsics.checkNotNullParameter(str, Param.PATTERN);
            Intrinsics.checkNotNullParameter(str2, "pin");
            if ((!StringsKt__StringsJVMKt.startsWith$default(str, "*.", false, 2, (Object) null) || StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 1, false, 4, (Object) null) != -1) && ((!StringsKt__StringsJVMKt.startsWith$default(str, "**.", false, 2, (Object) null) || StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 2, false, 4, (Object) null) != -1) && StringsKt__StringsKt.indexOf$default((CharSequence) str, "*", 0, false, 6, (Object) null) != -1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                String canonicalHost = HostnamesKt.toCanonicalHost(str);
                if (canonicalHost != null) {
                    this.pattern = canonicalHost;
                    if (StringsKt__StringsJVMKt.startsWith$default(str2, "sha1/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.Companion;
                        String substring = str2.substring(5);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase64 = companion.decodeBase64(substring);
                        if (decodeBase64 != null) {
                            this.hash = decodeBase64;
                            return;
                        }
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", str2));
                    } else if (StringsKt__StringsJVMKt.startsWith$default(str2, "sha256/", false, 2, (Object) null)) {
                        this.hashAlgorithm = "sha256";
                        ByteString.Companion companion2 = ByteString.Companion;
                        String substring2 = str2.substring(7);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase642 = companion2.decodeBase64(substring2);
                        if (decodeBase642 != null) {
                            this.hash = decodeBase642;
                            return;
                        }
                        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pin hash: ", str2));
                    } else {
                        throw new IllegalArgumentException(Intrinsics.stringPlus("pins must start with 'sha256/' or 'sha1/': ", str2));
                    }
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid pattern: ", str));
                }
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected pattern: ", str).toString());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            if (Intrinsics.areEqual((Object) this.pattern, (Object) pin.pattern) && Intrinsics.areEqual((Object) this.hashAlgorithm, (Object) pin.hashAlgorithm) && Intrinsics.areEqual((Object) this.hash, (Object) pin.hash)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@NotNull X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (Intrinsics.areEqual((Object) str, (Object) "sha256")) {
                return Intrinsics.areEqual((Object) this.hash, (Object) CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (Intrinsics.areEqual((Object) str, (Object) "sha1")) {
                return Intrinsics.areEqual((Object) this.hash, (Object) CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "hostname");
            if (StringsKt__StringsJVMKt.startsWith$default(this.pattern, "**.", false, 2, (Object) null)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                if (!StringsKt__StringsJVMKt.regionMatches$default(str, str.length() - length, this.pattern, 3, length, false, 16, (Object) null)) {
                    return false;
                }
                if (!(length2 == 0 || str.charAt(length2 - 1) == '.')) {
                    return false;
                }
            } else if (!StringsKt__StringsJVMKt.startsWith$default(this.pattern, "*.", false, 2, (Object) null)) {
                return Intrinsics.areEqual((Object) str, (Object) this.pattern);
            } else {
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                if (!StringsKt__StringsJVMKt.regionMatches$default(str, str.length() - length3, this.pattern, 1, length3, false, 16, (Object) null)) {
                    return false;
                }
                if (StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', length4 - 1, false, 4, (Object) null) != -1) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(@NotNull Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner2) {
        Intrinsics.checkNotNullParameter(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@NotNull String str, @NotNull List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Intrinsics.checkNotNullParameter(list, "peerCertificates");
        check$okhttp(str, new CertificatePinner$check$1(this, list, str));
    }

    public final void check$okhttp(@NotNull String str, @NotNull Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Intrinsics.checkNotNullParameter(function0, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            List<X509Certificate> list = (List) function0.invoke();
            for (X509Certificate x509Certificate : list) {
                Iterator<Pin> it = findMatchingPins.iterator();
                ByteString byteString = null;
                ByteString byteString2 = null;
                while (true) {
                    if (it.hasNext()) {
                        Pin next = it.next();
                        String hashAlgorithm = next.getHashAlgorithm();
                        if (Intrinsics.areEqual((Object) hashAlgorithm, (Object) "sha256")) {
                            if (byteString == null) {
                                byteString = Companion.sha256Hash(x509Certificate);
                            }
                            if (Intrinsics.areEqual((Object) next.getHash(), (Object) byteString)) {
                                return;
                            }
                        } else if (Intrinsics.areEqual((Object) hashAlgorithm, (Object) "sha1")) {
                            if (byteString2 == null) {
                                byteString2 = Companion.sha1Hash(x509Certificate);
                            }
                            if (Intrinsics.areEqual((Object) next.getHash(), (Object) byteString2)) {
                                return;
                            }
                        } else {
                            throw new AssertionError(Intrinsics.stringPlus("unsupported hashAlgorithm: ", next.getHashAlgorithm()));
                        }
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list) {
                sb2.append("\n    ");
                sb2.append(Companion.pin(x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(CertificateUtil.DELIMITER);
            for (Pin append : findMatchingPins) {
                sb2.append("\n    ");
                sb2.append(append);
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb3);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!Intrinsics.areEqual((Object) certificatePinner.pins, (Object) this.pins) || !Intrinsics.areEqual((Object) certificatePinner.certificateChainCleaner, (Object) this.certificateChainCleaner)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> emptyList = CollectionsKt__CollectionsKt.emptyList();
        for (T next : set) {
            if (((Pin) next).matchesHostname(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                TypeIntrinsics.asMutableList(emptyList).add(next);
            }
        }
        return emptyList;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i11;
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        if (certificateChainCleaner2 != null) {
            i11 = certificateChainCleaner2.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner2) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner2, "certificateChainCleaner");
        if (Intrinsics.areEqual((Object) this.certificateChainCleaner, (Object) certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    @Deprecated(message = "replaced with {@link #check(String, List)}.", replaceWith = @ReplaceWith(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void check(@NotNull String str, @NotNull Certificate... certificateArr) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(str, "hostname");
        Intrinsics.checkNotNullParameter(certificateArr, "peerCertificates");
        check(str, (List<? extends Certificate>) ArraysKt___ArraysKt.toList((T[]) certificateArr));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i11 & 2) != 0 ? null : certificateChainCleaner2);
    }
}
