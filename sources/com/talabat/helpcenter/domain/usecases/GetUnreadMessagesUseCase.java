package com.talabat.helpcenter.domain.usecases;

import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import com.talabat.helpcenter.domain.repository.HelpCenterRepository;
import com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository;
import com.talabat.helpcenter.domain.util.JwtTokenExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/helpcenter/domain/usecases/GetUnreadMessagesUseCase;", "", "unreadChatMessagesRepository", "Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;", "helpCenterRepository", "Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;", "jwtTokenExtractor", "Lcom/talabat/helpcenter/domain/util/JwtTokenExtractor;", "language", "", "country", "", "appVersion", "appPlatform", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;Lcom/talabat/helpcenter/domain/util/JwtTokenExtractor;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetUnreadMessagesUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final String appPlatform;
    /* access modifiers changed from: private */
    @NotNull
    public final String appVersion;
    /* access modifiers changed from: private */
    public final int country;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final HelpCenterRepository helpCenterRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final JwtTokenExtractor jwtTokenExtractor;
    /* access modifiers changed from: private */
    @NotNull
    public final String language;
    /* access modifiers changed from: private */
    @NotNull
    public final UnreadChatMessagesRepository unreadChatMessagesRepository;

    public GetUnreadMessagesUseCase(@NotNull UnreadChatMessagesRepository unreadChatMessagesRepository2, @NotNull HelpCenterRepository helpCenterRepository2, @NotNull JwtTokenExtractor jwtTokenExtractor2, @NotNull String str, int i11, @NotNull String str2, @NotNull String str3, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(unreadChatMessagesRepository2, "unreadChatMessagesRepository");
        Intrinsics.checkNotNullParameter(helpCenterRepository2, "helpCenterRepository");
        Intrinsics.checkNotNullParameter(jwtTokenExtractor2, "jwtTokenExtractor");
        Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "appPlatform");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.unreadChatMessagesRepository = unreadChatMessagesRepository2;
        this.helpCenterRepository = helpCenterRepository2;
        this.jwtTokenExtractor = jwtTokenExtractor2;
        this.language = str;
        this.country = i11;
        this.appVersion = str2;
        this.appPlatform = str3;
        this.dispatcher = coroutineDispatcher;
    }

    @NotNull
    public final Flow<UnreadChatMessages> execute() {
        return FlowKt.flowOn(FlowKt.flow(new GetUnreadMessagesUseCase$execute$1(this, (Continuation<? super GetUnreadMessagesUseCase$execute$1>) null)), this.dispatcher);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUnreadMessagesUseCase(UnreadChatMessagesRepository unreadChatMessagesRepository2, HelpCenterRepository helpCenterRepository2, JwtTokenExtractor jwtTokenExtractor2, String str, int i11, String str2, String str3, CoroutineDispatcher coroutineDispatcher, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(unreadChatMessagesRepository2, helpCenterRepository2, jwtTokenExtractor2, str, i11, str2, str3, (i12 & 128) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }
}
