package com.talabat.features.swimlanevoucherslist.domain;

import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest;
import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/features/swimlanevoucherslist/domain/LoadCustomerVouchersSwimLaneUseCase;", "", "vouchersSwimLaneRepository", "Lcom/talabat/features/swimlanevoucherslist/domain/repository/CustomerVouchersSwimLaneRepository;", "(Lcom/talabat/features/swimlanevoucherslist/domain/repository/CustomerVouchersSwimLaneRepository;)V", "invoke", "Lio/reactivex/Single;", "", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "vouchersRequest", "Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;", "com_talabat_feature_customer-vouchers-swimlane_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadCustomerVouchersSwimLaneUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerVouchersSwimLaneRepository vouchersSwimLaneRepository;

    @Inject
    public LoadCustomerVouchersSwimLaneUseCase(@NotNull CustomerVouchersSwimLaneRepository customerVouchersSwimLaneRepository) {
        Intrinsics.checkNotNullParameter(customerVouchersSwimLaneRepository, "vouchersSwimLaneRepository");
        this.vouchersSwimLaneRepository = customerVouchersSwimLaneRepository;
    }

    @NotNull
    public final Single<List<CustomerVoucher>> invoke(@NotNull VouchersSwimLaneRequest vouchersSwimLaneRequest) {
        Intrinsics.checkNotNullParameter(vouchersSwimLaneRequest, "vouchersRequest");
        return RxSingleKt.rxSingle$default((CoroutineContext) null, new LoadCustomerVouchersSwimLaneUseCase$invoke$1(this, vouchersSwimLaneRequest, (Continuation<? super LoadCustomerVouchersSwimLaneUseCase$invoke$1>) null), 1, (Object) null);
    }
}
