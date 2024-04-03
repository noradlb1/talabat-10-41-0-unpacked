package com.talabat.restaurants;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.talabat.R;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.pickup.data.events.TooltipActions;
import com.talabat.feature.pickup.data.events.TooltipEvent;
import com.talabat.feature.pickup.presentation.PickupTooltipViewAnimations;
import com.talabat.restaurants.domain.ShowTooltipUseCase;
import com.talabat.restaurants.v1.IRestaurantsListPresenterRefactor;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.pickup.PickupNavigatorActions;
import ct.a;
import ct.b;
import io.reactivex.functions.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/PickupTooltipViewInitializer;", "Lio/reactivex/functions/BiConsumer;", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "Lcom/talabat/restaurants/v1/IRestaurantsListPresenterRefactor;", "showTooltipUseCase", "Lcom/talabat/restaurants/domain/ShowTooltipUseCase;", "(Lcom/talabat/restaurants/domain/ShowTooltipUseCase;)V", "accept", "", "activity", "presenter", "hideTooltip", "pickupTooltip", "Landroid/view/View;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupTooltipViewInitializer implements BiConsumer<RestaurantsListScreenRefactor, IRestaurantsListPresenterRefactor> {
    @NotNull
    private ShowTooltipUseCase showTooltipUseCase;

    public PickupTooltipViewInitializer(@NotNull ShowTooltipUseCase showTooltipUseCase2) {
        Intrinsics.checkNotNullParameter(showTooltipUseCase2, "showTooltipUseCase");
        this.showTooltipUseCase = showTooltipUseCase2;
    }

    /* access modifiers changed from: private */
    /* renamed from: accept$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10717accept$lambda1$lambda0(RestaurantsListScreenRefactor restaurantsListScreenRefactor, PickupTooltipViewInitializer pickupTooltipViewInitializer, View view, View view2) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "$activity");
        Intrinsics.checkNotNullParameter(pickupTooltipViewInitializer, "this$0");
        restaurantsListScreenRefactor.J.track(new TooltipEvent(TooltipActions.CLOSED));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pickupTooltip);
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "pickupTooltip");
        pickupTooltipViewInitializer.hideTooltip(relativeLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: accept$lambda-2  reason: not valid java name */
    public static final void m10718accept$lambda2(RestaurantsListScreenRefactor restaurantsListScreenRefactor, PickupTooltipViewInitializer pickupTooltipViewInitializer, View view) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "$activity");
        Intrinsics.checkNotNullParameter(pickupTooltipViewInitializer, "this$0");
        restaurantsListScreenRefactor.J.track(new TooltipEvent(TooltipActions.CLICKED));
        Intrinsics.checkNotNullExpressionValue(view, "it");
        pickupTooltipViewInitializer.hideTooltip(view);
        Navigator.Companion.navigate((Context) restaurantsListScreenRefactor, new NavigatorModel(PickupNavigatorActions.ACTION_NEW_PICKUP_MODULE, (Bundle) null, PickupTooltipViewInitializer$accept$2$1.INSTANCE, 2, (DefaultConstructorMarker) null));
    }

    private final void hideTooltip(View view) {
        SharedPreferencesManager.getInstance().setInteractedWithPickupTooltip();
        PickupTooltipViewAnimations.Companion.animateToHide(view);
    }

    public void accept(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor, @NotNull IRestaurantsListPresenterRefactor iRestaurantsListPresenterRefactor) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "activity");
        Intrinsics.checkNotNullParameter(iRestaurantsListPresenterRefactor, "presenter");
        if (restaurantsListScreenRefactor.J == null) {
            restaurantsListScreenRefactor.J = ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) restaurantsListScreenRefactor).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        }
        restaurantsListScreenRefactor.J.track(new TooltipEvent(TooltipActions.SHOWN));
        View view = restaurantsListScreenRefactor.f61209o;
        ((TextView) view.findViewById(R.id.tooltipHeader)).setText(restaurantsListScreenRefactor.getResources().getString(this.showTooltipUseCase.isFirstVariant() ? R.string.pickupToolTipExpV1Title : R.string.pickupToolTipExpV2Title));
        ((TextView) view.findViewById(R.id.tooltipSubtitle)).setText(restaurantsListScreenRefactor.getResources().getString(this.showTooltipUseCase.isFirstVariant() ? R.string.pickupToolTipExpV1SubTitle : R.string.pickupToolTipExpV2SubTitle));
        ((Button) view.findViewById(R.id.dsIconButtonClose)).setOnClickListener(new a(restaurantsListScreenRefactor, this, view));
        view.setOnClickListener(new b(restaurantsListScreenRefactor, this));
    }
}
