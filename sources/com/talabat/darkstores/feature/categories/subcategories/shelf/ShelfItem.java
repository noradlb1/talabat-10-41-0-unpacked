package com.talabat.darkstores.feature.categories.subcategories.shelf;

import com.talabat.talabatcommon.optional.Optional;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nHÂ\u0003JM\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "", "name", "", "url", "color", "isSelected", "Lio/reactivex/Observable;", "", "selectedItem", "Lio/reactivex/Observer;", "Lcom/talabat/talabatcommon/optional/Optional;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/reactivex/Observable;Lio/reactivex/Observer;)V", "getColor", "()Ljava/lang/String;", "()Lio/reactivex/Observable;", "getName", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "onClick", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShelfItem {
    @NotNull
    private final String color;
    @NotNull
    private final Observable<Boolean> isSelected;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56365name;
    @NotNull
    private final Observer<Optional<String>> selectedItem;
    @NotNull
    private final String url;

    public ShelfItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Observable<Boolean> observable, @NotNull Observer<Optional<String>> observer) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "color");
        Intrinsics.checkNotNullParameter(observable, "isSelected");
        Intrinsics.checkNotNullParameter(observer, "selectedItem");
        this.f56365name = str;
        this.url = str2;
        this.color = str3;
        this.isSelected = observable;
        this.selectedItem = observer;
    }

    private final Observer<Optional<String>> component5() {
        return this.selectedItem;
    }

    public static /* synthetic */ ShelfItem copy$default(ShelfItem shelfItem, String str, String str2, String str3, Observable<Boolean> observable, Observer<Optional<String>> observer, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = shelfItem.f56365name;
        }
        if ((i11 & 2) != 0) {
            str2 = shelfItem.url;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = shelfItem.color;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            observable = shelfItem.isSelected;
        }
        Observable<Boolean> observable2 = observable;
        if ((i11 & 16) != 0) {
            observer = shelfItem.selectedItem;
        }
        return shelfItem.copy(str, str4, str5, observable2, observer);
    }

    @NotNull
    public final String component1() {
        return this.f56365name;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.color;
    }

    @NotNull
    public final Observable<Boolean> component4() {
        return this.isSelected;
    }

    @NotNull
    public final ShelfItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Observable<Boolean> observable, @NotNull Observer<Optional<String>> observer) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "color");
        Intrinsics.checkNotNullParameter(observable, "isSelected");
        Intrinsics.checkNotNullParameter(observer, "selectedItem");
        return new ShelfItem(str, str2, str3, observable, observer);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShelfItem)) {
            return false;
        }
        ShelfItem shelfItem = (ShelfItem) obj;
        return Intrinsics.areEqual((Object) this.f56365name, (Object) shelfItem.f56365name) && Intrinsics.areEqual((Object) this.url, (Object) shelfItem.url) && Intrinsics.areEqual((Object) this.color, (Object) shelfItem.color) && Intrinsics.areEqual((Object) this.isSelected, (Object) shelfItem.isSelected) && Intrinsics.areEqual((Object) this.selectedItem, (Object) shelfItem.selectedItem);
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    @NotNull
    public final String getName() {
        return this.f56365name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.f56365name.hashCode() * 31) + this.url.hashCode()) * 31) + this.color.hashCode()) * 31) + this.isSelected.hashCode()) * 31) + this.selectedItem.hashCode();
    }

    @NotNull
    public final Observable<Boolean> isSelected() {
        return this.isSelected;
    }

    public final void onClick() {
        this.selectedItem.onNext(new Optional.Some(this.f56365name));
    }

    @NotNull
    public String toString() {
        String str = this.f56365name;
        String str2 = this.url;
        String str3 = this.color;
        Observable<Boolean> observable = this.isSelected;
        Observer<Optional<String>> observer = this.selectedItem;
        return "ShelfItem(name=" + str + ", url=" + str2 + ", color=" + str3 + ", isSelected=" + observable + ", selectedItem=" + observer + ")";
    }
}
