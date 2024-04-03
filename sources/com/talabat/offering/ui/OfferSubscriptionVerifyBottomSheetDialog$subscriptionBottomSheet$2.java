package com.talabat.offering.ui;

import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.talabat.offering.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OfferSubscriptionVerifyBottomSheetDialog$subscriptionBottomSheet$2 extends Lambda implements Function0<DSBottomSheet> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OfferSubscriptionVerifyBottomSheetDialog f61171g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferSubscriptionVerifyBottomSheetDialog$subscriptionBottomSheet$2(OfferSubscriptionVerifyBottomSheetDialog offerSubscriptionVerifyBottomSheetDialog) {
        super(0);
        this.f61171g = offerSubscriptionVerifyBottomSheetDialog;
    }

    @NotNull
    public final DSBottomSheet invoke() {
        return DSBottomSheet.Companion.newInstance(this.f61171g, R.layout.bottom_sheet_offer_subscription_verification);
    }
}
