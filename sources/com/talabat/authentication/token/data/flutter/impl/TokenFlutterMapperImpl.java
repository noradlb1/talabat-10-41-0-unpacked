package com.talabat.authentication.token.data.flutter.impl;

import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.domain.model.Token;
import com.tekartik.sqflite.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/authentication/token/data/flutter/impl/TokenFlutterMapperImpl;", "Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "()V", "fromMap", "Lcom/talabat/authentication/token/domain/model/Token;", "arguments", "", "", "", "toMap", "token", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenFlutterMapperImpl implements TokenFlutterMapper {
    @NotNull
    public Token fromMap(@NotNull Map<String, ? extends Object> map) {
        long j11;
        String obj;
        Long longOrNull;
        String obj2;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(map, Constant.PARAM_SQL_ARGUMENTS);
        String valueOf = String.valueOf(map.get("refreshToken"));
        String valueOf2 = String.valueOf(map.get("accessToken"));
        Object obj3 = map.get("expiresIn");
        long j12 = 0;
        if (obj3 == null || (obj2 = obj3.toString()) == null || (longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(obj2)) == null) {
            j11 = 0;
        } else {
            j11 = longOrNull2.longValue();
        }
        String valueOf3 = String.valueOf(map.get("tokenType"));
        String valueOf4 = String.valueOf(map.get("scope"));
        Object obj4 = map.get("timeDifference");
        if (!(obj4 == null || (obj = obj4.toString()) == null || (longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(obj)) == null)) {
            j12 = longOrNull.longValue();
        }
        return new Token(valueOf, valueOf2, j11, valueOf3, valueOf4, j12);
    }

    @NotNull
    public Map<String, Object> toMap(@NotNull Token token) {
        Intrinsics.checkNotNullParameter(token, LegacyTokenLocalDataSourceImpl.KEY);
        return MapsKt__MapsKt.mapOf(TuplesKt.to("refreshToken", token.getRefreshToken()), TuplesKt.to("accessToken", token.getAccessToken()), TuplesKt.to("expiresIn", Long.valueOf(token.getExpiresIn())), TuplesKt.to("tokenType", token.getTokenType()), TuplesKt.to("scope", token.getScope()), TuplesKt.to("timeDifference", Long.valueOf(token.getTimeDifference())));
    }
}
