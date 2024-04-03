package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InlineClassAwareCallerKt {
    @Nullable
    public static final Object coerceToExpectedReceiverType(@Nullable Object obj, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType;
        Class<?> inlineClass;
        Method unboxMethod;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        if (((callableMemberDescriptor instanceof PropertyDescriptor) && InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) callableMemberDescriptor)) || (expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor)) == null || (inlineClass = toInlineClass(expectedReceiverType)) == null || (unboxMethod = getUnboxMethod(inlineClass, callableMemberDescriptor)) == null) {
            return obj;
        }
        return unboxMethod.invoke(obj, new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <M extends java.lang.reflect.Member> kotlin.reflect.jvm.internal.calls.Caller<M> createInlineClassAwareCallerIfNeeded(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6, boolean r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r6)
            r1 = 1
            if (r0 != 0) goto L_0x006b
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r2 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x002c
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x002c
        L_0x002a:
            r0 = r3
            goto L_0x004c
        L_0x002c:
            java.util.Iterator r0 = r0.iterator()
        L_0x0030:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            java.lang.String r4 = "it.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r2)
            if (r2 == 0) goto L_0x0030
            r0 = r1
        L_0x004c:
            if (r0 != 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r6.getReturnType()
            if (r0 == 0) goto L_0x005c
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClassType(r0)
            if (r0 != r1) goto L_0x005c
            r0 = r1
            goto L_0x005d
        L_0x005c:
            r0 = r3
        L_0x005d:
            if (r0 != 0) goto L_0x006b
            boolean r0 = r5 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 != 0) goto L_0x006a
            boolean r0 = hasInlineClassReceiver(r6)
            if (r0 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r1 = r3
        L_0x006b:
            if (r1 == 0) goto L_0x0073
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller
            r0.<init>(r6, r5, r7)
            r5 = r0
        L_0x0073:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded(kotlin.reflect.jvm.internal.calls.Caller, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, boolean):kotlin.reflect.jvm.internal.calls.Caller");
    }

    public static /* synthetic */ Caller createInlineClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return createInlineClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z11);
    }

    @NotNull
    public static final Method getBoxMethod(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", new Class[]{getUnboxMethod(cls, callableMemberDescriptor).getReturnType()});
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "{\n        getDeclaredMet…riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor callableMemberDescriptor) {
        ClassDescriptor classDescriptor;
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter != null) {
            if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                return dispatchReceiverParameter.getType();
            }
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            if (containingDeclaration instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) containingDeclaration;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor != null) {
                return classDescriptor.getDefaultType();
            }
        }
        return null;
    }

    @NotNull
    public static final Method getUnboxMethod(@NotNull Class<?> cls, @NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final boolean hasInlineClassReceiver(CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        return expectedReceiverType != null && InlineClassesUtilsKt.isInlineClassType(expectedReceiverType);
    }

    @Nullable
    public static final Class<?> toInlineClass(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Class<?> inlineClass = toInlineClass((DeclarationDescriptor) kotlinType.getConstructor().getDeclarationDescriptor());
        if (inlineClass == null) {
            return null;
        }
        if (!TypeUtils.isNullableType(kotlinType)) {
            return inlineClass;
        }
        KotlinType unsubstitutedUnderlyingType = InlineClassesUtilsKt.unsubstitutedUnderlyingType(kotlinType);
        if (unsubstitutedUnderlyingType != null && !TypeUtils.isNullableType(unsubstitutedUnderlyingType) && !KotlinBuiltIns.isPrimitiveType(unsubstitutedUnderlyingType)) {
            return inlineClass;
        }
        return null;
    }

    @Nullable
    public static final Class<?> toInlineClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) declarationDescriptor) + ')');
    }
}
