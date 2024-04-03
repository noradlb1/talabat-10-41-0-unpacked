package com.talabat.authentication.token.data.local.impl;

import android.content.SharedPreferences;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.local.model.TokenLocal;
import com.talabat.authentication.token.domain.model.Token;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.registration.RegistrationInteractor;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R?\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl;", "Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "encryptedStorageProvider", "Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;", "moshi", "Lcom/squareup/moshi/Moshi;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;Lcom/squareup/moshi/Moshi;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "deviceToken", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "tokenLocalJsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/authentication/token/data/local/model/TokenLocal;", "kotlin.jvm.PlatformType", "getTokenLocalJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "tokenLocalJsonAdapter$delegate", "clearToken", "", "getDeviceToken", "getToken", "readDeviceToken", "readToken", "setToken", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenLocalDataSourceImpl implements TokenLocalDataSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY_DEVICE_TOKEN = "deviceIdkey";
    @NotNull
    @Deprecated
    public static final String KEY_TOKEN = "tknkey";
    @NotNull
    @Deprecated
    public static final String PREFERENCE = "tkn";
    @Nullable
    private volatile String deviceToken;
    /* access modifiers changed from: private */
    @NotNull
    public final EncryptedStorageProvider encryptedStorageProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final Moshi moshi;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final Lazy sharedPreferences$delegate;
    @Nullable
    private volatile Token token;
    @NotNull
    private final Lazy tokenLocalJsonAdapter$delegate;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\n\u0010\u0010\u001a\u00020\u0004*\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl$Companion;", "", "()V", "KEY_DEVICE_TOKEN", "", "KEY_TOKEN", "PREFERENCE", "onSecureStorageFailed", "", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "operation", "Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl$Companion$Operation;", "tokenType", "Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl$Companion$TokenType;", "e", "", "toAttributeString", "Operation", "TokenType", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl$Companion$Operation;", "", "(Ljava/lang/String;I)V", "READ", "WRITE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum Operation {
            READ,
            WRITE
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/TokenLocalDataSourceImpl$Companion$TokenType;", "", "(Ljava/lang/String;I)V", "JWT", "DEVICE", "JWT_DEVICE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum TokenType {
            JWT,
            DEVICE,
            JWT_DEVICE
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[Operation.values().length];
                iArr[Operation.READ.ordinal()] = 1;
                iArr[Operation.WRITE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[TokenType.values().length];
                iArr2[TokenType.JWT.ordinal()] = 1;
                iArr2[TokenType.DEVICE.ordinal()] = 2;
                iArr2[TokenType.JWT_DEVICE.ordinal()] = 3;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onSecureStorageFailed(@NotNull IObservabilityManager iObservabilityManager, @NotNull Operation operation, @NotNull TokenType tokenType, @NotNull Throwable th2) {
            String str;
            Intrinsics.checkNotNullParameter(iObservabilityManager, "<this>");
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(tokenType, "tokenType");
            Intrinsics.checkNotNullParameter(th2, "e");
            int i11 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
            if (i11 == 1) {
                str = "read_from_keychain_failed";
            } else if (i11 == 2) {
                str = "save_to_keychain_failed";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            String simpleName = th2.getClass().getSimpleName();
            String message = th2.getMessage();
            iObservabilityManager.trackEvent(str, RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android"), TuplesKt.to("message", simpleName + "::" + message), TuplesKt.to("tokenType", toAttributeString(tokenType))));
        }

        @NotNull
        public final String toAttributeString(@NotNull TokenType tokenType) {
            Intrinsics.checkNotNullParameter(tokenType, "<this>");
            int i11 = WhenMappings.$EnumSwitchMapping$1[tokenType.ordinal()];
            if (i11 == 1) {
                return "jwt";
            }
            if (i11 == 2) {
                return "device";
            }
            if (i11 == 3) {
                return "jwt+device";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public TokenLocalDataSourceImpl(@NotNull EncryptedStorageProvider encryptedStorageProvider2, @NotNull Moshi moshi2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(encryptedStorageProvider2, "encryptedStorageProvider");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.encryptedStorageProvider = encryptedStorageProvider2;
        this.moshi = moshi2;
        this.observabilityManager = iObservabilityManager;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.sharedPreferences$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TokenLocalDataSourceImpl$sharedPreferences$2(this));
        this.tokenLocalJsonAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new TokenLocalDataSourceImpl$tokenLocalJsonAdapter$2(this));
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences$delegate.getValue();
    }

    private final JsonAdapter<TokenLocal> getTokenLocalJsonAdapter() {
        return (JsonAdapter) this.tokenLocalJsonAdapter$delegate.getValue();
    }

    private final String readDeviceToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(getSharedPreferences().getString(KEY_DEVICE_TOKEN, (String) null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            Companion.onSecureStorageFailed(this.observabilityManager, Companion.Operation.READ, Companion.TokenType.DEVICE, r12);
        }
        ResultKt.throwOnFailure(obj);
        return (String) obj;
    }

    private final Token readToken() {
        Object obj;
        TokenLocal tokenLocal;
        try {
            Result.Companion companion = Result.Companion;
            Token token2 = null;
            String string = getSharedPreferences().getString(KEY_TOKEN, (String) null);
            if (string != null) {
                JsonAdapter<TokenLocal> tokenLocalJsonAdapter = getTokenLocalJsonAdapter();
                Intrinsics.checkNotNullExpressionValue(tokenLocalJsonAdapter, "tokenLocalJsonAdapter");
                tokenLocal = tokenLocalJsonAdapter.fromJson(string);
            } else {
                tokenLocal = null;
            }
            if (tokenLocal != null) {
                token2 = tokenLocal.toToken();
            }
            obj = Result.m6329constructorimpl(token2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            Companion.onSecureStorageFailed(this.observabilityManager, Companion.Operation.READ, Companion.TokenType.JWT, r12);
        }
        ResultKt.throwOnFailure(obj);
        return (Token) obj;
    }

    public void clearToken() {
        Object obj;
        this.token = null;
        try {
            Result.Companion companion = Result.Companion;
            getSharedPreferences().edit().remove(KEY_TOKEN).apply();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            Companion.onSecureStorageFailed(this.observabilityManager, Companion.Operation.WRITE, Companion.TokenType.JWT, r02);
        }
    }

    @Nullable
    public String getDeviceToken() {
        String str = this.deviceToken;
        if (str != null) {
            return str;
        }
        String readDeviceToken = readDeviceToken();
        this.deviceToken = readDeviceToken;
        return readDeviceToken;
    }

    @Nullable
    public Token getToken() {
        Token token2 = this.token;
        if (token2 != null) {
            return token2;
        }
        Token readToken = readToken();
        this.token = readToken;
        return readToken;
    }

    public void setToken(@NotNull Token token2, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(token2, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        this.token = token2;
        this.deviceToken = str;
        try {
            Result.Companion companion = Result.Companion;
            getSharedPreferences().edit().putString(KEY_TOKEN, getTokenLocalJsonAdapter().toJson(new TokenLocal(token2))).putString(KEY_DEVICE_TOKEN, str).apply();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            Companion.onSecureStorageFailed(this.observabilityManager, Companion.Operation.WRITE, Companion.TokenType.JWT_DEVICE, r42);
        }
    }
}
