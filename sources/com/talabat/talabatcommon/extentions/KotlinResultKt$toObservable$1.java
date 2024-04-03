package com.talabat.talabatcommon.extentions;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "kotlin.jvm.PlatformType", "it", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class KotlinResultKt$toObservable$1 extends Lambda implements Function1 {
    public static final KotlinResultKt$toObservable$1 INSTANCE = new KotlinResultKt$toObservable$1();

    public KotlinResultKt$toObservable$1() {
        super(1);
    }

    @NotNull
    public final Observable invoke(Object obj) {
        Observable just = Observable.just(obj);
        Intrinsics.checkNotNullExpressionValue(just, "just(it)");
        return just;
    }
}
