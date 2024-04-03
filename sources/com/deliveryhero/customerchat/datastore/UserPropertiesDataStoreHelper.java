package com.deliveryhero.customerchat.datastore;

import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/datastore/UserPropertiesDataStoreHelper;", "", "getLatestUserProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "updateUserPropertiesToDataStore", "", "userProperties", "(Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserPropertiesDataStoreHelper {
    @Nullable
    UserProperties getLatestUserProperties();

    @Nullable
    Object updateUserPropertiesToDataStore(@NotNull UserProperties userProperties, @NotNull Continuation<? super Unit> continuation);
}
