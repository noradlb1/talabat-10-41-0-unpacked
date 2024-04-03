package com.talabat.feature.activecarts.domain.extensions;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Result;", "T", "kotlin.jvm.PlatformType", "error", "", "apply-CmtIpJM"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class MaybeExtensionsKt$toResultSingle$2<T, R> implements Function {
    public static final MaybeExtensionsKt$toResultSingle$2<T, R> INSTANCE = new MaybeExtensionsKt$toResultSingle$2<>();

    /* renamed from: apply-CmtIpJM  reason: not valid java name */
    public final Result<? extends T> apply(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        Result.Companion companion = Result.Companion;
        return Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }
}
