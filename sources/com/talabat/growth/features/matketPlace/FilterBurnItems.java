package com.talabat.growth.features.matketPlace;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.rewards.RewardsFeatureFlagConstants;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/features/matketPlace/FilterBurnItems;", "Lcom/talabat/talabatcore/interactor/UseCase;", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "funWithFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterByRestriction", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterBurnItems extends UseCase<List<? extends BurnItemDisplayModel>, List<? extends BurnItemDisplayModel>> {
    @NotNull
    private final ITalabatFeatureFlag funWithFlags;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterBurnItems(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "funWithFlags");
        this.funWithFlags = iTalabatFeatureFlag;
    }

    private final List<BurnItemDisplayModel> filterByRestriction(List<BurnItemDisplayModel> list) {
        boolean z11;
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.funWithFlags, RewardsFeatureFlagConstants.CAN_SHOW_PRO_NON_PRO_REWARDS, false, 2, (Object) null)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((BurnItemDisplayModel) next).getSubscriptionRestriction() == SubscriptionRestriction.UNRESTRICTED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Nullable
    public Object run(@NotNull List<BurnItemDisplayModel> list, @NotNull Continuation<? super Either<? extends Failure, ? extends List<BurnItemDisplayModel>>> continuation) {
        return new Either.Right(filterByRestriction(list));
    }
}
