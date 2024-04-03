package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedTypeConstructor$_supertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NewCapturedTypeConstructor f24966g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.f24966g = newCapturedTypeConstructor;
    }

    @Nullable
    public final List<UnwrappedType> invoke() {
        Function0 access$getSupertypesComputation$p = this.f24966g.supertypesComputation;
        if (access$getSupertypesComputation$p != null) {
            return (List) access$getSupertypesComputation$p.invoke();
        }
        return null;
    }
}
