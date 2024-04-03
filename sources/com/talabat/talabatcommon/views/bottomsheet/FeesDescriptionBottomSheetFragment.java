package com.talabat.talabatcommon.views.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.databinding.DialogFeesDescriptionBottomSheetBinding;
import iv.a;
import iv.b;
import iv.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/talabatcommon/databinding/DialogFeesDescriptionBottomSheetBinding;", "displayData", "Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "dismissCurrentDialog", "", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openUrlInBrowser", "overrideParentTopPadding", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesDescriptionBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final String BUNDLE_KEY = "data";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FeesDescriptionBottomSheetFragment";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private DialogFeesDescriptionBottomSheetBinding binding;
    private FeesDescriptionDisplayModel displayData;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionBottomSheetFragment$Companion;", "", "()V", "BUNDLE_KEY", "", "TAG", "newInstance", "Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionBottomSheetFragment;", "imageId", "", "title", "description", "url", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final FeesDescriptionBottomSheetFragment newInstance(@DrawableRes int i11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(str3, "url");
            FeesDescriptionBottomSheetFragment feesDescriptionBottomSheetFragment = new FeesDescriptionBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", new FeesDescriptionDisplayModel(Integer.valueOf(i11), str, str2, str3));
            feesDescriptionBottomSheetFragment.setArguments(bundle);
            return feesDescriptionBottomSheetFragment;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dismissCurrentDialog() {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x0013
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = "FeesDescriptionBottomSheetFragment"
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x001c
            androidx.fragment.app.DialogFragment r0 = (androidx.fragment.app.DialogFragment) r0
            r0.dismiss()
            return
        L_0x001c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.DialogFragment"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.bottomsheet.FeesDescriptionBottomSheetFragment.dismissCurrentDialog():void");
    }

    private final void initViews() {
        Resources.Theme theme;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel = this.displayData;
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding = null;
        if (feesDescriptionDisplayModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayData");
            feesDescriptionDisplayModel = null;
        }
        Integer imageId = feesDescriptionDisplayModel.getImageId();
        if (imageId != null) {
            DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding2 = this.binding;
            if (dialogFeesDescriptionBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogFeesDescriptionBottomSheetBinding2 = null;
            }
            ImageView imageView = dialogFeesDescriptionBottomSheetBinding2.headerImage;
            Resources resources = getResources();
            int intValue = imageId.intValue();
            Context context = getContext();
            if (context != null) {
                theme = context.getTheme();
            } else {
                theme = null;
            }
            imageView.setImageDrawable(resources.getDrawable(intValue, theme));
        }
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding3 = this.binding;
        if (dialogFeesDescriptionBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFeesDescriptionBottomSheetBinding3 = null;
        }
        TextView textView = dialogFeesDescriptionBottomSheetBinding3.headerText;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel2 = this.displayData;
        if (feesDescriptionDisplayModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayData");
            feesDescriptionDisplayModel2 = null;
        }
        textView.setText(feesDescriptionDisplayModel2.getTitle());
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding4 = this.binding;
        if (dialogFeesDescriptionBottomSheetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFeesDescriptionBottomSheetBinding4 = null;
        }
        TextView textView2 = dialogFeesDescriptionBottomSheetBinding4.descriptionText;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel3 = this.displayData;
        if (feesDescriptionDisplayModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayData");
            feesDescriptionDisplayModel3 = null;
        }
        textView2.setText(feesDescriptionDisplayModel3.getDescription());
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding5 = this.binding;
        if (dialogFeesDescriptionBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFeesDescriptionBottomSheetBinding5 = null;
        }
        dialogFeesDescriptionBottomSheetBinding5.readMoreButton.setOnClickListener(new a(this));
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding6 = this.binding;
        if (dialogFeesDescriptionBottomSheetBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFeesDescriptionBottomSheetBinding6 = null;
        }
        dialogFeesDescriptionBottomSheetBinding6.gotItButton.setOnClickListener(new b(this));
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding7 = this.binding;
        if (dialogFeesDescriptionBottomSheetBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogFeesDescriptionBottomSheetBinding = dialogFeesDescriptionBottomSheetBinding7;
        }
        dialogFeesDescriptionBottomSheetBinding.closeButton.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-0  reason: not valid java name */
    public static final void m5751initViews$lambda0(FeesDescriptionBottomSheetFragment feesDescriptionBottomSheetFragment, View view) {
        OnReadMoreInfoClickedCallback onReadMoreInfoClickedCallback;
        Intrinsics.checkNotNullParameter(feesDescriptionBottomSheetFragment, "this$0");
        Fragment parentFragment = feesDescriptionBottomSheetFragment.getParentFragment();
        if (parentFragment instanceof OnReadMoreInfoClickedCallback) {
            onReadMoreInfoClickedCallback = (OnReadMoreInfoClickedCallback) parentFragment;
        } else {
            onReadMoreInfoClickedCallback = null;
        }
        if (onReadMoreInfoClickedCallback != null) {
            onReadMoreInfoClickedCallback.onReadMoreInfoClicked();
        }
        feesDescriptionBottomSheetFragment.openUrlInBrowser();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-1  reason: not valid java name */
    public static final void m5752initViews$lambda1(FeesDescriptionBottomSheetFragment feesDescriptionBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(feesDescriptionBottomSheetFragment, "this$0");
        feesDescriptionBottomSheetFragment.dismissCurrentDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-2  reason: not valid java name */
    public static final void m5753initViews$lambda2(FeesDescriptionBottomSheetFragment feesDescriptionBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(feesDescriptionBottomSheetFragment, "this$0");
        feesDescriptionBottomSheetFragment.dismissCurrentDialog();
    }

    @JvmStatic
    @NotNull
    public static final FeesDescriptionBottomSheetFragment newInstance(@DrawableRes int i11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        return Companion.newInstance(i11, str, str2, str3);
    }

    private final void openUrlInBrowser() {
        boolean z11;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel = this.displayData;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel2 = null;
        if (feesDescriptionDisplayModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayData");
            feesDescriptionDisplayModel = null;
        }
        String url = feesDescriptionDisplayModel.getUrl();
        if (url == null || StringsKt__StringsJVMKt.isBlank(url)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            FeesDescriptionDisplayModel feesDescriptionDisplayModel3 = this.displayData;
            if (feesDescriptionDisplayModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("displayData");
            } else {
                feesDescriptionDisplayModel2 = feesDescriptionDisplayModel3;
            }
            requireContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(feesDescriptionDisplayModel2.getUrl())));
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

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Serializable serializable;
        DialogFeesDescriptionBottomSheetBinding dialogFeesDescriptionBottomSheetBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "FeesDescriptionBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FeesDescriptionBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("data");
        } else {
            serializable = null;
        }
        if (serializable != null) {
            this.displayData = (FeesDescriptionDisplayModel) serializable;
            overrideParentTopPadding();
            DialogFeesDescriptionBottomSheetBinding inflate = DialogFeesDescriptionBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogFeesDescriptionBottomSheetBinding = inflate;
            }
            LinearLayout root = dialogFeesDescriptionBottomSheetBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            TraceMachine.exitMethod();
            return root;
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcommon.views.bottomsheet.FeesDescriptionDisplayModel");
        TraceMachine.exitMethod();
        throw nullPointerException;
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
        initViews();
    }
}
