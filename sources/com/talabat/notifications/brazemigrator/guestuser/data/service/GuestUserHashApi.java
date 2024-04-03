package com.talabat.notifications.brazemigrator.guestuser.data.service;

import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashApi;", "", "fitchUserHashValue", "Lretrofit2/Call;", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserResponseBody;", "guestUserRequestBody", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GuestUserHashApi {
    @NotNull
    @POST("v1/braze/hash")
    Call<GuestUserResponseBody> fitchUserHashValue(@NotNull @Body GuestUserRequestBody guestUserRequestBody);
}
