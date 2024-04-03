package com.talabat.restaurants.tmart;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.talabat.R;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.tmart.data.IDarkStoreEntryInteractor;
import com.talabat.restaurants.tmart.ui.DarkstoreEntryPresenter;
import com.talabat.restaurants.tmart.ui.IDarkStoreEntryView;
import com.talabat.restaurants.tmart.ui.IDarkstoreEntryPresenter;
import datamodels.Restaurant;
import gt.a;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010(\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\b\u0010)\u001a\u00020\"H\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\"H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/restaurants/tmart/DarkstoreEntryView;", "Landroid/widget/FrameLayout;", "Lcom/talabat/restaurants/tmart/ui/IDarkStoreEntryView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "dailyAverageDuration", "Landroid/widget/TextView;", "dailyHeader", "Landroid/widget/ImageView;", "dailyLogo", "dailyShimmerContainer", "Landroidx/cardview/widget/CardView;", "dailyStatusTextView", "dailyStatusView", "Landroid/widget/RelativeLayout;", "dailyTalabatContainer", "dailyTalabatTitle", "darkStorePresenter", "Lcom/talabat/restaurants/tmart/ui/IDarkstoreEntryPresenter;", "darkStoreVendor", "Ldatamodels/Restaurant;", "getDarkStoreVendor", "()Ldatamodels/Restaurant;", "setDarkStoreVendor", "(Ldatamodels/Restaurant;)V", "sendShopClickedEvent", "Lkotlin/Function0;", "", "talabatDailyShimmer", "Lio/supercharge/shimmerlayout/ShimmerLayout;", "darkstoreFailure", "darkstoreSuccess", "darkStoreInfo", "getDarkStore", "hideDailyTalabatLoading", "navigateToDarkStores", "restaurant", "showDailyTalabatLoading", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreEntryView extends FrameLayout implements IDarkStoreEntryView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private Activity activity;
    @Nullable
    private TextView dailyAverageDuration;
    @Nullable
    private ImageView dailyHeader;
    @Nullable
    private ImageView dailyLogo;
    @Nullable
    private CardView dailyShimmerContainer;
    @Nullable
    private TextView dailyStatusTextView;
    @Nullable
    private RelativeLayout dailyStatusView;
    @Nullable
    private CardView dailyTalabatContainer;
    @Nullable
    private TextView dailyTalabatTitle;
    @NotNull
    private final IDarkstoreEntryPresenter darkStorePresenter;
    @Nullable
    private Restaurant darkStoreVendor;
    @Nullable
    private Function0<Unit> sendShopClickedEvent;
    @Nullable
    private ShimmerLayout talabatDailyShimmer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DarkstoreEntryView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DarkstoreEntryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DarkstoreEntryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.layout_talabat_daily_entry_point, this);
        this.talabatDailyShimmer = (ShimmerLayout) findViewById(R.id.talabat_daily_shimmer);
        this.dailyShimmerContainer = (CardView) findViewById(R.id.daily_shimmer_container);
        this.dailyTalabatContainer = (CardView) findViewById(R.id.talabat_daily_container);
        this.dailyHeader = (ImageView) findViewById(R.id.daily_header_image);
        this.dailyLogo = (ImageView) findViewById(R.id.talabat_daily_logo);
        this.dailyAverageDuration = (TextView) findViewById(R.id.daily_average_duration);
        this.dailyTalabatTitle = (TextView) findViewById(R.id.talabat_daily);
        this.dailyStatusView = (RelativeLayout) findViewById(R.id.status_view);
        this.dailyStatusTextView = (TextView) findViewById(R.id.new_status_text);
        ShimmerLayout shimmerLayout = this.talabatDailyShimmer;
        if (shimmerLayout != null) {
            shimmerLayout.startShimmerAnimation();
        }
        this.darkStorePresenter = new DarkstoreEntryPresenter(this, (IDarkStoreEntryInteractor) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: darkstoreSuccess$lambda-1  reason: not valid java name */
    public static final void m10728darkstoreSuccess$lambda1(Restaurant restaurant, DarkstoreEntryView darkstoreEntryView, View view) {
        Intrinsics.checkNotNullParameter(darkstoreEntryView, "this$0");
        if (restaurant != null) {
            darkstoreEntryView.navigateToDarkStores(restaurant);
        }
    }

    private final void navigateToDarkStores(Restaurant restaurant) {
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        DarkstoresDelegate.DSClickOrigin dSClickOrigin = DarkstoresDelegate.DSClickOrigin.ORIGIN_BANNER;
        GlobalDataModel.ShopClickOrigin = dSClickOrigin.getOrigin();
        Function0<Unit> function0 = this.sendShopClickedEvent;
        if (function0 != null) {
            function0.invoke();
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            DarkstoresDelegate.Companion.onDarkstoresClicked$default(DarkstoresDelegate.Companion, activity2, restaurant, 0, (String) null, false, false, false, dSClickOrigin, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8060, (Object) null);
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

    public void darkstoreFailure() {
        setVisibility(8);
    }

    public void darkstoreSuccess(@Nullable Restaurant restaurant) {
        boolean z11;
        TextView textView;
        boolean z12;
        boolean z13;
        String str;
        String str2;
        String str3;
        this.darkStoreVendor = restaurant;
        CardView cardView = this.dailyTalabatContainer;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        CardView cardView2 = this.dailyTalabatContainer;
        if (cardView2 != null) {
            cardView2.setOnClickListener(new a(restaurant, this));
        }
        ImageView imageView = this.dailyHeader;
        String str4 = null;
        if (imageView != null) {
            RequestManager with = Glide.with((View) this);
            if (restaurant != null) {
                str3 = restaurant.getTalabatCoverLogo();
            } else {
                str3 = null;
            }
            with.load(str3).into(imageView);
        }
        ImageView imageView2 = this.dailyLogo;
        if (imageView2 != null) {
            RequestManager with2 = Glide.with((View) this);
            if (restaurant != null) {
                str4 = restaurant.getLogo();
            }
            with2.load(str4).into(imageView2);
        }
        TextView textView2 = this.dailyAverageDuration;
        String str5 = "";
        if (textView2 != null) {
            if (restaurant == null || (str2 = restaurant.deliveryTime) == null) {
                str2 = str5;
            }
            textView2.setText(str2);
        }
        TextView textView3 = this.dailyTalabatTitle;
        if (textView3 != null) {
            if (!(restaurant == null || (str = restaurant.f13873name) == null)) {
                str5 = str;
            }
            textView3.setText(str5);
        }
        if (restaurant == null || restaurant.statusType != 2) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            if (restaurant == null || restaurant.statusType != 1) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z12) {
                if (restaurant == null || restaurant.statusType != 5) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z13) {
                    RelativeLayout relativeLayout = this.dailyStatusView;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    AppTracker.onDarkStoresShown(getContext(), "grocery", restaurant);
                }
            }
        }
        RelativeLayout relativeLayout2 = this.dailyStatusView;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        int i11 = restaurant.statusType;
        if (i11 == 1) {
            TextView textView4 = this.dailyStatusTextView;
            if (textView4 != null) {
                textView4.setText(getResources().getText(R.string.closed_tgo));
            }
        } else if (i11 == 2) {
            TextView textView5 = this.dailyStatusTextView;
            if (textView5 != null) {
                textView5.setText(getResources().getText(R.string.busy_tgo));
            }
        } else if (i11 == 5 && (textView = this.dailyStatusTextView) != null) {
            textView.setText(getResources().getText(R.string.open_for_preorder));
        }
        AppTracker.onDarkStoresShown(getContext(), "grocery", restaurant);
    }

    public final void getDarkStore(@NotNull Activity activity2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(function0, "sendShopClickedEvent");
        this.activity = activity2;
        this.sendShopClickedEvent = function0;
        this.darkStorePresenter.getDarkStoresInfo();
    }

    @Nullable
    public final Restaurant getDarkStoreVendor() {
        return this.darkStoreVendor;
    }

    public void hideDailyTalabatLoading() {
        CardView cardView = this.dailyShimmerContainer;
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        ShimmerLayout shimmerLayout = this.talabatDailyShimmer;
        if (shimmerLayout != null) {
            shimmerLayout.stopShimmerAnimation();
        }
    }

    public final void setDarkStoreVendor(@Nullable Restaurant restaurant) {
        this.darkStoreVendor = restaurant;
    }

    public void showDailyTalabatLoading() {
        CardView cardView = this.dailyShimmerContainer;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        ShimmerLayout shimmerLayout = this.talabatDailyShimmer;
        if (shimmerLayout != null) {
            shimmerLayout.startShimmerAnimation();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DarkstoreEntryView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
