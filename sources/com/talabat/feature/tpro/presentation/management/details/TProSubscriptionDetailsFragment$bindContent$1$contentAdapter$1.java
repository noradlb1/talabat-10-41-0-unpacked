package com.talabat.feature.tpro.presentation.management.details;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$1(Object obj) {
        super(1, obj, TProSubscriptionDetailsFragment.class, "onBackPressed", "onBackPressed(Landroid/view/View;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable View view) {
        ((TProSubscriptionDetailsFragment) this.receiver).onBackPressed(view);
    }
}
