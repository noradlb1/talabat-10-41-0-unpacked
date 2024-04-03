package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1 extends TypeConstructorSubstitution {
    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        CapturedTypeConstructor capturedTypeConstructor;
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        if (typeConstructor instanceof CapturedTypeConstructor) {
            capturedTypeConstructor = (CapturedTypeConstructor) typeConstructor;
        } else {
            capturedTypeConstructor = null;
        }
        if (capturedTypeConstructor == null) {
            return null;
        }
        if (capturedTypeConstructor.getProjection().isStarProjection()) {
            return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
        }
        return capturedTypeConstructor.getProjection();
    }
}
