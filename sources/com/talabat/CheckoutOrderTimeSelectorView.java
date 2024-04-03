package com.talabat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import buisnessmodels.TalabatFormatter;
import com.designsystem.ds_radio_button.DSRadioButton;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.verticals.helper.ExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import ue.d5;
import ue.e5;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001(B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0018J\u0015\u0010\"\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/CheckoutOrderTimeSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/talabat/CheckoutOrderTimeSelectorView$Mode;", "mode", "getMode", "()Lcom/talabat/CheckoutOrderTimeSelectorView$Mode;", "onOrderNowClickListener", "Landroid/view/View$OnClickListener;", "getOnOrderNowClickListener", "()Landroid/view/View$OnClickListener;", "setOnOrderNowClickListener", "(Landroid/view/View$OnClickListener;)V", "onScheduleLaterClickListener", "getOnScheduleLaterClickListener", "setOnScheduleLaterClickListener", "scheduledDeliveryDiscount", "", "getSubtitle", "deliverSlot", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/model/DeliverySlotContent;", "hideOrderNowOption", "", "onOrderNowClicked", "onScheduleLaterClicked", "setOrderNowTitle", "title", "updateScheduledDeliveryDiscount", "", "(Ljava/lang/Float;)V", "updateScheduledDeliveryDiscountInfo", "updateScheduledDeliveryDiscountIntro", "updateSelectedDeliverySlot", "Mode", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutOrderTimeSelectorView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private Mode mode;
    @Nullable
    private View.OnClickListener onOrderNowClickListener;
    @Nullable
    private View.OnClickListener onScheduleLaterClickListener;
    @Nullable
    private String scheduledDeliveryDiscount;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/CheckoutOrderTimeSelectorView$Mode;", "", "(Ljava/lang/String;I)V", "ORDER_NOW", "SCHEDULE_LATER", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Mode {
        ORDER_NOW,
        SCHEDULE_LATER
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            iArr[Mode.ORDER_NOW.ordinal()] = 1;
            iArr[Mode.SCHEDULE_LATER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutOrderTimeSelectorView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutOrderTimeSelectorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutOrderTimeSelectorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mode = Mode.ORDER_NOW;
        View.inflate(context, R.layout.checkout_order_time_selector_view, this);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds_xxs);
        setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
        ((RelativeLayout) _$_findCachedViewById(R.id.clOrderNow)).setOnClickListener(new d5(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.clScheduleLater)).setOnClickListener(new e5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9408_init_$lambda0(CheckoutOrderTimeSelectorView checkoutOrderTimeSelectorView, View view) {
        Intrinsics.checkNotNullParameter(checkoutOrderTimeSelectorView, "this$0");
        checkoutOrderTimeSelectorView.onOrderNowClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m9409_init_$lambda1(CheckoutOrderTimeSelectorView checkoutOrderTimeSelectorView, View view) {
        Intrinsics.checkNotNullParameter(checkoutOrderTimeSelectorView, "this$0");
        checkoutOrderTimeSelectorView.onScheduleLaterClicked();
    }

    private final String getSubtitle(DeliverySlotContent deliverySlotContent) {
        String string = ExtensionsKt.getString(this, R.string.today);
        int date = deliverySlotContent.getDate();
        String str = getContext().getResources().getStringArray(R.array.months)[deliverySlotContent.getMonthOfYear()];
        return string + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + date + " " + str;
    }

    private final void onOrderNowClicked() {
        ((DSRadioButton) _$_findCachedViewById(R.id.rbOrderNow)).setRadioButtonChecked(true);
        ((DSRadioButton) _$_findCachedViewById(R.id.rbScheduleLater)).setRadioButtonChecked(false);
        this.mode = Mode.ORDER_NOW;
        updateScheduledDeliveryDiscountInfo();
        View.OnClickListener onClickListener = this.onOrderNowClickListener;
        if (onClickListener != null) {
            onClickListener.onClick((RelativeLayout) _$_findCachedViewById(R.id.clOrderNow));
        }
    }

    private final void onScheduleLaterClicked() {
        View.OnClickListener onClickListener = this.onScheduleLaterClickListener;
        if (onClickListener != null) {
            onClickListener.onClick((RelativeLayout) _$_findCachedViewById(R.id.clScheduleLater));
        }
    }

    private final void updateScheduledDeliveryDiscountInfo() {
        Unit unit;
        int i11;
        String str = this.scheduledDeliveryDiscount;
        if (str != null) {
            int i12 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
            if (i12 == 1) {
                i11 = R.string.scheduled_delivery_discount_info;
            } else if (i12 == 2) {
                i11 = R.string.scheduled_delivery_selected_discount_info;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            int i13 = R.id.tvScheduledDeliveryDiscountInfo;
            ((AppCompatTextView) _$_findCachedViewById(i13)).setText(getResources().getString(i11, new Object[]{str}));
            ((AppCompatTextView) _$_findCachedViewById(i13)).setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduledDeliveryDiscountInfo)).setVisibility(8);
        }
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduledDeliveryDiscountIntro)).setVisibility(8);
    }

    private final void updateScheduledDeliveryDiscountIntro() {
        Unit unit;
        String str = this.scheduledDeliveryDiscount;
        if (str != null) {
            int i11 = R.id.tvScheduledDeliveryDiscountIntro;
            ((AppCompatTextView) _$_findCachedViewById(i11)).setText(getResources().getString(R.string.scheduled_delivery_discount_intro, new Object[]{str}));
            ((AppCompatTextView) _$_findCachedViewById(i11)).setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduledDeliveryDiscountIntro)).setVisibility(8);
        }
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduledDeliveryDiscountInfo)).setVisibility(8);
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

    @NotNull
    public final Mode getMode() {
        return this.mode;
    }

    @Nullable
    public final View.OnClickListener getOnOrderNowClickListener() {
        return this.onOrderNowClickListener;
    }

    @Nullable
    public final View.OnClickListener getOnScheduleLaterClickListener() {
        return this.onScheduleLaterClickListener;
    }

    public final void hideOrderNowOption() {
        ((RelativeLayout) _$_findCachedViewById(R.id.clOrderNow)).setVisibility(8);
    }

    public final void setOnOrderNowClickListener(@Nullable View.OnClickListener onClickListener) {
        this.onOrderNowClickListener = onClickListener;
    }

    public final void setOnScheduleLaterClickListener(@Nullable View.OnClickListener onClickListener) {
        this.onScheduleLaterClickListener = onClickListener;
    }

    public final void setOrderNowTitle(@Nullable String str) {
        boolean z11;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ((AppCompatTextView) _$_findCachedViewById(R.id.tvOrderNow)).setText(str);
        }
    }

    public final void updateScheduledDeliveryDiscount(@Nullable Float f11) {
        String str;
        if (f11 != null) {
            str = TalabatFormatter.getInstance().getFormattedCurrency(f11.floatValue());
        } else {
            str = null;
        }
        this.scheduledDeliveryDiscount = str;
        if (f11 != null) {
            f11.floatValue();
            ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduleLater)).setText(ExtensionsKt.getString(this, R.string.schedule_and_save));
        }
        updateScheduledDeliveryDiscountIntro();
    }

    public final void updateSelectedDeliverySlot(@NotNull DeliverySlotContent deliverySlotContent) {
        Intrinsics.checkNotNullParameter(deliverySlotContent, "deliverSlot");
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvScheduleLater)).setText(deliverySlotContent.getLocalisedDisplayTime(ExtensionsKt.getString(this, R.string.f54876am), ExtensionsKt.getString(this, R.string.f54884pm)));
        int i11 = R.id.tvScheduleLaterSubtitle;
        ((AppCompatTextView) _$_findCachedViewById(i11)).setText(getSubtitle(deliverySlotContent));
        ((AppCompatTextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((AppCompatTextView) _$_findCachedViewById(R.id.tvNew)).setVisibility(8);
        ((DSRadioButton) _$_findCachedViewById(R.id.rbOrderNow)).setRadioButtonChecked(false);
        ((DSRadioButton) _$_findCachedViewById(R.id.rbScheduleLater)).setRadioButtonChecked(true);
        this.mode = Mode.SCHEDULE_LATER;
        updateScheduledDeliveryDiscountInfo();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckoutOrderTimeSelectorView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
