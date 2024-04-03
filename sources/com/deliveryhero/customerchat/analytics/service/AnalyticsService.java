package com.deliveryhero.customerchat.analytics.service;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJI\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsService;", "", "sendEvent", "Lretrofit2/Response;", "url", "", "event", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "authToken", "globalEntityId", "serviceType", "(Ljava/lang/String;Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AnalyticsService {
    @NotNull
    public static final Factory Factory = Factory.f29813a;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object sendEvent$default(AnalyticsService analyticsService, String str, EventCreationRequest eventCreationRequest, String str2, String str3, String str4, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 16) != 0) {
                    str4 = "p2p_chat";
                }
                return analyticsService.sendEvent(str, eventCreationRequest, str2, str3, str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsService$Factory;", "", "()V", "CHAT_SERVICE_TYPE", "", "getInstance", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsService;", "retrofit", "Lretrofit2/Retrofit;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Factory {
        @NotNull
        private static final String CHAT_SERVICE_TYPE = "p2p_chat";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Factory f29813a = new Factory();

        private Factory() {
        }

        @NotNull
        public final AnalyticsService getInstance(@NotNull Retrofit retrofit) {
            Intrinsics.checkNotNullParameter(retrofit, "retrofit");
            Object create = retrofit.create(AnalyticsService.class);
            Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(AnalyticsService::class.java)");
            return (AnalyticsService) create;
        }
    }

    @POST
    @Nullable
    Object sendEvent(@NotNull @Url String str, @NotNull @Body EventCreationRequest eventCreationRequest, @NotNull @Header("Authorization") String str2, @NotNull @Header("x-helpcenter-gei") String str3, @NotNull @Header("x-service-type") String str4, @NotNull Continuation<? super Response<Object>> continuation);
}
