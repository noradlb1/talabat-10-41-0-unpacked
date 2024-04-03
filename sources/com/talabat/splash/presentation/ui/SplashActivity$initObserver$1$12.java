package com.talabat.splash.presentation.ui;

import com.talabat.splash.presentation.ui.displaymodel.SplashContentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SplashActivity$initObserver$1$12 extends FunctionReferenceImpl implements Function1<SplashContentDisplayModel, Unit> {
    public SplashActivity$initObserver$1$12(Object obj) {
        super(1, obj, SplashActivity.class, "showDynamicSplash", "showDynamicSplash(Lcom/talabat/splash/presentation/ui/displaymodel/SplashContentDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SplashContentDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SplashContentDisplayModel splashContentDisplayModel) {
        ((SplashActivity) this.receiver).showDynamicSplash(splashContentDisplayModel);
    }
}
