package com.talabat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.FilterEngine;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.offer.DaggerOffersListScreenComponent;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.performance.PerformanceTracker;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.OffersDisplayModel;
import datamodels.Restaurant;
import java.util.ArrayList;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.offerslist.IOffersPresenter;
import library.talabat.mvp.offerslist.OffersPresenter;
import library.talabat.mvp.offerslist.OffersView;
import tracking.AppTracker;
import tracking.ScreenNames;

public class OffersListScreen extends TalabatBase implements OffersView {

    /* renamed from: i  reason: collision with root package name */
    public ImageLoader f54439i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f54440j;
    private LinearLayoutManager llm;
    private View loadingLayout;
    private Toolbar mToolbar;
    private View noOffersView;
    private RecyclerView offerList;
    private OfferListAdapter offerListAdapter;
    /* access modifiers changed from: private */
    public OffersDisplayModel[] offersDisplayModels;
    /* access modifiers changed from: private */
    public IOffersPresenter presenter;

    public class OfferListAdapter extends RecyclerView.Adapter<OfferListViewHolder> {
        private OfferListAdapter() {
        }

        public int getItemCount() {
            return OffersListScreen.this.offersDisplayModels.length;
        }

        public void onBindViewHolder(OfferListViewHolder offerListViewHolder, final int i11) {
            offerListViewHolder.f54444h.setImageUrl(OffersListScreen.this.offersDisplayModels[i11].getThumbnail(), OffersListScreen.this.f54439i);
            if (TalabatUtils.isArabic()) {
                offerListViewHolder.f54445i.setTextDirection(4);
                offerListViewHolder.f54446j.setTextDirection(4);
                offerListViewHolder.f54447k.setTextDirection(4);
                offerListViewHolder.f54448l.setTextDirection(4);
            }
            offerListViewHolder.f54445i.setText(OffersListScreen.this.offersDisplayModels[i11].offerTitle);
            offerListViewHolder.f54446j.setText(OffersListScreen.this.offersDisplayModels[i11].restaurantName);
            if (!TalabatUtils.isNullOrEmpty(OffersListScreen.this.offersDisplayModels[i11].description)) {
                offerListViewHolder.f54447k.setVisibility(0);
                offerListViewHolder.f54447k.setText(OffersListScreen.this.offersDisplayModels[i11].description.trim());
            } else {
                offerListViewHolder.f54447k.setVisibility(8);
            }
            if (OffersListScreen.this.offersDisplayModels[i11].isPriceOnSelection()) {
                offerListViewHolder.f54448l.setText(OffersListScreen.this.offersDisplayModels[i11].getPrice());
            } else {
                offerListViewHolder.f54448l.setText(OffersListScreen.this.getString(R.string.price_based_on_selection));
            }
            if (OffersListScreen.this.offersDisplayModels[i11].promotionType == 2) {
                offerListViewHolder.f54448l.setVisibility(8);
            } else {
                offerListViewHolder.f54448l.setVisibility(0);
            }
            offerListViewHolder.f54449m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OffersListScreen.this.startLodingPopup();
                    GlobalDataModel.ShopClickOrigin = FilterEngine.DEEPLINKFILER.OFFERS;
                    OffersListScreen.this.presenter.setOffersSelected(OffersListScreen.this.offersDisplayModels[i11].restaurantId);
                }
            });
        }

        public OfferListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new OfferListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offers_list_screen_item, viewGroup, false));
        }
    }

    public class OfferListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public NetworkImageView f54444h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f54445i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f54446j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f54447k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f54448l;

        /* renamed from: m  reason: collision with root package name */
        public View f54449m;

        public OfferListViewHolder(View view) {
            super(view);
            this.f54449m = view.findViewById(R.id.convertView);
            this.f54444h = (NetworkImageView) view.findViewById(R.id.offer_screen_rest_image);
            this.f54446j = (TextView) view.findViewById(R.id.offer_screen_restaurant_name);
            this.f54445i = (TextView) view.findViewById(R.id.offer_screen_offer_name);
            this.f54447k = (TextView) view.findViewById(R.id.offers_screen_description);
            this.f54448l = (TextView) view.findViewById(R.id.offers_screen_price);
        }
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.PROMOTIONS;
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
        DaggerOffersListScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.offers_list_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setTitle(R.id.title, getString(R.string.title_activity_offers));
            notificationFeedCount(this);
            handleToolBarButton();
            this.noOffersView = findViewById(R.id.no_offers_view);
            this.loadingLayout = findViewById(R.id.offers_loading_layout);
            this.noOffersView.setVisibility(8);
            this.loadingLayout.setVisibility(8);
            this.offerList = (RecyclerView) findViewById(R.id.offer_list);
            this.f54439i = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.offerList.setLayoutManager(this.llm);
            this.offerList.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
            OffersPresenter offersPresenter = new OffersPresenter(this.f54440j, this);
            this.presenter = offersPresenter;
            offersPresenter.loadOffersList();
            this.loadingLayout.setVisibility(0);
            GlobalConstants.isSideMenuInitialSelection = false;
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void onOffersLoaded(ArrayList<OffersDisplayModel> arrayList) {
        OffersDisplayModel[] offersDisplayModelArr = new OffersDisplayModel[arrayList.size()];
        this.offersDisplayModels = offersDisplayModelArr;
        arrayList.toArray(offersDisplayModelArr);
        if (this.offersDisplayModels.length > 0) {
            this.loadingLayout.setVisibility(8);
            this.noOffersView.setVisibility(8);
        } else {
            this.loadingLayout.setVisibility(8);
            this.noOffersView.setVisibility(0);
        }
        AppTracker.onOfferlistListLoaded(this, arrayList);
        OfferListAdapter offerListAdapter2 = new OfferListAdapter();
        this.offerListAdapter = offerListAdapter2;
        this.offerList.setAdapter(offerListAdapter2);
        PerformanceTracker performanceTracker = PerformanceTracker.INSTANCE;
        performanceTracker.addAppFlowTraceAttribute("appStartToInteractive", "OfferScreen");
        performanceTracker.stopTrace("appStartToInteractive");
    }

    public void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr) {
        stopLodingPopup();
        restaurantChanged();
        if (restaurant != null) {
            Intent intent = new Intent(this, BrandingScreen.class);
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            int[] iArr = new int[deliveryAreaArr.length];
            for (int i11 = 0; i11 < deliveryAreaArr.length; i11++) {
                iArr[i11] = deliveryAreaArr[i11].getId();
            }
            GlobalDataModel.SELECTED.restaurant.delAreas = iArr;
            GlobalDataModel.restaurantDeliveryAreas = deliveryAreaArr;
            intent.putExtra(GlobalConstants.ExtraNames.AREA_CHOOSED, false);
            intent.putExtra(GlobalConstants.BRAND_DEEP_LINK_NAVIGATION.DISABLE_SIDEMENU, true);
            startActivity(intent);
        }
    }
}
