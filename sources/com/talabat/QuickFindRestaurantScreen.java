package com.talabat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.restaurant.DaggerQuickFindRestaurantScreenComponent;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GlobalSlideAnimatorAdapter;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.QuickRestaurant;
import datamodels.Restaurant;
import java.util.ArrayList;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.quickfindrestaurants.IQuickFindRestaurantsPresenter;
import library.talabat.mvp.quickfindrestaurants.QuickFindRestaurantsPresenter;
import library.talabat.mvp.quickfindrestaurants.QuickFindRestaurantsView;
import tracking.AppTracker;
import tracking.ScreenNames;

public class QuickFindRestaurantScreen extends TalabatBase implements QuickFindRestaurantsView {
    private Button cancel;
    private ImageButton clearSearch;
    /* access modifiers changed from: private */
    public ArrayList<QuickRestaurant> displayRestaurants;

    /* renamed from: i  reason: collision with root package name */
    public GlobalSlideAnimatorAdapter f54559i;
    /* access modifiers changed from: private */
    public ImageLoader imageLoader;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f54560j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public AppVersionProvider f54561k;
    private LinearLayoutManager llm;
    private Toolbar mToolbar;
    /* access modifiers changed from: private */
    public View noRestaurants;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public QuickFindRestaurantsAdapter quickFindRestaurantsAdapter;
    private ListView quickFindRestaurantsList;
    /* access modifiers changed from: private */
    public IQuickFindRestaurantsPresenter quickFindRestaurantsPresenter;
    /* access modifiers changed from: private */
    public RecyclerView quickFindRestaurantsRecyclerView;
    /* access modifiers changed from: private */
    public EditText search;
    /* access modifiers changed from: private */
    public ArrayList<QuickRestaurant> tempAllRestaurants;

    public class QuickFindRestaurantsAdapter extends RecyclerView.Adapter<QuickRestaurantListViewHolder> implements Filterable {
        private QuickFindRestaurantsAdapter() {
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    ArrayList arrayList = new ArrayList();
                    if (QuickFindRestaurantScreen.this.tempAllRestaurants != null) {
                        int size = QuickFindRestaurantScreen.this.tempAllRestaurants.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            QuickRestaurant quickRestaurant = (QuickRestaurant) QuickFindRestaurantScreen.this.tempAllRestaurants.get(i11);
                            if (quickRestaurant.getName().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(quickRestaurant);
                            } else if (QuickFindRestaurantScreen.this.getRestaurantShortName(quickRestaurant.getName()).toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(quickRestaurant);
                            }
                        }
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    QuickFindRestaurantScreen.this.displayRestaurants = (ArrayList) filterResults.values;
                    if (filterResults.count > 0) {
                        QuickFindRestaurantScreen.this.quickFindRestaurantsRecyclerView.setVisibility(0);
                        QuickFindRestaurantScreen.this.noRestaurants.setVisibility(8);
                        QuickFindRestaurantScreen.this.progressBar.setVisibility(8);
                        QuickFindRestaurantScreen.this.f54559i = new GlobalSlideAnimatorAdapter(QuickFindRestaurantScreen.this.quickFindRestaurantsAdapter, QuickFindRestaurantScreen.this.quickFindRestaurantsRecyclerView);
                        QuickFindRestaurantScreen.this.f54559i.setAnimationDirection(2);
                        QuickFindRestaurantScreen.this.quickFindRestaurantsRecyclerView.setAdapter(QuickFindRestaurantScreen.this.f54559i);
                        return;
                    }
                    QuickFindRestaurantScreen.this.quickFindRestaurantsRecyclerView.setVisibility(8);
                    QuickFindRestaurantScreen.this.setNoRestaurantsView();
                    QuickFindRestaurantsAdapter.this.notifyDataSetChanged();
                }
            };
        }

        public int getItemCount() {
            return QuickFindRestaurantScreen.this.displayRestaurants.size();
        }

        public void onBindViewHolder(QuickRestaurantListViewHolder quickRestaurantListViewHolder, final int i11) {
            final QuickRestaurant quickRestaurant = (QuickRestaurant) QuickFindRestaurantScreen.this.displayRestaurants.get(i11);
            quickRestaurantListViewHolder.networkImageView.setImageUrl(quickRestaurant.getLogo(), QuickFindRestaurantScreen.this.imageLoader);
            quickRestaurantListViewHolder.restaurantName.setText(quickRestaurant.f13870name);
            quickRestaurantListViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    QuickFindRestaurantScreen.this.quickFindRestaurantsPresenter.setRestaurantSelected(quickRestaurant);
                    QuickFindRestaurantScreen quickFindRestaurantScreen = QuickFindRestaurantScreen.this;
                    AppTracker.onSearchRestaurantClicked(quickFindRestaurantScreen, quickFindRestaurantScreen.getScreenName(), QuickFindRestaurantScreen.this.search.getText().toString(), quickRestaurant, i11);
                    QuickFindRestaurantScreen.this.startLodingPopup();
                }
            });
        }

        public QuickRestaurantListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new QuickRestaurantListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quickfindrestaurants_item, viewGroup, false));
        }
    }

    public class QuickFindViewHolder {
        public NetworkImageView networkImageView;
        public TextView restaurantName;

        private QuickFindViewHolder() {
        }
    }

    public class QuickRestaurantListViewHolder extends RecyclerView.ViewHolder {
        public View convertView;
        public NetworkImageView networkImageView;
        public TextView restaurantName;

        public QuickRestaurantListViewHolder(View view) {
            super(view);
            this.restaurantName = (TextView) view.findViewById(R.id.restaurant_name);
            this.networkImageView = (NetworkImageView) view.findViewById(R.id.restaurant_logo);
            this.convertView = view.findViewById(R.id.convertView);
        }
    }

    private void searchBarSlideLeftAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        loadAnimation.setDuration(400);
        loadAnimation.setFillAfter(true);
        ((RelativeLayout) findViewById(R.id.search_container)).startAnimation(loadAnimation);
    }

    public void destroyPresenter() {
        this.quickFindRestaurantsPresenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.quickFindRestaurantsPresenter;
    }

    public String getRestaurantShortName(String str) {
        Object obj;
        String[] split = str.split(" ");
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < split.length; i11++) {
            if (split[i11].length() > 0) {
                obj = Character.valueOf(split[i11].charAt(0));
            } else {
                obj = "";
            }
            sb2.append(obj);
        }
        return sb2.toString();
    }

    public String getScreenName() {
        return ScreenNames.QUICKFINDRESTAURANTS;
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        effectiveNavigation();
    }

    public void onCreate(Bundle bundle) {
        String str;
        DaggerQuickFindRestaurantScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.quickfindrestaurants);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            searchBarSlideLeftAnimation();
            this.noRestaurants = findViewById(R.id.no_restaurants_view);
            this.progressBar = (ProgressBar) findViewById(R.id.quickfindrestaurantprogress);
            this.quickFindRestaurantsRecyclerView = (RecyclerView) findViewById(R.id.quickfindrestaurantView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.quickFindRestaurantsRecyclerView.setLayoutManager(this.llm);
            this.noRestaurants.setVisibility(0);
            this.progressBar.setVisibility(8);
            this.quickFindRestaurantsRecyclerView.setVisibility(8);
            this.imageLoader = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.quickFindRestaurantsPresenter = new QuickFindRestaurantsPresenter(this.f54561k, this);
            this.clearSearch = (ImageButton) findViewById(R.id.clear_search);
            this.quickFindRestaurantsPresenter.loadAllRestaurants();
            this.noRestaurants.setVisibility(8);
            this.progressBar.setVisibility(0);
            this.quickFindRestaurantsRecyclerView.setVisibility(8);
            this.search = (EditText) findViewById(R.id.search_edittext);
            this.cancel = (Button) findViewById(R.id.cancel);
            this.f54560j = (ImageView) findViewById(R.id.search_clear);
            if (getIntent().hasExtra("value")) {
                str = getIntent().getStringExtra("value");
            } else {
                str = "";
            }
            if (!TalabatUtils.isNullOrEmpty(str)) {
                this.search.setText(str);
            }
            this.cancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    QuickFindRestaurantScreen.this.search.setText("");
                    QuickFindRestaurantScreen.this.quickFindRestaurantsPresenter.typingCancelled();
                    QuickFindRestaurantScreen.this.finish();
                }
            });
            this.quickFindRestaurantsPresenter.typingStarted();
            this.quickFindRestaurantsRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                    GlobalSlideAnimatorAdapter globalSlideAnimatorAdapter;
                    super.onScrollStateChanged(recyclerView, i11);
                    if (i11 == 1 && (globalSlideAnimatorAdapter = QuickFindRestaurantScreen.this.f54559i) != null) {
                        globalSlideAnimatorAdapter.getViewAnimator().disableAnimations();
                    }
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr) {
        stopLodingPopup();
        restaurantChanged();
        Intent intent = new Intent(this, BrandingScreen.class);
        if (restaurant != null) {
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

    public void onTypingStarted() {
        this.progressBar.setVisibility(8);
        this.noRestaurants.setVisibility(8);
        this.quickFindRestaurantsRecyclerView.setVisibility(0);
    }

    public void setLoadingView() {
        this.progressBar.setVisibility(0);
    }

    public void setNoRestaurantsView() {
        this.noRestaurants.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.quickFindRestaurantsRecyclerView.setVisibility(8);
        onShakeImage(R.id.no_rest_found);
    }

    public void setQuickFindView(ArrayList<QuickRestaurant> arrayList) {
        this.progressBar.setVisibility(8);
        final String string = getResources().getString(R.string.search_restaurants_count);
        this.displayRestaurants = arrayList;
        this.quickFindRestaurantsAdapter = new QuickFindRestaurantsAdapter();
        GlobalSlideAnimatorAdapter globalSlideAnimatorAdapter = new GlobalSlideAnimatorAdapter(this.quickFindRestaurantsAdapter, this.quickFindRestaurantsRecyclerView);
        this.f54559i = globalSlideAnimatorAdapter;
        globalSlideAnimatorAdapter.setAnimationDirection(2);
        this.quickFindRestaurantsRecyclerView.setAdapter(this.f54559i);
        this.tempAllRestaurants = this.displayRestaurants;
        this.search.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                QuickFindRestaurantScreen quickFindRestaurantScreen = QuickFindRestaurantScreen.this;
                AppTracker.onRestaurantSearched(quickFindRestaurantScreen, quickFindRestaurantScreen.getScreenName(), editable.toString(), QuickFindRestaurantScreen.this.tempAllRestaurants);
                if (editable.length() > 0) {
                    QuickFindRestaurantScreen.this.f54560j.setVisibility(0);
                } else {
                    QuickFindRestaurantScreen.this.f54560j.setVisibility(8);
                }
                QuickFindRestaurantScreen.this.quickFindRestaurantsPresenter.typingStarted();
                if (QuickFindRestaurantScreen.this.tempAllRestaurants == null) {
                    QuickFindRestaurantScreen.this.tempAllRestaurants = new ArrayList();
                    QuickFindRestaurantScreen.this.tempAllRestaurants.addAll(QuickFindRestaurantScreen.this.displayRestaurants);
                }
                QuickFindRestaurantScreen.this.quickFindRestaurantsAdapter.getFilter().filter(editable);
                if (TalabatUtils.isNullOrEmpty(editable.toString())) {
                    EditText z11 = QuickFindRestaurantScreen.this.search;
                    String str = string;
                    z11.setHint(str.replace("#", "" + QuickFindRestaurantScreen.this.tempAllRestaurants.size()));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.quickFindRestaurantsRecyclerView.setVisibility(0);
        this.f54560j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickFindRestaurantScreen.this.search.setText("");
            }
        });
    }
}
