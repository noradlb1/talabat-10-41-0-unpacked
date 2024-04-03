package okhttp3;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.visa.checkout.Profile;
import io.flutter.plugins.firebase.crashlytics.Constants;
import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002('B\u0017\b\u0002\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0004\b%\u0010&J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u001b\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006)"}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "name", "get", "Ljava/util/Date;", "getDate", "j$/time/Instant", "getInstant", "", "-deprecated_size", "()I", "size", "index", "value", "", "names", "", "values", "", "byteCount", "", "iterator", "Lokhttp3/Headers$Builder;", "newBuilder", "", "other", "", "equals", "hashCode", "toString", "", "toMultimap", "", "namesAndValues", "[Ljava/lang/String;", "<init>", "([Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String[] namesAndValues;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000eJ\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000fH\u0002J\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\u0014\u001a\u00020\u000bR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0000X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lokhttp3/Headers$Builder;", "", "", "line", "addLenient$okhttp", "(Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addLenient", "add", "name", "value", "addUnsafeNonAscii", "Lokhttp3/Headers;", "headers", "addAll", "Ljava/util/Date;", "j$/time/Instant", "set", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "removeAll", "get", "build", "", "namesAndValues", "Ljava/util/List;", "getNamesAndValues$okhttp", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {
        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Constants.LINE);
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String obj = StringsKt__StringsKt.trim((CharSequence) substring).toString();
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected header: ", str).toString());
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                addLenient$okhttp(headers.name(i11), headers.value(i11));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Constants.LINE);
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) AbstractJsonLexerKt.COLON, 1, false, 4, (Object) null);
            if (indexOf$default != -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (str.charAt(0) == ':') {
                String substring3 = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", substring3);
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @Nullable
        public final String get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            int size = this.namesAndValues.size() - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return null;
            }
            while (true) {
                int i11 = size - 2;
                if (StringsKt__StringsJVMKt.equals(str, this.namesAndValues.get(size), true)) {
                    return this.namesAndValues.get(size + 1);
                }
                if (size == progressionLastElement) {
                    return null;
                }
                size = i11;
            }
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            int i11 = 0;
            while (i11 < getNamesAndValues$okhttp().size()) {
                if (StringsKt__StringsJVMKt.equals(str, getNamesAndValues$okhttp().get(i11), true)) {
                    getNamesAndValues$okhttp().remove(i11);
                    getNamesAndValues$okhttp().remove(i11);
                    i11 -= 2;
                }
                i11 += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String str, @NotNull Date date) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @NotNull
        @IgnoreJRERequirement
        public final Builder set(@NotNull String str, @NotNull Instant instant) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            getNamesAndValues$okhttp().add(str);
            getNamesAndValues$okhttp().add(StringsKt__StringsKt.trim((CharSequence) str2).toString());
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String str, @NotNull Date date) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @NotNull
        @IgnoreJRERequirement
        public final Builder add(@NotNull String str, @NotNull Instant instant) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void checkName(String str) {
            boolean z11;
            boolean z12;
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int length = str.length();
                int i11 = 0;
                while (i11 < length) {
                    int i12 = i11 + 1;
                    char charAt = str.charAt(i11);
                    if ('!' > charAt || charAt >= 127) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        i11 = i12;
                    } else {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i11), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[LOOP:0: B:1:0x0006->B:20:0x005b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0026 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void checkValue(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = r1
            L_0x0006:
                if (r2 >= r0) goto L_0x005d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L_0x0023
                r5 = 32
                if (r5 > r4) goto L_0x001d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L_0x001d
                r5 = r6
                goto L_0x001e
            L_0x001d:
                r5 = r1
            L_0x001e:
                if (r5 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r5 = r1
                goto L_0x0024
            L_0x0023:
                r5 = r6
            L_0x0024:
                if (r5 != 0) goto L_0x005b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = okhttp3.internal.Util.format(r1, r0)
                boolean r9 = okhttp3.internal.Util.isSensitiveHeader(r9)
                if (r9 == 0) goto L_0x0047
                java.lang.String r8 = ""
                goto L_0x004d
            L_0x0047:
                java.lang.String r9 = ": "
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            L_0x004d:
                java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L_0x005b:
                r2 = r3
                goto L_0x0006
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }

        /* access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
            if (progressionLastElement > length) {
                return null;
            }
            while (true) {
                int i11 = length - 2;
                if (StringsKt__StringsJVMKt.equals(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == progressionLastElement) {
                    return null;
                }
                length = i11;
            }
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m7964deprecated_of(@NotNull String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final Headers of(@NotNull String... strArr) {
            Intrinsics.checkNotNullParameter(strArr, "namesAndValues");
            int i11 = 0;
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                int length = strArr2.length;
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i12 + 1;
                    String str = strArr2[i12];
                    if (str != null) {
                        strArr2[i12] = StringsKt__StringsKt.trim((CharSequence) str).toString();
                        i12 = i13;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr2.length - 1, 2);
                if (progressionLastElement >= 0) {
                    while (true) {
                        int i14 = i11 + 2;
                        String str2 = strArr2[i11];
                        String str3 = strArr2[i11 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i11 == progressionLastElement) {
                            break;
                        }
                        i11 = i14;
                    }
                }
                return new Headers(strArr2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        @JvmName(name = "-deprecated_of")
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m7963deprecated_of(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
            return of(map);
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final Headers of(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            String[] strArr = new String[(map.size() * 2)];
            int i11 = 0;
            for (Map.Entry next : map.entrySet()) {
                String obj = StringsKt__StringsKt.trim((CharSequence) (String) next.getKey()).toString();
                String obj2 = StringsKt__StringsKt.trim((CharSequence) (String) next.getValue()).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i11] = obj;
                strArr[i11 + 1] = obj2;
                i11 += 2;
            }
            return new Headers(strArr, (DefaultConstructorMarker) null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final Headers of(@NotNull Map<String, String> map) {
        return Companion.of(map);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final Headers of(@NotNull String... strArr) {
        return Companion.of(strArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m7962deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i11 = 0; i11 < length2; i11++) {
            length += (long) this.namesAndValues[i11].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    @Nullable
    public final String get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    @Nullable
    public final Date getDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        return DatesKt.toHttpDateOrNull(str2);
    }

    @Nullable
    @IgnoreJRERequirement
    public final Instant getInstant(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Date date = getDate(str);
        if (date == null) {
            return null;
        }
        return DateRetargetClass.toInstant(date);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @NotNull
    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i11 = 0; i11 < size; i11++) {
            pairArr[i11] = TuplesKt.to(name(i11), value(i11));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    @NotNull
    public final String name(int i11) {
        return this.namesAndValues[i11 * 2];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            treeSet.add(name(i11));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(builder.getNamesAndValues$okhttp(), (T[]) this.namesAndValues);
        return builder;
    }

    @JvmName(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            String name2 = name(i11);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            String lowerCase = name2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i11));
            i11 = i12;
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            String name2 = name(i11);
            String value = value(i11);
            sb2.append(name2);
            sb2.append(": ");
            if (Util.isSensitiveHeader(name2)) {
                value = "██";
            }
            sb2.append(value);
            sb2.append(StringUtils.LF);
            i11 = i12;
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public final String value(int i11) {
        return this.namesAndValues[(i11 * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        int size = size();
        ArrayList arrayList = null;
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            if (StringsKt__StringsJVMKt.equals(str, name(i11), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i11));
            }
            i11 = i12;
        }
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }
}
