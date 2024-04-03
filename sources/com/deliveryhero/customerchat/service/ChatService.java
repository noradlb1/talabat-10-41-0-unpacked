package com.deliveryhero.customerchat.service;

import android.content.Context;
import com.deliveryhero.chatui.view.root.CustomerChatActivity;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.ChatRepository;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.model.ChatDetails;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException;
import com.deliveryhero.customerchat.commons.UserNotRegisteredException;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.telephony.domain.TokuService;
import com.deliveryhero.customerchat.telephony.domain.TokuUserStatus;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J=\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010\u0019J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJB\u0010\u001a\u001a\u00020\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001b\u0012\u0004\u0012\u00020\u00100\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015J5\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010!J=\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010\u0019J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J7\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010'J7\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010)\u001a\u00020*2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u0010+J5\u0010,\u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100&H\u0002¢\u0006\u0002\u0010.J$\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015J/\u00102\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100&2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u000206H\u0002J\u001d\u0010\u0012\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u00107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/deliveryhero/customerchat/service/ChatService;", "", "repository", "Lcom/deliveryhero/contract/ChatRepository;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "tokuService", "Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "(Lcom/deliveryhero/contract/ChatRepository;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/telephony/domain/TokuService;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;)V", "isRepoInitialized", "", "registeringGccNotInitialized", "", "disconnect", "", "()Lkotlin/Unit;", "getChatDetailsByChannel", "channelId", "onSuccess", "Lkotlin/Function1;", "Lcom/deliveryhero/contract/model/ChatDetails;", "onError", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "getChatDetailsByChannels", "", "channels", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "getUnreadCount", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "init", "initializeToku", "registerToken", "token", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "registerUser", "userInfo", "Lcom/deliveryhero/contract/model/UserInfo;", "(Lcom/deliveryhero/contract/model/UserInfo;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "runIfRepoInitialized", "block", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "startChat", "context", "Landroid/content/Context;", "unregisterPush", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "updateTokuUserStatus", "userStatus", "Lcom/deliveryhero/customerchat/telephony/domain/TokuUserStatus;", "(Lcom/deliveryhero/contract/ChatRepository;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatService {
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final ChatFeatureCallbacks chatFeatureCallbacks;
    /* access modifiers changed from: private */
    public boolean isRepoInitialized;
    /* access modifiers changed from: private */
    @NotNull
    public final String registeringGccNotInitialized = "Registering: GCC not initialized";
    /* access modifiers changed from: private */
    @NotNull
    public final ChatRepository repository;
    @NotNull
    private final TokuService tokuService;

    public ChatService(@NotNull ChatRepository chatRepository, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull TokuService tokuService2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2) {
        Intrinsics.checkNotNullParameter(chatRepository, "repository");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(tokuService2, "tokuService");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        this.repository = chatRepository;
        this.chatConfigProvider = chatConfigProvider2;
        this.tokuService = tokuService2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
    }

    public static /* synthetic */ Unit a(ChatService chatService, Function1 function1, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        return chatService.runIfRepoInitialized(function1, function0);
    }

    private final Unit runIfRepoInitialized(Function1<? super Throwable, Unit> function1, Function0<Unit> function0) {
        if (this.isRepoInitialized) {
            function0.invoke();
            return Unit.INSTANCE;
        } else if (function1 == null) {
            return null;
        } else {
            function1.invoke(new CustomerChatNotInitializedException(this.registeringGccNotInitialized));
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void updateTokuUserStatus(TokuUserStatus tokuUserStatus) {
        UserInfo userInfoOrNull;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null && (chatConfiguration.getPhoneCallingType() instanceof PhoneCallType.Toku) && (userInfoOrNull = chatConfiguration.getUserInfoOrNull()) != null) {
            this.tokuService.updateUserStatus(userInfoOrNull.getId(), tokuUserStatus);
        }
    }

    @Nullable
    public final Unit disconnect() {
        return a(this, (Function1) null, new ChatService$disconnect$1(this), 1, (Object) null);
    }

    @Nullable
    public final Unit getChatDetailsByChannel(@NotNull String str, @NotNull Function1<? super ChatDetails, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfRepoInitialized(function12, new ChatService$getChatDetailsByChannel$1(this, str, function1, function12));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getChatDetailsByChannels(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.deliveryhero.contract.model.ChatDetails>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$1 r0 = (com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$1) r0
            int r1 = r0.f30022n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30022n = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$1 r0 = new com.deliveryhero.customerchat.service.ChatService$getChatDetailsByChannels$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f30020l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30022n
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r7 = r0.f30019k
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r2 = r0.f30018j
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f30017i
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.f30016h
            com.deliveryhero.customerchat.service.ChatService r5 = (com.deliveryhero.customerchat.service.ChatService) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007c
        L_0x0039:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6.isRepoInitialized
            if (r8 == 0) goto L_0x0086
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r2)
            r8.<init>(r2)
            java.util.Iterator r7 = r7.iterator()
            r5 = r6
            r2 = r7
            r7 = r8
        L_0x005c:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0083
            java.lang.Object r8 = r2.next()
            java.lang.String r8 = (java.lang.String) r8
            com.deliveryhero.contract.ChatRepository r4 = r5.repository
            r0.f30016h = r5
            r0.f30017i = r7
            r0.f30018j = r2
            r0.f30019k = r7
            r0.f30022n = r3
            java.lang.Object r8 = r5.getChatDetailsByChannel((com.deliveryhero.contract.ChatRepository) r4, (java.lang.String) r8, (kotlin.coroutines.Continuation<? super com.deliveryhero.contract.model.ChatDetails>) r0)
            if (r8 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r4 = r7
        L_0x007c:
            com.deliveryhero.contract.model.ChatDetails r8 = (com.deliveryhero.contract.model.ChatDetails) r8
            r7.add(r8)
            r7 = r4
            goto L_0x005c
        L_0x0083:
            java.util.List r7 = (java.util.List) r7
            return r7
        L_0x0086:
            com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException r7 = new com.deliveryhero.customerchat.commons.CustomerChatNotInitializedException
            java.lang.String r8 = r6.registeringGccNotInitialized
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.service.ChatService.getChatDetailsByChannels(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Unit getUnreadCount(@NotNull String str, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfRepoInitialized(function12, new ChatService$getUnreadCount$1(this, str, function1, function12));
    }

    public final void init() {
        this.repository.init();
        this.isRepoInitialized = true;
    }

    public final void initializeToku() {
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            PhoneCallType phoneCallingType = chatConfiguration.getPhoneCallingType();
            if (!(phoneCallingType instanceof PhoneCallType.Toku)) {
                this.tokuService.stop();
            } else if (chatConfiguration.getUserInfoOrNull() != null && chatConfiguration.getClientConfigOrNull() != null) {
                this.tokuService.init(((PhoneCallType.Toku) phoneCallingType).getLicenseKey(), chatConfiguration.getUserInfo().getId(), chatConfiguration.getEnableVoipLogging());
            }
        }
    }

    @Nullable
    public final Unit registerToken(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return a(this, (Function1) null, new ChatService$registerToken$1(this, str, function0, function1), 1, (Object) null);
    }

    @Nullable
    public final Unit registerUser(@NotNull UserInfo userInfo, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return runIfRepoInitialized(function1, new ChatService$registerUser$1(this, userInfo, function0, function1));
    }

    public final void startChat(@NotNull Context context, @Nullable Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.isRepoInitialized) {
            ChatLogger chatLogger = this.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                chatLogger.log(Events.CHAT_OPEN_FAILED_EVENT, MapsKt__MapsKt.emptyMap());
            }
            if (function1 != null) {
                function1.invoke(new CustomerChatNotInitializedException(this.registeringGccNotInitialized));
            }
        } else if (this.repository.isChatReadyToUse()) {
            CustomerChatActivity.Companion.newInstance(context);
        } else if (function1 != null) {
            function1.invoke(new UserNotRegisteredException((String) null, 1, (DefaultConstructorMarker) null));
        }
    }

    @Nullable
    public final Unit unregisterPush(@NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        return a(this, (Function1) null, new ChatService$unregisterPush$1(this, function0, function1), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object getChatDetailsByChannel(ChatRepository chatRepository, String str, Continuation<? super ChatDetails> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        chatRepository.getChatDetailsByChannel(str, new ChatService$getChatDetailsByChannel$3$1(safeContinuation), new ChatService$getChatDetailsByChannel$3$2(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Unit getUnreadCount(@NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return runIfRepoInitialized(function12, new ChatService$getUnreadCount$2(this, function1, function12));
    }

    @NotNull
    public final Job getChatDetailsByChannels(@NotNull List<String> list, @NotNull Function1<? super List<ChatDetails>, Unit> function1, @NotNull Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "channels");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        return BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ChatService$getChatDetailsByChannels$3(list, function1, function12, this, (Continuation<? super ChatService$getChatDetailsByChannels$3>) null), 2, (Object) null);
    }
}
