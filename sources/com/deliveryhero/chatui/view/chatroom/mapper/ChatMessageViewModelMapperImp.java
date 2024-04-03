package com.deliveryhero.chatui.view.chatroom.mapper;

import com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel;
import com.deliveryhero.chatui.view.chatroom.ImageMessage;
import com.deliveryhero.chatui.view.chatroom.LocationMessage;
import com.deliveryhero.chatui.view.chatroom.TextMessage;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.AdminMessage;
import com.deliveryhero.contract.model.BaseLocationMessage;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.FileMessage;
import com.deliveryhero.contract.model.Receipt;
import com.deliveryhero.contract.model.SenderType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.User;
import com.deliveryhero.contract.model.UserKt;
import com.deliveryhero.contract.model.UserMessage;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.helpers.dateProvider.DateProvider;
import com.deliveryhero.customerchat.service.ChannelService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J5\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010(J/\u0010$\u001a\b\u0012\u0004\u0012\u00020%0)2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140)H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u001a\u00102\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u00103\u001a\u00020%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/mapper/ChatMessageViewModelMapperImp;", "Lcom/deliveryhero/chatui/view/chatroom/mapper/ChatMessageViewModelMapper;", "service", "Lcom/deliveryhero/customerchat/service/ChannelService;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "dateProvider", "Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProvider;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "(Lcom/deliveryhero/customerchat/service/ChannelService;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProvider;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;)V", "userId", "", "getUserId", "()Ljava/lang/String;", "userId$delegate", "Lkotlin/Lazy;", "findOriginal", "Lcom/deliveryhero/chatui/view/chatroom/TextMessage;", "chatMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "findTranslation", "preferredLanguage", "getImageMessage", "Lcom/deliveryhero/chatui/view/chatroom/ImageMessage;", "error", "", "getLocationMessage", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "getSenderName", "showSenderName", "", "user", "Lcom/deliveryhero/contract/model/User;", "getUser", "isMyMessage", "map", "Lcom/deliveryhero/chatui/view/chatroom/ChatMessageViewModel;", "index", "", "(ILjava/lang/String;Lcom/deliveryhero/contract/model/BaseMessage;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "list", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDate", "time", "", "messageReceipt", "Lcom/deliveryhero/contract/model/Receipt;", "baseMessage", "translate", "chatMessageViewModel", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatMessageViewModelMapperImp implements ChatMessageViewModelMapper {
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final DateProvider dateProvider;
    @NotNull
    private final FeatureFlagProvider featureFlagProvider;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    public final ChannelService f29635service;
    @NotNull
    private final Lazy userId$delegate = LazyKt__LazyJVMKt.lazy(new ChatMessageViewModelMapperImp$userId$2(this));

    public ChatMessageViewModelMapperImp(@NotNull ChannelService channelService, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull DateProvider dateProvider2, @NotNull FeatureFlagProvider featureFlagProvider2) {
        Intrinsics.checkNotNullParameter(channelService, "service");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        this.f29635service = channelService;
        this.chatConfigProvider = chatConfigProvider2;
        this.dateProvider = dateProvider2;
        this.featureFlagProvider = featureFlagProvider2;
    }

    private final TextMessage findOriginal(BaseMessage baseMessage) {
        if (baseMessage instanceof UserMessage) {
            return new TextMessage(0, ((UserMessage) baseMessage).getMessage());
        }
        if (baseMessage instanceof AdminMessage) {
            return new TextMessage(0, ((AdminMessage) baseMessage).getMessage());
        }
        return new TextMessage(8, (String) null, 2, (DefaultConstructorMarker) null);
    }

    private final String findTranslation(BaseMessage baseMessage, String str) {
        UserMessage userMessage;
        Map<String, String> map;
        if (baseMessage instanceof UserMessage) {
            userMessage = (UserMessage) baseMessage;
        } else {
            userMessage = null;
        }
        if (userMessage != null) {
            map = userMessage.getTranslations();
        } else {
            map = null;
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private final ImageMessage getImageMessage(BaseMessage baseMessage, Throwable th2) {
        if (!(baseMessage instanceof FileMessage)) {
            return new ImageMessage.Hidden(0, 1, (DefaultConstructorMarker) null);
        }
        if (th2 != null) {
            return new ImageMessage.UploadFailed(0, (String) null, 2, (DefaultConstructorMarker) null);
        }
        FileMessage fileMessage = (FileMessage) baseMessage;
        if (!fileMessage.getThumbnails().isEmpty()) {
            return new ImageMessage.Downloading(0, (FileMessage.Thumbnail) CollectionsKt___CollectionsKt.first(fileMessage.getThumbnails()), fileMessage.getUrl());
        }
        return new ImageMessage.UploadFailed(0, (String) null, 2, (DefaultConstructorMarker) null);
    }

    private final LocationMessage getLocationMessage(BaseMessage baseMessage) {
        if (!(baseMessage instanceof BaseLocationMessage)) {
            return LocationMessage.Hidden.INSTANCE;
        }
        BaseLocationMessage baseLocationMessage = (BaseLocationMessage) baseMessage;
        return new LocationMessage.Location(baseLocationMessage.getLatitude(), baseLocationMessage.getLongitude());
    }

    private final String getSenderName(BaseMessage baseMessage, boolean z11, User user) {
        if ((baseMessage instanceof AdminMessage) || !z11) {
            return null;
        }
        return user.getName();
    }

    private final User getUser(BaseMessage baseMessage) {
        if (baseMessage instanceof UserMessage) {
            return ((UserMessage) baseMessage).getSender();
        }
        if (baseMessage instanceof FileMessage) {
            return ((FileMessage) baseMessage).getSender();
        }
        if (baseMessage instanceof BaseLocationMessage) {
            return ((BaseLocationMessage) baseMessage).getSender();
        }
        if (baseMessage instanceof AdminMessage) {
            return new User("", "Admin", SenderType.ADMIN);
        }
        return UserKt.getUNKNOWN_USER();
    }

    private final String getUserId() {
        return (String) this.userId$delegate.getValue();
    }

    private final boolean isMyMessage(User user) {
        return Intrinsics.areEqual((Object) getUserId(), (Object) user.getId());
    }

    private final String mapDate(long j11) {
        return this.dateProvider.formatTime(j11, "HH:mm");
    }

    private final Receipt messageReceipt(BaseMessage baseMessage) {
        return this.f29635service.messageReceipt(baseMessage);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object map(@org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.NotNull java.util.List<? extends com.deliveryhero.contract.model.BaseMessage> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel>> r21) {
        /*
            r18 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$1 r1 = (com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$1) r1
            int r2 = r1.f29644p
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f29644p = r2
            r2 = r18
            goto L_0x001e
        L_0x0017:
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$1 r1 = new com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$1
            r2 = r18
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f29642n
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.f29644p
            r5 = 1
            if (r4 == 0) goto L_0x0051
            if (r4 != r5) goto L_0x0049
            int r4 = r1.f29641m
            java.lang.Object r6 = r1.f29640l
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r1.f29639k
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.f29638j
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r9 = r1.f29637i
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r1.f29636h
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp r10 = (com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r17 = r4
            r4 = r7
            r15 = r10
            goto L_0x00a6
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r20
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r6)
            r4.<init>(r6)
            java.util.Iterator r0 = r0.iterator()
            r6 = 0
            r15 = r2
            r8 = r6
            r6 = r4
            r4 = r0
            r0 = r19
        L_0x006e:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00b0
            java.lang.Object r7 = r4.next()
            int r14 = r8 + 1
            if (r8 >= 0) goto L_0x007f
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x007f:
            r10 = r7
            com.deliveryhero.contract.model.BaseMessage r10 = (com.deliveryhero.contract.model.BaseMessage) r10
            r11 = 0
            r13 = 8
            r16 = 0
            r1.f29636h = r15
            r1.f29637i = r0
            r1.f29638j = r6
            r1.f29639k = r4
            r1.f29640l = r6
            r1.f29641m = r14
            r1.f29644p = r5
            r7 = r15
            r9 = r0
            r12 = r1
            r17 = r14
            r14 = r16
            java.lang.Object r7 = com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapper.DefaultImpls.map$default(r7, r8, r9, r10, r11, r12, r13, r14)
            if (r7 != r3) goto L_0x00a3
            return r3
        L_0x00a3:
            r9 = r0
            r8 = r6
            r0 = r7
        L_0x00a6:
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r0 = (com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel) r0
            r6.add(r0)
            r6 = r8
            r0 = r9
            r8 = r17
            goto L_0x006e
        L_0x00b0:
            java.util.List r6 = (java.util.List) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp.map(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public ChatMessageViewModel translate(@Nullable String str, @NotNull ChatMessageViewModel chatMessageViewModel) {
        boolean z11;
        boolean z12;
        TextMessage textMessage;
        Translations translations;
        Intrinsics.checkNotNullParameter(chatMessageViewModel, "chatMessageViewModel");
        String findTranslation = findTranslation(chatMessageViewModel.getChatMessage(), str);
        TextMessage findOriginal = findOriginal(chatMessageViewModel.getChatMessage());
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (translations = chatConfiguration.getTranslations()) == null || !translations.getShouldShowOriginalWithTranslated()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (findTranslation != null) {
                textMessage = new TextMessage(0, findTranslation, 1, (DefaultConstructorMarker) null);
            } else {
                textMessage = null;
            }
            return ChatMessageViewModel.copy$default(chatMessageViewModel, 0, (TextMessage) null, textMessage, (ImageMessage) null, (LocationMessage) null, (String) null, false, (Receipt) null, (BaseMessage) null, (String) null, 1019, (Object) null);
        }
        if (findTranslation == null || findTranslation.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            findOriginal = new TextMessage(0, findTranslation, 1, (DefaultConstructorMarker) null);
        }
        return ChatMessageViewModel.copy$default(chatMessageViewModel, 0, findOriginal, (TextMessage) null, (ImageMessage) null, (LocationMessage) null, (String) null, false, (Receipt) null, (BaseMessage) null, (String) null, 1017, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        r9 = r9.getTranslations();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object map(int r22, @org.jetbrains.annotations.Nullable java.lang.String r23, @org.jetbrains.annotations.NotNull com.deliveryhero.contract.model.BaseMessage r24, @org.jetbrains.annotations.Nullable java.lang.Throwable r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel> r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r24
            r2 = r26
            boolean r3 = r2 instanceof com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$3
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$3 r3 = (com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$3) r3
            int r4 = r3.f29654q
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f29654q = r4
            goto L_0x001e
        L_0x0019:
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$3 r3 = new com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp$map$3
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f29652o
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f29654q
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0056
            if (r5 != r7) goto L_0x004e
            int r1 = r3.f29651n
            java.lang.Object r4 = r3.f29650m
            com.deliveryhero.chatui.view.chatroom.ImageMessage r4 = (com.deliveryhero.chatui.view.chatroom.ImageMessage) r4
            java.lang.Object r5 = r3.f29649l
            com.deliveryhero.contract.model.User r5 = (com.deliveryhero.contract.model.User) r5
            java.lang.Object r7 = r3.f29648k
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r3.f29647j
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r3.f29646i
            com.deliveryhero.contract.model.BaseMessage r9 = (com.deliveryhero.contract.model.BaseMessage) r9
            java.lang.Object r3 = r3.f29645h
            com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp r3 = (com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r11 = r1
            r14 = r4
            r1 = r9
            goto L_0x00ca
        L_0x004e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r23
            java.lang.String r2 = r0.findTranslation(r1, r2)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            com.deliveryhero.chatui.view.chatroom.TextMessage r5 = r0.findOriginal(r1)
            r8.element = r5
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            if (r2 == 0) goto L_0x00a0
            com.deliveryhero.customerchat.configuration.ChatConfigProvider r9 = r0.chatConfigProvider
            com.deliveryhero.contract.configuration.ChatConfiguration r9 = r9.getChatConfiguration()
            if (r9 == 0) goto L_0x0087
            com.deliveryhero.contract.model.Translations r9 = r9.getTranslations()
            if (r9 == 0) goto L_0x0087
            boolean r9 = r9.getShouldShowOriginalWithTranslated()
            if (r9 != r7) goto L_0x0087
            r9 = r7
            goto L_0x0088
        L_0x0087:
            r9 = r6
        L_0x0088:
            if (r9 == 0) goto L_0x0092
            com.deliveryhero.chatui.view.chatroom.TextMessage r9 = new com.deliveryhero.chatui.view.chatroom.TextMessage
            r9.<init>(r6, r2)
            r5.element = r9
            goto L_0x00a0
        L_0x0092:
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x00a0
            com.deliveryhero.chatui.view.chatroom.TextMessage r9 = new com.deliveryhero.chatui.view.chatroom.TextMessage
            r9.<init>(r6, r2)
            r8.element = r9
        L_0x00a0:
            com.deliveryhero.contract.model.User r2 = r0.getUser(r1)
            r9 = r25
            com.deliveryhero.chatui.view.chatroom.ImageMessage r9 = r0.getImageMessage(r1, r9)
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r10 = r0.featureFlagProvider
            r3.f29645h = r0
            r3.f29646i = r1
            r3.f29647j = r8
            r3.f29648k = r5
            r3.f29649l = r2
            r3.f29650m = r9
            r11 = r22
            r3.f29651n = r11
            r3.f29654q = r7
            java.lang.Object r3 = r10.getUserFeatureFlags(r3)
            if (r3 != r4) goto L_0x00c5
            return r4
        L_0x00c5:
            r7 = r5
            r14 = r9
            r5 = r2
            r2 = r3
            r3 = r0
        L_0x00ca:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r2 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r2
            if (r2 == 0) goto L_0x00d2
            boolean r6 = r2.isShowSenderNameEnabled()
        L_0x00d2:
            java.lang.String r20 = r3.getSenderName(r1, r6, r5)
            com.deliveryhero.chatui.view.chatroom.LocationMessage r15 = r3.getLocationMessage(r1)
            com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel r2 = new com.deliveryhero.chatui.view.chatroom.ChatMessageViewModel
            T r4 = r8.element
            r12 = r4
            com.deliveryhero.chatui.view.chatroom.TextMessage r12 = (com.deliveryhero.chatui.view.chatroom.TextMessage) r12
            T r4 = r7.element
            r13 = r4
            com.deliveryhero.chatui.view.chatroom.TextMessage r13 = (com.deliveryhero.chatui.view.chatroom.TextMessage) r13
            long r6 = r1.getCreatedAt()
            java.lang.String r16 = r3.mapDate(r6)
            boolean r17 = r3.isMyMessage(r5)
            com.deliveryhero.contract.model.Receipt r18 = r3.messageReceipt(r1)
            r10 = r2
            r19 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatui.view.chatroom.mapper.ChatMessageViewModelMapperImp.map(int, java.lang.String, com.deliveryhero.contract.model.BaseMessage, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
