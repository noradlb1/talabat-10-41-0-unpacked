package library.talabat.mvp.orderlistscreen;

import JsonModels.Request.McdBranchRequest;
import datamodels.OrderInfoPaging;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J4\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0007H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0005H&J\u0012\u0010\"\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\nH&¨\u0006#"}, d2 = {"Llibrary/talabat/mvp/orderlistscreen/IOrderListScreenPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "fetchGroceryReorderSwimlaneInfo", "", "isDarkstore", "", "branchId", "", "onInfoReceived", "Lkotlin/Function2;", "", "fetchOrdersList", "pageNumber", "getMcdBranchIdFromBlock", "mcdBlockMapRequest", "LJsonModels/Request/McdBranchRequest;", "isGroceryOrder", "orderInfo", "Ldatamodels/OrderInfoPaging;", "loadReOrderCartFromMap", "selectedAreaId", "orderId", "loadReorderCartWithGrl", "selectedBranchID", "onAttach", "proceedReorderClearingCart", "reorder", "restaurantId", "isGrlRestaurant", "restName", "reorderAreaSelected", "areaId", "reorderGrocery", "shouldEnableGroceryReorder", "showOrderDetails", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOrderListScreenPresenter extends IGlobalPresenter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void fetchOrdersList$default(IOrderListScreenPresenter iOrderListScreenPresenter, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                iOrderListScreenPresenter.fetchOrdersList(i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchOrdersList");
        }
    }

    void fetchGroceryReorderSwimlaneInfo(boolean z11, int i11, @NotNull Function2<? super String, ? super String, Unit> function2);

    void fetchOrdersList(int i11);

    void getMcdBranchIdFromBlock(@Nullable McdBranchRequest mcdBranchRequest);

    boolean isGroceryOrder(@NotNull OrderInfoPaging orderInfoPaging);

    void loadReOrderCartFromMap(int i11, @Nullable String str);

    void loadReorderCartWithGrl(int i11, int i12);

    void onAttach();

    void proceedReorderClearingCart();

    void reorder(int i11, @Nullable String str, boolean z11, @Nullable String str2, int i12);

    void reorderAreaSelected(int i11);

    void reorderGrocery(@NotNull String str, boolean z11);

    boolean shouldEnableGroceryReorder();

    void showOrderDetails(@Nullable String str);
}
