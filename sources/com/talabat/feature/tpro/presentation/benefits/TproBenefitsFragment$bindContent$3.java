package com.talabat.feature.tpro.presentation.benefits;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TproBenefitsFragment$bindContent$3 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public TproBenefitsFragment$bindContent$3(Object obj) {
        super(1, obj, TproBenefitsFragment.class, "onBackClick", "onBackClick(Landroid/view/View;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "p0");
        ((TproBenefitsFragment) this.receiver).onBackClick(view);
    }
}
