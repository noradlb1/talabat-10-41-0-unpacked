package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0016J:\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameters", "", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ComposableMethod {
    public static final int $stable = 8;
    @NotNull
    private final ComposableInfo composableInfo;
    @NotNull
    private final Method method;

    public ComposableMethod(@NotNull Method method2, @NotNull ComposableInfo composableInfo2) {
        Intrinsics.checkNotNullParameter(method2, "method");
        Intrinsics.checkNotNullParameter(composableInfo2, "composableInfo");
        this.method = method2;
        this.composableInfo = composableInfo2;
    }

    @NotNull
    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ComposableMethod) {
            return Intrinsics.areEqual((Object) this.method, (Object) ((ComposableMethod) obj).method);
        }
        return false;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    @NotNull
    public final Parameter[] getParameters() {
        Parameter[] a11 = this.method.getParameters();
        Intrinsics.checkNotNullExpressionValue(a11, "method.parameters");
        return (Parameter[]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) a11, 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    @Nullable
    public final Object invoke(@NotNull Composer composer, @Nullable Object obj, @NotNull Object... objArr) {
        boolean z11;
        int i11;
        boolean z12;
        boolean z13;
        int i12;
        Object[] objArr2 = objArr;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(composer2, "composer");
        Intrinsics.checkNotNullParameter(objArr2, StepData.ARGS);
        ComposableInfo composableInfo2 = this.composableInfo;
        int component2 = composableInfo2.component2();
        int component3 = composableInfo2.component3();
        int component4 = composableInfo2.component4();
        int length = this.method.getParameterTypes().length;
        int i13 = component2 + 1;
        int i14 = component3 + i13;
        Object[] objArr3 = new Integer[component4];
        for (int i15 = 0; i15 < component4; i15++) {
            int i16 = i15 * 31;
            IntRange until = RangesKt___RangesKt.until(i16, Math.min(i16 + 31, component2));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if (nextInt >= objArr2.length || objArr2[nextInt] == null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                arrayList.add(Integer.valueOf(i12));
            }
            int i17 = 0;
            int i18 = 0;
            for (Object next : arrayList) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                i17 |= ((Number) next).intValue() << i18;
                i18 = i19;
            }
            objArr3[i15] = Integer.valueOf(i17);
        }
        Object[] objArr4 = new Object[length];
        for (int i21 = 0; i21 < length; i21++) {
            if (i21 < 0 || i21 >= component2) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (i21 < 0 || i21 > ArraysKt___ArraysKt.getLastIndex((T[]) objArr)) {
                    Class cls = this.method.getParameterTypes()[i21];
                    Intrinsics.checkNotNullExpressionValue(cls, "method.parameterTypes[idx]");
                    i11 = ComposableMethodKt.getDefaultValue(cls);
                } else {
                    i11 = objArr2[i21];
                }
            } else if (i21 == component2) {
                i11 = composer2;
            } else if (i21 == i13) {
                i11 = 1;
            } else {
                if (i13 + 1 > i21 || i21 >= i14) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    i11 = 0;
                } else {
                    if (i14 > i21 || i21 >= length) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (z13) {
                        i11 = objArr3[i21 - i14];
                    } else {
                        throw new IllegalStateException("Unexpected index".toString());
                    }
                }
            }
            objArr4[i21] = i11;
        }
        return this.method.invoke(obj, Arrays.copyOf(objArr4, length));
    }
}
