package com.designsystem.marshmallow.viewsentity.gridview;

import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/designsystem/marshmallow/viewsentity/gridview/GridItemViewEntity;", "", "imageUrl", "", "itemName", "itemBackGroundHexa", "onItemClick", "Lkotlin/Function0;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getImageUrl", "()Ljava/lang/String;", "getItemBackGroundHexa", "getItemName", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This model is no longer part of the Design System")
public final class GridItemViewEntity {
    public static final int $stable = 0;
    @NotNull
    private final String imageUrl;
    @NotNull
    private final String itemBackGroundHexa;
    @NotNull
    private final String itemName;
    @NotNull
    private final Function0<Unit> onItemClick;

    public GridItemViewEntity(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, "itemName");
        Intrinsics.checkNotNullParameter(str3, "itemBackGroundHexa");
        Intrinsics.checkNotNullParameter(function0, "onItemClick");
        this.imageUrl = str;
        this.itemName = str2;
        this.itemBackGroundHexa = str3;
        this.onItemClick = function0;
    }

    public static /* synthetic */ GridItemViewEntity copy$default(GridItemViewEntity gridItemViewEntity, String str, String str2, String str3, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = gridItemViewEntity.imageUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = gridItemViewEntity.itemName;
        }
        if ((i11 & 4) != 0) {
            str3 = gridItemViewEntity.itemBackGroundHexa;
        }
        if ((i11 & 8) != 0) {
            function0 = gridItemViewEntity.onItemClick;
        }
        return gridItemViewEntity.copy(str, str2, str3, function0);
    }

    @NotNull
    public final String component1() {
        return this.imageUrl;
    }

    @NotNull
    public final String component2() {
        return this.itemName;
    }

    @NotNull
    public final String component3() {
        return this.itemBackGroundHexa;
    }

    @NotNull
    public final Function0<Unit> component4() {
        return this.onItemClick;
    }

    @NotNull
    public final GridItemViewEntity copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, "itemName");
        Intrinsics.checkNotNullParameter(str3, "itemBackGroundHexa");
        Intrinsics.checkNotNullParameter(function0, "onItemClick");
        return new GridItemViewEntity(str, str2, str3, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GridItemViewEntity)) {
            return false;
        }
        GridItemViewEntity gridItemViewEntity = (GridItemViewEntity) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) gridItemViewEntity.imageUrl) && Intrinsics.areEqual((Object) this.itemName, (Object) gridItemViewEntity.itemName) && Intrinsics.areEqual((Object) this.itemBackGroundHexa, (Object) gridItemViewEntity.itemBackGroundHexa) && Intrinsics.areEqual((Object) this.onItemClick, (Object) gridItemViewEntity.onItemClick);
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getItemBackGroundHexa() {
        return this.itemBackGroundHexa;
    }

    @NotNull
    public final String getItemName() {
        return this.itemName;
    }

    @NotNull
    public final Function0<Unit> getOnItemClick() {
        return this.onItemClick;
    }

    public int hashCode() {
        return (((((this.imageUrl.hashCode() * 31) + this.itemName.hashCode()) * 31) + this.itemBackGroundHexa.hashCode()) * 31) + this.onItemClick.hashCode();
    }

    @NotNull
    public String toString() {
        return "GridItemViewEntity(imageUrl=" + this.imageUrl + ", itemName=" + this.itemName + ", itemBackGroundHexa=" + this.itemBackGroundHexa + ", onItemClick=" + this.onItemClick + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridItemViewEntity(String str, String str2, String str3, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? "#FFCFAA" : str3, function0);
    }
}
