package com.talabat.components.gem.checkout;

import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import buisnessmodels.Cart;
import com.talabat.CheckOutScreen;
import com.talabat.R;
import com.talabat.components.gem.cart.GemCartCustomizationViewHolderBinderKt;
import com.talabat.gem.adapters.presentation.GemCheckoutFooterConfigurations;
import com.talabat.gem.adapters.presentation.GemVisibilityCallbacks;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutFooterView;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutScreenBinder$accept$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f55724g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutScreenBinder$accept$1$1(CheckOutScreen checkOutScreen) {
        super(0);
        this.f55724g = checkOutScreen;
    }

    public final void invoke() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        final Integer valueOf = restaurant != null ? Integer.valueOf(restaurant.f13872id) : null;
        final CheckOutScreen checkOutScreen = this.f55724g;
        ((GemCheckoutFooterView) this.f55724g.findViewById(R.id.gemCheckoutFooterView)).invoke(new Function1<GemCheckoutFooterConfigurations, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemCheckoutFooterConfigurations) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemCheckoutFooterConfigurations gemCheckoutFooterConfigurations) {
                Intrinsics.checkNotNullParameter(gemCheckoutFooterConfigurations, "$this$invoke");
                gemCheckoutFooterConfigurations.getWith().restaurantId(valueOf);
                GemVisibilityCallbacks on2 = gemCheckoutFooterConfigurations.getOn();
                final CheckOutScreen checkOutScreen = checkOutScreen;
                on2.enabled(new Function0<Unit>() {
                    public final void invoke() {
                        ((GemCheckoutFooterView) checkOutScreen.findViewById(R.id.gemCheckoutFooterView)).setVisibility(0);
                        ((FrameLayout) checkOutScreen.findViewById(R.id.gem_footer_view_inner_layout)).setVisibility(8);
                    }
                });
                GemVisibilityCallbacks on3 = gemCheckoutFooterConfigurations.getOn();
                final CheckOutScreen checkOutScreen2 = checkOutScreen;
                on3.disabled(new Function0<Unit>() {
                    public final void invoke() {
                        ((GemCheckoutFooterView) checkOutScreen2.findViewById(R.id.gemCheckoutFooterView)).setVisibility(8);
                        ((FrameLayout) checkOutScreen2.findViewById(R.id.gem_footer_view_inner_layout)).setVisibility(0);
                        Cart instance = Cart.getInstance();
                        final CheckOutScreen checkOutScreen = checkOutScreen2;
                        GemCartCustomizationViewHolderBinderKt.updateWithDiscount(instance, 0.0f, new Function0<Unit>() {
                            public final void invoke() {
                                checkOutScreen.setTotalAmount();
                            }
                        });
                    }
                });
            }
        });
        GemCheckoutDiscountView gemCheckoutDiscountView = (GemCheckoutDiscountView) this.f55724g.findViewById(R.id.gemCheckoutDiscountView);
        Intrinsics.checkNotNullExpressionValue(gemCheckoutDiscountView, "gemCheckoutDiscountView");
        FrameLayout frameLayout = (FrameLayout) this.f55724g.findViewById(R.id.gem_discount_view_layout);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "gem_discount_view_layout");
        new GemDiscountViewBinder(gemCheckoutDiscountView, frameLayout).accept((AppCompatActivity) this.f55724g);
    }
}
