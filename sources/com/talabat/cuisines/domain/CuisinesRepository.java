package com.talabat.cuisines.domain;

import datamodels.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0018"}, d2 = {"Lcom/talabat/cuisines/domain/CuisinesRepository;", "", "appendSelectedCollectionCuisine", "", "cuisine", "Ldatamodels/Cuisine;", "appendSelectedCuisine", "getAllCuisinesId", "", "getAllCuisinesSlug", "", "loadAllCollectionsCuisines", "", "loadAllCuisines", "loadPopularCuisines", "loadSelectedCollectionCuisines", "loadSelectedCollectionsCuisineId", "()Ljava/lang/Integer;", "loadSelectedCuisineId", "loadSelectedCuisines", "removeSelectedCollectionsCuisine", "removeSelectedCuisine", "saveSelectedCollectionCuisine", "saveSelectedCuisine", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CuisinesRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void appendSelectedCollectionCuisine(@NotNull CuisinesRepository cuisinesRepository, @NotNull Cuisine cuisine) {
            Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        }

        public static void appendSelectedCuisine(@NotNull CuisinesRepository cuisinesRepository, @NotNull Cuisine cuisine) {
            Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        }

        public static int getAllCuisinesId(@NotNull CuisinesRepository cuisinesRepository) {
            return 0;
        }

        @NotNull
        public static String getAllCuisinesSlug(@NotNull CuisinesRepository cuisinesRepository) {
            return "";
        }

        @Nullable
        public static List<Cuisine> loadAllCollectionsCuisines(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static List<Cuisine> loadAllCuisines(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static List<Integer> loadPopularCuisines(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static List<Cuisine> loadSelectedCollectionCuisines(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static Integer loadSelectedCollectionsCuisineId(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static Integer loadSelectedCuisineId(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        @Nullable
        public static List<Cuisine> loadSelectedCuisines(@NotNull CuisinesRepository cuisinesRepository) {
            return null;
        }

        public static void removeSelectedCollectionsCuisine(@NotNull CuisinesRepository cuisinesRepository) {
        }

        public static void removeSelectedCuisine(@NotNull CuisinesRepository cuisinesRepository) {
        }

        public static void saveSelectedCollectionCuisine(@NotNull CuisinesRepository cuisinesRepository, @NotNull Cuisine cuisine) {
            Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        }

        public static void saveSelectedCuisine(@NotNull CuisinesRepository cuisinesRepository, @NotNull Cuisine cuisine) {
            Intrinsics.checkNotNullParameter(cuisine, "cuisine");
        }
    }

    void appendSelectedCollectionCuisine(@NotNull Cuisine cuisine);

    void appendSelectedCuisine(@NotNull Cuisine cuisine);

    int getAllCuisinesId();

    @NotNull
    String getAllCuisinesSlug();

    @Nullable
    List<Cuisine> loadAllCollectionsCuisines();

    @Nullable
    List<Cuisine> loadAllCuisines();

    @Nullable
    List<Integer> loadPopularCuisines();

    @Nullable
    List<Cuisine> loadSelectedCollectionCuisines();

    @Nullable
    Integer loadSelectedCollectionsCuisineId();

    @Nullable
    Integer loadSelectedCuisineId();

    @Nullable
    List<Cuisine> loadSelectedCuisines();

    void removeSelectedCollectionsCuisine();

    void removeSelectedCuisine();

    void saveSelectedCollectionCuisine(@NotNull Cuisine cuisine);

    void saveSelectedCuisine(@NotNull Cuisine cuisine);
}
