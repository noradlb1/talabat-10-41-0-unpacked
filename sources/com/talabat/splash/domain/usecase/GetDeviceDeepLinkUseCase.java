package com.talabat.splash.domain.usecase;

import com.talabat.splash.core.interactor.InternalUseCaseLiveSingleReturn;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.model.DeepLinkRedirectionWrapper;
import com.talabat.splash.domain.model.SplashDataUtils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetDeviceDeepLinkUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseLiveSingleReturn;", "Lcom/talabat/splash/domain/model/DeepLinkRedirectionWrapper;", "", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;)V", "DeepLinkFlowType", "deepLinkFlowType", "run", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDeviceDeepLinkUseCase extends InternalUseCaseLiveSingleReturn<DeepLinkRedirectionWrapper, Integer> {
    @NotNull
    private final SplashPreferences splashPreferences;

    @Inject
    public GetDeviceDeepLinkUseCase(@NotNull SplashPreferences splashPreferences2) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        this.splashPreferences = splashPreferences2;
    }

    private final int DeepLinkFlowType(int i11) {
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        splashDataUtils.getNORMAL_FLOW();
        if (this.splashPreferences.getIsEnableSplashWelcome()) {
            return splashDataUtils.getDIFFERED_DEEP_LINK();
        }
        if (i11 == splashDataUtils.getDIFFERED_DEEP_LINK()) {
            return splashDataUtils.getDIFFERED_DEEP_LINK();
        }
        return splashDataUtils.getNORMAL_DEEP_LINK();
    }

    public /* bridge */ /* synthetic */ Object run(Object obj) {
        return run(((Number) obj).intValue());
    }

    @NotNull
    public DeepLinkRedirectionWrapper run(int i11) {
        return new DeepLinkRedirectionWrapper(DeepLinkFlowType(i11));
    }
}
