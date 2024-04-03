package com.talabat.talabatcommon.views.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.databinding.DialogMultipleFeesDescriptionBottomSheetBinding;
import iv.d;
import iv.e;
import iv.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\f\u0010\u0015\u001a\u00020\n*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\n*\u00020\u0016H\u0002J\f\u0010\u0018\u001a\u00020\n*\u00020\u0016H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionBottomSheetDialog;", "Landroidx/fragment/app/Fragment;", "()V", "feesDescription", "Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "getFeesDescription", "()Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "onReadMoreInfoClickedCallback", "Lcom/talabat/talabatcommon/views/bottomsheet/OnReadMoreInfoClickedCallback;", "dismissCurrentDialog", "", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDetailsInBrowser", "overrideParentTopPadding", "setupButtons", "Lcom/talabat/talabatcommon/databinding/DialogMultipleFeesDescriptionBottomSheetBinding;", "setupDescriptions", "setupHeader", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultipleFeesDescriptionBottomSheetDialog extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final String ARG_DESCRIPTIONS = "ARG_DESCRIPTIONS";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionBottomSheetDialog$Companion;", "", "()V", "ARG_DESCRIPTIONS", "", "newInstance", "Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionBottomSheetDialog;", "feesDescriptions", "Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MultipleFeesDescriptionBottomSheetDialog newInstance(@NotNull MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel) {
            Intrinsics.checkNotNullParameter(multipleFeesDescriptionDisplayModel, "feesDescriptions");
            MultipleFeesDescriptionBottomSheetDialog multipleFeesDescriptionBottomSheetDialog = new MultipleFeesDescriptionBottomSheetDialog();
            multipleFeesDescriptionBottomSheetDialog.setArguments(BundleKt.bundleOf(TuplesKt.to(MultipleFeesDescriptionBottomSheetDialog.ARG_DESCRIPTIONS, multipleFeesDescriptionDisplayModel)));
            return multipleFeesDescriptionBottomSheetDialog;
        }
    }

    public MultipleFeesDescriptionBottomSheetDialog() {
        super(R.layout.dialog_multiple_fees_description_bottom_sheet);
    }

    private final void dismissCurrentDialog() {
        Fragment parentFragment = getParentFragment();
        BottomSheetDialogFragment bottomSheetDialogFragment = parentFragment instanceof BottomSheetDialogFragment ? (BottomSheetDialogFragment) parentFragment : null;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
    }

    private final MultipleFeesDescriptionDisplayModel getFeesDescription() {
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(ARG_DESCRIPTIONS) : null;
        if (obj != null) {
            return (MultipleFeesDescriptionDisplayModel) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcommon.views.bottomsheet.MultipleFeesDescriptionDisplayModel");
    }

    @JvmStatic
    @NotNull
    public static final MultipleFeesDescriptionBottomSheetDialog newInstance(@NotNull MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel) {
        return Companion.newInstance(multipleFeesDescriptionDisplayModel);
    }

    private final void openDetailsInBrowser() {
        boolean z11;
        String url = getFeesDescription().getHowFeesWork().getUrl();
        if (url == null || StringsKt__StringsJVMKt.isBlank(url)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            requireContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    private final void overrideParentTopPadding() {
        Sequence<View> children;
        View view;
        Fragment parentFragment = getParentFragment();
        ViewGroup viewGroup = null;
        KeyEvent.Callback view2 = parentFragment != null ? parentFragment.getView() : null;
        if (view2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) view2;
        }
        if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null && (view = (View) SequencesKt___SequencesKt.firstOrNull(children)) != null) {
            view.setPadding(0, 0, 0, 0);
        }
    }

    private final void setupButtons(DialogMultipleFeesDescriptionBottomSheetBinding dialogMultipleFeesDescriptionBottomSheetBinding) {
        dialogMultipleFeesDescriptionBottomSheetBinding.readMoreButton.setOnClickListener(new e(this));
        dialogMultipleFeesDescriptionBottomSheetBinding.gotItButton.setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButtons$lambda-7  reason: not valid java name */
    public static final void m5754setupButtons$lambda7(MultipleFeesDescriptionBottomSheetDialog multipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(multipleFeesDescriptionBottomSheetDialog, "this$0");
        OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback2 = multipleFeesDescriptionBottomSheetDialog.onReadMoreInfoClickedCallback;
        if (onReadMoreInfoClickedCallback2 != null) {
            onReadMoreInfoClickedCallback2.onReadMoreInfoClicked();
        }
        multipleFeesDescriptionBottomSheetDialog.openDetailsInBrowser();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButtons$lambda-8  reason: not valid java name */
    public static final void m5755setupButtons$lambda8(MultipleFeesDescriptionBottomSheetDialog multipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(multipleFeesDescriptionBottomSheetDialog, "this$0");
        multipleFeesDescriptionBottomSheetDialog.dismissCurrentDialog();
    }

    private final void setupDescriptions(DialogMultipleFeesDescriptionBottomSheetBinding dialogMultipleFeesDescriptionBottomSheetBinding) {
        Unit unit;
        Unit unit2;
        FeesDescriptionDisplayModel smallOrderFee = getFeesDescription().getSmallOrderFee();
        Unit unit3 = null;
        if (smallOrderFee != null) {
            RelativeLayout relativeLayout = dialogMultipleFeesDescriptionBottomSheetBinding.smallOrderFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "smallOrderFeeGroup");
            relativeLayout.setVisibility(0);
            dialogMultipleFeesDescriptionBottomSheetBinding.smallOrderFeeTitle.setText(smallOrderFee.getTitle());
            dialogMultipleFeesDescriptionBottomSheetBinding.smallOrderFeeSubtitle.setText(smallOrderFee.getDescription());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            RelativeLayout relativeLayout2 = dialogMultipleFeesDescriptionBottomSheetBinding.smallOrderFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "smallOrderFeeGroup");
            relativeLayout2.setVisibility(8);
        }
        FeesDescriptionDisplayModel deliveryFee = getFeesDescription().getDeliveryFee();
        if (deliveryFee != null) {
            RelativeLayout relativeLayout3 = dialogMultipleFeesDescriptionBottomSheetBinding.deliveryFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout3, "deliveryFeeGroup");
            relativeLayout3.setVisibility(0);
            dialogMultipleFeesDescriptionBottomSheetBinding.deliveryFeeTitle.setText(deliveryFee.getTitle());
            dialogMultipleFeesDescriptionBottomSheetBinding.deliveryFeeSubtitle.setText(deliveryFee.getDescription());
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            RelativeLayout relativeLayout4 = dialogMultipleFeesDescriptionBottomSheetBinding.deliveryFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "deliveryFeeGroup");
            relativeLayout4.setVisibility(8);
        }
        FeesDescriptionDisplayModel serviceFee = getFeesDescription().getServiceFee();
        if (serviceFee != null) {
            RelativeLayout relativeLayout5 = dialogMultipleFeesDescriptionBottomSheetBinding.serviceFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout5, "serviceFeeGroup");
            relativeLayout5.setVisibility(0);
            dialogMultipleFeesDescriptionBottomSheetBinding.serviceFeeTitle.setText(serviceFee.getTitle());
            dialogMultipleFeesDescriptionBottomSheetBinding.serviceFeeSubtitle.setText(serviceFee.getDescription());
            unit3 = Unit.INSTANCE;
        }
        if (unit3 == null) {
            RelativeLayout relativeLayout6 = dialogMultipleFeesDescriptionBottomSheetBinding.serviceFeeGroup;
            Intrinsics.checkNotNullExpressionValue(relativeLayout6, "serviceFeeGroup");
            relativeLayout6.setVisibility(8);
        }
    }

    private final void setupHeader(DialogMultipleFeesDescriptionBottomSheetBinding dialogMultipleFeesDescriptionBottomSheetBinding) {
        dialogMultipleFeesDescriptionBottomSheetBinding.headerText.setText(getFeesDescription().getHowFeesWork().getTitle());
        dialogMultipleFeesDescriptionBottomSheetBinding.closeButton.setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupHeader$lambda-0  reason: not valid java name */
    public static final void m5756setupHeader$lambda0(MultipleFeesDescriptionBottomSheetDialog multipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(multipleFeesDescriptionBottomSheetDialog, "this$0");
        multipleFeesDescriptionBottomSheetDialog.dismissCurrentDialog();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onAttach(@NotNull Context context) {
        OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof OnReadMoreInfoClickedCallback) {
            onReadMoreInfoClickedCallback2 = (OnReadMoreInfoClickedCallback) context;
        } else {
            onReadMoreInfoClickedCallback2 = null;
        }
        this.onReadMoreInfoClickedCallback = onReadMoreInfoClickedCallback2;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        overrideParentTopPadding();
        DialogMultipleFeesDescriptionBottomSheetBinding bind = DialogMultipleFeesDescriptionBottomSheetBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        setupHeader(bind);
        setupDescriptions(bind);
        setupButtons(bind);
    }
}
