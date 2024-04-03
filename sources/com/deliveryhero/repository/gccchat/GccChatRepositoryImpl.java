package com.deliveryhero.repository.gccchat;

import android.app.Application;
import androidx.annotation.VisibleForTesting;
import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.ChannelListener;
import com.deliveryhero.chatsdk.ChatSdk;
import com.deliveryhero.chatsdk.domain.model.ConnectionState;
import com.deliveryhero.chatsdk.domain.model.UserInfo;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.ChatRepository;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.idling.ChatIdlingResource;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ChatDetails;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.contract.model.FileMessageData;
import com.deliveryhero.contract.model.GroupChannel;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.contract.model.TextMessageData;
import com.deliveryhero.customerchat.BuildConfig;
import com.deliveryhero.customerchat.commons.ChatPreferences;
import com.deliveryhero.customerchat.commons.UUIDUtilKt;
import com.deliveryhero.customerchat.commons.UserNotRegisteredException;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.telephony.repository.PushConfigRepository;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\b\u00105\u001a\u00020/H\u0016J2\u00106\u001a\u00020/2\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J2\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u0002032\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J\u0016\u0010?\u001a\u00020/2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020/0:H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u000203H\u0016J\b\u0010C\u001a\u00020'H\u0016J8\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u0002032\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020/0.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J>\u0010G\u001a\u00020/2\u0006\u0010B\u001a\u0002032\u0018\u00109\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002010H\u0012\u0004\u0012\u00020/0.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u000201H\u0016J0\u0010K\u001a\u00020/2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J8\u0010K\u001a\u00020/2\u0006\u0010E\u001a\u0002032\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020/0.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J\b\u0010L\u001a\u00020/H\u0016J\u0010\u0010M\u001a\u00020/2\u0006\u0010E\u001a\u000203H\u0002J\"\u0010N\u001a\u00020/2\u0006\u00107\u001a\u0002082\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0002J\b\u0010P\u001a\u00020'H\u0016J\b\u0010Q\u001a\u00020'H\u0016J\b\u0010R\u001a\u00020'H\u0016J\b\u0010S\u001a\u00020'H\u0016J\u0010\u0010T\u001a\u00020/2\u0006\u0010B\u001a\u000203H\u0016J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u000201H\u0016J\b\u0010X\u001a\u00020'H\u0016J$\u0010Y\u001a\u00020/2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020/0:2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020/0:H\u0016J2\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u0002032\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J2\u0010^\u001a\u00020/2\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J\b\u0010_\u001a\u00020/H\u0016J@\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0.2\u001a\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0dH\u0016J@\u0010e\u001a\u00020/2\u0006\u0010f\u001a\u00020g2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0.2\u001a\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0dH\u0016JP\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020j2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010H2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0.2\u001a\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0dH\u0016J\u0010\u0010l\u001a\u00020/2\u0006\u0010m\u001a\u00020'H\u0016J\u0010\u0010n\u001a\u00020/2\u0006\u0010o\u001a\u000203H\u0016J0\u0010p\u001a\u00020/2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0.2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0.H\u0016J*\u0010r\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u00020/0:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020/0.H\u0016J\b\u0010s\u001a\u00020/H\u0016J\b\u0010t\u001a\u000203H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,XD¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203XD¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/deliveryhero/repository/gccchat/GccChatRepositoryImpl;", "Lcom/deliveryhero/contract/ChatRepository;", "Lcom/deliveryhero/contract/model/GroupChannel;", "appContext", "Landroid/app/Application;", "chatProvider", "Lcom/deliveryhero/repository/gccchat/ChatProvider;", "mapper", "Lcom/deliveryhero/repository/gccchat/GccChatMessageToBaseMessageMapper;", "configRelay", "Lcom/deliveryhero/repository/gccchat/ConfigRelay;", "chatIdlingResource", "Lcom/deliveryhero/contract/idling/ChatIdlingResource;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "pushConfigRepository", "Lcom/deliveryhero/customerchat/telephony/repository/PushConfigRepository;", "chatPreferences", "Lcom/deliveryhero/customerchat/commons/ChatPreferences;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "(Landroid/app/Application;Lcom/deliveryhero/repository/gccchat/ChatProvider;Lcom/deliveryhero/repository/gccchat/GccChatMessageToBaseMessageMapper;Lcom/deliveryhero/repository/gccchat/ConfigRelay;Lcom/deliveryhero/contract/idling/ChatIdlingResource;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/telephony/repository/PushConfigRepository;Lcom/deliveryhero/customerchat/commons/ChatPreferences;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;Lcom/deliveryhero/contract/ChatLogger;)V", "channel", "Lcom/deliveryhero/chatsdk/Channel;", "channelListener", "Lcom/deliveryhero/chatsdk/ChannelListener;", "getChannelListener$annotations", "()V", "getChannelListener", "()Lcom/deliveryhero/chatsdk/ChannelListener;", "setChannelListener", "(Lcom/deliveryhero/chatsdk/ChannelListener;)V", "chatSdk", "Lcom/deliveryhero/chatsdk/ChatSdk;", "gccUserInfo", "Lcom/deliveryhero/chatsdk/domain/model/UserInfo;", "isChannelDirty", "", "isUserRegistered", "lastReadMessageTimestamp", "", "messageLimit", "", "onMessageReceiptUpdateListener", "Lkotlin/Function1;", "", "onNewMessageListener", "Lcom/deliveryhero/contract/model/BaseMessage;", "preferredLanguage", "", "webSocketConnectedError", "clear", "connect", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "onSuccess", "Lkotlin/Function0;", "onError", "", "connectChannel", "id", "disconnect", "handler", "fetchConfig", "correlationID", "getAutoBackgroundDetection", "getChatDetailsByChannel", "channelId", "Lcom/deliveryhero/contract/model/ChatDetails;", "getChatList", "", "getReadReceipt", "message", "getUnreadCount", "init", "initGccChannel", "initGccChatSdk", "onComplete", "isChatReadyToUse", "isConnected", "isConnectionClosed", "isLoading", "markAllMessagesAsRead", "messageReceipt", "Lcom/deliveryhero/contract/model/Receipt;", "baseMessage", "reconnect", "registerConnectionHandler", "onStarted", "onSucceeded", "registerToken", "token", "registerUser", "removeConnectionHandler", "sendFileMessage", "fileMessageData", "Lcom/deliveryhero/contract/model/FileMessageData;", "onNewMessage", "Lkotlin/Function2;", "sendLocationMessage", "locationData", "Lcom/deliveryhero/contract/model/LocationData;", "sendMessage", "textMessageData", "Lcom/deliveryhero/contract/model/TextMessageData;", "supportedTranslation", "setAutoBackgroundDetection", "enable", "setPreferredLanguage", "language", "subscribeForMessages", "onMessageReceiptUpdate", "unregisterFromPushes", "unsubscribeForMessages", "userId", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImpl implements ChatRepository, GroupChannel {
    /* access modifiers changed from: private */
    @NotNull
    public final Application appContext;
    /* access modifiers changed from: private */
    public Channel channel;
    @NotNull
    private ChannelListener channelListener = new GccChatRepositoryImpl$channelListener$1(this);
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatFeatureCallbacks chatFeatureCallbacks;
    /* access modifiers changed from: private */
    @Nullable
    public final ChatIdlingResource chatIdlingResource;
    @Nullable
    private final ChatLogger chatLogger;
    @NotNull
    private final ChatPreferences chatPreferences;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatProvider chatProvider;
    /* access modifiers changed from: private */
    public ChatSdk chatSdk;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigRelay configRelay;
    /* access modifiers changed from: private */
    public UserInfo gccUserInfo;
    /* access modifiers changed from: private */
    public boolean isChannelDirty;
    /* access modifiers changed from: private */
    public boolean isUserRegistered;
    /* access modifiers changed from: private */
    public long lastReadMessageTimestamp;
    /* access modifiers changed from: private */
    @NotNull
    public final GccChatMessageToBaseMessageMapper mapper;
    private final int messageLimit = 50;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super GroupChannel, Unit> onMessageReceiptUpdateListener;
    /* access modifiers changed from: private */
    @Nullable
    public Function1<? super BaseMessage, Unit> onNewMessageListener;
    @Nullable
    private String preferredLanguage;
    /* access modifiers changed from: private */
    @NotNull
    public final PushConfigRepository pushConfigRepository;
    @NotNull
    private final String webSocketConnectedError = "Please close chat before registering the user again.";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Receipt.values().length];
            iArr[Receipt.SEEN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GccChatRepositoryImpl(@NotNull Application application, @NotNull ChatProvider chatProvider2, @NotNull GccChatMessageToBaseMessageMapper gccChatMessageToBaseMessageMapper, @NotNull ConfigRelay configRelay2, @Nullable ChatIdlingResource chatIdlingResource2, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull PushConfigRepository pushConfigRepository2, @NotNull ChatPreferences chatPreferences2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2, @Nullable ChatLogger chatLogger2) {
        Intrinsics.checkNotNullParameter(application, "appContext");
        Intrinsics.checkNotNullParameter(chatProvider2, "chatProvider");
        Intrinsics.checkNotNullParameter(gccChatMessageToBaseMessageMapper, "mapper");
        Intrinsics.checkNotNullParameter(configRelay2, "configRelay");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(pushConfigRepository2, "pushConfigRepository");
        Intrinsics.checkNotNullParameter(chatPreferences2, "chatPreferences");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        this.appContext = application;
        this.chatProvider = chatProvider2;
        this.mapper = gccChatMessageToBaseMessageMapper;
        this.configRelay = configRelay2;
        this.chatIdlingResource = chatIdlingResource2;
        this.chatConfigProvider = chatConfigProvider2;
        this.pushConfigRepository = pushConfigRepository2;
        this.chatPreferences = chatPreferences2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
        this.chatLogger = chatLogger2;
    }

    @VisibleForTesting
    public static /* synthetic */ void getChannelListener$annotations() {
    }

    private final void initGccChannel(String str) {
        Channel channel2 = this.channel;
        ChatSdk chatSdk2 = null;
        if (channel2 == null || this.isChannelDirty) {
            if (channel2 != null) {
                if (channel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    channel2 = null;
                }
                channel2.dispose();
            }
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            this.channel = chatSdk2.connectChannel(str, this.channelListener);
            this.isChannelDirty = false;
            return;
        }
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            channel2 = null;
        }
        if (!Intrinsics.areEqual((Object) channel2.getChannelId(), (Object) str)) {
            Channel channel3 = this.channel;
            if (channel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                channel3 = null;
            }
            channel3.dispose();
            ChatSdk chatSdk4 = this.chatSdk;
            if (chatSdk4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk4;
            }
            this.channel = chatSdk2.connectChannel(str, this.channelListener);
        }
    }

    private final void initGccChatSdk(com.deliveryhero.contract.model.UserInfo userInfo, Function0<Unit> function0) {
        String id2 = userInfo.getId();
        String dhAuthToken = userInfo.getDhAuthToken();
        if (dhAuthToken != null) {
            UserInfo userInfo2 = new UserInfo(id2, dhAuthToken);
            ChatSdk chatSdk2 = null;
            if (this.chatSdk != null) {
                UserInfo userInfo3 = this.gccUserInfo;
                if (userInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                    userInfo3 = null;
                }
                if (Intrinsics.areEqual((Object) userInfo3, (Object) userInfo2)) {
                    if (function0 != null) {
                        function0.invoke();
                        return;
                    }
                    return;
                }
            }
            GccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1 gccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1 = new GccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1(this, userInfo2, function0);
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 != null) {
                if (chatSdk3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
                } else {
                    chatSdk2 = chatSdk3;
                }
                chatSdk2.dispose();
                gccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1.invoke();
                unregisterFromPushes(GccChatRepositoryImpl$initGccChatSdk$3.INSTANCE, GccChatRepositoryImpl$initGccChatSdk$4.INSTANCE);
                return;
            }
            gccChatRepositoryImpl$initGccChatSdk$initSdkAndRegisterUser$1.invoke();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void clear() {
        Channel channel2 = this.channel;
        if (channel2 != null) {
            if (channel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                channel2 = null;
            }
            channel2.dispose();
            this.isChannelDirty = true;
        }
    }

    public void connect(@NotNull com.deliveryhero.contract.model.UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        ChatSdk chatSdk2 = null;
        if (isChatReadyToUse()) {
            ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
            if (chatIdlingResource2 != null) {
                chatIdlingResource2.increment();
            }
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            chatSdk2.connect(new GccChatRepositoryImpl$connect$1(this, function0, function1));
            return;
        }
        function1.invoke(new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null));
    }

    public void connectChannel(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        initGccChannel(str);
        function0.invoke();
    }

    public void disconnect(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "handler");
        if (isConnected()) {
            ChatSdk chatSdk2 = this.chatSdk;
            if (chatSdk2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
                chatSdk2 = null;
            }
            chatSdk2.disconnect(new GccChatRepositoryImpl$disconnect$1(this, function0));
        }
    }

    public void fetchConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        if (this.channel != null) {
            ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
            if (chatIdlingResource2 != null) {
                chatIdlingResource2.increment();
            }
            Channel channel2 = this.channel;
            if (channel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                channel2 = null;
            }
            channel2.sendConfigRequestMessage(str, new GccChatRepositoryImpl$fetchConfig$2(this));
        }
    }

    public boolean getAutoBackgroundDetection() {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            return false;
        }
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        return chatSdk2.getAutoBackgroundDetection();
    }

    @NotNull
    public final ChannelListener getChannelListener() {
        return this.channelListener;
    }

    public void getChatDetailsByChannel(@NotNull String str, @NotNull Function1<? super ChatDetails, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        ChatSdk chatSdk2 = null;
        if (isChatReadyToUse()) {
            ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
            if (chatIdlingResource2 != null) {
                chatIdlingResource2.increment();
            }
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            chatSdk2.getChannelUnreadMessagesCount(str, new GccChatRepositoryImpl$getChatDetailsByChannel$1(this, function1, str, function12));
            return;
        }
        function12.invoke(new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null));
    }

    public void getChatList(@NotNull String str, @NotNull Function1<? super List<? extends BaseMessage>, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
        if (chatIdlingResource2 != null) {
            chatIdlingResource2.increment();
        }
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            channel2 = null;
        }
        channel2.getMessages(this.messageLimit, (Long) null, true, str, new GccChatRepositoryImpl$getChatList$1(this, function1, function12));
    }

    public int getReadReceipt(@NotNull BaseMessage baseMessage) {
        Intrinsics.checkNotNullParameter(baseMessage, "message");
        if (WhenMappings.$EnumSwitchMapping$0[messageReceipt(baseMessage).ordinal()] == 1) {
            return 0;
        }
        return 1;
    }

    public void getUnreadCount(@NotNull String str, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        ChatSdk chatSdk2 = null;
        if (isChatReadyToUse()) {
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            chatSdk2.getChannelUnreadMessagesCount(str, new GccChatRepositoryImpl$getUnreadCount$1(function1, this, str, function12));
            return;
        }
        function12.invoke(new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null));
    }

    public void init() {
        ClientConfig clientConfig;
        String deviceUUID = UUIDUtilKt.getDeviceUUID(this.chatPreferences);
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            clientConfig = chatConfiguration.getClientConfig();
        } else {
            clientConfig = null;
        }
        if (clientConfig == null) {
            ChatLogger chatLogger2 = this.chatLogger;
            if (chatLogger2 != null) {
                chatLogger2.log(Events.GCC_CHAT_NOT_INITIALIZED_NO_CLIENT_CONFIG, MapsKt__MapsKt.emptyMap());
                return;
            }
            return;
        }
        this.chatProvider.init(clientConfig, BuildConfig.VERSION_NAME, deviceUUID);
    }

    public boolean isChatReadyToUse() {
        return this.chatSdk != null && this.isUserRegistered;
    }

    public boolean isConnected() {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            return false;
        }
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        if (chatSdk2.getConnectionState() == ConnectionState.OPEN) {
            return true;
        }
        return false;
    }

    public boolean isConnectionClosed() {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            return true;
        }
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        if (chatSdk2.getConnectionState() == ConnectionState.CLOSED) {
            return true;
        }
        return false;
    }

    public boolean isLoading() {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        return chatSdk2.getConnectionState() == ConnectionState.CONNECTING;
    }

    public void markAllMessagesAsRead(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            channel2 = null;
        }
        channel2.markAllMessagesAsRead(str);
    }

    @NotNull
    public Receipt messageReceipt(@NotNull BaseMessage baseMessage) {
        Intrinsics.checkNotNullParameter(baseMessage, "baseMessage");
        if (baseMessage.getCreatedAt() <= this.lastReadMessageTimestamp) {
            return Receipt.SEEN;
        }
        return Receipt.SENT;
    }

    public boolean reconnect() {
        return false;
    }

    public void registerConnectionHandler(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onStarted");
        Intrinsics.checkNotNullParameter(function02, "onSucceeded");
        function0.invoke();
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        chatSdk2.setConnectionStateChangesListener(new GccChatRepositoryImpl$registerConnectionHandler$1(function02));
    }

    public void registerToken(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        ChatSdk chatSdk2 = null;
        if (this.isUserRegistered) {
            PushConfigRepository pushConfigRepository2 = this.pushConfigRepository;
            UserInfo userInfo = this.gccUserInfo;
            if (userInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
                userInfo = null;
            }
            if (pushConfigRepository2.hasCache(userInfo.getUserId(), str)) {
                function0.invoke();
                return;
            }
        }
        this.pushConfigRepository.setToken(str);
        if (isChatReadyToUse()) {
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            String packageName = this.appContext.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "appContext.packageName");
            chatSdk2.registerDevicePushToken(str, packageName, new GccChatRepositoryImpl$registerToken$1(this, function0, function1));
        }
    }

    public void registerUser(@NotNull com.deliveryhero.contract.model.UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        if (isConnected()) {
            function1.invoke(new IllegalStateException(this.webSocketConnectedError));
            return;
        }
        ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
        if (chatIdlingResource2 != null) {
            chatIdlingResource2.increment();
        }
        initGccChatSdk(userInfo, new GccChatRepositoryImpl$registerUser$1(this, function0));
    }

    public void removeConnectionHandler() {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            chatSdk2 = null;
        }
        chatSdk2.removeConnectionStateChangesListener();
    }

    public void sendFileMessage(@NotNull FileMessageData fileMessageData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(fileMessageData, "fileMessageData");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        Channel channel2 = null;
        if (this.channel == null) {
            function2.invoke(null, new Exception("Sending file failed"));
            return;
        }
        ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
        if (chatIdlingResource2 != null) {
            chatIdlingResource2.increment();
        }
        Channel channel3 = this.channel;
        if (channel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        } else {
            channel2 = channel3;
        }
        channel2.sendFileMessage(fileMessageData.getFile(), fileMessageData.getCorrelationID(), new GccChatRepositoryImpl$sendFileMessage$2(this, function1, function2));
    }

    public void sendLocationMessage(@NotNull LocationData locationData, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Intrinsics.checkNotNullParameter(locationData, "locationData");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        Channel channel2 = null;
        if (this.channel == null) {
            function2.invoke(null, new Exception("Sending location failed"));
            return;
        }
        ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
        if (chatIdlingResource2 != null) {
            chatIdlingResource2.increment();
        }
        Channel channel3 = this.channel;
        if (channel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        } else {
            channel2 = channel3;
        }
        channel2.sendLocationMessage(GccChatRepositoryImplKt.toSDKLocation(locationData), locationData.getCorrelationID(), new GccChatRepositoryImpl$sendLocationMessage$2(this, function1, function2));
    }

    public void sendMessage(@NotNull TextMessageData textMessageData, @Nullable List<String> list, @NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function2<? super BaseMessage, ? super Throwable, Unit> function2) {
        Channel channel2;
        Intrinsics.checkNotNullParameter(textMessageData, "textMessageData");
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function2, "onError");
        if (this.channel == null) {
            function2.invoke(null, new Exception("Sending message failed"));
            return;
        }
        ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
        if (chatIdlingResource2 != null) {
            chatIdlingResource2.increment();
        }
        Channel channel3 = this.channel;
        if (channel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            channel2 = null;
        } else {
            channel2 = channel3;
        }
        channel2.sendMessage(textMessageData.getMessage(), this.preferredLanguage, list, textMessageData.getCorrelationID(), new GccChatRepositoryImpl$sendMessage$2(this, function1, function2));
    }

    public void setAutoBackgroundDetection(boolean z11) {
        ChatSdk chatSdk2 = this.chatSdk;
        if (chatSdk2 != null) {
            if (chatSdk2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
                chatSdk2 = null;
            }
            chatSdk2.setAutoBackgroundDetection(z11);
        }
    }

    public final void setChannelListener(@NotNull ChannelListener channelListener2) {
        Intrinsics.checkNotNullParameter(channelListener2, "<set-?>");
        this.channelListener = channelListener2;
    }

    public void setPreferredLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
        this.preferredLanguage = str;
    }

    public void subscribeForMessages(@NotNull Function1<? super BaseMessage, Unit> function1, @NotNull Function1<? super GroupChannel, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onNewMessage");
        Intrinsics.checkNotNullParameter(function12, "onMessageReceiptUpdate");
        this.onNewMessageListener = function1;
        this.onMessageReceiptUpdateListener = function12;
    }

    public void unregisterFromPushes(@NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        String token = this.pushConfigRepository.getToken();
        if (token != null) {
            ChatSdk chatSdk2 = this.chatSdk;
            if (chatSdk2 != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                token = null;
            }
            if (token != null) {
                if (chatSdk2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
                    chatSdk2 = null;
                }
                chatSdk2.unregisterDevicePushToken(token, new GccChatRepositoryImpl$unregisterFromPushes$2$1(this, function0, function1));
            }
        }
    }

    public void unsubscribeForMessages() {
        this.onNewMessageListener = null;
        this.onMessageReceiptUpdateListener = null;
    }

    @NotNull
    public String userId() {
        UserInfo userInfo = this.gccUserInfo;
        if (userInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gccUserInfo");
            userInfo = null;
        }
        return userInfo.getUserId();
    }

    public void getUnreadCount(@NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        ChatSdk chatSdk2 = null;
        if (isChatReadyToUse()) {
            ChatIdlingResource chatIdlingResource2 = this.chatIdlingResource;
            if (chatIdlingResource2 != null) {
                chatIdlingResource2.increment();
            }
            ChatSdk chatSdk3 = this.chatSdk;
            if (chatSdk3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSdk");
            } else {
                chatSdk2 = chatSdk3;
            }
            chatSdk2.getTotalUnreadMessagesCount(new GccChatRepositoryImpl$getUnreadCount$2(this, function1, function12));
            return;
        }
        function12.invoke(new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null));
    }
}
