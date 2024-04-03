package com.talabat.helpcenter.data.repository;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.helpcenter.data.datasources.remote.ChatMessagesDataSource;
import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/talabat/helpcenter/data/repository/UnreadChatMessagesRepositoryImpl;", "Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;", "chatMessagesDataSource", "Lcom/talabat/helpcenter/data/datasources/remote/ChatMessagesDataSource;", "delay", "Lkotlin/time/Duration;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/helpcenter/data/datasources/remote/ChatMessagesDataSource;JLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "activationFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "J", "createUnreadMessagesFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "token", "", "getUnreadMessages", "isActive", "setActive", "", "active", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnreadChatMessagesRepositoryImpl implements UnreadChatMessagesRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TRIES_ON_ERROR = 3;
    @NotNull
    private final MutableStateFlow<Boolean> activationFlow;
    /* access modifiers changed from: private */
    @NotNull
    public final ChatMessagesDataSource chatMessagesDataSource;
    /* access modifiers changed from: private */
    public final long delay;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/helpcenter/data/repository/UnreadChatMessagesRepositoryImpl$Companion;", "", "()V", "MAX_TRIES_ON_ERROR", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UnreadChatMessagesRepositoryImpl(ChatMessagesDataSource chatMessagesDataSource2, long j11, CoroutineDispatcher coroutineDispatcher) {
        this.chatMessagesDataSource = chatMessagesDataSource2;
        this.delay = j11;
        this.ioDispatcher = coroutineDispatcher;
        this.activationFlow = StateFlowKt.MutableStateFlow(Boolean.TRUE);
    }

    public /* synthetic */ UnreadChatMessagesRepositoryImpl(ChatMessagesDataSource chatMessagesDataSource2, long j11, CoroutineDispatcher coroutineDispatcher, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatMessagesDataSource2, j11, coroutineDispatcher);
    }

    /* access modifiers changed from: private */
    public final Flow<UnreadChatMessages> createUnreadMessagesFlow(String str) {
        return FlowKt.distinctUntilChanged(FlowKt.flow(new UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1(this, str, (Continuation<? super UnreadChatMessagesRepositoryImpl$createUnreadMessagesFlow$1>) null)));
    }

    @NotNull
    public Flow<UnreadChatMessages> getUnreadMessages(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        return FlowKt.flowOn(FlowKt.transformLatest(this.activationFlow, new UnreadChatMessagesRepositoryImpl$getUnreadMessages$$inlined$flatMapLatest$1((Continuation) null, this, str)), this.ioDispatcher);
    }

    public boolean isActive() {
        return this.activationFlow.getValue().booleanValue();
    }

    @Nullable
    public Object setActive(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object emit = this.activationFlow.emit(Boxing.boxBoolean(z11), continuation);
        return emit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnreadChatMessagesRepositoryImpl(ChatMessagesDataSource chatMessagesDataSource2, long j11, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatMessagesDataSource2, (i11 & 2) != 0 ? Duration.Companion.m7730minutesUwyO8pc(1) : j11, (i11 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (DefaultConstructorMarker) null);
    }
}
