package com.talabat.darkstores.feature.cart.partialFulfillment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseBottomSheet;
import com.talabat.darkstores.data.partialFulfillment.model.Control;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vi.b;
import vi.c;
import vi.d;
import vi.e;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0012\u001a\u00020\u00118\u0014X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheet;", "Lcom/talabat/darkstores/common/base/BaseBottomSheet;", "", "setupPreferencesRecyclerView", "", "loggedIn", "setupActions", "onPreferenceClicked", "", "i0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "save", "updateSelection", "", "contentViewId", "I", "getContentViewId", "()I", "Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheetArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheetArgs;", "args", "Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter;", "preferencesAdapter", "Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter;", "getPreferencesAdapter", "()Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter;", "setPreferencesAdapter", "(Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter;)V", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class PartialFulfillmentBottomSheet extends BaseBottomSheet {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Partial fulfillment";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(PartialFulfillmentBottomSheetArgs.class), new PartialFulfillmentBottomSheet$special$$inlined$navArgs$1(this));
    private final int contentViewId = R.layout.darkstores_fragment_bottom_sheet_partial_fulfillment;
    @Nullable
    private PartialFulfillmentAdapter preferencesAdapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentBottomSheet$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final PartialFulfillmentBottomSheetArgs getArgs() {
        return (PartialFulfillmentBottomSheetArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void onPreferenceClicked() {
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m9847onViewCreated$lambda0(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(partialFulfillmentBottomSheet, "this$0");
        partialFulfillmentBottomSheet.dismiss();
    }

    private final void setupActions(boolean z11) {
        int i11;
        ((AppCompatTextView) _$_findCachedViewById(R.id.partial_fulfillment_bottom_title)).setText(getArgs().getPreferences().getName());
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.logged_actions);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "logged_actions");
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        linearLayout.setVisibility(i11);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.guest_actions);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "guest_actions");
        if (!(!z11)) {
            i12 = 8;
        }
        linearLayout2.setVisibility(i12);
        ((TextView) _$_findCachedViewById(R.id.just_once)).setOnClickListener(new c(this));
        ((TextView) _$_findCachedViewById(R.id.always)).setOnClickListener(new d(this));
        ((TextView) _$_findCachedViewById(R.id.update)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupActions$lambda-3  reason: not valid java name */
    public static final void m9848setupActions$lambda3(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(partialFulfillmentBottomSheet, "this$0");
        updateSelection$default(partialFulfillmentBottomSheet, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupActions$lambda-4  reason: not valid java name */
    public static final void m9849setupActions$lambda4(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(partialFulfillmentBottomSheet, "this$0");
        partialFulfillmentBottomSheet.updateSelection(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupActions$lambda-5  reason: not valid java name */
    public static final void m9850setupActions$lambda5(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(partialFulfillmentBottomSheet, "this$0");
        updateSelection$default(partialFulfillmentBottomSheet, false, 1, (Object) null);
    }

    private final void setupPreferencesRecyclerView() {
        PartialFulfillmentAdapter partialFulfillmentAdapter = new PartialFulfillmentAdapter();
        partialFulfillmentAdapter.submitList(CollectionsKt___CollectionsKt.toList(getArgs().getPreferences().getControls()), getArgs().getSelected());
        partialFulfillmentAdapter.setOnItemClickListener(new PartialFulfillmentBottomSheet$setupPreferencesRecyclerView$1$1(this));
        this.preferencesAdapter = partialFulfillmentAdapter;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.preferencesAdapter);
    }

    public static /* synthetic */ void updateSelection$default(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        partialFulfillmentBottomSheet.updateSelection(z11);
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

    public int getContentViewId() {
        return this.contentViewId;
    }

    @Nullable
    public final PartialFulfillmentAdapter getPreferencesAdapter() {
        return this.preferencesAdapter;
    }

    @NotNull
    public String i0() {
        return SCREEN_NAME;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupPreferencesRecyclerView();
        setupActions(getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores().isLoggedIn());
        ((ImageView) _$_findCachedViewById(R.id.partial_fulfillment_close)).setOnClickListener(new b(this));
    }

    public final void setPreferencesAdapter(@Nullable PartialFulfillmentAdapter partialFulfillmentAdapter) {
        this.preferencesAdapter = partialFulfillmentAdapter;
    }

    public final void updateSelection(boolean z11) {
        Control control;
        PartialFulfillmentAdapter partialFulfillmentAdapter = this.preferencesAdapter;
        if (partialFulfillmentAdapter != null) {
            control = partialFulfillmentAdapter.getSelectedControl();
        } else {
            control = null;
        }
        if (control != null) {
            getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores().onControlSelected(control, z11);
        }
        dismiss();
    }
}
