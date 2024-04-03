package com.talabat.talabatcommon.views.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.databinding.DialogOldMultipleFeesDescriptionBottomSheetBinding;
import iv.g;
import iv.h;
import iv.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0!H\u0002J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0002J\f\u0010%\u001a\u00020\n*\u00020&H\u0002J\f\u0010'\u001a\u00020\n*\u00020&H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/OldMultipleFeesDescriptionBottomSheetDialog;", "Landroidx/fragment/app/Fragment;", "()V", "feesDescription", "Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "getFeesDescription", "()Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "onReadMoreInfoClickedCallback", "Lcom/talabat/talabatcommon/views/bottomsheet/OnReadMoreInfoClickedCallback;", "dismissCurrentDialog", "", "getFeeDescriptionText", "", "feeDescription", "Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "getHeaderDescription", "", "getHeaderText", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDetailsInBrowser", "overrideParentTopPadding", "setupFeeDescription", "groupView", "descriptionView", "Landroid/widget/TextView;", "getDescriptionText", "Lkotlin/Function0;", "spanBold", "parent", "child", "setupButtons", "Lcom/talabat/talabatcommon/databinding/DialogOldMultipleFeesDescriptionBottomSheetBinding;", "setupHeader", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OldMultipleFeesDescriptionBottomSheetDialog extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final String ARG_DESCRIPTIONS = "ARG_DESCRIPTIONS";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/OldMultipleFeesDescriptionBottomSheetDialog$Companion;", "", "()V", "ARG_DESCRIPTIONS", "", "newInstance", "Lcom/talabat/talabatcommon/views/bottomsheet/OldMultipleFeesDescriptionBottomSheetDialog;", "feesDescriptions", "Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final OldMultipleFeesDescriptionBottomSheetDialog newInstance(@NotNull MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel) {
            Intrinsics.checkNotNullParameter(multipleFeesDescriptionDisplayModel, "feesDescriptions");
            OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog = new OldMultipleFeesDescriptionBottomSheetDialog();
            oldMultipleFeesDescriptionBottomSheetDialog.setArguments(BundleKt.bundleOf(TuplesKt.to(OldMultipleFeesDescriptionBottomSheetDialog.ARG_DESCRIPTIONS, multipleFeesDescriptionDisplayModel)));
            return oldMultipleFeesDescriptionBottomSheetDialog;
        }
    }

    public OldMultipleFeesDescriptionBottomSheetDialog() {
        super(R.layout.dialog_old_multiple_fees_description_bottom_sheet);
    }

    private final void dismissCurrentDialog() {
        Fragment parentFragment = getParentFragment();
        BottomSheetDialogFragment bottomSheetDialogFragment = parentFragment instanceof BottomSheetDialogFragment ? (BottomSheetDialogFragment) parentFragment : null;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final CharSequence getFeeDescriptionText(FeesDescriptionDisplayModel feesDescriptionDisplayModel) {
        if (feesDescriptionDisplayModel == null) {
            return null;
        }
        return spanBold(feesDescriptionDisplayModel.getDescription(), feesDescriptionDisplayModel.getTitle());
    }

    /* access modifiers changed from: private */
    public final MultipleFeesDescriptionDisplayModel getFeesDescription() {
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(ARG_DESCRIPTIONS) : null;
        if (obj != null) {
            return (MultipleFeesDescriptionDisplayModel) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcommon.views.bottomsheet.MultipleFeesDescriptionDisplayModel");
    }

    private final String getHeaderDescription() {
        return getFeesDescription().getHowFeesWork().getDescription();
    }

    private final String getHeaderText() {
        return getFeesDescription().getHowFeesWork().getTitle();
    }

    @JvmStatic
    @NotNull
    public static final OldMultipleFeesDescriptionBottomSheetDialog newInstance(@NotNull MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel) {
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

    private final void setupButtons(DialogOldMultipleFeesDescriptionBottomSheetBinding dialogOldMultipleFeesDescriptionBottomSheetBinding) {
        dialogOldMultipleFeesDescriptionBottomSheetBinding.readMoreButton.setOnClickListener(new g(this));
        dialogOldMultipleFeesDescriptionBottomSheetBinding.gotItButton.setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButtons$lambda-1  reason: not valid java name */
    public static final void m5757setupButtons$lambda1(OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(oldMultipleFeesDescriptionBottomSheetDialog, "this$0");
        OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback2 = oldMultipleFeesDescriptionBottomSheetDialog.onReadMoreInfoClickedCallback;
        if (onReadMoreInfoClickedCallback2 != null) {
            onReadMoreInfoClickedCallback2.onReadMoreInfoClicked();
        }
        oldMultipleFeesDescriptionBottomSheetDialog.openDetailsInBrowser();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupButtons$lambda-2  reason: not valid java name */
    public static final void m5758setupButtons$lambda2(OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(oldMultipleFeesDescriptionBottomSheetDialog, "this$0");
        oldMultipleFeesDescriptionBottomSheetDialog.dismissCurrentDialog();
    }

    private final void setupFeeDescription(View view, TextView textView, Function0<? extends CharSequence> function0) {
        boolean z11;
        CharSequence charSequence = (CharSequence) function0.invoke();
        textView.setText(charSequence);
        int i11 = 0;
        if (charSequence == null || StringsKt__StringsJVMKt.isBlank(charSequence)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    private final void setupHeader(DialogOldMultipleFeesDescriptionBottomSheetBinding dialogOldMultipleFeesDescriptionBottomSheetBinding) {
        dialogOldMultipleFeesDescriptionBottomSheetBinding.headerText.setText(getHeaderText());
        dialogOldMultipleFeesDescriptionBottomSheetBinding.descriptionText.setText(getHeaderDescription());
        dialogOldMultipleFeesDescriptionBottomSheetBinding.closeButton.setOnClickListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupHeader$lambda-0  reason: not valid java name */
    public static final void m5759setupHeader$lambda0(OldMultipleFeesDescriptionBottomSheetDialog oldMultipleFeesDescriptionBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(oldMultipleFeesDescriptionBottomSheetDialog, "this$0");
        oldMultipleFeesDescriptionBottomSheetDialog.dismissCurrentDialog();
    }

    private final CharSequence spanBold(String str, String str2) {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
        if (indexOf$default < 0) {
            return str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf$default, str2.length() + indexOf$default, 17);
        return spannableStringBuilder;
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
        DialogOldMultipleFeesDescriptionBottomSheetBinding bind = DialogOldMultipleFeesDescriptionBottomSheetBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        setupHeader(bind);
        LinearLayout linearLayout = bind.deliveryFeeGroup;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.deliveryFeeGroup");
        TextView textView = bind.deliveryFeeDescription;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.deliveryFeeDescription");
        setupFeeDescription(linearLayout, textView, new OldMultipleFeesDescriptionBottomSheetDialog$onViewCreated$1(this));
        LinearLayout linearLayout2 = bind.serviceFeeGroup;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.serviceFeeGroup");
        TextView textView2 = bind.serviceFeeDescription;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.serviceFeeDescription");
        setupFeeDescription(linearLayout2, textView2, new OldMultipleFeesDescriptionBottomSheetDialog$onViewCreated$2(this));
        setupButtons(bind);
    }
}
