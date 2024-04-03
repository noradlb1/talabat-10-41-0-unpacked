package com.talabat.splash.core.interactor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/splash/core/interactor/InternalUseCaseWithParamNoReturn;", "Params", "", "()V", "invoke", "params", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InternalUseCaseWithParamNoReturn<Params> {
    @NotNull
    public final Object invoke(Params params) {
        return run(params);
    }

    @NotNull
    public abstract Object run(Params params);
}
