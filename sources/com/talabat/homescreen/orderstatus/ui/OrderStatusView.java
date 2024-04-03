package com.talabat.homescreen.orderstatus.ui;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.annotations.SerializedName;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.itemreplacement.ItemReplacementScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.homescreen.OnFragmentInteractionListener;
import com.talabat.homescreen.R;
import com.talabat.homescreen.adapter.model.order_tracking.OrderTrackingItem;
import com.talabat.homescreen.orderstatus.presentation.displaymodel.OrderStatus;
import com.talabat.homescreen.orderstatus.presentation.observability.OrderStatusUpdateTracker;
import com.talabat.homescreen.orderstatus.presentation.viewmodel.OrderStatusViewModel;
import is.d;
import is.e;
import is.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0002<=B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001cJ\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020)H\u0007J\b\u00102\u001a\u00020)H\u0007J&\u00103\u001a\u00020)2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000205J\u000e\u00109\u001a\u00020)2\u0006\u0010:\u001a\u000205J\u0016\u0010;\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "navigateToOrderConfirmationObserver", "Landroidx/lifecycle/Observer;", "Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "onFragmentInteractionListener", "Lcom/talabat/homescreen/OnFragmentInteractionListener;", "getOnFragmentInteractionListener", "()Lcom/talabat/homescreen/OnFragmentInteractionListener;", "onFragmentInteractionListener$delegate", "Lkotlin/Lazy;", "orderStatusObserver", "", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "viewModel", "Lcom/talabat/homescreen/orderstatus/presentation/viewmodel/OrderStatusViewModel;", "getViewModel", "()Lcom/talabat/homescreen/orderstatus/presentation/viewmodel/OrderStatusViewModel;", "viewModel$delegate", "bind", "", "orderStatuses", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navigateItemReplacement", "orderId", "", "onAttach", "onDetached", "setItemPadding", "start", "", "top", "end", "bottom", "setItemSpacing", "spacing", "trackOrderStatusDisplayed", "OrderStatusData", "SpacingItemDecorator", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusView extends ConstraintLayout implements LifecycleObserver {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Observer<OrderTrackingItem> navigateToOrderConfirmationObserver;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    @NotNull
    private final Lazy onFragmentInteractionListener$delegate;
    @NotNull
    private final Observer<List<OrderStatus>> orderStatusObserver;
    @NotNull
    private final Lazy recyclerView$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0017R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00061"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "", "chainName", "", "chainId", "orderStatus", "", "orderType", "encryptedOrderId", "isTalabatGo", "", "serverTime", "preOrderDeliveryTime", "orderReceivedTime", "isPreOrder", "isOrderStatus", "isTracking", "originalOrderID", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZI)V", "getChainId", "()Ljava/lang/String;", "getChainName", "getEncryptedOrderId", "()Z", "getOrderReceivedTime", "getOrderStatus", "()I", "getOrderType", "getOriginalOrderID", "getPreOrderDeliveryTime", "getServerTime", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OrderStatusData {
        @SerializedName("chainId")
        @NotNull
        private final String chainId;
        @SerializedName("chainName")
        @NotNull
        private final String chainName;
        @SerializedName("orderId")
        @NotNull
        private final String encryptedOrderId;
        @SerializedName("isOrderStatus")
        private final boolean isOrderStatus;
        @SerializedName("isPreOrder")
        private final boolean isPreOrder;
        @SerializedName("isTalabatGo")
        private final boolean isTalabatGo;
        @SerializedName("isTracking")
        private final boolean isTracking;
        @SerializedName("orderReceivedTime")
        @NotNull
        private final String orderReceivedTime;
        @SerializedName("orderStatus")
        private final int orderStatus;
        @SerializedName("orderType")
        private final int orderType;
        @SerializedName("originalOrderID")
        private final int originalOrderID;
        @SerializedName("preOrderDeliveryTime")
        @NotNull
        private final String preOrderDeliveryTime;
        @SerializedName("serverTime")
        @NotNull
        private final String serverTime;

        public OrderStatusData(@NotNull String str, @NotNull String str2, int i11, int i12, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z12, boolean z13, boolean z14, int i13) {
            Intrinsics.checkNotNullParameter(str, "chainName");
            Intrinsics.checkNotNullParameter(str2, "chainId");
            Intrinsics.checkNotNullParameter(str3, "encryptedOrderId");
            Intrinsics.checkNotNullParameter(str4, "serverTime");
            Intrinsics.checkNotNullParameter(str5, "preOrderDeliveryTime");
            Intrinsics.checkNotNullParameter(str6, "orderReceivedTime");
            this.chainName = str;
            this.chainId = str2;
            this.orderStatus = i11;
            this.orderType = i12;
            this.encryptedOrderId = str3;
            this.isTalabatGo = z11;
            this.serverTime = str4;
            this.preOrderDeliveryTime = str5;
            this.orderReceivedTime = str6;
            this.isPreOrder = z12;
            this.isOrderStatus = z13;
            this.isTracking = z14;
            this.originalOrderID = i13;
        }

        public static /* synthetic */ OrderStatusData copy$default(OrderStatusData orderStatusData, String str, String str2, int i11, int i12, String str3, boolean z11, String str4, String str5, String str6, boolean z12, boolean z13, boolean z14, int i13, int i14, Object obj) {
            OrderStatusData orderStatusData2 = orderStatusData;
            int i15 = i14;
            return orderStatusData.copy((i15 & 1) != 0 ? orderStatusData2.chainName : str, (i15 & 2) != 0 ? orderStatusData2.chainId : str2, (i15 & 4) != 0 ? orderStatusData2.orderStatus : i11, (i15 & 8) != 0 ? orderStatusData2.orderType : i12, (i15 & 16) != 0 ? orderStatusData2.encryptedOrderId : str3, (i15 & 32) != 0 ? orderStatusData2.isTalabatGo : z11, (i15 & 64) != 0 ? orderStatusData2.serverTime : str4, (i15 & 128) != 0 ? orderStatusData2.preOrderDeliveryTime : str5, (i15 & 256) != 0 ? orderStatusData2.orderReceivedTime : str6, (i15 & 512) != 0 ? orderStatusData2.isPreOrder : z12, (i15 & 1024) != 0 ? orderStatusData2.isOrderStatus : z13, (i15 & 2048) != 0 ? orderStatusData2.isTracking : z14, (i15 & 4096) != 0 ? orderStatusData2.originalOrderID : i13);
        }

        @NotNull
        public final String component1() {
            return this.chainName;
        }

        public final boolean component10() {
            return this.isPreOrder;
        }

        public final boolean component11() {
            return this.isOrderStatus;
        }

        public final boolean component12() {
            return this.isTracking;
        }

        public final int component13() {
            return this.originalOrderID;
        }

        @NotNull
        public final String component2() {
            return this.chainId;
        }

        public final int component3() {
            return this.orderStatus;
        }

        public final int component4() {
            return this.orderType;
        }

        @NotNull
        public final String component5() {
            return this.encryptedOrderId;
        }

        public final boolean component6() {
            return this.isTalabatGo;
        }

        @NotNull
        public final String component7() {
            return this.serverTime;
        }

        @NotNull
        public final String component8() {
            return this.preOrderDeliveryTime;
        }

        @NotNull
        public final String component9() {
            return this.orderReceivedTime;
        }

        @NotNull
        public final OrderStatusData copy(@NotNull String str, @NotNull String str2, int i11, int i12, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z12, boolean z13, boolean z14, int i13) {
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "chainName");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, "chainId");
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "encryptedOrderId");
            String str10 = str4;
            Intrinsics.checkNotNullParameter(str10, "serverTime");
            String str11 = str5;
            Intrinsics.checkNotNullParameter(str11, "preOrderDeliveryTime");
            String str12 = str6;
            Intrinsics.checkNotNullParameter(str12, "orderReceivedTime");
            return new OrderStatusData(str7, str8, i11, i12, str9, z11, str10, str11, str12, z12, z13, z14, i13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderStatusData)) {
                return false;
            }
            OrderStatusData orderStatusData = (OrderStatusData) obj;
            return Intrinsics.areEqual((Object) this.chainName, (Object) orderStatusData.chainName) && Intrinsics.areEqual((Object) this.chainId, (Object) orderStatusData.chainId) && this.orderStatus == orderStatusData.orderStatus && this.orderType == orderStatusData.orderType && Intrinsics.areEqual((Object) this.encryptedOrderId, (Object) orderStatusData.encryptedOrderId) && this.isTalabatGo == orderStatusData.isTalabatGo && Intrinsics.areEqual((Object) this.serverTime, (Object) orderStatusData.serverTime) && Intrinsics.areEqual((Object) this.preOrderDeliveryTime, (Object) orderStatusData.preOrderDeliveryTime) && Intrinsics.areEqual((Object) this.orderReceivedTime, (Object) orderStatusData.orderReceivedTime) && this.isPreOrder == orderStatusData.isPreOrder && this.isOrderStatus == orderStatusData.isOrderStatus && this.isTracking == orderStatusData.isTracking && this.originalOrderID == orderStatusData.originalOrderID;
        }

        @NotNull
        public final String getChainId() {
            return this.chainId;
        }

        @NotNull
        public final String getChainName() {
            return this.chainName;
        }

        @NotNull
        public final String getEncryptedOrderId() {
            return this.encryptedOrderId;
        }

        @NotNull
        public final String getOrderReceivedTime() {
            return this.orderReceivedTime;
        }

        public final int getOrderStatus() {
            return this.orderStatus;
        }

        public final int getOrderType() {
            return this.orderType;
        }

        public final int getOriginalOrderID() {
            return this.originalOrderID;
        }

        @NotNull
        public final String getPreOrderDeliveryTime() {
            return this.preOrderDeliveryTime;
        }

        @NotNull
        public final String getServerTime() {
            return this.serverTime;
        }

        public int hashCode() {
            int hashCode = ((((((((this.chainName.hashCode() * 31) + this.chainId.hashCode()) * 31) + this.orderStatus) * 31) + this.orderType) * 31) + this.encryptedOrderId.hashCode()) * 31;
            boolean z11 = this.isTalabatGo;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int hashCode2 = (((((((hashCode + (z11 ? 1 : 0)) * 31) + this.serverTime.hashCode()) * 31) + this.preOrderDeliveryTime.hashCode()) * 31) + this.orderReceivedTime.hashCode()) * 31;
            boolean z13 = this.isPreOrder;
            if (z13) {
                z13 = true;
            }
            int i11 = (hashCode2 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.isOrderStatus;
            if (z14) {
                z14 = true;
            }
            int i12 = (i11 + (z14 ? 1 : 0)) * 31;
            boolean z15 = this.isTracking;
            if (!z15) {
                z12 = z15;
            }
            return ((i12 + (z12 ? 1 : 0)) * 31) + this.originalOrderID;
        }

        public final boolean isOrderStatus() {
            return this.isOrderStatus;
        }

        public final boolean isPreOrder() {
            return this.isPreOrder;
        }

        public final boolean isTalabatGo() {
            return this.isTalabatGo;
        }

        public final boolean isTracking() {
            return this.isTracking;
        }

        @NotNull
        public String toString() {
            String str = this.chainName;
            String str2 = this.chainId;
            int i11 = this.orderStatus;
            int i12 = this.orderType;
            String str3 = this.encryptedOrderId;
            boolean z11 = this.isTalabatGo;
            String str4 = this.serverTime;
            String str5 = this.preOrderDeliveryTime;
            String str6 = this.orderReceivedTime;
            boolean z12 = this.isPreOrder;
            boolean z13 = this.isOrderStatus;
            boolean z14 = this.isTracking;
            int i13 = this.originalOrderID;
            return "OrderStatusData(chainName=" + str + ", chainId=" + str2 + ", orderStatus=" + i11 + ", orderType=" + i12 + ", encryptedOrderId=" + str3 + ", isTalabatGo=" + z11 + ", serverTime=" + str4 + ", preOrderDeliveryTime=" + str5 + ", orderReceivedTime=" + str6 + ", isPreOrder=" + z12 + ", isOrderStatus=" + z13 + ", isTracking=" + z14 + ", originalOrderID=" + i13 + ")";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ApiContainer apiContainer = (ApiContainer) applicationContext;
            DaggerOrderStatusViewComponent.factory().create((NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).inject(this);
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
            this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new OrderStatusView$viewModel$2(context, this));
            this.onFragmentInteractionListener$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new OrderStatusView$onFragmentInteractionListener$2(context));
            this.recyclerView$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new OrderStatusView$recyclerView$2(this));
            this.orderStatusObserver = new e(this, context);
            this.navigateToOrderConfirmationObserver = new f(this);
            View.inflate(context, R.layout.layout_order_status_view, this);
            getLifecycleOwner().getLifecycle().addObserver(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    private final LifecycleOwner getLifecycleOwner() {
        LifecycleOwner lifecycleOwner;
        Context context = getContext();
        if (context instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        ClassCastException classCastException = new ClassCastException("Attached activity/fragment should be a lifecycle owner!");
        IObservabilityManager observabilityManager2 = getObservabilityManager();
        String message = classCastException.getMessage();
        if (message == null) {
            message = "";
        }
        observabilityManager2.trackUnExpectedScenario("OrderStatusViewException", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
        throw classCastException;
    }

    private final OnFragmentInteractionListener getOnFragmentInteractionListener() {
        return (OnFragmentInteractionListener) this.onFragmentInteractionListener$delegate.getValue();
    }

    private final RecyclerView getRecyclerView() {
        Object value = this.recyclerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recyclerView>(...)");
        return (RecyclerView) value;
    }

    /* access modifiers changed from: private */
    public final OrderStatusViewModel getViewModel() {
        return (OrderStatusViewModel) this.viewModel$delegate.getValue();
    }

    private final void navigateItemReplacement(String str) {
        Navigator navigator2 = getNavigator();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Navigator.DefaultImpls.navigateTo$default(navigator2, context, new ItemReplacementScreen(new ItemReplacementScreen.ItemReplacementData(str, ItemReplacementScreen.EVENT_ORIGIN_STATUS_CARD)), (Function1) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToOrderConfirmationObserver$lambda-3  reason: not valid java name */
    public static final void m10653navigateToOrderConfirmationObserver$lambda3(OrderStatusView orderStatusView, OrderTrackingItem orderTrackingItem) {
        Intrinsics.checkNotNullParameter(orderStatusView, "this$0");
        OnFragmentInteractionListener onFragmentInteractionListener = orderStatusView.getOnFragmentInteractionListener();
        Intrinsics.checkNotNullExpressionValue(orderTrackingItem, "it");
        onFragmentInteractionListener.goToOrderConfirmationScreen(orderTrackingItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttach$lambda-5  reason: not valid java name */
    public static final void m10654onAttach$lambda5(OrderStatusView orderStatusView, String str) {
        Intrinsics.checkNotNullParameter(orderStatusView, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "it");
        orderStatusView.navigateItemReplacement(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: orderStatusObserver$lambda-1  reason: not valid java name */
    public static final void m10655orderStatusObserver$lambda1(OrderStatusView orderStatusView, Context context, List list) {
        Intrinsics.checkNotNullParameter(orderStatusView, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        RecyclerView recyclerView = orderStatusView.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        recyclerView.setAdapter(new OrderStatusRecyclerViewAdaptor(list, new OrderStatusView$orderStatusObserver$1$1$1(orderStatusView)));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        orderStatusView.trackOrderStatusDisplayed(list);
    }

    private final void trackOrderStatusDisplayed(List<? extends OrderStatus> list) {
        for (OrderStatus orderStatus : list) {
            OrderStatusUpdateTracker.INSTANCE.trackStatusDisplayed(orderStatus.getStatus(), orderStatus.getOrderId(), getObservabilityManager());
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void bind(@NotNull List<OrderStatusData> list) {
        Intrinsics.checkNotNullParameter(list, "orderStatuses");
        getViewModel().onBind(list);
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onAttach() {
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        getViewModel().getOrderStatuses().observe(lifecycleOwner, this.orderStatusObserver);
        getViewModel().getGoToOrderConfirmation().observe(lifecycleOwner, this.navigateToOrderConfirmationObserver);
        getViewModel().getGoToOrderReplacement().observe(lifecycleOwner, new d(this));
        getViewModel().onViewAttached();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onDetached() {
        getViewModel().getOrderStatuses().removeObserver(this.orderStatusObserver);
        getViewModel().getGoToOrderConfirmation().removeObserver(this.navigateToOrderConfirmationObserver);
        getViewModel().onViewDetached();
    }

    public final void setItemPadding(int i11, int i12, int i13, int i14) {
        getRecyclerView().setPaddingRelative(i11, i12, i13, i14);
    }

    public final void setItemSpacing(int i11) {
        getRecyclerView().addItemDecoration(new SpacingItemDecorator(i11));
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$SpacingItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpace", "", "(Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class SpacingItemDecorator extends RecyclerView.ItemDecoration {
        private final int horizontalSpace;

        public SpacingItemDecorator(int i11) {
            this.horizontalSpace = i11;
        }

        /* JADX WARNING: type inference failed for: r2v8, types: [android.view.ViewGroup$LayoutParams] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect r2, @org.jetbrains.annotations.NotNull android.view.View r3, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r4, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r5) {
            /*
                r1 = this;
                java.lang.String r0 = "outRect"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r2 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "parent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
                java.lang.String r2 = "state"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r4.getAdapter()
                r5 = 0
                if (r2 == 0) goto L_0x0025
                int r2 = r2.getItemCount()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x0026
            L_0x0025:
                r2 = r5
            L_0x0026:
                int r2 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r2)
                int r2 = r2 + -1
                int r4 = r4.getChildAdapterPosition(r3)
                if (r4 >= r2) goto L_0x0044
                android.view.ViewGroup$LayoutParams r2 = r3.getLayoutParams()
                boolean r3 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r3 == 0) goto L_0x003d
                r5 = r2
                android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            L_0x003d:
                if (r5 == 0) goto L_0x0044
                int r2 = r1.horizontalSpace
                r5.setMarginEnd(r2)
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.orderstatus.ui.OrderStatusView.SpacingItemDecorator.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SpacingItemDecorator(OrderStatusView orderStatusView, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11);
        }
    }
}
