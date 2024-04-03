package com.talabat.feature.tpro.presentation.payment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproOtpPointResponseBinding;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/TProOTPPaymentBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "getDsBottomSheet", "()Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscriptionOTPPaymentStatus", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "getSubscriptionOTPPaymentStatus", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproOtpPointResponseBinding;", "onClick", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "removePadding", "setupViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOTPPaymentBottomSheetFragment extends Fragment implements View.OnClickListener, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SUBSCRIPTION_OTP_PAYMENT_STATUS = "SUBSCRIPTION_OTP_PAYMENT_STATUS";
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    private FragmentTproOtpPointResponseBinding viewBinding;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/TProOTPPaymentBottomSheetFragment$Companion;", "", "()V", "SUBSCRIPTION_OTP_PAYMENT_STATUS", "", "create", "Lcom/talabat/feature/tpro/presentation/payment/TProOTPPaymentBottomSheetFragment;", "subscriptionOTPPaymentStatus", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TProOTPPaymentBottomSheetFragment create(@Nullable SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus, @NotNull DSBottomSheet dSBottomSheet) {
            Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
            TProOTPPaymentBottomSheetFragment tProOTPPaymentBottomSheetFragment = new TProOTPPaymentBottomSheetFragment(dSBottomSheet);
            Bundle bundle = new Bundle();
            bundle.putParcelable(TProOTPPaymentBottomSheetFragment.SUBSCRIPTION_OTP_PAYMENT_STATUS, subscriptionOTPPaymentStatus);
            tProOTPPaymentBottomSheetFragment.setArguments(bundle);
            return tProOTPPaymentBottomSheetFragment;
        }
    }

    public TProOTPPaymentBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        this.dsBottomSheet = dSBottomSheet;
    }

    private final SubscriptionOTPPaymentStatus getSubscriptionOTPPaymentStatus() {
        Parcelable parcelable;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            parcelable = arguments.getParcelable(SUBSCRIPTION_OTP_PAYMENT_STATUS);
        } else {
            parcelable = (Parcelable) arguments.getParcelable(SUBSCRIPTION_OTP_PAYMENT_STATUS, SubscriptionOTPPaymentStatus.class);
        }
        return (SubscriptionOTPPaymentStatus) parcelable;
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setupViews(SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus) {
        boolean z11;
        Drawable drawable;
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding = this.viewBinding;
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding2 = null;
        if (fragmentTproOtpPointResponseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproOtpPointResponseBinding = null;
        }
        fragmentTproOtpPointResponseBinding.tvBannerHeader.setText(subscriptionOTPPaymentStatus.getTitle());
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding3 = this.viewBinding;
        if (fragmentTproOtpPointResponseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproOtpPointResponseBinding3 = null;
        }
        fragmentTproOtpPointResponseBinding3.tvUpgradeSuccessDescription.setText(subscriptionOTPPaymentStatus.getDescription());
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding4 = this.viewBinding;
        if (fragmentTproOtpPointResponseBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproOtpPointResponseBinding4 = null;
        }
        fragmentTproOtpPointResponseBinding4.actionButtonDismiss.setText(subscriptionOTPPaymentStatus.getButtonTitle());
        if (subscriptionOTPPaymentStatus.getImageUrl().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            removePadding();
            FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding5 = this.viewBinding;
            if (fragmentTproOtpPointResponseBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproOtpPointResponseBinding5 = null;
            }
            ImageView imageView = fragmentTproOtpPointResponseBinding5.cancelButton;
            Context context = getContext();
            if (context != null) {
                drawable = context.getDrawable(com.talabat.feature.tpro.presentation.R.drawable.ic_tpro_close_marshmellow);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding6 = this.viewBinding;
            if (fragmentTproOtpPointResponseBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproOtpPointResponseBinding6 = null;
            }
            fragmentTproOtpPointResponseBinding6.ivBannerImage.setVisibility(0);
            FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding7 = this.viewBinding;
            if (fragmentTproOtpPointResponseBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproOtpPointResponseBinding7 = null;
            }
            ImageView imageView2 = fragmentTproOtpPointResponseBinding7.ivBannerImage;
            Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.ivBannerImage");
            ImageViewExtensionsKt.loadImage$default(imageView2, subscriptionOTPPaymentStatus.getImageUrl(), (Function1) null, 2, (Object) null);
        }
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding8 = this.viewBinding;
        if (fragmentTproOtpPointResponseBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproOtpPointResponseBinding8 = null;
        }
        fragmentTproOtpPointResponseBinding8.cancelButton.setOnClickListener(this);
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding9 = this.viewBinding;
        if (fragmentTproOtpPointResponseBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproOtpPointResponseBinding2 = fragmentTproOtpPointResponseBinding9;
        }
        fragmentTproOtpPointResponseBinding2.actionButtonView.setOnClickListener(this);
    }

    @NotNull
    public final DSBottomSheet getDsBottomSheet() {
        return this.dsBottomSheet;
    }

    public void onClick(@Nullable View view) {
        this.dsBottomSheet.dismiss();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproOtpPointResponseBinding fragmentTproOtpPointResponseBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProOTPPaymentBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProOTPPaymentBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproOtpPointResponseBinding inflate = FragmentTproOtpPointResponseBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproOtpPointResponseBinding = inflate;
        }
        ConstraintLayout root = fragmentTproOtpPointResponseBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus = getSubscriptionOTPPaymentStatus();
        if (subscriptionOTPPaymentStatus != null) {
            setupViews(subscriptionOTPPaymentStatus);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.dsBottomSheet.dismiss();
        }
    }
}
