package com.talabat.gem.adapters.presentation.offer;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferMainActivity$initialize$1$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemOfferMainActivity f60236g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferMainActivity$initialize$1$1(GemOfferMainActivity gemOfferMainActivity) {
        super(1);
        this.f60236g = gemOfferMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        if (!this.f60236g.isFinishing()) {
            this.f60236g.onBackPressed();
        }
    }
}
