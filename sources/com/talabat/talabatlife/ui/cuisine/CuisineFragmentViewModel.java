package com.talabat.talabatlife.ui.cuisine;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.domain.entity.Cuisine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineFragmentViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "getCuisineUseCase", "Lcom/talabat/talabatlife/ui/cuisine/GetCuisineUseCase;", "(Lcom/talabat/talabatlife/ui/cuisine/GetCuisineUseCase;)V", "cuisineList", "", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "cuisineLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCuisineLiveData", "()Landroidx/lifecycle/MutableLiveData;", "cuisineLiveData$delegate", "Lkotlin/Lazy;", "selectedCuisineLiveData", "getSelectedCuisineLiveData", "selectedCuisineLiveData$delegate", "getCuisineList", "", "selectedCuisine", "selectCuisine", "cuisine", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineFragmentViewModel extends BaseViewModel {
    @NotNull
    private List<CuisineDisplayModel> cuisineList = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private final Lazy cuisineLiveData$delegate;
    @NotNull
    private final GetCuisineUseCase getCuisineUseCase;
    @NotNull
    private final Lazy selectedCuisineLiveData$delegate;

    public CuisineFragmentViewModel(@NotNull GetCuisineUseCase getCuisineUseCase2) {
        Intrinsics.checkNotNullParameter(getCuisineUseCase2, "getCuisineUseCase");
        this.getCuisineUseCase = getCuisineUseCase2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cuisineLiveData$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CuisineFragmentViewModel$cuisineLiveData$2.INSTANCE);
        this.selectedCuisineLiveData$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CuisineFragmentViewModel$selectedCuisineLiveData$2.INSTANCE);
    }

    public final void getCuisineList(@Nullable CuisineDisplayModel cuisineDisplayModel) {
        Object obj;
        boolean z11;
        Iterable<Cuisine> invoke = this.getCuisineUseCase.invoke();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(invoke, 10));
        for (Cuisine cuisine : invoke) {
            arrayList.add(new CuisineDisplayModel(cuisine.getId(), cuisine.getName(), cuisine.getSlug(), false));
        }
        this.cuisineList = arrayList;
        if (cuisineDisplayModel != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((CuisineDisplayModel) obj).getId() == cuisineDisplayModel.getId()) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            CuisineDisplayModel cuisineDisplayModel2 = (CuisineDisplayModel) obj;
            if (cuisineDisplayModel2 != null) {
                cuisineDisplayModel2.setSelected(true);
            }
        } else {
            CuisineDisplayModel cuisineDisplayModel3 = (CuisineDisplayModel) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
            if (cuisineDisplayModel3 != null) {
                cuisineDisplayModel3.setSelected(true);
            }
        }
        getCuisineLiveData().setValue(this.cuisineList);
    }

    @NotNull
    public final MutableLiveData<List<CuisineDisplayModel>> getCuisineLiveData() {
        return (MutableLiveData) this.cuisineLiveData$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<CuisineDisplayModel> getSelectedCuisineLiveData() {
        return (MutableLiveData) this.selectedCuisineLiveData$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void selectCuisine(@org.jetbrains.annotations.NotNull com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "cuisine"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List<com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel> r0 = r7.cuisineList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r3 = (com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel) r3
            boolean r3 = r3.isSelected()
            if (r3 == 0) goto L_0x000d
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r1 = (com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel) r1
            r0 = 0
            if (r1 != 0) goto L_0x0029
            goto L_0x002c
        L_0x0029:
            r1.setSelected(r0)
        L_0x002c:
            java.util.List<com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel> r1 = r7.cuisineList
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0034:
            boolean r3 = r1.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r1.next()
            r5 = r3
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r5 = (com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel) r5
            int r5 = r5.getId()
            int r6 = r8.getId()
            if (r5 != r6) goto L_0x004e
            r5 = r4
            goto L_0x004f
        L_0x004e:
            r5 = r0
        L_0x004f:
            if (r5 == 0) goto L_0x0034
            r2 = r3
        L_0x0052:
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r2 = (com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel) r2
            if (r2 != 0) goto L_0x0057
            goto L_0x005a
        L_0x0057:
            r2.setSelected(r4)
        L_0x005a:
            androidx.lifecycle.MutableLiveData r0 = r7.getCuisineLiveData()
            java.util.List<com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel> r1 = r7.cuisineList
            r0.setValue(r1)
            androidx.lifecycle.MutableLiveData r0 = r7.getSelectedCuisineLiveData()
            r0.setValue(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.cuisine.CuisineFragmentViewModel.selectCuisine(com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel):void");
    }
}
