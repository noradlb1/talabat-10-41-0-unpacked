package com.designsystem.ds_bottom_navigation_bar;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "", "title", "", "icon", "", "animatedIcon", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAnimatedIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "equals", "", "other", "hashCode", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBarItem {
    public static final int $stable = 0;
    @Nullable
    private final Integer animatedIcon;
    @Nullable
    private final Integer icon;
    @NotNull
    private final String title;

    public DSBottomNavigationBarItem(@NotNull String str, @Nullable @DrawableRes Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.icon = num;
        this.animatedIcon = num2;
    }

    public static /* synthetic */ DSBottomNavigationBarItem copy$default(DSBottomNavigationBarItem dSBottomNavigationBarItem, String str, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSBottomNavigationBarItem.title;
        }
        if ((i11 & 2) != 0) {
            num = dSBottomNavigationBarItem.icon;
        }
        if ((i11 & 4) != 0) {
            num2 = dSBottomNavigationBarItem.animatedIcon;
        }
        return dSBottomNavigationBarItem.copy(str, num, num2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Integer component2() {
        return this.icon;
    }

    @Nullable
    public final Integer component3() {
        return this.animatedIcon;
    }

    @NotNull
    public final DSBottomNavigationBarItem copy(@NotNull String str, @Nullable @DrawableRes Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new DSBottomNavigationBarItem(str, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSBottomNavigationBarItem)) {
            return false;
        }
        DSBottomNavigationBarItem dSBottomNavigationBarItem = (DSBottomNavigationBarItem) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) dSBottomNavigationBarItem.title) && Intrinsics.areEqual((Object) this.icon, (Object) dSBottomNavigationBarItem.icon) && Intrinsics.areEqual((Object) this.animatedIcon, (Object) dSBottomNavigationBarItem.animatedIcon);
    }

    @Nullable
    public final Integer getAnimatedIcon() {
        return this.animatedIcon;
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        Integer num = this.icon;
        int i11 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.animatedIcon;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "DSBottomNavigationBarItem(title=" + this.title + ", icon=" + this.icon + ", animatedIcon=" + this.animatedIcon + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBottomNavigationBarItem(String str, Integer num, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : num2);
    }
}
