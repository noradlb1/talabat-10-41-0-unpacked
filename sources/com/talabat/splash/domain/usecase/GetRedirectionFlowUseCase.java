package com.talabat.splash.domain.usecase;

import com.facebook.internal.NativeProtocol;
import com.talabat.splash.core.interactor.InternalUseCaseLiveSingleReturn;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetRedirectionFlowUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseLiveSingleReturn;", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "Lcom/talabat/splash/domain/usecase/GetRedirectionFlowUseCase$Parameters;", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;)V", "run", "params", "splashRedirectionType", "Lkotlin/Pair;", "", "", "deepLinkFlowType", "Parameters", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetRedirectionFlowUseCase extends InternalUseCaseLiveSingleReturn<SplashRedirectionWrapper, Parameters> {
    @NotNull
    private final SplashPreferences splashPreferences;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetRedirectionFlowUseCase$Parameters;", "", "deepLinkFlowType", "", "deepLinkQuery", "", "(ILjava/lang/String;)V", "getDeepLinkFlowType", "()I", "getDeepLinkQuery", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Parameters {
        private final int deepLinkFlowType;
        @NotNull
        private final String deepLinkQuery;

        public Parameters(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "deepLinkQuery");
            this.deepLinkFlowType = i11;
            this.deepLinkQuery = str;
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, int i11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = parameters.deepLinkFlowType;
            }
            if ((i12 & 2) != 0) {
                str = parameters.deepLinkQuery;
            }
            return parameters.copy(i11, str);
        }

        public final int component1() {
            return this.deepLinkFlowType;
        }

        @NotNull
        public final String component2() {
            return this.deepLinkQuery;
        }

        @NotNull
        public final Parameters copy(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "deepLinkQuery");
            return new Parameters(i11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parameters)) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return this.deepLinkFlowType == parameters.deepLinkFlowType && Intrinsics.areEqual((Object) this.deepLinkQuery, (Object) parameters.deepLinkQuery);
        }

        public final int getDeepLinkFlowType() {
            return this.deepLinkFlowType;
        }

        @NotNull
        public final String getDeepLinkQuery() {
            return this.deepLinkQuery;
        }

        public int hashCode() {
            return (this.deepLinkFlowType * 31) + this.deepLinkQuery.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.deepLinkFlowType;
            String str = this.deepLinkQuery;
            return "Parameters(deepLinkFlowType=" + i11 + ", deepLinkQuery=" + str + ")";
        }
    }

    @Inject
    public GetRedirectionFlowUseCase(@NotNull SplashPreferences splashPreferences2) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        this.splashPreferences = splashPreferences2;
    }

    private final Pair<Boolean, Integer> splashRedirectionType(int i11) {
        Boolean bool = Boolean.TRUE;
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        new Pair(bool, Integer.valueOf(splashDataUtils.getNORMAL_FLOW()));
        boolean isEnableSplashWelcome = this.splashPreferences.getIsEnableSplashWelcome();
        if (i11 > 0) {
            if (i11 != splashDataUtils.getDIFFERED_DEEP_LINK()) {
                return new Pair<>(bool, Integer.valueOf(splashDataUtils.getDEEP_LINK_FLOW()));
            }
            if (isEnableSplashWelcome) {
                return new Pair<>(Boolean.FALSE, Integer.valueOf(splashDataUtils.getDIFFERED_DEEP_LINK_WITH_WELCOME()));
            }
            return new Pair<>(bool, Integer.valueOf(splashDataUtils.getDIFFERED_DEEP_LINK_FLOW()));
        } else if (isEnableSplashWelcome) {
            return new Pair<>(Boolean.FALSE, Integer.valueOf(splashDataUtils.getNORMAL_WELCOME_FLOW()));
        } else {
            return new Pair<>(bool, Integer.valueOf(splashDataUtils.getNORMAL_FLOW()));
        }
    }

    @NotNull
    public SplashRedirectionWrapper run(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, NativeProtocol.WEB_DIALOG_PARAMS);
        Pair<Boolean, Integer> splashRedirectionType = splashRedirectionType(parameters.getDeepLinkFlowType());
        return new SplashRedirectionWrapper(splashRedirectionType.getFirst().booleanValue(), splashRedirectionType.getSecond().intValue());
    }
}
