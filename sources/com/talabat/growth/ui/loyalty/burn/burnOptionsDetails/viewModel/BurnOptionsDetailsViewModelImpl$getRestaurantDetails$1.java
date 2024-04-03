package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel;

import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Ldatamodels/Restaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsViewModelImpl$getRestaurantDetails$1 extends Lambda implements Function1<Either<? extends Failure, ? extends Restaurant>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ConfirmationDisplayModel f60610g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsViewModelImpl f60611h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsViewModelImpl$getRestaurantDetails$1(ConfirmationDisplayModel confirmationDisplayModel, BurnOptionsDetailsViewModelImpl burnOptionsDetailsViewModelImpl) {
        super(1);
        this.f60610g = confirmationDisplayModel;
        this.f60611h = burnOptionsDetailsViewModelImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends Restaurant>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, ? extends Restaurant> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        ConfirmationDisplayModel confirmationDisplayModel = this.f60610g;
        final BurnOptionsDetailsViewModelImpl burnOptionsDetailsViewModelImpl = this.f60611h;
        confirmationDisplayModel.setOrderNowDirection((OrderNowDirection) either.either(new Function1<Failure, OrderNowDirection>() {
            @NotNull
            public final OrderNowDirection invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "it");
                return burnOptionsDetailsViewModelImpl.onRequestError();
            }
        }, new Function1<Restaurant, OrderNowDirection>(this.f60611h) {
            @NotNull
            public final OrderNowDirection invoke(@NotNull Restaurant restaurant) {
                Intrinsics.checkNotNullParameter(restaurant, "p0");
                return ((BurnOptionsDetailsViewModelImpl) this.receiver).onRestaurantInfoReceived(restaurant);
            }
        }));
        this.f60611h.getRedeemData().setValue(this.f60610g);
    }
}
