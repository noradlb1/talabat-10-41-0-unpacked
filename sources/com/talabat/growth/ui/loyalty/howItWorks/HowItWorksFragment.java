package com.talabat.growth.ui.loyalty.howItWorks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBarWithActionButton;
import com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorImageRatio;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import com.integration.IntegrationAppTracker;
import com.talabat.feature.helpcenter.HelpCenterNavigator;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksDisplayModel;
import com.talabat.growth.ui.loyalty.howItWorks.viewModel.HowItWorksViewModel;
import com.talabat.growth.ui.loyalty.howItWorks.viewModel.HowItWorksViewModelBuilder;
import com.talabat.talabatcommon.views.titleViewMoreGridView.TitleViewMoreGridView;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/HowItWorksFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/howItWorks/viewModel/HowItWorksViewModel;", "()V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getDataFromServer", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "navigateToHelpCenter", "observatory", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populate", "setupUi", "updateHowItWorksTips", "howItWorksDisplayModel", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    private final void getDataFromServer() {
        HowItWorksViewModel.getGetHowItWorksTips$default((HowItWorksViewModel) getViewModel(), (String) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void navigateToHelpCenter() {
        PackageInfo packageInfo = requireContext().getPackageManager().getPackageInfo(requireContext().getPackageName(), 0);
        HelpCenterNavigator helpCenterNavigator = HelpCenterNavigator.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String str = packageInfo.versionName;
        Intrinsics.checkNotNullExpressionValue(str, "packageInfo.versionName");
        HelpCenterNavigator.navigateToHelpCenter$default(helpCenterNavigator, requireActivity, "rewards", str, (String) null, (String) null, 24, (Object) null);
    }

    private final void populate() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("TotalPoints", 0);
            Context context = getContext();
            if (context != null) {
                IntegrationAppTracker.Companion companion = IntegrationAppTracker.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.onRedeemPageOpen(context, "How to Earn Points Screen", String.valueOf(i11));
            }
        }
    }

    private final void setupUi() {
        int i11 = R.id.navBarHowItWork;
        ((DSNavigationBarWithActionButton) _$_findCachedViewById(i11)).setLeadingIconButton(new DSIconButtonModel(com.designsystem.marshmallow.R.drawable.ds_arrow_back, new HowItWorksFragment$setupUi$1(this)));
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.howItWorksBackButton);
        Intrinsics.checkNotNullExpressionValue(imageView, "howItWorksBackButton");
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(R.id.scroller);
        Intrinsics.checkNotNullExpressionValue(scrollView, "scroller");
        ((DSNavigationBarWithActionButton) _$_findCachedViewById(i11)).setAnimationBehavior(new DSNavigationBarAnimationBehaviorImageRatio(imageView, scrollView));
        String string = getString(com.talabat.localization.R.string.loyalty_get_help);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.loyalty_get_help)");
        ((DSNavigationBarWithActionButton) _$_findCachedViewById(i11)).setActionButton(new DSNavigationBarActionButtonModel(string, new HowItWorksFragment$setupUi$2(this)));
    }

    /* access modifiers changed from: private */
    public final void updateHowItWorksTips(HowItWorksDisplayModel howItWorksDisplayModel) {
        if (howItWorksDisplayModel != null) {
            TitleViewMoreGridView titleViewMoreGridView = (TitleViewMoreGridView) _$_findCachedViewById(R.id.howItWorksTitleViewMoreGridView);
            Intrinsics.checkNotNullExpressionValue(titleViewMoreGridView, "howItWorksTitleViewMoreGridView");
            TitleViewMoreGridView.setAdapter$default(titleViewMoreGridView, new HowItWorksListAdaptor(howItWorksDisplayModel.getInstructions()), 1, (RecyclerView.ItemDecoration) null, 4, (Object) null);
        }
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

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public Class<HowItWorksViewModel> getViewModelClass() {
        return HowItWorksViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_loyalty_how_it_works;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((HowItWorksViewModel) getViewModel()).getHowItWorksTipsData(), new HowItWorksFragment$observatory$1(this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupUi();
        populate();
        getDataFromServer();
    }

    @NotNull
    public HowItWorksViewModel viewModelBuilder() {
        HowItWorksViewModelBuilder.Companion companion = HowItWorksViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getHowItWorksViewModel(requireContext, getCoroutineScope());
    }
}
