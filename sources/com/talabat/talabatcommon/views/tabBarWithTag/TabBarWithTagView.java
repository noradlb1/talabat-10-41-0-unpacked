package com.talabat.talabatcommon.views.tabBarWithTag;

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
import androidx.cardview.widget.CardView;
import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.tabs.TabLayout;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.talabatcommon.R;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u0001:\u0003KLMB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\rH\u0002J \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0016J*\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010%\u001a\u00020\rH\u0002J\u001a\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\nH\u0002J \u00107\u001a\n 9*\u0004\u0018\u000108082\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\u0018\u0010:\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u00072\b\b\u0002\u0010;\u001a\u00020\u0014J\b\u0010<\u001a\u00020\u000eH\u0002J\u001a\u0010=\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\nH\u0002JA\u0010>\u001a\u00020\u000e*\u0002082\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0@2\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0@H\u0000¢\u0006\u0002\bCJL\u0010D\u001a\u00020\u000e*\u00020E2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\f2\u0014\b\u0002\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\f2\u0014\b\u0002\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\fJ\f\u0010I\u001a\u00020\r*\u00020JH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006N"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentSelectedTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemModel;", "", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "shouldTriggerTabSelectionCallback", "", "value", "", "tabs", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "tabsModelMap", "", "viewBinder", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarBinder;", "getViewBinder", "()Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarBinder;", "setViewBinder", "(Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarBinder;)V", "addTabFromItemModel", "itemModel", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "animateSelectionIndicator", "tab", "isSelected", "animationDirection", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$AnimationDirection;", "animationStartOffset", "", "createCustomTab", "getAnimationDirection", "selectedTab", "unselectedTab", "getScaleAnimation", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "selectTab", "triggerSelectionCallback", "setupListeners", "updateTabsSelection", "onAnimation", "start", "Lkotlin/Function0;", "end", "repeat", "onAnimation$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onTab", "Lcom/google/android/material/tabs/TabLayout;", "selected", "reselected", "unselected", "toDSTabItemModel", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemView;", "AnimationDirection", "Companion", "ViewHolder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TabBarWithTagView extends LinearLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long TAB_BAR_ANIMATION_OFFSET = 150;
    private static final long TAB_BAR_DEFAULT_ANIMATION_OFFSET = 0;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    @Nullable
    public TabLayout.Tab currentSelectedTab;
    @Nullable
    private Function1<? super TabItemModel, Unit> onTabSelected;
    /* access modifiers changed from: private */
    public boolean shouldTriggerTabSelectionCallback;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<TabLayout.Tab, TabItemModel> tabsModelMap;
    public TabBarBinder viewBinder;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$AnimationDirection;", "", "(Ljava/lang/String;I)V", "FORWARD", "REVERSE", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum AnimationDirection {
        FORWARD,
        REVERSE
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$Companion;", "", "()V", "TAB_BAR_ANIMATION_OFFSET", "", "TAB_BAR_DEFAULT_ANIMATION_OFFSET", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$ViewHolder;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabText", "Landroid/widget/TextView;", "getTabText", "()Landroid/widget/TextView;", "tagContainer", "Landroidx/cardview/widget/CardView;", "getTagContainer", "()Landroidx/cardview/widget/CardView;", "tagIv", "Landroid/widget/ImageView;", "getTagIv", "()Landroid/widget/ImageView;", "tagTv", "getTagTv", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder {
        @Nullable
        private final TextView tabText;
        @Nullable
        private final CardView tagContainer;
        @Nullable
        private final ImageView tagIv;
        @Nullable
        private final TextView tagTv;

        /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolder(@org.jetbrains.annotations.NotNull com.google.android.material.tabs.TabLayout.Tab r4) {
            /*
                r3 = this;
                java.lang.String r0 = "tab"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r3.<init>()
                android.view.View r0 = r4.getCustomView()
                r1 = 0
                if (r0 == 0) goto L_0x0018
                int r2 = com.talabat.talabatcommon.R.id.tabText
                android.view.View r0 = r0.findViewById(r2)
                android.widget.TextView r0 = (android.widget.TextView) r0
                goto L_0x0019
            L_0x0018:
                r0 = r1
            L_0x0019:
                r3.tabText = r0
                android.view.View r0 = r4.getCustomView()
                if (r0 == 0) goto L_0x002a
                int r2 = com.talabat.talabatcommon.R.id.tagContainer
                android.view.View r0 = r0.findViewById(r2)
                androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
                goto L_0x002b
            L_0x002a:
                r0 = r1
            L_0x002b:
                r3.tagContainer = r0
                android.view.View r0 = r4.getCustomView()
                if (r0 == 0) goto L_0x003c
                int r2 = com.talabat.talabatcommon.R.id.tagTv
                android.view.View r0 = r0.findViewById(r2)
                android.widget.TextView r0 = (android.widget.TextView) r0
                goto L_0x003d
            L_0x003c:
                r0 = r1
            L_0x003d:
                r3.tagTv = r0
                android.view.View r4 = r4.getCustomView()
                if (r4 == 0) goto L_0x004e
                int r0 = com.talabat.talabatcommon.R.id.tagIv
                android.view.View r4 = r4.findViewById(r0)
                r1 = r4
                android.widget.ImageView r1 = (android.widget.ImageView) r1
            L_0x004e:
                r3.tagIv = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView.ViewHolder.<init>(com.google.android.material.tabs.TabLayout$Tab):void");
        }

        @Nullable
        public final TextView getTabText() {
            return this.tabText;
        }

        @Nullable
        public final CardView getTagContainer() {
            return this.tagContainer;
        }

        @Nullable
        public final ImageView getTagIv() {
            return this.tagIv;
        }

        @Nullable
        public final TextView getTagTv() {
            return this.tagTv;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TabBarWithTagView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TabBarWithTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TabBarWithTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.tabsModelMap = new LinkedHashMap();
        this.shouldTriggerTabSelectionCallback = true;
        LayoutInflater.from(context).inflate(R.layout.tab_bar_with_tag, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.designsystem.marshmallow.R.styleable.DSTabBar, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…abBar, 0, 0\n            )");
            obtainStyledAttributes.recycle();
        }
        setupListeners();
    }

    public static /* synthetic */ void a(TabBarWithTagView tabBarWithTagView, TabLayout.Tab tab, boolean z11, AnimationDirection animationDirection, long j11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            j11 = 0;
        }
        tabBarWithTagView.animateSelectionIndicator(tab, z11, animationDirection, j11);
    }

    private final void addTabFromItemModel(TabItemModel tabItemModel) {
        TabLayout.Tab createCustomTab = createCustomTab(tabItemModel);
        ((TabLayout) _$_findCachedViewById(R.id.tabsLayout)).addTab(createCustomTab);
        this.tabsModelMap.put(createCustomTab, tabItemModel);
    }

    private final void animateSelectionIndicator(TabLayout.Tab tab, boolean z11, AnimationDirection animationDirection, long j11) {
        DSSelectionIndicator dSSelectionIndicator;
        View customView = tab.getCustomView();
        if (customView != null) {
            dSSelectionIndicator = (DSSelectionIndicator) customView.findViewById(R.id.tabSelectionIndicator);
        } else {
            dSSelectionIndicator = null;
        }
        Animation scaleAnimation = getScaleAnimation(z11, animationDirection);
        Intrinsics.checkNotNullExpressionValue(scaleAnimation, Param.ANIMATION);
        onAnimation$com_talabat_NewArchi_TalabatCommon_TalabatCommon$default(this, scaleAnimation, (Function0) null, new TabBarWithTagView$animateSelectionIndicator$1(dSSelectionIndicator, z11), (Function0) null, 5, (Object) null);
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

    private final TabLayout.Tab createCustomTab(TabItemModel tabItemModel) {
        TabLayout.Tab newTab = ((TabLayout) _$_findCachedViewById(R.id.tabsLayout)).newTab();
        Intrinsics.checkNotNullExpressionValue(newTab, "tabsLayout.newTab()");
        newTab.setCustomView(R.layout.tab_item_with_tag);
        TabBarBinder viewBinder2 = getViewBinder();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        viewBinder2.initialState(tabItemModel, context, new ViewHolder(newTab));
        return newTab;
    }

    private final AnimationDirection getAnimationDirection(TabLayout.Tab tab, TabLayout.Tab tab2) {
        int i11;
        if (tab2 != null) {
            i11 = tab2.getPosition();
        } else {
            i11 = 0;
        }
        if (i11 <= tab.getPosition()) {
            return AnimationDirection.FORWARD;
        }
        return AnimationDirection.REVERSE;
    }

    private final Animation getScaleAnimation(boolean z11, AnimationDirection animationDirection) {
        if (z11 && animationDirection == AnimationDirection.FORWARD) {
            return AnimationUtils.loadAnimation(getContext(), com.designsystem.marshmallow.R.anim.scale_in_forward);
        }
        if (z11 && animationDirection == AnimationDirection.REVERSE) {
            return AnimationUtils.loadAnimation(getContext(), com.designsystem.marshmallow.R.anim.scale_in_reverse);
        }
        if (animationDirection == AnimationDirection.FORWARD) {
            return AnimationUtils.loadAnimation(getContext(), com.designsystem.marshmallow.R.anim.scale_out_forward);
        }
        return AnimationUtils.loadAnimation(getContext(), com.designsystem.marshmallow.R.anim.scale_out_reverse);
    }

    public static /* synthetic */ void onAnimation$com_talabat_NewArchi_TalabatCommon_TalabatCommon$default(TabBarWithTagView tabBarWithTagView, Animation animation, Function0 function0, Function0 function02, Function0 function03, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = TabBarWithTagView$onAnimation$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            function02 = TabBarWithTagView$onAnimation$2.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            function03 = TabBarWithTagView$onAnimation$3.INSTANCE;
        }
        tabBarWithTagView.onAnimation$com_talabat_NewArchi_TalabatCommon_TalabatCommon(animation, function0, function02, function03);
    }

    public static /* synthetic */ void onTab$default(TabBarWithTagView tabBarWithTagView, TabLayout tabLayout, Function1 function1, Function1 function12, Function1 function13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = TabBarWithTagView$onTab$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            function12 = TabBarWithTagView$onTab$2.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            function13 = TabBarWithTagView$onTab$3.INSTANCE;
        }
        tabBarWithTagView.onTab(tabLayout, function1, function12, function13);
    }

    public static /* synthetic */ void selectTab$default(TabBarWithTagView tabBarWithTagView, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = true;
        }
        tabBarWithTagView.selectTab(i11, z11);
    }

    private final void setupListeners() {
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.tabsLayout);
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tabsLayout");
        onTab$default(this, tabLayout, new TabBarWithTagView$setupListeners$1(this), (Function1) null, (Function1) null, 6, (Object) null);
    }

    private final TabItemModel toDSTabItemModel(TabItemView tabItemView) {
        return new TabItemModel(tabItemView.getId$com_talabat_NewArchi_TalabatCommon_TalabatCommon(), tabItemView.getText$com_talabat_NewArchi_TalabatCommon_TalabatCommon(), false, 0, false, false, 60, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final void updateTabsSelection(TabLayout.Tab tab, TabLayout.Tab tab2) {
        long j11;
        AnimationDirection animationDirection = getAnimationDirection(tab, tab2);
        TabBarBinder viewBinder2 = getViewBinder();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        viewBinder2.selected(context, new ViewHolder(tab));
        if (tab2 != null) {
            TabBarBinder viewBinder3 = getViewBinder();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            viewBinder3.unselected(context2, new ViewHolder(tab2));
            a(this, tab2, false, animationDirection, 0, 8, (Object) null);
        }
        if (tab2 != null) {
            j11 = 150;
        } else {
            j11 = 0;
        }
        animateSelectionIndicator(tab, true, animationDirection, j11);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void addView(@NotNull View view, int i11, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        if (view.getId() == R.id.tabsContainer) {
            super.addView(view, i11, layoutParams);
        } else if (view instanceof TabItemView) {
            addTabFromItemModel(toDSTabItemModel((TabItemView) view));
        } else {
            throw new IllegalArgumentException("Only DSTabItem instances can be added to DSTabBar.");
        }
    }

    @Nullable
    public final Function1<TabItemModel, Unit> getOnTabSelected() {
        return this.onTabSelected;
    }

    @NotNull
    public final List<TabItemModel> getTabs() {
        return CollectionsKt___CollectionsKt.toList(this.tabsModelMap.values());
    }

    @NotNull
    public final TabBarBinder getViewBinder() {
        TabBarBinder tabBarBinder = this.viewBinder;
        if (tabBarBinder != null) {
            return tabBarBinder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewBinder");
        return null;
    }

    public final void onAnimation$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Animation animation, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(animation, "<this>");
        Intrinsics.checkNotNullParameter(function0, "start");
        Intrinsics.checkNotNullParameter(function02, TtmlNode.END);
        Intrinsics.checkNotNullParameter(function03, "repeat");
        animation.setAnimationListener(new TabBarWithTagView$onAnimation$4(function0, function02, function03));
    }

    public final void onTab(@NotNull TabLayout tabLayout, @NotNull Function1<? super TabLayout.Tab, Unit> function1, @NotNull Function1<? super TabLayout.Tab, Unit> function12, @NotNull Function1<? super TabLayout.Tab, Unit> function13) {
        Intrinsics.checkNotNullParameter(tabLayout, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selected");
        Intrinsics.checkNotNullParameter(function12, "reselected");
        Intrinsics.checkNotNullParameter(function13, "unselected");
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabBarWithTagView$onTab$4(function1, function12, function13));
    }

    public final void selectTab(int i11, boolean z11) {
        this.shouldTriggerTabSelectionCallback = z11;
        TabLayout.Tab tabAt = ((TabLayout) _$_findCachedViewById(R.id.tabsLayout)).getTabAt(i11);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    public final void setOnTabSelected(@Nullable Function1<? super TabItemModel, Unit> function1) {
        this.onTabSelected = function1;
    }

    public final void setTabs(@NotNull List<TabItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.tabsModelMap.clear();
        ((TabLayout) _$_findCachedViewById(R.id.tabsLayout)).removeAllTabs();
        for (TabItemModel addTabFromItemModel : list) {
            addTabFromItemModel(addTabFromItemModel);
        }
    }

    public final void setViewBinder(@NotNull TabBarBinder tabBarBinder) {
        Intrinsics.checkNotNullParameter(tabBarBinder, "<set-?>");
        this.viewBinder = tabBarBinder;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabBarWithTagView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
