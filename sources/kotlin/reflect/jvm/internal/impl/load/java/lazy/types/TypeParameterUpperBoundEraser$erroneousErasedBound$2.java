package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

public final class TypeParameterUpperBoundEraser$erroneousErasedBound$2 extends Lambda implements Function0<ErrorType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeParameterUpperBoundEraser f24662g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeParameterUpperBoundEraser$erroneousErasedBound$2(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        super(0);
        this.f24662g = typeParameterUpperBoundEraser;
    }

    @NotNull
    public final ErrorType invoke() {
        return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, this.f24662g.toString());
    }
}
