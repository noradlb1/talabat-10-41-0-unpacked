package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.rate.DaggerRateMyOrderScreenComponent;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.RateOrderItem;
import datamodels.RateOrderReq;
import datamodels.RateTag;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.rateorder.RateOrderPresenter;
import library.talabat.mvp.rateorder.RateOrderView;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.ScreenNames;

@Instrumented
public class RateMyOrderScreen extends TalabatBase implements RateOrderView {
    /* access modifiers changed from: private */
    public static final String TAG = "RateMyOrderScreen";
    /* access modifiers changed from: private */
    public BaseRatingBar deliveryTimeRating;
    private RecyclerView foodList;
    private FoodListAdapter foodListAdapter;

    /* renamed from: i  reason: collision with root package name */
    public RateOrderItem[] f54894i;
    private boolean isDisabled;

    /* renamed from: j  reason: collision with root package name */
    public ImageLoader f54895j;

    /* renamed from: k  reason: collision with root package name */
    public RateOrderReq f54896k;

    /* renamed from: l  reason: collision with root package name */
    public String f54897l;
    private LinearLayoutManager llm;

    /* renamed from: m  reason: collision with root package name */
    public String f54898m;
    private CardView mCardViewRateDriverContainer;
    /* access modifiers changed from: private */
    public MaterialEditText mEditTextRateDriver;
    /* access modifiers changed from: private */
    public FlexboxLayout mFlexBoxRateDriverTagsContainer;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayoutRateDriverContainer;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayoutRateDriverImproveContainier;
    private BaseRatingBar mRatingBarDriverPerformance;
    /* access modifiers changed from: private */
    public LinearLayout mReviewSuggestionContainer;
    /* access modifiers changed from: private */
    public ArrayList<Integer> mSelectedDriverTagsId = new ArrayList<>();
    private TextView mTextViewDriverRatedReview;
    private TextView mTextViewOptionalRateDriver;
    /* access modifiers changed from: private */
    public TextView mTextViewStarStatus;
    private Toolbar mToolbar;

    /* renamed from: n  reason: collision with root package name */
    public String f54899n;
    private NestedScrollView nestedScrollView;

    /* renamed from: o  reason: collision with root package name */
    public FlexboxLayout f54900o;
    private TextView orderId;
    private TextView orderStatus;
    private TextView orderTime;

    /* renamed from: p  reason: collision with root package name */
    public TextView f54901p;
    /* access modifiers changed from: private */
    public BaseRatingBar packagingRating;
    public RateOrderPresenter presenter;

    /* renamed from: q  reason: collision with root package name */
    public TextView f54902q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f54903r;
    private Button rateOrderButton;
    private View ratedView;
    private NetworkImageView restaurantLogo;
    private TextView restaurantName;
    private View reviewEdit;
    private TextView reviewHeader;
    private TextView reviewText;
    private View reviewTextView;

    /* renamed from: s  reason: collision with root package name */
    public TextView f54904s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public AppVersionProvider f54905t;
    private View underLine;
    /* access modifiers changed from: private */
    public MaterialEditText userReview;
    /* access modifiers changed from: private */
    public BaseRatingBar valueForMoneyRating;

    public class FoodListAdapter extends RecyclerView.Adapter<FoodListViewHolder> {
        private FoodListAdapter() {
        }

        public int getItemCount() {
            return RateMyOrderScreen.this.f54894i.length;
        }

        public void onBindViewHolder(FoodListViewHolder foodListViewHolder, int i11) {
            final RateOrderItem rateOrderItem = RateMyOrderScreen.this.f54894i[i11];
            foodListViewHolder.f54920h.setText(rateOrderItem.itemName);
            if (rateOrderItem.rating > 0.0f) {
                foodListViewHolder.f54921i.setTouchable(false);
            } else {
                foodListViewHolder.f54921i.setTouchable(true);
            }
            foodListViewHolder.f54921i.setRating(rateOrderItem.rating);
            foodListViewHolder.f54921i.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
                public void onRatingChange(BaseRatingBar baseRatingBar, float f11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("rate : ");
                    sb2.append(f11);
                    rateOrderItem.rating = f11;
                    RateMyOrderScreen.this.showSuggestion();
                }
            });
        }

        public FoodListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new FoodListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rate_my_order_foodlist_item, viewGroup, false));
        }
    }

    public class FoodListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f54920h;

        /* renamed from: i  reason: collision with root package name */
        public BaseRatingBar f54921i;

        public FoodListViewHolder(View view) {
            super(view);
            this.f54920h = (TextView) view.findViewById(R.id.food_item);
            this.f54921i = (BaseRatingBar) view.findViewById(R.id.food_item_rating);
        }
    }

    /* access modifiers changed from: private */
    public void showSuggestion() {
        if (this.f54896k.ratingSubmitted) {
            this.mReviewSuggestionContainer.setVisibility(8);
        } else if (!this.presenter.isAllRated() || !TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_REVIEW_SUGGESTION, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.mReviewSuggestionContainer.setVisibility(8);
        } else if (this.presenter.reachedAverage()) {
            if (((double) this.presenter.getAverageItemRate()) >= 0.5d && ((double) this.presenter.getAverageItemRate()) < 2.5d) {
                this.f54901p.setText(getString(R.string.food_not_quality));
            } else if (((double) this.presenter.getAverageItemRate()) >= 2.5d && this.presenter.getAverageItemRate() < 4.0f) {
                this.f54901p.setText(getString(R.string.food_quality_better));
            } else if (this.presenter.getAverageItemRate() >= 4.0f && this.presenter.getAverageItemRate() < 5.0f) {
                this.f54901p.setText(getString(R.string.food_good));
            } else if (this.presenter.getAverageItemRate() == 5.0f) {
                this.f54901p.setText(getString(R.string.food_very_good));
            }
            if (this.f54901p.getVisibility() != 8 || this.f54902q.getVisibility() != 8 || this.f54903r.getVisibility() != 8 || this.f54904s.getVisibility() != 8) {
                this.mReviewSuggestionContainer.setVisibility(0);
            }
        } else {
            this.mReviewSuggestionContainer.setVisibility(8);
        }
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public Context getContext() {
        return this;
    }

    public float getDeliveryRating() {
        return this.deliveryTimeRating.getRating();
    }

    public String getDriverOtherReason() {
        return this.mEditTextRateDriver.getText().toString();
    }

    public float getDriverRating() {
        if (getRateOrderReq().isDriverRateEnabled) {
            return this.mRatingBarDriverPerformance.getRating();
        }
        return 0.0f;
    }

    public String getOrderId() {
        return this.f54897l;
    }

    public float getPackageRating() {
        return this.packagingRating.getRating();
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public RateOrderItem getRateOrderItemAtIndex(int i11) {
        return this.f54894i[i11];
    }

    public RateOrderReq getRateOrderReq() {
        return this.f54896k;
    }

    public String getReview() {
        return this.userReview.getText().toString();
    }

    public String getScreenName() {
        return ScreenNames.RATEORDER_SCREEN;
    }

    public ArrayList<Integer> getSelectedDriverTagsIds() {
        return this.mSelectedDriverTagsId;
    }

    public float getValueRating() {
        return this.valueForMoneyRating.getRating();
    }

    public boolean isDriverOtherReviewVisible() {
        return this.mLinearLayoutRateDriverContainer.getVisibility() == 0;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        DaggerRateMyOrderScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.rate_my_order_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.title_activity_rate));
            Gson gson = UniversalGson.INSTANCE.gson;
            String stringExtra = getIntent().getStringExtra("value");
            TextView textView = (TextView) findViewById(R.id.deliveryTimeTag);
            this.f54904s = textView;
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (RateMyOrderScreen.this.userReview.getText().toString().length() > 0) {
                        MaterialEditText B = RateMyOrderScreen.this.userReview;
                        B.setText(RateMyOrderScreen.this.userReview.getText() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    MaterialEditText B2 = RateMyOrderScreen.this.userReview;
                    B2.setText(RateMyOrderScreen.this.userReview.getText() + RateMyOrderScreen.this.f54904s.getText().toString());
                    RateMyOrderScreen.this.userReview.setSelection(RateMyOrderScreen.this.userReview.getText().length());
                    RateMyOrderScreen.this.f54904s.setVisibility(8);
                    if (RateMyOrderScreen.this.f54901p.getVisibility() == 8 && RateMyOrderScreen.this.f54902q.getVisibility() == 8 && RateMyOrderScreen.this.f54903r.getVisibility() == 8 && RateMyOrderScreen.this.f54904s.getVisibility() == 8) {
                        RateMyOrderScreen.this.mReviewSuggestionContainer.setVisibility(8);
                    }
                }
            });
            TextView textView2 = (TextView) findViewById(R.id.valueOfMoneyTag);
            this.f54903r = textView2;
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (RateMyOrderScreen.this.userReview.getText().toString().length() > 0) {
                        MaterialEditText B = RateMyOrderScreen.this.userReview;
                        B.setText(RateMyOrderScreen.this.userReview.getText() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    MaterialEditText B2 = RateMyOrderScreen.this.userReview;
                    B2.setText(RateMyOrderScreen.this.userReview.getText() + RateMyOrderScreen.this.f54903r.getText().toString());
                    RateMyOrderScreen.this.userReview.setSelection(RateMyOrderScreen.this.userReview.getText().length());
                    RateMyOrderScreen.this.f54903r.setVisibility(8);
                    if (RateMyOrderScreen.this.f54901p.getVisibility() == 8 && RateMyOrderScreen.this.f54902q.getVisibility() == 8 && RateMyOrderScreen.this.f54903r.getVisibility() == 8 && RateMyOrderScreen.this.f54904s.getVisibility() == 8) {
                        RateMyOrderScreen.this.mReviewSuggestionContainer.setVisibility(8);
                    }
                }
            });
            TextView textView3 = (TextView) findViewById(R.id.packingTag);
            this.f54902q = textView3;
            textView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (RateMyOrderScreen.this.userReview.getText().toString().length() > 0) {
                        MaterialEditText B = RateMyOrderScreen.this.userReview;
                        B.setText(RateMyOrderScreen.this.userReview.getText() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    MaterialEditText B2 = RateMyOrderScreen.this.userReview;
                    B2.setText(RateMyOrderScreen.this.userReview.getText() + RateMyOrderScreen.this.f54902q.getText().toString());
                    RateMyOrderScreen.this.userReview.setSelection(RateMyOrderScreen.this.userReview.getText().length());
                    RateMyOrderScreen.this.f54902q.setVisibility(8);
                    if (RateMyOrderScreen.this.f54901p.getVisibility() == 8 && RateMyOrderScreen.this.f54902q.getVisibility() == 8 && RateMyOrderScreen.this.f54903r.getVisibility() == 8 && RateMyOrderScreen.this.f54904s.getVisibility() == 8) {
                        RateMyOrderScreen.this.mReviewSuggestionContainer.setVisibility(8);
                    }
                }
            });
            TextView textView4 = (TextView) findViewById(R.id.qualityFoodTag);
            this.f54901p = textView4;
            textView4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (RateMyOrderScreen.this.userReview.getText().toString().length() > 0) {
                        MaterialEditText B = RateMyOrderScreen.this.userReview;
                        B.setText(RateMyOrderScreen.this.userReview.getText() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    MaterialEditText B2 = RateMyOrderScreen.this.userReview;
                    B2.setText(RateMyOrderScreen.this.userReview.getText() + RateMyOrderScreen.this.f54901p.getText().toString());
                    RateMyOrderScreen.this.userReview.setSelection(RateMyOrderScreen.this.userReview.getText().length());
                    RateMyOrderScreen.this.f54901p.setVisibility(8);
                    if (RateMyOrderScreen.this.f54901p.getVisibility() == 8 && RateMyOrderScreen.this.f54902q.getVisibility() == 8 && RateMyOrderScreen.this.f54903r.getVisibility() == 8 && RateMyOrderScreen.this.f54904s.getVisibility() == 8) {
                        RateMyOrderScreen.this.mReviewSuggestionContainer.setVisibility(8);
                    }
                }
            });
            this.f54900o = (FlexboxLayout) findViewById(R.id.reviewSuggestion);
            this.mReviewSuggestionContainer = (LinearLayout) findViewById(R.id.linearLayout_suggestionContainer);
            Class cls = RateOrderReq.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, stringExtra, cls);
            }
            this.f54896k = (RateOrderReq) obj;
            this.restaurantLogo = (NetworkImageView) findViewById(R.id.rate_my_order_rest_logo);
            this.restaurantName = (TextView) findViewById(R.id.rate_my_order_restaurant_name);
            this.orderStatus = (TextView) findViewById(R.id.rate_my_order_status);
            this.orderId = (TextView) findViewById(R.id.rate_my_order_orderId);
            this.orderTime = (TextView) findViewById(R.id.rate_my_order_order_time);
            BaseRatingBar baseRatingBar = (BaseRatingBar) findViewById(R.id.packaging_rating);
            this.packagingRating = baseRatingBar;
            baseRatingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
                public void onRatingChange(BaseRatingBar baseRatingBar, float f11) {
                    if (((double) RateMyOrderScreen.this.packagingRating.getRating()) >= 0.5d && ((double) RateMyOrderScreen.this.packagingRating.getRating()) < 2.5d) {
                        RateMyOrderScreen rateMyOrderScreen = RateMyOrderScreen.this;
                        rateMyOrderScreen.f54902q.setText(rateMyOrderScreen.getString(R.string.bad_packed));
                    } else if (((double) RateMyOrderScreen.this.packagingRating.getRating()) >= 2.5d && RateMyOrderScreen.this.packagingRating.getRating() < 4.0f) {
                        RateMyOrderScreen rateMyOrderScreen2 = RateMyOrderScreen.this;
                        rateMyOrderScreen2.f54902q.setText(rateMyOrderScreen2.getString(R.string.pack_average));
                    } else if (RateMyOrderScreen.this.packagingRating.getRating() >= 4.0f && RateMyOrderScreen.this.packagingRating.getRating() < 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen3 = RateMyOrderScreen.this;
                        rateMyOrderScreen3.f54902q.setText(rateMyOrderScreen3.getString(R.string.love_pack));
                    } else if (RateMyOrderScreen.this.packagingRating.getRating() == 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen4 = RateMyOrderScreen.this;
                        rateMyOrderScreen4.f54902q.setText(rateMyOrderScreen4.getString(R.string.prefect_pack));
                    }
                    RateMyOrderScreen.this.showSuggestion();
                }
            });
            BaseRatingBar baseRatingBar2 = (BaseRatingBar) findViewById(R.id.delivery_rating);
            this.deliveryTimeRating = baseRatingBar2;
            baseRatingBar2.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
                public void onRatingChange(BaseRatingBar baseRatingBar, float f11) {
                    if (((double) RateMyOrderScreen.this.deliveryTimeRating.getRating()) >= 0.5d && ((double) RateMyOrderScreen.this.deliveryTimeRating.getRating()) < 2.5d) {
                        RateMyOrderScreen rateMyOrderScreen = RateMyOrderScreen.this;
                        rateMyOrderScreen.f54904s.setText(rateMyOrderScreen.getString(R.string.time_bad));
                    } else if (((double) RateMyOrderScreen.this.deliveryTimeRating.getRating()) >= 2.5d && RateMyOrderScreen.this.deliveryTimeRating.getRating() < 4.0f) {
                        RateMyOrderScreen rateMyOrderScreen2 = RateMyOrderScreen.this;
                        rateMyOrderScreen2.f54904s.setText(rateMyOrderScreen2.getString(R.string.time_expected));
                    } else if (RateMyOrderScreen.this.deliveryTimeRating.getRating() >= 4.0f && RateMyOrderScreen.this.deliveryTimeRating.getRating() < 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen3 = RateMyOrderScreen.this;
                        rateMyOrderScreen3.f54904s.setText(rateMyOrderScreen3.getString(R.string.time_fast));
                    } else if (RateMyOrderScreen.this.deliveryTimeRating.getRating() == 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen4 = RateMyOrderScreen.this;
                        rateMyOrderScreen4.f54904s.setText(rateMyOrderScreen4.getString(R.string.super_fast));
                    }
                    RateMyOrderScreen.this.showSuggestion();
                }
            });
            BaseRatingBar baseRatingBar3 = (BaseRatingBar) findViewById(R.id.value_for_money_rating);
            this.valueForMoneyRating = baseRatingBar3;
            baseRatingBar3.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
                public void onRatingChange(BaseRatingBar baseRatingBar, float f11) {
                    if (((double) RateMyOrderScreen.this.valueForMoneyRating.getRating()) >= 0.5d && ((double) RateMyOrderScreen.this.valueForMoneyRating.getRating()) < 2.5d) {
                        RateMyOrderScreen rateMyOrderScreen = RateMyOrderScreen.this;
                        rateMyOrderScreen.f54903r.setText(rateMyOrderScreen.getString(R.string.was_not_greate_money));
                    } else if (((double) RateMyOrderScreen.this.valueForMoneyRating.getRating()) >= 2.5d && RateMyOrderScreen.this.valueForMoneyRating.getRating() < 4.0f) {
                        RateMyOrderScreen rateMyOrderScreen2 = RateMyOrderScreen.this;
                        rateMyOrderScreen2.f54903r.setText(rateMyOrderScreen2.getString(R.string.average_money));
                    } else if (RateMyOrderScreen.this.valueForMoneyRating.getRating() >= 4.0f && RateMyOrderScreen.this.valueForMoneyRating.getRating() < 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen3 = RateMyOrderScreen.this;
                        rateMyOrderScreen3.f54903r.setText(rateMyOrderScreen3.getString(R.string.quality_money));
                    } else if (RateMyOrderScreen.this.valueForMoneyRating.getRating() == 5.0f) {
                        RateMyOrderScreen rateMyOrderScreen4 = RateMyOrderScreen.this;
                        rateMyOrderScreen4.f54903r.setText(rateMyOrderScreen4.getString(R.string.greate_quality));
                    }
                    RateMyOrderScreen.this.showSuggestion();
                }
            });
            this.userReview = (MaterialEditText) findViewById(R.id.review_editText);
            this.reviewTextView = findViewById(R.id.review_text_view);
            this.ratedView = findViewById(R.id.rated_view);
            this.underLine = findViewById(R.id.underline);
            this.nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scrollview);
            this.rateOrderButton = (Button) findViewById(R.id.rate_my_order_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.f54895j = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.f54897l = getIntent().getStringExtra("orderId");
            this.f54898m = getIntent().getStringExtra("orderTime");
            this.f54899n = getIntent().getStringExtra("orderStatus");
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rate_my_order_food_list);
            this.foodList = recyclerView;
            recyclerView.setLayoutManager(this.llm);
            this.foodList.removeItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
            this.reviewEdit = findViewById(R.id.review_edit_view);
            this.reviewText = (TextView) findViewById(R.id.review_text);
            this.reviewHeader = (TextView) findViewById(R.id.review_header);
            this.presenter = new RateOrderPresenter(this.f54905t, this);
            this.mLinearLayoutRateDriverContainer = (LinearLayout) findViewById(R.id.linearLayout_rateDriverContainer);
            this.mRatingBarDriverPerformance = (BaseRatingBar) findViewById(R.id.ratingBar_driverPerformance);
            this.mTextViewOptionalRateDriver = (TextView) findViewById(R.id.textView_rateDriverOptional);
            this.mLinearLayoutRateDriverImproveContainier = (LinearLayout) findViewById(R.id.linearLayout_rateDriverImproveContainer);
            this.mFlexBoxRateDriverTagsContainer = (FlexboxLayout) findViewById(R.id.flexBox_rateDriverTags);
            this.mEditTextRateDriver = (MaterialEditText) findViewById(R.id.editText_rateDriver);
            this.mTextViewStarStatus = (TextView) findViewById(R.id.textView_starStatus);
            this.mCardViewRateDriverContainer = (CardView) findViewById(R.id.cardView_rateDriverContainer);
            this.mTextViewDriverRatedReview = (TextView) findViewById(R.id.textView_driverReview);
            RateOrderPresenter rateOrderPresenter = this.presenter;
            RateOrderReq rateOrderReq = this.f54896k;
            rateOrderPresenter.setUpView(rateOrderReq, rateOrderReq.branchId, rateOrderReq.transactionId);
            this.rateOrderButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    RateMyOrderScreen.this.startLodingPopup();
                    RateMyOrderScreen.this.presenter.submitRating();
                }
            });
            this.userReview.setFilters(new InputFilter[]{new InputFilter.LengthFilter(250)});
            if (this.f54896k.isDriverRateEnabled) {
                this.mCardViewRateDriverContainer.setVisibility(0);
                if (this.f54896k.isDriverRateMandatory) {
                    this.mTextViewOptionalRateDriver.setVisibility(8);
                } else {
                    this.mTextViewOptionalRateDriver.setVisibility(0);
                }
                this.mRatingBarDriverPerformance.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
                    public void onRatingChange(BaseRatingBar baseRatingBar, float f11) {
                        String unused = RateMyOrderScreen.TAG;
                        RateMyOrderScreen.this.mLinearLayoutRateDriverContainer.setVisibility(8);
                        RateMyOrderScreen.this.mEditTextRateDriver.setText("");
                        RateMyOrderScreen.this.mSelectedDriverTagsId = new ArrayList();
                        if (f11 > 0.0f) {
                            int i11 = ((int) f11) - 1;
                            RateMyOrderScreen.this.mTextViewStarStatus.setText(RateMyOrderScreen.this.getResources().getStringArray(R.array.tags)[i11]);
                            ArrayList arrayList = new ArrayList();
                            RateMyOrderScreen rateMyOrderScreen = RateMyOrderScreen.this;
                            arrayList.addAll(rateMyOrderScreen.presenter.getRateTags(rateMyOrderScreen.f54896k, i11));
                            RateTag.Tag tag = new RateTag.Tag();
                            tag.setTagId(0);
                            tag.setTagText(RateMyOrderScreen.this.getString(R.string.Other));
                            arrayList.add(tag);
                            RateMyOrderScreen.this.mFlexBoxRateDriverTagsContainer.removeAllViews();
                            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                                View inflate = RateMyOrderScreen.this.getLayoutInflater().inflate(R.layout.item_tag, RateMyOrderScreen.this.mFlexBoxRateDriverTagsContainer, false);
                                ((TextView) inflate.findViewById(R.id.textView_tag)).setText(((RateTag.Tag) arrayList.get(i12)).getTagText());
                                inflate.setTag(Integer.valueOf(((RateTag.Tag) arrayList.get(i12)).getTagId()));
                                inflate.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        int intValue = ((Integer) view.getTag()).intValue();
                                        if (intValue == 0 && !view.isSelected()) {
                                            RateMyOrderScreen.this.mLinearLayoutRateDriverContainer.setVisibility(0);
                                            view.setSelected(true);
                                        } else if (intValue != 0) {
                                            if (view.isSelected()) {
                                                view.setSelected(false);
                                                if (RateMyOrderScreen.this.mSelectedDriverTagsId.contains(new Integer(intValue))) {
                                                    RateMyOrderScreen.this.mSelectedDriverTagsId.remove(new Integer(intValue));
                                                    return;
                                                }
                                                return;
                                            }
                                            RateMyOrderScreen.this.mSelectedDriverTagsId.add(Integer.valueOf(intValue));
                                            view.setSelected(true);
                                        } else if (intValue == 0 && view.isSelected()) {
                                            RateMyOrderScreen.this.mLinearLayoutRateDriverContainer.setVisibility(8);
                                            RateMyOrderScreen.this.mEditTextRateDriver.setText("");
                                            view.setSelected(false);
                                        }
                                    }
                                });
                                RateMyOrderScreen.this.mFlexBoxRateDriverTagsContainer.addView(inflate);
                            }
                            RateMyOrderScreen.this.mLinearLayoutRateDriverImproveContainier.setVisibility(0);
                            RateMyOrderScreen.this.mTextViewStarStatus.setVisibility(0);
                            return;
                        }
                        RateMyOrderScreen.this.mLinearLayoutRateDriverImproveContainier.setVisibility(8);
                        RateMyOrderScreen.this.mTextViewStarStatus.setVisibility(8);
                    }
                });
                return;
            }
            this.mCardViewRateDriverContainer.setVisibility(8);
        } catch (Exception e11) {
            e11.printStackTrace();
            pauseBannerForNextScreen();
            finish();
        }
    }

    public void onError() {
    }

    public void onRatingSubmited() {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) getString(R.string.your_rating_has_been_submitted));
        builder.setPositiveButton((int) R.string.rate_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                Intent intent = new Intent();
                intent.putExtra("orderId", RateMyOrderScreen.this.f54897l);
                RateMyOrderScreen.this.setResult(-1, intent);
                RateMyOrderScreen.this.finish();
            }
        });
        builder.show();
    }

    public void onValidationFailed(int i11) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        if (i11 == 0) {
            builder.setMessage((CharSequence) getString(R.string.rate_all_items));
        } else if (i11 == 1) {
            builder.setMessage((int) R.string.rate_pachaging);
        } else if (i11 == 2) {
            builder.setMessage((int) R.string.rate_time);
        } else if (i11 == 3) {
            builder.setMessage((int) R.string.rate_value);
        } else if (i11 == 4) {
            builder.setMessage((int) R.string.rate_quality);
        } else if (i11 == 5) {
            builder.setMessage((int) R.string.unrate_driver);
        } else if (i11 == 6) {
            builder.setMessage((int) R.string.driver_tags);
        } else if (i11 == 7) {
            builder.setMessage((int) R.string.type_other_reason);
        }
        builder.show();
    }

    public void setDeliveryRating(float f11) {
        this.deliveryTimeRating.setRating(f11);
    }

    public void setDriverOtherReason(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.item_tag, this.mFlexBoxRateDriverTagsContainer, false);
        TextView textView = (TextView) inflate.findViewById(R.id.textView_tag);
        textView.setText(getString(R.string.Other));
        textView.setSelected(true);
        textView.setClickable(false);
        this.mFlexBoxRateDriverTagsContainer.addView(inflate);
        this.mTextViewDriverRatedReview.setText(str);
        this.mTextViewDriverRatedReview.setVisibility(0);
        this.mLinearLayoutRateDriverImproveContainier.setVisibility(0);
    }

    public void setDriverRating(float f11) {
        this.mRatingBarDriverPerformance.setRating(f11);
        if (f11 > 0.0f) {
            this.mTextViewStarStatus.setText(getResources().getStringArray(R.array.tags)[((int) f11) - 1]);
        }
    }

    public void setOrderDetails(String str, String str2, String str3) {
        this.orderId.setText(str);
        this.orderStatus.setText(str2);
        this.orderTime.setText(str3);
    }

    public void setPackageRating(float f11) {
        this.packagingRating.setRating(f11);
    }

    public void setRateOrderItems(RateOrderItem[] rateOrderItemArr) {
        this.f54894i = rateOrderItemArr;
        FoodListAdapter foodListAdapter2 = new FoodListAdapter();
        this.foodList.setNestedScrollingEnabled(false);
        this.foodList.setAdapter(foodListAdapter2);
        this.nestedScrollView.smoothScrollTo(0, 0);
        this.nestedScrollView.scrollTo(0, 0);
    }

    public void setRated(boolean z11) {
        if (z11) {
            this.reviewText.setVisibility(0);
            this.reviewHeader.setVisibility(0);
            this.rateOrderButton.setVisibility(8);
            this.packagingRating.setTouchable(false);
            this.deliveryTimeRating.setTouchable(false);
            this.valueForMoneyRating.setTouchable(false);
            this.userReview.setEnabled(false);
            this.mRatingBarDriverPerformance.setTouchable(false);
            this.reviewEdit.setVisibility(8);
            this.ratedView.setVisibility(0);
            return;
        }
        this.reviewText.setVisibility(8);
        this.reviewHeader.setVisibility(8);
        this.reviewTextView.setVisibility(0);
        this.rateOrderButton.setVisibility(0);
        this.packagingRating.setTouchable(true);
        this.deliveryTimeRating.setTouchable(true);
        this.valueForMoneyRating.setTouchable(true);
        this.userReview.setEnabled(true);
        this.mRatingBarDriverPerformance.setTouchable(true);
        this.reviewEdit.setVisibility(0);
        this.ratedView.setVisibility(8);
    }

    public void setRestaurantLogo(String str) {
        this.restaurantLogo.setImageUrl(str, this.f54895j);
    }

    public void setRestaurantName(String str) {
        this.restaurantName.setText(str);
    }

    public void setReview(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.reviewTextView.setVisibility(0);
            this.reviewEdit.setVisibility(8);
            this.reviewText.setVisibility(0);
            this.reviewHeader.setVisibility(0);
            this.reviewText.setText(str);
            return;
        }
        this.reviewTextView.setVisibility(8);
        this.reviewText.setVisibility(8);
        this.reviewHeader.setVisibility(8);
        this.reviewEdit.setVisibility(8);
    }

    public void setSelectedTags(ArrayList<RateTag.Tag> arrayList) {
        Iterator<RateTag.Tag> it = arrayList.iterator();
        while (it.hasNext()) {
            View inflate = getLayoutInflater().inflate(R.layout.item_tag, this.mFlexBoxRateDriverTagsContainer, false);
            TextView textView = (TextView) inflate.findViewById(R.id.textView_tag);
            textView.setText(it.next().getTagText());
            textView.setSelected(true);
            textView.setClickable(false);
            this.mFlexBoxRateDriverTagsContainer.addView(inflate);
        }
        this.mLinearLayoutRateDriverImproveContainier.setVisibility(0);
    }

    public void setValueRating(float f11) {
        this.valueForMoneyRating.setRating(f11);
    }
}
