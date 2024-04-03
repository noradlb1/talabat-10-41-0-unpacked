package com.talabat.wallet.bnplmanager.data.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.data.remote.BNPLManagerRemoteDataSource;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentsRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.response.BNPLOrderPaymentRemoteDto;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\u0011\u0010\"\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010+R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/impl/BNPLManagerRepositoryImpl;", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "bNPLManagerRemoteDataSource", "Lcom/talabat/wallet/bnplmanager/data/remote/BNPLManagerRemoteDataSource;", "bNPLManagerLocalDataSource", "Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;", "context", "Landroid/content/Context;", "(Lcom/talabat/wallet/bnplmanager/data/remote/BNPLManagerRemoteDataSource;Lcom/talabat/wallet/bnplmanager/data/local/BNPLManagerLocalDataSource;Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLEligibilityStatusFromLocal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLInstallments", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentsRemoteDto;", "bNPLInstallmentRequestModel", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLPlans", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBnplTrackingStatus", "", "getIsUserSeenBnplPaymentFallbackOption", "payOrderWithBNPL", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/response/BNPLOrderPaymentRemoteDto;", "bNPLOrderPaymentRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/request/BNPLOrderPaymentRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setIsUserSeenBnplPaymentFallbackOption", "", "seen", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLManagerRepositoryImpl implements BNPLManagerRepository {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String EXPERIMENT_VERSION = "experiment_version";
    @NotNull
    @Deprecated
    public static final String VERSION_NUMBER = "2.0";
    @NotNull
    private final BNPLManagerLocalDataSource bNPLManagerLocalDataSource;
    @NotNull
    private final BNPLManagerRemoteDataSource bNPLManagerRemoteDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final Lazy sharedPreferences$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new BNPLManagerRepositoryImpl$sharedPreferences$2(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/impl/BNPLManagerRepositoryImpl$Companion;", "", "()V", "EXPERIMENT_VERSION", "", "VERSION_NUMBER", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLManagerRepositoryImpl(@NotNull BNPLManagerRemoteDataSource bNPLManagerRemoteDataSource2, @NotNull BNPLManagerLocalDataSource bNPLManagerLocalDataSource2, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(bNPLManagerRemoteDataSource2, "bNPLManagerRemoteDataSource");
        Intrinsics.checkNotNullParameter(bNPLManagerLocalDataSource2, "bNPLManagerLocalDataSource");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.bNPLManagerRemoteDataSource = bNPLManagerRemoteDataSource2;
        this.bNPLManagerLocalDataSource = bNPLManagerLocalDataSource2;
        this.context = context2;
    }

    private final SharedPreferences getSharedPreferences() {
        Object value = this.sharedPreferences$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getBNPLEligibilityStatus(@org.jetbrains.annotations.NotNull com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1 r0 = (com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1) r0
            int r1 = r0.f12459k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12459k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1 r0 = new com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl$getBNPLEligibilityStatus$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12457i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12459k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.f12456h
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0060
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            java.lang.Object r6 = r0.f12456h
            com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl r6 = (com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.wallet.bnplmanager.data.remote.BNPLManagerRemoteDataSource r7 = r5.bNPLManagerRemoteDataSource
            r0.f12456h = r5
            r0.f12459k = r4
            java.lang.Object r7 = r7.getBNPLEligibilityStatus(r6, r0)
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r6 = r5
        L_0x004f:
            r2 = r7
            com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto r2 = (com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto) r2
            com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource r6 = r6.bNPLManagerLocalDataSource
            r0.f12456h = r7
            r0.f12459k = r3
            java.lang.Object r6 = r6.setBNPLEligibilityStatus(r2, r0)
            if (r6 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r6 = r7
        L_0x0060:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.bnplmanager.data.impl.BNPLManagerRepositoryImpl.getBNPLEligibilityStatus(com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object getBNPLEligibilityStatusFromLocal(@NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation) {
        return this.bNPLManagerLocalDataSource.getBNPLEligibilityStatus(continuation);
    }

    @Nullable
    public Object getBNPLInstallments(@NotNull BNPLInstallmentRequestModel bNPLInstallmentRequestModel, @NotNull Continuation<? super BNPLInstallmentsRemoteDto> continuation) {
        return this.bNPLManagerRemoteDataSource.getBNPLInstallments(bNPLInstallmentRequestModel, continuation);
    }

    @Nullable
    public Object getBNPLPlans(int i11, @NotNull Continuation<? super BNPLPlansRemoteDto> continuation) {
        return this.bNPLManagerRemoteDataSource.getBNPLPlans(i11, continuation);
    }

    public boolean getBnplTrackingStatus() {
        return Intrinsics.areEqual((Object) getSharedPreferences().getString(EXPERIMENT_VERSION, StringUtils.empty(StringCompanionObject.INSTANCE)), (Object) VERSION_NUMBER);
    }

    @Nullable
    public Object getIsUserSeenBnplPaymentFallbackOption(@NotNull Continuation<? super Boolean> continuation) {
        return this.bNPLManagerLocalDataSource.getIsUserSeenBnplPaymentFallbackOption(continuation);
    }

    @Nullable
    public Object payOrderWithBNPL(@NotNull BNPLOrderPaymentRequestDto bNPLOrderPaymentRequestDto, @NotNull Continuation<? super BNPLOrderPaymentRemoteDto> continuation) {
        return this.bNPLManagerRemoteDataSource.payOrderWithBNPL(bNPLOrderPaymentRequestDto, continuation);
    }

    @Nullable
    public Object setIsUserSeenBnplPaymentFallbackOption(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object isUserSeenBnplPaymentFallbackOption = this.bNPLManagerLocalDataSource.setIsUserSeenBnplPaymentFallbackOption(z11, continuation);
        return isUserSeenBnplPaymentFallbackOption == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? isUserSeenBnplPaymentFallbackOption : Unit.INSTANCE;
    }
}
