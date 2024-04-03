package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public final class TypeParameterUpperBoundEraser$getErasedUpperBound$1 extends Lambda implements Function1<TypeParameterUpperBoundEraser.DataToEraseUpperBound, KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeParameterUpperBoundEraser f24663g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeParameterUpperBoundEraser$getErasedUpperBound$1(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        super(1);
        this.f24663g = typeParameterUpperBoundEraser;
    }

    public final KotlinType invoke(TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
        return this.f24663g.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.isRaw(), dataToEraseUpperBound.getTypeAttr());
    }
}
