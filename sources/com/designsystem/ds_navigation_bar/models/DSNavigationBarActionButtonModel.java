package com.designsystem.ds_navigation_bar.models;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;", "", "title", "", "onTap", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarActionButtonModel {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Function0<Unit> onTap;
    @NotNull
    private String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel$Companion;", "", "()V", "empty", "Lcom/designsystem/ds_navigation_bar/models/DSNavigationBarActionButtonModel;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DSNavigationBarActionButtonModel empty() {
            return new DSNavigationBarActionButtonModel("", DSNavigationBarActionButtonModel$Companion$empty$1.INSTANCE);
        }
    }

    public DSNavigationBarActionButtonModel(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        this.title = str;
        this.onTap = function0;
    }

    public static /* synthetic */ DSNavigationBarActionButtonModel copy$default(DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel, String str, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSNavigationBarActionButtonModel.title;
        }
        if ((i11 & 2) != 0) {
            function0 = dSNavigationBarActionButtonModel.onTap;
        }
        return dSNavigationBarActionButtonModel.copy(str, function0);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onTap;
    }

    @NotNull
    public final DSNavigationBarActionButtonModel copy(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        return new DSNavigationBarActionButtonModel(str, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSNavigationBarActionButtonModel)) {
            return false;
        }
        DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel = (DSNavigationBarActionButtonModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) dSNavigationBarActionButtonModel.title) && Intrinsics.areEqual((Object) this.onTap, (Object) dSNavigationBarActionButtonModel.onTap);
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return this.onTap;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.onTap.hashCode();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "DSNavigationBarActionButtonModel(title=" + this.title + ", onTap=" + this.onTap + ')';
    }
}
