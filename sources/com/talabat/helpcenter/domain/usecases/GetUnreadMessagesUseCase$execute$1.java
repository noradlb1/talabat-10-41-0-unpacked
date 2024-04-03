package com.talabat.helpcenter.domain.usecases;

import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase$execute$1", f = "GetUnreadMessagesUseCase.kt", i = {0, 1, 2, 4}, l = {31, 34, 43, 47, 49, 50}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class GetUnreadMessagesUseCase$execute$1 extends SuspendLambda implements Function2<FlowCollector<? super UnreadChatMessages>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60750h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetUnreadMessagesUseCase f60751i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUnreadMessagesUseCase$execute$1(GetUnreadMessagesUseCase getUnreadMessagesUseCase, Continuation<? super GetUnreadMessagesUseCase$execute$1> continuation) {
        super(2, continuation);
        this.f60751i = getUnreadMessagesUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetUnreadMessagesUseCase$execute$1 getUnreadMessagesUseCase$execute$1 = new GetUnreadMessagesUseCase$execute$1(this.f60751i, continuation);
        getUnreadMessagesUseCase$execute$1.L$0 = obj;
        return getUnreadMessagesUseCase$execute$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super UnreadChatMessages> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((GetUnreadMessagesUseCase$execute$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        r13 = r12.f60751i.unreadChatMessagesRepository.getUnreadMessages(r12.f60751i.jwtTokenExtractor.extractToken(((com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig) r13).getHelpCenterUrl()));
        r4 = new com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase$execute$1.AnonymousClass1();
        r12.L$0 = r1;
        r12.f60750h = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b7, code lost:
        if (r13.collect(r4, r12) != r0) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b9, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.f60750h
            r2 = 0
            r3 = 0
            switch(r1) {
                case 0: goto L_0x003a;
                case 1: goto L_0x0032;
                case 2: goto L_0x002a;
                case 3: goto L_0x0021;
                case 4: goto L_0x0013;
                case 5: goto L_0x0018;
                case 6: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0013:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ee
        L_0x0018:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00cc
        L_0x0021:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            goto L_0x00ee
        L_0x002a:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            goto L_0x008f
        L_0x0032:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            goto L_0x005f
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository r13 = r13.unreadChatMessagesRepository     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            boolean r13 = r13.isActive()     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            if (r13 != 0) goto L_0x0062
            com.talabat.helpcenter.domain.entity.UnreadChatMessages r13 = new com.talabat.helpcenter.domain.entity.UnreadChatMessages     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r13.<init>(r3, r3)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r12.L$0 = r1     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r4 = 1
            r12.f60750h = r4     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.Object r13 = r1.emit(r13, r12)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            if (r13 != r0) goto L_0x005f
            return r0
        L_0x005f:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            return r13
        L_0x0062:
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.repository.HelpCenterRepository r4 = r13.helpCenterRepository     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r5 = 0
            r6 = 0
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.String r7 = r13.language     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            int r8 = r13.country     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.String r9 = r13.appVersion     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.String r10 = r13.appPlatform     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r12.L$0 = r1     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r13 = 2
            r12.f60750h = r13     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r11 = r12
            java.lang.Object r13 = r4.getGlobalHelpCenterConfig(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            if (r13 != r0) goto L_0x008f
            return r0
        L_0x008f:
            com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig r13 = (com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig) r13     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r4 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.util.JwtTokenExtractor r4 = r4.jwtTokenExtractor     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.String r13 = r13.getHelpCenterUrl()     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.String r13 = r4.extractToken(r13)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r4 = r12.f60751i     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository r4 = r4.unreadChatMessagesRepository     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            kotlinx.coroutines.flow.Flow r13 = r4.getUnreadMessages(r13)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase$execute$1$1 r4 = new com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase$execute$1$1     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r4.<init>(r1)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r12.L$0 = r1     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            r5 = 3
            r12.f60750h = r5     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            java.lang.Object r13 = r13.collect(r4, r12)     // Catch:{ UnableToFetchGlobalHelpCenterConfig -> 0x00dd, UnableToFetchUnreadChatMessages -> 0x00ba }
            if (r13 != r0) goto L_0x00ee
            return r0
        L_0x00ba:
            com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase r13 = r12.f60751i
            com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository r13 = r13.unreadChatMessagesRepository
            r12.L$0 = r1
            r4 = 5
            r12.f60750h = r4
            java.lang.Object r13 = r13.setActive(r3, r12)
            if (r13 != r0) goto L_0x00cc
            return r0
        L_0x00cc:
            com.talabat.helpcenter.domain.entity.UnreadChatMessages r13 = new com.talabat.helpcenter.domain.entity.UnreadChatMessages
            r13.<init>(r3, r3)
            r12.L$0 = r2
            r2 = 6
            r12.f60750h = r2
            java.lang.Object r13 = r1.emit(r13, r12)
            if (r13 != r0) goto L_0x00ee
            return r0
        L_0x00dd:
            com.talabat.helpcenter.domain.entity.UnreadChatMessages r13 = new com.talabat.helpcenter.domain.entity.UnreadChatMessages
            r13.<init>(r3, r3)
            r12.L$0 = r2
            r2 = 4
            r12.f60750h = r2
            java.lang.Object r13 = r1.emit(r13, r12)
            if (r13 != r0) goto L_0x00ee
            return r0
        L_0x00ee:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase$execute$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
