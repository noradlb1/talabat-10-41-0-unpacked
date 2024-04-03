package com.talabat.home.useraccount;

import com.talabat.helpers.GlobalConstants;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/talabat/home/useraccount/UserAccountFragment$setSideMenu$1", "Lcom/talabat/sidemenu/SideMenuRecyclerViewAdapter$SidemenuClicked;", "onClick", "", "ref", "", "onLinkClicked", "title", "url", "scrollFocus", "posistion", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountFragment$setSideMenu$1 implements SideMenuRecyclerViewAdapter.SidemenuClicked {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60933a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment$createLinearLayoutManager$1 f60934b;

    public UserAccountFragment$setSideMenu$1(UserAccountFragment userAccountFragment, UserAccountFragment$createLinearLayoutManager$1 userAccountFragment$createLinearLayoutManager$1) {
        this.f60933a = userAccountFragment;
        this.f60934b = userAccountFragment$createLinearLayoutManager$1;
    }

    public void onClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, GlobalConstants.ExtraNames.REF);
        this.f60933a.getSideMenuPresenter().onSidemenuItemClicked(str);
    }

    public void onLinkClicked(@Nullable String str, @Nullable String str2) {
        this.f60933a.getSideMenuPresenter().onSidemenuLinkClicked(str, str2);
    }

    public void scrollFocus(int i11) {
        this.f60934b.scrollToPosition(i11);
    }
}
