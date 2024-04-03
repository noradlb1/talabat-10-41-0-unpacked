package com.talabat.notifications.brazemigrator.guestuser.data.service;

import com.talabat.core.network.endpoint.GuestUserHashValueEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashService;", "Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashApi;", "api", "(Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashApi;)V", "fitchUserHashValue", "Lretrofit2/Call;", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserResponseBody;", "guestUserRequestBody", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserHashService implements GuestUserHashApi {
    @NotNull
    private final GuestUserHashApi api;

    public GuestUserHashService() {
        this((GuestUserHashApi) null, 1, (DefaultConstructorMarker) null);
    }

    public GuestUserHashService(@NotNull GuestUserHashApi guestUserHashApi) {
        Intrinsics.checkNotNullParameter(guestUserHashApi, "api");
        this.api = guestUserHashApi;
    }

    @NotNull
    public Call<GuestUserResponseBody> fitchUserHashValue(@NotNull GuestUserRequestBody guestUserRequestBody) {
        Intrinsics.checkNotNullParameter(guestUserRequestBody, "guestUserRequestBody");
        return this.api.fitchUserHashValue(guestUserRequestBody);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GuestUserHashService(GuestUserHashApi guestUserHashApi, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? (GuestUserHashApi) new TalabatAPIBuilder().createApi(new GuestUserHashValueEndPointProvider((String) null, 1, (DefaultConstructorMarker) null).getBaseUrl(), GuestUserHashApi.class) : guestUserHashApi);
    }
}
