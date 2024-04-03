package com.deliveryhero.contract.datastore;

import androidx.datastore.core.Serializer;
import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import com.deliveryhero.customerchat.commons.ChatCryptoException;
import com.deliveryhero.customerchat.commons.encryption.CryptoManager;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/contract/datastore/PersistableChatConfigurationSerializer;", "Landroidx/datastore/core/Serializer;", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "cryptoManager", "Lcom/deliveryhero/customerchat/commons/encryption/CryptoManager;", "defaultValue", "(Lcom/deliveryhero/customerchat/commons/encryption/CryptoManager;Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;)V", "getDefaultValue", "()Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "readFrom", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "", "t", "output", "Ljava/io/OutputStream;", "(Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PersistableChatConfigurationSerializer implements Serializer<PersistableChatConfiguration> {
    @NotNull
    private final CryptoManager cryptoManager;
    @NotNull
    private final PersistableChatConfiguration defaultValue;

    public PersistableChatConfigurationSerializer(@NotNull CryptoManager cryptoManager2, @NotNull PersistableChatConfiguration persistableChatConfiguration) {
        Intrinsics.checkNotNullParameter(cryptoManager2, "cryptoManager");
        Intrinsics.checkNotNullParameter(persistableChatConfiguration, "defaultValue");
        this.cryptoManager = cryptoManager2;
        this.defaultValue = persistableChatConfiguration;
    }

    @Nullable
    public Object readFrom(@NotNull InputStream inputStream, @NotNull Continuation<? super PersistableChatConfiguration> continuation) {
        try {
            return (PersistableChatConfiguration) Json.Default.decodeFromString(PersistableChatConfiguration.Companion.serializer(), StringsKt__StringsJVMKt.decodeToString(this.cryptoManager.decrypt(inputStream)));
        } catch (SerializationException unused) {
            return getDefaultValue();
        } catch (ChatCryptoException unused2) {
            return getDefaultValue();
        }
    }

    @NotNull
    public PersistableChatConfiguration getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    public Object writeTo(@NotNull PersistableChatConfiguration persistableChatConfiguration, @NotNull OutputStream outputStream, @NotNull Continuation<? super Unit> continuation) {
        try {
            this.cryptoManager.encrypt(StringsKt__StringsJVMKt.encodeToByteArray(Json.Default.encodeToString(PersistableChatConfiguration.Companion.serializer(), persistableChatConfiguration)), outputStream);
        } catch (ChatCryptoException unused) {
        }
        return Unit.INSTANCE;
    }
}
