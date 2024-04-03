package com.talabat.components.gem.checkout;

import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.data.GemDataSourcesKt;
import com.talabat.gem.adapters.presentation.GemCheckoutDiscountConfigurations;
import com.talabat.gem.adapters.presentation.GemDiscountCallbacks;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.helpers.GlobalDataModel;
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
public final class GemDiscountViewBinder$accept$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemDiscountViewBinder f55730g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f55731h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemDiscountViewBinder$accept$1(GemDiscountViewBinder gemDiscountViewBinder, AppCompatActivity appCompatActivity) {
        super(0);
        this.f55730g = gemDiscountViewBinder;
        this.f55731h = appCompatActivity;
    }

    public final void invoke() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        final Integer valueOf = restaurant != null ? Integer.valueOf(restaurant.f13872id) : null;
        GemCheckoutDiscountView access$getGemCheckoutDiscountView$p = this.f55730g.gemCheckoutDiscountView;
        final GemDiscountViewBinder gemDiscountViewBinder = this.f55730g;
        access$getGemCheckoutDiscountView$p.invoke(new Function1<GemCheckoutDiscountConfigurations, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemCheckoutDiscountConfigurations) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
                Intrinsics.checkNotNullParameter(gemCheckoutDiscountConfigurations, "$this$invoke");
                gemCheckoutDiscountConfigurations.getWith().restaurantId(valueOf);
                gemCheckoutDiscountConfigurations.getWith().subTotal(Double.valueOf(GemDataSourcesKt.subTotalAmount()));
                GemDiscountCallbacks on2 = gemCheckoutDiscountConfigurations.getOn();
                final GemDiscountViewBinder gemDiscountViewBinder = gemDiscountViewBinder;
                final Ref.ObjectRef<Timer> objectRef = objectRef;
                on2.enabled(new Function0<Unit>() {
                    public final void invoke() {
                        gemDiscountViewBinder.gemCheckoutDiscountView.setVisibility(0);
                        gemDiscountViewBinder.gemDiscountViewLayout.setVisibility(8);
                        Ref.ObjectRef<Timer> objectRef = objectRef;
                        final GemDiscountViewBinder gemDiscountViewBinder = gemDiscountViewBinder;
                        objectRef.element = GemDataSourcesKt.onSubTotalChanged$default(0, new Function1<Double, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).doubleValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final double d11) {
                                gemDiscountViewBinder.gemCheckoutDiscountView.invoke(new Function1<GemCheckoutDiscountConfigurations, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GemCheckoutDiscountConfigurations) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
                                        Intrinsics.checkNotNullParameter(gemCheckoutDiscountConfigurations, "$this$invoke");
                                        gemCheckoutDiscountConfigurations.getWith().subTotal(Double.valueOf(d11));
                                    }
                                });
                            }
                        }, 1, (Object) null);
                    }
                });
                GemDiscountCallbacks on3 = gemCheckoutDiscountConfigurations.getOn();
                final GemDiscountViewBinder gemDiscountViewBinder2 = gemDiscountViewBinder;
                final Ref.ObjectRef<Timer> objectRef2 = objectRef;
                on3.disabled(new Function0<Unit>() {
                    public final void invoke() {
                        gemDiscountViewBinder2.gemCheckoutDiscountView.setVisibility(8);
                        gemDiscountViewBinder2.gemDiscountViewLayout.setVisibility(0);
                        Timer timer = (Timer) objectRef2.element;
                        if (timer != null) {
                            timer.cancel();
                        }
                    }
                });
                gemCheckoutDiscountConfigurations.getOn().discount(AnonymousClass3.INSTANCE);
            }
        });
        AppCompatActivity appCompatActivity = this.f55731h;
        final GemDiscountViewBinder gemDiscountViewBinder2 = this.f55730g;
        ContextLifecycleEventsKt.withLifecycleEvents(appCompatActivity, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$null");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final GemDiscountViewBinder gemDiscountViewBinder = gemDiscountViewBinder2;
                final Integer num = valueOf;
                on2.resume(new Function0<Unit>() {
                    public final void invoke() {
                        GemCheckoutDiscountView access$getGemCheckoutDiscountView$p = gemDiscountViewBinder.gemCheckoutDiscountView;
                        final Integer num = num;
                        access$getGemCheckoutDiscountView$p.invoke(new Function1<GemCheckoutDiscountConfigurations, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GemCheckoutDiscountConfigurations) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
                                Intrinsics.checkNotNullParameter(gemCheckoutDiscountConfigurations, "$this$invoke");
                                gemCheckoutDiscountConfigurations.getWith().restaurantId(num);
                                gemCheckoutDiscountConfigurations.getWith().subTotal(Double.valueOf(GemDataSourcesKt.subTotalAmount()));
                            }
                        });
                    }
                });
            }
        });
    }
}
