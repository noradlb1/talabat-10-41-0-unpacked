package com.designsystem.ds_tabs;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n"}, d2 = {"Lkotlin/Function1;", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TabBarMenuFragment$onMenuItemTap$2 extends Lambda implements Function0<Function1<? super DSTabItemModel, ? extends Unit>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33062g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$onMenuItemTap$2(TabBarMenuFragment tabBarMenuFragment) {
        super(0);
        this.f33062g = tabBarMenuFragment;
    }

    @NotNull
    public final Function1<DSTabItemModel, Unit> invoke() {
        Serializable serializable = this.f33062g.requireArguments().getSerializable("TAB_BAR_ON_MENU_ITEM_TAP");
        if (serializable != null) {
            return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(serializable, 1);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
