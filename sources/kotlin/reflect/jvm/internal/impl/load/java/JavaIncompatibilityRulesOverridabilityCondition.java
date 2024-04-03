package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r6v6, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean isPrimitiveCompareTo(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6) {
            /*
                r5 = this;
                java.util.List r0 = r6.getValueParameters()
                int r0 = r0.size()
                r1 = 0
                r2 = 1
                if (r0 == r2) goto L_0x000d
                return r1
            L_0x000d:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r6.getContainingDeclaration()
                boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                r4 = 0
                if (r3 == 0) goto L_0x0019
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
                goto L_0x001a
            L_0x0019:
                r0 = r4
            L_0x001a:
                if (r0 != 0) goto L_0x001d
                return r1
            L_0x001d:
                java.util.List r6 = r6.getValueParameters()
                java.lang.String r3 = "f.valueParameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
                java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.single(r6)
                kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
                kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6 = r6.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r6 = r6.getDeclarationDescriptor()
                boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                if (r3 == 0) goto L_0x003f
                r4 = r6
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            L_0x003f:
                if (r4 != 0) goto L_0x0042
                return r1
            L_0x0042:
                boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveClass(r0)
                if (r6 == 0) goto L_0x0057
                kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r0)
                kotlin.reflect.jvm.internal.impl.name.FqName r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r4)
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
                if (r6 == 0) goto L_0x0057
                r1 = r2
            L_0x0057:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion.isPrimitiveCompareTo(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):boolean");
        }

        private final JvmType mapValueParameterType(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(functionDescriptor) || isPrimitiveCompareTo(functionDescriptor)) {
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "valueParameterDescriptor.type");
                return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(type));
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(type2);
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
            Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
            Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : CollectionsKt___CollectionsKt.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.component2();
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "subParameter");
                    boolean z11 = mapValueParameterType((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof JvmType.Primitive;
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor2, "superParameter");
                    if (z11 != (mapValueParameterType(functionDescriptor, valueParameterDescriptor2) instanceof JvmType.Primitive)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        FunctionDescriptor functionDescriptor;
        boolean z11;
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !KotlinBuiltIns.isBuiltIn(callableDescriptor2)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor functionDescriptor2 = (FunctionDescriptor) callableDescriptor2;
            Name name2 = functionDescriptor2.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "subDescriptor.name");
            if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name2)) {
                SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
                Name name3 = functionDescriptor2.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "subDescriptor.name");
                if (!companion.getSameAsRenamedInJvmBuiltin(name3)) {
                    return false;
                }
            }
            CallableMemberDescriptor overriddenSpecialBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) callableDescriptor);
            boolean z12 = callableDescriptor instanceof FunctionDescriptor;
            if (z12) {
                functionDescriptor = (FunctionDescriptor) callableDescriptor;
            } else {
                functionDescriptor = null;
            }
            if (functionDescriptor == null || functionDescriptor2.isHiddenToOvercomeSignatureClash() != functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if ((!z11) && (overriddenSpecialBuiltin == null || !functionDescriptor2.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor2.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, overriddenSpecialBuiltin)) {
                if ((overriddenSpecialBuiltin instanceof FunctionDescriptor) && z12 && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) overriddenSpecialBuiltin) != null) {
                    String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor2, false, false, 2, (Object) null);
                    FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                    Intrinsics.checkNotNullExpressionValue(original, "superDescriptor.original");
                    if (Intrinsics.areEqual((Object) computeJvmDescriptor$default, (Object) MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, (Object) null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(callableDescriptor, callableDescriptor2, classDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor, callableDescriptor2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
