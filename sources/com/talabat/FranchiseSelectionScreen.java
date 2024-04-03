package com.talabat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.RestaurantFranchise.FranchisePresenter;
import library.talabat.mvp.RestaurantFranchise.FranchiseView;
import tracking.ScreenNames;

public class FranchiseSelectionScreen extends TalabatBase implements FranchiseView {

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Restaurant> f54019i;
    private boolean isFranchiseRest;
    public boolean isFromMapFirstFlow;
    private boolean isUpdateAddressSelected;
    private LinearLayoutManager llm;
    private String location;
    private Toolbar mToolbar;
    public FranchisePresenter presenter;
    private int resGrpID;
    private boolean resetPreselectedBranch;
    private RestaruantListAdapter restaruantListAdapter;
    private RecyclerView restaurantlistView;

    public class RestaruantListAdapter extends RecyclerView.Adapter<RestaurantListViewHolder> {
        private RestaruantListAdapter() {
        }

        public int getItemCount() {
            return FranchiseSelectionScreen.this.f54019i.size();
        }

        public void onBindViewHolder(final RestaurantListViewHolder restaurantListViewHolder, int i11) {
            final Restaurant restaurant = FranchiseSelectionScreen.this.f54019i.get(i11);
            restaurantListViewHolder.f54027i.setText(restaurant.f13873name);
            restaurantListViewHolder.f54028j.setText(restaurant.getDisplayMinimumAmount());
            restaurantListViewHolder.f54029k.setText(restaurant.getDeliveryTime());
            FranchiseSelectionScreen franchiseSelectionScreen = FranchiseSelectionScreen.this;
            if (franchiseSelectionScreen.isValidContextForGlide(franchiseSelectionScreen)) {
                GlideApp.with((FragmentActivity) FranchiseSelectionScreen.this).clear((View) restaurantListViewHolder.f54026h);
                GlideApp.with((FragmentActivity) FranchiseSelectionScreen.this).load(restaurant.getLogo()).centerInside().into(restaurantListViewHolder.f54026h);
            }
            restaurantListViewHolder.f54026h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FranchiseSelectionScreen.this.setSelectedRestaurantFranchise(restaurant);
                }
            });
            int i12 = restaurant.statusType;
            if (i12 == 0) {
                restaurantListViewHolder.f54032n.setText(FranchiseSelectionScreen.this.getText(R.string.open));
                restaurantListViewHolder.f54032n.setTextColor(FranchiseSelectionScreen.this.getResources().getColor(R.color.status_open));
            } else if (i12 == 5) {
                restaurantListViewHolder.f54032n.setText(FranchiseSelectionScreen.this.getText(R.string.open_for_preorder));
                restaurantListViewHolder.f54032n.setTextColor(FranchiseSelectionScreen.this.getResources().getColor(R.color.status_open));
            } else if (i12 == 1) {
                restaurantListViewHolder.f54032n.setText(FranchiseSelectionScreen.this.getText(R.string.closed));
                restaurantListViewHolder.f54032n.setTextColor(FranchiseSelectionScreen.this.getResources().getColor(R.color.status_close));
            } else {
                restaurantListViewHolder.f54032n.setText(FranchiseSelectionScreen.this.getText(R.string.busy));
                restaurantListViewHolder.f54032n.setTextColor(FranchiseSelectionScreen.this.getResources().getColor(R.color.status_busy));
            }
            restaurantListViewHolder.f54032n.setVisibility(8);
            if (restaurant.isMealDealAvailable() || restaurant.isCouponAvailable()) {
                restaurantListViewHolder.f54036r.setVisibility(0);
            } else {
                restaurantListViewHolder.f54036r.setVisibility(4);
            }
            if (restaurant.getDeliveryCharges() == 0.0f) {
                restaurantListViewHolder.f54035q.setText(R.string.delivery);
                restaurantListViewHolder.f54034p.setText(R.string.free);
            } else {
                restaurantListViewHolder.f54035q.setText(R.string.deliveryfee);
                restaurantListViewHolder.f54034p.setText(restaurant.getDisplayDeliveryCharges());
            }
            TextView textView = restaurantListViewHolder.f54031m;
            textView.setText("(" + restaurant.getTotalRating() + ")");
            restaurantListViewHolder.f54030l.setRating(restaurant.getRating());
            restaurantListViewHolder.f54033o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FranchiseSelectionScreen.this.setSelectedRestaurantFranchise(restaurant);
                    TextView textView = restaurantListViewHolder.f54027i;
                    Pair.create(textView, textView.getTransitionName());
                    TextView textView2 = restaurantListViewHolder.f54032n;
                    Pair.create(textView2, textView2.getTransitionName());
                }
            });
            if (restaurant.isSponsered) {
                restaurantListViewHolder.f54038t.setVisibility(0);
            } else {
                restaurantListViewHolder.f54038t.setVisibility(4);
            }
        }

        public RestaurantListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new RestaurantListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurantlist_item, viewGroup, false));
        }
    }

    public class RestaurantListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public ImageView f54026h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f54027i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f54028j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f54029k;

        /* renamed from: l  reason: collision with root package name */
        public RatingBar f54030l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f54031m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f54032n;

        /* renamed from: o  reason: collision with root package name */
        public View f54033o;

        /* renamed from: p  reason: collision with root package name */
        public TextView f54034p;

        /* renamed from: q  reason: collision with root package name */
        public TextView f54035q;

        /* renamed from: r  reason: collision with root package name */
        public View f54036r;

        /* renamed from: s  reason: collision with root package name */
        public View f54037s;

        /* renamed from: t  reason: collision with root package name */
        public TextView f54038t;

        public RestaurantListViewHolder(View view) {
            super(view);
            this.f54027i = (TextView) view.findViewById(R.id.rest_name);
            this.f54026h = (ImageView) view.findViewById(R.id.rest_logo);
            this.f54030l = (RatingBar) view.findViewById(R.id.ratingbar);
            this.f54032n = (TextView) view.findViewById(R.id.status_text);
            this.f54028j = (TextView) view.findViewById(R.id.min_orderamt);
            this.f54029k = (TextView) view.findViewById(R.id.del_time);
            this.f54034p = (TextView) view.findViewById(R.id.del_fees);
            this.f54035q = (TextView) view.findViewById(R.id.del_fees_property);
            this.f54031m = (TextView) view.findViewById(R.id.rating_count);
            this.f54033o = view.findViewById(R.id.convertView);
            this.f54036r = view.findViewById(R.id.offers);
            this.f54027i.setTransitionName("title");
            this.f54032n.setTransitionName("status_text");
            this.f54037s = view.findViewById(R.id.rest_list_bg_layout);
            this.f54038t = (TextView) view.findViewById(R.id.restaurant_sponsered);
        }
    }

    /* access modifiers changed from: private */
    public void setSelectedRestaurantFranchise(Restaurant restaurant) {
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        Intent intent = new Intent();
        if (this.isFromMapFirstFlow) {
            intent.putExtra("DeliveryAreaBranchId", restaurant.branchId);
            intent.putExtra(GlobalConstants.ExtraNames.FRANCHISE_GRP_ID, restaurant.groupId);
            intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFranchiseRest);
            intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_SELECTED, true);
            intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, this.isUpdateAddressSelected);
        }
        setResult(-1, intent);
        finish();
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.TALABATWEBVIEW;
    }

    public void loadFranchiseList() {
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        this.f54019i = arrayList;
        arrayList.addAll(Arrays.asList(GlobalDataModel.JSON.franchiseRestaurants));
        this.restaurantlistView = (RecyclerView) findViewById(R.id.restaurantlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.llm = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.restaurantlistView.setLayoutManager(this.llm);
        this.restaurantlistView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
        RestaruantListAdapter restaruantListAdapter2 = new RestaruantListAdapter();
        this.restaruantListAdapter = restaruantListAdapter2;
        this.restaurantlistView.setAdapter(restaruantListAdapter2);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, this.resetPreselectedBranch);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_SELECTED, false);
        setResult(0, intent);
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.franchiselist_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.isFromMapFirstFlow = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, false);
        this.location = getIntent().getStringExtra("location");
        this.resGrpID = getIntent().getIntExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_RES_GRP_ID, -1);
        this.isUpdateAddressSelected = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, false);
        this.isFranchiseRest = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, false);
        this.resetPreselectedBranch = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, false);
        setToolbarPadding(this.mToolbar);
        this.presenter = new FranchisePresenter(this);
        if (this.isFromMapFirstFlow) {
            startLodingPopup();
            this.presenter.loadFranchiseRestaurants(this.resGrpID, this.location);
            return;
        }
        loadFranchiseList();
    }

    public void onError() {
    }
}
