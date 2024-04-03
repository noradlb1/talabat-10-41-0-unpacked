package com.talabat.collectiondetails.ui.quickfilter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import com.designsystem.marshmallow.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.cuisines.navigation.CollectionsCuisineView;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import datamodels.QuickFilter;
import io.supercharge.shimmerlayout.ShimmerLayout;
import wf.f0;

public class UnsubscribeCollectionActivity extends QuickFilterRestaurantsActivity {
    public CollapsingToolbarLayout F;
    public AppBarLayout G;
    public FrameLayout H;
    public Toolbar I;
    public FrameLayout J;
    public TextView K;
    public LinearLayout L;
    public FrameLayout M;
    public NestedScrollView N;
    public Button O;
    public LinearLayout P;
    public LookingGlassView Q;
    public CollectionsCuisineView mLinearLayoutCuisines;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initHeader$0(View view) {
        onBackPressed();
    }

    public void buildHeader(QuickFilter quickFilter) {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.ds_secondary_10));
        this.G.setVisibility(0);
        if (quickFilter.getHasTermsNCodn().booleanValue()) {
            this.O.setVisibility(0);
        } else {
            this.O.setVisibility(8);
        }
        this.K.setText(quickFilter.getDescription());
        this.F.setTitle(quickFilter.getPageName());
        if (quickFilter.getDeepLink().matches("grocery")) {
            this.f55654p.getDarkStoresInfo();
        }
        this.f55656r = (ShimmerLayout) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_shimmer);
        this.f55657s = (CardView) findViewById(com.talabat.talabatcommon.R.id.daily_shimmer_container);
        this.f55658t = (CardView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_container);
        this.f55659u = (ImageView) findViewById(com.talabat.talabatcommon.R.id.daily_header_image);
        this.f55660v = (ImageView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_logo);
        this.f55661w = (TextView) findViewById(com.talabat.talabatcommon.R.id.daily_average_duration);
        this.f55662x = (TextView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily);
        this.f55663y = (RelativeLayout) findViewById(com.talabat.talabatcommon.R.id.status_view);
        this.A = (TextView) findViewById(com.talabat.talabatcommon.R.id.new_status_text);
        this.f55656r.startShimmerAnimation();
    }

    public int getLayout() {
        return com.talabat.collectiondetails.R.layout.collections_activity_quick_filter_restaurants;
    }

    public void initHeader() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(com.talabat.collectiondetails.R.id.collapsingToolbar);
        this.F = collapsingToolbarLayout;
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.ds_secondary_10));
        this.G = (AppBarLayout) findViewById(com.talabat.collectiondetails.R.id.appbarLayout);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.talabat.collectiondetails.R.id.toolbar);
        this.H = frameLayout;
        frameLayout.setElevation((float) getResources().getDimensionPixelOffset(com.talabat.talabatcommon.R.dimen.filter_collections_shadow));
        Toolbar toolbar = (Toolbar) findViewById(com.talabat.collectiondetails.R.id.mainToolbar);
        this.I = toolbar;
        toolbar.setNavigationOnClickListener(new f0(this));
        Button button = (Button) findViewById(com.talabat.collectiondetails.R.id.button_termsAndCondition);
        this.O = button;
        button.setOnClickListener(this);
        this.I.setNavigationIcon(R.drawable.ds_arrow_back);
        this.N = (NestedScrollView) findViewById(com.talabat.collectiondetails.R.id.scrollView_noRestaurant);
        this.J = (FrameLayout) findViewById(com.talabat.collectiondetails.R.id.frameLayout_headerContainer);
        this.K = (TextView) findViewById(com.talabat.collectiondetails.R.id.headerSecondaryText);
        this.M = (FrameLayout) findViewById(com.talabat.collectiondetails.R.id.frameLayout_divider);
        this.mLinearLayoutCuisines = (CollectionsCuisineView) findViewById(com.talabat.collectiondetails.R.id.collectionsCuisineViewLayout);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.talabat.collectiondetails.R.id.linearLayout_search);
        this.L = linearLayout;
        linearLayout.setOnClickListener(this);
        this.P = (LinearLayout) findViewById(com.talabat.collectiondetails.R.id.linearLayout_filterCuisineContainer);
        this.f55656r = (ShimmerLayout) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_shimmer);
        this.f55657s = (CardView) findViewById(com.talabat.talabatcommon.R.id.daily_shimmer_container);
        this.f55658t = (CardView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_container);
        this.f55659u = (ImageView) findViewById(com.talabat.talabatcommon.R.id.daily_header_image);
        this.f55660v = (ImageView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily_logo);
        this.f55661w = (TextView) findViewById(com.talabat.talabatcommon.R.id.daily_average_duration);
        this.f55662x = (TextView) findViewById(com.talabat.talabatcommon.R.id.talabat_daily);
        this.f55663y = (RelativeLayout) findViewById(com.talabat.talabatcommon.R.id.status_view);
        this.A = (TextView) findViewById(com.talabat.talabatcommon.R.id.new_status_text);
        int i11 = com.talabat.collectiondetails.R.id.looking_glass;
        this.Q = (LookingGlassView) findViewById(i11);
        this.f55656r.startShimmerAnimation();
        this.G.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f55674a = false;

            /* renamed from: b  reason: collision with root package name */
            public int f55675b = -1;

            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onOffsetChanged$0(AppBarLayout appBarLayout, int i11) {
                if (this.f55675b == -1) {
                    this.f55675b = appBarLayout.getTotalScrollRange();
                }
                UnsubscribeCollectionActivity.this.H.setTranslationY((((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange())) * ((float) ((int) (UnsubscribeCollectionActivity.this.getResources().getDisplayMetrics().density * 22.0f))));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(-1);
                UnsubscribeCollectionActivity.this.H.setBackground(gradientDrawable);
                if (this.f55675b + i11 == 0) {
                    UnsubscribeCollectionActivity unsubscribeCollectionActivity = UnsubscribeCollectionActivity.this;
                    unsubscribeCollectionActivity.G.setBackgroundColor(unsubscribeCollectionActivity.getResources().getColor(R.color.ds_secondary_10));
                    this.f55674a = true;
                } else if (this.f55674a) {
                    UnsubscribeCollectionActivity unsubscribeCollectionActivity2 = UnsubscribeCollectionActivity.this;
                    unsubscribeCollectionActivity2.G.setBackgroundColor(unsubscribeCollectionActivity2.getResources().getColor(com.talabat.talabatcommon.R.color.app_background));
                    this.f55674a = false;
                }
            }

            public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
                UnsubscribeCollectionActivity.this.G.post(new a(this, appBarLayout, i11));
            }
        });
        this.Q = (LookingGlassView) findViewById(i11);
    }
}
