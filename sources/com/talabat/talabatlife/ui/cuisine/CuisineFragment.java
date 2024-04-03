package com.talabat.talabatlife.ui.cuisine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.cuisine.CuisineViewHolder;
import fw.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010!\u001a\u00020\u0002H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatlife/ui/cuisine/CuisineFragmentViewModel;", "Lcom/talabat/talabatlife/ui/cuisine/CuisineViewHolder$OnCuisineClicked;", "()V", "cuisineAdapter", "Lcom/talabat/talabatlife/ui/cuisine/CuisineAdapter;", "getCuisineAdapter", "()Lcom/talabat/talabatlife/ui/cuisine/CuisineAdapter;", "cuisineAdapter$delegate", "Lkotlin/Lazy;", "cuisineClick", "", "cuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "observatory", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateCuisineList", "cuisineList", "", "updateSelectedCuisine", "cuisineDisplayModel", "viewModelBuilder", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineFragment extends BaseFragment implements CuisineViewHolder.OnCuisineClicked {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ICuisineRepository cuisineRepository;
    /* access modifiers changed from: private */
    @Nullable
    public static CuisineDisplayModel selectedCuisine;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Lazy cuisineAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CuisineFragment$cuisineAdapter$2(this));

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineFragment$Companion;", "", "()V", "cuisineRepository", "Lcom/talabat/talabatlife/ui/cuisine/ICuisineRepository;", "selectedCuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "getInstance", "Lcom/talabat/talabatlife/ui/cuisine/CuisineFragment;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CuisineFragment getInstance(@Nullable CuisineDisplayModel cuisineDisplayModel, @NotNull ICuisineRepository iCuisineRepository) {
            Intrinsics.checkNotNullParameter(iCuisineRepository, "cuisineRepository");
            CuisineFragment.selectedCuisine = cuisineDisplayModel;
            CuisineFragment.cuisineRepository = iCuisineRepository;
            return new CuisineFragment();
        }
    }

    private final CuisineAdapter getCuisineAdapter() {
        return (CuisineAdapter) this.cuisineAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m5829onViewCreated$lambda2(CuisineFragment cuisineFragment, View view) {
        Intrinsics.checkNotNullParameter(cuisineFragment, "this$0");
        FragmentActivity activity = cuisineFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void updateCuisineList(List<CuisineDisplayModel> list) {
        if (list != null) {
            getCuisineAdapter().setCuisineList(list);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelectedCuisine(CuisineDisplayModel cuisineDisplayModel) {
        if (cuisineDisplayModel != null) {
            Intent intent = new Intent(CuisineFragmentKt.ACTION_CUISINE_SELECTED);
            intent.putExtra(CuisineFragmentKt.ARG_SELECTED_CUISINE, cuisineDisplayModel);
            BroadcastsKt.sendBroadcast(intent);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
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

    public void cuisineClick(@NotNull CuisineDisplayModel cuisineDisplayModel) {
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "cuisine");
        ((CuisineFragmentViewModel) getViewModel()).selectCuisine(cuisineDisplayModel);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public Class<CuisineFragmentViewModel> getViewModelClass() {
        return CuisineFragmentViewModel.class;
    }

    public int layoutId() {
        return R.layout.fragment_cuisine;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((CuisineFragmentViewModel) getViewModel()).getCuisineLiveData(), new CuisineFragment$observatory$1(this));
        LifecycleKt.observe(this, ((CuisineFragmentViewModel) getViewModel()).getSelectedCuisineLiveData(), new CuisineFragment$observatory$2(this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((CuisineFragmentViewModel) getViewModel()).getCuisineList(selectedCuisine);
        int i11 = R.id.cuisineRecyclerView;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getCuisineAdapter());
        ((ImageButton) _$_findCachedViewById(R.id.closeBtn)).setOnClickListener(new a(this));
    }

    @NotNull
    public CuisineFragmentViewModel viewModelBuilder() {
        ICuisineRepository iCuisineRepository = cuisineRepository;
        if (iCuisineRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cuisineRepository");
            iCuisineRepository = null;
        }
        return new CuisineFragmentViewModel(new GetCuisineUseCase(iCuisineRepository));
    }
}
