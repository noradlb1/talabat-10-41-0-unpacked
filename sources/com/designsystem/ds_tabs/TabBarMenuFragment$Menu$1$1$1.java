package com.designsystem.ds_tabs;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TabBarMenuFragment$Menu$1$1$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTabItemModel f33056g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TabBarMenuFragment f33057h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<DSTabItemModel> f33058i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$Menu$1$1$1(DSTabItemModel dSTabItemModel, TabBarMenuFragment tabBarMenuFragment, MutableState<DSTabItemModel> mutableState) {
        super(1);
        this.f33056g = dSTabItemModel;
        this.f33057h = tabBarMenuFragment;
        this.f33058i = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        TabBarMenuFragment.m8627Menu$lambda3(this.f33058i, this.f33056g);
        this.f33057h.getOnMenuItemTap$marshmallow_release().invoke(this.f33056g);
    }
}
