package com.talabat.darkstores.common;

import com.talabat.darkstores.common.Result;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/Result;", "OutputType", "kotlin.jvm.PlatformType", "InputType", "", "it", "apply", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result;"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ResultKt$toResult$3<T, R> implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<InputType, OutputType> f56100b;

    public ResultKt$toResult$3(Function1<? super InputType, ? extends OutputType> function1) {
        this.f56100b = function1;
    }

    public final Result<OutputType> apply(@NotNull InputType inputtype) {
        Intrinsics.checkNotNullParameter(inputtype, "it");
        return new Result.Success(this.f56100b.invoke(inputtype));
    }
}
