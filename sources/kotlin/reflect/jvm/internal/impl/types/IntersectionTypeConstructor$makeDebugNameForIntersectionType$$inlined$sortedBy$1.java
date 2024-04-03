package kotlin.reflect.jvm.internal.impl.types;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T> implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f24942b;

    public IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(Function1 function1) {
        this.f24942b = function1;
    }

    public final int compare(T t11, T t12) {
        KotlinType kotlinType = (KotlinType) t11;
        Function1 function1 = this.f24942b;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        String obj = function1.invoke(kotlinType).toString();
        KotlinType kotlinType2 = (KotlinType) t12;
        Function1 function12 = this.f24942b;
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "it");
        return ComparisonsKt__ComparisonsKt.compareValues(obj, function12.invoke(kotlinType2).toString());
    }
}
