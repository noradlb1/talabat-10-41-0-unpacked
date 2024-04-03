package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"LJsonModels/Response/OrderRatingDetailsResponse;", "", "result", "LJsonModels/Response/OrderRatingDetailsResponseResult;", "hasError", "", "error", "LJsonModels/Response/OrderRatingDetailsError;", "(LJsonModels/Response/OrderRatingDetailsResponseResult;Ljava/lang/Boolean;LJsonModels/Response/OrderRatingDetailsError;)V", "getError", "()LJsonModels/Response/OrderRatingDetailsError;", "getHasError", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResult", "()LJsonModels/Response/OrderRatingDetailsResponseResult;", "component1", "component2", "component3", "copy", "(LJsonModels/Response/OrderRatingDetailsResponseResult;Ljava/lang/Boolean;LJsonModels/Response/OrderRatingDetailsError;)LJsonModels/Response/OrderRatingDetailsResponse;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingDetailsResponse {
    @SerializedName("error")
    @Nullable
    private final OrderRatingDetailsError error;
    @SerializedName("hasError")
    @Nullable
    private final Boolean hasError;
    @SerializedName("result")
    @NotNull
    private final OrderRatingDetailsResponseResult result;

    public OrderRatingDetailsResponse(@NotNull OrderRatingDetailsResponseResult orderRatingDetailsResponseResult, @Nullable Boolean bool, @Nullable OrderRatingDetailsError orderRatingDetailsError) {
        Intrinsics.checkNotNullParameter(orderRatingDetailsResponseResult, "result");
        this.result = orderRatingDetailsResponseResult;
        this.hasError = bool;
        this.error = orderRatingDetailsError;
    }

    public static /* synthetic */ OrderRatingDetailsResponse copy$default(OrderRatingDetailsResponse orderRatingDetailsResponse, OrderRatingDetailsResponseResult orderRatingDetailsResponseResult, Boolean bool, OrderRatingDetailsError orderRatingDetailsError, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            orderRatingDetailsResponseResult = orderRatingDetailsResponse.result;
        }
        if ((i11 & 2) != 0) {
            bool = orderRatingDetailsResponse.hasError;
        }
        if ((i11 & 4) != 0) {
            orderRatingDetailsError = orderRatingDetailsResponse.error;
        }
        return orderRatingDetailsResponse.copy(orderRatingDetailsResponseResult, bool, orderRatingDetailsError);
    }

    @NotNull
    public final OrderRatingDetailsResponseResult component1() {
        return this.result;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasError;
    }

    @Nullable
    public final OrderRatingDetailsError component3() {
        return this.error;
    }

    @NotNull
    public final OrderRatingDetailsResponse copy(@NotNull OrderRatingDetailsResponseResult orderRatingDetailsResponseResult, @Nullable Boolean bool, @Nullable OrderRatingDetailsError orderRatingDetailsError) {
        Intrinsics.checkNotNullParameter(orderRatingDetailsResponseResult, "result");
        return new OrderRatingDetailsResponse(orderRatingDetailsResponseResult, bool, orderRatingDetailsError);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRatingDetailsResponse)) {
            return false;
        }
        OrderRatingDetailsResponse orderRatingDetailsResponse = (OrderRatingDetailsResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) orderRatingDetailsResponse.result) && Intrinsics.areEqual((Object) this.hasError, (Object) orderRatingDetailsResponse.hasError) && Intrinsics.areEqual((Object) this.error, (Object) orderRatingDetailsResponse.error);
    }

    @Nullable
    public final OrderRatingDetailsError getError() {
        return this.error;
    }

    @Nullable
    public final Boolean getHasError() {
        return this.hasError;
    }

    @NotNull
    public final OrderRatingDetailsResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        int hashCode = this.result.hashCode() * 31;
        Boolean bool = this.hasError;
        int i11 = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        OrderRatingDetailsError orderRatingDetailsError = this.error;
        if (orderRatingDetailsError != null) {
            i11 = orderRatingDetailsError.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        OrderRatingDetailsResponseResult orderRatingDetailsResponseResult = this.result;
        Boolean bool = this.hasError;
        OrderRatingDetailsError orderRatingDetailsError = this.error;
        return "OrderRatingDetailsResponse(result=" + orderRatingDetailsResponseResult + ", hasError=" + bool + ", error=" + orderRatingDetailsError + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderRatingDetailsResponse(OrderRatingDetailsResponseResult orderRatingDetailsResponseResult, Boolean bool, OrderRatingDetailsError orderRatingDetailsError, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderRatingDetailsResponseResult, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : orderRatingDetailsError);
    }
}
