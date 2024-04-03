package com.talabat.darkstores.feature.cart.ageRestriction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.navigation.NavArgsLazy;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseBottomSheet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import si.a;
import si.b;
import si.c;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0014X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheet;", "Lcom/talabat/darkstores/common/base/BaseBottomSheet;", "", "setupActions", "", "i0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "", "eligible", "updateSelection", "", "contentViewId", "I", "getContentViewId", "()I", "Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheetArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheetArgs;", "args", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class AgeRestrictionBottomSheet extends BaseBottomSheet {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String SCREEN_NAME = "DS Age Restriction";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(AgeRestrictionBottomSheetArgs.class), new AgeRestrictionBottomSheet$special$$inlined$navArgs$1(this));
    private final int contentViewId = R.layout.darkstores_fragment_bottom_sheet_age_restriction;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/cart/ageRestriction/AgeRestrictionBottomSheet$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m9835onViewCreated$lambda0(AgeRestrictionBottomSheet ageRestrictionBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(ageRestrictionBottomSheet, "this$0");
        ageRestrictionBottomSheet.dismiss();
    }

    private final void setupActions() {
        int i11 = R.id.ineligible;
        ((TextView) _$_findCachedViewById(i11)).setText(getResources().getString(com.talabat.localization.R.string.ds_age_restriction_ineligible, new Object[]{getArgs().getAge()}));
        int i12 = R.id.eligible;
        ((TextView) _$_findCachedViewById(i12)).setText(getResources().getString(com.talabat.localization.R.string.ds_age_restriction_eligible, new Object[]{getArgs().getAge()}));
        ((TextView) _$_findCachedViewById(i11)).setOnClickListener(new b(this));
        ((TextView) _$_findCachedViewById(i12)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupActions$lambda-1  reason: not valid java name */
    public static final void m9836setupActions$lambda1(AgeRestrictionBottomSheet ageRestrictionBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(ageRestrictionBottomSheet, "this$0");
        ageRestrictionBottomSheet.updateSelection(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupActions$lambda-2  reason: not valid java name */
    public static final void m9837setupActions$lambda2(AgeRestrictionBottomSheet ageRestrictionBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(ageRestrictionBottomSheet, "this$0");
        ageRestrictionBottomSheet.updateSelection(true);
    }

    public static /* synthetic */ void updateSelection$default(AgeRestrictionBottomSheet ageRestrictionBottomSheet, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        ageRestrictionBottomSheet.updateSelection(z11);
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
    public final AgeRestrictionBottomSheetArgs getArgs() {
        return (AgeRestrictionBottomSheetArgs) this.args$delegate.getValue();
    }

    public int getContentViewId() {
        return this.contentViewId;
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
        setupActions();
        ((ImageView) _$_findCachedViewById(R.id.age_restriction_close)).setOnClickListener(new a(this));
    }

    public final void updateSelection(boolean z11) {
        getCartFragmentViewModel$com_talabat_NewArchi_darkstores_darkstores().updateEligibility(z11, getArgs().getAge());
        dismiss();
    }
}
