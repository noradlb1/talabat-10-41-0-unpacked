package com.deliveryhero.chatsdk.domain;

import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.chatsdk.domain.model.messages.UploadFile;
import com.deliveryhero.chatsdk.network.HTTPRepositoryImpl;
import com.deliveryhero.chatsdk.network.http.ChatHttpService;
import com.deliveryhero.customerchat.commons.ChatUtilsImpl;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "", "getChannelUnreadMessagesCount", "Lio/reactivex/Single;", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "channelId", "", "getTotalUnreadMessagesCount", "", "registerDevicePushToken", "Lio/reactivex/Completable;", "token", "appId", "unregisterDevicePushToken", "uploadFile", "Lcom/deliveryhero/chatsdk/domain/model/messages/UploadFile;", "file", "Ljava/io/File;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Unnecessary layer.", replaceWith = @ReplaceWith(expression = "ChatHttpService", imports = {"com.deliveryhero.chatsdk.network.http.ChatHttpService"}))
public interface HTTPRepository {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatsdk/domain/HTTPRepository$Companion;", "", "()V", "getInstance", "Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "user", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "pushTokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "httpService", "Lcom/deliveryhero/chatsdk/network/http/ChatHttpService;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final HTTPRepository getInstance(@NotNull UserInfo userInfo, @NotNull TokenType tokenType, @NotNull ChatHttpService chatHttpService) {
            Intrinsics.checkNotNullParameter(userInfo, "user");
            Intrinsics.checkNotNullParameter(tokenType, "pushTokenType");
            Intrinsics.checkNotNullParameter(chatHttpService, "httpService");
            return new HTTPRepositoryImpl(chatHttpService, userInfo, tokenType, new ChatUtilsImpl());
        }
    }

    @NotNull
    Single<UnreadChatDetails> getChannelUnreadMessagesCount(@NotNull String str);

    @NotNull
    Single<Integer> getTotalUnreadMessagesCount();

    @NotNull
    Completable registerDevicePushToken(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable unregisterDevicePushToken(@NotNull String str);

    @NotNull
    Single<UploadFile> uploadFile(@NotNull File file);
}
