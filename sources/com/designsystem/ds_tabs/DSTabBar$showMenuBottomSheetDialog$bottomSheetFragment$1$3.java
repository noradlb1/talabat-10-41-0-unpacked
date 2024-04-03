package com.designsystem.ds_tabs;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTabBar f33045g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTabBar$showMenuBottomSheetDialog$bottomSheetFragment$1$3(DSTabBar dSTabBar) {
        super(0);
        this.f33045g = dSTabBar;
    }

    public final void invoke() {
        DSTabBarCallbacks callbacks = this.f33045g.getCallbacks();
        if (callbacks != null) {
            callbacks.onMenuOpen();
        }
    }
}
