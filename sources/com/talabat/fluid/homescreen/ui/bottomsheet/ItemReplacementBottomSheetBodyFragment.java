package com.talabat.fluid.homescreen.ui.bottomsheet;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.homescreen.databinding.BottomSheetItemReplacementBinding;
import com.talabat.localization.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/bottomsheet/ItemReplacementBottomSheetBodyFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/homescreen/databinding/BottomSheetItemReplacementBinding;", "chainName", "", "description", "empty", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemReplacementBottomSheetBodyFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final String CHAIN_NAME = "com.talabat.fluid.homescreen.ui.bottomsheet.CHAIN_NAME";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private BottomSheetItemReplacementBinding binding;
    @NotNull
    private String chainName = "";
    @NotNull
    private String description = "";
    @NotNull
    private final String empty = "";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/bottomsheet/ItemReplacementBottomSheetBodyFragment$Companion;", "", "()V", "CHAIN_NAME", "", "newInstance", "Lcom/talabat/fluid/homescreen/ui/bottomsheet/ItemReplacementBottomSheetBodyFragment;", "chainName", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemReplacementBottomSheetBodyFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "chainName");
            ItemReplacementBottomSheetBodyFragment itemReplacementBottomSheetBodyFragment = new ItemReplacementBottomSheetBodyFragment();
            itemReplacementBottomSheetBodyFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(ItemReplacementBottomSheetBodyFragment.CHAIN_NAME, str)));
            return itemReplacementBottomSheetBodyFragment;
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

    public void onCreate(@Nullable Bundle bundle) {
        String string;
        TraceMachine.startTracing("ItemReplacementBottomSheetBodyFragment");
        String str = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ItemReplacementBottomSheetBodyFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ItemReplacementBottomSheetBodyFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (bundle == null || (string = bundle.getString(CHAIN_NAME)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString(CHAIN_NAME, this.empty);
            }
        } else {
            str = string;
        }
        if (str == null) {
            str = this.empty;
        }
        this.chainName = str;
        Resources resources = getResources();
        int i11 = R.string.home_item_replacement_bottom_sheet_description;
        String str2 = this.chainName;
        String string2 = resources.getString(i11, new Object[]{"<b>" + str2 + "</b>"});
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(\n   …$chainName</b>\"\n        )");
        this.description = string2;
        TraceMachine.exitMethod();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        BottomSheetItemReplacementBinding bottomSheetItemReplacementBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ItemReplacementBottomSheetBodyFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ItemReplacementBottomSheetBodyFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BottomSheetItemReplacementBinding inflate = BottomSheetItemReplacementBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bottomSheetItemReplacementBinding = inflate;
        }
        LinearLayoutCompat root = bottomSheetItemReplacementBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(CHAIN_NAME, this.chainName);
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
        BottomSheetItemReplacementBinding bottomSheetItemReplacementBinding = this.binding;
        if (bottomSheetItemReplacementBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomSheetItemReplacementBinding = null;
        }
        bottomSheetItemReplacementBinding.bsItemReplacementDescription.setText(HtmlCompat.fromHtml(this.description, 0));
    }
}
