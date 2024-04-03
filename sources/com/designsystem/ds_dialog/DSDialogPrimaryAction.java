package com.designsystem.ds_dialog;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;", "", "title", "", "onTap", "Lkotlin/Function0;", "", "type", "Lcom/designsystem/ds_dialog/DSDialogPrimaryActionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/designsystem/ds_dialog/DSDialogPrimaryActionType;)V", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "getType", "()Lcom/designsystem/ds_dialog/DSDialogPrimaryActionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDialogPrimaryAction {
    public static final int $stable = 0;
    @NotNull
    private final Function0<Unit> onTap;
    @NotNull
    private final String title;
    @NotNull
    private final DSDialogPrimaryActionType type;

    public DSDialogPrimaryAction(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull DSDialogPrimaryActionType dSDialogPrimaryActionType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Intrinsics.checkNotNullParameter(dSDialogPrimaryActionType, "type");
        this.title = str;
        this.onTap = function0;
        this.type = dSDialogPrimaryActionType;
    }

    public static /* synthetic */ DSDialogPrimaryAction copy$default(DSDialogPrimaryAction dSDialogPrimaryAction, String str, Function0<Unit> function0, DSDialogPrimaryActionType dSDialogPrimaryActionType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSDialogPrimaryAction.title;
        }
        if ((i11 & 2) != 0) {
            function0 = dSDialogPrimaryAction.onTap;
        }
        if ((i11 & 4) != 0) {
            dSDialogPrimaryActionType = dSDialogPrimaryAction.type;
        }
        return dSDialogPrimaryAction.copy(str, function0, dSDialogPrimaryActionType);
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
    public final DSDialogPrimaryActionType component3() {
        return this.type;
    }

    @NotNull
    public final DSDialogPrimaryAction copy(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull DSDialogPrimaryActionType dSDialogPrimaryActionType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Intrinsics.checkNotNullParameter(dSDialogPrimaryActionType, "type");
        return new DSDialogPrimaryAction(str, function0, dSDialogPrimaryActionType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSDialogPrimaryAction)) {
            return false;
        }
        DSDialogPrimaryAction dSDialogPrimaryAction = (DSDialogPrimaryAction) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) dSDialogPrimaryAction.title) && Intrinsics.areEqual((Object) this.onTap, (Object) dSDialogPrimaryAction.onTap) && this.type == dSDialogPrimaryAction.type;
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return this.onTap;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DSDialogPrimaryActionType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.onTap.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSDialogPrimaryAction(title=" + this.title + ", onTap=" + this.onTap + ", type=" + this.type + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSDialogPrimaryAction(String str, Function0 function0, DSDialogPrimaryActionType dSDialogPrimaryActionType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function0, (i11 & 4) != 0 ? DSDialogPrimaryActionType.NORMAL : dSDialogPrimaryActionType);
    }
}
