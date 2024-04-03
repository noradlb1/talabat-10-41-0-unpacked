package com.talabat.talabatcommon.feature.pickupToggle.presentation;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.localization.R;
import com.talabat.talabatcommon.feature.pickupToggle.domain.ShowTabBarUseCase;
import com.talabat.talabatcommon.views.tabBarWithTag.OriginalTabBarBinder;
import com.talabat.talabatcommon.views.tabBarWithTag.RevampTabBarBinder;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import com.talabat.talabatcommon.views.tabBarWithTag.TabItemModel;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!BM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/presentation/OrderModeTabBar;", "Lio/reactivex/functions/BiConsumer;", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView;", "Landroid/content/Context;", "showTabBarUseCase", "Lcom/talabat/talabatcommon/feature/pickupToggle/domain/ShowTabBarUseCase;", "caller", "", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "tagPercentage", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "countryId", "deeplinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/talabatcommon/feature/pickupToggle/domain/ShowTabBarUseCase;ILcom/talabat/core/tracking/domain/TalabatTracker;ILcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/navigation/domain/Navigator;ILcom/talabat/core/deeplink/domain/DeepLinkNavigator;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getCaller", "()I", "accept", "", "tabBar", "context", "orderModeTabs", "", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemModel;", "activity", "pickupClicked", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderModeTabBar implements BiConsumer<TabBarWithTagView, Context> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DELIVERY_MODE_INDEX = 0;
    public static final int PICKUP_MODE_INDEX = 1;
    private final int caller;
    /* access modifiers changed from: private */
    public final int countryId;
    /* access modifiers changed from: private */
    @NotNull
    public final DeepLinkNavigator deeplinkNavigator;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag featureFlag;
    /* access modifiers changed from: private */
    @NotNull
    public final Navigator navigator;
    @NotNull
    private final ShowTabBarUseCase showTabBarUseCase;
    private final int tagPercentage;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker tracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/presentation/OrderModeTabBar$Companion;", "", "()V", "DELIVERY_MODE_INDEX", "", "PICKUP_MODE_INDEX", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderModeTabBar(@NotNull ShowTabBarUseCase showTabBarUseCase2, int i11, @NotNull TalabatTracker talabatTracker, int i12, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull Navigator navigator2, int i13, @NotNull DeepLinkNavigator deepLinkNavigator, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(showTabBarUseCase2, "showTabBarUseCase");
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "deeplinkNavigator");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.showTabBarUseCase = showTabBarUseCase2;
        this.caller = i11;
        this.tracker = talabatTracker;
        this.tagPercentage = i12;
        this.talabatExperiment = iTalabatExperiment;
        this.navigator = navigator2;
        this.countryId = i13;
        this.deeplinkNavigator = deepLinkNavigator;
        this.featureFlag = iTalabatFeatureFlag;
    }

    private final List<TabItemModel> orderModeTabs(Context context) {
        boolean isRevampedTabBar = this.showTabBarUseCase.isRevampedTabBar();
        boolean isRevampedTabBarWithIcon = this.showTabBarUseCase.isRevampedTabBarWithIcon();
        String string = context.getString(R.string.delivery_tab_bar_text);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t…ng.delivery_tab_bar_text)");
        boolean z11 = isRevampedTabBar;
        boolean z12 = isRevampedTabBarWithIcon;
        String string2 = context.getString(R.string.pickup_tab_bar_text);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t…ring.pickup_tab_bar_text)");
        return CollectionsKt__CollectionsKt.listOf(new TabItemModel(0, string, false, 0, z11, z12, 12, (DefaultConstructorMarker) null), new TabItemModel(1, string2, true, this.tagPercentage, z11, z12));
    }

    /* access modifiers changed from: private */
    public final boolean pickupClicked(int i11) {
        return i11 == 1;
    }

    public final int getCaller() {
        return this.caller;
    }

    public void accept(@NotNull TabBarWithTagView tabBarWithTagView, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(tabBarWithTagView, "tabBar");
        Intrinsics.checkNotNullParameter(context, "context");
        tabBarWithTagView.setViewBinder(this.showTabBarUseCase.isRevampedTabBar() ? new RevampTabBarBinder() : new OriginalTabBarBinder());
        tabBarWithTagView.setTabs(orderModeTabs(context));
        tabBarWithTagView.setVisibility(this.showTabBarUseCase.shouldShowTabBar() ? 0 : 8);
        TabBarWithTagView.selectTab$default(tabBarWithTagView, this.caller, false, 2, (Object) null);
        tabBarWithTagView.setOnTabSelected(new OrderModeTabBar$accept$1(this, context));
    }
}
