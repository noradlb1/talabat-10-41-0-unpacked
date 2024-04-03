package com.talabat.feature.ridertips.domain.usecases;

import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/feature/ridertips/domain/usecases/GetRiderTipUseCase;", "", "repository", "Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "(Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;)V", "getRiderTip", "Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetRiderTipUseCase {
    @NotNull
    private final IRiderTipRepository repository;

    @Inject
    public GetRiderTipUseCase(@NotNull IRiderTipRepository iRiderTipRepository) {
        Intrinsics.checkNotNullParameter(iRiderTipRepository, "repository");
        this.repository = iRiderTipRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRiderTip(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.ridertips.domain.model.RiderTip> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase$getRiderTip$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase$getRiderTip$1 r0 = (com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase$getRiderTip$1) r0
            int r1 = r0.f58798j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58798j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase$getRiderTip$1 r0 = new com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase$getRiderTip$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58796h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58798j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0042 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0042 }
            com.talabat.feature.ridertips.domain.IRiderTipRepository r5 = r4.repository     // Catch:{ all -> 0x0042 }
            r0.f58798j = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r5 = r5.getRiderTip(r0)     // Catch:{ all -> 0x0042 }
            if (r5 != r1) goto L_0x0041
            return r1
        L_0x0041:
            return r5
        L_0x0042:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 != 0) goto L_0x0059
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L_0x0059:
            java.lang.Exception r5 = new java.lang.Exception
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase.getRiderTip(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
