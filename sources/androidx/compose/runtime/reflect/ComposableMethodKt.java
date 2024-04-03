package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u0002H\u000b2\u0006\u0010\f\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\bH\u0002\u001a7\u0010\u0010\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\n\"\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "Ljava/lang/reflect/Method;", "dup", "", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "getDeclaredComposableMethod", "Ljava/lang/Class;", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "getDefaultValue", "", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    @Nullable
    public static final ComposableMethod asComposableMethod(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        ComposableInfo composableInfo = getComposableInfo(method);
        if (composableInfo.isComposable()) {
            return new ComposableMethod(method, composableInfo);
        }
        return null;
    }

    private static final int changedParamCount(int i11, int i12) {
        if (i11 == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (i11 + i12)) / 10.0d);
    }

    private static final int defaultParamCount(int i11) {
        return (int) Math.ceil(((double) i11) / 31.0d);
    }

    private static final /* synthetic */ <T> T[] dup(T t11, int i11) {
        IntRange until = RangesKt___RangesKt.until(0, i11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t11);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    private static final ComposableInfo getComposableInfo(Method method) {
        boolean z11;
        int i11;
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i12 = length - 1;
                if (Intrinsics.areEqual((Object) parameterTypes[length], (Object) Composer.class)) {
                    break;
                } else if (i12 < 0) {
                    break;
                } else {
                    length = i12;
                }
            }
        }
        length = -1;
        boolean z12 = false;
        if (length == -1) {
            return new ComposableInfo(false, method.getParameterTypes().length, 0, 0);
        }
        int changedParamCount = changedParamCount(length, Modifier.isStatic(method.getModifiers()) ^ true ? 1 : 0);
        int i13 = length + 1 + changedParamCount;
        int length2 = method.getParameterTypes().length;
        if (length2 != i13) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = defaultParamCount(length);
        } else {
            i11 = 0;
        }
        if (i13 + i11 == length2) {
            z12 = true;
        }
        return new ComposableInfo(z12, length, changedParamCount, i11);
    }

    @NotNull
    public static final ComposableMethod getDeclaredComposableMethod(@NotNull Class<?> cls, @NotNull String str, @NotNull Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        Class<Composer> cls2 = Composer.class;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, StepData.ARGS);
        int changedParamCount = changedParamCount(clsArr.length, 0);
        try {
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.addSpread(clsArr);
            spreadBuilder.add(cls2);
            Class cls3 = Integer.TYPE;
            IntRange until = RangesKt___RangesKt.until(0, changedParamCount);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList.add(cls3);
            }
            Object[] array = arrayList.toArray(new Class[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            spreadBuilder.addSpread(array);
            method = cls.getDeclaredMethod(str, (Class[]) spreadBuilder.toArray(new Class[spreadBuilder.size()]));
        } catch (ReflectiveOperationException unused) {
            int defaultParamCount = defaultParamCount(clsArr.length);
            try {
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
                spreadBuilder2.addSpread(clsArr);
                spreadBuilder2.add(cls2);
                Class cls4 = Integer.TYPE;
                IntRange until2 = RangesKt___RangesKt.until(0, changedParamCount);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until2, 10));
                Iterator it2 = until2.iterator();
                while (it2.hasNext()) {
                    ((IntIterator) it2).nextInt();
                    arrayList2.add(cls4);
                }
                Object[] array2 = arrayList2.toArray(new Class[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                spreadBuilder2.addSpread(array2);
                Class cls5 = Integer.TYPE;
                IntRange until3 = RangesKt___RangesKt.until(0, defaultParamCount);
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until3, 10));
                Iterator it3 = until3.iterator();
                while (it3.hasNext()) {
                    ((IntIterator) it3).nextInt();
                    arrayList3.add(cls5);
                }
                Object[] array3 = arrayList3.toArray(new Class[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                spreadBuilder2.addSpread(array3);
                method = cls.getDeclaredMethod(str, (Class[]) spreadBuilder2.toArray(new Class[spreadBuilder2.size()]));
            } catch (ReflectiveOperationException unused2) {
                method = null;
            }
        }
        if (method != null) {
            ComposableMethod asComposableMethod = asComposableMethod(method);
            Intrinsics.checkNotNull(asComposableMethod);
            return asComposableMethod;
        }
        throw new NoSuchMethodException(cls.getName() + '.' + str);
    }

    /* access modifiers changed from: private */
    public static final Object getDefaultValue(Class<?> cls) {
        String name2 = cls.getName();
        switch (name2.hashCode()) {
            case -1325958191:
                if (name2.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                break;
            case 104431:
                if (name2.equals("int")) {
                    return 0;
                }
                break;
            case 3039496:
                if (name2.equals("byte")) {
                    return (byte) 0;
                }
                break;
            case 3052374:
                if (name2.equals("char")) {
                    return 0;
                }
                break;
            case 3327612:
                if (name2.equals(Constants.LONG)) {
                    return 0L;
                }
                break;
            case 64711720:
                if (name2.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return Boolean.FALSE;
                }
                break;
            case 97526364:
                if (name2.equals(TypedValues.Custom.S_FLOAT)) {
                    return Float.valueOf(0.0f);
                }
                break;
            case 109413500:
                if (name2.equals("short")) {
                    return (short) 0;
                }
                break;
        }
        return null;
    }
}
