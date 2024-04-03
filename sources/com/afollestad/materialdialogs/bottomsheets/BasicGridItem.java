package com.afollestad.materialdialogs.bottomsheets;

import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/BasicGridItem;", "Lcom/afollestad/materialdialogs/bottomsheets/GridItem;", "iconRes", "", "title", "", "(ILjava/lang/String;)V", "getIconRes", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "populateIcon", "", "imageView", "Landroid/widget/ImageView;", "toString", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class BasicGridItem implements GridItem {
    private final int iconRes;
    @NotNull
    private final String title;

    public BasicGridItem(@DrawableRes int i11, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        this.iconRes = i11;
        this.title = str;
    }

    public static /* synthetic */ BasicGridItem copy$default(BasicGridItem basicGridItem, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = basicGridItem.iconRes;
        }
        if ((i12 & 2) != 0) {
            str = basicGridItem.getTitle();
        }
        return basicGridItem.copy(i11, str);
    }

    public final int component1() {
        return this.iconRes;
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @NotNull
    public final BasicGridItem copy(@DrawableRes int i11, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        return new BasicGridItem(i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BasicGridItem) {
                BasicGridItem basicGridItem = (BasicGridItem) obj;
                if (!(this.iconRes == basicGridItem.iconRes) || !Intrinsics.areEqual((Object) getTitle(), (Object) basicGridItem.getTitle())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = this.iconRes * 31;
        String title2 = getTitle();
        return i11 + (title2 != null ? title2.hashCode() : 0);
    }

    public void populateIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        imageView.setImageResource(this.iconRes);
    }

    @NotNull
    public String toString() {
        return "BasicGridItem(iconRes=" + this.iconRes + ", title=" + getTitle() + ")";
    }
}
