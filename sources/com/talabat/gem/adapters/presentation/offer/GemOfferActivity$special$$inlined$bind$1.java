package com.talabat.gem.adapters.presentation.offer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.core.navigation.domain.screen.gem.GemOffersScreen;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.impressions.ImpressionsIntegrationKt;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$bind$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivity$special$$inlined$bind$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f60175g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferActivity f60176h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferActivity$special$$inlined$bind$1(AutoDisposable autoDisposable, GemOfferActivity gemOfferActivity) {
        super(1);
        this.f60175g = autoDisposable;
        this.f60176h = gemOfferActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f60175g;
        if (autoDisposable instanceof View) {
            final GemOfferActivity gemOfferActivity = this.f60176h;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel;
                    GemOfferActivity$initialize$1$7 gemOfferActivity$initialize$1$7;
                    GemOffersScreen.GemOffersData gemOffersData;
                    GemOffersScreen.GemOffersData gemOffersData2;
                    GemOffersScreen.GemOffersData gemOffersData3;
                    Context context = ((View) autoDisposable).getContext();
                    boolean z11 = false;
                    Class cls = GemOfferViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        Intent intent = gemOfferActivity.getIntent();
                        if (!(intent == null || (gemOffersData3 = (GemOffersScreen.GemOffersData) intent.getParcelableExtra("navigatorData")) == null)) {
                            z11 = gemOffersData3.isFromFlutterHoF();
                        }
                        gemOfferActivity.checkInstrumentURL();
                        IntegrationKt.getAnalytics().onGemOfferDetailsShown();
                        ImageView imageView = (ImageView) gemOfferActivity._$_findCachedViewById(R.id.imageView_close);
                        Intrinsics.checkNotNullExpressionValue(imageView, "imageView_close");
                        ViewKt.invoke(imageView, new GemOfferActivity$initialize$1$1(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$2(gemOfferViewModel, gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$4(gemOfferViewModel, gemOfferActivity));
                        ((AppBarLayout) gemOfferActivity._$_findCachedViewById(R.id.appbarLayout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new GemOfferActivity$initialize$1$5(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$6(gemOfferActivity, gemOfferViewModel, z11));
                        gemOfferActivity$initialize$1$7 = new GemOfferActivity$initialize$1$7(gemOfferViewModel, gemOfferActivity);
                    } else if (context instanceof FragmentActivity) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        Intent intent2 = gemOfferActivity.getIntent();
                        if (!(intent2 == null || (gemOffersData2 = (GemOffersScreen.GemOffersData) intent2.getParcelableExtra("navigatorData")) == null)) {
                            z11 = gemOffersData2.isFromFlutterHoF();
                        }
                        gemOfferActivity.checkInstrumentURL();
                        IntegrationKt.getAnalytics().onGemOfferDetailsShown();
                        ImageView imageView2 = (ImageView) gemOfferActivity._$_findCachedViewById(R.id.imageView_close);
                        Intrinsics.checkNotNullExpressionValue(imageView2, "imageView_close");
                        ViewKt.invoke(imageView2, new GemOfferActivity$initialize$1$1(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$2(gemOfferViewModel, gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$4(gemOfferViewModel, gemOfferActivity));
                        ((AppBarLayout) gemOfferActivity._$_findCachedViewById(R.id.appbarLayout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new GemOfferActivity$initialize$1$5(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$6(gemOfferActivity, gemOfferViewModel, z11));
                        gemOfferActivity$initialize$1$7 = new GemOfferActivity$initialize$1$7(gemOfferViewModel, gemOfferActivity);
                    } else if (context instanceof Fragment) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        Intent intent3 = gemOfferActivity.getIntent();
                        if (!(intent3 == null || (gemOffersData = (GemOffersScreen.GemOffersData) intent3.getParcelableExtra("navigatorData")) == null)) {
                            z11 = gemOffersData.isFromFlutterHoF();
                        }
                        gemOfferActivity.checkInstrumentURL();
                        IntegrationKt.getAnalytics().onGemOfferDetailsShown();
                        ImageView imageView3 = (ImageView) gemOfferActivity._$_findCachedViewById(R.id.imageView_close);
                        Intrinsics.checkNotNullExpressionValue(imageView3, "imageView_close");
                        ViewKt.invoke(imageView3, new GemOfferActivity$initialize$1$1(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$2(gemOfferViewModel, gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$4(gemOfferViewModel, gemOfferActivity));
                        ((AppBarLayout) gemOfferActivity._$_findCachedViewById(R.id.appbarLayout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new GemOfferActivity$initialize$1$5(gemOfferActivity));
                        gemOfferViewModel.autoDispose(new GemOfferActivity$initialize$1$6(gemOfferActivity, gemOfferViewModel, z11));
                        gemOfferActivity$initialize$1$7 = new GemOfferActivity$initialize$1$7(gemOfferViewModel, gemOfferActivity);
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                    gemOfferViewModel.autoDispose(gemOfferActivity$initialize$1$7);
                    RecyclerView recyclerView = (RecyclerView) gemOfferActivity._$_findCachedViewById(R.id.restaurantsRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
                    ImpressionsIntegrationKt.trackImpressions(recyclerView, gemOfferViewModel.getRestaurants().getValue(), GemOfferActivity$initialize$1$8.INSTANCE);
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final GemOfferActivity gemOfferActivity2 = this.f60176h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
                    r1 = (com.talabat.core.navigation.domain.screen.gem.GemOffersScreen.GemOffersData) r1.getParcelableExtra("navigatorData");
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke() {
                    /*
                        r5 = this;
                        com.talabat.talabatcommon.lifecycle.AutoDisposable r0 = r3
                        androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
                        androidx.lifecycle.ViewModelProvider r0 = androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) r0)
                        java.lang.Class<com.talabat.gem.adapters.presentation.offer.GemOfferViewModel> r1 = com.talabat.gem.adapters.presentation.offer.GemOfferViewModel.class
                        androidx.lifecycle.ViewModel r0 = r0.get(r1)
                        com.talabat.gem.adapters.presentation.offer.GemOfferViewModel r0 = (com.talabat.gem.adapters.presentation.offer.GemOfferViewModel) r0
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r1 = r1
                        android.content.Intent r1 = r1.getIntent()
                        if (r1 == 0) goto L_0x0027
                        java.lang.String r2 = "navigatorData"
                        android.os.Parcelable r1 = r1.getParcelableExtra(r2)
                        com.talabat.core.navigation.domain.screen.gem.GemOffersScreen$GemOffersData r1 = (com.talabat.core.navigation.domain.screen.gem.GemOffersScreen.GemOffersData) r1
                        if (r1 == 0) goto L_0x0027
                        boolean r1 = r1.isFromFlutterHoF()
                        goto L_0x0028
                    L_0x0027:
                        r1 = 0
                    L_0x0028:
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        r2.checkInstrumentURL()
                        com.talabat.gem.ports.analytics.AnalyticsPort r2 = com.talabat.gem.IntegrationKt.getAnalytics()
                        r2.onGemOfferDetailsShown()
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        int r3 = com.talabat.gem.adapters.R.id.imageView_close
                        android.view.View r2 = r2._$_findCachedViewById(r3)
                        android.widget.ImageView r2 = (android.widget.ImageView) r2
                        java.lang.String r3 = "imageView_close"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$1 r3 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$1
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r4 = r1
                        r3.<init>(r4)
                        com.talabat.talabatcommon.extension.ViewKt.invoke(r2, r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$2 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$2
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r0, r3)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$3 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$3
                        r2.<init>(r0)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$4 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$4
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r0, r3)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        int r3 = com.talabat.gem.adapters.R.id.appbarLayout
                        android.view.View r2 = r2._$_findCachedViewById(r3)
                        com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$5 r3 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$5
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r4 = r1
                        r3.<init>(r4)
                        r2.addOnOffsetChangedListener((com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener) r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r3, r0, r1)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$7 r1 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$7
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        r1.<init>(r0, r2)
                        r0.autoDispose(r1)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r1 = r1
                        int r2 = com.talabat.gem.adapters.R.id.restaurantsRecyclerView
                        android.view.View r1 = r1._$_findCachedViewById(r2)
                        androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                        java.lang.String r2 = "restaurantsRecyclerView"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                        io.reactivex.subjects.BehaviorSubject r0 = r0.getRestaurants()
                        java.lang.Object r0 = r0.getValue()
                        java.util.List r0 = (java.util.List) r0
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$8 r2 = com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$8.INSTANCE
                        com.talabat.impressions.ImpressionsIntegrationKt.trackImpressions(r1, r0, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.presentation.offer.GemOfferActivity$special$$inlined$bind$1.AnonymousClass2.invoke():void");
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final GemOfferActivity gemOfferActivity3 = this.f60176h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
                    r1 = (com.talabat.core.navigation.domain.screen.gem.GemOffersScreen.GemOffersData) r1.getParcelableExtra("navigatorData");
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke() {
                    /*
                        r5 = this;
                        com.talabat.talabatcommon.lifecycle.AutoDisposable r0 = r3
                        androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
                        androidx.lifecycle.ViewModelProvider r0 = androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.Fragment) r0)
                        java.lang.Class<com.talabat.gem.adapters.presentation.offer.GemOfferViewModel> r1 = com.talabat.gem.adapters.presentation.offer.GemOfferViewModel.class
                        androidx.lifecycle.ViewModel r0 = r0.get(r1)
                        com.talabat.gem.adapters.presentation.offer.GemOfferViewModel r0 = (com.talabat.gem.adapters.presentation.offer.GemOfferViewModel) r0
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r1 = r1
                        android.content.Intent r1 = r1.getIntent()
                        if (r1 == 0) goto L_0x0027
                        java.lang.String r2 = "navigatorData"
                        android.os.Parcelable r1 = r1.getParcelableExtra(r2)
                        com.talabat.core.navigation.domain.screen.gem.GemOffersScreen$GemOffersData r1 = (com.talabat.core.navigation.domain.screen.gem.GemOffersScreen.GemOffersData) r1
                        if (r1 == 0) goto L_0x0027
                        boolean r1 = r1.isFromFlutterHoF()
                        goto L_0x0028
                    L_0x0027:
                        r1 = 0
                    L_0x0028:
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        r2.checkInstrumentURL()
                        com.talabat.gem.ports.analytics.AnalyticsPort r2 = com.talabat.gem.IntegrationKt.getAnalytics()
                        r2.onGemOfferDetailsShown()
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        int r3 = com.talabat.gem.adapters.R.id.imageView_close
                        android.view.View r2 = r2._$_findCachedViewById(r3)
                        android.widget.ImageView r2 = (android.widget.ImageView) r2
                        java.lang.String r3 = "imageView_close"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$1 r3 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$1
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r4 = r1
                        r3.<init>(r4)
                        com.talabat.talabatcommon.extension.ViewKt.invoke(r2, r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$2 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$2
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r0, r3)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$3 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$3
                        r2.<init>(r0)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$4 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$4
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r0, r3)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        int r3 = com.talabat.gem.adapters.R.id.appbarLayout
                        android.view.View r2 = r2._$_findCachedViewById(r3)
                        com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$5 r3 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$5
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r4 = r1
                        r3.<init>(r4)
                        r2.addOnOffsetChangedListener((com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener) r3)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6 r2 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$6
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r3 = r1
                        r2.<init>(r3, r0, r1)
                        r0.autoDispose(r2)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$7 r1 = new com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$7
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r2 = r1
                        r1.<init>(r0, r2)
                        r0.autoDispose(r1)
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity r1 = r1
                        int r2 = com.talabat.gem.adapters.R.id.restaurantsRecyclerView
                        android.view.View r1 = r1._$_findCachedViewById(r2)
                        androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                        java.lang.String r2 = "restaurantsRecyclerView"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                        io.reactivex.subjects.BehaviorSubject r0 = r0.getRestaurants()
                        java.lang.Object r0 = r0.getValue()
                        java.util.List r0 = (java.util.List) r0
                        com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$8 r2 = com.talabat.gem.adapters.presentation.offer.GemOfferActivity$initialize$1$8.INSTANCE
                        com.talabat.impressions.ImpressionsIntegrationKt.trackImpressions(r1, r0, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.presentation.offer.GemOfferActivity$special$$inlined$bind$1.AnonymousClass3.invoke():void");
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
