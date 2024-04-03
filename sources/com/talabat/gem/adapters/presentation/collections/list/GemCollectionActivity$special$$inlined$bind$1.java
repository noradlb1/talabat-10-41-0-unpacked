package com.talabat.gem.adapters.presentation.collections.list;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionScreen;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.offer.GemOfferViewModel;
import com.talabat.impressions.ImpressionsIntegrationKt;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$bind$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionActivity$special$$inlined$bind$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f60000g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCollectionActivity f60001h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$special$$inlined$bind$1(AutoDisposable autoDisposable, GemCollectionActivity gemCollectionActivity) {
        super(1);
        this.f60000g = autoDisposable;
        this.f60001h = gemCollectionActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f60000g;
        if (autoDisposable instanceof View) {
            final GemCollectionActivity gemCollectionActivity = this.f60001h;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    Context context = ((View) autoDisposable).getContext();
                    GemCollectionEntrypoint gemCollectionEntrypoint = null;
                    Class cls = GemOfferViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        GemOfferViewModel gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        GemCollectionScreen.GemCollectionData gemCollectionData = (GemCollectionScreen.GemCollectionData) gemCollectionActivity.getIntent().getParcelableExtra("navigatorData");
                        if (gemCollectionData != null) {
                            gemCollectionEntrypoint = gemCollectionData.getEntrypoint();
                        }
                        gemCollectionActivity.configureToolbar();
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$1(gemOfferViewModel, gemCollectionActivity));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$2(gemOfferViewModel, gemCollectionActivity));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$4(gemOfferViewModel, gemCollectionActivity));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$5(gemOfferViewModel, gemCollectionEntrypoint));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$6(gemCollectionActivity, gemOfferViewModel, gemCollectionEntrypoint));
                        gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$7(gemOfferViewModel, gemCollectionActivity));
                        RecyclerView recyclerView = (RecyclerView) gemCollectionActivity._$_findCachedViewById(R.id.restaurantsRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
                        ImpressionsIntegrationKt.trackImpressions(recyclerView, gemOfferViewModel.getRestaurants().getValue(), new GemCollectionActivity$initialize$1$8(gemCollectionEntrypoint));
                        GemCollectionActivity gemCollectionActivity = gemCollectionActivity;
                        ContextLifecycleEventsKt.withLifecycleEvents(gemCollectionActivity, new GemCollectionActivity$initialize$1$9(gemCollectionActivity));
                    } else if (context instanceof FragmentActivity) {
                        GemOfferViewModel gemOfferViewModel2 = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        GemCollectionScreen.GemCollectionData gemCollectionData2 = (GemCollectionScreen.GemCollectionData) gemCollectionActivity.getIntent().getParcelableExtra("navigatorData");
                        if (gemCollectionData2 != null) {
                            gemCollectionEntrypoint = gemCollectionData2.getEntrypoint();
                        }
                        gemCollectionActivity.configureToolbar();
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$1(gemOfferViewModel2, gemCollectionActivity));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$2(gemOfferViewModel2, gemCollectionActivity));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$3(gemOfferViewModel2));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$4(gemOfferViewModel2, gemCollectionActivity));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$5(gemOfferViewModel2, gemCollectionEntrypoint));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$6(gemCollectionActivity, gemOfferViewModel2, gemCollectionEntrypoint));
                        gemOfferViewModel2.autoDispose(new GemCollectionActivity$initialize$1$7(gemOfferViewModel2, gemCollectionActivity));
                        RecyclerView recyclerView2 = (RecyclerView) gemCollectionActivity._$_findCachedViewById(R.id.restaurantsRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(recyclerView2, "restaurantsRecyclerView");
                        ImpressionsIntegrationKt.trackImpressions(recyclerView2, gemOfferViewModel2.getRestaurants().getValue(), new GemCollectionActivity$initialize$1$8(gemCollectionEntrypoint));
                        GemCollectionActivity gemCollectionActivity2 = gemCollectionActivity;
                        ContextLifecycleEventsKt.withLifecycleEvents(gemCollectionActivity2, new GemCollectionActivity$initialize$1$9(gemCollectionActivity2));
                    } else if (context instanceof Fragment) {
                        GemOfferViewModel gemOfferViewModel3 = (GemOfferViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        GemCollectionScreen.GemCollectionData gemCollectionData3 = (GemCollectionScreen.GemCollectionData) gemCollectionActivity.getIntent().getParcelableExtra("navigatorData");
                        if (gemCollectionData3 != null) {
                            gemCollectionEntrypoint = gemCollectionData3.getEntrypoint();
                        }
                        gemCollectionActivity.configureToolbar();
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$1(gemOfferViewModel3, gemCollectionActivity));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$2(gemOfferViewModel3, gemCollectionActivity));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$3(gemOfferViewModel3));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$4(gemOfferViewModel3, gemCollectionActivity));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$5(gemOfferViewModel3, gemCollectionEntrypoint));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$6(gemCollectionActivity, gemOfferViewModel3, gemCollectionEntrypoint));
                        gemOfferViewModel3.autoDispose(new GemCollectionActivity$initialize$1$7(gemOfferViewModel3, gemCollectionActivity));
                        RecyclerView recyclerView3 = (RecyclerView) gemCollectionActivity._$_findCachedViewById(R.id.restaurantsRecyclerView);
                        Intrinsics.checkNotNullExpressionValue(recyclerView3, "restaurantsRecyclerView");
                        ImpressionsIntegrationKt.trackImpressions(recyclerView3, gemOfferViewModel3.getRestaurants().getValue(), new GemCollectionActivity$initialize$1$8(gemCollectionEntrypoint));
                        GemCollectionActivity gemCollectionActivity3 = gemCollectionActivity;
                        ContextLifecycleEventsKt.withLifecycleEvents(gemCollectionActivity3, new GemCollectionActivity$initialize$1$9(gemCollectionActivity3));
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final GemCollectionActivity gemCollectionActivity2 = this.f60001h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(GemOfferViewModel.class);
                    GemCollectionScreen.GemCollectionData gemCollectionData = (GemCollectionScreen.GemCollectionData) gemCollectionActivity2.getIntent().getParcelableExtra("navigatorData");
                    GemCollectionEntrypoint entrypoint = gemCollectionData != null ? gemCollectionData.getEntrypoint() : null;
                    gemCollectionActivity2.configureToolbar();
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$1(gemOfferViewModel, gemCollectionActivity2));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$2(gemOfferViewModel, gemCollectionActivity2));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$3(gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$4(gemOfferViewModel, gemCollectionActivity2));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$5(gemOfferViewModel, entrypoint));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$6(gemCollectionActivity2, gemOfferViewModel, entrypoint));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$7(gemOfferViewModel, gemCollectionActivity2));
                    RecyclerView recyclerView = (RecyclerView) gemCollectionActivity2._$_findCachedViewById(R.id.restaurantsRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
                    ImpressionsIntegrationKt.trackImpressions(recyclerView, gemOfferViewModel.getRestaurants().getValue(), new GemCollectionActivity$initialize$1$8(entrypoint));
                    GemCollectionActivity gemCollectionActivity = gemCollectionActivity2;
                    ContextLifecycleEventsKt.withLifecycleEvents(gemCollectionActivity, new GemCollectionActivity$initialize$1$9(gemCollectionActivity));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final GemCollectionActivity gemCollectionActivity3 = this.f60001h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(GemOfferViewModel.class);
                    GemCollectionScreen.GemCollectionData gemCollectionData = (GemCollectionScreen.GemCollectionData) gemCollectionActivity3.getIntent().getParcelableExtra("navigatorData");
                    GemCollectionEntrypoint entrypoint = gemCollectionData != null ? gemCollectionData.getEntrypoint() : null;
                    gemCollectionActivity3.configureToolbar();
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$1(gemOfferViewModel, gemCollectionActivity3));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$2(gemOfferViewModel, gemCollectionActivity3));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$3(gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$4(gemOfferViewModel, gemCollectionActivity3));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$5(gemOfferViewModel, entrypoint));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$6(gemCollectionActivity3, gemOfferViewModel, entrypoint));
                    gemOfferViewModel.autoDispose(new GemCollectionActivity$initialize$1$7(gemOfferViewModel, gemCollectionActivity3));
                    RecyclerView recyclerView = (RecyclerView) gemCollectionActivity3._$_findCachedViewById(R.id.restaurantsRecyclerView);
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "restaurantsRecyclerView");
                    ImpressionsIntegrationKt.trackImpressions(recyclerView, gemOfferViewModel.getRestaurants().getValue(), new GemCollectionActivity$initialize$1$8(entrypoint));
                    GemCollectionActivity gemCollectionActivity = gemCollectionActivity3;
                    ContextLifecycleEventsKt.withLifecycleEvents(gemCollectionActivity, new GemCollectionActivity$initialize$1$9(gemCollectionActivity));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
