package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 extends Lambda implements Function0<List<? extends KotlinType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor f24933g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor f24934h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.f24933g = moduleViewTypeConstructor;
        this.f24934h = abstractTypeConstructor;
    }

    @NotNull
    public final List<KotlinType> invoke() {
        return KotlinTypeRefinerKt.refineTypes(this.f24933g.kotlinTypeRefiner, this.f24934h.getSupertypes());
    }
}
