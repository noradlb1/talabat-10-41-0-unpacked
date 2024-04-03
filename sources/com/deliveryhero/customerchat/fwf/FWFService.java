package com.deliveryhero.customerchat.fwf;

import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.PUT;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \t2\u00020\u0001:\u0001\tJ'\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FWFService;", "", "getFeatureFlags", "", "", "Lcom/deliveryhero/customerchat/fwf/FeatureInfo;", "fwfRequest", "Lcom/deliveryhero/customerchat/fwf/FWFRequest;", "(Lcom/deliveryhero/customerchat/fwf/FWFRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FWFService {
    @NotNull
    public static final Companion Companion = Companion.f29982a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FWFService$Companion;", "", "()V", "BASE_URL", "", "getInstance", "Lcom/deliveryhero/customerchat/fwf/FWFService;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "retrofit", "Lretrofit2/Retrofit;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final String BASE_URL = "https://client-api.fwf.deliveryhero.net/v3/";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f29982a = new Companion();

        private Companion() {
        }

        public static /* synthetic */ FWFService getInstance$default(Companion companion, ChatConfigProvider chatConfigProvider, Retrofit retrofit, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                retrofit = FWFClient.build$default(FWFClient.INSTANCE, BASE_URL, chatConfigProvider, (OkHttpClient) null, (MoshiConverterFactory) null, 12, (Object) null);
            }
            return companion.getInstance(chatConfigProvider, retrofit);
        }

        @NotNull
        public final FWFService getInstance(@NotNull ChatConfigProvider chatConfigProvider, @NotNull Retrofit retrofit) {
            Intrinsics.checkNotNullParameter(chatConfigProvider, "chatConfigProvider");
            Intrinsics.checkNotNullParameter(retrofit, "retrofit");
            Object create = retrofit.create(FWFService.class);
            Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(FWFService::class.java)");
            return (FWFService) create;
        }
    }

    @Nullable
    @PUT("features")
    Object getFeatureFlags(@NotNull @Body FWFRequest fWFRequest, @NotNull Continuation<? super Map<String, FeatureInfo>> continuation);
}
