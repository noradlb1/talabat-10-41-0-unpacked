package com.talabat.fragments;

import JsonModels.Response.rateOrders.RateReason;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.RatePagerAdapter;
import com.talabat.adapters.RateReasonsAdapter;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.ratedelivery.DaggerRateDeliveryFragmentComponent;
import com.talabat.rating.presentation.viewmodel.RateDeliveryViewModel;
import com.talabat.rating.presentation.viewstate.RatingParadigm;
import com.talabat.talabatcommon.views.TalabatSmileyRating;
import com.talabat.talabatcommon.views.TalabatStarRating;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.j;
import mq.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u00108\u001a\u00020!2\u0006\u00109\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0011J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020!H\u0002J\b\u0010>\u001a\u00020!H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001b¨\u0006@"}, d2 = {"Lcom/talabat/fragments/RateDeliveryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/talabat/adapters/RateReasonsAdapter;", "getAdapter", "()Lcom/talabat/adapters/RateReasonsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "deliveryReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "getDeliveryReasons", "()Ljava/util/ArrayList;", "deliveryReasons$delegate", "ratingFragmentCallbacksListener", "Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "viewModel", "Lcom/talabat/rating/presentation/viewmodel/RateDeliveryViewModel;", "getViewModel", "()Lcom/talabat/rating/presentation/viewmodel/RateDeliveryViewModel;", "viewModel$delegate", "getRate", "", "getSelectedReasons", "hideSmileyRatingView", "", "hideStarRatingView", "initialize", "inject", "isLessThan3", "", "rating", "", "observeRatingViewChanges", "ratingParadigm", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRatingChange", "onViewCreated", "view", "setCallbackListener", "listener", "showReasons", "showSmileyRatingView", "showStarRatingView", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateDeliveryFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DELIVERY_EXPERIENCE_RATING_TITLE = "deliveryExperienceRatingTitle";
    @NotNull
    private static final String RATE = "rate";
    @NotNull
    private static final String REASONS = "reasons";
    @NotNull
    private static final String SHOW_REASONS = "showReasons";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy adapter$delegate;
    @NotNull
    private final Lazy deliveryReasons$delegate;
    private RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/fragments/RateDeliveryFragment$Companion;", "", "()V", "DELIVERY_EXPERIENCE_RATING_TITLE", "", "RATE", "REASONS", "SHOW_REASONS", "getInstance", "Lcom/talabat/fragments/RateDeliveryFragment;", "deliveryRateReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "deliveryExperienceRatingTitle", "showReasons", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RateDeliveryFragment getInstance(@NotNull ArrayList<RateReason> arrayList, @NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(arrayList, "deliveryRateReasons");
            Intrinsics.checkNotNullParameter(str, "deliveryExperienceRatingTitle");
            RateDeliveryFragment rateDeliveryFragment = new RateDeliveryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(RateDeliveryFragment.REASONS, arrayList);
            bundle.putString("deliveryExperienceRatingTitle", str);
            bundle.putBoolean("showReasons", z11);
            rateDeliveryFragment.setArguments(bundle);
            return rateDeliveryFragment;
        }
    }

    public RateDeliveryFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.deliveryReasons$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RateDeliveryFragment$deliveryReasons$2(this));
        this.adapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RateDeliveryFragment$adapter$2(this));
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RateDeliveryFragment$viewModel$2(this));
    }

    private final RateReasonsAdapter getAdapter() {
        return (RateReasonsAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ArrayList<RateReason> getDeliveryReasons() {
        return (ArrayList) this.deliveryReasons$delegate.getValue();
    }

    private final RateDeliveryViewModel getViewModel() {
        return (RateDeliveryViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideSmileyRatingView() {
        ((TalabatSmileyRating) _$_findCachedViewById(R.id.rating_smiley)).setVisibility(8);
    }

    private final void hideStarRatingView() {
        ((TalabatStarRating) _$_findCachedViewById(R.id.rating_star)).setVisibility(8);
    }

    private final void initialize() {
        String str;
        boolean z11;
        int i11 = R.id.reasonsRecyclerView;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getActivity()));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getAdapter());
        ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("deliveryExperienceRatingTitle", "");
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((TalabatTextView) _$_findCachedViewById(R.id.deliveryExperienceRatingTitleTv)).setText(getString(R.string.how_was_the_delivery_experience));
        } else {
            ((TalabatTextView) _$_findCachedViewById(R.id.deliveryExperienceRatingTitleTv)).setText(str);
        }
        getViewModel().getRatingViewLiveData().observe(getViewLifecycleOwner(), new k(this));
    }

    private final void inject() {
        DaggerRateDeliveryFragmentComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private final boolean isLessThan3(int i11) {
        return i11 <= 3;
    }

    /* access modifiers changed from: private */
    public final void observeRatingViewChanges(RatingParadigm ratingParadigm) {
        if (Intrinsics.areEqual((Object) ratingParadigm, (Object) RatingParadigm.Smiley.INSTANCE)) {
            showSmileyRatingView();
            hideStarRatingView();
        } else if (Intrinsics.areEqual((Object) ratingParadigm, (Object) RatingParadigm.Star.INSTANCE)) {
            showStarRatingView();
            hideSmileyRatingView();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void onRatingChange(int i11) {
        int i12 = 8;
        if (showReasons()) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.reasonsContainer);
            if (isLessThan3(i11)) {
                i12 = 0;
            }
            linearLayout.setVisibility(i12);
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(8);
        }
        RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = this.ratingFragmentCallbacksListener;
        if (ratingFragmentCallbacksListener2 != null) {
            if (ratingFragmentCallbacksListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingFragmentCallbacksListener");
                ratingFragmentCallbacksListener2 = null;
            }
            ratingFragmentCallbacksListener2.enableContinueButton();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10489onViewCreated$lambda0(RateDeliveryFragment rateDeliveryFragment, View view) {
        Intrinsics.checkNotNullParameter(rateDeliveryFragment, "this$0");
        RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = rateDeliveryFragment.ratingFragmentCallbacksListener;
        if (ratingFragmentCallbacksListener2 != null) {
            if (ratingFragmentCallbacksListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingFragmentCallbacksListener");
                ratingFragmentCallbacksListener2 = null;
            }
            ratingFragmentCallbacksListener2.onCloseClicked();
        }
    }

    private final boolean showReasons() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean("showReasons");
        }
        return false;
    }

    private final void showSmileyRatingView() {
        Number number;
        Bundle arguments = getArguments();
        if (arguments != null) {
            number = Float.valueOf(arguments.getFloat("rate"));
        } else {
            number = 0;
        }
        int i11 = R.id.rating_smiley;
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setRating(number.intValue());
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setOnRatingChangedListener(new RateDeliveryFragment$showSmileyRatingView$1(this));
    }

    private final void showStarRatingView() {
        Number number;
        Bundle arguments = getArguments();
        if (arguments != null) {
            number = Float.valueOf(arguments.getFloat("rate"));
        } else {
            number = 0;
        }
        int i11 = R.id.rating_star;
        ((TalabatStarRating) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatStarRating) _$_findCachedViewById(i11)).setRating(number.intValue());
        ((TalabatStarRating) _$_findCachedViewById(i11)).setOnRatingChangedListener(new RateDeliveryFragment$showStarRatingView$1(this));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final float getRate() {
        return (float) getViewModel().getRating(new RateDeliveryFragment$getRate$1(this), new RateDeliveryFragment$getRate$2(this));
    }

    @NotNull
    public final ArrayList<RateReason> getSelectedReasons() {
        ArrayList<RateReason> checkedRateReasons = getAdapter().getCheckedRateReasons();
        Intrinsics.checkNotNullExpressionValue(checkedRateReasons, "adapter.checkedRateReasons");
        return checkedRateReasons;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        inject();
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RateDeliveryFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RateDeliveryFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_rate_delivery, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initialize();
        getViewModel().onAttach();
        ((ImageView) _$_findCachedViewById(R.id.btn_rating_close)).setOnClickListener(new j(this));
    }

    public final void setCallbackListener(@NotNull RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2) {
        Intrinsics.checkNotNullParameter(ratingFragmentCallbacksListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.ratingFragmentCallbacksListener = ratingFragmentCallbacksListener2;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
