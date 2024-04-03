package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.FileMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.network.SocketRepositoryImpl;
import com.deliveryhero.chatsdk.network.websocket.converter.MoshiConverter;
import com.deliveryhero.chatsdk.network.websocket.model.MessageReceipt;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpConnector;
import com.deliveryhero.chatsdk.network.websocket.okhttp.OkHttpWebSocketService;
import com.deliveryhero.chatsdk.provider.Provider;
import com.deliveryhero.chatsdk.provider.ProviderKt;
import com.deliveryhero.chatsdk.util.UrlBuilder;
import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.customerchat.di.MyKoinContext;
import com.visa.checkout.Profile;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.StringQualifier;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 .2\u00020\u0001:\u0001.J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0010H&J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001bH&J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H&J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H&J&\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0010H&J@\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010\u00102\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "", "autoBackgroundDetection", "", "getAutoBackgroundDetection", "()Z", "setAutoBackgroundDetection", "(Z)V", "connect", "Lio/reactivex/Completable;", "disconnect", "getMessages", "Lio/reactivex/Single;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "channelId", "", "limit", "", "timestamp", "", "inverted", "correlationID", "markMessageAsRead", "", "message", "observeConnectionState", "Lio/reactivex/Flowable;", "Lcom/deliveryhero/chatsdk/domain/model/ConnectionState;", "observeIncomingMessages", "observeReadReceipts", "Lcom/deliveryhero/chatsdk/network/websocket/model/MessageReceipt;", "sendConfigRequest", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "sendFileMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "fileUrl", "sendLocationMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "location", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "sendTextMessage", "Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "text", "language", "supportedLanguages", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SocketRepository {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/SocketRepository$Companion;", "", "()V", "getInstance", "Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "user", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "country", "", "environment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "pushTokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "versionName", "deviceUUID", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final SocketRepository getInstance(@NotNull UserInfo userInfo, @NotNull String str, @NotNull DhEnvironment dhEnvironment, @NotNull TokenType tokenType, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(userInfo, "user");
            Intrinsics.checkNotNullParameter(str, "country");
            Intrinsics.checkNotNullParameter(dhEnvironment, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(tokenType, "pushTokenType");
            Intrinsics.checkNotNullParameter(str2, "versionName");
            Intrinsics.checkNotNullParameter(str3, "deviceUUID");
            Koin koin = MyKoinContext.INSTANCE.getKoin();
            StringQualifier stringQualifier = new StringQualifier(ProviderKt.AUTHENTICATED);
            Provider provider = Provider.INSTANCE;
            return new SocketRepositoryImpl(OkHttpWebSocketService.Factory.getInstance(new OkHttpConnector((OkHttpClient) koin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(OkHttpClient.class), stringQualifier, (Function0<? extends ParametersHolder>) null), provider.provideRequest(UrlBuilder.INSTANCE.buildSocketUrl(str, dhEnvironment, tokenType, str2, str3))), new MoshiConverter(provider.provideMoshi())), userInfo);
        }
    }

    @NotNull
    Completable connect();

    @NotNull
    Completable disconnect();

    boolean getAutoBackgroundDetection();

    @NotNull
    Single<List<Message>> getMessages(@NotNull String str, int i11, long j11, boolean z11, @NotNull String str2);

    void markMessageAsRead(@NotNull String str, @NotNull Message message, @NotNull String str2);

    @NotNull
    Flowable<ConnectionState> observeConnectionState();

    @NotNull
    Flowable<Message> observeIncomingMessages();

    @NotNull
    Flowable<MessageReceipt> observeReadReceipts();

    @NotNull
    Single<ConfigMessage> sendConfigRequest(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<FileMessage> sendFileMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<LocationMessage> sendLocationMessage(@NotNull String str, @NotNull Location location, @NotNull String str2);

    @NotNull
    Single<TextMessage> sendTextMessage(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable List<String> list, @NotNull String str4);

    void setAutoBackgroundDetection(boolean z11);
}
