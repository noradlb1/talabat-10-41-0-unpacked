package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class NewCapturedTypeConstructor$initializeSupertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<UnwrappedType> f24967g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$initializeSupertypes$2(List<? extends UnwrappedType> list) {
        super(0);
        this.f24967g = list;
    }

    @NotNull
    public final List<UnwrappedType> invoke() {
        return this.f24967g;
    }
}
