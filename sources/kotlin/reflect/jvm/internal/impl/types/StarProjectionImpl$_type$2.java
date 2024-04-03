package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class StarProjectionImpl$_type$2 extends Lambda implements Function0<KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StarProjectionImpl f24956g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarProjectionImpl$_type$2(StarProjectionImpl starProjectionImpl) {
        super(0);
        this.f24956g = starProjectionImpl;
    }

    @NotNull
    public final KotlinType invoke() {
        return StarProjectionImplKt.starProjectionType(this.f24956g.typeParameter);
    }
}
