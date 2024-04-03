package com.talabat.collectiondetails.data;

import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.NetworkBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/collectiondetails/data/CollectionsApiFactory;", "", "()V", "collectionsApi", "Lcom/talabat/collectiondetails/data/CollectionsApi;", "getCollectionsApi", "()Lcom/talabat/collectiondetails/data/CollectionsApi;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsApiFactory {
    @NotNull
    public static final CollectionsApiFactory INSTANCE = new CollectionsApiFactory();

    private CollectionsApiFactory() {
    }

    @NotNull
    public final CollectionsApi getCollectionsApi() {
        return (CollectionsApi) NetworkBuilder.Companion.getService(VendorEndPointProvider.INSTANCE.getBaseUrl(), CollectionsApi.class);
    }
}
