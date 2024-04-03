package com.talabat.wallet.bnplmanager.data.remote.api;

import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlansRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/api/BNPLEligibilityApi;", "", "getBNPLEligibilityStatus", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRemoteDto;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBNPLPlans", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlansRemoteDto;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLEligibilityApi {
    @POST("/api/v1/customers/check-eligibility")
    @Nullable
    Object getBNPLEligibilityStatus(@NotNull @Body BNPLEligibilityRequestDto bNPLEligibilityRequestDto, @NotNull Continuation<? super BNPLEligibilityRemoteDto> continuation);

    @Nullable
    @GET("/api/v1/plans/countries/{country}")
    Object getBNPLPlans(@Path("country") int i11, @NotNull Continuation<? super BNPLPlansRemoteDto> continuation);
}
