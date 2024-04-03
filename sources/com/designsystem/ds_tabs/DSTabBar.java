package com.designsystem.ds_tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import com.designsystem.extensions.AnimationExtensionsKt;
import com.designsystem.extensions.ContextExtensionsKt;
import com.designsystem.extensions.TabLayoutExtensionsKt;
import com.designsystem.marshmallow.R;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.tabs.TabLayout;
import com.huawei.hms.flutter.map.constants.Param;
import g6.a;
import g6.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0003YZ[B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\"H\u0002J \u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020?H\u0016J*\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\u00102\u0006\u00109\u001a\u00020\"H\u0002J\u001a\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010K\u001a\n M*\u0004\u0018\u00010L0L2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010N\u001a\u00020\u0007J\u0018\u0010O\u001a\u00020#2\u0006\u0010=\u001a\u00020\u00072\b\b\u0002\u0010P\u001a\u00020\u0018J\u0010\u0010Q\u001a\u00020#2\u0006\u00103\u001a\u000202H\u0002J\b\u0010R\u001a\u00020#H\u0002J\"\u0010S\u001a\u00020#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0*2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010U\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u0018H\u0002J\u001a\u0010V\u001a\u00020#2\u0006\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010\u0010H\u0002J\f\u0010W\u001a\u00020\"*\u00020XH\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R0\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0*2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0*8F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"01X\u0004¢\u0006\u0002\n\u0000R$\u00103\u001a\u0002022\u0006\u0010)\u001a\u000202@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006\\"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callbacks", "Lcom/designsystem/ds_tabs/DSTabBarCallbacks;", "getCallbacks", "()Lcom/designsystem/ds_tabs/DSTabBarCallbacks;", "setCallbacks", "(Lcom/designsystem/ds_tabs/DSTabBarCallbacks;)V", "currentSelectedTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "isMaxTabsNumber", "", "()Z", "menuTitle", "", "getMenuTitle", "()Ljava/lang/String;", "setMenuTitle", "(Ljava/lang/String;)V", "onTabSelected", "Lkotlin/Function1;", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "shouldTriggerTabSelectionCallback", "value", "", "tabs", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "tabsModelMap", "", "Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "type", "getType", "()Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "setType", "(Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;)V", "addTabFromItemModel", "itemModel", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "animateSelectionIndicator", "tab", "isSelected", "animationDirection", "Lcom/designsystem/ds_tabs/DSTabBar$AnimationDirection;", "animationStartOffset", "", "createCustomTab", "getAnimationDirection", "selectedTab", "unselectedTab", "getScaleAnimation", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "getSelectedTabIndex", "selectTab", "triggerSelectionCallback", "setTabBarType", "setupListeners", "showMenuBottomSheetDialog", "title", "updateTabTextColor", "updateTabsSelection", "toDSTabItemModel", "Lcom/designsystem/ds_tabs/DSTabItem;", "AnimationDirection", "Companion", "DSTabBarType", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTabBar extends LinearLayout {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long TAB_BAR_ANIMATION_OFFSET = 150;
    private static final long TAB_BAR_DEFAULT_ANIMATION_OFFSET = 0;
    private static final double TAB_BAR_MENU_HEIGHT_RATIO = 0.7d;
    private static final int TAB_BAR_TABS_LIMIT = 4;
    @Nullable
    private DSTabBarCallbacks callbacks;
    /* access modifiers changed from: private */
    @Nullable
    public TabLayout.Tab currentSelectedTab;
    @Nullable
    private FragmentManager fragmentManager;
    @Nullable
    private String menuTitle;
    @Nullable
    private Function1<? super DSTabItemModel, Unit> onTabSelected;
    /* access modifiers changed from: private */
    public boolean shouldTriggerTabSelectionCallback;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<TabLayout.Tab, DSTabItemModel> tabsModelMap;
    @NotNull
    private DSTabBarType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabBar$AnimationDirection;", "", "(Ljava/lang/String;I)V", "FORWARD", "REVERSE", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum AnimationDirection {
        FORWARD,
        REVERSE
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabBar$Companion;", "", "()V", "TAB_BAR_ANIMATION_OFFSET", "", "TAB_BAR_DEFAULT_ANIMATION_OFFSET", "TAB_BAR_MENU_HEIGHT_RATIO", "", "TAB_BAR_TABS_LIMIT", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "", "(Ljava/lang/String;I)V", "FIXED", "SCROLLABLE", "MENU", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum DSTabBarType {
        FIXED,
        SCROLLABLE,
        MENU
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DSTabBarType.values().length];
            iArr[DSTabBarType.FIXED.ordinal()] = 1;
            iArr[DSTabBarType.SCROLLABLE.ordinal()] = 2;
            iArr[DSTabBarType.MENU.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTabBar(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void addTabFromItemModel(DSTabItemModel dSTabItemModel) {
        if (!isMaxTabsNumber()) {
            TabLayout.Tab createCustomTab = createCustomTab(dSTabItemModel);
            ((TabLayout) findViewById(R.id.tabsLayout)).addTab(createCustomTab);
            this.tabsModelMap.put(createCustomTab, dSTabItemModel);
            return;
        }
        throw new IllegalStateException("DSTabBar with FIXED width can contain maximum of 4 tabs.");
    }

    private final void animateSelectionIndicator(TabLayout.Tab tab, boolean z11, AnimationDirection animationDirection, long j11) {
        DSSelectionIndicator dSSelectionIndicator;
        View customView = tab.getCustomView();
        if (customView == null) {
            dSSelectionIndicator = null;
        } else {
            dSSelectionIndicator = (DSSelectionIndicator) customView.findViewById(R.id.tabSelectionIndicator);
        }
        Animation scaleAnimation = getScaleAnimation(z11, animationDirection);
        Intrinsics.checkNotNullExpressionValue(scaleAnimation, Param.ANIMATION);
        AnimationExtensionsKt.onAnimation$default(scaleAnimation, (Function0) null, new DSTabBar$animateSelectionIndicator$1(dSSelectionIndicator, z11), (Function0) null, 5, (Object) null);
        scaleAnimation.setStartOffset(j11);
        if (dSSelectionIndicator != null) {
            dSSelectionIndicator.clearAnimation();
        }
        if (dSSelectionIndicator != null) {
            dSSelectionIndicator.setVisibility(0);
        }
        if (dSSelectionIndicator != null) {
            dSSelectionIndicator.startAnimation(scaleAnimation);
        }
    }

    public static /* synthetic */ void c(DSTabBar dSTabBar, TabLayout.Tab tab, boolean z11, AnimationDirection animationDirection, long j11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            j11 = 0;
        }
        dSTabBar.animateSelectionIndicator(tab, z11, animationDirection, j11);
    }

    private final TabLayout.Tab createCustomTab(DSTabItemModel dSTabItemModel) {
        TextView textView;
        TabLayout.Tab newTab = ((TabLayout) findViewById(R.id.tabsLayout)).newTab();
        Intrinsics.checkNotNullExpressionValue(newTab, "tabsLayout.newTab()");
        newTab.setCustomView(R.layout.ds_tab_item);
        View customView = newTab.getCustomView();
        if (!(customView == null || (textView = (TextView) customView.findViewById(R.id.tabText)) == null)) {
            textView.setText(dSTabItemModel.getTitle());
        }
        return newTab;
    }

    private final AnimationDirection getAnimationDirection(TabLayout.Tab tab, TabLayout.Tab tab2) {
        int i11;
        if (tab2 == null) {
            i11 = 0;
        } else {
            i11 = tab2.getPosition();
        }
        if (i11 <= tab.getPosition()) {
            return AnimationDirection.FORWARD;
        }
        return AnimationDirection.REVERSE;
    }

    private final Animation getScaleAnimation(boolean z11, AnimationDirection animationDirection) {
        if (z11 && animationDirection == AnimationDirection.FORWARD) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.scale_in_forward);
        }
        if (z11 && animationDirection == AnimationDirection.REVERSE) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.scale_in_reverse);
        }
        if (animationDirection == AnimationDirection.FORWARD) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.scale_out_forward);
        }
        return AnimationUtils.loadAnimation(getContext(), R.anim.scale_out_reverse);
    }

    private final boolean isMaxTabsNumber() {
        return this.type == DSTabBarType.FIXED && this.tabsModelMap.size() >= 4;
    }

    public static /* synthetic */ void selectTab$default(DSTabBar dSTabBar, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        dSTabBar.selectTab(i11, z11);
    }

    private final void setTabBarType(DSTabBarType dSTabBarType) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[dSTabBarType.ordinal()];
        if (i11 == 1) {
            ((TabLayout) findViewById(R.id.tabsLayout)).setTabMode(1);
            ((ImageView) findViewById(R.id.tabsMenu)).setVisibility(8);
        } else if (i11 == 2) {
            ((TabLayout) findViewById(R.id.tabsLayout)).setTabMode(0);
            ((ImageView) findViewById(R.id.tabsMenu)).setVisibility(8);
        } else if (i11 == 3) {
            ((TabLayout) findViewById(R.id.tabsLayout)).setTabMode(0);
            ((ImageView) findViewById(R.id.tabsMenu)).setVisibility(0);
        }
    }

    private final void setupListeners() {
        ((ImageView) findViewById(R.id.tabsMenu)).setOnClickListener(new a(this));
        int i11 = R.id.tabsLayout;
        TabLayout tabLayout = (TabLayout) findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tabsLayout");
        TabLayoutExtensionsKt.onTab$default(tabLayout, new DSTabBar$setupListeners$2(this), (Function1) null, (Function1) null, 6, (Object) null);
        ((TabLayout) findViewById(i11)).setOnScrollChangeListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupListeners$lambda-3  reason: not valid java name */
    public static final void m8624setupListeners$lambda3(DSTabBar dSTabBar, View view) {
        Intrinsics.checkNotNullParameter(dSTabBar, "this$0");
        dSTabBar.showMenuBottomSheetDialog(dSTabBar.getTabs(), dSTabBar.getMenuTitle());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupListeners$lambda-4  reason: not valid java name */
    public static final void m8625setupListeners$lambda4(DSTabBar dSTabBar, View view, int i11, int i12, int i13, int i14) {
        float f11;
        Intrinsics.checkNotNullParameter(dSTabBar, "this$0");
        ImageView imageView = (ImageView) dSTabBar.findViewById(R.id.tabsMenu);
        if (i11 > 0) {
            f11 = dSTabBar.getResources().getDimension(R.dimen.ds_xxs);
        } else {
            f11 = 0.0f;
        }
        imageView.setElevation(f11);
    }

    private final void showMenuBottomSheetDialog(List<DSTabItemModel> list, String str) {
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this@DSTabBar.context");
        DSNavigationBar dSNavigationBar = new DSNavigationBar(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$1$1(dSBottomSheet)));
        dSNavigationBar.setTitle(str);
        Unit unit = Unit.INSTANCE;
        dSBottomSheet.setNavigationBar(dSNavigationBar);
        dSBottomSheet.setBody(TabBarMenuFragment.Companion.newInstance(list, new DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$2(this, dSBottomSheet), this.tabsModelMap.get(this.currentSelectedTab)));
        dSBottomSheet.setMaxHeightRation(TAB_BAR_MENU_HEIGHT_RATIO);
        dSBottomSheet.setOnShow(new DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$3(this));
        dSBottomSheet.setOnDismiss(new DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$4(this));
        FragmentManager fragmentManager2 = this.fragmentManager;
        if (fragmentManager2 != null) {
            dSBottomSheet.show(fragmentManager2, (String) null);
        }
    }

    private final DSTabItemModel toDSTabItemModel(DSTabItem dSTabItem) {
        return new DSTabItemModel(dSTabItem.getId$marshmallow_release(), dSTabItem.getText$marshmallow_release(), dSTabItem.getSecondaryText$marshmallow_release());
    }

    private final void updateTabTextColor(TabLayout.Tab tab, boolean z11) {
        TextView textView;
        int i11;
        View customView = tab.getCustomView();
        if (customView == null) {
            textView = null;
        } else {
            textView = (TextView) customView.findViewById(R.id.tabText);
        }
        if (z11) {
            i11 = R.color.ds_primary_100;
        } else {
            i11 = R.color.ds_neutral_70;
        }
        if (textView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTextColor(ContextExtensionsKt.getColorCompat(context, i11));
        }
    }

    /* access modifiers changed from: private */
    public final void updateTabsSelection(TabLayout.Tab tab, TabLayout.Tab tab2) {
        long j11;
        AnimationDirection animationDirection = getAnimationDirection(tab, tab2);
        updateTabTextColor(tab, true);
        if (tab2 != null) {
            j11 = 150;
        } else {
            j11 = 0;
        }
        animateSelectionIndicator(tab, true, animationDirection, j11);
        if (tab2 != null) {
            updateTabTextColor(tab2, false);
            c(this, tab2, false, animationDirection, 0, 8, (Object) null);
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void addView(@NotNull View view, int i11, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        if (view.getId() == R.id.tabsContainer) {
            super.addView(view, i11, layoutParams);
        } else if (view instanceof DSTabItem) {
            addTabFromItemModel(toDSTabItemModel((DSTabItem) view));
        } else {
            throw new IllegalArgumentException("Only DSTabItem instances can be added to DSTabBar.");
        }
    }

    @Nullable
    public final DSTabBarCallbacks getCallbacks() {
        return this.callbacks;
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @Nullable
    public final String getMenuTitle() {
        return this.menuTitle;
    }

    @Nullable
    public final Function1<DSTabItemModel, Unit> getOnTabSelected() {
        return this.onTabSelected;
    }

    public final int getSelectedTabIndex() {
        return ((TabLayout) findViewById(R.id.tabsLayout)).getSelectedTabPosition();
    }

    @NotNull
    public final List<DSTabItemModel> getTabs() {
        return CollectionsKt___CollectionsKt.toList(this.tabsModelMap.values());
    }

    @NotNull
    public final DSTabBarType getType() {
        return this.type;
    }

    public final void selectTab(int i11, boolean z11) {
        this.shouldTriggerTabSelectionCallback = z11;
        TabLayout.Tab tabAt = ((TabLayout) findViewById(R.id.tabsLayout)).getTabAt(i11);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    public final void setCallbacks(@Nullable DSTabBarCallbacks dSTabBarCallbacks) {
        this.callbacks = dSTabBarCallbacks;
    }

    public final void setFragmentManager(@Nullable FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
    }

    public final void setMenuTitle(@Nullable String str) {
        this.menuTitle = str;
    }

    public final void setOnTabSelected(@Nullable Function1<? super DSTabItemModel, Unit> function1) {
        this.onTabSelected = function1;
    }

    public final void setTabs(@NotNull List<DSTabItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.tabsModelMap.clear();
        ((TabLayout) findViewById(R.id.tabsLayout)).removeAllTabs();
        for (DSTabItemModel addTabFromItemModel : list) {
            addTabFromItemModel(addTabFromItemModel);
        }
    }

    public final void setType(@NotNull DSTabBarType dSTabBarType) {
        Intrinsics.checkNotNullParameter(dSTabBarType, "value");
        setTabBarType(dSTabBarType);
        this.type = dSTabBarType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSTabBarType dSTabBarType = DSTabBarType.MENU;
        this.type = dSTabBarType;
        this.tabsModelMap = new LinkedHashMap();
        this.shouldTriggerTabSelectionCallback = true;
        LayoutInflater.from(context).inflate(R.layout.ds_tab_bar, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTabBar, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.DSTabBar, 0, 0)");
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSTabBar_tb_type, -1);
            setType(i12 >= 0 ? DSTabBarType.values()[i12] : dSTabBarType);
            setMenuTitle(obtainStyledAttributes.getString(R.styleable.DSTabBar_tb_menu_title));
            obtainStyledAttributes.recycle();
        }
        setupListeners();
    }
}
