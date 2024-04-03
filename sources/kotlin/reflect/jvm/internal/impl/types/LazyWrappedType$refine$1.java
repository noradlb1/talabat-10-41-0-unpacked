package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class LazyWrappedType$refine$1 extends Lambda implements Function0<KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KotlinTypeRefiner f24954g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyWrappedType f24955h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyWrappedType$refine$1(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        super(0);
        this.f24954g = kotlinTypeRefiner;
        this.f24955h = lazyWrappedType;
    }

    @NotNull
    public final KotlinType invoke() {
        return this.f24954g.refineType((KotlinTypeMarker) this.f24955h.computation.invoke());
    }
}
