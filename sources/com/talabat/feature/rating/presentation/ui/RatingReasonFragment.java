package com.talabat.feature.rating.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.designsystem.ds_button.DSPrimaryButton;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.rating.domain.model.RatingReasonsData;
import com.talabat.feature.rating.presentation.R;
import com.talabat.talabatcommon.views.TalabatStarRating;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xn.l;
import xn.m;
import xn.n;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingReasonFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/feature/rating/presentation/ui/RatingReasonClickListener;", "()V", "ratingFeedBackViewModel", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "getRatingFeedBackViewModel", "()Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "ratingFeedBackViewModel$delegate", "Lkotlin/Lazy;", "ratingReasonAdapter", "Lcom/talabat/feature/rating/presentation/ui/RatingReasonsAdapter;", "getRatingReasonAdapter", "()Lcom/talabat/feature/rating/presentation/ui/RatingReasonsAdapter;", "setRatingReasonAdapter", "(Lcom/talabat/feature/rating/presentation/ui/RatingReasonsAdapter;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRatingReasonClick", "position", "", "ratingReasonsData", "Lcom/talabat/feature/rating/domain/model/RatingReasonsData;", "onViewCreated", "view", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingReasonFragment extends Fragment implements RatingReasonClickListener, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy ratingFeedBackViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RatingFeedBackViewModel.class), new RatingReasonFragment$special$$inlined$activityViewModels$default$1(this), new RatingReasonFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new RatingReasonFragment$special$$inlined$activityViewModels$default$3(this));
    public RatingReasonsAdapter ratingReasonAdapter;

    /* access modifiers changed from: private */
    public final RatingFeedBackViewModel getRatingFeedBackViewModel() {
        return (RatingFeedBackViewModel) this.ratingFeedBackViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m10270onViewCreated$lambda2(RatingReasonFragment ratingReasonFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingReasonFragment, "this$0");
        ratingReasonFragment.getRatingFeedBackViewModel().onRatingClose("FOOD_REASON_SCREEN");
        ratingReasonFragment.requireActivity().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m10271onViewCreated$lambda3(RatingReasonFragment ratingReasonFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingReasonFragment, "this$0");
        FragmentKt.findNavController(ratingReasonFragment).navigate(R.id.action_ratingReasonFragment_to_ratingDeliveryFragment);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m10272onViewCreated$lambda4(RatingReasonFragment ratingReasonFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingReasonFragment, "this$0");
        FragmentKt.findNavController(ratingReasonFragment).navigate(R.id.action_ratingReasonFragment_to_ratingCommentFragment, BundleKt.bundleOf(TuplesKt.to(RatingReasonFragmentKt.ARGUMENT_SCREEN_TYPE, RatingReasonFragmentKt.ARGUMENT_NAME_FOOD)));
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

    @NotNull
    public final RatingReasonsAdapter getRatingReasonAdapter() {
        RatingReasonsAdapter ratingReasonsAdapter = this.ratingReasonAdapter;
        if (ratingReasonsAdapter != null) {
            return ratingReasonsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ratingReasonAdapter");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new RatingReasonFragment$onAttach$callback$1());
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RatingReasonFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RatingReasonFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.cloneInContext(requireContext()).inflate(R.layout.fragment_rating_reasons, (ViewGroup) null, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRatingReasonClick(int i11, @NotNull RatingReasonsData ratingReasonsData) {
        Intrinsics.checkNotNullParameter(ratingReasonsData, "ratingReasonsData");
        getRatingFeedBackViewModel().updateVendorReasonsInRateOrderRequest(ratingReasonsData);
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
        setRatingReasonAdapter(new RatingReasonsAdapter(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.reasonRatingList);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
        flexboxLayoutManager.setJustifyContent(2);
        flexboxLayoutManager.setAlignItems(2);
        boolean z11 = false;
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(getRatingReasonAdapter());
        getRatingReasonAdapter().submitList(getRatingFeedBackViewModel().getVendorReasonList(getRatingFeedBackViewModel().getSelectedFoodRating()));
        int i11 = R.id.rbReasons;
        ((TalabatStarRating) _$_findCachedViewById(i11)).setOnRatingChangedListener(new RatingReasonFragment$onViewCreated$2(this));
        ((TalabatStarRating) _$_findCachedViewById(i11)).setRating(getRatingFeedBackViewModel().getSelectedFoodRating());
        ((ImageView) _$_findCachedViewById(R.id.buttonRatingClose)).setOnClickListener(new l(this));
        String vendorLogoUrl = getRatingFeedBackViewModel().getVendorLogoUrl();
        if (vendorLogoUrl == null || vendorLogoUrl.length() == 0) {
            z11 = true;
        }
        if (!z11) {
            Glide.with((Fragment) this).load(vendorLogoUrl).into((ImageView) _$_findCachedViewById(R.id.ivVendorIcon));
        }
        ((DSPrimaryButton) _$_findCachedViewById(R.id.buttonRatingNext)).setOnClickListener(new m(this));
        ((TextView) view.findViewById(R.id.tvReasonRatingComment)).setOnClickListener(new n(this));
    }

    public final void setRatingReasonAdapter(@NotNull RatingReasonsAdapter ratingReasonsAdapter) {
        Intrinsics.checkNotNullParameter(ratingReasonsAdapter, "<set-?>");
        this.ratingReasonAdapter = ratingReasonsAdapter;
    }
}
