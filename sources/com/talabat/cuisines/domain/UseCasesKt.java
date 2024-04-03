package com.talabat.cuisines.domain;

import com.talabat.cuisines.CuisinesIntegratorKt;
import datamodels.Cuisine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\b\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0002\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u0016\u0010\f\u001a\u00020\u000b2\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001af\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t2#\u0010\u000e\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u00102#\u0010\u0011\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u0010H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\u00132\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u0016\u0010\u0014\u001a\u00020\u00132\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a3\u0010\u0015\u001a\u00020\u00132\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u001d\u0010\u0016\u001a\u0019\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0002\b\u0010H\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001H\u0001\u001a\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a`\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t2#\u0010\u000e\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u00102\u001d\u0010\u0011\u001a\u0019\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f¢\u0006\u0002\b\u0010H\u0001\u001af\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t2#\u0010\u000e\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u00102#\u0010\u0011\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u0010H\u0001\u001a\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0001\u001a=\u0010\"\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00060#2\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u001d\u0010$\u001a\u0019\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f¢\u0006\u0002\b\u0010H\u0002\u001aC\u0010%\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00060#2\n\u0010\u0007\u001a\u00060\bj\u0002`\t2#\u0010$\u001a\u001f\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u000f¢\u0006\u0002\b\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000*\f\b\u0002\u0010&\"\u00020\b2\u00020\b¨\u0006'"}, d2 = {"FIRST_INDEX", "", "lastSavedCusines", "", "Ldatamodels/Cuisine;", "SelectableCuisine", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "repository", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "Lcom/talabat/cuisines/domain/Repository;", "applyLastSavedCollectionCuisines", "", "applyLastSavedCuisines", "getAnyPopularCuisines", "loadAnyCuisines", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "loadAnySelectedCuisine", "hasSelectedCollectionsCuisines", "", "hasSelectedCuisines", "hasSelection", "loadId", "isAllCuisinesItem", "itemId", "allCuisinesId", "popularCollectionsCuisines", "popularCuisines", "requestAnyCuisines", "requestAnyCuisinesWithMultipleSelection", "requestCollectionsCuisines", "requestCollectionsCuisinesWithMultipleSelection", "requestCuisines", "requestCuisinesWithMultipleSelection", "updateSelectionStatus", "", "loadAnySelectedCuisines", "updateSelectionStatusFromList", "Repository", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UseCasesKt {
    private static final int FIRST_INDEX = 0;
    @Nullable
    private static List<? extends Cuisine> lastSavedCusines;

    private static final SelectableCuisine SelectableCuisine(CuisinesRepository cuisinesRepository) {
        return new SelectableCuisine(EntitiesKt.Cuisine(cuisinesRepository.getAllCuisinesId(), cuisinesRepository.getAllCuisinesSlug(), cuisinesRepository.getAllCuisinesSlug()), false, false, 6, (DefaultConstructorMarker) null);
    }

    @BusinessRule
    public static final void applyLastSavedCollectionCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        cuisinesRepository.removeSelectedCollectionsCuisine();
        List<? extends Cuisine> list = lastSavedCusines;
        if (list != null) {
            for (Cuisine appendSelectedCollectionCuisine : list) {
                cuisinesRepository.appendSelectedCollectionCuisine(appendSelectedCollectionCuisine);
            }
        }
    }

    public static /* synthetic */ void applyLastSavedCollectionCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        applyLastSavedCollectionCuisines(cuisinesRepository);
    }

    @BusinessRule
    public static final void applyLastSavedCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        cuisinesRepository.removeSelectedCuisine();
        List<? extends Cuisine> list = lastSavedCusines;
        if (list != null) {
            for (Cuisine appendSelectedCuisine : list) {
                cuisinesRepository.appendSelectedCuisine(appendSelectedCuisine);
            }
        }
    }

    public static /* synthetic */ void applyLastSavedCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        applyLastSavedCuisines(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> getAnyPopularCuisines(@NotNull CuisinesRepository cuisinesRepository, @NotNull Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function1, @NotNull Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        Intrinsics.checkNotNullParameter(function1, "loadAnyCuisines");
        Intrinsics.checkNotNullParameter(function12, "loadAnySelectedCuisine");
        List list = (List) function1.invoke(cuisinesRepository);
        if (list != null) {
            ArrayList<Cuisine> arrayList = new ArrayList<>();
            for (Object next : list) {
                Cuisine cuisine = (Cuisine) next;
                List<Integer> loadPopularCuisines = cuisinesRepository.loadPopularCuisines();
                if (loadPopularCuisines != null) {
                    z11 = loadPopularCuisines.contains(Integer.valueOf(cuisine.f13848id));
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (Cuisine selectableCuisine : arrayList) {
                arrayList2.add(new SelectableCuisine(selectableCuisine, false, true, 2, (DefaultConstructorMarker) null));
            }
            List<SelectableCuisine> mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList2);
            if (mutableList != null) {
                updateSelectionStatusFromList(mutableList, cuisinesRepository, function12);
                return mutableList;
            }
        }
        return null;
    }

    @BusinessRule
    public static final boolean hasSelectedCollectionsCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return hasSelection(cuisinesRepository, UseCasesKt$hasSelectedCollectionsCuisines$1.INSTANCE);
    }

    public static /* synthetic */ boolean hasSelectedCollectionsCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return hasSelectedCollectionsCuisines(cuisinesRepository);
    }

    @BusinessRule
    public static final boolean hasSelectedCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return hasSelection(cuisinesRepository, UseCasesKt$hasSelectedCuisines$1.INSTANCE);
    }

    public static /* synthetic */ boolean hasSelectedCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return hasSelectedCuisines(cuisinesRepository);
    }

    @BusinessRule
    public static final boolean hasSelection(@NotNull CuisinesRepository cuisinesRepository, @NotNull Function1<? super CuisinesRepository, Integer> function1) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        Intrinsics.checkNotNullParameter(function1, "loadId");
        Integer invoke = function1.invoke(cuisinesRepository);
        if (invoke == null || invoke.intValue() == cuisinesRepository.getAllCuisinesId()) {
            return false;
        }
        return true;
    }

    @BusinessRule
    public static final boolean isAllCuisinesItem(int i11, int i12) {
        return i11 == i12;
    }

    public static /* synthetic */ boolean isAllCuisinesItem$default(int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = CuisinesIntegratorKt.getRepository().getAllCuisinesId();
        }
        return isAllCuisinesItem(i11, i12);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> popularCollectionsCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return getAnyPopularCuisines(cuisinesRepository, UseCasesKt$popularCollectionsCuisines$1.INSTANCE, UseCasesKt$popularCollectionsCuisines$2.INSTANCE);
    }

    public static /* synthetic */ List popularCollectionsCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return popularCollectionsCuisines(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> popularCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return getAnyPopularCuisines(cuisinesRepository, UseCasesKt$popularCuisines$1.INSTANCE, UseCasesKt$popularCuisines$2.INSTANCE);
    }

    public static /* synthetic */ List popularCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return popularCuisines(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestAnyCuisines(@NotNull CuisinesRepository cuisinesRepository, @NotNull Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function1, @NotNull Function1<? super CuisinesRepository, ? extends Cuisine> function12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        Intrinsics.checkNotNullParameter(function1, "loadAnyCuisines");
        Intrinsics.checkNotNullParameter(function12, "loadAnySelectedCuisine");
        List list = (List) function1.invoke(cuisinesRepository);
        if (list != null) {
            Iterable<Cuisine> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Cuisine selectableCuisine : iterable) {
                arrayList.add(new SelectableCuisine(selectableCuisine, false, false, 6, (DefaultConstructorMarker) null));
            }
            List<SelectableCuisine> mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList);
            if (mutableList != null) {
                mutableList.add(0, SelectableCuisine(cuisinesRepository));
                updateSelectionStatus(mutableList, cuisinesRepository, function12);
                Iterable iterable2 = mutableList;
                if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                    Iterator it = iterable2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((SelectableCuisine) it.next()).isOn()) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z11 = true;
                if (!z11) {
                    return mutableList;
                }
                mutableList.get(0).setOn(true);
                return mutableList;
            }
        }
        return null;
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestAnyCuisinesWithMultipleSelection(@NotNull CuisinesRepository cuisinesRepository, @NotNull Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function1, @NotNull Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function12) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        Intrinsics.checkNotNullParameter(function1, "loadAnyCuisines");
        Intrinsics.checkNotNullParameter(function12, "loadAnySelectedCuisine");
        List list = (List) function1.invoke(cuisinesRepository);
        if (list != null) {
            Iterable<Cuisine> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Cuisine selectableCuisine : iterable) {
                arrayList.add(new SelectableCuisine(selectableCuisine, false, false, 6, (DefaultConstructorMarker) null));
            }
            List<SelectableCuisine> mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList);
            if (mutableList != null) {
                lastSavedCusines = (List) function12.invoke(cuisinesRepository);
                updateSelectionStatusFromList(mutableList, cuisinesRepository, function12);
                return mutableList;
            }
        }
        return null;
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestCollectionsCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return requestAnyCuisines(cuisinesRepository, UseCasesKt$requestCollectionsCuisines$1.INSTANCE, UseCasesKt$requestCollectionsCuisines$2.INSTANCE);
    }

    public static /* synthetic */ List requestCollectionsCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return requestCollectionsCuisines(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestCollectionsCuisinesWithMultipleSelection(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return requestAnyCuisinesWithMultipleSelection(cuisinesRepository, UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$1.INSTANCE, UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$2.INSTANCE);
    }

    public static /* synthetic */ List requestCollectionsCuisinesWithMultipleSelection$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return requestCollectionsCuisinesWithMultipleSelection(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestCuisines(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return requestAnyCuisines(cuisinesRepository, UseCasesKt$requestCuisines$1.INSTANCE, UseCasesKt$requestCuisines$2.INSTANCE);
    }

    public static /* synthetic */ List requestCuisines$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return requestCuisines(cuisinesRepository);
    }

    @Nullable
    @BusinessRule
    public static final List<SelectableCuisine> requestCuisinesWithMultipleSelection(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        return requestAnyCuisinesWithMultipleSelection(cuisinesRepository, UseCasesKt$requestCuisinesWithMultipleSelection$1.INSTANCE, UseCasesKt$requestCuisinesWithMultipleSelection$2.INSTANCE);
    }

    public static /* synthetic */ List requestCuisinesWithMultipleSelection$default(CuisinesRepository cuisinesRepository, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cuisinesRepository = CuisinesIntegratorKt.getRepository();
        }
        return requestCuisinesWithMultipleSelection(cuisinesRepository);
    }

    private static final void updateSelectionStatus(List<SelectableCuisine> list, CuisinesRepository cuisinesRepository, Function1<? super CuisinesRepository, ? extends Cuisine> function1) {
        for (SelectableCuisine next : list) {
            Cuisine cuisine = (Cuisine) function1.invoke(cuisinesRepository);
            boolean z11 = false;
            if (cuisine != null && cuisine.f13848id == next.getCuisine().f13848id) {
                z11 = true;
            }
            next.setOn(z11);
        }
    }

    private static final void updateSelectionStatusFromList(List<SelectableCuisine> list, CuisinesRepository cuisinesRepository, Function1<? super CuisinesRepository, ? extends List<? extends Cuisine>> function1) {
        boolean z11;
        for (SelectableCuisine next : list) {
            List list2 = (List) function1.invoke(cuisinesRepository);
            boolean z12 = false;
            if (list2 != null) {
                Iterable iterable = list2;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((Cuisine) it.next()).f13848id == next.getCuisine().f13848id) {
                                z11 = true;
                                continue;
                            } else {
                                z11 = false;
                                continue;
                            }
                            if (z11) {
                                z12 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            next.setOn(z12);
        }
    }
}
