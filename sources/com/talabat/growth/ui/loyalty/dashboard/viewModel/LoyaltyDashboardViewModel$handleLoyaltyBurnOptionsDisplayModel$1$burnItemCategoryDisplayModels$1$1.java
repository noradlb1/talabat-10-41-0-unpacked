package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1", f = "LoyaltyDashboardViewModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
public final class LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BurnItemCategoryDisplayModel>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f60675h;

    /* renamed from: i  reason: collision with root package name */
    public Object f60676i;

    /* renamed from: j  reason: collision with root package name */
    public int f60677j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BurnItemCategoryDisplayModel f60678k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardViewModel f60679l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1(BurnItemCategoryDisplayModel burnItemCategoryDisplayModel, LoyaltyDashboardViewModel loyaltyDashboardViewModel, Continuation<? super LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1> continuation) {
        super(2, continuation);
        this.f60678k = burnItemCategoryDisplayModel;
        this.f60679l = loyaltyDashboardViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1(this.f60678k, this.f60679l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BurnItemCategoryDisplayModel> continuation) {
        return ((LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1$burnItemCategoryDisplayModels$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BurnItemCategoryDisplayModel burnItemCategoryDisplayModel;
        BurnItemCategoryDisplayModel burnItemCategoryDisplayModel2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60677j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BurnItemCategoryDisplayModel burnItemCategoryDisplayModel3 = this.f60678k;
            LoyaltyDashboardViewModel loyaltyDashboardViewModel = this.f60679l;
            this.f60675h = burnItemCategoryDisplayModel3;
            this.f60676i = burnItemCategoryDisplayModel3;
            this.f60677j = 1;
            Object access$filterBurnItems = loyaltyDashboardViewModel.filterBurnItems(burnItemCategoryDisplayModel3, this);
            if (access$filterBurnItems == coroutine_suspended) {
                return coroutine_suspended;
            }
            burnItemCategoryDisplayModel2 = burnItemCategoryDisplayModel3;
            obj = access$filterBurnItems;
            burnItemCategoryDisplayModel = burnItemCategoryDisplayModel2;
        } else if (i11 == 1) {
            burnItemCategoryDisplayModel2 = (BurnItemCategoryDisplayModel) this.f60676i;
            burnItemCategoryDisplayModel = (BurnItemCategoryDisplayModel) this.f60675h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        burnItemCategoryDisplayModel2.setBurnItemsDisplayModel((List) obj);
        return burnItemCategoryDisplayModel;
    }
}
