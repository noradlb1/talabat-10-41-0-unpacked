package com.designsystem.ds_tabs;

import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.google.android.material.tabs.TabLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabItemModel;", "itemModel", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$2 extends Lambda implements Function1<DSTabItemModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTabBar f33043g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f33044h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$2(DSTabBar dSTabBar, DSBottomSheet dSBottomSheet) {
        super(1);
        this.f33043g = dSTabBar;
        this.f33044h = dSBottomSheet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSTabItemModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSTabItemModel dSTabItemModel) {
        Intrinsics.checkNotNullParameter(dSTabItemModel, "itemModel");
        Map access$getTabsModelMap$p = this.f33043g.tabsModelMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : access$getTabsModelMap$p.entrySet()) {
            if (Intrinsics.areEqual((Object) dSTabItemModel, entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        TabLayout.Tab tab = (TabLayout.Tab) CollectionsKt___CollectionsKt.firstOrNull(linkedHashMap.keySet());
        if (tab != null) {
            ((TabLayout) this.f33043g.findViewById(R.id.tabsLayout)).selectTab(tab);
        }
        DSTabBarCallbacks callbacks = this.f33043g.getCallbacks();
        if (callbacks != null) {
            callbacks.onMenuItemTap(dSTabItemModel);
        }
        this.f33044h.dismiss();
    }
}
