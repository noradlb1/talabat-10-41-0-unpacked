package com.talabat.collectiondetails.ui.quickfilter;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.collectiondetails.R;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.talabatcommon.extentions.StringUtils;
import datamodels.QuickFilter;
import datamodels.SubscriptionCollection;
import datamodels.SubscriptionCollectionBackground;
import datamodels.SubscriptionCollectionCallToAction;
import datamodels.SubscriptionCollectionText;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wf.c0;
import wf.d0;
import wf.e0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/SubscribeCollectionActivity;", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsActivity;", "()V", "buildHeader", "", "collection", "Ldatamodels/QuickFilter;", "getLayout", "", "initHeader", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscribeCollectionActivity extends QuickFilterRestaurantsActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* access modifiers changed from: private */
    /* renamed from: buildHeader$lambda-3  reason: not valid java name */
    public static final void m9568buildHeader$lambda3(SubscribeCollectionActivity subscribeCollectionActivity, String str, QuickFilter quickFilter, View view) {
        String str2;
        SubscriptionCollectionCallToAction callToAction;
        Intrinsics.checkNotNullParameter(subscribeCollectionActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$btnText");
        Intrinsics.checkNotNullParameter(quickFilter, "$collection");
        Dialog dialog = new Dialog(subscribeCollectionActivity);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        dialog.setContentView(R.layout.collections_dialog_subscribe_collection_informative);
        ((TextView) dialog.findViewById(R.id.subscription_header)).setText(str);
        TextView textView = (TextView) dialog.findViewById(R.id.subscription_text);
        SubscriptionCollection subscription = quickFilter.getSubscription();
        if (subscription == null || (callToAction = subscription.getCallToAction()) == null || (str2 = callToAction.getMessage()) == null) {
            str2 = "";
        }
        textView.setText(str2);
        ((ImageButton) dialog.findViewById(R.id.imageButton_close)).setOnClickListener(new d0(dialog));
        subscribeCollectionActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i11 = (int) (((double) displayMetrics.widthPixels) * 0.9d);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(i11, -2);
        }
        dialog.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: buildHeader$lambda-3$lambda-2  reason: not valid java name */
    public static final void m9569buildHeader$lambda3$lambda2(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: initHeader$lambda-0  reason: not valid java name */
    public static final void m9570initHeader$lambda0(SubscribeCollectionActivity subscribeCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(subscribeCollectionActivity, "this$0");
        subscribeCollectionActivity.onBackPressed();
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

    public void buildHeader(@NotNull QuickFilter quickFilter) {
        boolean z11;
        String str;
        String str2;
        SubscriptionCollectionCallToAction callToAction;
        Integer type;
        SubscriptionCollectionCallToAction callToAction2;
        String buttonText;
        SubscriptionCollectionText text;
        String color;
        SubscriptionCollectionText text2;
        SubscriptionCollectionText text3;
        String str3;
        SubscriptionCollectionBackground background;
        String str4;
        SubscriptionCollectionBackground background2;
        SubscriptionCollectionBackground background3;
        Integer type2;
        Intrinsics.checkNotNullParameter(quickFilter, GemAccessor.COMPONENT_COLLECTION);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        ((AppBarLayout) _$_findCachedViewById(R.id.subscribeCollectionAppBar)).setVisibility(0);
        SubscriptionCollection subscription = quickFilter.getSubscription();
        boolean z12 = true;
        if (subscription == null || (background3 = subscription.getBackground()) == null || (type2 = background3.getType()) == null || type2.intValue() != 1) {
            z11 = false;
        } else {
            z11 = true;
        }
        String str5 = null;
        if (z11) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.headerBackground);
            SubscriptionCollection subscription2 = quickFilter.getSubscription();
            if (subscription2 == null || (background2 = subscription2.getBackground()) == null) {
                str4 = null;
            } else {
                str4 = background2.getColor();
            }
            imageView.setBackgroundColor(Color.parseColor("#" + str4));
        } else {
            RequestManager with = Glide.with((FragmentActivity) this);
            SubscriptionCollection subscription3 = quickFilter.getSubscription();
            if (subscription3 == null || (background = subscription3.getBackground()) == null) {
                str3 = null;
            } else {
                str3 = background.getImage();
            }
            ((RequestBuilder) with.load(StringUtils.vendorImage(str3)).fitCenter()).into((ImageView) _$_findCachedViewById(R.id.headerBackground));
        }
        RequestManager with2 = Glide.with((FragmentActivity) this);
        SubscriptionCollection subscription4 = quickFilter.getSubscription();
        if (subscription4 != null) {
            str5 = subscription4.getForegroundImg();
        }
        ((RequestBuilder) with2.load(StringUtils.vendorImage(str5)).fitCenter()).into((ImageView) _$_findCachedViewById(R.id.headerLogo));
        int i11 = R.id.headerMainText;
        TextView textView = (TextView) _$_findCachedViewById(i11);
        SubscriptionCollection subscription5 = quickFilter.getSubscription();
        String str6 = "";
        if (subscription5 == null || (text3 = subscription5.getText()) == null || (str = text3.getMain()) == null) {
            str = str6;
        }
        textView.setText(str);
        int i12 = R.id.headerSecondaryText;
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        SubscriptionCollection subscription6 = quickFilter.getSubscription();
        if (subscription6 == null || (text2 = subscription6.getText()) == null || (str2 = text2.getSecondary()) == null) {
            str2 = str6;
        }
        textView2.setText(str2);
        SubscriptionCollection subscription7 = quickFilter.getSubscription();
        if (!(subscription7 == null || (text = subscription7.getText()) == null || (color = text.getColor()) == null)) {
            ((TextView) _$_findCachedViewById(i12)).setTextColor(Color.parseColor("#" + color));
            ((TextView) _$_findCachedViewById(i11)).setTextColor(Color.parseColor("#" + color));
        }
        SubscriptionCollection subscription8 = quickFilter.getSubscription();
        if (!(subscription8 == null || (callToAction2 = subscription8.getCallToAction()) == null || (buttonText = callToAction2.getButtonText()) == null)) {
            str6 = buttonText;
        }
        SubscriptionCollection subscription9 = quickFilter.getSubscription();
        if (subscription9 == null || (callToAction = subscription9.getCallToAction()) == null || (type = callToAction.getType()) == null || type.intValue() != 1) {
            z12 = false;
        }
        if (z12) {
            int i13 = R.id.headerCallToAction;
            ((Button) _$_findCachedViewById(i13)).setText(str6);
            ((Button) _$_findCachedViewById(i13)).setVisibility(0);
        } else {
            ((Button) _$_findCachedViewById(R.id.headerCallToAction)).setVisibility(8);
        }
        ((Button) _$_findCachedViewById(R.id.headerCallToAction)).setOnClickListener(new e0(this, str6, quickFilter));
    }

    public int getLayout() {
        return R.layout.collections_activity_subscribe_collection;
    }

    public void initHeader() {
        int i11 = R.id.subscribeCollectionToolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationIcon(com.talabat.talabatcommon.R.drawable.ic_m_back_black);
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationOnClickListener(new c0(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
