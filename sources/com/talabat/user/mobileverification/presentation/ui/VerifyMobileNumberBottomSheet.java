package com.talabat.user.mobileverification.presentation.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_bottom_sheet.DSBottomSheet;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ww.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/user/mobileverification/presentation/ui/VerifyMobileNumberBottomSheet;", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "()V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "getBottomSheet", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "bottomSheet$delegate", "Lkotlin/Lazy;", "getView", "", "view", "Landroid/view/View;", "show", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "Companion", "com_talabat_feature_mobile-verification_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyMobileNumberBottomSheet implements DSBottomSheet.FragmentListener {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String TAG = "VerifyMobileNumberBottomSheet";
    @NotNull
    private final Lazy bottomSheet$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VerifyMobileNumberBottomSheet$bottomSheet$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/user/mobileverification/presentation/ui/VerifyMobileNumberBottomSheet$Companion;", "", "()V", "TAG", "", "com_talabat_feature_mobile-verification_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final DSBottomSheet getBottomSheet() {
        return (DSBottomSheet) this.bottomSheet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-0  reason: not valid java name */
    public static final void m5879show$lambda0(VerifyMobileNumberBottomSheet verifyMobileNumberBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(verifyMobileNumberBottomSheet, "this$0");
        verifyMobileNumberBottomSheet.getBottomSheet().dismiss();
    }

    public void getView(@Nullable View view) {
    }

    public final void show(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        getBottomSheet().setHeaderStartIconOnClickListener(new a(this));
        getBottomSheet().show(appCompatActivity.getSupportFragmentManager(), TAG);
    }
}
