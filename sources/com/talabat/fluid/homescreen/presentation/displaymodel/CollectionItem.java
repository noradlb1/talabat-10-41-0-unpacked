package com.talabat.fluid.homescreen.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/CollectionItem;", "", "deepLink", "", "verticalId", "", "(Ljava/lang/String;I)V", "getDeepLink", "()Ljava/lang/String;", "getVerticalId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionItem {
    @NotNull
    private final String deepLink;
    private final int verticalId;

    public CollectionItem(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "deepLink");
        this.deepLink = str;
        this.verticalId = i11;
    }

    public static /* synthetic */ CollectionItem copy$default(CollectionItem collectionItem, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = collectionItem.deepLink;
        }
        if ((i12 & 2) != 0) {
            i11 = collectionItem.verticalId;
        }
        return collectionItem.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.deepLink;
    }

    public final int component2() {
        return this.verticalId;
    }

    @NotNull
    public final CollectionItem copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "deepLink");
        return new CollectionItem(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionItem)) {
            return false;
        }
        CollectionItem collectionItem = (CollectionItem) obj;
        return Intrinsics.areEqual((Object) this.deepLink, (Object) collectionItem.deepLink) && this.verticalId == collectionItem.verticalId;
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    public final int getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        return (this.deepLink.hashCode() * 31) + this.verticalId;
    }

    @NotNull
    public String toString() {
        String str = this.deepLink;
        int i11 = this.verticalId;
        return "CollectionItem(deepLink=" + str + ", verticalId=" + i11 + ")";
    }
}
