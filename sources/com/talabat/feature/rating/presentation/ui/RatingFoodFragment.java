package com.talabat.feature.rating.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.rating.presentation.R;
import com.talabat.talabatcommon.views.TalabatStarRating;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xn.k;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingFoodFragment;", "Landroidx/fragment/app/Fragment;", "()V", "ratingFeedBackViewModel", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "getRatingFeedBackViewModel", "()Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "ratingFeedBackViewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRatingChange", "onViewCreated", "view", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingFoodFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy ratingFeedBackViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RatingFeedBackViewModel.class), new RatingFoodFragment$special$$inlined$activityViewModels$default$1(this), new RatingFoodFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new RatingFoodFragment$special$$inlined$activityViewModels$default$3(this));

    /* access modifiers changed from: private */
    public final RatingFeedBackViewModel getRatingFeedBackViewModel() {
        return (RatingFeedBackViewModel) this.ratingFeedBackViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void onRatingChange() {
        NavControllerExtensionKt.navigateSafe$default(FragmentKt.findNavController(this), R.id.action_ratingFoodFragment_to_ratingReasonFragment, (Bundle) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10269onViewCreated$lambda0(RatingFoodFragment ratingFoodFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingFoodFragment, "this$0");
        ratingFoodFragment.getRatingFeedBackViewModel().onRatingClose("FOOD_SCREEN");
        ratingFoodFragment.requireActivity().finish();
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new RatingFoodFragment$onAttach$callback$1());
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RatingFoodFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RatingFoodFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.cloneInContext(requireContext()).inflate(R.layout.fragment_rating_food, (ViewGroup) null, false);
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
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        String vendorLogoUrl = getRatingFeedBackViewModel().getVendorLogoUrl();
        if (vendorLogoUrl == null || vendorLogoUrl.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            Glide.with((Fragment) this).load(vendorLogoUrl).into((ImageView) _$_findCachedViewById(R.id.ivVendorIcon));
        }
        ((ImageView) _$_findCachedViewById(R.id.buttonFoodRatingClose)).setOnClickListener(new k(this));
        TalabatStarRating talabatStarRating = (TalabatStarRating) _$_findCachedViewById(R.id.rbFoodRatings);
        if (talabatStarRating != null) {
            talabatStarRating.setOnRatingChangedListener(new RatingFoodFragment$onViewCreated$2(this));
        }
        ((TextView) _$_findCachedViewById(R.id.tvVendorExperienceRatingTitle)).setText(getRatingFeedBackViewModel().getVendorTitle());
        getRatingFeedBackViewModel().onRatingLoaded("FOOD_SCREEN");
    }
}
