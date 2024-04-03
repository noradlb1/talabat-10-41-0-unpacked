package com.talabat.cuisines.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/talabat/cuisines/presentation/ItemContainer;", "", "item", "(Ljava/lang/Object;)V", "getItem", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemContainer {
    @NotNull
    private final Object item;

    public ItemContainer(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        this.item = obj;
    }

    public static /* synthetic */ ItemContainer copy$default(ItemContainer itemContainer, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = itemContainer.item;
        }
        return itemContainer.copy(obj);
    }

    @NotNull
    public final Object component1() {
        return this.item;
    }

    @NotNull
    public final ItemContainer copy(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        return new ItemContainer(obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ItemContainer) && Intrinsics.areEqual(this.item, ((ItemContainer) obj).item);
    }

    @NotNull
    public final Object getItem() {
        return this.item;
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    @NotNull
    public String toString() {
        Object obj = this.item;
        return "ItemContainer(item=" + obj + ")";
    }
}
