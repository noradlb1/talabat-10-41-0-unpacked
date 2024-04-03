package com.talabat.feature.activecarts.domain.extensions;

import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u0002H\u0003 \u0004*\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"toResultSingle", "Lio/reactivex/Single;", "Lkotlin/Result;", "T", "kotlin.jvm.PlatformType", "Lio/reactivex/Maybe;", "com_talabat_feature_active-carts_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaybeExtensionsKt {
    public static final /* synthetic */ <T> Single<Result<T>> toResultSingle(Maybe<T> maybe) {
        Intrinsics.checkNotNullParameter(maybe, "<this>");
        Single<R> onErrorReturn = maybe.map(MaybeExtensionsKt$toResultSingle$1.INSTANCE).toSingle().onErrorReturn(MaybeExtensionsKt$toResultSingle$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "map { activeCartInfo ->\n…> Result.failure(error) }");
        return onErrorReturn;
    }
}
