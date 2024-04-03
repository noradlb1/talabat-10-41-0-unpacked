package com.talabat.home.useraccount;

import com.talabat.sidemenu.SideMenuHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserAccountRecyclerViewAdapter$onBindViewHolder$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UserAccountRecyclerViewAdapter f60939g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SideMenuHeader f60940h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountRecyclerViewAdapter$onBindViewHolder$1(UserAccountRecyclerViewAdapter userAccountRecyclerViewAdapter, SideMenuHeader sideMenuHeader) {
        super(0);
        this.f60939g = userAccountRecyclerViewAdapter;
        this.f60940h = sideMenuHeader;
    }

    public final void invoke() {
        this.f60939g.f61366i.onClick(this.f60940h.getRef());
    }
}
