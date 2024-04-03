package com.talabat.feature.tpro.presentation.management.details;

import android.content.Context;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TProSubscriptionDetailsFragment$subscriptionSharedPrefManager$2 extends Lambda implements Function0<SubscriptionSharedPrefManager> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f59318g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProSubscriptionDetailsFragment$subscriptionSharedPrefManager$2(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        super(0);
        this.f59318g = tProSubscriptionDetailsFragment;
    }

    @NotNull
    public final SubscriptionSharedPrefManager invoke() {
        Context requireContext = this.f59318g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new SubscriptionSharedPrefManager(requireContext);
    }
}
