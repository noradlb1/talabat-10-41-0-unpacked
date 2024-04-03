package com.deliveryhero.contract.datastore;

import android.content.Context;
import androidx.datastore.DataStoreDelegateKt;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.deliveryhero.contract.configuration.PersistableChatConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelperImpl;", "Lcom/deliveryhero/contract/datastore/ChatConfigurationDataStoreHelper;", "context", "Landroid/content/Context;", "persistableChatConfigurationSerializer", "Lcom/deliveryhero/contract/datastore/PersistableChatConfigurationSerializer;", "(Landroid/content/Context;Lcom/deliveryhero/contract/datastore/PersistableChatConfigurationSerializer;)V", "chatConfigurationDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;", "getChatConfigurationDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "chatConfigurationDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getLatestChatConfiguration", "updateChatConfigurationToDataStore", "", "persistableChatConfiguration", "(Lcom/deliveryhero/contract/configuration/PersistableChatConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatConfigurationDataStoreHelperImpl implements ChatConfigurationDataStoreHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f29713a = {Reflection.property2(new PropertyReference2Impl(ChatConfigurationDataStoreHelperImpl.class, "chatConfigurationDataStore", "getChatConfigurationDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    @NotNull
    private final ReadOnlyProperty chatConfigurationDataStore$delegate;
    @NotNull
    private final Context context;

    public ChatConfigurationDataStoreHelperImpl(@NotNull Context context2, @NotNull PersistableChatConfigurationSerializer persistableChatConfigurationSerializer) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(persistableChatConfigurationSerializer, "persistableChatConfigurationSerializer");
        this.context = context2;
        this.chatConfigurationDataStore$delegate = DataStoreDelegateKt.dataStore$default("chat_configuration.json", persistableChatConfigurationSerializer, (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 28, (Object) null);
    }

    private final DataStore<PersistableChatConfiguration> getChatConfigurationDataStore(Context context2) {
        return (DataStore) this.chatConfigurationDataStore$delegate.getValue(context2, f29713a[0]);
    }

    @Nullable
    public PersistableChatConfiguration getLatestChatConfiguration() {
        return (PersistableChatConfiguration) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1(this, (Continuation<? super ChatConfigurationDataStoreHelperImpl$getLatestChatConfiguration$1>) null), 1, (Object) null);
    }

    @Nullable
    public Object updateChatConfigurationToDataStore(@NotNull PersistableChatConfiguration persistableChatConfiguration, @NotNull Continuation<? super Unit> continuation) {
        Object updateData = getChatConfigurationDataStore().updateData(new ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2(persistableChatConfiguration, (Continuation<? super ChatConfigurationDataStoreHelperImpl$updateChatConfigurationToDataStore$2>) null), continuation);
        return updateData == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateData : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final DataStore<PersistableChatConfiguration> getChatConfigurationDataStore() {
        return getChatConfigurationDataStore(this.context);
    }
}
