package com.deliveryhero.contract.datastore;

import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2", f = "ChatConfigurationDataStoreHelperImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2 extends SuspendLambda implements Function2<PersistableChatConfiguration, Continuation<? super PersistableChatConfiguration>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29716h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PersistableChatConfiguration f29717i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2(PersistableChatConfiguration persistableChatConfiguration, Continuation<? super ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2> continuation) {
        super(2, continuation);
        this.f29717i = persistableChatConfiguration;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2(this.f29717i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull PersistableChatConfiguration persistableChatConfiguration, @Nullable Continuation<? super PersistableChatConfiguration> continuation) {
        return ((ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2) create(persistableChatConfiguration, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29716h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f29717i;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
