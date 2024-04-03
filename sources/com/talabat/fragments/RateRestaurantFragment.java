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
import androidx.fragment.app.FragmentActivity;
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
import com.talabat.di.raterestaurant.DaggerRateRestaurantFragmentComponent;
import com.talabat.rating.presentation.viewmodel.RateVendorViewModel;
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
import mq.q;
import mq.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0018H\u0002J\u001a\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0006J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, d2 = {"Lcom/talabat/fragments/RateRestaurantFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/talabat/adapters/RateReasonsAdapter;", "ratingFragmentCallbacksListener", "Lcom/talabat/adapters/RatePagerAdapter$RatingFragmentCallbacksListener;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "vendorReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/talabat/rating/presentation/viewmodel/RateVendorViewModel;", "getViewModel", "()Lcom/talabat/rating/presentation/viewmodel/RateVendorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getRating", "", "getSelectedReasons", "hideSmileyRatingView", "", "hideStarRatingView", "initialize", "inject", "observeRatingViewChanges", "ratingParadigm", "Lcom/talabat/rating/presentation/viewstate/RatingParadigm;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRatingChange", "rating", "onViewCreated", "view", "setCallbackListener", "listener", "showReasons", "", "showSmileyRatingView", "showStarRatingView", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateRestaurantFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ID = "id";
    @NotNull
    private static final String NAME = "name";
    @NotNull
    private static final String RATE = "rate";
    @NotNull
    private static final String REASONS = "reasons";
    @NotNull
    private static final String SHOW_REASONS = "showReasons";
    @NotNull
    private static final String VENDOR_EXPERIENCE_RATING_TITLE = "vendorExperienceRatingTitle";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private RateReasonsAdapter adapter;
    private RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    private ArrayList<RateReason> vendorReasons;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new RateRestaurantFragment$viewModel$2(this));

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/fragments/RateRestaurantFragment$Companion;", "", "()V", "ID", "", "NAME", "RATE", "REASONS", "SHOW_REASONS", "VENDOR_EXPERIENCE_RATING_TITLE", "getInstance", "Lcom/talabat/fragments/RateRestaurantFragment;", "restaurantName", "restaurantId", "", "rate", "", "vendorRateReasons", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "vendorExperienceRatingTitle", "showReasons", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RateRestaurantFragment getInstance(@NotNull String str, int i11, float f11, @NotNull ArrayList<RateReason> arrayList, @NotNull String str2, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "restaurantName");
            Intrinsics.checkNotNullParameter(arrayList, "vendorRateReasons");
            Intrinsics.checkNotNullParameter(str2, "vendorExperienceRatingTitle");
            RateRestaurantFragment rateRestaurantFragment = new RateRestaurantFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", str);
            bundle.putInt("id", i11);
            bundle.putFloat("rate", f11);
            bundle.putParcelableArrayList(RateRestaurantFragment.REASONS, arrayList);
            bundle.putString("vendorExperienceRatingTitle", str2);
            bundle.putBoolean("showReasons", z11);
            rateRestaurantFragment.setArguments(bundle);
            return rateRestaurantFragment;
        }
    }

    private final RateVendorViewModel getViewModel() {
        return (RateVendorViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideSmileyRatingView() {
        ((TalabatSmileyRating) _$_findCachedViewById(R.id.rating_smiley)).setVisibility(8);
    }

    private final void hideStarRatingView() {
        ((TalabatStarRating) _$_findCachedViewById(R.id.rating_star)).setVisibility(8);
    }

    private final void initialize() {
        ArrayList<RateReason> arrayList;
        String str;
        boolean z11;
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList(REASONS);
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.vendorReasons = arrayList;
        int i11 = R.id.reasonsRecyclerView;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getActivity()));
        FragmentActivity activity = getActivity();
        ArrayList<RateReason> arrayList2 = this.vendorReasons;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vendorReasons");
            arrayList2 = null;
        }
        this.adapter = new RateReasonsAdapter(activity, arrayList2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        RateReasonsAdapter rateReasonsAdapter = this.adapter;
        if (rateReasonsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rateReasonsAdapter = null;
        }
        recyclerView.setAdapter(rateReasonsAdapter);
        ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(8);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("vendorExperienceRatingTitle", "");
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((TalabatTextView) _$_findCachedViewById(R.id.vendorExperienceRatingTitleTv)).setText(getString(R.string.how_was_the_order_from));
            int i12 = R.id.vendorNameTv;
            ((TalabatTextView) _$_findCachedViewById(i12)).setVisibility(0);
            TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(i12);
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str2 = arguments3.getString("name");
            }
            talabatTextView.setText(str2);
        } else {
            ((TalabatTextView) _$_findCachedViewById(R.id.vendorExperienceRatingTitleTv)).setText(str);
            ((TalabatTextView) _$_findCachedViewById(R.id.vendorNameTv)).setVisibility(8);
        }
        getViewModel().getRatingViewLiveData().observe(getViewLifecycleOwner(), new q(this));
    }

    private final void inject() {
        DaggerRateRestaurantFragmentComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
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
        if (!showReasons()) {
            ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(8);
        } else if (i11 <= 3) {
            ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(0);
        } else {
            ((LinearLayout) _$_findCachedViewById(R.id.reasonsContainer)).setVisibility(8);
        }
        RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = this.ratingFragmentCallbacksListener;
        if (ratingFragmentCallbacksListener2 != null) {
            if (ratingFragmentCallbacksListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingFragmentCallbacksListener");
                ratingFragmentCallbacksListener2 = null;
            }
            ratingFragmentCallbacksListener2.showContinueContainer();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10495onViewCreated$lambda0(RateRestaurantFragment rateRestaurantFragment, View view) {
        Intrinsics.checkNotNullParameter(rateRestaurantFragment, "this$0");
        RatePagerAdapter.RatingFragmentCallbacksListener ratingFragmentCallbacksListener2 = rateRestaurantFragment.ratingFragmentCallbacksListener;
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
        ((TalabatStarRating) _$_findCachedViewById(R.id.rating_star)).setVisibility(8);
        int i11 = R.id.rating_smiley;
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setVisibility(0);
        Bundle arguments = getArguments();
        if (arguments != null) {
            number = Float.valueOf(arguments.getFloat("rate"));
        } else {
            number = 0;
        }
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setRating(number.intValue());
        ((TalabatSmileyRating) _$_findCachedViewById(i11)).setOnRatingChangedListener(new RateRestaurantFragment$showSmileyRatingView$1(this));
    }

    private final void showStarRatingView() {
        Number number;
        int i11 = R.id.rating_star;
        ((TalabatStarRating) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatSmileyRating) _$_findCachedViewById(R.id.rating_smiley)).setVisibility(8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            number = Float.valueOf(arguments.getFloat("rate"));
        } else {
            number = 0;
        }
        ((TalabatStarRating) _$_findCachedViewById(i11)).setRating(number.intValue());
        ((TalabatStarRating) _$_findCachedViewById(i11)).setOnRatingChangedListener(new RateRestaurantFragment$showStarRatingView$1(this));
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

    public final int getRating() {
        return getViewModel().getRating(new RateRestaurantFragment$getRating$1(this), new RateRestaurantFragment$getRating$2(this));
    }

    @NotNull
    public final ArrayList<RateReason> getSelectedReasons() {
        RateReasonsAdapter rateReasonsAdapter = this.adapter;
        if (rateReasonsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            rateReasonsAdapter = null;
        }
        ArrayList<RateReason> checkedRateReasons = rateReasonsAdapter.getCheckedRateReasons();
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

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RateRestaurantFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RateRestaurantFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_rate_restaurant, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(\n…iner,\n        false\n    )");
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
        ((ImageView) _$_findCachedViewById(R.id.btn_rating_close)).setOnClickListener(new r(this));
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
