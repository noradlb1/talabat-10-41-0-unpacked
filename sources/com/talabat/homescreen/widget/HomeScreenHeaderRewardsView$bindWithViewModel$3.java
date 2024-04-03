package com.talabat.homescreen.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeScreenHeaderRewardsView$bindWithViewModel$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public HomeScreenHeaderRewardsView$bindWithViewModel$3(Object obj) {
        super(1, obj, HomeScreenHeaderRewardsView.class, "showRewardsText", "showRewardsText(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ((HomeScreenHeaderRewardsView) this.receiver).showRewardsText(str);
    }
}
