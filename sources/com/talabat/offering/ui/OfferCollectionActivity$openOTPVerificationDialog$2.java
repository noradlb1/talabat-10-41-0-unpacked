package com.talabat.offering.ui;

import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionActivity$openOTPVerificationDialog$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f61159g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OTPDisplayModel f61160h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferCollectionActivity$openOTPVerificationDialog$2(OfferCollectionActivity offerCollectionActivity, OTPDisplayModel oTPDisplayModel) {
        super(0);
        this.f61159g = offerCollectionActivity;
        this.f61160h = oTPDisplayModel;
    }

    public final void invoke() {
        this.f61159g.handleResendOTP(((OTPDisplayModel.OTPData) this.f61160h).getMobileNumber(), ((OTPDisplayModel.OTPData) this.f61160h).getRequestId());
    }
}
