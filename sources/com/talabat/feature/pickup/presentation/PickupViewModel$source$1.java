package com.talabat.feature.pickup.presentation;

import androidx.paging.PagingSource;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource;", "", "Ldatamodels/Restaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupViewModel$source$1 extends Lambda implements Function0<PagingSource<Integer, Restaurant>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupViewModel f58667g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupViewModel$source$1(PickupViewModel pickupViewModel) {
        super(0);
        this.f58667g = pickupViewModel;
    }

    @NotNull
    public final PagingSource<Integer, Restaurant> invoke() {
        return new PickupPagingSource(this.f58667g.useCase, this.f58667g.tracker, this.f58667g.creditBalanceProvider, this.f58667g.eventOrigin, this.f58667g.pageLoadedSuccess);
    }
}
