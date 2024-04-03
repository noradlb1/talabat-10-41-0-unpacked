package com.talabat.splash.data.remote;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.splash.data.model.SplashCampaign;
import com.talabat.splash.data.model.SplashConfiguration;
import com.talabat.splash.data.remote.dto.SplashCampaignDto;
import com.talabat.splash.data.remote.dto.SplashConfigurationDto;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.SplashRemoteConfigurationKeys;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/splash/data/remote/SplashConfigurationRemoteDataSource;", "", "configuration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "getSplashCampaign", "Lcom/talabat/splash/data/model/SplashCampaign;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSplashConfiguration", "Lcom/talabat/splash/data/model/SplashConfiguration;", "toSplashConfiguration", "dto", "Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashConfigurationRemoteDataSource {
    @NotNull
    private final RemoteConfiguration configuration;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SplashConfigurationDto.ScaleType.values().length];
            iArr[SplashConfigurationDto.ScaleType.SCALE_FILL.ordinal()] = 1;
            iArr[SplashConfigurationDto.ScaleType.CENTER.ordinal()] = 2;
            iArr[SplashConfigurationDto.ScaleType.ASPECT_FIT.ordinal()] = 3;
            iArr[SplashConfigurationDto.ScaleType.ASPECT_FILL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SplashConfigurationDto.ResourceType.values().length];
            iArr2[SplashConfigurationDto.ResourceType.IMAGE.ordinal()] = 1;
            iArr2[SplashConfigurationDto.ResourceType.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public SplashConfigurationRemoteDataSource(@NotNull RemoteConfiguration remoteConfiguration) {
        Intrinsics.checkNotNullParameter(remoteConfiguration, "configuration");
        this.configuration = remoteConfiguration;
    }

    /* access modifiers changed from: private */
    public final SplashConfiguration toSplashConfiguration(SplashConfigurationDto splashConfigurationDto) {
        int i11;
        SplashConfiguration.ScaleType scaleType;
        int i12;
        SplashConfiguration.ResourceType resourceType;
        String backgroundColor = splashConfigurationDto.getBackgroundColor();
        String str = "";
        if (backgroundColor == null) {
            backgroundColor = str;
        }
        SplashConfigurationDto.ScaleType scaleType2 = splashConfigurationDto.getScaleType();
        if (scaleType2 == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[scaleType2.ordinal()];
        }
        if (i11 == -1) {
            scaleType = SplashConfiguration.ScaleType.SCALE_FILL;
        } else if (i11 == 1) {
            scaleType = SplashConfiguration.ScaleType.SCALE_FILL;
        } else if (i11 == 2) {
            scaleType = SplashConfiguration.ScaleType.CENTER;
        } else if (i11 == 3) {
            scaleType = SplashConfiguration.ScaleType.ASPECT_FIT;
        } else if (i11 == 4) {
            scaleType = SplashConfiguration.ScaleType.ASPECT_FILL;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        SplashConfigurationDto.ResourceType resourceType2 = splashConfigurationDto.getResourceType();
        if (resourceType2 == null) {
            i12 = -1;
        } else {
            i12 = WhenMappings.$EnumSwitchMapping$1[resourceType2.ordinal()];
        }
        if (i12 == -1) {
            resourceType = SplashConfiguration.ResourceType.IMAGE;
        } else if (i12 == 1) {
            resourceType = SplashConfiguration.ResourceType.IMAGE;
        } else if (i12 == 2) {
            resourceType = SplashConfiguration.ResourceType.VIDEO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String resourcePath = splashConfigurationDto.getResourcePath();
        if (resourcePath != null) {
            str = resourcePath;
        }
        return new SplashConfiguration(backgroundColor, scaleType, resourceType, str);
    }

    @Nullable
    public final Object getSplashCampaign(@NotNull Continuation<? super SplashCampaign> continuation) {
        Object obj;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            Result.Companion companion = Result.Companion;
            this.configuration.getRemoteConfiguration((FWFKey) SplashRemoteConfigurationKeys.SPLASH_CAMPAIGN_LOGO, new SplashCampaignDto((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null), false, SplashCampaignDto.class, new SplashConfigurationRemoteDataSource$getSplashCampaign$2$1$1(safeContinuation));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            LogManager.error$default(r12, (String) null, 2, (Object) null);
            safeContinuation.resumeWith(Result.m6329constructorimpl((Object) null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object getSplashConfiguration(@NotNull Continuation<? super SplashConfiguration> continuation) {
        Object obj;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            Result.Companion companion = Result.Companion;
            this.configuration.getRemoteConfiguration((FWFKey) SplashRemoteConfigurationKeys.SPLASH_CONFIGURATION, new SplashConfigurationDto((String) null, (SplashConfigurationDto.ScaleType) null, (SplashConfigurationDto.ResourceType) null, (String) null, 15, (DefaultConstructorMarker) null), false, SplashConfigurationDto.class, new SplashConfigurationRemoteDataSource$getSplashConfiguration$2$1$1(safeContinuation, this));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            LogManager.error$default(r12, (String) null, 2, (Object) null);
            safeContinuation.resumeWith(Result.m6329constructorimpl((Object) null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
