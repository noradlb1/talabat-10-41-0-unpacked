package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import org.jetbrains.annotations.Nullable;

public final class NullabilityAnnotationStatesImpl$cache$1 extends Lambda implements Function1<FqName, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NullabilityAnnotationStatesImpl<T> f24568g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullabilityAnnotationStatesImpl$cache$1(NullabilityAnnotationStatesImpl<T> nullabilityAnnotationStatesImpl) {
        super(1);
        this.f24568g = nullabilityAnnotationStatesImpl;
    }

    @Nullable
    public final T invoke(FqName fqName) {
        Intrinsics.checkNotNullExpressionValue(fqName, "it");
        return FqNamesUtilKt.findValueForMostSpecificFqname(fqName, this.f24568g.getStates());
    }
}
