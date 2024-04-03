package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeConstructor$supertypes$1 extends Lambda implements Function0<AbstractTypeConstructor.Supertypes> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor f24935g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.f24935g = abstractTypeConstructor;
    }

    @NotNull
    public final AbstractTypeConstructor.Supertypes invoke() {
        return new AbstractTypeConstructor.Supertypes(this.f24935g.c());
    }
}
