package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\b¢\u0006\u0002\u0010\t\u001au\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\n*\u00020\u0003\"\b\b\u0003\u0010\u0001*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\f¢\u0006\u0002\u0010\r\u001a\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\n*\u00020\u0003\"\b\b\u0003\u0010\u000e*\u00020\u0003\"\b\b\u0004\u0010\u0001*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2\b\u0010\u000f\u001a\u0004\u0018\u0001H\u000e2&\u0010\u0007\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000e\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0010¢\u0006\u0002\u0010\u0011\u001a©\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\n*\u00020\u0003\"\b\b\u0003\u0010\u000e*\u00020\u0003\"\b\b\u0004\u0010\u0012*\u00020\u0003\"\b\b\u0005\u0010\u0001*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\b\u0010\u000b\u001a\u0004\u0018\u0001H\n2\b\u0010\u000f\u001a\u0004\u0018\u0001H\u000e2\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00122,\u0010\u0007\u001a(\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0014¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"safeLet", "R", "T1", "", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SafeLetKt {
    @Nullable
    public static final <T1, T2, R> R safeLet(@Nullable T1 t12, @Nullable T2 t22, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (t12 == null || t22 == null) {
            return null;
        }
        return function2.invoke(t12, t22);
    }

    @Nullable
    public static final <T1, T2, T3, R> R safeLet(@Nullable T1 t12, @Nullable T2 t22, @Nullable T3 t32, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        if (t12 == null || t22 == null || t32 == null) {
            return null;
        }
        return function3.invoke(t12, t22, t32);
    }

    @Nullable
    public static final <T1, T2, T3, T4, R> R safeLet(@Nullable T1 t12, @Nullable T2 t22, @Nullable T3 t32, @Nullable T4 t42, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        if (t12 == null || t22 == null || t32 == null || t42 == null) {
            return null;
        }
        return function4.invoke(t12, t22, t32, t42);
    }

    @Nullable
    public static final <T1, T2, T3, T4, T5, R> R safeLet(@Nullable T1 t12, @Nullable T2 t22, @Nullable T3 t32, @Nullable T4 t42, @Nullable T5 t52, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        if (t12 == null || t22 == null || t32 == null || t42 == null || t52 == null) {
            return null;
        }
        return function5.invoke(t12, t22, t32, t42, t52);
    }
}
