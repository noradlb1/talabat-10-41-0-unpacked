package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.internal.NativeProtocol;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 F2\u00020\u0001:\u0004EFGHB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ$\u0010)\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010*\u001a\u00060+j\u0002`,2\u0006\u0010-\u001a\u00020\u001cH\u0002J\u0013\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J(\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010504H\u0007J\u0010\u00106\u001a\u0002072\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u00108\u001a\u000207H\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010:\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010;\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u000103H\u0002J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u000203H\u0000¢\u0006\u0002\b=J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?H\u0000¢\u0006\u0002\b=J*\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u000105H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u0004\u0018\u00010\u001c8BX\u0002¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR\u0010\u0010'\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\n¨\u0006I"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "uri", "", "(Ljava/lang/String;)V", "uriPattern", "action", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "arguments", "", "argumentsNames", "", "getArgumentsNames$navigation_common_release", "()Ljava/util/List;", "<set-?>", "", "isExactDeepLink", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isParameterizedQuery", "isSingleQueryParamValueOnly", "getMimeType", "mimeTypeFinalRegex", "mimeTypePattern", "Ljava/util/regex/Pattern;", "getMimeTypePattern", "()Ljava/util/regex/Pattern;", "mimeTypePattern$delegate", "Lkotlin/Lazy;", "paramArgMap", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "pattern", "getPattern", "pattern$delegate", "patternFinalRegex", "getUriPattern", "buildPathRegex", "uriRegex", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "fillInPattern", "equals", "other", "getMatchingArguments", "Landroid/os/Bundle;", "deepLink", "Landroid/net/Uri;", "", "Landroidx/navigation/NavArgument;", "getMimeTypeMatchRating", "", "hashCode", "matchAction", "matchMimeType", "matchUri", "matches", "matches$navigation_common_release", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "parseArgument", "bundle", "name", "value", "argument", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLink {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    @Nullable
    private final String action;
    @NotNull
    private final List<String> arguments;
    private boolean isExactDeepLink;
    private boolean isParameterizedQuery;
    private boolean isSingleQueryParamValueOnly;
    @Nullable
    private final String mimeType;
    /* access modifiers changed from: private */
    @Nullable
    public String mimeTypeFinalRegex;
    @NotNull
    private final Lazy mimeTypePattern$delegate;
    @NotNull
    private final Map<String, ParamQuery> paramArgMap;
    @NotNull
    private final Lazy pattern$delegate;
    /* access modifiers changed from: private */
    @Nullable
    public String patternFinalRegex;
    @Nullable
    private final String uriPattern;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Nullable
        private String action;
        @Nullable
        private String mimeType;
        @Nullable
        private String uriPattern;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Builder fromAction(@NotNull String str) {
                boolean z11;
                Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    Builder builder = new Builder();
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            }

            @JvmStatic
            @NotNull
            public final Builder fromMimeType(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(str);
                return builder;
            }

            @JvmStatic
            @NotNull
            public final Builder fromUriPattern(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(str);
                return builder;
            }
        }

        @JvmStatic
        @NotNull
        public static final Builder fromAction(@NotNull String str) {
            return Companion.fromAction(str);
        }

        @JvmStatic
        @NotNull
        public static final Builder fromMimeType(@NotNull String str) {
            return Companion.fromMimeType(str);
        }

        @JvmStatic
        @NotNull
        public static final Builder fromUriPattern(@NotNull String str) {
            return Companion.fromUriPattern(str);
        }

        @NotNull
        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        @NotNull
        public final Builder setAction(@NotNull String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }

        @NotNull
        public final Builder setMimeType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            this.mimeType = str;
            return this;
        }

        @NotNull
        public final Builder setUriPattern(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "uriPattern");
            this.uriPattern = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", "type", "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MimeType implements Comparable<MimeType> {
        @NotNull
        private String subType;
        @NotNull
        private String type;

        public MimeType(@NotNull String str) {
            List list;
            boolean z11;
            Intrinsics.checkNotNullParameter(str, "mimeType");
            List<String> split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (!z11) {
                        list = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                this.type = (String) list.get(0);
                this.subType = (String) list.get(1);
            }
            list = CollectionsKt__CollectionsKt.emptyList();
            this.type = (String) list.get(0);
            this.subType = (String) list.get(1);
        }

        @NotNull
        public final String getSubType() {
            return this.subType;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public final void setSubType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subType = str;
        }

        public final void setType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public int compareTo(@NotNull MimeType mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "other");
            int i11 = Intrinsics.areEqual((Object) this.type, (Object) mimeType.type) ? 2 : 0;
            return Intrinsics.areEqual((Object) this.subType, (Object) mimeType.subType) ? i11 + 1 : i11;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "()V", "arguments", "", "", "getArguments", "()Ljava/util/List;", "paramRegex", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "(Ljava/lang/String;)V", "addArgumentName", "", "name", "getArgumentName", "index", "", "size", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParamQuery {
        @NotNull
        private final List<String> arguments = new ArrayList();
        @Nullable
        private String paramRegex;

        public final void addArgumentName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.arguments.add(str);
        }

        @NotNull
        public final String getArgumentName(int i11) {
            return this.arguments.get(i11);
        }

        @NotNull
        public final List<String> getArguments() {
            return this.arguments;
        }

        @Nullable
        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(@Nullable String str) {
            this.paramRegex = str;
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    public NavDeepLink(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        String str4 = str;
        this.uriPattern = str4;
        this.action = str2;
        this.mimeType = str3;
        this.arguments = new ArrayList();
        this.paramArgMap = new LinkedHashMap();
        this.pattern$delegate = LazyKt__LazyJVMKt.lazy(new NavDeepLink$pattern$2(this));
        this.mimeTypePattern$delegate = LazyKt__LazyJVMKt.lazy(new NavDeepLink$mimeTypePattern$2(this));
        if (str4 != null) {
            Uri parse = Uri.parse(str);
            this.isParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb2 = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str4).find()) {
                sb2.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.isParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str4);
                if (matcher.find()) {
                    String substring = str4.substring(0, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                    this.isExactDeepLink = buildPathRegex(substring, sb2, compile);
                }
                for (String next : parse.getQueryParameterNames()) {
                    StringBuilder sb3 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(next);
                    if (queryParameter == null) {
                        this.isSingleQueryParamValueOnly = true;
                        queryParameter = next;
                    }
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i11 = 0;
                    while (matcher2.find()) {
                        String group = matcher2.group(1);
                        if (group != null) {
                            paramQuery.addArgumentName(group);
                            Intrinsics.checkNotNullExpressionValue(queryParameter, "queryParam");
                            String substring2 = queryParameter.substring(i11, matcher2.start());
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            sb3.append(Pattern.quote(substring2));
                            sb3.append("(.+?)?");
                            i11 = matcher2.end();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    if (i11 < queryParameter.length()) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "queryParam");
                        String substring3 = queryParameter.substring(i11);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                        sb3.append(Pattern.quote(substring3));
                    }
                    String sb4 = sb3.toString();
                    Intrinsics.checkNotNullExpressionValue(sb4, "argRegex.toString()");
                    paramQuery.setParamRegex(StringsKt__StringsJVMKt.replace$default(sb4, ".*", "\\E.*\\Q", false, 4, (Object) null));
                    Map<String, ParamQuery> map = this.paramArgMap;
                    Intrinsics.checkNotNullExpressionValue(next, "paramName");
                    map.put(next, paramQuery);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                this.isExactDeepLink = buildPathRegex(str4, sb2, compile);
            }
            String sb5 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb5, "uriRegex.toString()");
            this.patternFinalRegex = StringsKt__StringsJVMKt.replace$default(sb5, ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
        if (this.mimeType == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            MimeType mimeType2 = new MimeType(this.mimeType);
            this.mimeTypeFinalRegex = StringsKt__StringsJVMKt.replace$default("^(" + mimeType2.getType() + "|[*]+)/(" + mimeType2.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
            return;
        }
        throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
    }

    private final boolean buildPathRegex(String str, StringBuilder sb2, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z11 = !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ".*", false, 2, (Object) null);
        int i11 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                this.arguments.add(group);
                String substring = str.substring(i11, matcher.start());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb2.append(Pattern.quote(substring));
                sb2.append("([^/]+?)");
                i11 = matcher.end();
                z11 = false;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (i11 < str.length()) {
            String substring2 = str.substring(i11);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(Pattern.quote(substring2));
        }
        sb2.append("($|(\\?(.)*)|(\\#(.)*))");
        return z11;
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    private final Pattern getPattern() {
        return (Pattern) this.pattern$delegate.getValue();
    }

    private final boolean matchAction(String str) {
        boolean z11;
        boolean z12;
        if (str == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str2 = this.action;
        if (str2 != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12 && (str == null || Intrinsics.areEqual((Object) str2, (Object) str))) {
            return true;
        }
        return false;
    }

    private final boolean matchMimeType(String str) {
        boolean z11;
        boolean z12;
        if (str == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mimeType != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12) {
            if (str == null) {
                return true;
            }
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private final boolean matchUri(Uri uri) {
        boolean z11;
        boolean z12;
        if (uri == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (getPattern() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12) {
            if (uri == null) {
                return true;
            }
            Pattern pattern = getPattern();
            Intrinsics.checkNotNull(pattern);
            if (pattern.matcher(uri.toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    private final boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.getType().parseAndPut(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        if (!Intrinsics.areEqual((Object) this.uriPattern, (Object) navDeepLink.uriPattern) || !Intrinsics.areEqual((Object) this.action, (Object) navDeepLink.action) || !Intrinsics.areEqual((Object) this.mimeType, (Object) navDeepLink.mimeType)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final List<String> getArgumentsNames$navigation_common_release() {
        Collection collection = this.arguments;
        ArrayList arrayList = new ArrayList();
        for (ParamQuery arguments2 : this.paramArgMap.values()) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, arguments2.getArguments());
        }
        return CollectionsKt___CollectionsKt.plus(collection, arrayList);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle getMatchingArguments(@NotNull Uri uri, @NotNull Map<String, NavArgument> map) {
        Matcher matcher;
        boolean z11;
        Matcher matcher2;
        String str;
        Uri uri2 = uri;
        Map<String, NavArgument> map2 = map;
        Intrinsics.checkNotNullParameter(uri2, "deepLink");
        Intrinsics.checkNotNullParameter(map2, Constant.PARAM_SQL_ARGUMENTS);
        Pattern pattern = getPattern();
        if (pattern != null) {
            matcher = pattern.matcher(uri.toString());
        } else {
            matcher = null;
        }
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.arguments.size();
        int i11 = 0;
        while (i11 < size) {
            String str2 = this.arguments.get(i11);
            i11++;
            String decode = Uri.decode(matcher.group(i11));
            NavArgument navArgument = map2.get(str2);
            try {
                Intrinsics.checkNotNullExpressionValue(decode, "value");
                if (parseArgument(bundle, str2, decode, navArgument)) {
                    return null;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (this.isParameterizedQuery) {
            for (String next : this.paramArgMap.keySet()) {
                ParamQuery paramQuery = this.paramArgMap.get(next);
                String queryParameter = uri2.getQueryParameter(next);
                if (this.isSingleQueryParamValueOnly) {
                    String uri3 = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(uri3, "deepLink.toString()");
                    String substringAfter$default = StringsKt__StringsKt.substringAfter$default(uri3, '?', (String) null, 2, (Object) null);
                    if (!Intrinsics.areEqual((Object) substringAfter$default, (Object) uri3)) {
                        queryParameter = substringAfter$default;
                    }
                }
                if (queryParameter != null) {
                    Intrinsics.checkNotNull(paramQuery);
                    matcher2 = Pattern.compile(paramQuery.getParamRegex(), 32).matcher(queryParameter);
                    if (!matcher2.matches()) {
                        return null;
                    }
                } else {
                    matcher2 = null;
                }
                Bundle bundle2 = new Bundle();
                try {
                    Intrinsics.checkNotNull(paramQuery);
                    int size2 = paramQuery.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        if (matcher2 != null) {
                            str = matcher2.group(i12 + 1);
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = null;
                        }
                        String argumentName = paramQuery.getArgumentName(i12);
                        NavArgument navArgument2 = map2.get(argumentName);
                        if (str != null) {
                            if (!Intrinsics.areEqual((Object) str, (Object) AbstractJsonLexerKt.BEGIN_OBJ + argumentName + AbstractJsonLexerKt.END_OBJ) && parseArgument(bundle2, argumentName, str, navArgument2)) {
                                return null;
                            }
                        }
                    }
                    bundle.putAll(bundle2);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            String str3 = (String) next2.getKey();
            NavArgument navArgument3 = (NavArgument) next2.getValue();
            if (navArgument3 == null || navArgument3.isNullable() || navArgument3.isDefaultValuePresent()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11 && !bundle.containsKey(str3)) {
                return null;
            }
        }
        return bundle;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMimeTypeMatchRating(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(str));
            }
        }
        return -1;
    }

    @Nullable
    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        int i11;
        int i12;
        String str = this.uriPattern;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i11 + 0) * 31;
        String str2 = this.action;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.mimeType;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return i15 + i13;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public final void setExactDeepLink$navigation_common_release(boolean z11) {
        this.isExactDeepLink = z11;
    }

    public final boolean matches$navigation_common_release(@NotNull NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "deepLinkRequest");
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLink(@NotNull String str) {
        this(str, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(str, "uri");
    }
}
