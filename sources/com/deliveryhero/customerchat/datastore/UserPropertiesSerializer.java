package com.deliveryhero.customerchat.datastore;

import androidx.datastore.core.Serializer;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/customerchat/datastore/UserPropertiesSerializer;", "Landroidx/datastore/core/Serializer;", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "defaultValue", "(Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;)V", "getDefaultValue", "()Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "readFrom", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "", "t", "output", "Ljava/io/OutputStream;", "(Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserPropertiesSerializer implements Serializer<UserProperties> {
    @NotNull
    private final UserProperties defaultValue;

    public UserPropertiesSerializer(@NotNull UserProperties userProperties) {
        Intrinsics.checkNotNullParameter(userProperties, "defaultValue");
        this.defaultValue = userProperties;
    }

    @Nullable
    public Object readFrom(@NotNull InputStream inputStream, @NotNull Continuation<? super UserProperties> continuation) {
        try {
            return Json.Default.decodeFromString(UserProperties.Companion.serializer(), StringsKt__StringsJVMKt.decodeToString(ByteStreamsKt.readBytes(inputStream)));
        } catch (SerializationException unused) {
            return getDefaultValue();
        }
    }

    @NotNull
    public UserProperties getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    public Object writeTo(@NotNull UserProperties userProperties, @NotNull OutputStream outputStream, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new UserPropertiesSerializer$writeTo$2(outputStream, userProperties, (Continuation<? super UserPropertiesSerializer$writeTo$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
