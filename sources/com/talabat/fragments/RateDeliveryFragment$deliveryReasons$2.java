package com.talabat.fragments;

import JsonModels.Response.rateOrders.RateReason;
import android.os.Bundle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "LJsonModels/Response/rateOrders/RateReason;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RateDeliveryFragment$deliveryReasons$2 extends Lambda implements Function0<ArrayList<RateReason>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RateDeliveryFragment f59804g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateDeliveryFragment$deliveryReasons$2(RateDeliveryFragment rateDeliveryFragment) {
        super(0);
        this.f59804g = rateDeliveryFragment;
    }

    @NotNull
    public final ArrayList<RateReason> invoke() {
        Bundle arguments = this.f59804g.getArguments();
        ArrayList<RateReason> parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("reasons") : null;
        return parcelableArrayList == null ? new ArrayList<>() : parcelableArrayList;
    }
}
