package com.designsystem.ds_tabs_view;

import com.designsystem.ds_tabs.DSTabBar;
import com.designsystem.ds_tabs.DSTabItemModel;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabItemModel;", "selectedTab", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTabsView$setupTabSelectionListener$1 extends Lambda implements Function1<DSTabItemModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTabsView f33067g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTabsView$setupTabSelectionListener$1(DSTabsView dSTabsView) {
        super(1);
        this.f33067g = dSTabsView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSTabItemModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSTabItemModel dSTabItemModel) {
        Intrinsics.checkNotNullParameter(dSTabItemModel, "selectedTab");
        DSTabsView dSTabsView = this.f33067g;
        dSTabsView.a(((DSTabBar) dSTabsView.findViewById(R.id.tabBarMenu)).getTabs().indexOf(dSTabItemModel));
    }
}
