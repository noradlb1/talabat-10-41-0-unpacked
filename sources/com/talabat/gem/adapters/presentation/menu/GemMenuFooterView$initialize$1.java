package com.talabat.gem.adapters.presentation.menu;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemMenuFooterConfigurations;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.TiersBindingKt;
import com.talabat.gem.adapters.presentation.expiration.GemExpiredViewKt;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt;
import com.talabat.gem.domain.usecases.SubTotalLineOne;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
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
public final class GemMenuFooterView$initialize$1 extends Lambda implements Function1<GemView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemMenuFooterView f60145g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f60146h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemMenuFooterView$initialize$1(GemMenuFooterView gemMenuFooterView, Context context) {
        super(1);
        this.f60145g = gemMenuFooterView;
        this.f60146h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final GemView gemView) {
        Intrinsics.checkNotNullParameter(gemView, "$this$withGemFlowTracking");
        int i11 = R.layout.v2_gem_footer_view;
        final GemMenuFooterView gemMenuFooterView = this.f60145g;
        final Context context = this.f60146h;
        AutoDisposableKt.bind((AutoDisposable) gemView, i11, (Function0<Unit>) new Function0<Unit>() {
            public final void invoke() {
                TextView textView = (TextView) gemMenuFooterView._$_findCachedViewById(R.id.counterLabelTextView);
                Intrinsics.checkNotNullExpressionValue(textView, "counterLabelTextView");
                ViewKt.plusAssign(textView, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.remaining_time, (String) null, 1, (Object) null));
                AppCompatTextView appCompatTextView = (AppCompatTextView) gemMenuFooterView._$_findCachedViewById(R.id.viewBasketLabelTextView);
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "viewBasketLabelTextView");
                ViewKt.plusAssign((TextView) appCompatTextView, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.view_basket, (String) null, 1, (Object) null));
                TextView textView2 = (TextView) gemMenuFooterView._$_findCachedViewById(R.id.subTotalLabelTextView);
                Intrinsics.checkNotNullExpressionValue(textView2, "subTotalLabelTextView");
                ViewKt.plusAssign(textView2, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_subtotal_label, (String) null, 1, (Object) null));
                CardView cardView = (CardView) gemMenuFooterView._$_findCachedViewById(R.id.openBasketView);
                Intrinsics.checkNotNullExpressionValue(cardView, "openBasketView");
                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                ViewKt.invoke(cardView, new Function1<View, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((View) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        Function0 function0 = (Function0) RxKt.invoke(gemMenuFooterView.onViewBasketClick);
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                });
                GemView gemView = gemView;
                final GemMenuFooterView gemMenuFooterView2 = gemMenuFooterView;
                gemView.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<Boolean> visibilityPerRestaurant = gemMenuFooterView2.getVisibilityPerRestaurant();
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView2;
                        return RxKt.invoke(visibilityPerRestaurant, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
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
                                        ConstraintLayout constraintLayout = (ConstraintLayout) gemMenuFooterView._$_findCachedViewById(R.id.gemFooterViewLayout);
                                        Intrinsics.checkNotNullExpressionValue(constraintLayout, "gemFooterViewLayout");
                                        ViewKt.get(constraintLayout, bool, 8);
                                        Intrinsics.checkNotNullExpressionValue(bool, "it");
                                        if (!(!bool.booleanValue() || (access$getOnEnabledAction$p = gemMenuFooterView.onEnabledAction) == null || (function02 = (Function0) access$getOnEnabledAction$p.getValue()) == null)) {
                                            function02.invoke();
                                        }
                                        if (!bool.booleanValue() && (access$getOnDisabledAction$p = gemMenuFooterView.onDisabledAction) != null && (function0 = (Function0) access$getOnDisabledAction$p.getValue()) != null) {
                                            function0.invoke();
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView2 = gemView;
                final GemMenuFooterView gemMenuFooterView3 = gemMenuFooterView;
                gemView2.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        return RxKt.invoke(gemMenuFooterView3.getErrors(), AnonymousClass1.INSTANCE);
                    }
                });
                GemView gemView3 = gemView;
                final GemMenuFooterView gemMenuFooterView4 = gemMenuFooterView;
                gemView3.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<String> counter = gemMenuFooterView4.getCounter();
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView4;
                        return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                on2.next(new Function1<String, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((String) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(String str) {
                                        TextView textView = (TextView) gemMenuFooterView._$_findCachedViewById(R.id.counterTextView);
                                        Intrinsics.checkNotNullExpressionValue(textView, "counterTextView");
                                        ViewKt.plusAssign(textView, str);
                                    }
                                });
                            }
                        });
                    }
                });
                GemMenuFooterView gemMenuFooterView5 = gemMenuFooterView;
                TiersBindingKt.bindTiersViews(gemMenuFooterView5, (GemTiersViewPort) gemMenuFooterView5);
                GemView gemView4 = gemView;
                final GemMenuFooterView gemMenuFooterView6 = gemMenuFooterView;
                gemView4.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<Boolean> subTotalVisibility = gemMenuFooterView6.getSubTotalVisibility();
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView6;
                        return RxKt.invoke(subTotalVisibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                on2.next(new Function1<Boolean, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Boolean) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Boolean bool) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) gemMenuFooterView._$_findCachedViewById(R.id.subtotalLayout);
                                        Intrinsics.checkNotNullExpressionValue(constraintLayout, "subtotalLayout");
                                        ViewKt.get(constraintLayout, bool, 8);
                                        FrameLayout frameLayout = (FrameLayout) gemMenuFooterView._$_findCachedViewById(R.id.v2_gem_tiers_visibility_layout);
                                        Intrinsics.checkNotNullExpressionValue(frameLayout, "v2_gem_tiers_visibility_layout");
                                        ViewKt.get(frameLayout, Boolean.valueOf(!bool.booleanValue()), 8);
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView5 = gemView;
                final GemMenuFooterView gemMenuFooterView7 = gemMenuFooterView;
                gemView5.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<SubTotalLineOne> subTitleLineOne = gemMenuFooterView7.getSubTitleLineOne();
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView7;
                        return RxKt.invoke(subTitleLineOne, new Function1<ObserverCallbacks<SubTotalLineOne, Observable<SubTotalLineOne>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<SubTotalLineOne, Observable<SubTotalLineOne>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<SubTotalLineOne, Observable<SubTotalLineOne>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<SubTotalLineOne, Observable<SubTotalLineOne>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                on2.next(new Function1<SubTotalLineOne, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((SubTotalLineOne) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SubTotalLineOne subTotalLineOne) {
                                        GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                        Intrinsics.checkNotNullExpressionValue(subTotalLineOne, "it");
                                        ((TextView) gemMenuFooterView._$_findCachedViewById(R.id.subTotalTextView)).setText(GemMenuFooterViewKt.formattedSubTotalText(gemMenuFooterView, subTotalLineOne));
                                        GemMenuFooterView gemMenuFooterView2 = gemMenuFooterView;
                                        int i11 = R.id.discountedSubTotalTextView;
                                        TextView textView = (TextView) gemMenuFooterView2._$_findCachedViewById(i11);
                                        Intrinsics.checkNotNullExpressionValue(textView, "discountedSubTotalTextView");
                                        ViewKt.plusAssign(textView, GemMenuFooterViewKt.subTotalAfterDiscountText(subTotalLineOne));
                                        ((TextView) gemMenuFooterView._$_findCachedViewById(i11)).setTextColor(GemMenuFooterViewKt.subTotalAfterDiscountColor(subTotalLineOne));
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView6 = gemView;
                final GemMenuFooterView gemMenuFooterView8 = gemMenuFooterView;
                gemView6.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<SubTotalLineTwo> subTitleLineTwo = gemMenuFooterView8.getSubTitleLineTwo();
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView8;
                        return RxKt.invoke(subTitleLineTwo, new Function1<ObserverCallbacks<SubTotalLineTwo, Observable<SubTotalLineTwo>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<SubTotalLineTwo, Observable<SubTotalLineTwo>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<SubTotalLineTwo, Observable<SubTotalLineTwo>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<SubTotalLineTwo, Observable<SubTotalLineTwo>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                on2.next(new Function1<SubTotalLineTwo, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((SubTotalLineTwo) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SubTotalLineTwo subTotalLineTwo) {
                                        TextView textView = (TextView) gemMenuFooterView._$_findCachedViewById(R.id.hintTextView);
                                        Intrinsics.checkNotNullExpressionValue(textView, "hintTextView");
                                        Intrinsics.checkNotNullExpressionValue(subTotalLineTwo, "it");
                                        ViewKt.plusAssign(textView, GemMenuFooterViewKt.subTotalLineTwoText(subTotalLineTwo));
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView7 = gemView;
                final GemMenuFooterView gemMenuFooterView9 = gemMenuFooterView;
                gemView7.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        ReplaySubject access$getConfigurations$p = gemMenuFooterView9.configurations;
                        final GemMenuFooterView gemMenuFooterView = gemMenuFooterView9;
                        return RxKt.invoke(access$getConfigurations$p, new Function1<ObserverCallbacks<GemMenuFooterConfigurations, Observable<GemMenuFooterConfigurations>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<GemMenuFooterConfigurations, Observable<GemMenuFooterConfigurations>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<GemMenuFooterConfigurations, Observable<GemMenuFooterConfigurations>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<GemMenuFooterConfigurations, Observable<GemMenuFooterConfigurations>> on2 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView = gemMenuFooterView;
                                on2.error(new Function1<Throwable, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Throwable) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull Throwable th2) {
                                        Intrinsics.checkNotNullParameter(th2, "it");
                                        RxKt.plusAssign(gemMenuFooterView.getErrors(), th2);
                                    }
                                });
                                ObserverCallbacks<GemMenuFooterConfigurations, Observable<GemMenuFooterConfigurations>> on3 = observerCallbacks.getOn();
                                final GemMenuFooterView gemMenuFooterView2 = gemMenuFooterView;
                                on3.next(new Function1<GemMenuFooterConfigurations, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GemMenuFooterConfigurations) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GemMenuFooterConfigurations gemMenuFooterConfigurations) {
                                        Integer restaurantId$com_talabat_Components_gem_gem = gemMenuFooterConfigurations.getWith().getRestaurantId$com_talabat_Components_gem_gem();
                                        if (restaurantId$com_talabat_Components_gem_gem != null) {
                                            GemMenuFooterView gemMenuFooterView = gemMenuFooterView2;
                                            int intValue = restaurantId$com_talabat_Components_gem_gem.intValue();
                                            GemPerRestaurantBusinessRulesKt.onUpdateRestaurantId(gemMenuFooterView, intValue);
                                            if (!Intrinsics.areEqual(RxKt.invoke(gemMenuFooterView.getVisibilityPerRestaurant()), (Object) Boolean.TRUE)) {
                                                BusinessRulesKt.selectIfGemRestaurant(intValue);
                                            }
                                        }
                                        Double subTotal$com_talabat_Components_gem_gem = gemMenuFooterConfigurations.getWith().getSubTotal$com_talabat_Components_gem_gem();
                                        if (subTotal$com_talabat_Components_gem_gem != null) {
                                            GemSubTotalBusinessRulesKt.onUpdateSubTotal(gemMenuFooterView2, subTotal$com_talabat_Components_gem_gem.doubleValue());
                                        }
                                        Function0<Unit> onViewBasket$com_talabat_Components_gem_gem = gemMenuFooterConfigurations.getOn().getOnViewBasket$com_talabat_Components_gem_gem();
                                        if (onViewBasket$com_talabat_Components_gem_gem != null) {
                                            RxKt.plusAssign(gemMenuFooterView2.onViewBasketClick, onViewBasket$com_talabat_Components_gem_gem);
                                        }
                                        Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemMenuFooterConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                                        if (onEnabled$com_talabat_Components_gem_gem != null) {
                                            gemMenuFooterView2.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                                        }
                                        Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemMenuFooterConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                                        if (onDisabled$com_talabat_Components_gem_gem != null) {
                                            gemMenuFooterView2.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView8 = gemView;
                final GemMenuFooterView gemMenuFooterView10 = gemMenuFooterView;
                final Context context = context;
                gemView8.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<Function0<Boolean>> triggerExpirationAlert = gemMenuFooterView10.getTriggerExpirationAlert();
                        final Context context = context;
                        return RxKt.invoke(triggerExpirationAlert, new Function1<ObserverCallbacks<Function0<? extends Boolean>, Observable<Function0<? extends Boolean>>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<Function0<Boolean>, Observable<Function0<Boolean>>> on2 = observerCallbacks.getOn();
                                final Context context = context;
                                on2.next(new Function1<Function0<? extends Boolean>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Function0<Boolean>) (Function0) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Function0<Boolean> function0) {
                                        Context context = context;
                                        Intrinsics.checkNotNullExpressionValue(function0, "it");
                                        GemExpiredViewKt.showGemExpiredView$default(context, function0, (Function0) null, false, 6, (Object) null);
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
