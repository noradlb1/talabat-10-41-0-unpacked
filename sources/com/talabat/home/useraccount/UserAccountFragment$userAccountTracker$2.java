package com.talabat.home.useraccount;

import android.content.Context;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.home.useraccount.tracking.UserAccountTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/home/useraccount/tracking/UserAccountTracker;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserAccountFragment$userAccountTracker$2 extends Lambda implements Function0<UserAccountTracker> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60935g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$userAccountTracker$2(UserAccountFragment userAccountFragment) {
        super(0);
        this.f60935g = userAccountFragment;
    }

    @NotNull
    public final UserAccountTracker invoke() {
        Context requireContext = this.f60935g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new UserAccountTracker(requireContext, new TalabatFirebase(), new LocationDataFactory((Function0) null, (Function0) null, (Function0) null, (Function0) null, 15, (DefaultConstructorMarker) null));
    }
}
