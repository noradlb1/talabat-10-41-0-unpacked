package com.talabat.components.gem.menu;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.talabat.R;
import com.talabat.RestaurantMenuScreenR;
import com.talabat.gem.adapters.data.GemDataSourcesKt;
import com.talabat.gem.adapters.presentation.GemBasketCallbacks;
import com.talabat.gem.adapters.presentation.GemMenuFooterConfigurations;
import com.talabat.gem.adapters.presentation.GemSubTotalData;
import com.talabat.gem.adapters.presentation.menu.GemMenuFooterView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import datamodels.Restaurant;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemMenuFooterViewBinder$accept$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f55746g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemMenuFooterViewBinder$accept$1$1(RestaurantMenuScreenR restaurantMenuScreenR) {
        super(0);
        this.f55746g = restaurantMenuScreenR;
    }

    public final void invoke() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final RestaurantMenuScreenR restaurantMenuScreenR = this.f55746g;
        ((GemMenuFooterView) this.f55746g.findViewById(R.id.gemMenuFooterView)).invoke(new Function1<GemMenuFooterConfigurations, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemMenuFooterConfigurations) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemMenuFooterConfigurations gemMenuFooterConfigurations) {
                Intrinsics.checkNotNullParameter(gemMenuFooterConfigurations, "$this$invoke");
                GemSubTotalData with = gemMenuFooterConfigurations.getWith();
                Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
                with.restaurantId(restaurant != null ? Integer.valueOf(restaurant.f13872id) : null);
                gemMenuFooterConfigurations.getWith().subTotal(Double.valueOf(GemDataSourcesKt.subTotalAmount()));
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                GemBasketCallbacks on2 = gemMenuFooterConfigurations.getOn();
                final RestaurantMenuScreenR restaurantMenuScreenR = restaurantMenuScreenR;
                final Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> objectRef2 = objectRef;
                on2.enabled(new Function0<Unit>() {
                    public final void invoke() {
                        ((FrameLayout) restaurantMenuScreenR.findViewById(R.id.miniCartLayout)).setVisibility(8);
                        RestaurantMenuScreenR restaurantMenuScreenR = restaurantMenuScreenR;
                        int i11 = R.id.gemMenuFooterView;
                        GemMenuFooterView gemMenuFooterView = (GemMenuFooterView) restaurantMenuScreenR.findViewById(i11);
                        Intrinsics.checkNotNullExpressionValue(gemMenuFooterView, "gemMenuFooterView");
                        ViewKt.get$default(gemMenuFooterView, Boolean.TRUE, 0, 2, (Object) null);
                        Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> objectRef = objectRef2;
                        RestaurantMenuScreenR restaurantMenuScreenR2 = restaurantMenuScreenR;
                        objectRef.element = restaurantMenuScreenR2.adjustMenuListPadding((GemMenuFooterView) restaurantMenuScreenR2.findViewById(i11));
                        Ref.ObjectRef<Timer> objectRef2 = objectRef;
                        final RestaurantMenuScreenR restaurantMenuScreenR3 = restaurantMenuScreenR;
                        objectRef2.element = GemDataSourcesKt.onSubTotalChanged$default(0, new Function1<Double, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).doubleValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final double d11) {
                                ((GemMenuFooterView) restaurantMenuScreenR3.findViewById(R.id.gemMenuFooterView)).invoke(new Function1<GemMenuFooterConfigurations, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GemMenuFooterConfigurations) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GemMenuFooterConfigurations gemMenuFooterConfigurations) {
                                        Intrinsics.checkNotNullParameter(gemMenuFooterConfigurations, "$this$invoke");
                                        gemMenuFooterConfigurations.getWith().subTotal(Double.valueOf(d11));
                                    }
                                });
                            }
                        }, 1, (Object) null);
                    }
                });
                GemBasketCallbacks on3 = gemMenuFooterConfigurations.getOn();
                final RestaurantMenuScreenR restaurantMenuScreenR2 = restaurantMenuScreenR;
                final Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> objectRef3 = objectRef;
                on3.disabled(new Function0<Unit>() {
                    public final void invoke() {
                        ((FrameLayout) restaurantMenuScreenR2.findViewById(R.id.miniCartLayout)).setVisibility(0);
                        RestaurantMenuScreenR restaurantMenuScreenR = restaurantMenuScreenR2;
                        int i11 = R.id.gemMenuFooterView;
                        GemMenuFooterView gemMenuFooterView = (GemMenuFooterView) restaurantMenuScreenR.findViewById(i11);
                        Intrinsics.checkNotNullExpressionValue(gemMenuFooterView, "gemMenuFooterView");
                        ViewKt.get(gemMenuFooterView, Boolean.FALSE, 8);
                        Timer timer = (Timer) objectRef.element;
                        if (timer != null) {
                            timer.cancel();
                        }
                        if (objectRef3.element != null) {
                            ((GemMenuFooterView) restaurantMenuScreenR2.findViewById(i11)).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) objectRef3.element);
                        }
                    }
                });
                gemMenuFooterConfigurations.getOn().viewBasket(new Function0<Unit>(restaurantMenuScreenR) {
                    public final void invoke() {
                        ((RestaurantMenuScreenR) this.receiver).openCartScreen();
                    }
                });
            }
        });
        final RestaurantMenuScreenR restaurantMenuScreenR2 = this.f55746g;
        ContextLifecycleEventsKt.withLifecycleEvents(restaurantMenuScreenR2, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$withLifecycleEvents");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final RestaurantMenuScreenR restaurantMenuScreenR = restaurantMenuScreenR2;
                final Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> objectRef = objectRef;
                on2.resume(new Function0<Unit>() {
                    public final void invoke() {
                        RestaurantMenuScreenR restaurantMenuScreenR = restaurantMenuScreenR;
                        int i11 = R.id.gemMenuFooterView;
                        ((GemMenuFooterView) restaurantMenuScreenR.findViewById(i11)).invoke(AnonymousClass1.INSTANCE);
                        if (objectRef.element != null) {
                            ((GemMenuFooterView) restaurantMenuScreenR.findViewById(i11)).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) objectRef.element);
                            Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> objectRef = objectRef;
                            RestaurantMenuScreenR restaurantMenuScreenR2 = restaurantMenuScreenR;
                            objectRef.element = restaurantMenuScreenR2.adjustMenuListPadding((GemMenuFooterView) restaurantMenuScreenR2.findViewById(i11));
                        }
                    }
                });
            }
        });
    }
}
