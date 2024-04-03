package com.designsystem.ds_tabs;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$Tab;", "selectedTab", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTabBar$setupListeners$2 extends Lambda implements Function1<TabLayout.Tab, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTabBar f33041g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTabBar$setupListeners$2(DSTabBar dSTabBar) {
        super(1);
        this.f33041g = dSTabBar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TabLayout.Tab) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "selectedTab");
        DSTabItemModel dSTabItemModel = (DSTabItemModel) this.f33041g.tabsModelMap.get(tab);
        if (dSTabItemModel != null) {
            DSTabBar dSTabBar = this.f33041g;
            if (dSTabBar.shouldTriggerTabSelectionCallback) {
                Function1<DSTabItemModel, Unit> onTabSelected = dSTabBar.getOnTabSelected();
                if (onTabSelected != null) {
                    onTabSelected.invoke(dSTabItemModel);
                }
                DSTabBarCallbacks callbacks = dSTabBar.getCallbacks();
                if (callbacks != null) {
                    callbacks.onTabTap(dSTabItemModel);
                }
            }
            dSTabBar.shouldTriggerTabSelectionCallback = true;
        }
        DSTabBar dSTabBar2 = this.f33041g;
        dSTabBar2.updateTabsSelection(tab, dSTabBar2.currentSelectedTab);
        this.f33041g.currentSelectedTab = tab;
    }
}
