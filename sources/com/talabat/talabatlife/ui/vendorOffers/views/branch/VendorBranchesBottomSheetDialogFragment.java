package com.talabat.talabatlife.ui.vendorOffers.views.branch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBranchesBottomSheetDialogFragment;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "branches", "", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "(Ljava/util/List;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBranchesBottomSheetDialogFragment extends TalabatBaseBottomSheetDialogFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private List<VendorBranchDisplayModel> branches;

    public VendorBranchesBottomSheetDialogFragment() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public VendorBranchesBottomSheetDialogFragment(@NotNull List<VendorBranchDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "branches");
        this._$_findViewCache = new LinkedHashMap();
        this.branches = list;
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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_vendor_branches, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.vendorBottomSheetBranchesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new VendorsBottomSheetBranchesListAdaptor(this.branches));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorBranchesBottomSheetDialogFragment(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }
}
