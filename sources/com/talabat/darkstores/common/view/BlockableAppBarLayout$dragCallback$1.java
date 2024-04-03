package com.talabat.darkstores.common.view;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/darkstores/common/view/BlockableAppBarLayout$dragCallback$1", "Lcom/google/android/material/appbar/AppBarLayout$Behavior$DragCallback;", "canDrag", "", "appBar", "Lcom/google/android/material/appbar/AppBarLayout;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlockableAppBarLayout$dragCallback$1 extends AppBarLayout.Behavior.DragCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BlockableAppBarLayout f56169a;

    public BlockableAppBarLayout$dragCallback$1(BlockableAppBarLayout blockableAppBarLayout) {
        this.f56169a = blockableAppBarLayout;
    }

    public boolean canDrag(@NotNull AppBarLayout appBarLayout) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBar");
        return this.f56169a.isScrollingEnabled();
    }
}
