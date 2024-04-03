package com.talabat;

import JsonModels.Request.McdBranchRequest;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.NoItemsBottomSheet.NoItemsBottomSheet;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.di.order.DaggerOrderListScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.OrderTrackingNavigator;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.rating.presenter.OrderRatingPresenter;
import com.talabat.rating.view.OrderRatingViewImpl;
import com.talabat.talabatcommon.helpers.OrderTrackingApplicabilityHelper;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.userandlocation.login.ui.LoginOptionsBottomSheet;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.OrderInfoPaging;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.orderlistscreen.IOrderListScreenPresenter;
import library.talabat.mvp.orderlistscreen.OrderListScreenView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.jb;
import ue.kb;

@Instrumented
public class OrderListScreen extends TalabatBase implements OrderListScreenView, CurrentLocationListener {
    private static final int INFORMAP_SELECTION = 40;
    public static final int LOGIN = 36;
    private static final int MAP_SCREEN_SELECTION_REORDER = 43;
    private static final int MCD_BLOCK_SELECTION = 41;
    private static final int MCD_LAT_LANG_SELECTION = 42;
    public static float OPACITY_FULL = 1.0f;
    public static float OPACITY_LOW = 0.26f;
    private static final String ORDER_LIST_SCREEN = "ORDER_LIST_SCREEN";
    private static final int REQUEST_AREA = 35;

    /* renamed from: z  reason: collision with root package name */
    public static String f54453z = "reorder";
    private int TbResBanchID;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<OrderInfoPaging> f54454i;

    /* renamed from: j  reason: collision with root package name */
    public ImageLoader f54455j;

    /* renamed from: k  reason: collision with root package name */
    public String f54456k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f54457l = "";
    /* access modifiers changed from: private */
    public LinearLayoutManager llm;
    /* access modifiers changed from: private */
    public boolean loading = true;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    private Button login;

    /* renamed from: m  reason: collision with root package name */
    public String f54458m = "";
    private Toolbar mToolbar;
    private String mcdResBanchID;
    /* access modifiers changed from: private */
    public boolean moreValuesPresent = true;

    /* renamed from: n  reason: collision with root package name */
    public int f54459n;
    private View noOrders;
    private View notLoggedIn;

    /* renamed from: o  reason: collision with root package name */
    public int f54460o;
    /* access modifiers changed from: private */
    public String orderEncryptedID;
    /* access modifiers changed from: private */
    public OrderRatingPresenter orderRatingPresenter;
    /* access modifiers changed from: private */
    public RecyclerView ordersListRV;

    /* renamed from: p  reason: collision with root package name */
    public int f54461p;
    /* access modifiers changed from: private */
    public IOrderListScreenPresenter presenter;
    /* access modifiers changed from: private */
    public int previousTotal = 0;
    private View progressLayout;

    /* renamed from: q  reason: collision with root package name */
    public int f54462q = 1;

    /* renamed from: r  reason: collision with root package name */
    public int f54463r;
    private boolean ratedOrder = false;
    /* access modifiers changed from: private */
    public int reorderRestaurantId = -1;
    /* access modifiers changed from: private */
    public String restaurantNameString;

    /* renamed from: s  reason: collision with root package name */
    public OrderListAdapter f54464s;
    private String selectedGlrID;
    /* access modifiers changed from: private */
    public String serverTime;
    /* access modifiers changed from: private */
    public Boolean statusBoolean;

    /* renamed from: t  reason: collision with root package name */
    public CurrentLocationFetch f54465t;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public AppVersionProvider f54466u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public ITalabatFeatureFlag f54467v;
    /* access modifiers changed from: private */
    public int visibleThreshold = 10;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public ITalabatExperiment f54468w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public CartUtility f54469x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public DeepLinkNavigator f54470y;

    public class LoadingView extends RecyclerView.ViewHolder {
        public LoadingView(View view) {
            super(view);
        }
    }

    public class OrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public OrderListAdapter() {
        }

        private int getStatus(Boolean bool) {
            return bool.booleanValue() ? R.string.successful : R.string.delivered;
        }

        /* access modifiers changed from: private */
        public boolean isOrderTrackingApplicable(OrderInfoPaging orderInfoPaging) {
            return new OrderTrackingApplicabilityHelper(orderInfoPaging.isTracking, orderInfoPaging.ordStatus, orderInfoPaging.newOrderStatus, orderInfoPaging.isPreOrder, orderInfoPaging.orderReceivedTime, orderInfoPaging.preOrderDeliveryTime, OrderListScreen.this.serverTime).isOrderTrackingApplicable();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(final OrderInfoPaging orderInfoPaging, View view) {
            OrderListScreen.this.startLodingPopup();
            if (OrderListScreen.this.presenter.isGroceryOrder(orderInfoPaging)) {
                OrderListScreen.this.presenter.fetchGroceryReorderSwimlaneInfo(orderInfoPaging.isDarkStore, orderInfoPaging.branchId, new Function2<String, String, Unit>() {
                    public Unit invoke(String str, String str2) {
                        return OrderListAdapter.this.openDarkstoreActivityWithSwimlane(str, str2, orderInfoPaging);
                    }
                });
                return;
            }
            if (Cart.getInstance().hasItems()) {
                Cart.getInstance().clearCart(OrderListScreen.this);
                Cart.getInstance().clearinfoMapAddressReorder();
            }
            OrderListScreen.this.reorderRestaurantId = orderInfoPaging.restId;
            OrderListScreen.this.presenter.reorder(orderInfoPaging.restId, orderInfoPaging.oid, orderInfoPaging.isGlrEnabled, orderInfoPaging.restName, orderInfoPaging.branchId);
        }

        /* access modifiers changed from: private */
        @NonNull
        public Unit openDarkstoreActivityWithSwimlane(String str, String str2, OrderInfoPaging orderInfoPaging) {
            OrderListScreen.this.stopLodingPopup();
            AppTracker.onReorderClicked(OrderListScreen.this.getContext(), orderInfoPaging.branchId, ScreenNames.ORDERS_LIST, ScreenNames.ORDERS_LIST);
            Intent intent = new Intent(QCommerceDeeplinkKeys.f54499a);
            intent.putExtra(QCommerceDeeplinkKeys.f54500b, orderInfoPaging.branchId);
            intent.putExtra(QCommerceDeeplinkKeys.f54501c, orderInfoPaging.isDarkStore);
            intent.putExtra(QCommerceDeeplinkKeys.f54502d, orderInfoPaging.isMigrated);
            intent.putExtra(QCommerceDeeplinkKeys.f54503e, 9);
            intent.putExtra(QCommerceDeeplinkKeys.f54504f, str);
            intent.putExtra(QCommerceDeeplinkKeys.f54505g, str2);
            intent.putExtra(QCommerceDeeplinkKeys.f54506h, OrderListScreen.f54453z);
            intent.putExtra(QCommerceDeeplinkKeys.f54507i, "order_list");
            OrderListScreen.this.startActivity(intent);
            return Unit.INSTANCE;
        }

        public void d(OrderInfoPaging orderInfoPaging) {
            OrderListScreen.this.startLodingPopup();
            OrderListScreen.this.orderEncryptedID = orderInfoPaging.oid;
            OrderListScreen.this.restaurantNameString = orderInfoPaging.restName;
            if (!TalabatUtils.isNullOrEmpty(OrderListScreen.this.orderEncryptedID)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isIndirectFlow", true);
                bundle.putString("restaurantName", orderInfoPaging.restName);
                bundle.putString("encryptedOrderId", orderInfoPaging.oid);
                OrderTrackingNavigator.navigateToOrderTracking((Context) OrderListScreen.this, bundle, false);
                OrderListScreen.this.stopLodingPopup();
            }
        }

        public int getItemCount() {
            int size = OrderListScreen.this.f54454i.size();
            OrderListScreen orderListScreen = OrderListScreen.this;
            if (size < orderListScreen.f54461p) {
                return orderListScreen.f54454i.size() + 1;
            }
            return orderListScreen.f54454i.size();
        }

        public int getItemViewType(int i11) {
            return i11 < OrderListScreen.this.f54454i.size() ? 0 : 1;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            float f11;
            if (viewHolder instanceof OrderListViewHolder) {
                OrderListViewHolder orderListViewHolder = (OrderListViewHolder) viewHolder;
                final OrderInfoPaging orderInfoPaging = OrderListScreen.this.f54454i.get(viewHolder.getAdapterPosition());
                OrderListScreen orderListScreen = OrderListScreen.this;
                orderListScreen.orderRatingPresenter = OrderRatingPresenter.create(new OrderRatingViewImpl(orderListScreen, OrderListScreen.ORDER_LIST_SCREEN, orderListScreen.getRatingEventTracker()), OrderListScreen.this.f54467v);
                if (GlobalDataModel.SelectedCountryId != Country.EGYPT.getCountryId()) {
                    orderListViewHolder.f54497q.setVisibility(0);
                } else if (orderInfoPaging.isOldOrder) {
                    orderListViewHolder.f54497q.setVisibility(8);
                } else {
                    orderListViewHolder.f54497q.setVisibility(0);
                }
                orderListViewHolder.f54489i.setText(orderInfoPaging.restName);
                orderListViewHolder.f54488h.setImageUrl(orderInfoPaging.getLogo(), OrderListScreen.this.f54455j);
                orderListViewHolder.f54491k.setText(orderInfoPaging.deliveryTime);
                if (isOrderTrackingApplicable(orderInfoPaging)) {
                    orderListViewHolder.showTrackOrderButton();
                    orderListViewHolder.hideReOrderButton();
                } else {
                    orderListViewHolder.hideTrackOrderButton();
                    orderListViewHolder.showReOrderButton();
                }
                boolean z11 = orderInfoPaging.ordStatus;
                if (z11) {
                    int i12 = orderInfoPaging.newOrderStatus;
                    if (i12 == 1) {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.ordered), Boolean.FALSE, OrderListScreen.OPACITY_LOW, OrderListScreen.this.getResources().getColor(R.color.success));
                    } else if (i12 == 2) {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.preparing), Boolean.FALSE, OrderListScreen.OPACITY_LOW, OrderListScreen.this.getResources().getColor(R.color.success));
                    } else if (i12 == 3) {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.delivering), Boolean.FALSE, OrderListScreen.OPACITY_LOW, OrderListScreen.this.getResources().getColor(R.color.success));
                    } else if (i12 == 4) {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(getStatus(Boolean.valueOf(orderInfoPaging.isPickup()))), Boolean.TRUE, OrderListScreen.OPACITY_FULL, OrderListScreen.this.getResources().getColor(R.color.success));
                    } else if (z11) {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.successful), Boolean.TRUE, OrderListScreen.OPACITY_FULL, OrderListScreen.this.getResources().getColor(R.color.success));
                    } else {
                        setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.cancelled), Boolean.FALSE, OrderListScreen.OPACITY_LOW, OrderListScreen.this.getResources().getColor(R.color.rdanger));
                        orderListViewHolder.f54493m.setEnabled(true);
                        orderListViewHolder.f54493m.setAlpha(OrderListScreen.OPACITY_FULL);
                    }
                } else {
                    setOrderStatus(orderListViewHolder, OrderListScreen.this.getString(R.string.cancelled), Boolean.FALSE, OrderListScreen.OPACITY_LOW, OrderListScreen.this.getResources().getColor(R.color.rdanger));
                    orderListViewHolder.f54493m.setEnabled(true);
                    orderListViewHolder.f54493m.setAlpha(OrderListScreen.OPACITY_FULL);
                }
                if (OrderListScreen.this.presenter.isGroceryOrder(orderInfoPaging)) {
                    boolean shouldEnableGroceryReorder = OrderListScreen.this.presenter.shouldEnableGroceryReorder();
                    orderListViewHolder.f54493m.setEnabled(shouldEnableGroceryReorder);
                    View view = orderListViewHolder.f54493m;
                    if (shouldEnableGroceryReorder) {
                        f11 = OrderListScreen.OPACITY_FULL;
                    } else {
                        f11 = OrderListScreen.OPACITY_LOW;
                    }
                    view.setAlpha(f11);
                    orderListViewHolder.f54492l.setEnabled(false);
                    orderListViewHolder.f54492l.setAlpha(OrderListScreen.OPACITY_LOW);
                } else {
                    orderListViewHolder.f54493m.setEnabled(true);
                    orderListViewHolder.f54493m.setAlpha(1.0f);
                    orderListViewHolder.f54492l.setEnabled(true);
                    orderListViewHolder.f54492l.setAlpha(OrderListScreen.OPACITY_FULL);
                }
                orderListViewHolder.f54496p.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (!orderInfoPaging.isDineOut()) {
                            OrderListScreen.this.statusBoolean = Boolean.valueOf(orderInfoPaging.ordStatus);
                            if (OrderListAdapter.this.isOrderTrackingApplicable(orderInfoPaging)) {
                                OrderListAdapter.this.d(orderInfoPaging);
                                return;
                            }
                            OrderListScreen.this.startLodingPopup();
                            OrderListScreen.this.presenter.showOrderDetails(orderInfoPaging.oid);
                        }
                    }
                });
                orderListViewHolder.f54493m.setOnClickListener(new kb(this, orderInfoPaging));
                orderListViewHolder.f54492l.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        OrderListScreen.this.orderRatingPresenter.onRateOrderButtonClicked(orderInfoPaging.oid);
                    }
                });
                orderListViewHolder.f54494n.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        OrderListAdapter.this.d(orderInfoPaging);
                    }
                });
                TextView textView = orderListViewHolder.f54495o;
                textView.setText(OrderListScreen.this.getResources().getString(R.string.order_id) + " " + orderInfoPaging.refId);
                if (orderInfoPaging.isPickup() || orderInfoPaging.isDineOut()) {
                    orderListViewHolder.hideButtonsView();
                }
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 0) {
                return new OrderListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_screen_list_item, viewGroup, false));
            }
            return new LoadingView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycularview_loading, viewGroup, false));
        }

        public void setOrderStatus(OrderListViewHolder orderListViewHolder, String str, Boolean bool, float f11, int i11) {
            orderListViewHolder.f54490j.setTextColor(i11);
            OrderListScreen.this.f54458m = str;
            orderListViewHolder.f54490j.setText(str);
            orderListViewHolder.f54492l.setEnabled(bool.booleanValue());
            orderListViewHolder.f54492l.setAlpha(f11);
        }
    }

    public class OrderListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public NetworkImageView f54488h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f54489i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f54490j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f54491k;

        /* renamed from: l  reason: collision with root package name */
        public View f54492l;

        /* renamed from: m  reason: collision with root package name */
        public View f54493m;

        /* renamed from: n  reason: collision with root package name */
        public View f54494n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f54495o;

        /* renamed from: p  reason: collision with root package name */
        public View f54496p;

        /* renamed from: q  reason: collision with root package name */
        public View f54497q;

        public OrderListViewHolder(View view) {
            super(view);
            this.f54489i = (TextView) view.findViewById(R.id.order_screen_restaurant_name);
            this.f54488h = (NetworkImageView) view.findViewById(R.id.order_screen_rest_image);
            this.f54490j = (TextView) view.findViewById(R.id.order_screen_result);
            this.f54491k = (TextView) view.findViewById(R.id.order_screen_time);
            this.f54492l = view.findViewById(R.id.order_screen_rate_view);
            this.f54493m = view.findViewById(R.id.order_screen_reorder_view);
            this.f54495o = (TextView) view.findViewById(R.id.order_id);
            this.f54496p = view.findViewById(R.id.convertView);
            this.f54494n = view.findViewById(R.id.order_screen_livetracking_view);
            this.f54497q = view.findViewById(R.id.buttons_view);
        }

        /* access modifiers changed from: private */
        public void hideButtonsView() {
            this.f54497q.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public void hideReOrderButton() {
            this.f54493m.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public void hideTrackOrderButton() {
            this.f54494n.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public void showReOrderButton() {
            this.f54493m.setVisibility(0);
        }

        /* access modifiers changed from: private */
        public void showTrackOrderButton() {
            this.f54494n.setVisibility(0);
        }
    }

    public static class QCommerceDeeplinkKeys {

        /* renamed from: a  reason: collision with root package name */
        public static String f54499a = "com.talabat.feature.darkstores.deeplink";

        /* renamed from: b  reason: collision with root package name */
        public static String f54500b = "branchId";

        /* renamed from: c  reason: collision with root package name */
        public static String f54501c = "isDarkStore";

        /* renamed from: d  reason: collision with root package name */
        public static String f54502d = "isMigrated";

        /* renamed from: e  reason: collision with root package name */
        public static String f54503e = "deeplinkType";

        /* renamed from: f  reason: collision with root package name */
        public static String f54504f = "deeplinkInfo";

        /* renamed from: g  reason: collision with root package name */
        public static String f54505g = "screenName";

        /* renamed from: h  reason: collision with root package name */
        public static String f54506h = "eventOrigin";

        /* renamed from: i  reason: collision with root package name */
        public static String f54507i = "shopClickOrigin";

        private QCommerceDeeplinkKeys() {
        }
    }

    /* access modifiers changed from: private */
    public EventTracker getRatingEventTracker() {
        return ((RatingFeatureApi) ((ApiContainer) getApplication()).getFeature(RatingFeatureApi.class)).getRatingEventTracker();
    }

    private ITalabatFeatureFlag getTalabatFeatureFlag() {
        return ((FeatureFlagCoreLibApi) ((ApiContainer) getApplication()).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }

    private boolean hasData(OrderInfoPaging[] orderInfoPagingArr) {
        return orderInfoPagingArr != null && orderInfoPagingArr.length > 0;
    }

    private void hideEmptyOrdersView() {
        this.noOrders.setVisibility(8);
    }

    private void initializeRecyclerView(OrderInfoPaging[] orderInfoPagingArr) {
        updateOrdersList(orderInfoPagingArr);
        OrderListAdapter orderListAdapter = new OrderListAdapter();
        this.f54464s = orderListAdapter;
        this.ordersListRV.setAdapter(orderListAdapter);
    }

    private void inject() {
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerOrderListScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class), (FoodCartFeatureApi) apiContainer.getFeature(FoodCartFeatureApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onReorderCartReceivedNavigateToFlutterCartScreen$0(Boolean bool) {
        if (bool.booleanValue()) {
            this.f54470y.navigateTo(this, "talabat://?s=cart&shopClickOrigin=", (Function0<Unit>) null);
        } else {
            startActivity(new Intent(this, CartScreen.class));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void navigateToLogin() {
        if (this.f54467v.getFeatureFlag(TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, false)) {
            new LoginOptionsBottomSheet(this, 36).show();
            return;
        }
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra("from", ScreenNames.ORDERS_LIST);
        startActivityForResult(intent, 36);
    }

    private void showEmptyOrdersView() {
        hideLoading();
        hideLoggedOutUserView();
        this.noOrders.setVisibility(0);
    }

    private void showOrdersView(OrderInfoPaging[] orderInfoPagingArr) {
        hideLoading();
        hideLoggedOutUserView();
        hideEmptyOrdersView();
        showRecyclerView(orderInfoPagingArr);
    }

    private void showRecyclerView(OrderInfoPaging[] orderInfoPagingArr) {
        if (this.f54464s == null) {
            initializeRecyclerView(orderInfoPagingArr);
        } else {
            updateRecyclerView(orderInfoPagingArr);
        }
        this.ordersListRV.setVisibility(0);
    }

    private void updateOrdersList(OrderInfoPaging[] orderInfoPagingArr) {
        this.f54454i.clear();
        this.f54454i.addAll(Arrays.asList(orderInfoPagingArr));
    }

    private void updateRecyclerView(OrderInfoPaging[] orderInfoPagingArr) {
        updateOrdersList(orderInfoPagingArr);
        this.f54464s.notifyDataSetChanged();
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
    }

    public void deliverToCLRecived(@NotNull LatLng latLng) {
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public void getBranchIdForReOrderCart(int i11, int i12, Address address) {
        startLodingPopup();
        this.presenter.getMcdBranchIdFromBlock(new McdBranchRequest(address, i11));
    }

    public Context getContext() {
        return this;
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.ORDERS_LIST;
    }

    public void hideLoading() {
        this.progressLayout.setVisibility(8);
    }

    public void hideLoggedOutUserView() {
        this.notLoggedIn.setVisibility(8);
    }

    public void isRefreshMap(boolean z11, @NotNull LatLng latLng) {
    }

    public void mapCurrentLocReceived(@NotNull LatLng latLng) {
    }

    public void mcdServerError() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void noOrdersFound() {
        hideLoading();
        showEmptyOrdersView();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 35) {
            if (i12 == -1) {
                startLodingPopup();
                datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
                if (selectedCountry.isCityInAddress) {
                    for (int i13 = 0; i13 < GlobalDataModel.restaurantDeliveryAreas.length; i13++) {
                        if (GlobalDataModel.SelectedAreaId == GlobalDataModel.restaurantDeliveryAreas[i13].getId()) {
                            for (City city : selectedCountry.cities) {
                                int cityId = GlobalDataModel.restaurantDeliveryAreas[i13].getCityId();
                                int i14 = city.f13843id;
                                if (cityId == i14) {
                                    GlobalDataModel.SelectedCityId = i14;
                                    GlobalDataModel.SelectedCityName = city.f13844name;
                                }
                            }
                        }
                    }
                }
                this.presenter.reorderAreaSelected(GlobalDataModel.SelectedAreaId);
            }
        } else if (i11 == 36) {
            if (i12 == -1 || i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
                this.notLoggedIn.setVisibility(8);
                hideEmptyOrdersView();
                this.progressLayout.setVisibility(0);
                this.presenter.fetchOrdersList(1);
            }
        } else if (i11 == 40) {
            if (i12 != -1) {
                stopLodingPopup();
            } else if (intent != null) {
                this.selectedGlrID = intent.getStringExtra(GlobalConstants.INFOR_MAP.INFORMAP_GLR_ID);
                this.TbResBanchID = intent.getIntExtra(GlobalConstants.INFOR_MAP.TB_BRANCH_ID_MENU, -1);
                this.mcdResBanchID = intent.getStringExtra(GlobalConstants.INFOR_MAP.MCD_BRANCH_ID_MENU);
                int i15 = this.TbResBanchID;
                if (i15 > 0) {
                    this.presenter.loadReorderCartWithGrl(GlobalDataModel.SelectedAreaId, i15);
                }
            }
        } else if (i11 == 41) {
            if (i12 != -1) {
                stopLodingPopup();
            } else if (intent != null) {
                int intExtra = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                this.TbResBanchID = intExtra;
                if (intExtra > 0) {
                    this.presenter.loadReorderCartWithGrl(GlobalDataModel.SelectedAreaId, intExtra);
                }
            }
        } else if (i11 == 42) {
            if (i12 != -1) {
                stopLodingPopup();
            } else if (intent != null) {
                int intExtra2 = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                this.TbResBanchID = intExtra2;
                if (intExtra2 > 0) {
                    this.presenter.loadReorderCartWithGrl(GlobalDataModel.SelectedAreaId, intExtra2);
                }
            }
        } else if (i11 == 43 && i12 == -1 && intent != null) {
            this.presenter.loadReOrderCartFromMap(GlobalDataModel.SelectedAreaId, intent.getStringExtra(GlobalConstants.ExtraNames.RE_ORDER_ID));
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!shouldDisableSideMenu()) {
            effectiveNavigation();
        }
    }

    public void onCreate(Bundle bundle) {
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.order_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setTitle(R.id.title, getString(R.string.title_activity_my_orders));
            GlobalConstants.isSideMenuInitialSelection = false;
            notificationFeedCount(this);
            handleToolBarButton();
            this.f54454i = new ArrayList<>();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.f54455j = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.ordersListRV = (RecyclerView) findViewById(R.id.order_list);
            this.progressLayout = findViewById(R.id.progress_layout);
            this.noOrders = findViewById(R.id.no_order_view);
            hideEmptyOrdersView();
            this.notLoggedIn = findViewById(R.id.not_logged_in_view);
            this.login = (Button) findViewById(R.id.orders_screen_login);
            this.ordersListRV.setLayoutManager(this.llm);
            this.ordersListRV.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
            this.presenter = OrderListScreenDependencyProvider.getOrderListPresenter(this.f54466u, this, this.f54467v, this.f54468w);
            this.login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OrderListScreen.this.navigateToLogin();
                }
            });
            this.orderRatingPresenter = OrderRatingPresenter.create(new OrderRatingViewImpl(this, ORDER_LIST_SCREEN, getRatingEventTracker()), getTalabatFeatureFlag());
            this.ordersListRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                    super.onScrollStateChanged(recyclerView, i11);
                }

                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    super.onScrolled(recyclerView, i11, i12);
                    if (i12 > 0) {
                        OrderListScreen orderListScreen = OrderListScreen.this;
                        orderListScreen.f54460o = orderListScreen.ordersListRV.getChildCount();
                        OrderListScreen orderListScreen2 = OrderListScreen.this;
                        orderListScreen2.f54461p = orderListScreen2.llm.getItemCount();
                        OrderListScreen orderListScreen3 = OrderListScreen.this;
                        orderListScreen3.f54459n = orderListScreen3.llm.findFirstVisibleItemPosition();
                        if (OrderListScreen.this.loading) {
                            OrderListScreen orderListScreen4 = OrderListScreen.this;
                            if (orderListScreen4.f54461p > orderListScreen4.previousTotal) {
                                OrderListScreen.this.loading = false;
                                OrderListScreen orderListScreen5 = OrderListScreen.this;
                                orderListScreen5.previousTotal = orderListScreen5.f54461p;
                                OrderListScreen.this.f54462q++;
                            }
                        }
                        if (!OrderListScreen.this.loading) {
                            OrderListScreen orderListScreen6 = OrderListScreen.this;
                            if (orderListScreen6.f54461p - orderListScreen6.f54460o <= orderListScreen6.f54459n + orderListScreen6.visibleThreshold) {
                                OrderListScreen orderListScreen7 = OrderListScreen.this;
                                if (orderListScreen7.f54462q == orderListScreen7.f54463r) {
                                    orderListScreen7.moreValuesPresent = false;
                                }
                                OrderListScreen orderListScreen8 = OrderListScreen.this;
                                if (orderListScreen8.f54462q <= orderListScreen8.f54463r) {
                                    orderListScreen8.presenter.fetchOrdersList(OrderListScreen.this.f54462q);
                                    OrderListScreen.this.loading = true;
                                }
                            }
                        }
                    }
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11) {
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11) {
    }

    public void onError() {
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
    }

    public void onOrderDetailsReceived(final OrderDetails orderDetails) {
        final String str;
        stopLodingPopup();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) orderDetails);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) orderDetails);
        }
        if (this.f54467v.getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_SHOW_NEW_FLUTTER_ORDER_DETAILS, false)) {
            datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            final String str2 = "talabat://?s=order-details&order_id=" + orderDetails.getOrderTransactionID() + "&country_iso=" + selectedCountry.code;
            this.f54470y.canHandleDeepLink(str2, new Continuation() {
                @NonNull
                public CoroutineContext getContext() {
                    return Dispatchers.getMain();
                }

                public void resumeWith(@NonNull Object obj) {
                    if (!(obj instanceof Boolean)) {
                        OrderListScreen.this.openLegacyOrderDetails(str, orderDetails);
                    } else if (((Boolean) obj).booleanValue()) {
                        OrderListScreen orderListScreen = OrderListScreen.this;
                        orderListScreen.f54470y.navigateTo(orderListScreen, str2, (Function0<Unit>) null);
                    } else {
                        OrderListScreen.this.openLegacyOrderDetails(str, orderDetails);
                    }
                }
            });
            return;
        }
        openLegacyOrderDetails(str, orderDetails);
    }

    public void onOrderListLoaded(OrderInfoPaging[] orderInfoPagingArr, int i11, int i12, String str) {
        this.serverTime = str;
        this.f54463r = i11;
        this.f54461p = i12;
        if (hasData(orderInfoPagingArr)) {
            showOrdersView(orderInfoPagingArr);
        } else {
            showEmptyOrdersView();
        }
    }

    public void onRedirectToAreaSelection(DeliveryArea[] deliveryAreaArr) {
        String str;
        stopLodingPopup();
        restaurantChanged();
        int[] iArr = new int[deliveryAreaArr.length];
        for (int i11 = 0; i11 < deliveryAreaArr.length; i11++) {
            iArr[i11] = deliveryAreaArr[i11].getId();
        }
        GlobalDataModel.restaurantDeliveryAreas = deliveryAreaArr;
        Gson gson = UniversalGson.INSTANCE.gson;
        DeliveryArea[] deliveryAreaArr2 = GlobalDataModel.restaurantDeliveryAreas;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) deliveryAreaArr2);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) deliveryAreaArr2);
        }
        Intent intent = new Intent(this, ChooseAreaScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.LOADAREAFOMHOME, false);
        intent.putExtra("deliveryAreas", true);
        intent.putExtra("areas", str);
        startActivityForResult(intent, 35);
    }

    public void onReorderCartReceived(Restaurant restaurant) {
        AppTracker.onReorderClicked(this, restaurant);
        stopLodingPopup();
        GlobalDataModel.POLYGON_TRACKING.polygonEvents = null;
        startActivity(new Intent(this, CartScreen.class));
    }

    public void onReorderCartReceivedNavigateToFlutterCartScreen(Restaurant restaurant, int i11) {
        AppTracker.onReorderClicked(this, restaurant);
        stopLodingPopup();
        GlobalDataModel.POLYGON_TRACKING.polygonEvents = null;
        this.f54469x.setCurrentCartId(i11, new jb(this));
    }

    public void onResume() {
        super.onResume();
        this.presenter.onAttach();
    }

    public void openLegacyOrderDetails(String str, OrderDetails orderDetails) {
        Intent intent = new Intent(this, OrderDetailsScreen.class);
        intent.putExtra("value", str);
        intent.putExtra("statusBoolean", orderDetails.status);
        startActivity(intent);
    }

    public void redirectToChooseSavedAddressScreenFromReorder(Address address, String str, int i11, String str2) {
        stopLodingPopup();
        Intent intent = new Intent(this, ChooseSavedAddressScreen.class);
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch(this, this);
        this.f54465t = currentLocationFetch;
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            this.f54465t.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_INIT_CL_BG());
            this.f54465t.fetchCurrentLocation();
            intent.putExtra(GlobalConstants.ExtraNames.IS_FETCHING_CL, true);
        }
        intent.putExtra(GlobalConstants.ExtraNames.IS_LOAD_DELIVERY_ADDRESS, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, str);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_ID, i11);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, str2);
        startActivityForResult(intent, 43);
        overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
    }

    public void redirectToHomeMapScreenFromReorder(boolean z11, String str, boolean z12, String str2, int i11, String str3) {
        LatLng areaCenterLatLg;
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch(this, this);
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            currentLocationFetch.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_SAVED_LOC());
            currentLocationFetch.fetchCurrentLocation();
        } else {
            GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME = null;
            GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = null;
        }
        String str4 = "";
        if (z11 && (areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(GlobalDataModel.SelectedAreaId, this.locationConfigurationRepository)) != null) {
            str4 = str4 + areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude;
        }
        Intent intent = new Intent(this, HomeScreenMap.class);
        intent.putExtra("areaLatLng", str4);
        intent.putExtra("isIgnoreCurrentLocation", z11);
        intent.putExtra("UserSelectedAddress", str);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_RE_ORDER_LIST, true);
        intent.putExtra("isIgnoreSavedLoc", z12);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_ID, str2);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_ID, i11);
        intent.putExtra(GlobalConstants.ExtraNames.RE_ORDER_RES_NAME, str3);
        startActivityForResult(intent, 43);
    }

    public void showCartClearAlert() {
        stopLodingPopup();
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.already_has_items_in_cart).replace("#", instance.getRestaurant().f13873name + " - " + instance.getCartAreaName());
        builder.setTitle((int) R.string.clear_cart_alert_title);
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                OrderListScreen.this.presenter.proceedReorderClearingCart();
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showCartLoadingError(@Nullable String str, boolean z11, @Nullable Restaurant restaurant) {
        stopLodingPopup();
        if (z11 && restaurant != null) {
            NoItemsBottomSheet.Companion.newInstance(restaurant).showDialog(getSupportFragmentManager(), "no items bottom sheet");
        } else if (!TalabatUtils.isNullOrEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) str);
            builder.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    public void showGoogleMapMcd(int i11, String str, int i12, Address address) {
        Intent intent = new Intent(this, MapsActivity.class);
        if (address != null && address.latitude > 0.0d && address.longitude > 0.0d) {
            intent.putExtra("location", "" + address.latitude + "," + address.longitude);
        }
        intent.putExtra("userSelectedAreaId", GlobalDataModel.SelectedAreaId);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_FLOW, true);
        intent.putExtra("noAreaChange", true);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_RESTAURANT_ID, i12);
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            startActivityForResult(intent, 41);
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            startActivityForResult(intent, 42);
        }
    }

    public void showLoading() {
        this.progressLayout.setVisibility(0);
    }

    public void showLoggedOutUserView() {
        hideLoading();
        hideEmptyOrdersView();
        this.notLoggedIn.setVisibility(0);
    }

    public void showMap(int i11, String str) {
        Intent intent = new Intent(this, InforMapScreen.class);
        intent.putExtra(GlobalConstants.INFOR_MAP.INFORMAP_SELECTED_AREA_ID, i11);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_ID, this.reorderRestaurantId);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_NAME, str);
        startActivityForResult(intent, 40);
    }

    public void stopLodingPopup() {
        super.stopLodingPopup();
    }
}
