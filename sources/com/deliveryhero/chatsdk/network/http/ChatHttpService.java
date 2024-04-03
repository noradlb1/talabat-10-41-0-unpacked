package com.deliveryhero.chatsdk.network.http;

import com.deliveryhero.chatsdk.network.http.model.ChannelUnreadCountResponse;
import com.deliveryhero.chatsdk.network.http.model.RegisterPushTokenRequest;
import com.deliveryhero.chatsdk.network.http.model.RemovePushTokenRequest;
import com.deliveryhero.chatsdk.network.http.model.TotalUnreadCountResponse;
import com.deliveryhero.chatsdk.network.http.model.UploadFileResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u001c\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'J\u001c\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/ChatHttpService;", "", "getChannelUnreadMessagesCount", "Lio/reactivex/Single;", "Lcom/deliveryhero/chatsdk/network/http/model/ChannelUnreadCountResponse;", "channelId", "", "getTotalUnreadMessagesCount", "Lcom/deliveryhero/chatsdk/network/http/model/TotalUnreadCountResponse;", "userId", "registerPushNotificationsToken", "Lio/reactivex/Completable;", "token", "Lcom/deliveryhero/chatsdk/network/http/model/RegisterPushTokenRequest;", "unregisterPushNotificationsToken", "tokenRequest", "Lcom/deliveryhero/chatsdk/network/http/model/RemovePushTokenRequest;", "uploadFile", "Lcom/deliveryhero/chatsdk/network/http/model/UploadFileResponse;", "file", "Lokhttp3/MultipartBody$Part;", "Factory", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatHttpService {
    @NotNull
    public static final Factory Factory = Factory.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/ChatHttpService$Factory;", "", "()V", "getInstance", "Lcom/deliveryhero/chatsdk/network/http/ChatHttpService;", "retrofit", "Lretrofit2/Retrofit;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Factory {
        static final /* synthetic */ Factory $$INSTANCE = new Factory();

        private Factory() {
        }

        @NotNull
        public final ChatHttpService getInstance(@NotNull Retrofit retrofit) {
            Intrinsics.checkNotNullParameter(retrofit, "retrofit");
            Object create = retrofit.create(ChatHttpService.class);
            Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(ChatHttpService::class.java)");
            return (ChatHttpService) create;
        }
    }

    @NotNull
    @GET("channel/{channel}/unread")
    Single<ChannelUnreadCountResponse> getChannelUnreadMessagesCount(@NotNull @Path("channel") String str);

    @NotNull
    @GET("user/{user}/unread")
    Single<TotalUnreadCountResponse> getTotalUnreadMessagesCount(@NotNull @Path("user") String str);

    @NotNull
    @PUT("user/{user}/device")
    Completable registerPushNotificationsToken(@NotNull @Path("user") String str, @NotNull @Body RegisterPushTokenRequest registerPushTokenRequest);

    @NotNull
    @POST("user/{user}/device")
    Completable unregisterPushNotificationsToken(@NotNull @Path("user") String str, @NotNull @Body RemovePushTokenRequest removePushTokenRequest);

    @Multipart
    @NotNull
    @POST("image/upload")
    Single<UploadFileResponse> uploadFile(@NotNull @Part MultipartBody.Part part);
}
