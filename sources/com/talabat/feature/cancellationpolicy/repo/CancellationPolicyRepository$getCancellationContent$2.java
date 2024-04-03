package com.talabat.feature.cancellationpolicy.repo;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import com.talabat.feature.cancellationpolicy.mapper.ICancellationPolicyMapper;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyResponse;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyData;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.cancellationpolicy.repo.CancellationPolicyRepository$getCancellationContent$2", f = "CancellationPolicyRepository.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class CancellationPolicyRepository$getCancellationContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CancellationPolicyData>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f58381h;

    /* renamed from: i  reason: collision with root package name */
    public int f58382i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CancellationPolicyRepository f58383j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationPolicyRepository$getCancellationContent$2(CancellationPolicyRepository cancellationPolicyRepository, Continuation<? super CancellationPolicyRepository$getCancellationContent$2> continuation) {
        super(2, continuation);
        this.f58383j = cancellationPolicyRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CancellationPolicyRepository$getCancellationContent$2(this.f58383j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CancellationPolicyData> continuation) {
        return ((CancellationPolicyRepository$getCancellationContent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ICancellationPolicyMapper iCancellationPolicyMapper;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58382i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ICancellationPolicyMapper access$getCancellationPolicyMapper$p = this.f58383j.cancellationPolicyMapper;
            CancellationPolicyService access$getCancellationPolicyService$p = this.f58383j.cancellationPolicyService;
            String access$getCountryId$p = this.f58383j.countryId;
            String access$getVerticalType$p = this.f58383j.verticalType;
            this.f58381h = access$getCancellationPolicyMapper$p;
            this.f58382i = 1;
            Object cancellationPolicyContent = access$getCancellationPolicyService$p.getCancellationPolicyContent(access$getCountryId$p, access$getVerticalType$p, this);
            if (cancellationPolicyContent == coroutine_suspended) {
                return coroutine_suspended;
            }
            iCancellationPolicyMapper = access$getCancellationPolicyMapper$p;
            obj = cancellationPolicyContent;
        } else if (i11 == 1) {
            iCancellationPolicyMapper = (ICancellationPolicyMapper) this.f58381h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iCancellationPolicyMapper.map((CancellationPolicyResponse) obj);
    }
}
