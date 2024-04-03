package com.talabat.components.gem.cart;

import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.R;
import com.talabat.gem.adapters.presentation.GemCheckoutFooterConfigurations;
import com.talabat.gem.adapters.presentation.GemRestaurantData;
import com.talabat.gem.adapters.presentation.GemVisibilityCallbacks;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutFooterView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCartScreenBinder$accept$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f55717g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCartScreenBinder$accept$1$1(AppCompatActivity appCompatActivity) {
        super(0);
        this.f55717g = appCompatActivity;
    }

    public final void invoke() {
        final AppCompatActivity appCompatActivity = this.f55717g;
        ContextLifecycleEventsKt.withLifecycleEvents(appCompatActivity, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final AppCompatActivity appCompatActivity = appCompatActivity;
                on2.create(new Function0<Unit>() {
                    public final void invoke() {
                        final AppCompatActivity appCompatActivity = appCompatActivity;
                        ((GemCheckoutFooterView) appCompatActivity.findViewById(R.id.gemCartFooterView)).invoke(new Function1<GemCheckoutFooterConfigurations, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GemCheckoutFooterConfigurations) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull GemCheckoutFooterConfigurations gemCheckoutFooterConfigurations) {
                                Intrinsics.checkNotNullParameter(gemCheckoutFooterConfigurations, "$this$invoke");
                                GemRestaurantData with = gemCheckoutFooterConfigurations.getWith();
                                Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
                                with.restaurantId(restaurant != null ? Integer.valueOf(restaurant.f13872id) : null);
                                GemVisibilityCallbacks on2 = gemCheckoutFooterConfigurations.getOn();
                                final AppCompatActivity appCompatActivity = appCompatActivity;
                                on2.enabled(new Function0<Unit>() {
                                    public final void invoke() {
                                        ((GemCheckoutFooterView) appCompatActivity.findViewById(R.id.gemCartFooterView)).setVisibility(0);
                                        ((FrameLayout) appCompatActivity.findViewById(R.id.gem_footer_view_inner_layout)).setVisibility(8);
                                    }
                                });
                                GemVisibilityCallbacks on3 = gemCheckoutFooterConfigurations.getOn();
                                final AppCompatActivity appCompatActivity2 = appCompatActivity;
                                on3.disabled(new Function0<Unit>() {
                                    public final void invoke() {
                                        ((GemCheckoutFooterView) appCompatActivity2.findViewById(R.id.gemCartFooterView)).setVisibility(8);
                                        ((FrameLayout) appCompatActivity2.findViewById(R.id.gem_footer_view_inner_layout)).setVisibility(0);
                                    }
                                });
                            }
                        });
                    }
                });
                ContextLifecycleEvents on3 = contextLifecycleEvents.getOn();
                final AppCompatActivity appCompatActivity2 = appCompatActivity;
                on3.resume(new Function0<Unit>() {
                    public final void invoke() {
                        ((GemCheckoutFooterView) appCompatActivity2.findViewById(R.id.gemCartFooterView)).invoke(AnonymousClass1.INSTANCE);
                    }
                });
            }
        });
    }
}
