package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1", f = "LoyaltyDashboardViewModel.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
public final class LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60672h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BurnListDisplayModel f60673i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardViewModel f60674j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1(BurnListDisplayModel burnListDisplayModel, LoyaltyDashboardViewModel loyaltyDashboardViewModel, Continuation<? super LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1> continuation) {
        super(2, continuation);
        this.f60673i = burnListDisplayModel;
        this.f60674j = loyaltyDashboardViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1 loyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1 = new LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1(this.f60673i, this.f60674j, continuation);
        loyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1.L$0 = obj;
        return loyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60672h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Iterable<BurnItemCategoryDisplayModel> data = this.f60673i.getData();
            LoyaltyDashboardViewModel loyaltyDashboardViewModel = this.f60674j;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(data, 10));
            for (BurnItemCategoryDisplayModel loyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1 : data) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1(loyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1, loyaltyDashboardViewModel, (Continuation<? super LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1>) null), 3, (Object) null));
            }
            this.f60672h = 1;
            obj = AwaitKt.awaitAll(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : (Iterable) obj) {
            if (!((BurnItemCategoryDisplayModel) next).getBurnItemsDisplayModel().isEmpty()) {
                arrayList2.add(next);
            }
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList2);
        MutableLiveData<BurnListDisplayModel> burnOptionsData = this.f60674j.getBurnOptionsData();
        BurnListDisplayModel burnListDisplayModel = this.f60673i;
        burnListDisplayModel.setData(mutableList);
        burnOptionsData.postValue(burnListDisplayModel);
        return Unit.INSTANCE;
    }
}
