package okhttp3;

import com.google.common.net.HttpHeaders;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import l.a;
import n.e;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cookie {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    @NotNull
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f27525name;
    @NotNull
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private String domain;
        private long expiresAt = DatesKt.MAX_DATE;
        private boolean hostOnly;
        private boolean httpOnly;
        @Nullable

        /* renamed from: name  reason: collision with root package name */
        private String f27526name;
        @NotNull
        private String path = "/";
        private boolean persistent;
        private boolean secure;
        @Nullable
        private String value;

        @NotNull
        public final Cookie build() {
            String str = this.f27526name;
            if (str != null) {
                String str2 = this.value;
                if (str2 != null) {
                    long j11 = this.expiresAt;
                    String str3 = this.domain;
                    if (str3 != null) {
                        return new Cookie(str, str2, j11, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, (DefaultConstructorMarker) null);
                    }
                    throw new NullPointerException("builder.domain == null");
                }
                throw new NullPointerException("builder.value == null");
            }
            throw new NullPointerException("builder.name == null");
        }

        @NotNull
        public final Builder domain(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "domain");
            return domain(str, false);
        }

        @NotNull
        public final Builder expiresAt(long j11) {
            if (j11 <= 0) {
                j11 = Long.MIN_VALUE;
            }
            if (j11 > DatesKt.MAX_DATE) {
                j11 = 253402300799999L;
            }
            this.expiresAt = j11;
            this.persistent = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "domain");
            return domain(str, true);
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Builder name(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            if (Intrinsics.areEqual((Object) StringsKt__StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                this.f27526name = str;
                return this;
            }
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        @NotNull
        public final Builder path(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            if (StringsKt__StringsJVMKt.startsWith$default(str, "/", false, 2, (Object) null)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (Intrinsics.areEqual((Object) StringsKt__StringsKt.trim((CharSequence) str).toString(), (Object) str)) {
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        private final Builder domain(String str, boolean z11) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z11;
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected domain: ", str));
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
            if (r1 != ':') goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int dateCharacterOffset(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L_0x0000:
                if (r7 >= r8) goto L_0x0049
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                if (r1 >= r2) goto L_0x0011
                r2 = 9
                if (r1 != r2) goto L_0x0041
            L_0x0011:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L_0x0041
                r2 = 57
                r4 = 0
                if (r1 > r2) goto L_0x0020
                r2 = 48
                if (r2 > r1) goto L_0x0020
                r2 = r3
                goto L_0x0021
            L_0x0020:
                r2 = r4
            L_0x0021:
                if (r2 != 0) goto L_0x0041
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L_0x002d
                r2 = 97
                if (r2 > r1) goto L_0x002d
                r2 = r3
                goto L_0x002e
            L_0x002d:
                r2 = r4
            L_0x002e:
                if (r2 != 0) goto L_0x0041
                r2 = 90
                if (r1 > r2) goto L_0x003a
                r2 = 65
                if (r2 > r1) goto L_0x003a
                r2 = r3
                goto L_0x003b
            L_0x003a:
                r2 = r4
            L_0x003b:
                if (r2 != 0) goto L_0x0041
                r2 = 58
                if (r1 != r2) goto L_0x0042
            L_0x0041:
                r4 = r3
            L_0x0042:
                r1 = r9 ^ 1
                if (r4 != r1) goto L_0x0047
                return r7
            L_0x0047:
                r7 = r0
                goto L_0x0000
            L_0x0049:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        /* access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                return true;
            }
            if (!StringsKt__StringsJVMKt.endsWith$default(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.canParseAsIpAddress(str)) {
                return false;
            }
            return true;
        }

        private final String parseDomain(String str) {
            if (!StringsKt__StringsJVMKt.endsWith$default(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, false, 2, (Object) null)) {
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.removePrefix(str, (CharSequence) RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
                if (canonicalHost != null) {
                    return canonicalHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseExpires(String str, int i11, int i12) {
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            boolean z18;
            String str2 = str;
            int i13 = i12;
            int dateCharacterOffset = dateCharacterOffset(str2, i11, i13, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str2);
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            while (dateCharacterOffset < i13) {
                int dateCharacterOffset2 = dateCharacterOffset(str2, dateCharacterOffset + 1, i13, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i15 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i15 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i18 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i19 = Integer.parseInt(group3);
                } else if (i16 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i16 = Integer.parseInt(group4);
                } else if (i17 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                    String lowerCase = group5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                    i17 = StringsKt__StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i14 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i14 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str2, dateCharacterOffset2 + 1, i13, false);
            }
            if (70 > i14 || i14 >= 100) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i14 += 1900;
            }
            if (i14 < 0 || i14 >= 70) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                i14 += 2000;
            }
            if (i14 >= 1601) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                if (i17 != -1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z14) {
                    if (1 > i16 || i16 >= 32) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (z15) {
                        if (i15 < 0 || i15 >= 24) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            if (i18 < 0 || i18 >= 60) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (z17) {
                                if (i19 < 0 || i19 >= 60) {
                                    z18 = false;
                                } else {
                                    z18 = true;
                                }
                                if (z18) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i14);
                                    gregorianCalendar.set(2, i17 - 1);
                                    gregorianCalendar.set(5, i16);
                                    gregorianCalendar.set(11, i15);
                                    gregorianCalendar.set(12, i18);
                                    gregorianCalendar.set(13, i19);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e11) {
                if (!new Regex("-?\\d+").matches(str)) {
                    throw e11;
                } else if (StringsKt__StringsJVMKt.startsWith$default(str, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return Long.MAX_VALUE;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.areEqual((Object) encodedPath, (Object) str)) {
                return true;
            }
            if (!StringsKt__StringsJVMKt.startsWith$default(encodedPath, str, false, 2, (Object) null) || (!StringsKt__StringsJVMKt.endsWith$default(str, "/", false, 2, (Object) null) && encodedPath.charAt(str.length()) != '/')) {
                return false;
            }
            return true;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String str) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Intrinsics.checkNotNullParameter(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
            if (r1 > okhttp3.internal.http.DatesKt.MAX_DATE) goto L_0x010a;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0137 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0138  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.Cookie parse$okhttp(long r26, @org.jetbrains.annotations.NotNull okhttp3.HttpUrl r28, @org.jetbrains.annotations.NotNull java.lang.String r29) {
            /*
                r25 = this;
                r0 = r25
                r7 = r29
                java.lang.String r1 = "url"
                r8 = r28
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
                java.lang.String r1 = "setCookie"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
                r2 = 59
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                r1 = r29
                int r9 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 61
                r5 = 2
                r4 = r9
                int r1 = okhttp3.internal.Util.delimiterOffset$default((java.lang.String) r1, (char) r2, (int) r3, (int) r4, (int) r5, (java.lang.Object) r6)
                r2 = 0
                if (r1 != r9) goto L_0x0028
                return r2
            L_0x0028:
                r3 = 0
                r4 = 1
                java.lang.String r11 = okhttp3.internal.Util.trimSubstring$default(r7, r3, r1, r4, r2)
                int r5 = r11.length()
                if (r5 != 0) goto L_0x0036
                r5 = r4
                goto L_0x0037
            L_0x0036:
                r5 = r3
            L_0x0037:
                if (r5 != 0) goto L_0x016e
                int r5 = okhttp3.internal.Util.indexOfControlOrNonAscii(r11)
                r6 = -1
                if (r5 == r6) goto L_0x0042
                goto L_0x016e
            L_0x0042:
                int r1 = r1 + r4
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r7, r1, r9)
                int r1 = okhttp3.internal.Util.indexOfControlOrNonAscii(r12)
                if (r1 == r6) goto L_0x004e
                return r2
            L_0x004e:
                int r9 = r9 + r4
                int r1 = r29.length()
                r5 = -1
                r10 = r2
                r22 = r10
                r17 = r3
                r18 = r17
                r19 = r18
                r20 = r4
                r15 = r5
                r23 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0066:
                if (r9 >= r1) goto L_0x00d6
                r2 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r2, (int) r9, (int) r1)
                r13 = 61
                int r13 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r7, (char) r13, (int) r9, (int) r2)
                java.lang.String r9 = okhttp3.internal.Util.trimSubstring(r7, r9, r13)
                if (r13 >= r2) goto L_0x0081
                int r13 = r13 + 1
                java.lang.String r13 = okhttp3.internal.Util.trimSubstring(r7, r13, r2)
                goto L_0x0083
            L_0x0081:
                java.lang.String r13 = ""
            L_0x0083:
                java.lang.String r14 = "expires"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r14, r4)
                if (r14 == 0) goto L_0x0094
                int r9 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00d2 }
                long r23 = r0.parseExpires(r13, r3, r9)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                goto L_0x00a0
            L_0x0094:
                java.lang.String r14 = "max-age"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r14, r4)
                if (r14 == 0) goto L_0x00a3
                long r15 = r0.parseMaxAge(r13)     // Catch:{  }
            L_0x00a0:
                r19 = r4
                goto L_0x00d2
            L_0x00a3:
                java.lang.String r14 = "domain"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r14, r4)
                if (r14 == 0) goto L_0x00b2
                java.lang.String r10 = r0.parseDomain(r13)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                r20 = r3
                goto L_0x00d2
            L_0x00b2:
                java.lang.String r14 = "path"
                boolean r14 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r14, r4)
                if (r14 == 0) goto L_0x00bd
                r22 = r13
                goto L_0x00d2
            L_0x00bd:
                java.lang.String r13 = "secure"
                boolean r13 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r13, r4)
                if (r13 == 0) goto L_0x00c8
                r17 = r4
                goto L_0x00d2
            L_0x00c8:
                java.lang.String r13 = "httponly"
                boolean r9 = kotlin.text.StringsKt__StringsJVMKt.equals(r9, r13, r4)
                if (r9 == 0) goto L_0x00d2
                r18 = r4
            L_0x00d2:
                int r9 = r2 + 1
                r2 = 0
                goto L_0x0066
            L_0x00d6:
                r1 = -9223372036854775808
                int r4 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x00de
            L_0x00dc:
                r13 = r1
                goto L_0x010e
            L_0x00de:
                int r1 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x010c
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00f0
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r15 = r15 * r1
                goto L_0x00f5
            L_0x00f0:
                r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00f5:
                long r1 = r26 + r15
                int r4 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
                if (r4 < 0) goto L_0x0105
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00dc
                goto L_0x010a
            L_0x0105:
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x010a:
                r13 = r4
                goto L_0x010e
            L_0x010c:
                r13 = r23
            L_0x010e:
                java.lang.String r1 = r28.host()
                if (r10 != 0) goto L_0x0117
                r15 = r1
                r2 = 0
                goto L_0x0121
            L_0x0117:
                boolean r2 = r0.domainMatch(r1, r10)
                if (r2 != 0) goto L_0x011f
                r2 = 0
                return r2
            L_0x011f:
                r2 = 0
                r15 = r10
            L_0x0121:
                int r1 = r1.length()
                int r4 = r15.length()
                if (r1 == r4) goto L_0x0138
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.get()
                java.lang.String r1 = r1.getEffectiveTldPlusOne(r15)
                if (r1 != 0) goto L_0x0138
                return r2
            L_0x0138:
                java.lang.String r1 = "/"
                r4 = r22
                if (r4 == 0) goto L_0x0149
                r5 = 2
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r4, r1, r3, r5, r2)
                if (r2 != 0) goto L_0x0146
                goto L_0x0149
            L_0x0146:
                r16 = r4
                goto L_0x0165
            L_0x0149:
                java.lang.String r2 = r28.encodedPath()
                r6 = 47
                r7 = 0
                r8 = 0
                r9 = 6
                r10 = 0
                r5 = r2
                int r4 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r5, (char) r6, (int) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)
                if (r4 == 0) goto L_0x0163
                java.lang.String r1 = r2.substring(r3, r4)
                java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L_0x0163:
                r16 = r1
            L_0x0165:
                okhttp3.Cookie r1 = new okhttp3.Cookie
                r21 = 0
                r10 = r1
                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
                return r1
            L_0x016e:
                r1 = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Intrinsics.checkNotNullParameter(headers, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            ArrayList arrayList = null;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                Cookie parse = parse(httpUrl, values.get(i11));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
                i11 = i12;
            }
            if (arrayList == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }

    private Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f27525name = str;
        this.value = str2;
        this.expiresAt = j11;
        this.domain = str3;
        this.path = str4;
        this.secure = z11;
        this.httpOnly = z12;
        this.persistent = z13;
        this.hostOnly = z14;
    }

    public /* synthetic */ Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, str3, str4, z11, z12, z13, z14);
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    @JvmName(name = "-deprecated_domain")
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m7944deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    @JvmName(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m7945deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    @JvmName(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m7946deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    @JvmName(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m7947deprecated_httpOnly() {
        return this.httpOnly;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    @JvmName(name = "-deprecated_name")
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m7948deprecated_name() {
        return this.f27525name;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    @JvmName(name = "-deprecated_path")
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m7949deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    @JvmName(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m7950deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    @JvmName(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m7951deprecated_secure() {
        return this.secure;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    @JvmName(name = "-deprecated_value")
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m7952deprecated_value() {
        return this.value;
    }

    @NotNull
    @JvmName(name = "domain")
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics.areEqual((Object) cookie.f27525name, (Object) this.f27525name) && Intrinsics.areEqual((Object) cookie.value, (Object) this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual((Object) cookie.domain, (Object) this.domain) && Intrinsics.areEqual((Object) cookie.path, (Object) this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
            return false;
        }
        return false;
    }

    @JvmName(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f27525name.hashCode()) * 31) + this.value.hashCode()) * 31) + a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + e.a(this.secure)) * 31) + e.a(this.httpOnly)) * 31) + e.a(this.persistent)) * 31) + e.a(this.hostOnly);
    }

    @JvmName(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl httpUrl) {
        boolean z11;
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        if (this.hostOnly) {
            z11 = Intrinsics.areEqual((Object) httpUrl.host(), (Object) this.domain);
        } else {
            z11 = Companion.domainMatch(httpUrl.host(), this.domain);
        }
        if (!z11 || !Companion.pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    @NotNull
    @JvmName(name = "name")
    public final String name() {
        return this.f27525name;
    }

    @NotNull
    @JvmName(name = "path")
    public final String path() {
        return this.path;
    }

    @JvmName(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    @NotNull
    public final String toString$okhttp(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name());
        sb2.append(SignatureVisitor.INSTANCEOF);
        sb2.append(value());
        if (persistent()) {
            if (expiresAt() == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(expiresAt())));
            }
        }
        if (!hostOnly()) {
            sb2.append("; domain=");
            if (z11) {
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            }
            sb2.append(domain());
        }
        sb2.append("; path=");
        sb2.append(path());
        if (secure()) {
            sb2.append("; secure");
        }
        if (httpOnly()) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString()");
        return sb3;
    }

    @NotNull
    @JvmName(name = "value")
    public final String value() {
        return this.value;
    }
}
