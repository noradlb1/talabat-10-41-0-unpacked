package com.talabat.feature.ridertips.data;

import com.talabat.feature.ridertips.data.convert.IRiderTipResponseToRiderTipMapper;
import com.talabat.feature.ridertips.data.remote.RiderTipApi;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/ridertips/data/RiderTipRepository;", "Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "countryId", "", "riderTipApi", "Lcom/talabat/feature/ridertips/data/remote/RiderTipApi;", "riderTipResponseToRiderTipMapper", "Lcom/talabat/feature/ridertips/data/convert/IRiderTipResponseToRiderTipMapper;", "(ILcom/talabat/feature/ridertips/data/remote/RiderTipApi;Lcom/talabat/feature/ridertips/data/convert/IRiderTipResponseToRiderTipMapper;)V", "getRiderTip", "Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRiderTip", "", "riderTipValue", "", "removeTip", "", "(Ljava/lang/Double;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipRepository implements IRiderTipRepository {
    private final int countryId;
    @NotNull
    private final RiderTipApi riderTipApi;
    @NotNull
    private final IRiderTipResponseToRiderTipMapper riderTipResponseToRiderTipMapper;

    @Inject
    public RiderTipRepository(@Named("countryId") int i11, @NotNull RiderTipApi riderTipApi2, @NotNull IRiderTipResponseToRiderTipMapper iRiderTipResponseToRiderTipMapper) {
        Intrinsics.checkNotNullParameter(riderTipApi2, "riderTipApi");
        Intrinsics.checkNotNullParameter(iRiderTipResponseToRiderTipMapper, "riderTipResponseToRiderTipMapper");
        this.countryId = i11;
        this.riderTipApi = riderTipApi2;
        this.riderTipResponseToRiderTipMapper = iRiderTipResponseToRiderTipMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRiderTip(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.ridertips.domain.model.RiderTip> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.ridertips.data.RiderTipRepository$getRiderTip$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.ridertips.data.RiderTipRepository$getRiderTip$1 r0 = (com.talabat.feature.ridertips.data.RiderTipRepository$getRiderTip$1) r0
            int r1 = r0.f58792k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58792k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.ridertips.data.RiderTipRepository$getRiderTip$1 r0 = new com.talabat.feature.ridertips.data.RiderTipRepository$getRiderTip$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58790i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58792k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f58789h
            com.talabat.feature.ridertips.data.RiderTipRepository r0 = (com.talabat.feature.ridertips.data.RiderTipRepository) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0057 }
            com.talabat.feature.ridertips.data.remote.RiderTipApi r5 = r4.riderTipApi     // Catch:{ all -> 0x0057 }
            int r2 = r4.countryId     // Catch:{ all -> 0x0057 }
            r0.f58789h = r4     // Catch:{ all -> 0x0057 }
            r0.f58792k = r3     // Catch:{ all -> 0x0057 }
            java.lang.Object r5 = r5.getRiderTip(r2, r0)     // Catch:{ all -> 0x0057 }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            com.talabat.feature.ridertips.data.remote.dto.RiderTipResponse r5 = (com.talabat.feature.ridertips.data.remote.dto.RiderTipResponse) r5     // Catch:{ all -> 0x0057 }
            com.talabat.feature.ridertips.data.convert.IRiderTipResponseToRiderTipMapper r0 = r0.riderTipResponseToRiderTipMapper     // Catch:{ all -> 0x0057 }
            com.talabat.feature.ridertips.data.remote.dto.RiderTipDto r5 = r5.getResult()     // Catch:{ all -> 0x0057 }
            com.talabat.feature.ridertips.domain.model.RiderTip r5 = r0.map(r5)     // Catch:{ all -> 0x0057 }
            return r5
        L_0x0057:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r5 != 0) goto L_0x006e
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        L_0x006e:
            java.lang.Exception r5 = new java.lang.Exception
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.data.RiderTipRepository.getRiderTip(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object saveRiderTip(@org.jetbrains.annotations.Nullable java.lang.Double r6, boolean r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.talabat.feature.ridertips.data.RiderTipRepository$saveRiderTip$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.feature.ridertips.data.RiderTipRepository$saveRiderTip$1 r0 = (com.talabat.feature.ridertips.data.RiderTipRepository$saveRiderTip$1) r0
            int r1 = r0.f58795j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58795j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.ridertips.data.RiderTipRepository$saveRiderTip$1 r0 = new com.talabat.feature.ridertips.data.RiderTipRepository$saveRiderTip$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f58793h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58795j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0053 }
            goto L_0x004d
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0053 }
            com.talabat.feature.ridertips.data.remote.RiderTipApi r8 = r5.riderTipApi     // Catch:{ all -> 0x0053 }
            int r2 = r5.countryId     // Catch:{ all -> 0x0053 }
            com.talabat.feature.ridertips.data.remote.dto.RiderTipRequest r4 = new com.talabat.feature.ridertips.data.remote.dto.RiderTipRequest     // Catch:{ all -> 0x0053 }
            if (r7 == 0) goto L_0x0040
            r7 = r3
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            r4.<init>(r6, r7)     // Catch:{ all -> 0x0053 }
            r0.f58795j = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r6 = r8.saveRiderTip(r2, r4, r0)     // Catch:{ all -> 0x0053 }
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x005d
        L_0x0053:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            kotlin.Result.m6329constructorimpl(r6)
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.data.RiderTipRepository.saveRiderTip(java.lang.Double, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
