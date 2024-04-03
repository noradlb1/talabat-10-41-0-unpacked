package com.deliveryhero.customerchat;

import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.CustomerChatModule$updateConfigurationInDataStore$1", f = "CustomerChatModule.kt", i = {}, l = {419}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerChatModule$updateConfigurationInDataStore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29795h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerChatModule f29796i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatModule$updateConfigurationInDataStore$1(CustomerChatModule customerChatModule, Continuation<? super CustomerChatModule$updateConfigurationInDataStore$1> continuation) {
        super(2, continuation);
        this.f29796i = customerChatModule;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerChatModule$updateConfigurationInDataStore$1(this.f29796i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomerChatModule$updateConfigurationInDataStore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29795h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChatConfigurationDataStoreHelper access$getChatConfigurationDataStoreHelper = this.f29796i.getChatConfigurationDataStoreHelper();
            PersistableChatConfiguration persistableChatConfiguration = this.f29796i.getChatConfiguration().toPersistableChatConfiguration();
            this.f29795h = 1;
            if (access$getChatConfigurationDataStoreHelper.updateChatConfigurationToDataStore(persistableChatConfiguration, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
