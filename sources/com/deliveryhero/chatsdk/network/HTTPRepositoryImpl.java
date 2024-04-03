package com.deliveryhero.chatsdk.network;

import com.deliveryhero.chatsdk.domain.HTTPRepository;
import com.deliveryhero.chatsdk.domain.mapper.ChatDetailsMapper;
import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.chatsdk.domain.model.messages.UnreadChatDetails;
import com.deliveryhero.chatsdk.domain.model.messages.UploadFile;
import com.deliveryhero.chatsdk.network.http.ChatHttpService;
import com.deliveryhero.chatsdk.network.http.model.RegisterPushTokenRequest;
import com.deliveryhero.chatsdk.network.http.model.RemovePushTokenRequest;
import com.deliveryhero.chatsdk.network.http.model.TotalUnreadCountResponse;
import com.deliveryhero.chatsdk.network.http.model.UploadFileResponse;
import com.deliveryhero.customerchat.commons.ChatUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l4.a;
import l4.b;
import l4.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/chatsdk/network/HTTPRepositoryImpl;", "Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "httpService", "Lcom/deliveryhero/chatsdk/network/http/ChatHttpService;", "userInfo", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "pushTokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "chatUtils", "Lcom/deliveryhero/customerchat/commons/ChatUtils;", "(Lcom/deliveryhero/chatsdk/network/http/ChatHttpService;Lcom/deliveryhero/chatsdk/domain/model/UserInfo;Lcom/deliveryhero/chatsdk/domain/model/TokenType;Lcom/deliveryhero/customerchat/commons/ChatUtils;)V", "getChannelUnreadMessagesCount", "Lio/reactivex/Single;", "Lcom/deliveryhero/chatsdk/domain/model/messages/UnreadChatDetails;", "channelId", "", "getTotalUnreadMessagesCount", "", "registerDevicePushToken", "Lio/reactivex/Completable;", "token", "appId", "unregisterDevicePushToken", "uploadFile", "Lcom/deliveryhero/chatsdk/domain/model/messages/UploadFile;", "file", "Ljava/io/File;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HTTPRepositoryImpl implements HTTPRepository {
    @NotNull
    private final ChatUtils chatUtils;
    @NotNull
    private final ChatHttpService httpService;
    @NotNull
    private final TokenType pushTokenType;
    @NotNull
    private final UserInfo userInfo;

    public HTTPRepositoryImpl(@NotNull ChatHttpService chatHttpService, @NotNull UserInfo userInfo2, @NotNull TokenType tokenType, @NotNull ChatUtils chatUtils2) {
        Intrinsics.checkNotNullParameter(chatHttpService, "httpService");
        Intrinsics.checkNotNullParameter(userInfo2, "userInfo");
        Intrinsics.checkNotNullParameter(tokenType, "pushTokenType");
        Intrinsics.checkNotNullParameter(chatUtils2, "chatUtils");
        this.httpService = chatHttpService;
        this.userInfo = userInfo2;
        this.pushTokenType = tokenType;
        this.chatUtils = chatUtils2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getTotalUnreadMessagesCount$lambda-1  reason: not valid java name */
    public static final Integer m8105getTotalUnreadMessagesCount$lambda1(TotalUnreadCountResponse totalUnreadCountResponse) {
        Intrinsics.checkNotNullParameter(totalUnreadCountResponse, "it");
        return Integer.valueOf(totalUnreadCountResponse.getTotal());
    }

    /* access modifiers changed from: private */
    /* renamed from: uploadFile$lambda-0  reason: not valid java name */
    public static final UploadFile m8106uploadFile$lambda0(UploadFileResponse uploadFileResponse) {
        Intrinsics.checkNotNullParameter(uploadFileResponse, "it");
        return new UploadFile(uploadFileResponse.getUrl());
    }

    @NotNull
    public Single<UnreadChatDetails> getChannelUnreadMessagesCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Single<R> map = this.httpService.getChannelUnreadMessagesCount(str).map(new a(ChatDetailsMapper.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(map, "httpService.getChannelUn…mapResponseToChatDetails)");
        return map;
    }

    @NotNull
    public Single<Integer> getTotalUnreadMessagesCount() {
        Single<R> map = this.httpService.getTotalUnreadMessagesCount(this.userInfo.getUserId()).map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "httpService.getTotalUnre….userId).map { it.total }");
        return map;
    }

    @NotNull
    public Completable registerDevicePushToken(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "appId");
        return this.httpService.registerPushNotificationsToken(this.userInfo.getUserId(), new RegisterPushTokenRequest(str, this.pushTokenType.getBackendName$customerchat_basicRelease(), str2));
    }

    @NotNull
    public Completable unregisterDevicePushToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        return this.httpService.unregisterPushNotificationsToken(this.userInfo.getUserId(), new RemovePushTokenRequest(str));
    }

    @NotNull
    public Single<UploadFile> uploadFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Single<R> map = this.httpService.uploadFile(this.chatUtils.generateMultipartBody(file)).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "httpService.uploadFile(c…ap { UploadFile(it.url) }");
        return map;
    }
}
