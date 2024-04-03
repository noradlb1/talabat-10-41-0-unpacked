package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeSystemContext$substitutionSupertypePolicy$2 extends TypeCheckerState.SupertypesPolicy.DoCustomTransform {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassicTypeSystemContext f24963a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TypeSubstitutor f24964b;

    public ClassicTypeSystemContext$substitutionSupertypePolicy$2(ClassicTypeSystemContext classicTypeSystemContext, TypeSubstitutor typeSubstitutor) {
        this.f24963a = classicTypeSystemContext;
        this.f24964b = typeSubstitutor;
    }

    @NotNull
    public SimpleTypeMarker transformType(@NotNull TypeCheckerState typeCheckerState, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        ClassicTypeSystemContext classicTypeSystemContext = this.f24963a;
        TypeSubstitutor typeSubstitutor = this.f24964b;
        SimpleTypeMarker lowerBoundIfFlexible = classicTypeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
        Intrinsics.checkNotNull(lowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
        KotlinType safeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) lowerBoundIfFlexible, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitu…VARIANT\n                )");
        SimpleTypeMarker asSimpleType = classicTypeSystemContext.asSimpleType(safeSubstitute);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }
}
