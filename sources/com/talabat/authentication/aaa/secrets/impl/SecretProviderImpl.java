package com.talabat.authentication.aaa.secrets.impl;

import com.talabat.authentication.aaa.EndpointProvider;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.secrets.Secrets;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/aaa/secrets/impl/SecretProviderImpl;", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "secrets", "Lcom/talabat/secrets/Secrets;", "endPointProvider", "Lcom/talabat/authentication/aaa/EndpointProvider;", "buildType", "", "instrumentationTestingServer", "(Lcom/talabat/secrets/Secrets;Lcom/talabat/authentication/aaa/EndpointProvider;Ljava/lang/String;Ljava/lang/String;)V", "isProd", "", "()Z", "getClientSecret", "getDarkstoresAPIKey", "getGoogleApiKey", "getKey", "keyName", "getSubscriptionsKey", "getTMartAPIKey", "getTproSubscriptionProductId", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SecretProviderImpl implements SecretProvider {
    @NotNull
    public static final String BUILD_TYPE_RELEASE = "release";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TESTING_SERVER_PROD = "prod";
    @NotNull
    private final String buildType;
    @NotNull
    private final EndpointProvider endPointProvider;
    @NotNull
    private final String instrumentationTestingServer;
    @NotNull
    private final Secrets secrets;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/aaa/secrets/impl/SecretProviderImpl$Companion;", "", "()V", "BUILD_TYPE_RELEASE", "", "TESTING_SERVER_PROD", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndpointEnvironment.values().length];
            iArr[EndpointEnvironment.PRODUCTION.ordinal()] = 1;
            iArr[EndpointEnvironment.QA.ordinal()] = 2;
            iArr[EndpointEnvironment.MOCK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SecretProviderImpl(@NotNull Secrets secrets2, @NotNull EndpointProvider endpointProvider, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(secrets2, "secrets");
        Intrinsics.checkNotNullParameter(endpointProvider, "endPointProvider");
        Intrinsics.checkNotNullParameter(str, "buildType");
        Intrinsics.checkNotNullParameter(str2, "instrumentationTestingServer");
        this.secrets = secrets2;
        this.endPointProvider = endpointProvider;
        this.buildType = str;
        this.instrumentationTestingServer = str2;
    }

    private final boolean isProd() {
        return Intrinsics.areEqual((Object) this.instrumentationTestingServer, (Object) "prod") || Intrinsics.areEqual((Object) this.buildType, (Object) "release");
    }

    @NotNull
    public String getClientSecret() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.endPointProvider.getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            return this.secrets.getAaaClientSecretProd();
        }
        if (i11 == 2) {
            return this.secrets.getAaaClientSecretQa();
        }
        if (i11 == 3) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String getDarkstoresAPIKey() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.endPointProvider.getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            return this.secrets.getDarkstoresAPIProdKey();
        }
        if (i11 == 2) {
            return this.secrets.getDarkstoresAPIQaKey();
        }
        if (i11 == 3) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String getGoogleApiKey() {
        if (isProd()) {
            return this.secrets.getGoogleMapsKeyProd();
        }
        return this.secrets.getGoogleMapsKeyQa();
    }

    @Nullable
    public String getKey(@NotNull String str) {
        Map<String, Function0<String>> map;
        Intrinsics.checkNotNullParameter(str, "keyName");
        if (isProd()) {
            map = this.secrets.getKeysProd();
        } else {
            map = this.secrets.getKeysQA();
        }
        Function0 function0 = map.get(str);
        if (function0 != null) {
            return (String) function0.invoke();
        }
        return null;
    }

    @NotNull
    public String getSubscriptionsKey() {
        if (isProd()) {
            return this.secrets.getSubscriptionReleaseKey();
        }
        return this.secrets.getSubscriptionQAKey();
    }

    @NotNull
    public String getTMartAPIKey() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.endPointProvider.getEndpointEnvironment().ordinal()];
        if (i11 == 1) {
            return this.secrets.getTmartAPIKeyProd();
        }
        if (i11 == 2) {
            return this.secrets.getTmartAPIKeyQa();
        }
        if (i11 == 3) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String getTproSubscriptionProductId() {
        if (isProd()) {
            return this.secrets.getProSubscriptionProdProductI();
        }
        return this.secrets.getProSubscriptionQAProductId();
    }
}
