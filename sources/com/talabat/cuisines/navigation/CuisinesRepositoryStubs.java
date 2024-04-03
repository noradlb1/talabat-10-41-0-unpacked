package com.talabat.cuisines.navigation;

import com.talabat.cuisines.domain.CuisinesRepository;
import datamodels.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/talabat/cuisines/navigation/CuisinesRepositoryStubs;", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "()V", "getAllCuisinesId", "", "getAllCuisinesSlug", "", "loadAllCollectionsCuisines", "", "Ldatamodels/Cuisine;", "loadAllCuisines", "loadSelectedCollectionCuisines", "loadSelectedCollectionsCuisineId", "()Ljava/lang/Integer;", "loadSelectedCuisineId", "loadSelectedCuisines", "removeSelectedCollectionsCuisine", "", "removeSelectedCuisine", "saveSelectedCollectionCuisine", "cuisine", "saveSelectedCuisine", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class CuisinesRepositoryStubs implements CuisinesRepository {
    @NotNull
    public static final CuisinesRepositoryStubs INSTANCE = new CuisinesRepositoryStubs();

    private CuisinesRepositoryStubs() {
    }

    public void appendSelectedCollectionCuisine(@NotNull Cuisine cuisine) {
        CuisinesRepository.DefaultImpls.appendSelectedCollectionCuisine(this, cuisine);
    }

    public void appendSelectedCuisine(@NotNull Cuisine cuisine) {
        CuisinesRepository.DefaultImpls.appendSelectedCuisine(this, cuisine);
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
        Object obj = SampleCuisinesActivityKt.getCache().get("AllCollectionsCuisines");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public List<Cuisine> loadAllCuisines() {
        Object obj = SampleCuisinesActivityKt.getCache().get("AllCuisines");
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    @Nullable
    public List<Integer> loadPopularCuisines() {
        return CuisinesRepository.DefaultImpls.loadPopularCuisines(this);
    }

    @Nullable
    public List<Cuisine> loadSelectedCollectionCuisines() {
        Object obj = SampleCuisinesActivityKt.getCache().get("SelectedCollectionCuisine");
        if (obj != null) {
            return CollectionsKt__CollectionsJVMKt.listOf((Cuisine) obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type datamodels.Cuisine");
    }

    @Nullable
    public Integer loadSelectedCollectionsCuisineId() {
        Cuisine cuisine;
        List<Cuisine> loadSelectedCollectionCuisines = loadSelectedCollectionCuisines();
        if (loadSelectedCollectionCuisines == null || (cuisine = (Cuisine) CollectionsKt___CollectionsKt.first(loadSelectedCollectionCuisines)) == null) {
            return null;
        }
        return Integer.valueOf(cuisine.f13848id);
    }

    @Nullable
    public Integer loadSelectedCuisineId() {
        Cuisine cuisine;
        List<Cuisine> loadSelectedCuisines = loadSelectedCuisines();
        if (loadSelectedCuisines == null || (cuisine = (Cuisine) CollectionsKt___CollectionsKt.first(loadSelectedCuisines)) == null) {
            return null;
        }
        return Integer.valueOf(cuisine.f13848id);
    }

    @Nullable
    public List<Cuisine> loadSelectedCuisines() {
        Object obj = SampleCuisinesActivityKt.getCache().get("SelectedCuisine");
        if (obj != null) {
            return CollectionsKt__CollectionsJVMKt.listOf((Cuisine) obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type datamodels.Cuisine");
    }

    public void removeSelectedCollectionsCuisine() {
        SampleCuisinesActivityKt.getCache().remove("SelectedCollectionsCuisine");
    }

    public void removeSelectedCuisine() {
        SampleCuisinesActivityKt.getCache().remove("SelectedCuisine");
    }

    public void saveSelectedCollectionCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        SampleCuisinesActivityKt.getCache().put("SelectedCollectionCuisine", cuisine);
    }

    public void saveSelectedCuisine(@NotNull Cuisine cuisine) {
        Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        SampleCuisinesActivityKt.getCache().put("SelectedCuisine", cuisine);
    }
}
