package com.deliveryhero.customerchat.datastore;

import com.deliveryhero.contract.model.UserType;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.datastore.UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1", f = "UserPropertiesDataStoreHelperImpl.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UserProperties>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29819h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserPropertiesDataStoreHelperImpl f29820i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1(UserPropertiesDataStoreHelperImpl userPropertiesDataStoreHelperImpl, Continuation<? super UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1> continuation) {
        super(2, continuation);
        this.f29820i = userPropertiesDataStoreHelperImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1(this.f29820i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super UserProperties> continuation) {
        return ((UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29819h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow data = this.f29820i.getUserPropertiesDataStore().getData();
            this.f29819h = 1;
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
        UserProperties userProperties = (UserProperties) obj2;
        if (!Intrinsics.areEqual((Object) userProperties, (Object) new UserProperties((UserType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null))) {
            return userProperties;
        }
        return null;
    }
}
