package com.talabat.darkstores.common;

import com.talabat.darkstores.common.Result;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/Result;", "OutputType", "kotlin.jvm.PlatformType", "InputType", "", "it", "", "apply"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ResultKt$toResult$4<T, R> implements Function {
    public static final ResultKt$toResult$4<T, R> INSTANCE = new ResultKt$toResult$4<>();

    public final Result<OutputType> apply(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null);
    }
}
