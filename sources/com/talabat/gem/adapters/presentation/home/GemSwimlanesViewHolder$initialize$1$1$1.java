package com.talabat.gem.adapters.presentation.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.impressions.ImpressionsIntegrationKt;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder$initialize$1$1$1 extends Lambda implements Function1<GemView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewHolder f60069g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f60070h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewModel f60071i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSwimlanesViewHolder$initialize$1$1$1(GemSwimlanesViewHolder gemSwimlanesViewHolder, View view, GemSwimlanesViewModel gemSwimlanesViewModel) {
        super(1);
        this.f60069g = gemSwimlanesViewHolder;
        this.f60070h = view;
        this.f60071i = gemSwimlanesViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemView gemView) {
        Intrinsics.checkNotNullParameter(gemView, "$this$withGemFlowTracking");
        this.f60069g.registerAnalyticsTrigger(this.f60070h, this.f60071i);
        final GemSwimlanesViewModel gemSwimlanesViewModel = this.f60071i;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                return RxKt.invoke(gemSwimlanesViewModel.getErrors(), AnonymousClass1.INSTANCE);
            }
        });
        final GemSwimlanesViewModel gemSwimlanesViewModel2 = this.f60071i;
        final GemSwimlanesViewHolder gemSwimlanesViewHolder = this.f60069g;
        final View view = this.f60070h;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<Boolean> visibility = gemSwimlanesViewModel2.getVisibility();
                final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder;
                final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel2;
                final View view = view;
                return RxKt.invoke(visibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                        final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder;
                        final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel;
                        final View view = view;
                        on2.next(new Function1<Boolean, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Boolean) obj);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
                                if ((r8 != null && (com.talabat.gem.domain.usecases.BusinessRulesKt.isExpired(r8, java.lang.System.currentTimeMillis() + ((long) 100)) ^ true)) != false) goto L_0x0059;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(java.lang.Boolean r8) {
                                /*
                                    r7 = this;
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder r0 = r1
                                    io.reactivex.subjects.BehaviorSubject r0 = r0.mode
                                    java.lang.Object r0 = com.talabat.talabatcommon.extentions.RxKt.invoke(r0)
                                    com.talabat.gem.domain.entities.GemMode r1 = com.talabat.gem.domain.entities.GemMode.DISABLED
                                    r2 = 0
                                    if (r0 == r1) goto L_0x0058
                                    java.lang.String r0 = "it"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                                    boolean r8 = r8.booleanValue()
                                    if (r8 == 0) goto L_0x0058
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewModel r8 = r2
                                    io.reactivex.subjects.BehaviorSubject r8 = r8.getRestaurants()
                                    java.lang.Object r8 = com.talabat.talabatcommon.extentions.RxKt.invoke(r8)
                                    java.util.Collection r8 = (java.util.Collection) r8
                                    r0 = 1
                                    if (r8 == 0) goto L_0x0032
                                    boolean r8 = r8.isEmpty()
                                    if (r8 == 0) goto L_0x0030
                                    goto L_0x0032
                                L_0x0030:
                                    r8 = r2
                                    goto L_0x0033
                                L_0x0032:
                                    r8 = r0
                                L_0x0033:
                                    if (r8 != 0) goto L_0x0058
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewModel r8 = r2
                                    io.reactivex.subjects.BehaviorSubject r8 = r8.getOffer()
                                    java.lang.Object r8 = com.talabat.talabatcommon.extentions.RxKt.invoke(r8)
                                    com.talabat.gem.domain.entities.GemOffer r8 = (com.talabat.gem.domain.entities.GemOffer) r8
                                    if (r8 == 0) goto L_0x0054
                                    long r3 = java.lang.System.currentTimeMillis()
                                    r1 = 100
                                    long r5 = (long) r1
                                    long r3 = r3 + r5
                                    boolean r8 = com.talabat.gem.domain.usecases.BusinessRulesKt.isExpired(r8, r3)
                                    r8 = r8 ^ r0
                                    if (r8 != r0) goto L_0x0054
                                    r8 = r0
                                    goto L_0x0055
                                L_0x0054:
                                    r8 = r2
                                L_0x0055:
                                    if (r8 == 0) goto L_0x0058
                                    goto L_0x0059
                                L_0x0058:
                                    r0 = r2
                                L_0x0059:
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder r8 = r1
                                    boolean r8 = r8.isAlreadyVisible(r0)
                                    if (r8 != 0) goto L_0x0096
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder r8 = r1
                                    boolean r8 = r8.isAlreadyGone(r0)
                                    if (r8 == 0) goto L_0x006a
                                    goto L_0x0096
                                L_0x006a:
                                    if (r0 != 0) goto L_0x007c
                                    android.view.View r8 = r3
                                    int r1 = com.talabat.gem.adapters.R.id.genSwimlaneOuterLayout
                                    android.view.View r8 = r8.findViewById(r1)
                                    android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
                                    r1 = 8
                                    r8.setVisibility(r1)
                                    goto L_0x0089
                                L_0x007c:
                                    android.view.View r8 = r3
                                    int r1 = com.talabat.gem.adapters.R.id.restaurantCardsRecyclerView
                                    android.view.View r8 = r8.findViewById(r1)
                                    androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
                                    r8.setVisibility(r2)
                                L_0x0089:
                                    com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder r8 = r1
                                    io.reactivex.subjects.BehaviorSubject r8 = r8.triggerHeightAnimation
                                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                                    com.talabat.talabatcommon.extentions.RxKt.plusAssign(r8, r0)
                                L_0x0096:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder$initialize$1$1$1.AnonymousClass2.AnonymousClass1.AnonymousClass1.invoke(java.lang.Boolean):void");
                            }
                        });
                    }
                });
            }
        });
        final GemSwimlanesViewHolder gemSwimlanesViewHolder2 = this.f60069g;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject access$getTriggerHeightAnimation$p = gemSwimlanesViewHolder2.triggerHeightAnimation;
                final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder2;
                return RxKt.invoke(access$getTriggerHeightAnimation$p, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        observerCallbacks.transform(AnonymousClass1.INSTANCE);
                        ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                        final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder;
                        on2.next(new Function1<Boolean, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Boolean) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Boolean bool) {
                                GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder;
                                View view = gemSwimlanesViewHolder.itemView;
                                Intrinsics.checkNotNullExpressionValue(view, "itemView");
                                Intrinsics.checkNotNullExpressionValue(bool, "it");
                                GemSwimlanesViewHolder.b(gemSwimlanesViewHolder, view, bool.booleanValue(), 0, 2, (Object) null);
                                gemSwimlanesViewHolder.invokeCallbacksAndAnalytics(bool.booleanValue());
                            }
                        });
                    }
                });
            }
        });
        final GemSwimlanesViewModel gemSwimlanesViewModel3 = this.f60071i;
        final View view2 = this.f60070h;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<SaveUpToAmountText> saveUpToAmountText = gemSwimlanesViewModel3.getSaveUpToAmountText();
                final View view = view2;
                return RxKt.invoke(saveUpToAmountText, new Function1<ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> on2 = observerCallbacks.getOn();
                        final View view = view;
                        on2.next(new Function1<SaveUpToAmountText, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SaveUpToAmountText) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SaveUpToAmountText saveUpToAmountText) {
                                View view = view;
                                int i11 = R.id.saveAmountTextView;
                                ((TextView) view.findViewById(i11)).setVisibility(0);
                                TextView textView = (TextView) view.findViewById(i11);
                                Intrinsics.checkNotNullExpressionValue(textView, "saveAmountTextView");
                                ViewKt.plusAssign(textView, StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_swimlane_title, (String) null, 1, (Object) null), "{saveAmount}", saveUpToAmountText.getSaveAmount(), false, 4, (Object) null), "{currency}", saveUpToAmountText.getCurrency(), false, 4, (Object) null));
                            }
                        });
                    }
                });
            }
        });
        final GemSwimlanesViewModel gemSwimlanesViewModel4 = this.f60071i;
        final View view3 = this.f60070h;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<String> counter = gemSwimlanesViewModel4.getCounter();
                final View view = view3;
                return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        observerCallbacks.transform(AnonymousClass1.INSTANCE);
                        ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                        final View view = view;
                        on2.next(new Function1<String, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String str) {
                                ((ImageView) view.findViewById(R.id.counterIconImageView)).setVisibility(0);
                                ((TextView) view.findViewById(R.id.counterTextView)).setVisibility(0);
                            }
                        });
                    }
                });
            }
        });
        final GemSwimlanesViewModel gemSwimlanesViewModel5 = this.f60071i;
        final View view4 = this.f60070h;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<String> counter = gemSwimlanesViewModel5.getCounter();
                final View view = view4;
                return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
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
                                TextView textView = (TextView) view.findViewById(R.id.counterTextView);
                                Intrinsics.checkNotNullExpressionValue(textView, "counterTextView");
                                ViewKt.plusAssign(textView, str);
                            }
                        });
                    }
                });
            }
        });
        final GemSwimlanesViewModel gemSwimlanesViewModel6 = this.f60071i;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<List<GemRestaurant>> restaurants = gemSwimlanesViewModel6.getRestaurants();
                final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel6;
                return RxKt.invoke(restaurants, new Function1<ObserverCallbacks<List<? extends GemRestaurant>, Observable<List<? extends GemRestaurant>>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> on2 = observerCallbacks.getOn();
                        final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel;
                        on2.next(new Function1<List<? extends GemRestaurant>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((List<GemRestaurant>) (List) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(List<GemRestaurant> list) {
                                Collection collection = list;
                                if (collection == null || collection.isEmpty()) {
                                    RxKt.plusAssign(gemSwimlanesViewModel.getVisibility(), Boolean.FALSE);
                                } else {
                                    RxKt.plusAssign(gemSwimlanesViewModel.getVisibility(), Boolean.TRUE);
                                }
                            }
                        });
                    }
                });
            }
        });
        final View view5 = this.f60070h;
        final GemSwimlanesViewHolder gemSwimlanesViewHolder3 = this.f60069g;
        final GemSwimlanesViewModel gemSwimlanesViewModel7 = this.f60071i;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                View view = view5;
                int i11 = R.id.restaurantCardsRecyclerView;
                GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder3;
                Context context = view5.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ((RecyclerView) view.findViewById(i11)).addItemDecoration(gemSwimlanesViewHolder.generateItemDecoration(context));
                RecyclerView recyclerView = (RecyclerView) view5.findViewById(i11);
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                int i12 = R.layout.gem_restaurant_card_view;
                BehaviorSubject<List<GemRestaurant>> restaurants = gemSwimlanesViewModel7.getRestaurants();
                GemSwimlanesViewHolder$layoutManager$1 access$layoutManager = gemSwimlanesViewHolder3.layoutManager(view5);
                final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel7;
                final GemSwimlanesViewHolder gemSwimlanesViewHolder2 = gemSwimlanesViewHolder3;
                return FunctionalAdaptersKt.invoke$default(recyclerView, i12, restaurants, access$layoutManager, (Function2) null, new Function2<View, GemRestaurant, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((View) obj, (GemRestaurant) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view, @NotNull final GemRestaurant gemRestaurant) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                        final GemSwimlanesViewModel gemSwimlanesViewModel = gemSwimlanesViewModel;
                        final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder2;
                        SwimlanesRestaurantsBindingKt.bindGemSwimlaneRestaurant(view, gemRestaurant, new Function0<Unit>() {
                            public final void invoke() {
                                GemRestaurantsBusinessRulesKt.onRestaurantSelected$default(gemSwimlanesViewModel, gemRestaurant, false, 2, (Object) null);
                                gemSwimlanesViewHolder.onSelectedAction.invoke(gemRestaurant);
                            }
                        });
                    }
                }, 8, (Object) null);
            }
        });
        final GemSwimlanesViewHolder gemSwimlanesViewHolder4 = this.f60069g;
        gemView.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                ReplaySubject access$getConfigurations$p = gemSwimlanesViewHolder4.configurations;
                final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder4;
                return RxKt.invoke(access$getConfigurations$p, new Function1<ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> on2 = observerCallbacks.getOn();
                        final GemSwimlanesViewHolder gemSwimlanesViewHolder = gemSwimlanesViewHolder;
                        on2.next(new Function1<GemEntryViewConfigurations, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GemEntryViewConfigurations) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GemEntryViewConfigurations gemEntryViewConfigurations) {
                                GemMode mode$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getWith().getMode$com_talabat_Components_gem_gem();
                                if (mode$com_talabat_Components_gem_gem != null) {
                                    RxKt.plusAssign(gemSwimlanesViewHolder.mode, mode$com_talabat_Components_gem_gem);
                                }
                                Function1<GemRestaurant, Unit> onSelected$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnSelected$com_talabat_Components_gem_gem();
                                if (onSelected$com_talabat_Components_gem_gem != null) {
                                    gemSwimlanesViewHolder.onSelectedAction = onSelected$com_talabat_Components_gem_gem;
                                }
                                Function0<Unit> onCancelled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnCancelled$com_talabat_Components_gem_gem();
                                if (onCancelled$com_talabat_Components_gem_gem != null) {
                                    gemSwimlanesViewHolder.onCancelledAction = onCancelled$com_talabat_Components_gem_gem;
                                }
                                Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                                if (onEnabled$com_talabat_Components_gem_gem != null) {
                                    gemSwimlanesViewHolder.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                                }
                                Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                                if (onDisabled$com_talabat_Components_gem_gem != null) {
                                    gemSwimlanesViewHolder.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                                }
                            }
                        });
                    }
                });
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f60070h.findViewById(R.id.restaurantCardsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ImpressionsIntegrationKt.trackImpressions(recyclerView, this.f60071i.getRestaurants().getValue(), AnonymousClass10.INSTANCE);
    }
}
