package com.talabat.adapters.restaurantslist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import bf.c;
import bf.d;
import bf.e;
import bf.f;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.adapters.restaurantslist.viewholders.CollectionsViewHolder;
import com.talabat.adapters.restaurantslist.viewholders.ToggleHeaderViewHolder;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionViewHolder;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCaseKt;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductItemViewHolder;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductListViewHolder;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.views.grocery.GroceryVendorViewHolder;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import datamodels.Swimlane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import library.talabat.SharedPreferencesManager;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

public class RestaurantsListAdapterRefactor extends PagingDataAdapter<RestaurantListItemModel, RecyclerView.ViewHolder> {
    private FeatureProductItemViewHolder.OnFeatureProductClick featureProductClickListener;
    private FeatureProductListViewHolder.OnFeatureProductShown featureProductShownListener;
    private ToggleHeaderViewHolder.OnHeaderToggleClickListener headerToggleClickListener;

    /* renamed from: i  reason: collision with root package name */
    public List<RestaurantListItemModel> f55308i;
    private HashSet<Integer> impressionTracker = new HashSet<>();
    private boolean isPaginatedAdapter;

    /* renamed from: j  reason: collision with root package name */
    public List<RestaurantListItemModel> f55309j;

    /* renamed from: k  reason: collision with root package name */
    public Context f55310k;

    /* renamed from: l  reason: collision with root package name */
    public OnRestaurantClick f55311l;

    /* renamed from: m  reason: collision with root package name */
    public String f55312m = "";

    /* renamed from: n  reason: collision with root package name */
    public boolean f55313n = false;

    /* renamed from: o  reason: collision with root package name */
    public int f55314o;
    private OnFeatureProductAppeared onFeatureProductAppeared;
    private OnFeatureProductTrackingEnabled onFeatureProductTrackingEnabled;
    private RewardsMissionViewHolder.OnMissionUpdated onMissionUpdated;

    /* renamed from: p  reason: collision with root package name */
    public int f55315p;
    private final ITalabatFeatureFlag talabatFeatureFlag;
    private int verticalId;

    public interface OnFeatureProductAppeared {
        void featureProductAppeared(FeatureProductListDisplayModel featureProductListDisplayModel);
    }

    public interface OnFeatureProductTrackingEnabled {
        void featureProductTrackingEnabled(boolean z11);
    }

    public RestaurantsListAdapterRefactor(Context context, int i11, boolean z11, ITalabatFeatureFlag iTalabatFeatureFlag) {
        super(RestaurantListItemDiffCallback.INSTANCE);
        this.f55310k = context;
        this.f55308i = new ArrayList();
        this.f55309j = new ArrayList();
        Resources resources = this.f55310k.getResources();
        this.f55314o = (int) TypedValue.applyDimension(1, 18.0f, resources.getDisplayMetrics());
        this.f55315p = (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics());
        this.verticalId = i11;
        SharedPreferencesManager.getInstance().saveFavVerical(GlobalConstants.VerticalTypes.VERTICAL, i11);
        this.isPaginatedAdapter = isPaginatedAdapter(i11, 0, z11);
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(Restaurant restaurant, Integer num) {
        this.f55311l.onRestaurantClick(restaurant, num.intValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2(AdsWrapper adsWrapper, View view) {
        GlobalDataModel.ShopClickOrigin = GetInlineAdsUseCaseKt.HEADER_DEVICE_CTA_VALUE;
        if (this.isPaginatedAdapter) {
            this.f55311l.onInlineAdsClick(adsWrapper);
        } else {
            this.f55311l.onInlineAdsClick(adsWrapper.getAdsLink(), adsWrapper.getAdsPosition());
        }
        adsWrapper.getNativeCustomTemplateAd().performClick("ss");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$onBindViewHolder$3(AdsWrapper adsWrapper) {
        return Boolean.valueOf(adsWrapper.getRestaurant().statusType == 5);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreateViewHolder$0(Restaurant restaurant, Integer num) {
        this.f55311l.onRestaurantClick(restaurant, num.intValue());
        return Unit.INSTANCE;
    }

    public void enableFeatureProductTracking() {
        OnFeatureProductTrackingEnabled onFeatureProductTrackingEnabled2 = this.onFeatureProductTrackingEnabled;
        if (onFeatureProductTrackingEnabled2 != null) {
            onFeatureProductTrackingEnabled2.featureProductTrackingEnabled(true);
        }
    }

    public int getItemCount() {
        if (this.isPaginatedAdapter) {
            return super.getItemCount();
        }
        return this.f55308i.size();
    }

    public int getItemViewType(int i11) {
        RestaurantListItemModel model = getModel(i11);
        if (model == null) {
            return 13;
        }
        int i12 = model.type;
        if (i12 != 2 || !this.f55313n) {
            return i12;
        }
        return 13;
    }

    @VisibleForTesting
    @Nullable
    public RestaurantListItemModel getModel(int i11) {
        if (this.isPaginatedAdapter) {
            return (RestaurantListItemModel) getItem(i11);
        }
        return this.f55308i.get(i11);
    }

    public void insertItem(@NotNull RestaurantListItemModel restaurantListItemModel, int i11) {
        if (this.f55308i.size() > i11) {
            this.f55308i.add(i11, restaurantListItemModel);
            notifyItemInserted(i11);
        }
    }

    @VisibleForTesting
    public boolean isPaginatedAdapter(int i11, int i12, boolean z11) {
        return i11 == i12 && !z11;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        RestaurantListItemModel model = getModel(i11);
        if (model != null) {
            if (viewHolder instanceof FreshRestaurantUiViewHolderExperiment) {
                ((FreshRestaurantUiViewHolderExperiment) viewHolder).bind(model.restaurant, i11, new c(this), this.f55312m);
            } else if (viewHolder instanceof FeatureProductListViewHolder) {
                FeatureProductListViewHolder featureProductListViewHolder = (FeatureProductListViewHolder) viewHolder;
                this.onFeatureProductTrackingEnabled = featureProductListViewHolder.getTrackingEnabledCallback();
                featureProductListViewHolder.bind((FeatureProductListDisplayModel) model.data);
            } else if (viewHolder instanceof RestaurantNewInlineAdsViewHolder) {
                final RestaurantNewInlineAdsViewHolder restaurantNewInlineAdsViewHolder = (RestaurantNewInlineAdsViewHolder) viewHolder;
                final AdsWrapper adsWrapper = model.adsWrapper;
                adsWrapper.getNativeCustomTemplateAd().recordImpression();
                GlideActivityExceptionHandler glideActivityExceptionHandler = GlideActivityExceptionHandler.INSTANCE;
                if (glideActivityExceptionHandler.isValidContextForGlide(this.f55310k)) {
                    GlideApp.with(this.f55310k).clear((View) restaurantNewInlineAdsViewHolder.f55306l);
                    GlideApp.with(this.f55310k).load(adsWrapper.getAdsImage()).fitCenter().transform((Transformation) new RoundedCorners(this.f55310k.getResources().getDimensionPixelSize(R.dimen.margin_8dp))).into(restaurantNewInlineAdsViewHolder.f55306l);
                }
                this.f55311l.onInlineAdsAppeared(adsWrapper.getAdsLink(), adsWrapper.getAdsPosition());
                restaurantNewInlineAdsViewHolder.itemView.setOnClickListener(new d(this, adsWrapper));
                ViewExtentionsKt.showIf(restaurantNewInlineAdsViewHolder.f55307m, new e(adsWrapper));
                if (adsWrapper.getRestaurantCuisine() != null) {
                    restaurantNewInlineAdsViewHolder.f55305k.setText(adsWrapper.getRestaurantCuisine());
                } else {
                    restaurantNewInlineAdsViewHolder.f55305k.setText("");
                }
                if (adsWrapper.getRestaurantName() != null) {
                    restaurantNewInlineAdsViewHolder.f55304j.setText(adsWrapper.getRestaurantName());
                } else {
                    restaurantNewInlineAdsViewHolder.f55304j.setText("");
                }
                if (adsWrapper.getRestaurantLogo() == null) {
                    restaurantNewInlineAdsViewHolder.f55302h.setVisibility(8);
                    restaurantNewInlineAdsViewHolder.f55303i.setImageResource(0);
                    restaurantNewInlineAdsViewHolder.f55303i.setVisibility(0);
                } else if (glideActivityExceptionHandler.isValidContextForGlide(this.f55310k)) {
                    GlideApp.with(this.f55310k).clear((View) restaurantNewInlineAdsViewHolder.f55303i);
                    GlideApp.with(this.f55310k).load(adsWrapper.getRestaurantLogo()).listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            String trim = adsWrapper.getRestaurantLogo().toString().trim();
                            if (!TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1, trim.length()))) {
                                restaurantNewInlineAdsViewHolder.f55302h.setVisibility(0);
                            } else {
                                restaurantNewInlineAdsViewHolder.f55302h.setVisibility(8);
                                restaurantNewInlineAdsViewHolder.f55303i.setImageResource(0);
                                restaurantNewInlineAdsViewHolder.f55303i.setVisibility(0);
                            }
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            restaurantNewInlineAdsViewHolder.f55302h.setVisibility(8);
                            return false;
                        }
                    }).into(restaurantNewInlineAdsViewHolder.f55303i);
                }
            } else if (viewHolder instanceof GroceryVendorViewHolder) {
                ((GroceryVendorViewHolder) viewHolder).bind(model.restaurant, i11);
            } else if (viewHolder instanceof SwimlaneRestaurantViewHolder) {
                ((SwimlaneRestaurantViewHolder) viewHolder).setSwimlane(this.f55310k, (Swimlane) model.data, this.f55311l);
            } else if (viewHolder instanceof ToggleHeaderViewHolder) {
                ((ToggleHeaderViewHolder) viewHolder).bind(this.f55313n, this.verticalId);
            } else if (viewHolder instanceof RewardsMissionViewHolder) {
                RewardsMissionViewHolder rewardsMissionViewHolder = (RewardsMissionViewHolder) viewHolder;
                rewardsMissionViewHolder.setupListener(this.onMissionUpdated);
                rewardsMissionViewHolder.setMission((Mission) model.data);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 14) {
            return new FeatureProductListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_feature_product_list, viewGroup, false), this.featureProductClickListener, this.featureProductShownListener);
        }
        if (i11 == 12) {
            return new SwimlaneRestaurantViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommendation_horizntal_list, viewGroup, false), this.f55310k);
        }
        if (i11 == 1) {
            return new ToggleHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurantlistheader, viewGroup, false), this.headerToggleClickListener);
        }
        if (i11 == 15) {
            return new CollectionsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flutter_collections_container, viewGroup, false));
        }
        if (i11 == 7) {
            return new RestaurantNewInlineAdsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_inline_ad_new, viewGroup, false));
        }
        if (i11 == 13) {
            return new FreshRestaurantUiViewHolderExperiment(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vendor_card_view_experiment, viewGroup, false), true);
        }
        if (i11 == 16) {
            RewardsMissionView rewardsMissionView = new RewardsMissionView(viewGroup.getContext(), (AttributeSet) null, 0, false);
            rewardsMissionView.setOrigin(MissionOrigin.HOME_OF_FOOD);
            rewardsMissionView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new RewardsMissionViewHolder(rewardsMissionView);
        } else if (this.verticalId != 1 || !this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.FLAG_NEW_GROCERY_CELL_DESIGN, false)) {
            return new FreshRestaurantUiViewHolderExperiment(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fresh_restaurant_ui_experiment, viewGroup, false), false);
        } else {
            return new GroceryVendorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grocery_vendor, viewGroup, false), new f(this));
        }
    }

    public void sendFeatureProductAppearedEvent(int i11, FeatureProductListDisplayModel featureProductListDisplayModel) {
        if (!this.impressionTracker.contains(Integer.valueOf(i11))) {
            this.impressionTracker.add(Integer.valueOf(i11));
            this.onFeatureProductAppeared.featureProductAppeared(featureProductListDisplayModel);
            enableFeatureProductTracking();
        }
    }

    public void setClickListener(OnRestaurantClick onRestaurantClick) {
        this.f55311l = onRestaurantClick;
    }

    public void setFeatureProductClickListener(FeatureProductItemViewHolder.OnFeatureProductClick onFeatureProductClick) {
        this.featureProductClickListener = onFeatureProductClick;
    }

    public void setFeatureProductImpressionListener(OnFeatureProductAppeared onFeatureProductAppeared2) {
        this.onFeatureProductAppeared = onFeatureProductAppeared2;
    }

    public void setFeatureProductShownListener(FeatureProductListViewHolder.OnFeatureProductShown onFeatureProductShown) {
        this.featureProductShownListener = onFeatureProductShown;
    }

    public void setHeaderToggleClickListener(ToggleHeaderViewHolder.OnHeaderToggleClickListener onHeaderToggleClickListener) {
        this.headerToggleClickListener = onHeaderToggleClickListener;
    }

    public void setIsTgoStyle(boolean z11) {
        this.f55313n = z11;
        notifyDataSetChanged();
    }

    public void setOnMissionUpdatedListener(RewardsMissionViewHolder.OnMissionUpdated onMissionUpdated2) {
        this.onMissionUpdated = onMissionUpdated2;
    }

    public void setRestaurantsListModels(List<RestaurantListItemModel> list) {
        this.f55308i = list;
        this.f55309j.clear();
        this.f55309j.addAll(list);
        notifyDataSetChanged();
    }
}
