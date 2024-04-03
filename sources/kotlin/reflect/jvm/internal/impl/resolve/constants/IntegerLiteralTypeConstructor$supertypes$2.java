package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements Function0<List<SimpleType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IntegerLiteralTypeConstructor f24806g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.f24806g = integerLiteralTypeConstructor;
    }

    @NotNull
    public final List<SimpleType> invoke() {
        SimpleType defaultType = this.f24806g.getBuiltIns().getComparable().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
        List<SimpleType> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, CollectionsKt__CollectionsJVMKt.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, this.f24806g.type)), (TypeAttributes) null, 2, (Object) null));
        if (!this.f24806g.isContainsOnlyUnsignedTypes()) {
            mutableListOf.add(this.f24806g.getBuiltIns().getNumberType());
        }
        return mutableListOf;
    }
}
