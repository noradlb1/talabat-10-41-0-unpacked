package com.talabat.offering.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionActivity$openSubscriptionDialog$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f61163g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionActivity$openSubscriptionDialog$1(OfferCollectionActivity offerCollectionActivity) {
        super(1);
        this.f61163g = offerCollectionActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.f61163g.getOfferCollectionViewModel().trackSubscriptionVerificationContinued();
        this.f61163g.getOfferCollectionViewModel().sendMobileNumberOTP(str, this.f61163g.getConfigurationLocalRepository());
    }
}
