package com.talabat.restaurants.v2.ui;

import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002BY\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\b\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J!\u0010\u0013\u001a\u0004\u0018\u00010\f*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u001a\u0010\u0018\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\fH\u0002J!\u0010\u001a\u001a\u0004\u0018\u00010\f*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0015R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\b\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/restaurants/v2/ui/NonRestaurantItemsAppender;", "T", "Lio/reactivex/functions/Function;", "", "Ldatamodels/RestaurantListItemModel;", "itemsRetriever", "", "isValidItem", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "position", "", "listItemFactory", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "apply", "allItems", "nextIndex", "index", "append", "item", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Integer;", "isInsertNextIndexAvailable", "lastRestaurantBeforeItemIndex", "isInsertPreviousIndexAvailable", "firstRestaurantIndex", "startWith", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppender<T> implements Function<List<RestaurantListItemModel>, List<RestaurantListItemModel>> {
    @NotNull
    private final Function1<T, Boolean> isValidItem;
    @NotNull
    private final List<T> itemsRetriever;
    @NotNull
    private final Function1<T, RestaurantListItemModel> listItemFactory;
    @NotNull
    private final Function1<T, Integer> position;

    public NonRestaurantItemsAppender(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1, @NotNull Function1<? super T, Integer> function12, @NotNull Function1<? super T, ? extends RestaurantListItemModel> function13) {
        Intrinsics.checkNotNullParameter(list, "itemsRetriever");
        Intrinsics.checkNotNullParameter(function1, "isValidItem");
        Intrinsics.checkNotNullParameter(function12, "position");
        Intrinsics.checkNotNullParameter(function13, "listItemFactory");
        this.itemsRetriever = list;
        this.isValidItem = function1;
        this.position = function12;
        this.listItemFactory = function13;
    }

    private final Integer append(List<RestaurantListItemModel> list, T t11) {
        Integer num;
        Object obj;
        int i11;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((RestaurantListItemModel) next).type != 2) {
                z12 = false;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            num = null;
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            Restaurant restaurant = ((RestaurantListItemModel) obj).restaurant;
            if (restaurant != null) {
                i11 = restaurant.itemPosition;
            } else {
                i11 = 0;
            }
            if (i11 == this.position.invoke(t11).intValue()) {
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
        RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) obj;
        if (restaurantListItemModel != null) {
            num = Integer.valueOf(list.lastIndexOf(restaurantListItemModel));
            int intValue = num.intValue();
            if (isInsertNextIndexAvailable(list, intValue)) {
                list.add(nextIndex(intValue), this.listItemFactory.invoke(t11));
            } else {
                list.add(this.listItemFactory.invoke(t11));
            }
        }
        return num;
    }

    private final boolean isInsertNextIndexAvailable(List<RestaurantListItemModel> list, int i11) {
        return i11 != -1 && list.size() > i11 + 1;
    }

    private final boolean isInsertPreviousIndexAvailable(List<RestaurantListItemModel> list, int i11) {
        return i11 != -1 && !list.isEmpty();
    }

    private final int nextIndex(int i11) {
        return i11 + 1;
    }

    private final Integer startWith(List<RestaurantListItemModel> list, T t11) {
        Object obj;
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((RestaurantListItemModel) next).type == 2) {
                z11 = true;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        Integer num = null;
        if (!it2.hasNext()) {
            obj = null;
        } else {
            obj = it2.next();
            if (it2.hasNext()) {
                Restaurant restaurant = ((RestaurantListItemModel) obj).restaurant;
                if (restaurant != null) {
                    i11 = restaurant.itemPosition;
                } else {
                    i11 = 0;
                }
                do {
                    Object next2 = it2.next();
                    Restaurant restaurant2 = ((RestaurantListItemModel) next2).restaurant;
                    if (restaurant2 != null) {
                        i12 = restaurant2.itemPosition;
                    } else {
                        i12 = 0;
                    }
                    if (i11 > i12) {
                        obj = next2;
                        i11 = i12;
                    }
                } while (it2.hasNext());
            }
        }
        RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) obj;
        if (restaurantListItemModel != null) {
            num = Integer.valueOf(list.indexOf(restaurantListItemModel));
            if (isInsertPreviousIndexAvailable(list, num.intValue())) {
                list.add(0, this.listItemFactory.invoke(t11));
            }
        }
        return num;
    }

    @NotNull
    public List<RestaurantListItemModel> apply(@NotNull List<RestaurantListItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "allItems");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.itemsRetriever) {
            if (this.isValidItem.invoke(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        for (Object next2 : CollectionsKt___CollectionsKt.sortedWith(arrayList, new NonRestaurantItemsAppender$apply$$inlined$sortedBy$1(this.position))) {
            if (this.position.invoke(next2).intValue() == 0) {
                startWith(list, next2);
            } else {
                append(list, next2);
            }
        }
        Unit unit = Unit.INSTANCE;
        return list;
    }
}
