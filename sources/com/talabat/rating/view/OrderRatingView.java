package com.talabat.rating.view;

import JsonModels.Response.rateOrders.RateReasonResponse;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.rating.domain.model.OrderRatingDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/rating/view/OrderRatingView;", "", "hideLoading", "", "rateOrderClicked", "rateOrderEventModel", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "showGenericError", "showLoading", "showOrderCannotBeRated", "message", "", "showRatingView", "encryptedOrderId", "orderRatingDetails", "Lcom/talabat/rating/domain/model/OrderRatingDetails;", "rateReasonResponse", "LJsonModels/Response/rateOrders/RateReasonResponse;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderRatingView {
    void hideLoading();

    void rateOrderClicked(@NotNull RateOrderEventModel rateOrderEventModel);

    void showGenericError();

    void showLoading();

    void showOrderCannotBeRated(@Nullable String str);

    void showRatingView(@NotNull String str, @NotNull OrderRatingDetails orderRatingDetails, @NotNull RateReasonResponse rateReasonResponse);
}
