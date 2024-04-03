package com.talabat.feature.helpcenter.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.helpcenter.R;
import com.talabat.feature.helpcenter.databinding.LayoutCancellationPolicyBottomsheetBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xm.a;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyBottomSheet;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "cancellationPolicyList", "Landroidx/recyclerview/widget/RecyclerView;", "getCancellationPolicyList", "()Landroidx/recyclerview/widget/RecyclerView;", "setCancellationPolicyList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyBottomSheet extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "CancellationPolicyBottomSheet";
    public Trace _nr_trace;
    public RecyclerView cancellationPolicyList;
    @NotNull
    private final DSBottomSheet dsBottomSheet;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyBottomSheet$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyBottomSheet;", "content", "Ljava/util/ArrayList;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "title", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CancellationPolicyBottomSheet getInstance(@NotNull ArrayList<CancellationPolicyItemDisplayModel> arrayList, @NotNull String str, @NotNull DSBottomSheet dSBottomSheet) {
            Intrinsics.checkNotNullParameter(arrayList, "content");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
            CancellationPolicyBottomSheet cancellationPolicyBottomSheet = new CancellationPolicyBottomSheet(dSBottomSheet);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(CancellationPolicyBottomSheetKt.KEY_CANCELLATION_POLICY_CONTENT, arrayList);
            bundle.putString(CancellationPolicyBottomSheetKt.KEY_CANCELLATION_POLICY_TITLE, str);
            cancellationPolicyBottomSheet.setArguments(bundle);
            return cancellationPolicyBottomSheet;
        }
    }

    public CancellationPolicyBottomSheet(@NotNull DSBottomSheet dSBottomSheet) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        this.dsBottomSheet = dSBottomSheet;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10218onViewCreated$lambda0(CancellationPolicyBottomSheet cancellationPolicyBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(cancellationPolicyBottomSheet, "this$0");
        cancellationPolicyBottomSheet.dsBottomSheet.dismiss();
    }

    @NotNull
    public final RecyclerView getCancellationPolicyList() {
        RecyclerView recyclerView = this.cancellationPolicyList;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cancellationPolicyList");
        return null;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CancellationPolicyBottomSheet#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CancellationPolicyBottomSheet#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutCancellationPolicyBottomsheetBinding inflate = LayoutCancellationPolicyBottomsheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        LinearLayout root = inflate.getRoot();
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
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null) {
            arrayList = arguments.getParcelableArrayList(CancellationPolicyBottomSheetKt.KEY_CANCELLATION_POLICY_CONTENT);
        } else {
            arrayList = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(CancellationPolicyBottomSheetKt.KEY_CANCELLATION_POLICY_TITLE);
        }
        View findViewById = view.findViewById(R.id.cancellation_policy_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cancellation_policy_list)");
        setCancellationPolicyList((RecyclerView) findViewById);
        View findViewById2 = view.findViewById(R.id.close_bottom_sheet);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.close_bottom_sheet)");
        View findViewById3 = view.findViewById(R.id.cancel_policy_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.cancel_policy_title)");
        ((TextView) findViewById3).setText(str);
        ((ImageView) findViewById2).setOnClickListener(new a(this));
        CancellationPolicyAdapter cancellationPolicyAdapter = new CancellationPolicyAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        getCancellationPolicyList().setLayoutManager(linearLayoutManager);
        getCancellationPolicyList().setAdapter(cancellationPolicyAdapter);
        cancellationPolicyAdapter.submitList(arrayList);
    }

    public final void setCancellationPolicyList(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.cancellationPolicyList = recyclerView;
    }
}
