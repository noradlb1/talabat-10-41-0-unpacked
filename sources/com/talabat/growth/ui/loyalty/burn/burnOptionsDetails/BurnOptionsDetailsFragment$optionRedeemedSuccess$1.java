package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "acty", "Landroidx/fragment/app/FragmentActivity;", "displayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsFragment$optionRedeemedSuccess$1 extends Lambda implements Function3<FragmentActivity, BurnItemDisplayModel, ConfirmationDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsFragment f60606g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsFragment$optionRedeemedSuccess$1(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
        super(3);
        this.f60606g = burnOptionsDetailsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((FragmentActivity) obj, (BurnItemDisplayModel) obj2, (ConfirmationDisplayModel) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FragmentActivity fragmentActivity, @NotNull BurnItemDisplayModel burnItemDisplayModel, @NotNull ConfirmationDisplayModel confirmationDisplayModel) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "acty");
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "displayModel");
        Intrinsics.checkNotNullParameter(confirmationDisplayModel, "confirmationDisplayModel");
        Navigator.Companion.navigate((Context) fragmentActivity, this.f60606g.createRedeemConfirmationNavigatorModel(burnItemDisplayModel, confirmationDisplayModel));
    }
}
