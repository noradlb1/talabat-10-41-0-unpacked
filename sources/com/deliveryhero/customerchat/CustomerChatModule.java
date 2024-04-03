package com.deliveryhero.customerchat;

import android.app.Application;
import android.content.Context;
import androidx.annotation.StyleRes;
import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.chatui.data.event.EventHandler;
import com.deliveryhero.chatui.view.root.CustomerChatActivity;
import com.deliveryhero.chatui.view.util.StylingProvider;
import com.deliveryhero.contract.ChatPushNotificationParser;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.configuration.CustomerChatConfigurationBuilder;
import com.deliveryhero.contract.configuration.UserRegistrationData;
import com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelper;
import com.deliveryhero.contract.model.ChatDetails;
import com.deliveryhero.contract.model.ChatPushData;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException;
import com.deliveryhero.customerchat.commons.UserChangedDuringChatOpenException;
import com.deliveryhero.customerchat.datastore.UserPropertiesDataStoreHelper;
import com.deliveryhero.customerchat.di.ModuleProviderKt;
import com.deliveryhero.customerchat.di.MyKoinContext;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.utils.DeviceUtils;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.service.ChatService;
import com.deliveryhero.customerchat.telephony.domain.TokuService;
import com.deliveryhero.customerchat.telephony.util.dispatcher.Dispatcher;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\r\u0010K\u001a\u0004\u0018\u00010H¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020HH\u0002J=\u0010N\u001a\u0004\u0018\u00010H2\u0006\u0010O\u001a\u00020P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020H0R2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0R¢\u0006\u0002\u0010VJ%\u0010W\u001a\b\u0012\u0004\u0012\u00020S0X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020P0XH@ø\u0001\u0000¢\u0006\u0002\u0010ZJK\u0010W\u001a\u0004\u0018\u00010H2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020P0X2\u0018\u0010Q\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0X\u0012\u0004\u0012\u00020H0R2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0RH\u0007¢\u0006\u0002\u0010[J\u0006\u0010\\\u001a\u00020\u0006J5\u0010]\u001a\u0004\u0018\u00010H2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020H0R2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0R¢\u0006\u0002\u0010_J=\u0010]\u001a\u0004\u0018\u00010H2\u0006\u0010O\u001a\u00020P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020H0R2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0R¢\u0006\u0002\u0010VJ>\u0010`\u001a\u0004\u0018\u00010a2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0c2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020H0e2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0RJ\u0010\u0010g\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u001c\u0010h\u001a\u00020i2\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P\u0018\u00010cJ\u0006\u0010k\u001a\u00020iJ\u001a\u0010l\u001a\u00020i2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0cJ\u001a\u0010m\u001a\u00020a2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0cJ\u0015\u0010n\u001a\u00020H2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\boJ\"\u0010p\u001a\u00020H2\u001a\u0010q\u001a\u0016\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020H\u0018\u00010Rj\u0004\u0018\u0001`sJ7\u0010t\u001a\u0004\u0018\u00010H2\u0006\u0010u\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020H0e2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0R¢\u0006\u0002\u0010vJ\u0012\u0010w\u001a\u00020H2\b\u0010x\u001a\u0004\u0018\u00010yH\u0002J5\u0010z\u001a\u0004\u0018\u00010H2\u0016\b\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H\u0018\u00010R2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020H0eH\u0002¢\u0006\u0002\u0010|J\b\u0010}\u001a\u00020HH\u0002J\u0010\u0010~\u001a\u00020H2\b\b\u0001\u0010\u001a\u00020^J\u000f\u0010\u0001\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ$\u0010\u0001\u001a\u00020H2\u0019\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0R¢\u0006\u0003\b\u0001H\u0007J\u0011\u0010\u0001\u001a\u00020i2\u0006\u0010I\u001a\u00020JH\u0002JE\u0010\u0001\u001a\u0004\u0018\u00010H2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010O\u001a\u00020P2\b\u0010\u0001\u001a\u00030\u00012\u0016\b\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H\u0018\u00010RH\u0007¢\u0006\u0003\u0010\u0001J1\u0010\u0001\u001a\u0004\u0018\u00010H2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020H0e2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020H0R¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020HH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\bA\u0010\n\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bD\u0010E\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/deliveryhero/customerchat/CustomerChatModule;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "chatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "getChatConfiguration", "()Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "chatConfiguration$delegate", "Lkotlin/Lazy;", "chatConfigurationDataStoreHelper", "Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelper;", "getChatConfigurationDataStoreHelper", "()Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelper;", "chatConfigurationDataStoreHelper$delegate", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "getChatFeatureCallbacks", "()Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "chatFeatureCallbacks$delegate", "chatService", "Lcom/deliveryhero/customerchat/service/ChatService;", "getChatService", "()Lcom/deliveryhero/customerchat/service/ChatService;", "chatService$delegate", "dataStoreCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;", "getDeviceUtils", "()Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;", "deviceUtils$delegate", "dispatchers", "Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "getDispatchers", "()Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "dispatchers$delegate", "eventHandler", "Lcom/deliveryhero/chatui/data/event/EventHandler;", "getEventHandler", "()Lcom/deliveryhero/chatui/data/event/EventHandler;", "eventHandler$delegate", "featureFlagCoroutineScope", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "getFeatureFlagProvider", "()Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "featureFlagProvider$delegate", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "parser", "Lcom/deliveryhero/contract/ChatPushNotificationParser;", "getParser", "()Lcom/deliveryhero/contract/ChatPushNotificationParser;", "parser$delegate", "stylingProvider", "Lcom/deliveryhero/chatui/view/util/StylingProvider;", "getStylingProvider", "()Lcom/deliveryhero/chatui/view/util/StylingProvider;", "stylingProvider$delegate", "tokuService", "Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "getTokuService", "()Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "tokuService$delegate", "userPropertiesDataStoreHelper", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "getUserPropertiesDataStoreHelper", "()Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "userPropertiesDataStoreHelper$delegate", "configureChat", "", "configBuilder", "Lcom/deliveryhero/contract/configuration/CustomerChatConfigurationBuilder;", "disconnect", "()Lkotlin/Unit;", "fetchUserFeatures", "getChatDetailsByChannel", "channelId", "", "onSuccess", "Lkotlin/Function1;", "Lcom/deliveryhero/contract/model/ChatDetails;", "onError", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "getChatDetailsByChannels", "", "channels", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "getCurrentChatConfiguration", "getUnreadCount", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "handlePush", "Lcom/deliveryhero/contract/model/ChatPushData;", "messageData", "", "onTrackingSuccess", "Lkotlin/Function0;", "onTrackingError", "initializeChatService", "isChatModuleMessage", "", "data", "isChatOpen", "isVoIPMessage", "parseMessage", "reconfigureSDK", "reconfigureSDK$customerchat_basicRelease", "registerEvents", "callback", "Lcom/deliveryhero/chatui/data/event/Event;", "Lcom/deliveryhero/chatui/data/event/EventCallback;", "registerToken", "token", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "registerUserIfNeeded", "userRegistrationData", "Lcom/deliveryhero/contract/configuration/UserRegistrationData;", "runIfInitialized", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "setAnalyticsProperties", "setChatStyle", "chatStyle", "setConfiguration", "configBlock", "Lkotlin/ExtensionFunctionType;", "shouldInitializeChatService", "startChat", "context", "Landroid/content/Context;", "deliveryInfo", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "(Landroid/content/Context;Ljava/lang/String;Lcom/deliveryhero/contract/model/DeliveryInfo;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "unregisterPush", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "updateConfigurationInDataStore", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule {
    /* access modifiers changed from: private */
    @NotNull
    public static final String CHAT_ACTIVITY_NAME;
    @NotNull
    public static final String CUSTOMER_CHAT_UNREAD_MESSAGE_COUNT_CHANGED = "CUSTOMER_CHAT_UNREAD_MESSAGE_COUNT_CHANGED";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static volatile CustomerChatModule INSTANCE;
    @NotNull
    private final Lazy chatConfiguration$delegate;
    @NotNull
    private final Lazy chatConfigurationDataStoreHelper$delegate;
    @NotNull
    private final Lazy chatFeatureCallbacks$delegate;
    @NotNull
    private final Lazy chatService$delegate;
    @NotNull
    private final CoroutineScope dataStoreCoroutineScope;
    @NotNull
    private final Lazy deviceUtils$delegate;
    @NotNull
    private final Lazy dispatchers$delegate;
    @NotNull
    private final Lazy eventHandler$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope featureFlagCoroutineScope;
    @NotNull
    private final Lazy featureFlagProvider$delegate;
    @NotNull
    private final AtomicBoolean isInitialized;
    @NotNull
    private final Lazy parser$delegate;
    @NotNull
    private final Lazy stylingProvider$delegate;
    @NotNull
    private final Lazy tokuService$delegate;
    @NotNull
    private final Lazy userPropertiesDataStoreHelper$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/customerchat/CustomerChatModule$Companion;", "", "()V", "CHAT_ACTIVITY_NAME", "", "getCHAT_ACTIVITY_NAME$annotations", "getCHAT_ACTIVITY_NAME", "()Ljava/lang/String;", "CUSTOMER_CHAT_UNREAD_MESSAGE_COUNT_CHANGED", "getCUSTOMER_CHAT_UNREAD_MESSAGE_COUNT_CHANGED$annotations", "INSTANCE", "Lcom/deliveryhero/customerchat/CustomerChatModule;", "getInstance", "application", "Landroid/app/Application;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCHAT_ACTIVITY_NAME$annotations() {
        }

        public static /* synthetic */ void getCUSTOMER_CHAT_UNREAD_MESSAGE_COUNT_CHANGED$annotations() {
        }

        @NotNull
        public final String getCHAT_ACTIVITY_NAME() {
            return CustomerChatModule.CHAT_ACTIVITY_NAME;
        }

        @NotNull
        public final CustomerChatModule getInstance(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            CustomerChatModule access$getINSTANCE$cp = CustomerChatModule.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                synchronized (this) {
                    access$getINSTANCE$cp = CustomerChatModule.INSTANCE;
                    if (access$getINSTANCE$cp == null) {
                        access$getINSTANCE$cp = new CustomerChatModule(application, (DefaultConstructorMarker) null);
                        CustomerChatModule.INSTANCE = access$getINSTANCE$cp;
                    }
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    static {
        String name2 = CustomerChatActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "CustomerChatActivity::class.java.name");
        CHAT_ACTIVITY_NAME = name2;
    }

    private CustomerChatModule(Application application) {
        MyKoinContext myKoinContext = MyKoinContext.INSTANCE;
        myKoinContext.init(application, ModuleProviderKt.getModules());
        this.isInitialized = new AtomicBoolean(false);
        Koin koin = myKoinContext.getKoin();
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        this.eventHandler$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$1(koin.getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.chatService$delegate = LazyKt__LazyJVMKt.lazy(CustomerChatModule$chatService$2.INSTANCE);
        this.parser$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$2(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.stylingProvider$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$3(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.tokuService$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$4(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.chatConfiguration$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$5(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.chatFeatureCallbacks$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$6(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.featureFlagProvider$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$7(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.deviceUtils$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$8(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.chatConfigurationDataStoreHelper$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$9(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.userPropertiesDataStoreHelper$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$10(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.dispatchers$delegate = LazyKt__LazyJVMKt.lazy(koinPlatformTools.defaultLazyMode(), new CustomerChatModule$special$$inlined$inject$default$11(myKoinContext.getKoin().getScopeRegistry().getRootScope(), (Qualifier) null, (Function0) null));
        this.featureFlagCoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(getDispatchers().main()));
        this.dataStoreCoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(getDispatchers().io()));
    }

    public /* synthetic */ CustomerChatModule(Application application, DefaultConstructorMarker defaultConstructorMarker) {
        this(application);
    }

    public static /* synthetic */ Unit a(CustomerChatModule customerChatModule, Function1 function1, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        return customerChatModule.runIfInitialized(function1, function0);
    }

    private final void configureChat(CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        getChatConfiguration().apply(customerChatConfigurationBuilder);
        getChatFeatureCallbacks().apply(customerChatConfigurationBuilder);
        updateConfigurationInDataStore();
    }

    private final void fetchUserFeatures() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.featureFlagCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CustomerChatModule$fetchUserFeatures$1(this, (Continuation<? super CustomerChatModule$fetchUserFeatures$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ChatConfiguration getChatConfiguration() {
        return (ChatConfiguration) this.chatConfiguration$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatConfigurationDataStoreHelper getChatConfigurationDataStoreHelper() {
        return (ChatConfigurationDataStoreHelper) this.chatConfigurationDataStoreHelper$delegate.getValue();
    }

    private final ChatFeatureCallbacks getChatFeatureCallbacks() {
        return (ChatFeatureCallbacks) this.chatFeatureCallbacks$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatService getChatService() {
        return (ChatService) this.chatService$delegate.getValue();
    }

    private final DeviceUtils getDeviceUtils() {
        return (DeviceUtils) this.deviceUtils$delegate.getValue();
    }

    private final Dispatcher getDispatchers() {
        return (Dispatcher) this.dispatchers$delegate.getValue();
    }

    private final EventHandler getEventHandler() {
        return (EventHandler) this.eventHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FeatureFlagProvider getFeatureFlagProvider() {
        return (FeatureFlagProvider) this.featureFlagProvider$delegate.getValue();
    }

    private final ChatPushNotificationParser getParser() {
        return (ChatPushNotificationParser) this.parser$delegate.getValue();
    }

    private final StylingProvider getStylingProvider() {
        return (StylingProvider) this.stylingProvider$delegate.getValue();
    }

    private final TokuService getTokuService() {
        return (TokuService) this.tokuService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UserPropertiesDataStoreHelper getUserPropertiesDataStoreHelper() {
        return (UserPropertiesDataStoreHelper) this.userPropertiesDataStoreHelper$delegate.getValue();
    }

    private final void initializeChatService(CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        if (shouldInitializeChatService(customerChatConfigurationBuilder)) {
            getChatService().init();
            this.isInitialized.getAndSet(true);
        }
        getChatService().initializeToku();
    }

    private final void registerUserIfNeeded(UserRegistrationData userRegistrationData) {
        if (userRegistrationData == null) {
            return;
        }
        if (!isChatOpen()) {
            getChatService().disconnect();
            getChatService().registerUser(userRegistrationData.getUserInfo(), userRegistrationData.getOnSuccess(), userRegistrationData.getOnError());
            return;
        }
        userRegistrationData.getOnError().invoke(new UserChangedDuringChatOpenException((String) null, 1, (DefaultConstructorMarker) null));
    }

    private final Unit runIfInitialized(Function1<? super Throwable, Unit> function1, Function0<Unit> function0) {
        if (this.isInitialized.get()) {
            function0.invoke();
            return Unit.INSTANCE;
        } else if (function1 == null) {
            return null;
        } else {
            function1.invoke(new CustomerChatNotInitializedException((String) null, 1, (DefaultConstructorMarker) null));
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void setAnalyticsProperties() {
        ChatConfiguration chatConfiguration = getChatConfiguration();
        if (chatConfiguration.getClientConfigOrNull() != null) {
            UserProperties userProperties = new UserProperties(chatConfiguration.getClientConfig().getUserType(), (String) null, getDeviceUtils().getDeviceName(), getDeviceUtils().getDeviceManufacturer(), getDeviceUtils().getDeviceOSVersion(), (String) null, getDeviceUtils().getSDKVersion(), getDeviceUtils().getHostAppIdentifier(), getDeviceUtils().getHostAppVersion(), (String) null, 546, (DefaultConstructorMarker) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.dataStoreCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CustomerChatModule$setAnalyticsProperties$1$1(this, userProperties, (Continuation<? super CustomerChatModule$setAnalyticsProperties$1$1>) null), 3, (Object) null);
        }
    }

    private final boolean shouldInitializeChatService(CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        if (customerChatConfigurationBuilder.getClientConfig() != null || (getChatConfiguration().getClientConfigOrNull() != null && !this.isInitialized.get())) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Unit startChat$default(CustomerChatModule customerChatModule, Context context, String str, DeliveryInfo deliveryInfo, Function1 function1, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        return customerChatModule.startChat(context, str, deliveryInfo, function1);
    }

    private final void updateConfigurationInDataStore() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.dataStoreCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CustomerChatModule$updateConfigurationInDataStore$1(this, (Continuation<? super CustomerChatModule$updateConfigurationInDataStore$1>) null), 3, (Object) null);
    }

    @Nullable
    public final Unit disconnect() {
        return a(this, (Function1) null, new CustomerChatModule$disconnect$1(this), 1, (Object) null);
    }

    @Nullable
    public final Unit getChatDetailsByChannel(@NotNull String str, @NotNull Function1<? super ChatDetails, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfInitialized(function12, new CustomerChatModule$getChatDetailsByChannel$1(this, str, function1, function12));
    }

    @Nullable
    public final Object getChatDetailsByChannels(@NotNull List<String> list, @NotNull Continuation<? super List<ChatDetails>> continuation) throws CustomerChatNotInitializedException, Exception {
        if (this.isInitialized.get()) {
            return getChatService().getChatDetailsByChannels(list, continuation);
        }
        throw new CustomerChatNotInitializedException((String) null, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final ChatConfiguration getCurrentChatConfiguration() {
        return getChatConfiguration();
    }

    @Nullable
    public final Unit getUnreadCount(@NotNull String str, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfInitialized(function12, new CustomerChatModule$getUnreadCount$1(this, str, function1, function12));
    }

    @Nullable
    public final ChatPushData handlePush(@NotNull Map<String, String> map, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "messageData");
        Intrinsics.checkNotNullParameter(function0, "onTrackingSuccess");
        Intrinsics.checkNotNullParameter(function1, "onTrackingError");
        getTokuService().onPushNotificationReceived(map);
        if (!getParser().canParse(map)) {
            return null;
        }
        ChatPushData parse = getParser().parse(map);
        PushNotificationTracker.INSTANCE.trackPushNotification(parse, function0, function1);
        return parse;
    }

    public final boolean isChatModuleMessage(@Nullable Map<String, String> map) {
        return getParser().canParse(map);
    }

    public final boolean isChatOpen() {
        return CustomerChatActivity.Companion.getVisible();
    }

    public final boolean isVoIPMessage(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return getTokuService().isVoIPPushMessage(map);
    }

    @NotNull
    public final ChatPushData parseMessage(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return getParser().parse(map);
    }

    public final void reconfigureSDK$customerchat_basicRelease(@NotNull ChatConfiguration chatConfiguration) {
        Intrinsics.checkNotNullParameter(chatConfiguration, "chatConfiguration");
        getChatConfiguration().forceApplyConfig(chatConfiguration);
        updateConfigurationInDataStore();
        getChatService().init();
        this.isInitialized.getAndSet(true);
        getChatService().initializeToku();
        getChatService().registerUser(chatConfiguration.getUserInfo(), CustomerChatModule$reconfigureSDK$1.INSTANCE, CustomerChatModule$reconfigureSDK$2.INSTANCE);
        setAnalyticsProperties();
    }

    public final void registerEvents(@Nullable Function1<? super Event, Unit> function1) {
        getEventHandler().register(function1);
    }

    @Nullable
    public final Unit registerToken(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return runIfInitialized(function1, new CustomerChatModule$registerToken$1(this, str, function0, function1));
    }

    public final void setChatStyle(@StyleRes int i11) {
        getStylingProvider().setChatStyleRes(i11);
    }

    public final void setConfiguration(@NotNull CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        Intrinsics.checkNotNullParameter(customerChatConfigurationBuilder, "configBuilder");
        configureChat(customerChatConfigurationBuilder);
        initializeChatService(customerChatConfigurationBuilder);
        registerUserIfNeeded(customerChatConfigurationBuilder.getUserRegistrationData());
        setAnalyticsProperties();
        fetchUserFeatures();
    }

    @Nullable
    @JvmOverloads
    public final Unit startChat(@NotNull Context context, @NotNull String str, @NotNull DeliveryInfo deliveryInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(deliveryInfo, "deliveryInfo");
        return startChat$default(this, context, str, deliveryInfo, (Function1) null, 8, (Object) null);
    }

    @Nullable
    @JvmOverloads
    public final Unit startChat(@NotNull Context context, @NotNull String str, @NotNull DeliveryInfo deliveryInfo, @Nullable Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(deliveryInfo, "deliveryInfo");
        return runIfInitialized(function1, new CustomerChatModule$startChat$1(str, function1, this, context, deliveryInfo));
    }

    @Nullable
    public final Unit unregisterPush(@NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return runIfInitialized(function1, new CustomerChatModule$unregisterPush$1(this, function0, function1));
    }

    @Nullable
    public final Unit getUnreadCount(@NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfInitialized(function12, new CustomerChatModule$getUnreadCount$2(this, function1, function12));
    }

    @Deprecated(message = "Since 6.3.0 and will be removed in future releases. Please replace with the coroutines counterpart.", replaceWith = @ReplaceWith(expression = "getChatDetailsByChannels(channels)", imports = {}))
    @Nullable
    public final Unit getChatDetailsByChannels(@NotNull List<String> list, @NotNull Function1<? super List<ChatDetails>, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "channels");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfInitialized(function12, new CustomerChatModule$getChatDetailsByChannels$2(this, list, function1, function12));
    }

    @CustomerChatSetConfigurationBuilderDSL
    public final void setConfiguration(@NotNull Function1<? super CustomerChatConfigurationBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "configBlock");
        CustomerChatConfigurationBuilder customerChatConfigurationBuilder = new CustomerChatConfigurationBuilder();
        function1.invoke(customerChatConfigurationBuilder);
        setConfiguration(customerChatConfigurationBuilder);
    }
}
