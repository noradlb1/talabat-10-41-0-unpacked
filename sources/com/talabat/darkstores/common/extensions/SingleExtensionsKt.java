package com.talabat.darkstores.common.extensions;

import com.talabat.darkstores.common.SingleCacheSuccess;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\u0003"}, d2 = {"cacheButRetryOnError", "Lio/reactivex/Single;", "T", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SingleExtensionsKt {
    @NotNull
    public static final <T> Single<T> cacheButRetryOnError(@NotNull Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Single<T> create = SingleCacheSuccess.create(single);
        Intrinsics.checkNotNullExpressionValue(create, "create(this)");
        return create;
    }
}
