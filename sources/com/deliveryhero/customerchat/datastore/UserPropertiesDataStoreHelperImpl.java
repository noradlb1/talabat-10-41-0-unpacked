package com.deliveryhero.customerchat.datastore;

import android.content.Context;
import androidx.datastore.DataStoreDelegateKt;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelperImpl;", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "context", "Landroid/content/Context;", "userPropertiesSerializer", "Lcom/deliveryhero/customerchat/datastore/UserPropertiesSerializer;", "(Landroid/content/Context;Lcom/deliveryhero/customerchat/datastore/UserPropertiesSerializer;)V", "userPropertiesDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "getUserPropertiesDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "userPropertiesDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getLatestUserProperties", "updateUserPropertiesToDataStore", "", "userProperties", "(Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserPropertiesDataStoreHelperImpl implements UserPropertiesDataStoreHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f29818a = {Reflection.property2(new PropertyReference2Impl(UserPropertiesDataStoreHelperImpl.class, "userPropertiesDataStore", "getUserPropertiesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    @NotNull
    private final Context context;
    @NotNull
    private final ReadOnlyProperty userPropertiesDataStore$delegate;

    public UserPropertiesDataStoreHelperImpl(@NotNull Context context2, @NotNull UserPropertiesSerializer userPropertiesSerializer) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(userPropertiesSerializer, "userPropertiesSerializer");
        this.context = context2;
        this.userPropertiesDataStore$delegate = DataStoreDelegateKt.dataStore$default("user_properties.json", userPropertiesSerializer, (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 28, (Object) null);
    }

    private final DataStore<UserProperties> getUserPropertiesDataStore(Context context2) {
        return (DataStore) this.userPropertiesDataStore$delegate.getValue(context2, f29818a[0]);
    }

    @Nullable
    public UserProperties getLatestUserProperties() {
        return (UserProperties) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1(this, (Continuation<? super UserPropertiesDataStoreHelperImpl$getLatestUserProperties$1>) null), 1, (Object) null);
    }

    @Nullable
    public Object updateUserPropertiesToDataStore(@NotNull UserProperties userProperties, @NotNull Continuation<? super Unit> continuation) {
        Object updateData = getUserPropertiesDataStore().updateData(new UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2(userProperties, (Continuation<? super UserPropertiesDataStoreHelperImpl$updateUserPropertiesToDataStore$2>) null), continuation);
        return updateData == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateData : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final DataStore<UserProperties> getUserPropertiesDataStore() {
        return getUserPropertiesDataStore(this.context);
    }
}
