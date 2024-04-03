package com.talabat.splash.presentation.ui;

import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashActivity$initObserver$1$7 extends FunctionReferenceImpl implements Function1<SplashRedirectionWrapper, Unit> {
    public SplashActivity$initObserver$1$7(Object obj) {
        super(1, obj, SplashActivity.class, "loadAppInfoWithScreenRedirection", "loadAppInfoWithScreenRedirection(Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SplashRedirectionWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SplashRedirectionWrapper splashRedirectionWrapper) {
        ((SplashActivity) this.receiver).loadAppInfoWithScreenRedirection(splashRedirectionWrapper);
    }
}
