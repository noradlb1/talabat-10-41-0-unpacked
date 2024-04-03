package com.talabat.darkstores.feature.categories.subcategories.sort;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bj.b;
import bj.c;
import bj.d;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseBottomSheet;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.data.discovery.model.SortOption;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheet;", "Lcom/talabat/darkstores/common/base/BaseBottomSheet;", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "sortOption", "", "position", "", "onRadioButtonClicked", "", "i0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetArgs;", "args", "updatedSortOptionIndex", "I", "Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetViewModel;", "viewModel", "getContentViewId", "()I", "contentViewId", "<init>", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SortOptionBottomSheet extends BaseBottomSheet {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SortOptionBottomSheetArgs.class), new SortOptionBottomSheet$special$$inlined$navArgs$1(this));
    private int updatedSortOptionIndex;
    @NotNull
    private final Lazy viewModel$delegate;

    public SortOptionBottomSheet() {
        SortOptionBottomSheet$special$$inlined$viewModel$1 sortOptionBottomSheet$special$$inlined$viewModel$1 = new SortOptionBottomSheet$special$$inlined$viewModel$1();
        Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SortOptionBottomSheetViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), sortOptionBottomSheet$special$$inlined$viewModel$1);
    }

    private final SortOptionBottomSheetArgs getArgs() {
        return (SortOptionBottomSheetArgs) this.args$delegate.getValue();
    }

    private final SortOptionBottomSheetViewModel getViewModel() {
        return (SortOptionBottomSheetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void onRadioButtonClicked(SortOption sortOption, int i11) {
        getViewModel().onSortOptionClicked(sortOption);
        this.updatedSortOptionIndex = i11;
        ((RecyclerView) _$_findCachedViewById(R.id.sort_option_rv)).post(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onRadioButtonClicked$lambda-4  reason: not valid java name */
    public static final void m9932onRadioButtonClicked$lambda4(SortOptionBottomSheet sortOptionBottomSheet) {
        Intrinsics.checkNotNullParameter(sortOptionBottomSheet, "this$0");
        RecyclerView.Adapter adapter = ((RecyclerView) sortOptionBottomSheet._$_findCachedViewById(R.id.sort_option_rv)).getAdapter();
        if (adapter != null) {
            ((SortOptionsRecycleViewAdapter) adapter).notifyDataSetChanged();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionsRecycleViewAdapter");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m9933onViewCreated$lambda2(List list, SortOptionBottomSheet sortOptionBottomSheet, Ref.IntRef intRef, View view) {
        Intrinsics.checkNotNullParameter(list, "$sortOptions");
        Intrinsics.checkNotNullParameter(sortOptionBottomSheet, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$preSelectedSortOptionIndex");
        SortOption sortOption = (SortOption) list.get(sortOptionBottomSheet.updatedSortOptionIndex);
        sortOptionBottomSheet.getViewModel().onSortOptionApplied(sortOption);
        if (intRef.element != sortOptionBottomSheet.updatedSortOptionIndex) {
            FragmentKt.setFragmentResult(sortOptionBottomSheet, SortOptionBottomSheetKt.REQUEST_APPLIED_SORT_OPTION, BundleKt.bundleOf(TuplesKt.to(SortOptionBottomSheetKt.SORT_OPTION_KEY, sortOption.getKey())));
        }
        sortOptionBottomSheet.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m9934onViewCreated$lambda3(SortOptionBottomSheet sortOptionBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(sortOptionBottomSheet, "this$0");
        sortOptionBottomSheet.dismiss();
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
        return R.layout.darkstores_fragment_bottom_sheet_sort;
    }

    @NotNull
    public String i0() {
        return "DS VLP Sort";
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        List list = ArraysKt___ArraysKt.toList((T[]) getArgs().getSortOptions());
        Ref.IntRef intRef = new Ref.IntRef();
        int i11 = 0;
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((SortOption) next).isApplied()) {
                intRef.element = i11;
            }
            i11 = i12;
        }
        this.updatedSortOptionIndex = intRef.element;
        int i13 = R.id.sort_option_rv;
        ((RecyclerView) _$_findCachedViewById(i13)).setLayoutManager(new LinearLayoutManager(requireContext()));
        SortOptionsRecycleViewAdapter sortOptionsRecycleViewAdapter = new SortOptionsRecycleViewAdapter(new SortOptionBottomSheet$onViewCreated$sortAdaptor$1(this), list, this.updatedSortOptionIndex);
        sortOptionsRecycleViewAdapter.setHasStableIds(true);
        ((RecyclerView) _$_findCachedViewById(i13)).setAdapter(sortOptionsRecycleViewAdapter);
        ((TextView) _$_findCachedViewById(R.id.btn_apply)).setOnClickListener(new b(list, this, intRef));
        ((ImageView) _$_findCachedViewById(R.id.close)).setOnClickListener(new c(this));
    }
}
