package io.reactivex.rxkotlin;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u0003 \u0006*\u0012\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00030\u00030\u00050\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "T", "", "it", "", "kotlin.jvm.PlatformType", "apply", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class FlowableKt$zip$1<T, R> implements Function<Object[], R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f23488b;

    public FlowableKt$zip$1(Function1 function1) {
        this.f23488b = function1;
    }

    @NotNull
    public final R apply(@NotNull Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "it");
        Function1 function1 = this.f23488b;
        Iterable asList = ArraysKt___ArraysJvmKt.asList((T[]) objArr);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asList, 10));
        for (Object next : asList) {
            if (next != null) {
                arrayList.add(next);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
        }
        return function1.invoke(arrayList);
    }
}
