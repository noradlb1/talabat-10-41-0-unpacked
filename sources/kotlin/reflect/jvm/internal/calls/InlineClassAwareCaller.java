package kotlin.reflect.jvm.internal.calls;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    @NotNull
    private final Caller<M> caller;
    @NotNull
    private final BoxUnboxData data;
    private final boolean isDefault;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BoxUnboxData {
        @NotNull
        private final IntRange argumentRange;
        @Nullable
        private final Method box;
        @NotNull
        private final Method[] unbox;

        public BoxUnboxData(@NotNull IntRange intRange, @NotNull Method[] methodArr, @Nullable Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        @NotNull
        public final IntRange component1() {
            return this.argumentRange;
        }

        @NotNull
        public final Method[] component2() {
            return this.unbox;
        }

        @Nullable
        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if ((r12 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r10.<init>()
            r10.caller = r12
            r10.isDefault = r13
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r11.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Class r0 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0024
            java.lang.reflect.Method r0 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r0, r11)
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r11)
            r3 = 0
            if (r2 == 0) goto L_0x003b
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r12 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r12 = r12.getEMPTY()
            java.lang.reflect.Method[] r13 = new java.lang.reflect.Method[r3]
            r11.<init>(r12, r13, r0)
            goto L_0x0148
        L_0x003b:
            boolean r2 = r12 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r4 = "descriptor.containingDeclaration"
            r5 = -1
            r6 = 1
            if (r2 == 0) goto L_0x0044
            goto L_0x0068
        L_0x0044:
            boolean r2 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r2 == 0) goto L_0x004d
            boolean r12 = r12 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r12 == 0) goto L_0x0067
            goto L_0x0068
        L_0x004d:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r2 = r11.getDispatchReceiverParameter()
            if (r2 == 0) goto L_0x0067
            boolean r12 = r12 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r12 != 0) goto L_0x0067
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12 = r11.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r4)
            boolean r12 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r12)
            if (r12 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r5 = r6
            goto L_0x0068
        L_0x0067:
            r5 = r3
        L_0x0068:
            if (r13 == 0) goto L_0x006c
            r12 = 2
            goto L_0x006d
        L_0x006c:
            r12 = r3
        L_0x006d:
            boolean r13 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r13 == 0) goto L_0x007c
            r13 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r13
            boolean r13 = r13.isSuspend()
            if (r13 == 0) goto L_0x007c
            r13 = r6
            goto L_0x007d
        L_0x007c:
            r13 = r3
        L_0x007d:
            int r12 = r12 + r13
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r2 = r11.getExtensionReceiverParameter()
            if (r2 == 0) goto L_0x008e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            goto L_0x008f
        L_0x008e:
            r2 = r1
        L_0x008f:
            if (r2 == 0) goto L_0x0095
            r13.add(r2)
            goto L_0x00d8
        L_0x0095:
            boolean r2 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r2 == 0) goto L_0x00be
            r2 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r2.getConstructedClass()
            java.lang.String r4 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r4 = r2.isInner()
            if (r4 == 0) goto L_0x00d8
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration()
            java.lang.String r4 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r2.getDefaultType()
            r13.add(r2)
            goto L_0x00d8
        L_0x00be:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r11.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r4 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L_0x00d8
            boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r2)
            if (r4 == 0) goto L_0x00d8
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r2.getDefaultType()
            r13.add(r2)
        L_0x00d8:
            java.util.List r2 = r11.getValueParameters()
            java.lang.String r4 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00e7:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00fb
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            r13.add(r4)
            goto L_0x00e7
        L_0x00fb:
            int r2 = r13.size()
            int r2 = r2 + r5
            int r2 = r2 + r12
            int r12 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r10)
            if (r12 != r2) goto L_0x014b
            int r12 = java.lang.Math.max(r5, r3)
            int r4 = r13.size()
            int r4 = r4 + r5
            kotlin.ranges.IntRange r12 = kotlin.ranges.RangesKt___RangesKt.until((int) r12, (int) r4)
            java.lang.reflect.Method[] r4 = new java.lang.reflect.Method[r2]
            r7 = r3
        L_0x0117:
            if (r7 >= r2) goto L_0x0143
            int r8 = r12.getFirst()
            int r9 = r12.getLast()
            if (r7 > r9) goto L_0x0127
            if (r8 > r7) goto L_0x0127
            r8 = r6
            goto L_0x0128
        L_0x0127:
            r8 = r3
        L_0x0128:
            if (r8 == 0) goto L_0x013d
            int r8 = r7 - r5
            java.lang.Object r8 = r13.get(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            java.lang.Class r8 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r8)
            if (r8 == 0) goto L_0x013d
            java.lang.reflect.Method r8 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r8, r11)
            goto L_0x013e
        L_0x013d:
            r8 = r1
        L_0x013e:
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0117
        L_0x0143:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r11.<init>(r12, r4, r0)
        L_0x0148:
            r10.data = r11
            return
        L_0x014b:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r12 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r13.append(r0)
            int r0 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r10)
            r13.append(r0)
            java.lang.String r0 = " != "
            r13.append(r0)
            r13.append(r2)
            java.lang.String r0 = "\nCalling: "
            r13.append(r0)
            r13.append(r11)
            java.lang.String r11 = "\nParameter types: "
            r13.append(r11)
            java.util.List r11 = r10.getParameterTypes()
            r13.append(r11)
            java.lang.String r11 = ")\nDefault: "
            r13.append(r11)
            boolean r11 = r10.isDefault
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object invoke;
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        BoxUnboxData boxUnboxData = this.data;
        IntRange component1 = boxUnboxData.component1();
        Method[] component2 = boxUnboxData.component2();
        Method component3 = boxUnboxData.component3();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        Intrinsics.checkNotNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int first = component1.getFirst();
        int last = component1.getLast();
        if (first <= last) {
            while (true) {
                Method method = component2[first];
                Object obj = objArr[first];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                        obj = UtilKt.defaultPrimitiveValue(returnType);
                    }
                }
                copyOf[first] = obj;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object call = this.caller.call(copyOf);
        if (component3 == null || (invoke = component3.invoke((Object) null, new Object[]{call})) == null) {
            return call;
        }
        return invoke;
    }

    public M getMember() {
        return this.caller.getMember();
    }

    @NotNull
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @NotNull
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
