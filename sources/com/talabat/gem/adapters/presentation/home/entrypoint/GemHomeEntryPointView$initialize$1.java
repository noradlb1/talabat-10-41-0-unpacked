package com.talabat.gem.adapters.presentation.home.entrypoint;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.C;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.views.ShimmerLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemHomeEntryPointView$initialize$1 extends Lambda implements Function1<GemView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemHomeEntryPointView f60113g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f60114h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemHomeEntryPointView$initialize$1(GemHomeEntryPointView gemHomeEntryPointView, Context context) {
        super(1);
        this.f60113g = gemHomeEntryPointView;
        this.f60114h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final GemView gemView) {
        Intrinsics.checkNotNullParameter(gemView, "$this$withGemFlowTracking");
        final GemHomeEntryPointView gemHomeEntryPointView = this.f60113g;
        int i11 = R.layout.gem_home_entry_point;
        final Context context = this.f60114h;
        ViewKt.withLayout(gemHomeEntryPointView, i11, new Function1<View, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final View view) {
                Intrinsics.checkNotNullParameter(view, "$this$withLayout");
                ((ShimmerLayout) view.findViewById(R.id.loading_state)).startShimmerAnimation();
                GemView gemView = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView;
                gemView.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        return RxKt.invoke(gemHomeEntryPointView.getErrors(), AnonymousClass1.INSTANCE);
                    }
                });
                GemView gemView2 = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView2 = gemHomeEntryPointView;
                gemView2.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject access$getViewVisibility$p = gemHomeEntryPointView2.viewVisibility;
                        final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView2;
                        return RxKt.invoke(access$getViewVisibility$p, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView;
                                on2.next(new Function1<Boolean, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Boolean) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Boolean bool) {
                                        boolean z11 = false;
                                        if (RxKt.invoke(gemHomeEntryPointView.mode) != GemMode.DISABLED) {
                                            Intrinsics.checkNotNullExpressionValue(bool, "it");
                                            if (bool.booleanValue()) {
                                                Collection collection = (Collection) RxKt.invoke(gemHomeEntryPointView.getRestaurants());
                                                if (!(collection == null || collection.isEmpty())) {
                                                    GemOffer gemOffer = (GemOffer) RxKt.invoke(gemHomeEntryPointView.getOffer());
                                                    if (gemOffer != null && (BusinessRulesKt.isExpired(gemOffer, System.currentTimeMillis() + ((long) 100)) ^ true)) {
                                                        z11 = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (!gemHomeEntryPointView.isAlreadyVisible(z11) && !gemHomeEntryPointView.isAlreadyGone(z11)) {
                                            if (z11) {
                                                IntegrationKt.getAnalytics().onGemHomeSwimlaneShown();
                                            }
                                            RxKt.plusAssign(gemHomeEntryPointView.loadedState, Boolean.valueOf(z11));
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView3 = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView3 = gemHomeEntryPointView;
                gemView3.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<SaveUpToAmountText> saveUpToAmountText = gemHomeEntryPointView3.getSaveUpToAmountText();
                        final View view = view;
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
                                        TextView textView = (TextView) view.findViewById(R.id.tvGemTitle);
                                        Intrinsics.checkNotNullExpressionValue(textView, "tvGemTitle");
                                        Intrinsics.checkNotNullExpressionValue(saveUpToAmountText, "it");
                                        ViewKt.plusAssign(textView, GemEntryBusinessRulesKt.getTitle(saveUpToAmountText));
                                        TextView textView2 = (TextView) view.findViewById(R.id.tvGemSubTitle);
                                        Intrinsics.checkNotNullExpressionValue(textView2, "tvGemSubTitle");
                                        ViewKt.plusAssign(textView2, GemEntryBusinessRulesKt.getBrandingMessage(saveUpToAmountText));
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView4 = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView4 = gemHomeEntryPointView;
                gemView4.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<String> counter = gemHomeEntryPointView4.getCounter();
                        final View view = view;
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
                                        TextView textView = (TextView) view.findViewById(R.id.tvGemTimer);
                                        Intrinsics.checkNotNullExpressionValue(textView, "tvGemTimer");
                                        ViewKt.plusAssign(textView, str);
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView5 = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView5 = gemHomeEntryPointView;
                gemView5.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject<List<GemRestaurant>> restaurants = gemHomeEntryPointView5.getRestaurants();
                        final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView5;
                        return RxKt.invoke(restaurants, new Function1<ObserverCallbacks<List<? extends GemRestaurant>, Observable<List<? extends GemRestaurant>>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<List<GemRestaurant>, Observable<List<GemRestaurant>>> on2 = observerCallbacks.getOn();
                                final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView;
                                on2.next(new Function1<List<? extends GemRestaurant>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((List<GemRestaurant>) (List) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<GemRestaurant> list) {
                                        Collection collection = list;
                                        if (collection == null || collection.isEmpty()) {
                                            RxKt.plusAssign(gemHomeEntryPointView.viewVisibility, Boolean.FALSE);
                                        } else {
                                            RxKt.plusAssign(gemHomeEntryPointView.viewVisibility, Boolean.TRUE);
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                GemView gemView6 = gemView;
                final GemHomeEntryPointView gemHomeEntryPointView6 = gemHomeEntryPointView;
                final Context context = context;
                gemView6.autoDispose(new Function0<Disposable>() {
                    @Nullable
                    public final Disposable invoke() {
                        BehaviorSubject access$getLoadedState$p = gemHomeEntryPointView6.loadedState;
                        final View view = view;
                        final Context context = context;
                        final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView6;
                        return RxKt.invoke(access$getLoadedState$p, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                                final View view = view;
                                final Context context = context;
                                final GemHomeEntryPointView gemHomeEntryPointView = gemHomeEntryPointView;
                                on2.next(new Function1<Boolean, Unit>() {
                                    /* access modifiers changed from: private */
                                    /* renamed from: invoke$lambda-0  reason: not valid java name */
                                    public static final void m10540invoke$lambda0(GemHomeEntryPointView gemHomeEntryPointView, View view) {
                                        Intrinsics.checkNotNullParameter(gemHomeEntryPointView, "this$0");
                                        gemHomeEntryPointView.navigateToGemCollection();
                                    }

                                    /* access modifiers changed from: private */
                                    /* renamed from: invoke$lambda-1  reason: not valid java name */
                                    public static final void m10541invoke$lambda1(View view) {
                                    }

                                    /* access modifiers changed from: private */
                                    /* renamed from: invoke$lambda-2  reason: not valid java name */
                                    public static final void m10542invoke$lambda2(GemHomeEntryPointView gemHomeEntryPointView) {
                                        Intrinsics.checkNotNullParameter(gemHomeEntryPointView, "this$0");
                                        gemHomeEntryPointView.getOnGemAvailabilityCallback().invoke(Boolean.FALSE);
                                        RxKt.plusAssign(gemHomeEntryPointView.viewVisibility, Boolean.TRUE);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Boolean) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Boolean bool) {
                                        Intrinsics.checkNotNullExpressionValue(bool, "it");
                                        if (bool.booleanValue()) {
                                            view.findViewById(R.id.layout_gem_loaded).setVisibility(0);
                                            ((LottieAnimationView) view.findViewById(R.id.lottieGem)).setMinAndMaxFrame(0, 90);
                                            view.setOnClickListener(new a(gemHomeEntryPointView));
                                            return;
                                        }
                                        view.setOnClickListener(new b());
                                        View view = view;
                                        int i11 = R.id.tvGemTimer;
                                        TextView textView = (TextView) view.findViewById(i11);
                                        Intrinsics.checkNotNullExpressionValue(textView, "tvGemTimer");
                                        ViewKt.plusAssign(textView, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string._00_00, (String) null, 1, (Object) null));
                                        Context context = context;
                                        int i12 = com.designsystem.marshmallow.R.color.ds_neutral_55;
                                        ((TextView) view.findViewById(i11)).setTextColor(ContextCompat.getColor(context, i12));
                                        View view2 = view;
                                        int i13 = R.id.tvGemTitle;
                                        ((TextView) view2.findViewById(i13)).setTextColor(ContextCompat.getColor(context, i12));
                                        View view3 = view;
                                        int i14 = R.id.tvGemSubTitle;
                                        ((TextView) view3.findViewById(i14)).setTextColor(ContextCompat.getColor(context, i12));
                                        TextView textView2 = (TextView) view.findViewById(i13);
                                        Intrinsics.checkNotNullExpressionValue(textView2, "tvGemTitle");
                                        ViewKt.plusAssign(textView2, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_expired_title, (String) null, 1, (Object) null));
                                        TextView textView3 = (TextView) view.findViewById(i14);
                                        Intrinsics.checkNotNullExpressionValue(textView3, "tvGemSubTitle");
                                        ViewKt.plusAssign(textView3, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_expired_sub_title, (String) null, 1, (Object) null));
                                        ((CardView) view.findViewById(R.id.gemCardView)).setCardElevation(0.0f);
                                        ((ImageView) view.findViewById(R.id.ivGemCropped)).setAlpha(0.1f);
                                        view.postDelayed(new c(gemHomeEntryPointView), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
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
