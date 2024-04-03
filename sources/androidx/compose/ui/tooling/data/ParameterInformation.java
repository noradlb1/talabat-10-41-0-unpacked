package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Landroidx/compose/ui/tooling/data/ParameterInformation;", "", "name", "", "value", "fromDefault", "", "static", "compared", "inlineClass", "stable", "(Ljava/lang/String;Ljava/lang/Object;ZZZLjava/lang/String;Z)V", "getCompared", "()Z", "getFromDefault", "getInlineClass", "()Ljava/lang/String;", "getName", "getStable", "getStatic", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
public final class ParameterInformation {
    public static final int $stable = 8;
    private final boolean compared;
    private final boolean fromDefault;
    @Nullable
    private final String inlineClass;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f10281name;
    private final boolean stable;

    /* renamed from: static  reason: not valid java name */
    private final boolean f47static;
    @Nullable
    private final Object value;

    public ParameterInformation(@NotNull String str, @Nullable Object obj, boolean z11, boolean z12, boolean z13, @Nullable String str2, boolean z14) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f10281name = str;
        this.value = obj;
        this.fromDefault = z11;
        this.f47static = z12;
        this.compared = z13;
        this.inlineClass = str2;
        this.stable = z14;
    }

    public static /* synthetic */ ParameterInformation copy$default(ParameterInformation parameterInformation, String str, Object obj, boolean z11, boolean z12, boolean z13, String str2, boolean z14, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = parameterInformation.f10281name;
        }
        if ((i11 & 2) != 0) {
            obj = parameterInformation.value;
        }
        Object obj3 = obj;
        if ((i11 & 4) != 0) {
            z11 = parameterInformation.fromDefault;
        }
        boolean z15 = z11;
        if ((i11 & 8) != 0) {
            z12 = parameterInformation.f47static;
        }
        boolean z16 = z12;
        if ((i11 & 16) != 0) {
            z13 = parameterInformation.compared;
        }
        boolean z17 = z13;
        if ((i11 & 32) != 0) {
            str2 = parameterInformation.inlineClass;
        }
        String str3 = str2;
        if ((i11 & 64) != 0) {
            z14 = parameterInformation.stable;
        }
        return parameterInformation.copy(str, obj3, z15, z16, z17, str3, z14);
    }

    @NotNull
    public final String component1() {
        return this.f10281name;
    }

    @Nullable
    public final Object component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.fromDefault;
    }

    public final boolean component4() {
        return this.f47static;
    }

    public final boolean component5() {
        return this.compared;
    }

    @Nullable
    public final String component6() {
        return this.inlineClass;
    }

    public final boolean component7() {
        return this.stable;
    }

    @NotNull
    public final ParameterInformation copy(@NotNull String str, @Nullable Object obj, boolean z11, boolean z12, boolean z13, @Nullable String str2, boolean z14) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ParameterInformation(str, obj, z11, z12, z13, str2, z14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParameterInformation)) {
            return false;
        }
        ParameterInformation parameterInformation = (ParameterInformation) obj;
        return Intrinsics.areEqual((Object) this.f10281name, (Object) parameterInformation.f10281name) && Intrinsics.areEqual(this.value, parameterInformation.value) && this.fromDefault == parameterInformation.fromDefault && this.f47static == parameterInformation.f47static && this.compared == parameterInformation.compared && Intrinsics.areEqual((Object) this.inlineClass, (Object) parameterInformation.inlineClass) && this.stable == parameterInformation.stable;
    }

    public final boolean getCompared() {
        return this.compared;
    }

    public final boolean getFromDefault() {
        return this.fromDefault;
    }

    @Nullable
    public final String getInlineClass() {
        return this.inlineClass;
    }

    @NotNull
    public final String getName() {
        return this.f10281name;
    }

    public final boolean getStable() {
        return this.stable;
    }

    public final boolean getStatic() {
        return this.f47static;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.f10281name.hashCode() * 31;
        Object obj = this.value;
        int i11 = 0;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        boolean z11 = this.fromDefault;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.f47static;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.compared;
        if (z14) {
            z14 = true;
        }
        int i14 = (i13 + (z14 ? 1 : 0)) * 31;
        String str = this.inlineClass;
        if (str != null) {
            i11 = str.hashCode();
        }
        int i15 = (i14 + i11) * 31;
        boolean z15 = this.stable;
        if (!z15) {
            z12 = z15;
        }
        return i15 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ParameterInformation(name=" + this.f10281name + ", value=" + this.value + ", fromDefault=" + this.fromDefault + ", static=" + this.f47static + ", compared=" + this.compared + ", inlineClass=" + this.inlineClass + ", stable=" + this.stable + ')';
    }
}
