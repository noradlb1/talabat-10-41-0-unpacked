package com.talabat.feature.tokenization.data.datasource;

import com.talabat.feature.tokenization.data.datasource.response.RemoteTokenizationPublicKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tokenization/data/datasource/RemoteTokenizationDataSource;", "", "getPublicKey", "Lcom/talabat/feature/tokenization/data/datasource/response/RemoteTokenizationPublicKey;", "countryId", "", "binNumber", "", "verticalId", "(ILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RemoteTokenizationDataSource {
    @Nullable
    @GET("checkoutapi/v1/keys/{countryId}")
    Object getPublicKey(@Path("countryId") int i11, @Nullable @Query("binNumber") String str, @Nullable @Query("verticalId") Integer num, @NotNull Continuation<? super RemoteTokenizationPublicKey> continuation);
}
