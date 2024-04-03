package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType unwrappedType) {
            if ((unwrappedType.getConstructor() instanceof NewTypeVariableConstructor) || (unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (unwrappedType instanceof NewCapturedType) || (unwrappedType instanceof StubTypeForBuilderInference)) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean z11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z11);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType unwrappedType, boolean z11) {
            TypeParameterDescriptorImpl typeParameterDescriptorImpl;
            boolean z12 = false;
            if (!canHaveUndefinedNullability(unwrappedType)) {
                return false;
            }
            if (unwrappedType instanceof StubTypeForBuilderInference) {
                return TypeUtils.isNullableType(unwrappedType);
            }
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptorImpl) {
                typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) declarationDescriptor;
            } else {
                typeParameterDescriptorImpl = null;
            }
            if (typeParameterDescriptorImpl != null && !typeParameterDescriptorImpl.isInitialized()) {
                z12 = true;
            }
            if (z12) {
                return true;
            }
            if (!z11 || !(unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                return !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType);
            }
            return TypeUtils.isNullableType(unwrappedType);
        }

        @Nullable
        public final DefinitelyNotNullType makeDefinitelyNotNull(@NotNull UnwrappedType unwrappedType, boolean z11) {
            Intrinsics.checkNotNullParameter(unwrappedType, "type");
            if (unwrappedType instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) unwrappedType;
            }
            if (!makesSenseToBeDefinitelyNotNull(unwrappedType, z11)) {
                return null;
            }
            if (unwrappedType instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrappedType;
                Intrinsics.areEqual((Object) flexibleType.getLowerBound().getConstructor(), (Object) flexibleType.getUpperBound().getConstructor());
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(unwrappedType).makeNullableAsSpecified(false), z11, (DefaultConstructorMarker) null);
        }
    }

    private DefinitelyNotNullType(SimpleType simpleType, boolean z11) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z11;
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z11);
    }

    @NotNull
    public SimpleType getDelegate() {
        return this.original;
    }

    @NotNull
    public final SimpleType getOriginal() {
        return this.original;
    }

    public boolean isMarkedNullable() {
        return false;
    }

    public boolean isTypeParameter() {
        if ((getDelegate().getConstructor() instanceof NewTypeVariableConstructor) || (getDelegate().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
            return true;
        }
        return false;
    }

    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @NotNull
    public String toString() {
        return getDelegate() + " & Any";
    }

    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z11) {
        return z11 ? getDelegate().makeNullableAsSpecified(z11) : this;
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(typeAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @NotNull
    public DefinitelyNotNullType replaceDelegate(@NotNull SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        return new DefinitelyNotNullType(simpleType, this.useCorrectedNullabilityForTypeParameters);
    }
}
