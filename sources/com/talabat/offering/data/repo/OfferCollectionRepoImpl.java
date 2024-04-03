package com.talabat.offering.data.repo;

import com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/talabat/offering/data/repo/OfferCollectionRepoImpl;", "Lcom/talabat/offering/domain/repo/OfferCollectionRepo;", "offerCollectionRemoteDataSource", "Lcom/talabat/offering/data/remote/datasoures/OfferCollectionRemoteDataSource;", "(Lcom/talabat/offering/data/remote/datasoures/OfferCollectionRemoteDataSource;)V", "getIsOfferCollectionSubscribed", "", "productId", "", "subscriptionCountryCode", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfferCollection", "Lcom/talabat/offering/domain/entities/OfferCollection;", "collectionId", "lat", "", "lon", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendMobileOTP", "Lcom/talabat/offering/domain/entities/OTPData;", "requestId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMobileOTP", "sendMobileOTPDto", "Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;", "(Lcom/talabat/offering/data/remote/dtos/SendMobileOTPDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOTP", "otpCode", "Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;", "(Ljava/lang/String;Lcom/talabat/offering/data/remote/dtos/OTPCodeModelDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionRepoImpl implements OfferCollectionRepo {
    @NotNull
    private final OfferCollectionRemoteDataSource offerCollectionRemoteDataSource;

    public OfferCollectionRepoImpl(@NotNull OfferCollectionRemoteDataSource offerCollectionRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(offerCollectionRemoteDataSource2, "offerCollectionRemoteDataSource");
        this.offerCollectionRemoteDataSource = offerCollectionRemoteDataSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getIsOfferCollectionSubscribed(@org.jetbrains.annotations.NotNull java.lang.String r6, int r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.talabat.offering.data.repo.OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1 r0 = (com.talabat.offering.data.repo.OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1) r0
            int r1 = r0.f61101k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61101k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1 r0 = new com.talabat.offering.data.repo.OfferCollectionRepoImpl$getIsOfferCollectionSubscribed$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f61099i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61101k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f61098h
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r6 = (com.talabat.offering.domain.entities.mapper.OfferCollectionMapper) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r8 = com.talabat.offering.domain.entities.mapper.OfferCollectionMapper.INSTANCE
            com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource r2 = r5.offerCollectionRemoteDataSource
            r0.f61098h = r8
            r0.f61101k = r3
            java.lang.Object r6 = r2.getIsOfferCollectionSubscribed(r6, r7, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r8
            r8 = r6
            r6 = r4
        L_0x004a:
            com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto r8 = (com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto) r8
            boolean r6 = r6.mapUserCollectionOfferStatus(r8)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.repo.OfferCollectionRepoImpl.getIsOfferCollectionSubscribed(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getOfferCollection(int r10, double r11, double r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.offering.domain.entities.OfferCollection> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof com.talabat.offering.data.repo.OfferCollectionRepoImpl$getOfferCollection$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$getOfferCollection$1 r0 = (com.talabat.offering.data.repo.OfferCollectionRepoImpl$getOfferCollection$1) r0
            int r1 = r0.f61105k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61105k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$getOfferCollection$1 r0 = new com.talabat.offering.data.repo.OfferCollectionRepoImpl$getOfferCollection$1
            r0.<init>(r9, r15)
        L_0x0018:
            r7 = r0
            java.lang.Object r15 = r7.f61103i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f61105k
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r10 = r7.f61102h
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r10 = (com.talabat.offering.domain.entities.mapper.OfferCollectionMapper) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r15)
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r15 = com.talabat.offering.domain.entities.mapper.OfferCollectionMapper.INSTANCE
            com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource r1 = r9.offerCollectionRemoteDataSource
            r7.f61102h = r15
            r7.f61105k = r2
            r2 = r10
            r3 = r11
            r5 = r13
            java.lang.Object r10 = r1.getOfferCollection(r2, r3, r5, r7)
            if (r10 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r8 = r15
            r15 = r10
            r10 = r8
        L_0x004e:
            com.talabat.offering.data.remote.dtos.OfferCollectionDto r15 = (com.talabat.offering.data.remote.dtos.OfferCollectionDto) r15
            com.talabat.offering.domain.entities.OfferCollection r10 = r10.mapOffer(r15)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.repo.OfferCollectionRepoImpl.getOfferCollection(int, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object resendMobileOTP(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.offering.domain.entities.OTPData> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.offering.data.repo.OfferCollectionRepoImpl$resendMobileOTP$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$resendMobileOTP$1 r0 = (com.talabat.offering.data.repo.OfferCollectionRepoImpl$resendMobileOTP$1) r0
            int r1 = r0.f61109k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61109k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$resendMobileOTP$1 r0 = new com.talabat.offering.data.repo.OfferCollectionRepoImpl$resendMobileOTP$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f61107i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61109k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f61106h
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r6 = (com.talabat.offering.domain.entities.mapper.OfferCollectionMapper) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r7 = com.talabat.offering.domain.entities.mapper.OfferCollectionMapper.INSTANCE
            com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource r2 = r5.offerCollectionRemoteDataSource
            r0.f61106h = r7
            r0.f61109k = r3
            java.lang.Object r6 = r2.resendMobileOTP(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x004a:
            com.talabat.offering.data.remote.dtos.OTPResponseDto r7 = (com.talabat.offering.data.remote.dtos.OTPResponseDto) r7
            com.talabat.offering.domain.entities.OTPData r6 = r6.mapOTPData(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.repo.OfferCollectionRepoImpl.resendMobileOTP(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendMobileOTP(@org.jetbrains.annotations.NotNull com.talabat.offering.data.remote.dtos.SendMobileOTPDto r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.offering.domain.entities.OTPData> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.offering.data.repo.OfferCollectionRepoImpl$sendMobileOTP$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$sendMobileOTP$1 r0 = (com.talabat.offering.data.repo.OfferCollectionRepoImpl$sendMobileOTP$1) r0
            int r1 = r0.f61113k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61113k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$sendMobileOTP$1 r0 = new com.talabat.offering.data.repo.OfferCollectionRepoImpl$sendMobileOTP$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f61111i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61113k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f61110h
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r6 = (com.talabat.offering.domain.entities.mapper.OfferCollectionMapper) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r7 = com.talabat.offering.domain.entities.mapper.OfferCollectionMapper.INSTANCE
            com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource r2 = r5.offerCollectionRemoteDataSource
            r0.f61110h = r7
            r0.f61113k = r3
            java.lang.Object r6 = r2.sendMobileOTP(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x004a:
            com.talabat.offering.data.remote.dtos.OTPResponseDto r7 = (com.talabat.offering.data.remote.dtos.OTPResponseDto) r7
            com.talabat.offering.domain.entities.OTPData r6 = r6.mapOTPData(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.repo.OfferCollectionRepoImpl.sendMobileOTP(com.talabat.offering.data.remote.dtos.SendMobileOTPDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object verifyOTP(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull com.talabat.offering.data.remote.dtos.OTPCodeModelDto r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.offering.domain.entities.OTPData> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.talabat.offering.data.repo.OfferCollectionRepoImpl$verifyOTP$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$verifyOTP$1 r0 = (com.talabat.offering.data.repo.OfferCollectionRepoImpl$verifyOTP$1) r0
            int r1 = r0.f61117k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61117k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.offering.data.repo.OfferCollectionRepoImpl$verifyOTP$1 r0 = new com.talabat.offering.data.repo.OfferCollectionRepoImpl$verifyOTP$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f61115i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61117k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f61114h
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r6 = (com.talabat.offering.domain.entities.mapper.OfferCollectionMapper) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.offering.domain.entities.mapper.OfferCollectionMapper r8 = com.talabat.offering.domain.entities.mapper.OfferCollectionMapper.INSTANCE
            com.talabat.offering.data.remote.datasoures.OfferCollectionRemoteDataSource r2 = r5.offerCollectionRemoteDataSource
            r0.f61114h = r8
            r0.f61117k = r3
            java.lang.Object r6 = r2.verifyOTP(r6, r7, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r8
            r8 = r6
            r6 = r4
        L_0x004a:
            com.talabat.offering.data.remote.dtos.OTPResponseDto r8 = (com.talabat.offering.data.remote.dtos.OTPResponseDto) r8
            com.talabat.offering.domain.entities.OTPData r6 = r6.mapOTPVerificationResult(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.repo.OfferCollectionRepoImpl.verifyOTP(java.lang.String, com.talabat.offering.data.remote.dtos.OTPCodeModelDto, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
