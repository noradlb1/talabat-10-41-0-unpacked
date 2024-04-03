package com.opsquad.ui.orderDetail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.opsquad.R;
import com.opsquad.ui.orderDetail.model.OrderDetailDisplayModel;
import com.opsquad.ui.orderDetail.viewmodel.OrderDetailsViewModel;
import com.opsquad.ui.orderDetail.viewmodel.OrderDetailsViewModelBuilder;
import com.opsquad.ui.orderDetail.viewmodel.OrderDetailsViewModelImpl;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oe.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/opsquad/ui/orderDetail/OrderDetailFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/opsquad/ui/orderDetail/viewmodel/OrderDetailsViewModel;", "()V", "vendorInfoAdapter", "Lcom/opsquad/ui/orderDetail/OrderDetailsAdapter;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "handleSuccess", "displayModel", "Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "initiateViews", "layoutId", "", "observatory", "onBackPressed", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateView", "orderDetailView", "viewModelBuilder", "Lcom/opsquad/ui/orderDetail/viewmodel/OrderDetailsViewModelImpl;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final OrderDetailsAdapter vendorInfoAdapter = new OrderDetailsAdapter();

    /* access modifiers changed from: private */
    public final void handleSuccess(OrderDetailDisplayModel orderDetailDisplayModel) {
        if (orderDetailDisplayModel != null) {
            updateView(orderDetailDisplayModel);
        }
    }

    private final void initiateViews() {
        int i11 = R.id.order_detail_recycler_view;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(this.vendorInfoAdapter);
        ((ImageButton) _$_findCachedViewById(R.id.order_detail_back)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initiateViews$lambda-1  reason: not valid java name */
    public static final void m9390initiateViews$lambda1(OrderDetailFragment orderDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(orderDetailFragment, "this$0");
        orderDetailFragment.onBackPressed();
    }

    private final void updateView(OrderDetailDisplayModel orderDetailDisplayModel) {
        if (orderDetailDisplayModel != null) {
            this.vendorInfoAdapter.updateOrderDetailsScreen(orderDetailDisplayModel.getRows());
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
        if (failure instanceof Failure.NetworkConnection) {
            Status.Companion companion = Status.Companion;
            FragmentActivity activity = getActivity();
            String string = getString(com.talabat.localization.R.string.failure_network_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ilure_network_connection)");
            Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        } else if (failure instanceof ServerError) {
            Status.Companion companion2 = Status.Companion;
            FragmentActivity activity2 = getActivity();
            String string2 = getString(com.talabat.localization.R.string.failure_server_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…ing.failure_server_error)");
            Status.Companion.notify$default(companion2, activity2, (ViewGroup) null, string2, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
    }

    @NotNull
    public Class<OrderDetailsViewModel> getViewModelClass() {
        return OrderDetailsViewModel.class;
    }

    public int layoutId() {
        return R.layout.order_detail_screen;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((OrderDetailsViewModel) getViewModel()).getSuccessData(), new OrderDetailFragment$observatory$1(this));
    }

    public void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initiateViews();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("orderID");
        } else {
            str = null;
        }
        ((OrderDetailsViewModel) getViewModel()).getOrderDetails(String.valueOf(str));
    }

    @NotNull
    public OrderDetailsViewModelImpl viewModelBuilder() {
        OrderDetailsViewModelBuilder.Companion companion = OrderDetailsViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        return companion.getOrderDetailsViewModel(requireContext, getCoroutineScope());
    }
}
