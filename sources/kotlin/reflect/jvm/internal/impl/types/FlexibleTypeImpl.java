package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeParameter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    private boolean assertionsDone;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlexibleTypeImpl(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        super(simpleType, simpleType2);
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS && !this.assertionsDone) {
            this.assertionsDone = true;
            FlexibleTypesKt.isFlexible(getLowerBound());
            FlexibleTypesKt.isFlexible(getUpperBound());
            Intrinsics.areEqual((Object) getLowerBound(), (Object) getUpperBound());
            KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
        }
    }

    @NotNull
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    public boolean isTypeParameter() {
        if (!(getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || !Intrinsics.areEqual((Object) getLowerBound().getConstructor(), (Object) getUpperBound().getConstructor())) {
            return false;
        }
        return true;
    }

    @NotNull
    public UnwrappedType makeNullableAsSpecified(boolean z11) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z11), getUpperBound().makeNullableAsSpecified(z11));
    }

    @NotNull
    public String render(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "options");
        if (!descriptorRendererOptions.getDebugMode()) {
            return descriptorRenderer.renderFlexibleType(descriptorRenderer.renderType(getLowerBound()), descriptorRenderer.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
        }
        return '(' + descriptorRenderer.renderType(getLowerBound()) + ".." + descriptorRenderer.renderType(getUpperBound()) + ')';
    }

    @NotNull
    public UnwrappedType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAttributes(typeAttributes), getUpperBound().replaceAttributes(typeAttributes));
    }

    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType kotlinType) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            unwrappedType = unwrap;
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            unwrappedType = KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap);
    }

    @NotNull
    public String toString() {
        return '(' + getLowerBound() + ".." + getUpperBound() + ')';
    }

    @NotNull
    public FlexibleType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType(getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new FlexibleTypeImpl((SimpleType) refineType, (SimpleType) refineType2);
    }
}
