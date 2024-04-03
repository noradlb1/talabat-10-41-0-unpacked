package com.talabat.cuisines.presentation;

import androidx.lifecycle.MutableLiveData;
import com.talabat.cuisines.domain.SelectableCuisine;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002¨\u0006\r"}, d2 = {"clearCuisineSelection", "", "Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "clearCuisineSelectionWithPopular", "initialize", "selectCuisine", "selectableCuisine", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "selectMultipleCuisines", "selectMultipleCuisinesWithPopular", "updateShowPopularCuisines", "allCuisines", "", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisinesViewModelKt {
    public static final void clearCuisineSelection(@NotNull CuisinesViewModel cuisinesViewModel) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "<this>");
        cuisinesViewModel.getClearUpAnalyticsSelectedCuisines().invoke();
        cuisinesViewModel.getClearSelection().invoke();
        List<SelectableCuisine> value = cuisinesViewModel.getCuisines().getValue();
        if (value != null) {
            for (SelectableCuisine on2 : value) {
                on2.setOn(false);
            }
        }
        cuisinesViewModel.getCuisines().setValue(value);
    }

    public static final void clearCuisineSelectionWithPopular(@NotNull CuisinesViewModel cuisinesViewModel) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "<this>");
        cuisinesViewModel.getClearUpAnalyticsSelectedCuisines().invoke();
        cuisinesViewModel.getClearSelection().invoke();
        List<SelectableCuisine> value = cuisinesViewModel.getCuisines().getValue();
        if (value != null) {
            for (SelectableCuisine on2 : value) {
                on2.setOn(false);
            }
        }
        cuisinesViewModel.getCuisines().setValue(value);
        updateShowPopularCuisines(cuisinesViewModel, value);
    }

    /* access modifiers changed from: private */
    public static final void initialize(CuisinesViewModel cuisinesViewModel) {
        cuisinesViewModel.getProgress().setValue(Boolean.TRUE);
        CoroutinesKt.runHandling(new CuisinesViewModelKt$initialize$1(cuisinesViewModel.getErrors()), new CuisinesViewModelKt$initialize$2(cuisinesViewModel));
        if (cuisinesViewModel.getShowPopularCuisines()) {
            CoroutinesKt.runHandling(new CuisinesViewModelKt$initialize$3(cuisinesViewModel.getErrors()), new CuisinesViewModelKt$initialize$4(cuisinesViewModel));
        }
        cuisinesViewModel.getProgress().setValue(Boolean.FALSE);
    }

    public static final void selectCuisine(@NotNull CuisinesViewModel cuisinesViewModel, @NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectableCuisine, "selectableCuisine");
        cuisinesViewModel.getSelectCuisine().invoke(selectableCuisine.getCuisine());
        List value = cuisinesViewModel.getCuisines().getValue();
        if (value != null) {
            Iterable iterable = value;
            ArrayList<SelectableCuisine> arrayList = new ArrayList<>();
            for (Object next : iterable) {
                if (((SelectableCuisine) next).isOn()) {
                    arrayList.add(next);
                }
            }
            for (SelectableCuisine on2 : arrayList) {
                on2.setOn(false);
            }
            ArrayList<SelectableCuisine> arrayList2 = new ArrayList<>();
            for (Object next2 : iterable) {
                if (Intrinsics.areEqual((Object) (SelectableCuisine) next2, (Object) selectableCuisine)) {
                    arrayList2.add(next2);
                }
            }
            for (SelectableCuisine on3 : arrayList2) {
                on3.setOn(true);
            }
            cuisinesViewModel.getCuisines().setValue(value);
        }
    }

    public static final void selectMultipleCuisines(@NotNull CuisinesViewModel cuisinesViewModel, @NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectableCuisine, "selectableCuisine");
        List value = cuisinesViewModel.getCuisines().getValue();
        if (value != null) {
            Iterable iterable = value;
            ArrayList<SelectableCuisine> arrayList = new ArrayList<>();
            for (Object next : iterable) {
                if (Intrinsics.areEqual((Object) (SelectableCuisine) next, (Object) selectableCuisine)) {
                    arrayList.add(next);
                }
            }
            for (SelectableCuisine selectableCuisine2 : arrayList) {
                selectableCuisine2.setOn(!selectableCuisine2.isOn());
                selectableCuisine.setOn(selectableCuisine2.isOn());
                cuisinesViewModel.getUpdateAnalyticsCuisinesOnClick().invoke(selectableCuisine);
            }
            cuisinesViewModel.getClearSelection().invoke();
            ArrayList<SelectableCuisine> arrayList2 = new ArrayList<>();
            for (Object next2 : iterable) {
                if (((SelectableCuisine) next2).isOn()) {
                    arrayList2.add(next2);
                }
            }
            for (SelectableCuisine cuisine : arrayList2) {
                cuisinesViewModel.getSelectCuisine().invoke(cuisine.getCuisine());
            }
            cuisinesViewModel.getCuisines().setValue(value);
        }
    }

    public static final void selectMultipleCuisinesWithPopular(@NotNull CuisinesViewModel cuisinesViewModel, @NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectableCuisine, "selectableCuisine");
        List value = cuisinesViewModel.getCuisines().getValue();
        if (value != null) {
            Iterable iterable = value;
            ArrayList<SelectableCuisine> arrayList = new ArrayList<>();
            Iterator it = iterable.iterator();
            while (true) {
                boolean z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SelectableCuisine) next).getCuisine().f13848id != selectableCuisine.getCuisine().f13848id) {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(next);
                }
            }
            for (SelectableCuisine selectableCuisine2 : arrayList) {
                selectableCuisine2.setOn(!selectableCuisine2.isOn());
                selectableCuisine.setOn(selectableCuisine2.isOn());
                cuisinesViewModel.getUpdateAnalyticsCuisinesOnClick().invoke(selectableCuisine);
            }
            cuisinesViewModel.getClearSelection().invoke();
            ArrayList<SelectableCuisine> arrayList2 = new ArrayList<>();
            for (Object next2 : iterable) {
                if (((SelectableCuisine) next2).isOn()) {
                    arrayList2.add(next2);
                }
            }
            for (SelectableCuisine cuisine : arrayList2) {
                cuisinesViewModel.getSelectCuisine().invoke(cuisine.getCuisine());
            }
            cuisinesViewModel.getCuisines().setValue(value);
            updateShowPopularCuisines(cuisinesViewModel, value);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateShowPopularCuisines(CuisinesViewModel cuisinesViewModel, List<SelectableCuisine> list) {
        ArrayList arrayList;
        boolean z11;
        Collection collection;
        MutableLiveData<List<ItemContainer>> showCuisinesWithPopular = cuisinesViewModel.getShowCuisinesWithPopular();
        ArrayList arrayList2 = new ArrayList();
        List invoke = cuisinesViewModel.getRequestPopularUseCase().invoke();
        if (invoke != null) {
            Iterable<SelectableCuisine> iterable = invoke;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (SelectableCuisine itemContainer : iterable) {
                arrayList.add(new ItemContainer(itemContainer));
            }
        } else {
            arrayList = null;
        }
        Collection collection2 = arrayList;
        if (collection2 == null || collection2.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            arrayList2.add(new ItemContainer(HEADERTYPE.POPULAR));
            arrayList2.addAll(arrayList);
            arrayList2.add(new ItemContainer(HEADERTYPE.ALL_CUISINES));
        }
        if (list != null) {
            Iterable<SelectableCuisine> iterable2 = list;
            collection = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
            for (SelectableCuisine itemContainer2 : iterable2) {
                collection.add(new ItemContainer(itemContainer2));
            }
        } else {
            collection = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList2.addAll(collection);
        showCuisinesWithPopular.setValue(arrayList2);
    }
}
