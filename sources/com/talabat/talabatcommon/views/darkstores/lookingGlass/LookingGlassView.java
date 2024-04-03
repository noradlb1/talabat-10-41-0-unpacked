package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.integration.IntegrationAppTracker;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.exception.LookingGlassFailure;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GVendorInfo;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.GlassProductsAdapter;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapter;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayCategory;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GHeadline;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.viewModel.LookingGlassViewModel;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.viewModel.LookingGlassViewModelBuilder;
import com.talabat.talabatcommon.views.ramadan.RamadanView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lv.a;
import lv.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002JKB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0002J*\u00109\u001a\u00020\u001d2 \u0010:\u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130<\u0018\u00010;H\u0002J\u000e\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u0017J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\tH\u0002J*\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\b\b\u0002\u0010F\u001a\u00020GH\u0007J\b\u0010H\u001a\u00020\u001dH\u0002J\b\u0010I\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/LookingGlassView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/viewModel/LookingGlassViewModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BUSY", "getBUSY", "()I", "CLOSED", "getCLOSED", "OPEN", "getOPEN", "eventOrigin", "", "getEventOrigin", "()Ljava/lang/String;", "lookingGlassListener", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/LookingGlassView$LookingGlassListener;", "mHeadlinesAdapter", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/HeadlinesAdapter;", "mProductsAdapter", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getABTestResults", "abTestResult", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/ABTestResult;", "getBackgroundColor", "isGrayBg", "", "getLayoutId", "getViewModelClass", "Ljava/lang/Class;", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onHeadlineClicked", "headline", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GHeadline;", "onLifecycleOwnerAttached", "onProductClicked", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "populateHeader", "vendorInfo", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GVendorInfo;", "populateViews", "model", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "sendAnalyticEvent", "pair", "Lkotlin/Pair;", "", "setListener", "listener", "setupView", "showNewDesign", "backgroundColor", "start", "tag", "hasLogo", "hasViewAllBtn", "org", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/LookingGlassView$LookingGlassOrigin;", "trackLookingGlassClicked", "viewModelBuilder", "LookingGlassListener", "LookingGlassOrigin", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassView extends MvvmLinearLayout<LookingGlassViewModel> {
    private final int BUSY;
    private final int CLOSED;
    private final int OPEN;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final String eventOrigin;
    @Nullable
    private LookingGlassListener lookingGlassListener;
    private HeadlinesAdapter mHeadlinesAdapter;
    private GlassProductsAdapter mProductsAdapter;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/LookingGlassView$LookingGlassListener;", "", "onFallback", "", "onProductClicked", "id", "", "tempRestaurant", "onViewAllClicked", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LookingGlassListener {
        void onFallback();

        void onProductClicked(@NotNull String str, @NotNull String str2);

        void onViewAllClicked(@NotNull String str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/LookingGlassView$LookingGlassOrigin;", "", "origin", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "ORIGIN_LISTING", "ORIGIN_TRACKING", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum LookingGlassOrigin {
        ORIGIN_LISTING(DefaultCardView.CARD_LIST),
        ORIGIN_TRACKING(ScreenNames.SCREEN_TYPE_ORDERCONFIRM);
        
        @NotNull
        private final String origin;

        private LookingGlassOrigin(String str) {
            this.origin = str;
        }

        @NotNull
        public final String getOrigin() {
            return this.origin;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookingGlassView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CLOSED = 1;
        this.BUSY = 2;
        this.eventOrigin = "item_carousel";
    }

    /* access modifiers changed from: private */
    public final void getABTestResults(ABTestResult aBTestResult) {
        if (aBTestResult != null) {
            this.mHeadlinesAdapter = new HeadlinesAdapter(aBTestResult.isNewDesign(), aBTestResult.isGrayBackground());
            this.mProductsAdapter = new GlassProductsAdapter(aBTestResult.isNewDesign());
            setupView(aBTestResult.isNewDesign(), getBackgroundColor(aBTestResult.isGrayBackground()));
        }
    }

    private final int getBackgroundColor(boolean z11) {
        return z11 ? R.color.ds_neutral_4 : R.color.ds_neutral_white;
    }

    /* access modifiers changed from: private */
    /* renamed from: observatory$lambda-1  reason: not valid java name */
    public static final void m5763observatory$lambda1(LookingGlassView lookingGlassView, LookingGlassDisplayModel lookingGlassDisplayModel) {
        Intrinsics.checkNotNullParameter(lookingGlassView, "this$0");
        if (lookingGlassDisplayModel != null) {
            lookingGlassView.populateViews(lookingGlassDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final void onHeadlineClicked(GHeadline gHeadline) {
        Unit unit;
        List<GDisplayItem> headlineProducts = ((LookingGlassViewModel) getViewModel()).getHeadlineProducts(gHeadline.getId());
        GlassProductsAdapter glassProductsAdapter = null;
        if (headlineProducts != null) {
            GlassProductsAdapter glassProductsAdapter2 = this.mProductsAdapter;
            if (glassProductsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProductsAdapter");
                glassProductsAdapter2 = null;
            }
            glassProductsAdapter2.submitList(headlineProducts);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            GlassProductsAdapter glassProductsAdapter3 = this.mProductsAdapter;
            if (glassProductsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProductsAdapter");
            } else {
                glassProductsAdapter = glassProductsAdapter3;
            }
            glassProductsAdapter.submitList(CollectionsKt__CollectionsKt.emptyList());
        }
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(GDisplayItem gDisplayItem) {
        String id2 = gDisplayItem.getId();
        if (id2 != null) {
            LookingGlassListener lookingGlassListener2 = this.lookingGlassListener;
            if (lookingGlassListener2 != null) {
                lookingGlassListener2.onProductClicked(id2, ((LookingGlassViewModel) getViewModel()).getTempRestaurant());
            }
            ((LookingGlassViewModel) getViewModel()).getItemClickedEvent(gDisplayItem);
            trackLookingGlassClicked();
        }
    }

    private final void populateHeader(GVendorInfo gVendorInfo) {
        String logoUrl = gVendorInfo.getLogoUrl();
        if (logoUrl != null) {
            ImageView imageView = (ImageView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.talabat_daily_logo);
            Intrinsics.checkNotNullExpressionValue(imageView, "talabat_daily_logo");
            ImageViewForTalabatKt.setImageResizeUrl$default(imageView, logoUrl, 0, 0, false, 14, (Object) null);
        }
        int status = gVendorInfo.getStatus();
        if (status == this.OPEN) {
            ((FrameLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.frameLayout_statusContainer)).setVisibility(8);
        } else if (status == this.CLOSED) {
            ((TextView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.textView_status)).setText(ViewKt.getString(this, com.talabat.localization.R.string.lg_closed));
            ((FrameLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.frameLayout_statusContainer)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.textView_status)).setText(ViewKt.getString(this, com.talabat.localization.R.string.lg_busy));
            ((FrameLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.frameLayout_statusContainer)).setVisibility(0);
        }
    }

    private final void populateViews(LookingGlassDisplayModel lookingGlassDisplayModel) {
        GVendorInfo vendorInfo = lookingGlassDisplayModel.getVendorInfo();
        if (vendorInfo != null) {
            populateHeader(vendorInfo);
        }
        ArrayList<GDisplayCategory> categories = lookingGlassDisplayModel.getCategories();
        if (categories != null) {
            if (!categories.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(categories, 10));
                for (GDisplayCategory gDisplayCategory : categories) {
                    arrayList.add(new GHeadline(gDisplayCategory.getHeadline(), gDisplayCategory.getId()));
                }
                HeadlinesAdapter headlinesAdapter = this.mHeadlinesAdapter;
                Object obj = null;
                if (headlinesAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadlinesAdapter");
                    headlinesAdapter = null;
                }
                headlinesAdapter.submitList(arrayList);
                HeadlinesAdapter headlinesAdapter2 = this.mHeadlinesAdapter;
                if (headlinesAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadlinesAdapter");
                    headlinesAdapter2 = null;
                }
                headlinesAdapter2.setSelectedItem(0);
                onHeadlineClicked((GHeadline) arrayList.get(0));
                setVisibility(0);
                IntegrationAppTracker.Companion companion = IntegrationAppTracker.Companion;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GVendorInfo vendorInfo2 = lookingGlassDisplayModel.getVendorInfo();
                if (vendorInfo2 != null) {
                    obj = vendorInfo2.getGRestaurant();
                }
                companion.onLookingGlassShown(context, String.valueOf(obj));
            } else {
                failureHere(new LookingGlassFailure());
            }
        }
        if (((RamadanView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.layout_ramadan_header)).isVisible()) {
            ((ConstraintLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.layout_looking_glass_header)).setVisibility(8);
        } else {
            ((ConstraintLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.layout_looking_glass_header)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void sendAnalyticEvent(Pair<String, ? extends Map<String, String>> pair) {
        if (pair != null) {
            TalabatGTM.Companion companion = TalabatGTM.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.trackEvent(context, pair.getFirst(), (Map) pair.getSecond());
        }
    }

    private final void setupView(boolean z11, int i11) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 0);
        Drawable drawable = ContextCompat.getDrawable(getContext(), com.talabat.talabatcommon.R.drawable.divider_headline_chips);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.headlines);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(dividerItemDecoration);
        HeadlinesAdapter headlinesAdapter = this.mHeadlinesAdapter;
        GlassProductsAdapter glassProductsAdapter = null;
        if (headlinesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadlinesAdapter");
            headlinesAdapter = null;
        }
        headlinesAdapter.setOnItemSelectedListener(new LookingGlassView$setupView$2$1$1(this));
        HeadlinesAdapter headlinesAdapter2 = this.mHeadlinesAdapter;
        if (headlinesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadlinesAdapter");
            headlinesAdapter2 = null;
        }
        recyclerView.setAdapter(headlinesAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.products);
        recyclerView2.setHasFixedSize(true);
        GlassProductsAdapter glassProductsAdapter2 = this.mProductsAdapter;
        if (glassProductsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProductsAdapter");
            glassProductsAdapter2 = null;
        }
        glassProductsAdapter2.setOnItemSelectedListener(new LookingGlassView$setupView$3$1$1(this));
        GlassProductsAdapter glassProductsAdapter3 = this.mProductsAdapter;
        if (glassProductsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProductsAdapter");
        } else {
            glassProductsAdapter = glassProductsAdapter3;
        }
        recyclerView2.setAdapter(glassProductsAdapter);
        int i12 = com.talabat.talabatcommon.R.id.viewAllProductsBtn;
        ((TalabatFillButton) _$_findCachedViewById(i12)).setOnClickListener(new a(this));
        if (z11) {
            ((ConstraintLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.layout_main)).setBackgroundColor(HeadlinesAdapterKt.getColor(i11));
            ((AppCompatTextView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.glass_title)).setText(ViewKt.getString(this, com.talabat.localization.R.string.looking_glass_title_new_design));
            ((AppCompatTextView) _$_findCachedViewById(com.talabat.talabatcommon.R.id.glass_subtitle)).setText(ViewKt.getString(this, com.talabat.localization.R.string.looking_glass_subtitle_new_design));
            ((TalabatFillButton) _$_findCachedViewById(i12)).setText(ViewKt.getString(this, com.talabat.localization.R.string.view_more_on_tmart));
            ((RelativeLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.imageView_tmart)).setPadding(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-8  reason: not valid java name */
    public static final void m5764setupView$lambda8(LookingGlassView lookingGlassView, View view) {
        Intrinsics.checkNotNullParameter(lookingGlassView, "this$0");
        LookingGlassListener lookingGlassListener2 = lookingGlassView.lookingGlassListener;
        if (lookingGlassListener2 != null) {
            lookingGlassListener2.onViewAllClicked(((LookingGlassViewModel) lookingGlassView.getViewModel()).getTempRestaurant());
        }
        lookingGlassView.trackLookingGlassClicked();
    }

    public static /* synthetic */ void start$default(LookingGlassView lookingGlassView, String str, boolean z11, boolean z12, LookingGlassOrigin lookingGlassOrigin, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            lookingGlassOrigin = LookingGlassOrigin.ORIGIN_LISTING;
        }
        lookingGlassView.start(str, z11, z12, lookingGlassOrigin);
    }

    private final void trackLookingGlassClicked() {
        Object obj;
        LookingGlassDisplayModel lookingGlassDisplayModel = ((LookingGlassViewModel) getViewModel()).getLookingGlassDisplayModel();
        if (lookingGlassDisplayModel != null) {
            IntegrationAppTracker.Companion companion = IntegrationAppTracker.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GVendorInfo vendorInfo = lookingGlassDisplayModel.getVendorInfo();
            if (vendorInfo != null) {
                obj = vendorInfo.getGRestaurant();
            } else {
                obj = null;
            }
            companion.onLookingGlassClicked(context, String.valueOf(obj));
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

    public void failureHere(@Nullable Failure failure) {
        setVisibility(8);
        LookingGlassListener lookingGlassListener2 = this.lookingGlassListener;
        if (lookingGlassListener2 != null) {
            lookingGlassListener2.onFallback();
        }
    }

    public final int getBUSY() {
        return this.BUSY;
    }

    public final int getCLOSED() {
        return this.CLOSED;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return com.talabat.talabatcommon.R.layout.layout_looking_glass;
    }

    public final int getOPEN() {
        return this.OPEN;
    }

    @NotNull
    public Class<LookingGlassViewModel> getViewModelClass() {
        return LookingGlassViewModel.class;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleKt.observe(lifecycleOwner, ((LookingGlassViewModel) getViewModel()).getAbTestResults(), new LookingGlassView$observatory$1(this));
        LifecycleKt.observe(lifecycleOwner, ((LookingGlassViewModel) getViewModel()).getSendAnalyticEvent(), new LookingGlassView$observatory$2(this));
        ((LookingGlassViewModel) getViewModel()).getDisplayModel().observe(lifecycleOwner, new b(this));
        LifecycleKt.failure(lifecycleOwner, ((LookingGlassViewModel) getViewModel()).getFailureData(), new LookingGlassView$observatory$4(this));
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        ((LookingGlassViewModel) getViewModel()).getABTestResults(WalletSubscriptionMapper.Companion.mapCountryToISOValue(GlobalDataModel.SelectedCountryId));
        observatory(lifecycleOwner);
    }

    public final void setListener(@NotNull LookingGlassListener lookingGlassListener2) {
        Intrinsics.checkNotNullParameter(lookingGlassListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.lookingGlassListener = lookingGlassListener2;
    }

    @JvmOverloads
    public final void start(@NotNull String str, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "tag");
        start$default(this, str, z11, z12, (LookingGlassOrigin) null, 8, (Object) null);
    }

    @JvmOverloads
    public final void start(@NotNull String str, boolean z11, boolean z12, @NotNull LookingGlassOrigin lookingGlassOrigin) {
        int i11;
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(lookingGlassOrigin, "org");
        ((LookingGlassViewModel) getViewModel()).getGlassData(str);
        ((LookingGlassViewModel) getViewModel()).saveOrigin(lookingGlassOrigin.getOrigin());
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(com.talabat.talabatcommon.R.id.viewAllProductsBtn);
        int i12 = 0;
        if (z12) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        talabatFillButton.setVisibility(i11);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(com.talabat.talabatcommon.R.id.logo_container);
        if (!z11) {
            i12 = 8;
        }
        linearLayout.setVisibility(i12);
    }

    @NotNull
    public LookingGlassViewModel viewModelBuilder() {
        LookingGlassViewModelBuilder.Companion companion = LookingGlassViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getMyViewModel(context, getCoroutineScope());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookingGlassView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CLOSED = 1;
        this.BUSY = 2;
        this.eventOrigin = "item_carousel";
    }
}
