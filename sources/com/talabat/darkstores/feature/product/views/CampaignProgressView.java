package com.talabat.darkstores.feature.product.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.models.CampaignAddedQuantity;
import com.talabat.darkstores.feature.product.models.CampaignFreeQuantity;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.darkstores.feature.product.views.CampaignProgressState;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lj.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0(J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002J!\u0010,\u001a\u00020&2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!j\u0002`$ø\u0001\u0000J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u000fR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001b\u001a\n \u0010*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eRA\u0010 \u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020# \u0010*\u0016\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!j\u0004\u0018\u0001`$0!j\u0002`$0\u000eX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressView;", "Landroid/widget/LinearLayout;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canAddFreeItemLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "configurationSubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "kotlin.jvm.PlatformType", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "label", "Landroidx/appcompat/widget/AppCompatTextView;", "getLabel", "()Landroidx/appcompat/widget/AppCompatTextView;", "label$delegate", "Lkotlin/Lazy;", "progress", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgress", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "progress$delegate", "quantitySubject", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "animateProgress", "", "endValue", "Landroidx/lifecycle/LiveData;", "handleState", "state", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "onQuantityChanged", "campaignProgressData", "setup", "campaign", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressView extends LinearLayout implements AutoDisposable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long PROGRESS_ANIMATION_DURATION = 150;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final MutableLiveData<Boolean> canAddFreeItemLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<ProductCampaign.Free> configurationSubject;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final Lazy label$delegate;
    @NotNull
    private final Lazy progress$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> quantitySubject;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressView$Companion;", "", "()V", "PROGRESS_ANIMATION_DURATION", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CampaignProgressView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CampaignProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CampaignProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.disposables = new CompositeDisposable();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.progress$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CampaignProgressView$progress$2(this));
        this.label$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new CampaignProgressView$label$2(this));
        PublishSubject<ProductCampaign.Free> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<ProductCampaign.Free>()");
        this.configurationSubject = create;
        PublishSubject<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<CampaignProgressData>()");
        this.quantitySubject = create2;
        this.canAddFreeItemLiveData = new MutableLiveData<>();
        ViewKt.withLayout(this, R.layout.darkstores_campaign_progress_view, new CampaignProgressView$special$$inlined$bind$1(this, this));
    }

    private final void animateProgress(int i11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getProgress().getProgress(), i11});
        ofInt.setDuration(150);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new f(this));
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateProgress$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10052animateProgress$lambda4$lambda3(CampaignProgressView campaignProgressView, ValueAnimator valueAnimator) {
        Integer num;
        Intrinsics.checkNotNullParameter(campaignProgressView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            num = (Integer) animatedValue;
        } else {
            num = null;
        }
        if (num != null) {
            LinearProgressIndicator progress = campaignProgressView.getProgress();
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            progress.setProgress(num.intValue());
        }
    }

    private final AppCompatTextView getLabel() {
        return (AppCompatTextView) this.label$delegate.getValue();
    }

    private final LinearProgressIndicator getProgress() {
        return (LinearProgressIndicator) this.progress$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleState(CampaignProgressState campaignProgressState) {
        int i11;
        if (!Intrinsics.areEqual((Object) campaignProgressState, (Object) CampaignProgressState.Hidden.INSTANCE)) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        animateProgress(campaignProgressState.progressValue());
        AppCompatTextView label = getLabel();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        label.setText(campaignProgressState.label(resources));
        this.canAddFreeItemLiveData.postValue(Boolean.valueOf(campaignProgressState instanceof CampaignProgressState.CanAddProduct));
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

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        AutoDisposable.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public final LiveData<Boolean> canAddFreeItemLiveData() {
        LiveData<Boolean> distinctUntilChanged = Transformations.distinctUntilChanged(this.canAddFreeItemLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public void onCleared() {
        AutoDisposable.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        AutoDisposable.DefaultImpls.onClearedImplementation(this);
    }

    public final void onQuantityChanged(@NotNull Pair<CampaignAddedQuantity, CampaignFreeQuantity> pair) {
        Intrinsics.checkNotNullParameter(pair, "campaignProgressData");
        this.quantitySubject.onNext(pair);
    }

    public final void setup(@NotNull ProductCampaign.Free free) {
        boolean z11;
        int i11;
        Unit unit;
        Intrinsics.checkNotNullParameter(free, "campaign");
        LinearProgressIndicator progress = getProgress();
        Intrinsics.checkNotNullExpressionValue(progress, "progress");
        if (free.requiredItems() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progress.setVisibility(i11);
        Integer usageLimit = free.getUsageLimit();
        if (usageLimit != null) {
            int intValue = usageLimit.intValue();
            ((TextView) _$_findCachedViewById(R.id.campaign_limit)).setText(getResources().getQuantityString(com.talabat.localization.R.plurals.free_item_campaign_limit, intValue, new Object[]{Integer.valueOf(intValue)}));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((TextView) _$_findCachedViewById(R.id.campaign_limit)).setVisibility(8);
        }
        this.configurationSubject.onNext(free);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CampaignProgressView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
