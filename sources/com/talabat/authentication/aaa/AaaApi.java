package com.talabat.authentication.aaa;

import com.talabat.authentication.authenticate.data.remote.model.LogoutRequest;
import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.authenticate.data.remote.model.SilentLoginRequest;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH'J1\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\f2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH'J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00122\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH'JC\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J1\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u0006\u001a\u00020\u00122\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J=\u0010\u0017\u001a\u00020\u00052\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/authentication/aaa/AaaApi;", "", "authenticateWithPassword", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lcom/talabat/authentication/aaa/TokenResponse;", "body", "Lcom/talabat/authentication/authenticate/data/remote/model/SilentLoginRequest;", "deviceId", "", "globalEntity", "authenticateWithSocialConnect", "Lcom/talabat/authentication/aaa/AuthenticateWithSocialConnectRequestBody;", "(Lcom/talabat/authentication/aaa/AuthenticateWithSocialConnectRequestBody;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginClient", "", "logout", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutResponse;", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutRequest;", "migrationExchangeToken", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revoke", "(Lcom/talabat/authentication/authenticate/data/remote/model/LogoutRequest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AaaApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single authenticateWithPassword$default(AaaApi aaaApi, SilentLoginRequest silentLoginRequest, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.authenticateWithPassword(silentLoginRequest, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authenticateWithPassword");
        }

        public static /* synthetic */ Object authenticateWithSocialConnect$default(AaaApi aaaApi, AuthenticateWithSocialConnectRequestBody authenticateWithSocialConnectRequestBody, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.authenticateWithSocialConnect(authenticateWithSocialConnectRequestBody, str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authenticateWithSocialConnect");
        }

        public static /* synthetic */ Single loginClient$default(AaaApi aaaApi, Map map, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.loginClient(map, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginClient");
        }

        public static /* synthetic */ Single logout$default(AaaApi aaaApi, LogoutRequest logoutRequest, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.logout(logoutRequest, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
        }

        public static /* synthetic */ Object migrationExchangeToken$default(AaaApi aaaApi, Map map, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.migrationExchangeToken(map, str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: migrationExchangeToken");
        }

        public static /* synthetic */ Object revoke$default(AaaApi aaaApi, LogoutRequest logoutRequest, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.revoke(logoutRequest, str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: revoke");
        }

        public static /* synthetic */ Object token$default(AaaApi aaaApi, Map map, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    str2 = "TB_KW";
                }
                return aaaApi.token(map, str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: token");
        }
    }

    @NotNull
    @POST("/api/v5/oauth2/token")
    Single<Response<TokenResponse>> authenticateWithPassword(@NotNull @Body SilentLoginRequest silentLoginRequest, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2);

    @POST("/api/v5/social-connect")
    @Nullable
    Object authenticateWithSocialConnect(@NotNull @Body AuthenticateWithSocialConnectRequestBody authenticateWithSocialConnectRequestBody, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2, @NotNull Continuation<? super TokenResponse> continuation);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v5/oauth2/token")
    Single<TokenResponse> loginClient(@NotNull @FieldMap Map<String, String> map, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2);

    @NotNull
    @POST("/api/v5/oauth2/revoke")
    Single<LogoutResponse> logout(@NotNull @Body LogoutRequest logoutRequest, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2);

    @FormUrlEncoded
    @Nullable
    @POST("/api/v5/oauth2/migration/exchange")
    Object migrationExchangeToken(@NotNull @FieldMap Map<String, String> map, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2, @NotNull Continuation<? super Response<TokenResponse>> continuation);

    @POST("/api/v5/oauth2/revoke")
    @Nullable
    Object revoke(@NotNull @Body LogoutRequest logoutRequest, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2, @NotNull Continuation<? super LogoutResponse> continuation);

    @FormUrlEncoded
    @Nullable
    @POST("/api/v5/oauth2/token")
    Object token(@NotNull @FieldMap Map<String, String> map, @Nullable @Header("X-device") String str, @NotNull @Header("X-Global-Entity-ID") String str2, @NotNull Continuation<? super TokenResponse> continuation);
}
