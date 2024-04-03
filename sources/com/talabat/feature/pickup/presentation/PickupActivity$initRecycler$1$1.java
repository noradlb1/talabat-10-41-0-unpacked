package com.talabat.feature.pickup.presentation;

import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/CombinedLoadStates;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$initRecycler$1$1 extends Lambda implements Function1<CombinedLoadStates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58644g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$initRecycler$1$1(PickupActivity pickupActivity) {
        super(1);
        this.f58644g = pickupActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CombinedLoadStates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CombinedLoadStates combinedLoadStates) {
        Intrinsics.checkNotNullParameter(combinedLoadStates, "it");
        LoadState refresh = combinedLoadStates.getRefresh();
        if (refresh instanceof LoadState.Error) {
            this.f58644g.onNetworkError();
        } else if (refresh instanceof LoadState.NotLoading) {
            this.f58644g.showLoading(Boolean.FALSE);
            PickupActivity pickupActivity = this.f58644g;
            pickupActivity.showResult(pickupActivity.pickupAdapter.getItemCount() == 0);
        } else if (refresh instanceof LoadState.Loading) {
            this.f58644g.showLoading(Boolean.TRUE);
        }
    }
}
