package com.talabat.home.useraccount;

import com.talabat.sidemenu.SideMenuHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/sidemenu/SideMenuHeader;", "invoke", "(Lcom/talabat/sidemenu/SideMenuHeader;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserAccountFragment$removeSideMenuHeaderItem$1 extends Lambda implements Function1<SideMenuHeader, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f60932g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$removeSideMenuHeaderItem$1(String str) {
        super(1);
        this.f60932g = str;
    }

    @NotNull
    public final Boolean invoke(@NotNull SideMenuHeader sideMenuHeader) {
        Intrinsics.checkNotNullParameter(sideMenuHeader, "it");
        return Boolean.valueOf(StringsKt__StringsJVMKt.equals(sideMenuHeader.getRef(), this.f60932g, true));
    }
}
