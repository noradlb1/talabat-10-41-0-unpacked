package com.talabat.darkstores.data.tracking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\t\u001a\u0018\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*4\b\u0002\u0010\n\"\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000b2\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000b¨\u0006\u000e"}, d2 = {"NOT_AVAILABLE", "", "orDefault", "", "default", "(Ljava/lang/Double;Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/Float;Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "Event", "Lkotlin/Pair;", "", "Landroid/os/Bundle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BaseTrackerKt {
    @NotNull
    public static final String NOT_AVAILABLE = "N/A";

    @NotNull
    public static final String orDefault(@Nullable Integer num, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        return orDefault(num != null ? num.toString() : null, str);
    }

    public static /* synthetic */ String orDefault$default(Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "N/A";
        }
        return orDefault(num, str);
    }

    @NotNull
    public static final String orDefault(@Nullable Float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        return orDefault(f11 != null ? f11.toString() : null, str);
    }

    public static /* synthetic */ String orDefault$default(Float f11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "N/A";
        }
        return orDefault(f11, str);
    }

    @NotNull
    public static final String orDefault(@Nullable Double d11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        return orDefault(d11 != null ? d11.toString() : null, str);
    }

    public static /* synthetic */ String orDefault$default(Double d11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "N/A";
        }
        return orDefault(d11, str);
    }

    @NotNull
    public static final String orDefault(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "default");
        if (str == null) {
            return str2;
        }
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            str = null;
        }
        return str == null ? str2 : str;
    }

    public static /* synthetic */ String orDefault$default(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "N/A";
        }
        return orDefault(str, str2);
    }
}
