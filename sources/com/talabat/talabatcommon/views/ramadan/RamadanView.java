package com.talabat.talabatcommon.views.ramadan;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModel;
import com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u0017\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010'J\u0017\u0010(\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010'J\u0012\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010,\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0018\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u0002H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u00063"}, d2 = {"Lcom/talabat/talabatcommon/views/ramadan/RamadanView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headerIconIftar", "Landroid/graphics/drawable/Drawable;", "headerIconSuhoor", "minuteUpdateReceiver", "com/talabat/talabatcommon/views/ramadan/RamadanView$minuteUpdateReceiver$1", "Lcom/talabat/talabatcommon/views/ramadan/RamadanView$minuteUpdateReceiver$1;", "attachTimeUpdateBroadcastReceiver", "", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getLayoutId", "getViewModelClass", "Ljava/lang/Class;", "init", "initViews", "shownLocation", "Lcom/talabat/talabatcommon/views/ramadan/viewModel/RamadanViewModel$ShownLocation;", "isVisible", "", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onLifecycleOwnerAttached", "onPause", "onResume", "showClockView", "showClock", "(Ljava/lang/Boolean;)V", "showRamadanView", "showRemainingTimeBeforeFasting", "remainingTime", "Lcom/talabat/talabatcommon/views/ramadan/RemainingTime;", "showRemainingTimeBeforeIftar", "showTimeText", "time", "", "start", "showBody", "viewModelBuilder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RamadanView extends MvvmLinearLayout<RamadanViewModel> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private Drawable headerIconIftar;
    @Nullable
    private Drawable headerIconSuhoor;
    @NotNull
    private final RamadanView$minuteUpdateReceiver$1 minuteUpdateReceiver;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RamadanView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minuteUpdateReceiver = new RamadanView$minuteUpdateReceiver$1(this);
        init(attributeSet);
    }

    private final void attachTimeUpdateBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        getContext().registerReceiver(this.minuteUpdateReceiver, intentFilter);
    }

    /* JADX INFO: finally extract failed */
    private final void init(AttributeSet attributeSet) {
        boolean z11;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShowBodyRamadanHeader);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…le.ShowBodyRamadanHeader)");
        try {
            boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.ShowBodyRamadanHeader_showBody, true);
            int i11 = R.styleable.ShowBodyRamadanHeader_headerBackgroundColor;
            Resources resources = getResources();
            int i12 = R.color.dark_blue_ramadan;
            int color = obtainStyledAttributes.getColor(i11, resources.getColor(i12, getContext().getTheme()));
            int color2 = obtainStyledAttributes.getColor(R.styleable.ShowBodyRamadanHeader_headerTextColor, getResources().getColor(i12, getContext().getTheme()));
            this.headerIconIftar = obtainStyledAttributes.getDrawable(R.styleable.ShowBodyRamadanHeader_headerIconIftar);
            this.headerIconSuhoor = obtainStyledAttributes.getDrawable(R.styleable.ShowBodyRamadanHeader_headerIconSuhoor);
            boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.ShowBodyRamadanHeader_showClockIcon, true);
            int i13 = 0;
            for (RamadanViewModel.ShownLocation shownLocation : RamadanViewModel.ShownLocation.values()) {
                if (shownLocation.ordinal() == obtainStyledAttributes.getInteger(R.styleable.ShowBodyRamadanHeader_shownLocation, RamadanViewModel.ShownLocation.Other.ordinal())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    obtainStyledAttributes.recycle();
                    ((ConstraintLayout) _$_findCachedViewById(R.id.layout_header)).setBackgroundColor(color);
                    ((TextView) _$_findCachedViewById(R.id.textview_remainingTime)).setTextColor(color2);
                    ((TextView) _$_findCachedViewById(R.id.textview_time)).setTextColor(color2);
                    ImageView imageView = (ImageView) _$_findCachedViewById(R.id.imageview_clock);
                    if (!z13) {
                        i13 = 8;
                    }
                    imageView.setVisibility(i13);
                    start(z12, shownLocation);
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private final void initViews(RamadanViewModel.ShownLocation shownLocation) {
        ((RamadanViewModel) getViewModel()).showRamadanView(WalletSubscriptionMapper.Companion.mapCountryToISOValue(GlobalDataModel.SelectedCountryId), shownLocation);
        ((RamadanViewModel) getViewModel()).showClock();
    }

    /* access modifiers changed from: private */
    public final void showClockView(Boolean bool) {
        int i11;
        if (bool != null) {
            bool.booleanValue();
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.layout_header);
            if (bool.booleanValue()) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            constraintLayout.setVisibility(i11);
        }
    }

    /* access modifiers changed from: private */
    public final void showRamadanView(Boolean bool) {
        int i11;
        if (bool != null) {
            bool.booleanValue();
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.layout_ramadan);
            if (bool.booleanValue()) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            constraintLayout.setVisibility(i11);
        }
    }

    /* access modifiers changed from: private */
    public final void showRemainingTimeBeforeFasting(RemainingTime remainingTime) {
        int i11;
        if (remainingTime != null) {
            int i12 = R.id.headerIcon;
            ImageView imageView = (ImageView) _$_findCachedViewById(i12);
            if (this.headerIconSuhoor != null) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            imageView.setVisibility(i11);
            ((ImageView) _$_findCachedViewById(i12)).setImageDrawable(this.headerIconSuhoor);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(com.talabat.localization.R.string.time_before_fasting);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ring.time_before_fasting)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(remainingTime.getHours()), Long.valueOf(remainingTime.getMinutes())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) _$_findCachedViewById(R.id.textview_remainingTime)).setText(format);
        }
    }

    /* access modifiers changed from: private */
    public final void showRemainingTimeBeforeIftar(RemainingTime remainingTime) {
        int i11;
        if (remainingTime != null) {
            int i12 = R.id.headerIcon;
            ImageView imageView = (ImageView) _$_findCachedViewById(i12);
            if (this.headerIconIftar != null) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            imageView.setVisibility(i11);
            ((ImageView) _$_findCachedViewById(i12)).setImageDrawable(this.headerIconIftar);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(com.talabat.localization.R.string.time_before_Iftar);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…string.time_before_Iftar)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(remainingTime.getHours()), Long.valueOf(remainingTime.getMinutes())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) _$_findCachedViewById(R.id.textview_remainingTime)).setText(format);
        }
    }

    /* access modifiers changed from: private */
    public final void showTimeText(String str) {
        if (str != null) {
            ((TextView) _$_findCachedViewById(R.id.textview_time)).setText(str);
        }
    }

    private final void start(boolean z11, RamadanViewModel.ShownLocation shownLocation) {
        RelativeLayout relativeLayout;
        int i11;
        if (z11) {
            relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.layout_body);
            i11 = 0;
        } else {
            relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.layout_body);
            i11 = 8;
        }
        relativeLayout.setVisibility(i11);
        initViews(shownLocation);
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
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return R.layout.layout_looking_glass_ramadan;
    }

    @NotNull
    public Class<RamadanViewModel> getViewModelClass() {
        return RamadanViewModel.class;
    }

    public final boolean isVisible() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.layout_ramadan);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "layout_ramadan");
        return ViewKt.isVisible(constraintLayout);
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleKt.observe(lifecycleOwner, ((RamadanViewModel) getViewModel()).getPrayerTimeText(), new RamadanView$observatory$1(this));
        LifecycleKt.observe(lifecycleOwner, ((RamadanViewModel) getViewModel()).getShowClockView(), new RamadanView$observatory$2(this));
        LifecycleKt.observe(lifecycleOwner, ((RamadanViewModel) getViewModel()).getShowRamadanView(), new RamadanView$observatory$3(this));
        LifecycleKt.observe(lifecycleOwner, ((RamadanViewModel) getViewModel()).getRemainingTimeTextBeforeFasting(), new RamadanView$observatory$4(this));
        LifecycleKt.observe(lifecycleOwner, ((RamadanViewModel) getViewModel()).getRemainingTimeTextBeforeIftar(), new RamadanView$observatory$5(this));
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
    }

    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(this.minuteUpdateReceiver);
    }

    public void onResume() {
        super.onResume();
        attachTimeUpdateBroadcastReceiver();
    }

    @NotNull
    public RamadanViewModel viewModelBuilder() {
        return RamadanViewModelBuilder.INSTANCE.getMyViewModel();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RamadanView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minuteUpdateReceiver = new RamadanView$minuteUpdateReceiver$1(this);
        init(attributeSet);
    }
}
