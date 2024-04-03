package com.deliveryhero.customerchat.datastore;

import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.datastore.UserPropertiesSerializer$writeTo$2", f = "UserPropertiesSerializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserPropertiesSerializer$writeTo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29823h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OutputStream f29824i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserProperties f29825j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserPropertiesSerializer$writeTo$2(OutputStream outputStream, UserProperties userProperties, Continuation<? super UserPropertiesSerializer$writeTo$2> continuation) {
        super(2, continuation);
        this.f29824i = outputStream;
        this.f29825j = userProperties;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserPropertiesSerializer$writeTo$2(this.f29824i, this.f29825j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserPropertiesSerializer$writeTo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f29823h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f29824i.write(StringsKt__StringsJVMKt.encodeToByteArray(Json.Default.encodeToString(UserProperties.Companion.serializer(), this.f29825j)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
