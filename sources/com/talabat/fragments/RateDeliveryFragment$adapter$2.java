package com.talabat.fragments;

import com.talabat.adapters.RateReasonsAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/adapters/RateReasonsAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RateDeliveryFragment$adapter$2 extends Lambda implements Function0<RateReasonsAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RateDeliveryFragment f59803g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateDeliveryFragment$adapter$2(RateDeliveryFragment rateDeliveryFragment) {
        super(0);
        this.f59803g = rateDeliveryFragment;
    }

    @NotNull
    public final RateReasonsAdapter invoke() {
        return new RateReasonsAdapter(this.f59803g.getActivity(), this.f59803g.getDeliveryReasons());
    }
}
