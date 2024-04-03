package com.talabat.talabatlife.tracking;

import buisnessmodels.ICustomer;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJA\u0010\r\u001a*\u0012\u0004\u0012\u00020\u000f\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatlife/tracking/LifeOnBoardingLoadedUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "customer", "Lbuisnessmodels/ICustomer;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lbuisnessmodels/ICustomer;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeOnBoardingLoadedUseCase extends UseCase<HashMap<String, String>, Integer> {
    @NotNull
    private final ICustomer customer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifeOnBoardingLoadedUseCase(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ICustomer iCustomer) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iCustomer, "customer");
        this.customer = iCustomer;
    }

    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation continuation) {
        return run(((Number) obj).intValue(), (Continuation<? super Either<? extends Failure, ? extends HashMap<String, String>>>) continuation);
    }

    @Nullable
    public Object run(int i11, @NotNull Continuation<? super Either<? extends Failure, ? extends HashMap<String, String>>> continuation) {
        HashMap hashMap = new HashMap();
        float talabatCreditBalance = this.customer.getTalabatCreditBalance();
        hashMap.put("userOnlinePaymentMethods", "credit:" + talabatCreditBalance);
        hashMap.put(ConstantsKt.LOADED_SHOP_QUANTITY_TOTAL, String.valueOf(i11));
        return new Either.Right(hashMap);
    }
}
