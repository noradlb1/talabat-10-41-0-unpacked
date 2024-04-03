package com.deliveryhero.customerchat.datastore;

import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.datastore.UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2", f = "UserPropertiesDataStoreHelperImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2 extends SuspendLambda implements Function2<UserProperties, Continuation<? super UserProperties>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29821h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserProperties f29822i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2(UserProperties userProperties, Continuation<? super UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2> continuation) {
        super(2, continuation);
        this.f29822i = userProperties;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2(this.f29822i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull UserProperties userProperties, @Nullable Continuation<? super UserProperties> continuation) {
        return ((UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2) create(userProperties, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29821h == 0) {
            ResultKt.throwOnFailure(obj);
            return this.f29822i;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
