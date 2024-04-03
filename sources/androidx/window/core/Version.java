package androidx.window.core;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0000H\u0002J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/window/core/Version;", "", "major", "", "minor", "patch", "description", "", "(IIILjava/lang/String;)V", "bigInteger", "Ljava/math/BigInteger;", "getBigInteger", "()Ljava/math/BigInteger;", "bigInteger$delegate", "Lkotlin/Lazy;", "getDescription", "()Ljava/lang/String;", "getMajor", "()I", "getMinor", "getPatch", "compareTo", "other", "equals", "", "", "hashCode", "toString", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Version implements Comparable<Version> {
    /* access modifiers changed from: private */
    @NotNull
    public static final Version CURRENT;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Version UNKNOWN = new Version(0, 0, 0, "");
    /* access modifiers changed from: private */
    @NotNull
    public static final Version VERSION_0_1 = new Version(0, 1, 0, "");
    /* access modifiers changed from: private */
    @NotNull
    public static final Version VERSION_1_0;
    @NotNull
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    @NotNull
    private final Lazy bigInteger$delegate;
    @NotNull
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "()V", "CURRENT", "Landroidx/window/core/Version;", "getCURRENT", "()Landroidx/window/core/Version;", "UNKNOWN", "getUNKNOWN", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "VERSION_PATTERN_STRING", "", "parse", "versionString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        @NotNull
        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        @NotNull
        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        @NotNull
        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        @JvmStatic
        @Nullable
        public final Version parse(@Nullable String str) {
            Integer num;
            Integer num2;
            Integer num3;
            String str2;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            if (group == null) {
                num = null;
            } else {
                num = Integer.valueOf(Integer.parseInt(group));
            }
            if (num == null) {
                return null;
            }
            int intValue = num.intValue();
            String group2 = matcher.group(2);
            if (group2 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(Integer.parseInt(group2));
            }
            if (num2 == null) {
                return null;
            }
            int intValue2 = num2.intValue();
            String group3 = matcher.group(3);
            if (group3 == null) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(Integer.parseInt(group3));
            }
            if (num3 == null) {
                return null;
            }
            int intValue3 = num3.intValue();
            if (matcher.group(4) != null) {
                str2 = matcher.group(4);
            } else {
                str2 = "";
            }
            String str3 = str2;
            Intrinsics.checkNotNullExpressionValue(str3, "description");
            return new Version(intValue, intValue2, intValue3, str3, (DefaultConstructorMarker) null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }

    private Version(int i11, int i12, int i13, String str) {
        this.major = i11;
        this.minor = i12;
        this.patch = i13;
        this.description = str;
        this.bigInteger$delegate = LazyKt__LazyJVMKt.lazy(new Version$bigInteger$2(this));
    }

    public /* synthetic */ Version(int i11, int i12, int i13, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @JvmStatic
    @Nullable
    public static final Version parse(@Nullable String str) {
        return Companion.parse(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.major == version.major && this.minor == version.minor && this.patch == version.patch) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    @NotNull
    public String toString() {
        String str;
        if (!StringsKt__StringsJVMKt.isBlank(this.description)) {
            str = Intrinsics.stringPlus(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, this.description);
        } else {
            str = "";
        }
        return this.major + '.' + this.minor + '.' + this.patch + str;
    }

    public int compareTo(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "other");
        return getBigInteger().compareTo(version.getBigInteger());
    }
}
