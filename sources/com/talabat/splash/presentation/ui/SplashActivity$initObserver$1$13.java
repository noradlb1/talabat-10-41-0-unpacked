package com.talabat.splash.presentation.ui;

import com.talabat.splash.core.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashActivity$initObserver$1$13 extends FunctionReferenceImpl implements Function1<Failure, Unit> {
    public SplashActivity$initObserver$1$13(Object obj) {
        super(1, obj, SplashActivity.class, "handleFailure", "handleFailure(Lcom/talabat/splash/core/exception/Failure;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Failure failure) {
        ((SplashActivity) this.receiver).handleFailure(failure);
    }
}
