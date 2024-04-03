package com.talabat.gem.adapters.presentation.checkout;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemCheckoutDiscountConfigurations;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutDiscountView$initialize$1 extends Lambda implements Function1<GemView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutDiscountView f59904g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f59905h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutDiscountView$initialize$1(GemCheckoutDiscountView gemCheckoutDiscountView, Context context) {
        super(1);
        this.f59904g = gemCheckoutDiscountView;
        this.f59905h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemView gemView) {
        Intrinsics.checkNotNullParameter(gemView, "$this$withGemFlowTracking");
        final GemCheckoutDiscountView gemCheckoutDiscountView = this.f59904g;
        int i11 = R.layout.v2_gem_discount_view;
        final Context context = this.f59905h;
        ViewKt.withLayout(gemCheckoutDiscountView, i11, new Function1<View, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final View view) {
                Intrinsics.checkNotNullParameter(view, "$this$withLayout");
                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.gemSavingAmountLabel);
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "gemSavingAmountLabel");
                ViewKt.plusAssign((TextView) appCompatTextView, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.saving_amount, (String) null, 1, (Object) null));
                Context context = context;
                final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView;
                AutoDisposableKt.withAutoDisposables(context, new Function1<AutoDisposable, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((AutoDisposable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull AutoDisposable autoDisposable) {
                        Intrinsics.checkNotNullParameter(autoDisposable, "$this$null");
                        final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                return RxKt.invoke(gemCheckoutDiscountView.getErrors(), AnonymousClass1.INSTANCE);
                            }
                        });
                        final GemCheckoutDiscountView gemCheckoutDiscountView2 = gemCheckoutDiscountView;
                        final View view = view;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                BehaviorSubject<Boolean> discountVisibility = gemCheckoutDiscountView2.getDiscountVisibility();
                                final View view = view;
                                return RxKt.invoke(discountVisibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                        final View view = view;
                                        on2.next(new Function1<Boolean, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Boolean) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Boolean bool) {
                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.gemDiscountViewLayout);
                                                Intrinsics.checkNotNullExpressionValue(frameLayout, "gemDiscountViewLayout");
                                                ViewKt.get(frameLayout, bool, 8);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final GemCheckoutDiscountView gemCheckoutDiscountView3 = gemCheckoutDiscountView;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                BehaviorSubject<Boolean> visibilityPerRestaurant = gemCheckoutDiscountView3.getVisibilityPerRestaurant();
                                final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView3;
                                return RxKt.invoke(visibilityPerRestaurant, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                        final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView;
                                        on2.next(new Function1<Boolean, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Boolean) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Boolean bool) {
                                                SingleAccess access$getOnDisabledAction$p;
                                                Function0 function0;
                                                SingleAccess access$getOnEnabledAction$p;
                                                Function0 function02;
                                                Intrinsics.checkNotNullExpressionValue(bool, "it");
                                                if (!(!bool.booleanValue() || (access$getOnEnabledAction$p = gemCheckoutDiscountView.onEnabledAction) == null || (function02 = (Function0) access$getOnEnabledAction$p.getValue()) == null)) {
                                                    function02.invoke();
                                                }
                                                if (!bool.booleanValue() && (access$getOnDisabledAction$p = gemCheckoutDiscountView.onDisabledAction) != null && (function0 = (Function0) access$getOnDisabledAction$p.getValue()) != null) {
                                                    function0.invoke();
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final GemCheckoutDiscountView gemCheckoutDiscountView4 = gemCheckoutDiscountView;
                        final View view2 = view;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                BehaviorSubject<String> discountText = gemCheckoutDiscountView4.getDiscountText();
                                final View view = view2;
                                return RxKt.invoke(discountText, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                                        final View view = view;
                                        on2.next(new Function1<String, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((String) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(String str) {
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.gemOfferPriceTextView);
                                                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "gemOfferPriceTextView");
                                                ViewKt.plusAssign((TextView) appCompatTextView, str);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final GemCheckoutDiscountView gemCheckoutDiscountView5 = gemCheckoutDiscountView;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                BehaviorSubject<Double> discountAmount = gemCheckoutDiscountView5.getDiscountAmount();
                                final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView5;
                                return RxKt.invoke(discountAmount, new Function1<ObserverCallbacks<Double, Observable<Double>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<Double, Observable<Double>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<Double, Observable<Double>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        ObserverCallbacks<Double, Observable<Double>> on2 = observerCallbacks.getOn();
                                        final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView;
                                        on2.next(new Function1<Double, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Double) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Double d11) {
                                                Function1 access$getOnDiscountAction$p = gemCheckoutDiscountView.onDiscountAction;
                                                if (access$getOnDiscountAction$p != null) {
                                                    Intrinsics.checkNotNullExpressionValue(d11, "it");
                                                    access$getOnDiscountAction$p.invoke(d11);
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        final GemCheckoutDiscountView gemCheckoutDiscountView6 = gemCheckoutDiscountView;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @Nullable
                            public final Disposable invoke() {
                                ReplaySubject access$getConfigurations$p = gemCheckoutDiscountView6.configurations;
                                final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView6;
                                return RxKt.invoke(access$getConfigurations$p, new Function1<ObserverCallbacks<GemCheckoutDiscountConfigurations, Observable<GemCheckoutDiscountConfigurations>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<GemCheckoutDiscountConfigurations, Observable<GemCheckoutDiscountConfigurations>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<GemCheckoutDiscountConfigurations, Observable<GemCheckoutDiscountConfigurations>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        ObserverCallbacks<GemCheckoutDiscountConfigurations, Observable<GemCheckoutDiscountConfigurations>> on2 = observerCallbacks.getOn();
                                        final GemCheckoutDiscountView gemCheckoutDiscountView = gemCheckoutDiscountView;
                                        on2.error(new Function1<Throwable, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Throwable) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(@NotNull Throwable th2) {
                                                Intrinsics.checkNotNullParameter(th2, "it");
                                                RxKt.plusAssign(gemCheckoutDiscountView.getErrors(), th2);
                                            }
                                        });
                                        ObserverCallbacks<GemCheckoutDiscountConfigurations, Observable<GemCheckoutDiscountConfigurations>> on3 = observerCallbacks.getOn();
                                        final GemCheckoutDiscountView gemCheckoutDiscountView2 = gemCheckoutDiscountView;
                                        on3.next(new Function1<GemCheckoutDiscountConfigurations, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((GemCheckoutDiscountConfigurations) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
                                                Integer restaurantId$com_talabat_Components_gem_gem = gemCheckoutDiscountConfigurations.getWith().getRestaurantId$com_talabat_Components_gem_gem();
                                                if (restaurantId$com_talabat_Components_gem_gem != null) {
                                                    GemPerRestaurantBusinessRulesKt.onUpdateRestaurantId(gemCheckoutDiscountView2, restaurantId$com_talabat_Components_gem_gem.intValue());
                                                }
                                                Double subTotal$com_talabat_Components_gem_gem = gemCheckoutDiscountConfigurations.getWith().getSubTotal$com_talabat_Components_gem_gem();
                                                if (subTotal$com_talabat_Components_gem_gem != null) {
                                                    GemSubTotalBusinessRulesKt.onUpdateSubTotal(gemCheckoutDiscountView2, subTotal$com_talabat_Components_gem_gem.doubleValue());
                                                }
                                                Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemCheckoutDiscountConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                                                if (onEnabled$com_talabat_Components_gem_gem != null) {
                                                    gemCheckoutDiscountView2.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                                                }
                                                Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemCheckoutDiscountConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                                                if (onDisabled$com_talabat_Components_gem_gem != null) {
                                                    gemCheckoutDiscountView2.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                                                }
                                                Function1<Double, Unit> onDiscount$com_talabat_Components_gem_gem = gemCheckoutDiscountConfigurations.getOn().getOnDiscount$com_talabat_Components_gem_gem();
                                                if (onDiscount$com_talabat_Components_gem_gem != null) {
                                                    gemCheckoutDiscountView2.onDiscountAction = onDiscount$com_talabat_Components_gem_gem;
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}
