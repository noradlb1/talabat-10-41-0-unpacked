package com.talabat.darkstores.data.vendors.remote;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/data/vendors/remote/VendorsApi;", "", "getInfo", "LJsonModels/Response/Darkstores/DarkStoresEntryPointResponse;", "areaId", "", "latitude", "", "longitude", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsApi {
    @Nullable
    @GET("/api/v1/darkstore/{areaId}/{latitude}/{longitude}")
    Object getInfo(@Path("areaId") int i11, @NotNull @Path("latitude") String str, @NotNull @Path("longitude") String str2, @NotNull Continuation<? super DarkStoresEntryPointResponse> continuation);
}
