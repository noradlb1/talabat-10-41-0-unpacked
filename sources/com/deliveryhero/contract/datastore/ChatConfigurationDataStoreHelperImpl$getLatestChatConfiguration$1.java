package com.deliveryhero.contract.datastore;

import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.contract.datastore.ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1", f = "ChatConfigurationDataStoreHelperImpl.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PersistableChatConfiguration>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29714h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatConfigurationDataStoreHelperImpl f29715i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1(ChatConfigurationDataStoreHelperImpl chatConfigurationDataStoreHelperImpl, Continuation<? super ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1> continuation) {
        super(2, continuation);
        this.f29715i = chatConfigurationDataStoreHelperImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1(this.f29715i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super PersistableChatConfiguration> continuation) {
        return ((ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29714h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow data = this.f29715i.getChatConfigurationDataStore().getData();
            this.f29714h = 1;
            obj2 = FlowKt.firstOrNull(data, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PersistableChatConfiguration persistableChatConfiguration = (PersistableChatConfiguration) obj2;
        if (persistableChatConfiguration == null || !(!Intrinsics.areEqual((Object) persistableChatConfiguration, (Object) new PersistableChatConfiguration((UserInfo) null, (DeliveryInfo) null, (String) null, (ClientConfig) null, false, false, false, (List) null, false, false, false, false, (PhoneCallType) null, (Translations) null, false, false, 0, 131071, (DefaultConstructorMarker) null)))) {
            return null;
        }
        return persistableChatConfiguration;
    }
}
