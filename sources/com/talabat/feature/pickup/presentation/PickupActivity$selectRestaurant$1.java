package com.talabat.feature.pickup.presentation;

import android.view.View;
import android.view.ViewGroup;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.presentation.PickupConfirmationDialogView;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "result", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$selectRestaurant$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58653g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Restaurant f58654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SwimlanesTracking f58655i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$selectRestaurant$1(PickupActivity pickupActivity, Restaurant restaurant, SwimlanesTracking swimlanesTracking) {
        super(1);
        this.f58653g = pickupActivity;
        this.f58654h = restaurant;
        this.f58655i = swimlanesTracking;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE) || !this.f58653g.canShowConfirmationPopupOnce || !this.f58653g.getPickupViewModel().shouldShowConfirmationPopup()) {
            this.f58653g.navigateToVendorMenu(this.f58654h, this.f58655i);
            return;
        }
        this.f58653g.canShowConfirmationPopupOnce = false;
        this.f58653g.getPickupViewModel().logPickupPopupLoaded(this.f58654h);
        PickupConfirmationDialogView.Companion companion = PickupConfirmationDialogView.Companion;
        View findViewById = this.f58653g.findViewById(R.id.pickupCoordinator);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pickupCoordinator)");
        final PickupActivity pickupActivity = this.f58653g;
        final Restaurant restaurant = this.f58654h;
        final SwimlanesTracking swimlanesTracking = this.f58655i;
        companion.showPickupConfirmationDialog((ViewGroup) findViewById, pickupActivity, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z11) {
                pickupActivity.getPickupViewModel().logPickupPopupClicked(restaurant, z11);
                if (z11) {
                    pickupActivity.navigateToVendorMenu(restaurant, swimlanesTracking);
                }
            }
        });
    }
}
