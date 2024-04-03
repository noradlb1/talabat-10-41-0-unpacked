package com.talabat.helpcenter.data.datasources.remote.impl;

import com.talabat.helpcenter.data.datasources.remote.dto.GlobalHelpCenterConfigResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JQ\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/helpcenter/data/datasources/remote/impl/PoeRetrofitService;", "", "getGlobalHelpCenterConfig", "Lcom/talabat/helpcenter/data/datasources/remote/dto/GlobalHelpCenterConfigResponse;", "orderId", "", "caseId", "language", "countryId", "", "appVersion", "appPlatform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PoeRetrofitService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getGlobalHelpCenterConfig$default(PoeRetrofitService poeRetrofitService, String str, String str2, String str3, int i11, String str4, String str5, Continuation continuation, int i12, Object obj) {
            String str6;
            String str7;
            String str8;
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str6 = "";
                } else {
                    str6 = str;
                }
                if ((i12 & 2) != 0) {
                    str7 = "";
                } else {
                    str7 = str2;
                }
                if ((i12 & 4) != 0) {
                    str8 = "en-US";
                } else {
                    str8 = str3;
                }
                return poeRetrofitService.getGlobalHelpCenterConfig(str6, str7, str8, i11, str4, str5, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGlobalHelpCenterConfig");
        }
    }

    @Nullable
    @GET("/api/v1/GHC")
    Object getGlobalHelpCenterConfig(@Nullable @Query("orderId") String str, @Nullable @Query("caseId") String str2, @NotNull @Query("language") String str3, @Query("country") int i11, @NotNull @Query("appVersion") String str4, @NotNull @Query("appPlatform") String str5, @NotNull Continuation<? super GlobalHelpCenterConfigResponse> continuation);
}
