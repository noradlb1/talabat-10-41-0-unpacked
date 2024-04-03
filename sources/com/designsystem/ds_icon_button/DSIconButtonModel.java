package com.designsystem.ds_icon_button;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "", "icon", "", "onTap", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getIcon", "()I", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSIconButtonModel {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int icon;
    @NotNull
    private final Function0<Unit> onTap;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_icon_button/DSIconButtonModel$Companion;", "", "()V", "empty", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DSIconButtonModel empty() {
            return new DSIconButtonModel(-1, DSIconButtonModel$Companion$empty$1.INSTANCE);
        }
    }

    public DSIconButtonModel(@DrawableRes int i11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onTap");
        this.icon = i11;
        this.onTap = function0;
    }

    public static /* synthetic */ DSIconButtonModel copy$default(DSIconButtonModel dSIconButtonModel, int i11, Function0<Unit> function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = dSIconButtonModel.icon;
        }
        if ((i12 & 2) != 0) {
            function0 = dSIconButtonModel.onTap;
        }
        return dSIconButtonModel.copy(i11, function0);
    }

    public final int component1() {
        return this.icon;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onTap;
    }

    @NotNull
    public final DSIconButtonModel copy(@DrawableRes int i11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onTap");
        return new DSIconButtonModel(i11, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSIconButtonModel)) {
            return false;
        }
        DSIconButtonModel dSIconButtonModel = (DSIconButtonModel) obj;
        return this.icon == dSIconButtonModel.icon && Intrinsics.areEqual((Object) this.onTap, (Object) dSIconButtonModel.onTap);
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return this.onTap;
    }

    public int hashCode() {
        return (this.icon * 31) + this.onTap.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSIconButtonModel(icon=" + this.icon + ", onTap=" + this.onTap + ')';
    }
}
