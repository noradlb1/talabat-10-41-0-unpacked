package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import library.talabat.mvp.home.IActiveVouchersUseCase;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ActiveVouchersUseCase;", "Llibrary/talabat/mvp/home/IActiveVouchersUseCase;", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "countryId", "", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveVouchersUseCase implements IActiveVouchersUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final VoucherStateDomainModel NO_ACTIVE_VOUCHERS = new VoucherStateDomainModel(0, "", VoucherNotificationStyle.NONE);
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final VoucherRepository voucherRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ActiveVouchersUseCase$Companion;", "", "()V", "NO_ACTIVE_VOUCHERS", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "getNO_ACTIVE_VOUCHERS", "()Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VoucherStateDomainModel getNO_ACTIVE_VOUCHERS() {
            return ActiveVouchersUseCase.NO_ACTIVE_VOUCHERS;
        }
    }

    @Inject
    public ActiveVouchersUseCase(@NotNull VoucherRepository voucherRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.voucherRepository = voucherRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    @NotNull
    public VoucherStateDomainModel invoke(int i11) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.voucherRepository.getVouchersState(i11));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            IObservabilityManager iObservabilityManager = this.observabilityManager;
            Pair[] pairArr = new Pair[2];
            String message = r12.getMessage();
            if (message == null) {
                message = StringUtils.empty(StringCompanionObject.INSTANCE);
            }
            pairArr[0] = TuplesKt.to("message", message);
            pairArr[1] = TuplesKt.to("countryId", String.valueOf(i11));
            iObservabilityManager.trackUnExpectedScenario("FailedToGetActiveVouchersCount", MapsKt__MapsKt.mapOf(pairArr));
            obj = NO_ACTIVE_VOUCHERS;
        }
        return (VoucherStateDomainModel) obj;
    }
}
