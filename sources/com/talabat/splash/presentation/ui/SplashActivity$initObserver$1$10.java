package com.talabat.splash.presentation.ui;

import com.talabat.splash.core.extension.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashActivity$initObserver$1$10 extends FunctionReferenceImpl implements Function1<Event<? extends String>, Unit> {
    public SplashActivity$initObserver$1$10(Object obj) {
        super(1, obj, SplashActivity.class, "showForceUpdate", "showForceUpdate(Lcom/talabat/splash/core/extension/Event;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Event<String>) (Event) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Event<String> event) {
        ((SplashActivity) this.receiver).showForceUpdate(event);
    }
}
