package com.talabat.offering.domain.usecases.business;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.offering.domain.entities.OTPData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/offering/domain/entities/OTPData;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase$invoke$2", f = "SendMobileOTPUseCase.kt", i = {}, l = {33, 34}, m = "invokeSuspend", n = {}, s = {})
public final class SendMobileOTPUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OTPData>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61126h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61127i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ConfigurationLocalRepository f61128j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61129k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f61130l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SendMobileOTPUseCase f61131m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendMobileOTPUseCase$invoke$2(String str, ConfigurationLocalRepository configurationLocalRepository, String str2, String str3, SendMobileOTPUseCase sendMobileOTPUseCase, Continuation<? super SendMobileOTPUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61127i = str;
        this.f61128j = configurationLocalRepository;
        this.f61129k = str2;
        this.f61130l = str3;
        this.f61131m = sendMobileOTPUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SendMobileOTPUseCase$invoke$2 sendMobileOTPUseCase$invoke$2 = new SendMobileOTPUseCase$invoke$2(this.f61127i, this.f61128j, this.f61129k, this.f61130l, this.f61131m, continuation);
        sendMobileOTPUseCase$invoke$2.L$0 = obj;
        return sendMobileOTPUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super OTPData> continuation) {
        return ((SendMobileOTPUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f61126h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x007f }
            goto L_0x0078
        L_0x0012:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x007f }
            goto L_0x0064
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.String r11 = r10.f61127i
            com.talabat.configuration.ConfigurationLocalRepository r1 = r10.f61128j
            java.lang.String r4 = r10.f61129k
            java.lang.String r5 = r10.f61130l
            com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase r6 = r10.f61131m
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x007f }
            com.talabat.offering.data.remote.dtos.VerificationInfoDto r7 = new com.talabat.offering.data.remote.dtos.VerificationInfoDto     // Catch:{ all -> 0x007f }
            r8 = 0
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch:{ all -> 0x007f }
            r7.<init>(r11, r9)     // Catch:{ all -> 0x007f }
            com.talabat.offering.data.remote.dtos.SendMobileOTPDto r11 = new com.talabat.offering.data.remote.dtos.SendMobileOTPDto     // Catch:{ all -> 0x007f }
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()     // Catch:{ all -> 0x007f }
            int r1 = r1.getCountryId()     // Catch:{ all -> 0x007f }
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)     // Catch:{ all -> 0x007f }
            r11.<init>(r1, r4, r7)     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x0054
            int r1 = r5.length()     // Catch:{ all -> 0x007f }
            if (r1 != 0) goto L_0x0055
        L_0x0054:
            r8 = r3
        L_0x0055:
            if (r8 == 0) goto L_0x0067
            com.talabat.offering.domain.repo.OfferCollectionRepo r1 = r6.offerCollectionRepo     // Catch:{ all -> 0x007f }
            r10.f61126h = r3     // Catch:{ all -> 0x007f }
            java.lang.Object r11 = r1.sendMobileOTP(r11, r10)     // Catch:{ all -> 0x007f }
            if (r11 != r0) goto L_0x0064
            return r0
        L_0x0064:
            com.talabat.offering.domain.entities.OTPData r11 = (com.talabat.offering.domain.entities.OTPData) r11     // Catch:{ all -> 0x007f }
            goto L_0x007a
        L_0x0067:
            com.talabat.offering.domain.repo.OfferCollectionRepo r11 = r6.offerCollectionRepo     // Catch:{ all -> 0x007f }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x007f }
            r10.f61126h = r2     // Catch:{ all -> 0x007f }
            java.lang.Object r11 = r11.resendMobileOTP(r1, r10)     // Catch:{ all -> 0x007f }
            if (r11 != r0) goto L_0x0078
            return r0
        L_0x0078:
            com.talabat.offering.domain.entities.OTPData r11 = (com.talabat.offering.domain.entities.OTPData) r11     // Catch:{ all -> 0x007f }
        L_0x007a:
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x007f }
            goto L_0x008a
        L_0x007f:
            r11 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x008a:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r11)
            if (r0 != 0) goto L_0x0091
            goto L_0x009f
        L_0x0091:
            com.talabat.offering.domain.entities.OTPData r11 = new com.talabat.offering.domain.entities.OTPData
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 31
            r8 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
        L_0x009f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.domain.usecases.business.SendMobileOTPUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
