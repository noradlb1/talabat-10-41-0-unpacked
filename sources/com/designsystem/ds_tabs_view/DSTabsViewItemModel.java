package com.designsystem.ds_tabs_view;

import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.ds_tabs.DSTabItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSTabsViewItemModel;", "T", "", "tabModel", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "contentModel", "(Lcom/designsystem/ds_tabs/DSTabItemModel;Ljava/lang/Object;)V", "getContentModel", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTabModel", "()Lcom/designsystem/ds_tabs/DSTabItemModel;", "component1", "component2", "copy", "(Lcom/designsystem/ds_tabs/DSTabItemModel;Ljava/lang/Object;)Lcom/designsystem/ds_tabs_view/DSTabsViewItemModel;", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTabsViewItemModel<T> {
    public static final int $stable = 0;
    private final T contentModel;
    @NotNull
    private final DSTabItemModel tabModel;

    public DSTabsViewItemModel(@NotNull DSTabItemModel dSTabItemModel, T t11) {
        Intrinsics.checkNotNullParameter(dSTabItemModel, "tabModel");
        this.tabModel = dSTabItemModel;
        this.contentModel = t11;
    }

    public static /* synthetic */ DSTabsViewItemModel copy$default(DSTabsViewItemModel dSTabsViewItemModel, DSTabItemModel dSTabItemModel, T t11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dSTabItemModel = dSTabsViewItemModel.tabModel;
        }
        if ((i11 & 2) != 0) {
            t11 = dSTabsViewItemModel.contentModel;
        }
        return dSTabsViewItemModel.copy(dSTabItemModel, t11);
    }

    @NotNull
    public final DSTabItemModel component1() {
        return this.tabModel;
    }

    public final T component2() {
        return this.contentModel;
    }

    @NotNull
    public final DSTabsViewItemModel<T> copy(@NotNull DSTabItemModel dSTabItemModel, T t11) {
        Intrinsics.checkNotNullParameter(dSTabItemModel, "tabModel");
        return new DSTabsViewItemModel<>(dSTabItemModel, t11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSTabsViewItemModel)) {
            return false;
        }
        DSTabsViewItemModel dSTabsViewItemModel = (DSTabsViewItemModel) obj;
        return Intrinsics.areEqual((Object) this.tabModel, (Object) dSTabsViewItemModel.tabModel) && Intrinsics.areEqual((Object) this.contentModel, (Object) dSTabsViewItemModel.contentModel);
    }

    public final T getContentModel() {
        return this.contentModel;
    }

    @NotNull
    public final DSTabItemModel getTabModel() {
        return this.tabModel;
    }

    public int hashCode() {
        int hashCode = this.tabModel.hashCode() * 31;
        T t11 = this.contentModel;
        return hashCode + (t11 == null ? 0 : t11.hashCode());
    }

    @NotNull
    public String toString() {
        return "DSTabsViewItemModel(tabModel=" + this.tabModel + ", contentModel=" + this.contentModel + ')';
    }
}
