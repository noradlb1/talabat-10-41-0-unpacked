package com.talabat.fluid.homescreen.ui.widget.gem;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAvailable", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemWidgetView$onGemAvailabilityCallback$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemWidgetView f59752g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemWidgetView$onGemAvailabilityCallback$1(GemWidgetView gemWidgetView) {
        super(1);
        this.f59752g = gemWidgetView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        GemExpirationCallback access$getGemExpirationCallback$p;
        if (!z11 && (access$getGemExpirationCallback$p = this.f59752g.gemExpirationCallback) != null) {
            access$getGemExpirationCallback$p.onGemExpired();
        }
    }
}
