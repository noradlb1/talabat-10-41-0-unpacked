package com.talabat.darkstores.feature.product.views;

import com.talabat.darkstores.feature.product.models.CampaignAddedQuantity;
import com.talabat.darkstores.feature.product.models.CampaignFreeQuantity;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "io/reactivex/rxkotlin/Observables$combineLatest$1"}, k = 3, mv = {1, 6, 0})
public final class CampaignProgressViewModel$special$$inlined$combineLatest$1<T1, T2, R> implements BiFunction<T1, T2, R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressViewModel f56564b;

    public CampaignProgressViewModel$special$$inlined$combineLatest$1(CampaignProgressViewModel campaignProgressViewModel) {
        this.f56564b = campaignProgressViewModel;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Pair pair = (Pair) t12;
        int r02 = ((CampaignAddedQuantity) pair.component1()).m10036unboximpl();
        int r32 = ((CampaignFreeQuantity) pair.component2()).m10043unboximpl();
        return this.f56564b.m10054createStateMlP_i40(r02, r32, (ProductCampaign.Free) t22);
    }
}
