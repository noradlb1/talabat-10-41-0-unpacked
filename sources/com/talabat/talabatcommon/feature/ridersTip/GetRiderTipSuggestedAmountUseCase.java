package com.talabat.talabatcommon.feature.ridersTip;

import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import com.talabat.talabatcommon.feature.ridersTip.repository.RiderTipRepository;
import com.talabat.talabatcommon.views.ridersTip.model.RiderTipMapper;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestedAmountDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.functional.EitherKt;
import com.talabat.talabatcore.interactor.UseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\f¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/GetRiderTipSuggestedAmountUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "", "riderTipRepository", "Lcom/talabat/talabatcommon/feature/ridersTip/repository/RiderTipRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mapper", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "(Lcom/talabat/talabatcommon/feature/ridersTip/repository/RiderTipRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetRiderTipSuggestedAmountUseCase extends UseCase<List<? extends RidersTipSuggestedAmountDisplayModel>, Integer> {
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<RiderTipSuggestedAmountResponse, List<RidersTipSuggestedAmountDisplayModel>> mapper;
    @NotNull
    private final RiderTipRepository riderTipRepository;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetRiderTipSuggestedAmountUseCase(RiderTipRepository riderTipRepository2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(riderTipRepository2, coroutineScope, coroutineDispatcher, (i11 & 8) != 0 ? new Function1<RiderTipSuggestedAmountResponse, List<? extends RidersTipSuggestedAmountDisplayModel>>(RiderTipMapper.Companion) {
            @NotNull
            public final List<RidersTipSuggestedAmountDisplayModel> invoke(@Nullable RiderTipSuggestedAmountResponse riderTipSuggestedAmountResponse) {
                return ((RiderTipMapper.Companion) this.receiver).mapRidersTipSuggestedAmountToDisplayModel(riderTipSuggestedAmountResponse);
            }
        } : function1);
    }

    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation continuation) {
        return run(((Number) obj).intValue(), (Continuation<? super Either<? extends Failure, ? extends List<RidersTipSuggestedAmountDisplayModel>>>) continuation);
    }

    @Nullable
    public Object run(int i11, @NotNull Continuation<? super Either<? extends Failure, ? extends List<RidersTipSuggestedAmountDisplayModel>>> continuation) {
        return EitherKt.map(this.riderTipRepository.getRiderTipSuggestedAmount(i11), new GetRiderTipSuggestedAmountUseCase$run$2(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetRiderTipSuggestedAmountUseCase(@NotNull RiderTipRepository riderTipRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super RiderTipSuggestedAmountResponse, ? extends List<RidersTipSuggestedAmountDisplayModel>> function1) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(riderTipRepository2, "riderTipRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        this.riderTipRepository = riderTipRepository2;
        this.mapper = function1;
    }
}
