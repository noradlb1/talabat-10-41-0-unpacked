package com.talabat.splash.core.interactor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/core/interactor/InternalUseCaseStateDecider;", "Type", "", "()V", "invoke", "run", "None", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InternalUseCaseStateDecider<Type> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/splash/core/interactor/InternalUseCaseStateDecider$None;", "", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None {
    }

    @NotNull
    public final Object invoke() {
        return run();
    }

    @NotNull
    public abstract Object run();
}
