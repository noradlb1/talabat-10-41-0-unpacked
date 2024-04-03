package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

public final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements Function0<KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeProjection f24802g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        super(0);
        this.f24802g = typeProjection;
    }

    @NotNull
    public final KotlinType invoke() {
        KotlinType type = this.f24802g.getType();
        Intrinsics.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}
