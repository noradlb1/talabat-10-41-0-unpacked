package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J1\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J?\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\f\"\u0006\b\u0000\u0010\u001c\u0018\u0001*\u0002H\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\u00020 *\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010!J9\u0010\"\u001a\u00020 *\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\rH\u0002J=\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010'R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/tooling/CommonPreviewUtils;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "compatibleTypes", "", "methodTypes", "", "Ljava/lang/Class;", "actualTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "defaultParamCount", "invokeComposableViaReflection", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "invokeComposableViaReflection$ui_tooling_release", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDeclaredCompatibleMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CommonPreviewUtils {
    private static final int BITS_PER_INT = 31;
    @NotNull
    public static final CommonPreviewUtils INSTANCE = new CommonPreviewUtils();
    private static final int SLOTS_PER_INT = 15;

    private CommonPreviewUtils() {
    }

    private final int changedParamCount(int i11, int i12) {
        if (i11 == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (i11 + i12)) / 15.0d);
    }

    private final boolean compatibleTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z11;
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        int length = clsArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            arrayList.add(Boolean.valueOf(clsArr[i11].isAssignableFrom(clsArr2[i12])));
            i11++;
            i12++;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return true;
        }
        return false;
    }

    private final int defaultParamCount(int i11) {
        return (int) Math.ceil(((double) i11) / 31.0d);
    }

    private final /* synthetic */ <T> T[] dup(T t11, int i11) {
        IntRange intRange = new IntRange(0, i11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t11);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] array = arrayList.toArray(new Object[0]);
        if (array != null) {
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r11 = r9.getDeclaredMethods();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "declaredMethods");
        r2 = r11.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0095, code lost:
        if (r1 < r2) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        r3 = r11[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3.getName(), (java.lang.Object) r10) != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x008b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method findComposableMethod(java.lang.Class<?> r9, java.lang.String r10, java.lang.Object... r11) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r2 = r11.length     // Catch:{ ReflectiveOperationException -> 0x008b }
            int r2 = r8.changedParamCount(r2, r1)     // Catch:{ ReflectiveOperationException -> 0x008b }
            kotlin.jvm.internal.SpreadBuilder r3 = new kotlin.jvm.internal.SpreadBuilder     // Catch:{ ReflectiveOperationException -> 0x008b }
            r4 = 4
            r3.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x008b }
            r4.<init>()     // Catch:{ ReflectiveOperationException -> 0x008b }
            int r5 = r11.length     // Catch:{ ReflectiveOperationException -> 0x008b }
            r6 = r1
        L_0x0014:
            if (r6 >= r5) goto L_0x0028
            r7 = r11[r6]     // Catch:{ ReflectiveOperationException -> 0x008b }
            if (r7 != 0) goto L_0x001c
            r7 = r0
            goto L_0x0020
        L_0x001c:
            java.lang.Class r7 = r7.getClass()     // Catch:{ ReflectiveOperationException -> 0x008b }
        L_0x0020:
            if (r7 == 0) goto L_0x0025
            r4.add(r7)     // Catch:{ ReflectiveOperationException -> 0x008b }
        L_0x0025:
            int r6 = r6 + 1
            goto L_0x0014
        L_0x0028:
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Object[] r11 = r4.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T>"
            if (r11 == 0) goto L_0x0085
            r3.addSpread(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Class<androidx.compose.runtime.Composer> r11 = androidx.compose.runtime.Composer.class
            r3.add(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ ReflectiveOperationException -> 0x008b }
            r3.add(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            kotlin.ranges.IntRange r5 = new kotlin.ranges.IntRange     // Catch:{ ReflectiveOperationException -> 0x008b }
            r5.<init>(r1, r2)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x008b }
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r5, r6)     // Catch:{ ReflectiveOperationException -> 0x008b }
            r2.<init>(r6)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ ReflectiveOperationException -> 0x008b }
        L_0x0053:
            boolean r6 = r5.hasNext()     // Catch:{ ReflectiveOperationException -> 0x008b }
            if (r6 == 0) goto L_0x0063
            r6 = r5
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6     // Catch:{ ReflectiveOperationException -> 0x008b }
            r6.nextInt()     // Catch:{ ReflectiveOperationException -> 0x008b }
            r2.add(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            goto L_0x0053
        L_0x0063:
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Object[] r11 = r2.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            if (r11 == 0) goto L_0x007f
            r3.addSpread(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            int r11 = r3.size()     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Class[] r11 = new java.lang.Class[r11]     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Object[] r11 = r3.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.Class[] r11 = (java.lang.Class[]) r11     // Catch:{ ReflectiveOperationException -> 0x008b }
            java.lang.reflect.Method r11 = r8.getDeclaredCompatibleMethod(r9, r10, r11)     // Catch:{ ReflectiveOperationException -> 0x008b }
            goto L_0x00a9
        L_0x007f:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ ReflectiveOperationException -> 0x008b }
            r11.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x008b }
            throw r11     // Catch:{ ReflectiveOperationException -> 0x008b }
        L_0x0085:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ ReflectiveOperationException -> 0x008b }
            r11.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x008b }
            throw r11     // Catch:{ ReflectiveOperationException -> 0x008b }
        L_0x008b:
            java.lang.reflect.Method[] r11 = r9.getDeclaredMethods()     // Catch:{ ReflectiveOperationException -> 0x00a8 }
            java.lang.String r2 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ ReflectiveOperationException -> 0x00a8 }
            int r2 = r11.length     // Catch:{ ReflectiveOperationException -> 0x00a8 }
        L_0x0095:
            if (r1 >= r2) goto L_0x00a8
            r3 = r11[r1]     // Catch:{ ReflectiveOperationException -> 0x00a8 }
            java.lang.String r4 = r3.getName()     // Catch:{ ReflectiveOperationException -> 0x00a8 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r10)     // Catch:{ ReflectiveOperationException -> 0x00a8 }
            if (r4 == 0) goto L_0x00a5
            r0 = r3
            goto L_0x00a8
        L_0x00a5:
            int r1 = r1 + 1
            goto L_0x0095
        L_0x00a8:
            r11 = r0
        L_0x00a9:
            if (r11 == 0) goto L_0x00ac
            return r11
        L_0x00ac:
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = r9.getName()
            r0.append(r9)
            r9 = 46
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            r11.<init>(r9)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.CommonPreviewUtils.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c A[EDGE_INSN: B:16:0x003c->B:11:0x003c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038 A[LOOP:0: B:1:0x0013->B:9:0x0038, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            r7 = this;
            int r0 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r0)
            java.lang.Class[] r10 = (java.lang.Class[]) r10
            java.lang.reflect.Method[] r8 = r8.getDeclaredMethods()
            java.lang.String r0 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            int r0 = r8.length
            r1 = 0
            r2 = r1
        L_0x0013:
            if (r2 >= r0) goto L_0x003b
            r3 = r8[r2]
            java.lang.String r4 = r3.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0034
            androidx.compose.ui.tooling.CommonPreviewUtils r4 = INSTANCE
            java.lang.Class[] r5 = r3.getParameterTypes()
            java.lang.String r6 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r4 = r4.compatibleTypes(r5, r10)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = r1
        L_0x0035:
            if (r4 == 0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x003b:
            r3 = 0
        L_0x003c:
            if (r3 == 0) goto L_0x003f
            return r3
        L_0x003f:
            java.lang.NoSuchMethodException r8 = new java.lang.NoSuchMethodException
            java.lang.String r10 = " not found"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r10)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.CommonPreviewUtils.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private final Object getDefaultValue(Class<?> cls) {
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
                    return '0';
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

    private final Object invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        boolean z13;
        int i13;
        boolean z14;
        boolean z15;
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        int i14 = -1;
        int length = parameterTypes.length - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (Intrinsics.areEqual((Object) parameterTypes[length], (Object) Composer.class)) {
                i14 = length;
                break;
            } else {
                length--;
            }
        }
        if (obj != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i15 = i14 + 1;
        int changedParamCount = changedParamCount(i14, i11) + i15;
        int length2 = method.getParameterTypes().length;
        if (length2 != changedParamCount) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i12 = defaultParamCount(i14);
        } else {
            i12 = 0;
        }
        if (i12 + changedParamCount == length2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            Object[] objArr2 = new Object[length2];
            for (int i16 = 0; i16 < length2; i16++) {
                if (i16 < 0 || i16 >= i14) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    if (i16 < 0 || i16 > ArraysKt___ArraysKt.getLastIndex((T[]) objArr)) {
                        CommonPreviewUtils commonPreviewUtils = INSTANCE;
                        Class cls = method.getParameterTypes()[i16];
                        Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                        i13 = commonPreviewUtils.getDefaultValue(cls);
                    } else {
                        i13 = objArr[i16];
                    }
                } else if (i16 == i14) {
                    i13 = composer;
                } else {
                    if (i15 > i16 || i16 >= changedParamCount) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        i13 = 0;
                    } else {
                        if (changedParamCount > i16 || i16 >= length2) {
                            z15 = false;
                        } else {
                            z15 = true;
                        }
                        if (z15) {
                            i13 = 2097151;
                        } else {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                    }
                }
                objArr2[i16] = i13;
            }
            return method.invoke(obj, Arrays.copyOf(objArr2, length2));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void invokeComposableViaReflection$ui_tooling_release(@NotNull String str, @NotNull String str2, @NotNull Composer composer, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "composableClass");
            Method findComposableMethod = findComposableMethod(cls, str2, Arrays.copyOf(objArr, objArr.length));
            findComposableMethod.setAccessible(true);
            if (Modifier.isStatic(findComposableMethod.getModifiers())) {
                invokeComposableMethod(findComposableMethod, (Object) null, composer, Arrays.copyOf(objArr, objArr.length));
            } else {
                invokeComposableMethod(findComposableMethod, cls.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(objArr, objArr.length));
            }
        } catch (ReflectiveOperationException e11) {
            throw new ClassNotFoundException("Composable Method '" + str + '.' + str2 + "' not found", e11);
        }
    }
}
