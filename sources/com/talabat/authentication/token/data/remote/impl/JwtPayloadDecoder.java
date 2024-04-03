package com.talabat.authentication.token.data.remote.impl;

import android.util.Base64;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.token.data.model.JwtPayload;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R?\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/authentication/token/data/remote/impl/JwtPayloadDecoder;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/authentication/token/data/model/JwtPayload;", "kotlin.jvm.PlatformType", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "decodeJwtPayload", "", "encodedJwtPayload", "getEncodedJwtPayload", "accessToken", "invoke", "parseJwtPayload", "decodedJwtPayload", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JwtPayloadDecoder {
    @NotNull
    private final Lazy adapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new JwtPayloadDecoder$adapter$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final Moshi moshi;

    @Inject
    public JwtPayloadDecoder(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    private final String decodeJwtPayload(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            byte[] decode = Base64.decode(str, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decodedJwtPayloadBytes");
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            obj = Result.m6329constructorimpl(new String(decode, charset));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    private final JsonAdapter<JwtPayload> getAdapter() {
        return (JsonAdapter) this.adapter$delegate.getValue();
    }

    private final String getEncodedJwtPayload(String str) {
        return (String) CollectionsKt___CollectionsKt.getOrNull(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{RealDiscoveryConfigurationRepository.VERSION_DELIMETER}, false, 0, 6, (Object) null), 1);
    }

    private final JwtPayload parseJwtPayload(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(getAdapter().fromJson(str));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (JwtPayload) obj;
    }

    @Nullable
    public final JwtPayload invoke(@NotNull String str) {
        String decodeJwtPayload;
        Intrinsics.checkNotNullParameter(str, "accessToken");
        String encodedJwtPayload = getEncodedJwtPayload(str);
        if (encodedJwtPayload == null || (decodeJwtPayload = decodeJwtPayload(encodedJwtPayload)) == null) {
            return null;
        }
        return parseJwtPayload(decodeJwtPayload);
    }
}
