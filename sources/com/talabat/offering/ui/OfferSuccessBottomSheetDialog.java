package com.talabat.offering.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import com.talabat.offering.R;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vs.r;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/talabat/offering/ui/OfferSuccessBottomSheetDialog;", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "function", "Lkotlin/Function0;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function0;)V", "subscriptionBottomSheet", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "getSubscriptionBottomSheet", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "subscriptionBottomSheet$delegate", "Lkotlin/Lazy;", "getView", "view", "Landroid/view/View;", "show", "Companion", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferSuccessBottomSheetDialog implements DSBottomSheet.FragmentListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "OfferSuccessBottomSheet";
    @NotNull
    private final AppCompatActivity activity;
    @NotNull
    private final Function0<Unit> function;
    @NotNull
    private final Lazy subscriptionBottomSheet$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new OfferSuccessBottomSheetDialog$subscriptionBottomSheet$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/offering/ui/OfferSuccessBottomSheetDialog$Companion;", "", "()V", "TAG", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OfferSuccessBottomSheetDialog(@NotNull AppCompatActivity appCompatActivity, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "function");
        this.activity = appCompatActivity;
        this.function = function0;
    }

    private final DSBottomSheet getSubscriptionBottomSheet() {
        return (DSBottomSheet) this.subscriptionBottomSheet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10700getView$lambda1$lambda0(OfferSuccessBottomSheetDialog offerSuccessBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(offerSuccessBottomSheetDialog, "this$0");
        offerSuccessBottomSheetDialog.function.invoke();
        offerSuccessBottomSheetDialog.getSubscriptionBottomSheet().dismiss();
    }

    public void getView(@Nullable View view) {
        if (view != null) {
            ((TextView) view.findViewById(R.id.tvShowRestaurants)).setOnClickListener(new r(this));
        }
    }

    public final void show() {
        getSubscriptionBottomSheet().show(this.activity.getSupportFragmentManager(), TAG);
    }
}
