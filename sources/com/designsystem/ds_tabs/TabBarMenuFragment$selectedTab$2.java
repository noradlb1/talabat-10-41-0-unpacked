package com.designsystem.ds_tabs;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lcom/designsystem/ds_tabs/DSTabItemModel;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TabBarMenuFragment$selectedTab$2 extends Lambda implements Function0<DSTabItemModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33063g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$selectedTab$2(TabBarMenuFragment tabBarMenuFragment) {
        super(0);
        this.f33063g = tabBarMenuFragment;
    }

    @Nullable
    public final DSTabItemModel invoke() {
        return (DSTabItemModel) this.f33063g.requireArguments().getParcelable("TAB_BAR_SELECTED_TAB");
    }
}
