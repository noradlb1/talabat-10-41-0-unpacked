package com.talabat.talabatcommon.feature.promotionWidget;

import com.talabat.talabatcommon.feature.promotionWidget.model.request.PromotionsWidgetRequestModel;
import com.talabat.talabatcommon.feature.promotionWidget.repository.PromotionsWidgetRepository;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/promotionWidget/PromotionsWidgetUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;", "promotionsWidgetRepository", "Lcom/talabat/talabatcommon/feature/promotionWidget/repository/PromotionsWidgetRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcommon/feature/promotionWidget/repository/PromotionsWidgetRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/talabatcommon/feature/promotionWidget/model/request/PromotionsWidgetRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromotionsWidgetUseCase extends UseCase<PromotionsWidgetDisplayModel, PromotionsWidgetRequestModel> {
    @NotNull
    private final PromotionsWidgetRepository promotionsWidgetRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromotionsWidgetUseCase(@NotNull PromotionsWidgetRepository promotionsWidgetRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(promotionsWidgetRepository2, "promotionsWidgetRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.promotionsWidgetRepository = promotionsWidgetRepository2;
    }

    @Nullable
    public Object run(@NotNull PromotionsWidgetRequestModel promotionsWidgetRequestModel, @NotNull Continuation<? super Either<? extends Failure, PromotionsWidgetDisplayModel>> continuation) {
        return this.promotionsWidgetRepository.getPromotionData(promotionsWidgetRequestModel);
    }
}
