package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class PrimitiveType$arrayTypeFqName$2 extends Lambda implements Function0<FqName> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PrimitiveType f24457g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimitiveType$arrayTypeFqName$2(PrimitiveType primitiveType) {
        super(0);
        this.f24457g = primitiveType;
    }

    @NotNull
    public final FqName invoke() {
        FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.f24457g.getArrayTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
        return child;
    }
}
