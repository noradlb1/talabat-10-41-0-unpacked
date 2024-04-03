package com.talabat.talabatcommon.views.tabBarWithTag;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "selectedTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabBarWithTagView$setupListeners$1 extends Lambda implements Function1<TabLayout.Tab, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabBarWithTagView f11754g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarWithTagView$setupListeners$1(TabBarWithTagView tabBarWithTagView) {
        super(1);
        this.f11754g = tabBarWithTagView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TabLayout.Tab) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TabLayout.Tab tab) {
        Function1<TabItemModel, Unit> onTabSelected;
        Intrinsics.checkNotNullParameter(tab, "selectedTab");
        TabItemModel tabItemModel = (TabItemModel) this.f11754g.tabsModelMap.get(tab);
        if (tabItemModel != null) {
            TabBarWithTagView tabBarWithTagView = this.f11754g;
            if (tabBarWithTagView.shouldTriggerTabSelectionCallback && (onTabSelected = tabBarWithTagView.getOnTabSelected()) != null) {
                onTabSelected.invoke(tabItemModel);
            }
            tabBarWithTagView.shouldTriggerTabSelectionCallback = true;
        }
        TabBarWithTagView tabBarWithTagView2 = this.f11754g;
        tabBarWithTagView2.updateTabsSelection(tab, tabBarWithTagView2.currentSelectedTab);
        this.f11754g.currentSelectedTab = tab;
    }
}
