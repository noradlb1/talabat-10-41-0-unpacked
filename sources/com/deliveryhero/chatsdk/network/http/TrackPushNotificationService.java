package com.deliveryhero.chatsdk.network.http;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/http/TrackPushNotificationService;", "", "trackPushNotification", "Lretrofit2/Call;", "", "channelId", "", "pushId", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackPushNotificationService {
    @NotNull
    @POST("notifications/channel/{channel_id}/uid/{id}")
    Call<Unit> trackPushNotification(@NotNull @Path("channel_id") String str, @NotNull @Path("id") String str2);
}
