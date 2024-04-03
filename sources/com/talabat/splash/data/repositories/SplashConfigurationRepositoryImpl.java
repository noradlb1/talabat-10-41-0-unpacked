package com.talabat.splash.data.repositories;

import com.talabat.splash.data.model.SplashConfiguration;
import com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/splash/data/repositories/SplashConfigurationRepositoryImpl;", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository;", "splashConfigurationRemoteDataSource", "Lcom/talabat/splash/data/remote/SplashConfigurationRemoteDataSource;", "(Lcom/talabat/splash/data/remote/SplashConfigurationRemoteDataSource;)V", "getCampaign", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashCampaign;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfiguration", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration;", "toAvailableConfiguration", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration;", "it", "Lcom/talabat/splash/data/model/SplashConfiguration;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashConfigurationRepositoryImpl implements SplashConfigurationRepository {
    @NotNull
    private final SplashConfigurationRemoteDataSource splashConfigurationRemoteDataSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SplashConfiguration.ScaleType.values().length];
            iArr[SplashConfiguration.ScaleType.SCALE_FILL.ordinal()] = 1;
            iArr[SplashConfiguration.ScaleType.CENTER.ordinal()] = 2;
            iArr[SplashConfiguration.ScaleType.ASPECT_FIT.ordinal()] = 3;
            iArr[SplashConfiguration.ScaleType.ASPECT_FILL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SplashConfiguration.ResourceType.values().length];
            iArr2[SplashConfiguration.ResourceType.IMAGE.ordinal()] = 1;
            iArr2[SplashConfiguration.ResourceType.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public SplashConfigurationRepositoryImpl(@NotNull SplashConfigurationRemoteDataSource splashConfigurationRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(splashConfigurationRemoteDataSource2, "splashConfigurationRemoteDataSource");
        this.splashConfigurationRemoteDataSource = splashConfigurationRemoteDataSource2;
    }

    private final SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration toAvailableConfiguration(SplashConfiguration splashConfiguration) {
        SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType scaleType;
        SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType resourceType;
        String backgroundColor = splashConfiguration.getBackgroundColor();
        int i11 = WhenMappings.$EnumSwitchMapping$0[splashConfiguration.getScaleType().ordinal()];
        if (i11 == 1) {
            scaleType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.SCALE_FILL;
        } else if (i11 == 2) {
            scaleType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.CENTER;
        } else if (i11 == 3) {
            scaleType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.ASPECT_FIT;
        } else if (i11 == 4) {
            scaleType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ScaleType.ASPECT_FILL;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i12 = WhenMappings.$EnumSwitchMapping$1[splashConfiguration.getResourceType().ordinal()];
        if (i12 == 1) {
            resourceType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType.IMAGE;
        } else if (i12 == 2) {
            resourceType = SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration.ResourceType.VIDEO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new SplashConfigurationRepository.SplashConfiguration.AvailableConfiguration(backgroundColor, scaleType, resourceType, splashConfiguration.getResourcePath());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCampaign(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getCampaign$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getCampaign$1 r0 = (com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getCampaign$1) r0
            int r1 = r0.f61459j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61459j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getCampaign$1 r0 = new com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getCampaign$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61457h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61459j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource r6 = r5.splashConfigurationRemoteDataSource     // Catch:{ all -> 0x0048 }
            r0.f61459j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = r6.getSplashCampaign(r0)     // Catch:{ all -> 0x0048 }
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.talabat.splash.data.model.SplashCampaign r6 = (com.talabat.splash.data.model.SplashCampaign) r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r6 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0053:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x008f
            com.talabat.splash.data.model.SplashCampaign r6 = (com.talabat.splash.data.model.SplashCampaign) r6
            if (r6 == 0) goto L_0x008c
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$AvailableCampaign r0 = new com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$AvailableCampaign
            java.lang.String r1 = r6.getTitle()
            java.lang.String r2 = r6.getImagePath()
            java.lang.String r3 = r6.getImageWidth()
            java.lang.Float r3 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r3)
            r4 = -1
            if (r3 == 0) goto L_0x0078
            float r3 = r3.floatValue()
            int r3 = (int) r3
            goto L_0x0079
        L_0x0078:
            r3 = r4
        L_0x0079:
            java.lang.String r6 = r6.getImageHeight()
            java.lang.Float r6 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r6)
            if (r6 == 0) goto L_0x0088
            float r6 = r6.floatValue()
            int r4 = (int) r6
        L_0x0088:
            r0.<init>(r1, r2, r3, r4)
            goto L_0x0096
        L_0x008c:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$NotAvailable r0 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign.NotAvailable.INSTANCE
            goto L_0x0096
        L_0x008f:
            r6 = 2
            r1 = 0
            com.talabat.talabatcore.logger.LogManager.error$default(r0, r1, r6, r1)
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashCampaign$NotAvailable r0 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashCampaign.NotAvailable.INSTANCE
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl.getCampaign(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getConfiguration(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getConfiguration$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getConfiguration$1 r0 = (com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getConfiguration$1) r0
            int r1 = r0.f61463k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61463k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getConfiguration$1 r0 = new com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl$getConfiguration$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f61461i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61463k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f61460h
            com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl r0 = (com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r5 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource r5 = r4.splashConfigurationRemoteDataSource     // Catch:{ all -> 0x0051 }
            r0.f61460h = r4     // Catch:{ all -> 0x0051 }
            r0.f61463k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r5 = r5.getSplashConfiguration(r0)     // Catch:{ all -> 0x0051 }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            com.talabat.splash.data.model.SplashConfiguration r5 = (com.talabat.splash.data.model.SplashConfiguration) r5     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r5 = move-exception
            r0 = r4
        L_0x0053:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x005d:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r1 != 0) goto L_0x0071
            com.talabat.splash.data.model.SplashConfiguration r5 = (com.talabat.splash.data.model.SplashConfiguration) r5
            if (r5 == 0) goto L_0x006e
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration$AvailableConfiguration r5 = r0.toAvailableConfiguration(r5)
            if (r5 == 0) goto L_0x006e
            goto L_0x0078
        L_0x006e:
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration$NotAvailable r5 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration.NotAvailable.INSTANCE
            goto L_0x0078
        L_0x0071:
            java.lang.String r5 = "Could not retrieve Splash Configurations"
            com.talabat.talabatcore.logger.LogManager.error(r1, r5)
            com.talabat.splash.domain.repository.SplashConfigurationRepository$SplashConfiguration$NotAvailable r5 = com.talabat.splash.domain.repository.SplashConfigurationRepository.SplashConfiguration.NotAvailable.INSTANCE
        L_0x0078:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl.getConfiguration(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
