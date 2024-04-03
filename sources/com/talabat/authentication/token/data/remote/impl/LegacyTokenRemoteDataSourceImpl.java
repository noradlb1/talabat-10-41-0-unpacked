package com.talabat.authentication.token.data.remote.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.authentication.token.data.model.SwapTokenData;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.SwapTokenRemoteDataException;
import com.talabat.authentication.token.data.remote.api.SwapTokenApi;
import com.talabat.authentication.token.data.remote.api.SwapTokenResponse;
import com.talabat.observability.ObservabilityManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import of.a;
import of.b;
import of.c;
import of.d;
import of.e;
import org.jetbrains.annotations.NotNull;
import p005if.f;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/authentication/token/data/remote/impl/LegacyTokenRemoteDataSourceImpl;", "Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "swapTokenApi", "Lcom/talabat/authentication/token/data/remote/api/SwapTokenApi;", "(Lcom/talabat/authentication/token/data/remote/api/SwapTokenApi;)V", "observe", "", "throwable", "", "swapToLegacyToken", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/SwapTokenData;", "tokenType", "", "accessToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyTokenRemoteDataSourceImpl implements LegacyTokenRemoteDataSource {
    @NotNull
    private final SwapTokenApi swapTokenApi;

    @Inject
    public LegacyTokenRemoteDataSourceImpl(@NotNull SwapTokenApi swapTokenApi2) {
        Intrinsics.checkNotNullParameter(swapTokenApi2, "swapTokenApi");
        this.swapTokenApi = swapTokenApi2;
    }

    /* access modifiers changed from: private */
    public final void observe(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("LegacyTokenRemoteDataSourceImpl", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    /* access modifiers changed from: private */
    /* renamed from: swapToLegacyToken$lambda-2  reason: not valid java name */
    public static final void m9526swapToLegacyToken$lambda2(LegacyTokenRemoteDataSourceImpl legacyTokenRemoteDataSourceImpl, String str, String str2, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(legacyTokenRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$tokenType");
        Intrinsics.checkNotNullParameter(str2, "$accessToken");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        SwapTokenApi swapTokenApi2 = legacyTokenRemoteDataSourceImpl.swapTokenApi;
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String capitalize = StringsKt__StringsJVMKt.capitalize(str, locale);
        singleEmitter.setDisposable(swapTokenApi2.swapToken(capitalize + " " + str2).map(new b()).doOnError(new c(legacyTokenRemoteDataSourceImpl)).onErrorResumeNext(new d()).subscribe(new e(singleEmitter), new f(singleEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: swapToLegacyToken$lambda-2$lambda-0  reason: not valid java name */
    public static final SwapTokenData m9527swapToLegacyToken$lambda2$lambda0(SwapTokenResponse swapTokenResponse) {
        Intrinsics.checkNotNullParameter(swapTokenResponse, "it");
        return new SwapTokenData(swapTokenResponse.getAccessToken(), swapTokenResponse.getExpiresIn(), swapTokenResponse.getTokenType());
    }

    /* access modifiers changed from: private */
    /* renamed from: swapToLegacyToken$lambda-2$lambda-1  reason: not valid java name */
    public static final SingleSource m9528swapToLegacyToken$lambda2$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.error((Throwable) new SwapTokenRemoteDataException((String) null, th2, 1, (DefaultConstructorMarker) null));
    }

    @NotNull
    public Single<SwapTokenData> swapToLegacyToken(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tokenType");
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        Single<SwapTokenData> create = Single.create(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n\n   …ter::setDisposable)\n    }");
        return create;
    }
}
