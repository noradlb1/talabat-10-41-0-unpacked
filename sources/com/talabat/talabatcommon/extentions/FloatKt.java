package com.talabat.talabatcommon.extentions;

import com.talabat.talabatcommon.TalabatCommonIntegrationKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0001H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u000bH\u0007\u001a\u0013\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ZERO", "", "density", "convertDpToPixels", "convertPixelsToDp", "isNotZero", "", "isZero", "", "threshold", "orZero", "Lkotlin/Float$Companion;", "(Ljava/lang/Float;)F", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FloatKt {
    public static final float ZERO = 0.0f;

    @FloatDsl
    public static final float convertDpToPixels(float f11) {
        return f11 * density();
    }

    @FloatDsl
    public static final float convertPixelsToDp(float f11) {
        return f11 / density();
    }

    private static final float density() {
        return (float) (TalabatCommonIntegrationKt.getAppContext().getResources().getDisplayMetrics().densityDpi / Opcodes.IF_ICMPNE);
    }

    @FloatDsl
    public static final boolean isNotZero(float f11) {
        return !Float.valueOf(f11).equals(Double.valueOf(0.0d));
    }

    @FloatDsl
    public static final boolean isZero(double d11, double d12) {
        return d11 >= (-d12) && d11 <= d12;
    }

    public static /* synthetic */ boolean isZero$default(double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d12 = 0.0d;
        }
        return isZero(d11, d12);
    }

    @FloatDsl
    public static final float orZero(@Nullable Float f11) {
        if (f11 != null) {
            return f11.floatValue();
        }
        return 0.0f;
    }

    @FloatDsl
    @Deprecated(message = "ZERO can be used instead", replaceWith = @ReplaceWith(expression = "ZERO", imports = {"com.talabat.talabatcommon.extentions"}))
    public static final float orZero(@NotNull FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return 0.0f;
    }
}
