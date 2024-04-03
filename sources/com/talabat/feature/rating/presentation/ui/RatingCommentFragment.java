package com.talabat.feature.rating.presentation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentKt;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_input_field.DSTextAreaField;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.rating.presentation.R;
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
import xn.a;
import xn.b;
import xn.c;
import xn.d;

@Instrumented
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/rating/presentation/ui/RatingCommentFragment;", "Landroidx/fragment/app/Fragment;", "()V", "ratingFeedBackViewModel", "Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "getRatingFeedBackViewModel", "()Lcom/talabat/feature/rating/presentation/ui/RatingFeedBackViewModel;", "ratingFeedBackViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "com_talabat_feature_rating_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingCommentFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy ratingFeedBackViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RatingFeedBackViewModel.class), new RatingCommentFragment$special$$inlined$activityViewModels$default$1(this), new RatingCommentFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new RatingCommentFragment$special$$inlined$activityViewModels$default$3(this));

    /* access modifiers changed from: private */
    public final RatingFeedBackViewModel getRatingFeedBackViewModel() {
        return (RatingFeedBackViewModel) this.ratingFeedBackViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10259onViewCreated$lambda0(RatingCommentFragment ratingCommentFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingCommentFragment, "this$0");
        FragmentKt.findNavController(ratingCommentFragment).popBackStack();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m10260onViewCreated$lambda1(String str, RatingCommentFragment ratingCommentFragment, View view) {
        Intrinsics.checkNotNullParameter(ratingCommentFragment, "this$0");
        if (StringsKt__StringsJVMKt.equals$default(str, RatingReasonFragmentKt.ARGUMENT_NAME_FOOD, false, 2, (Object) null)) {
            FragmentKt.findNavController(ratingCommentFragment).navigate(R.id.action_ratingCommentFragment_to_ratingDeliveryFragment);
        } else {
            ratingCommentFragment.getRatingFeedBackViewModel().submitRating();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m10261onViewCreated$lambda2(RatingCommentFragment ratingCommentFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(ratingCommentFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "ratingSuccess");
        if (bool.booleanValue() && ratingCommentFragment.getActivity() != null && ratingCommentFragment.getView() != null) {
            ratingCommentFragment.getRatingFeedBackViewModel().onRatingSubmitted("COMMENT_SCREEN");
            View requireView = ratingCommentFragment.requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
            NavControllerExtensionKt.navigateSafe$default(Navigation.findNavController(requireView), R.id.action_ratingCommentFragment_to_ratingSuccessFragment, (Bundle) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m10262onViewCreated$lambda3(RatingCommentFragment ratingCommentFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(ratingCommentFragment, "this$0");
        ratingCommentFragment.getRatingFeedBackViewModel().onRatingSubmitError("COMMENT_SCREEN");
        ratingCommentFragment.requireActivity().finish();
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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "RatingCommentFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RatingCommentFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.cloneInContext(requireContext()).inflate(R.layout.fragment_rating_comment, (ViewGroup) null, false);
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
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(RatingReasonFragmentKt.ARGUMENT_SCREEN_TYPE);
        } else {
            str = null;
        }
        if (StringsKt__StringsJVMKt.equals$default(str, RatingReasonFragmentKt.ARGUMENT_NAME_FOOD, false, 2, (Object) null)) {
            String string = getString(com.talabat.localization.R.string.next);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.localization.R.string.next)");
            ((DSPrimaryButton) _$_findCachedViewById(R.id.buttonContinue)).setCenterText(string);
        } else {
            String string2 = getString(com.talabat.localization.R.string.submit);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…lization.R.string.submit)");
            ((DSPrimaryButton) _$_findCachedViewById(R.id.buttonContinue)).setCenterText(string2);
        }
        ((ImageView) _$_findCachedViewById(R.id.arrowBack)).setOnClickListener(new a(this));
        int i11 = R.id.editRatingComment;
        ((DSTextAreaField) _$_findCachedViewById(i11)).setText(getRatingFeedBackViewModel().getRatingComment());
        ((DSTextAreaField) _$_findCachedViewById(i11)).setOnTextChange(new RatingCommentFragment$onViewCreated$2(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.buttonContinue)).setOnClickListener(new b(str, this));
        getRatingFeedBackViewModel().isRatingSuccess().observe(requireActivity(), new c(this));
        getRatingFeedBackViewModel().isRatingError().observe(getViewLifecycleOwner(), new d(this));
    }
}
