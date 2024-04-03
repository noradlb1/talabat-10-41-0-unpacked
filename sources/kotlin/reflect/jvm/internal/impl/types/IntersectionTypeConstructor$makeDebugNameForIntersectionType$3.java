package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$3 extends Lambda implements Function1<KotlinType, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<KotlinType, Object> f24944g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntersectionTypeConstructor$makeDebugNameForIntersectionType$3(Function1<? super KotlinType, ? extends Object> function1) {
        super(1);
        this.f24944g = function1;
    }

    @NotNull
    public final CharSequence invoke(KotlinType kotlinType) {
        Function1<KotlinType, Object> function1 = this.f24944g;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        return function1.invoke(kotlinType).toString();
    }
}
