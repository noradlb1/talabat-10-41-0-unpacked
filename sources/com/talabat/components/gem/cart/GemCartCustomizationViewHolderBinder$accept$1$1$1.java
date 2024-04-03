package com.talabat.components.gem.cart;

import android.view.View;
import android.widget.LinearLayout;
import buisnessmodels.Cart;
import com.talabat.CartScreen;
import com.talabat.R;
import com.talabat.gem.adapters.data.GemDataSourcesKt;
import com.talabat.gem.adapters.presentation.GemCheckoutDiscountConfigurations;
import com.talabat.gem.adapters.presentation.GemDiscountCallbacks;
import com.talabat.gem.adapters.presentation.GemSubTotalData;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extension.ViewKt;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemCheckoutDiscountConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCartCustomizationViewHolderBinder$accept$1$1$1 extends Lambda implements Function1<GemCheckoutDiscountConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f55709g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CartScreen f55710h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCartCustomizationViewHolderBinder$accept$1$1$1(View view, CartScreen cartScreen) {
        super(1);
        this.f55709g = view;
        this.f55710h = cartScreen;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemCheckoutDiscountConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
        Intrinsics.checkNotNullParameter(gemCheckoutDiscountConfigurations, "$this$invoke");
        GemSubTotalData with = gemCheckoutDiscountConfigurations.getWith();
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        with.restaurantId(restaurant != null ? Integer.valueOf(restaurant.f13872id) : null);
        gemCheckoutDiscountConfigurations.getWith().subTotal(Double.valueOf(GemDataSourcesKt.subTotalAmount()));
        GemDiscountCallbacks on2 = gemCheckoutDiscountConfigurations.getOn();
        final View view = this.f55709g;
        on2.enabled(new Function0<Unit>() {
            public final void invoke() {
                GemCheckoutDiscountView gemCheckoutDiscountView = (GemCheckoutDiscountView) view.findViewById(R.id.gemCartDiscountView);
                Intrinsics.checkNotNullExpressionValue(gemCheckoutDiscountView, "gemCartDiscountView");
                ViewKt.get(gemCheckoutDiscountView, Boolean.TRUE, 8);
                ((LinearLayout) view.findViewById(R.id.gem_discount_view_layout)).setVisibility(8);
            }
        });
        GemDiscountCallbacks on3 = gemCheckoutDiscountConfigurations.getOn();
        final View view2 = this.f55709g;
        final CartScreen cartScreen = this.f55710h;
        on3.disabled(new Function0<Unit>() {
            public final void invoke() {
                GemCheckoutDiscountView gemCheckoutDiscountView = (GemCheckoutDiscountView) view2.findViewById(R.id.gemCartDiscountView);
                Intrinsics.checkNotNullExpressionValue(gemCheckoutDiscountView, "gemCartDiscountView");
                ViewKt.get(gemCheckoutDiscountView, Boolean.FALSE, 8);
                ((LinearLayout) view2.findViewById(R.id.gem_discount_view_layout)).setVisibility(0);
                Cart instance = Cart.getInstance();
                final CartScreen cartScreen = cartScreen;
                GemCartCustomizationViewHolderBinderKt.updateWithDiscount(instance, 0.0f, new Function0<Unit>() {
                    public final void invoke() {
                        cartScreen.cartRecyclerviewAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
        GemDiscountCallbacks on4 = gemCheckoutDiscountConfigurations.getOn();
        final CartScreen cartScreen2 = this.f55710h;
        on4.discount(new Function1<Double, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double d11) {
                final CartScreen cartScreen = cartScreen2;
                GemCartCustomizationViewHolderBinderKt.updateWithDiscount(Cart.getInstance(), (float) d11, new Function0<Unit>() {
                    public final void invoke() {
                        cartScreen.cartRecyclerviewAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
