package com.talabat.components;

import android.util.SparseArray;
import buisnessmodels.FilterEngine;
import com.talabat.cuisines.domain.CuisinesRepository;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Cuisine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@CuisinesIntegrationDsl
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0016J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u001a"}, d2 = {"Lcom/talabat/components/CuisinesRepositoryImplementer;", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "()V", "appendSelectedCollectionCuisine", "", "cuisine", "Ldatamodels/Cuisine;", "appendSelectedCuisine", "getAllCuisinesId", "", "getAllCuisinesSlug", "", "loadAllCollectionsCuisines", "", "loadAllCuisines", "", "loadPopularCuisines", "loadSelectedCollectionCuisines", "loadSelectedCollectionsCuisineId", "()Ljava/lang/Integer;", "loadSelectedCuisineId", "loadSelectedCuisines", "removeSelectedCollectionsCuisine", "removeSelectedCuisine", "saveSelectedCollectionCuisine", "saveSelectedCuisine", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesRepositoryImplementer implements CuisinesRepository {
    @NotNull
    public static final CuisinesRepositoryImplementer INSTANCE = new CuisinesRepositoryImplementer();

    private CuisinesRepositoryImplementer() {
    }

    public void appendSelectedCollectionCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        if (GlobalDataModel.collectionFilterEngine == null) {
            GlobalDataModel.collectionFilterEngine = new FilterEngine();
        }
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (filterEngine.selectedCuisines == null) {
            filterEngine.selectedCuisines = new SparseArray<>();
        }
        GlobalDataModel.collectionFilterEngine.selectedCuisines.put(cuisine.f13848id, cuisine);
    }

    public void appendSelectedCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        if (GlobalDataModel.filterEngine == null) {
            GlobalDataModel.filterEngine = new FilterEngine();
        }
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine.selectedCuisines == null) {
            filterEngine.selectedCuisines = new SparseArray<>();
        }
        GlobalDataModel.filterEngine.selectedCuisines.put(cuisine.f13848id, cuisine);
    }

    public int getAllCuisinesId() {
        return -100;
    }

    @NotNull
    public String getAllCuisinesSlug() {
        return "All Cuisine";
    }

    @Nullable
    public List<Cuisine> loadAllCollectionsCuisines() {
        List<Cuisine> list;
        Object obj;
        boolean z11;
        Cuisine[] cuisineArr = GlobalDataModel.collectionCuisines;
        if (cuisineArr == null || (list = ArraysKt___ArraysKt.toMutableList((T[]) cuisineArr)) == null) {
            list = new ArrayList<>();
        }
        for (Cuisine cuisine : list) {
            List<Cuisine> loadAllCuisines = INSTANCE.loadAllCuisines();
            if (loadAllCuisines != null) {
                Iterator it = loadAllCuisines.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (cuisine.f13848id == ((Cuisine) obj).f13848id) {
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
                Cuisine cuisine2 = (Cuisine) obj;
                if (!(cuisine2 == null || (r3 = cuisine2.slugName) == null)) {
                    cuisine.slugName = r3;
                }
            }
            String str = "";
            cuisine.slugName = str;
        }
        return list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = kotlin.collections.ArraysKt___ArraysKt.toMutableList((T[]) r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<datamodels.Cuisine> loadAllCuisines() {
        /*
            r1 = this;
            datamodels.Cuisine[] r0 = com.talabat.helpers.GlobalDataModel.cuisines
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysKt.toMutableList((T[]) r0)
            if (r0 != 0) goto L_0x000f
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.components.CuisinesRepositoryImplementer.loadAllCuisines():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = kotlin.collections.ArraysKt___ArraysKt.toMutableList((T[]) r0);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> loadPopularCuisines() {
        /*
            r1 = this;
            java.lang.Integer[] r0 = com.talabat.helpers.GlobalDataModel.popularCuisinesIds
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysKt.toMutableList((T[]) r0)
            if (r0 != 0) goto L_0x000f
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.components.CuisinesRepositoryImplementer.loadPopularCuisines():java.util.List");
    }

    @Nullable
    public List<Cuisine> loadSelectedCollectionCuisines() {
        SparseArray<Cuisine> sparseArray;
        ArrayList arrayList = new ArrayList();
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (!(filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null)) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                sparseArray.keyAt(i11);
                arrayList.add(sparseArray.valueAt(i11));
            }
        }
        return arrayList;
    }

    @Nullable
    public Integer loadSelectedCollectionsCuisineId() {
        SparseArray<Cuisine> sparseArray;
        boolean z11;
        Cuisine valueAt;
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null) {
            return null;
        }
        if (sparseArray.size() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || (valueAt = sparseArray.valueAt(0)) == null) {
            return null;
        }
        return Integer.valueOf(valueAt.f13848id);
    }

    @Nullable
    public Integer loadSelectedCuisineId() {
        SparseArray<Cuisine> sparseArray;
        boolean z11;
        Cuisine valueAt;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null) {
            return null;
        }
        if (sparseArray.size() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || (valueAt = sparseArray.valueAt(0)) == null) {
            return null;
        }
        return Integer.valueOf(valueAt.f13848id);
    }

    @Nullable
    public List<Cuisine> loadSelectedCuisines() {
        SparseArray<Cuisine> sparseArray;
        ArrayList arrayList = new ArrayList();
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (!(filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null)) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                sparseArray.keyAt(i11);
                arrayList.add(sparseArray.valueAt(i11));
            }
        }
        return arrayList;
    }

    public void removeSelectedCollectionsCuisine() {
        SparseArray<Cuisine> sparseArray;
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (filterEngine != null && (sparseArray = filterEngine.selectedCuisines) != null) {
            sparseArray.clear();
        }
    }

    public void removeSelectedCuisine() {
        SparseArray<Cuisine> sparseArray;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine != null && (sparseArray = filterEngine.selectedCuisines) != null) {
            sparseArray.clear();
        }
    }

    public void saveSelectedCollectionCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        FilterEngine filterEngine = new FilterEngine();
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cuisine.f13848id, cuisine);
        filterEngine.setSelectedCuisines(sparseArray);
        GlobalDataModel.collectionFilterEngine = filterEngine;
    }

    public void saveSelectedCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        FilterEngine filterEngine = new FilterEngine();
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(cuisine.f13848id, cuisine);
        filterEngine.setSelectedCuisines(sparseArray);
        GlobalDataModel.filterEngine = filterEngine;
    }
}
