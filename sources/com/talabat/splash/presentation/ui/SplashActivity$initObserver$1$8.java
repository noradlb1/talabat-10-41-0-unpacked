package com.talabat.splash.presentation.ui;

import com.talabat.splash.domain.model.ScreenInfoWrapper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashActivity$initObserver$1$8 extends FunctionReferenceImpl implements Function1<Pair<? extends ScreenInfoWrapper, ? extends Boolean>, Unit> {
    public SplashActivity$initObserver$1$8(Object obj) {
        super(1, obj, SplashActivity.class, "loadScreenRedirection", "loadScreenRedirection(Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<ScreenInfoWrapper, Boolean>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<ScreenInfoWrapper, Boolean> pair) {
        ((SplashActivity) this.receiver).loadScreenRedirection(pair);
    }
}
