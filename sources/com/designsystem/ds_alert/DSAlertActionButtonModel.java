package com.designsystem.ds_alert;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_alert/DSAlertActionButtonModel;", "", "text", "", "onTap", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSAlertActionButtonModel {
    public static final int $stable = 0;
    @NotNull
    private final Function0<Unit> onTap;
    @NotNull
    private final String text;

    public DSAlertActionButtonModel(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        this.text = str;
        this.onTap = function0;
    }

    public static /* synthetic */ DSAlertActionButtonModel copy$default(DSAlertActionButtonModel dSAlertActionButtonModel, String str, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSAlertActionButtonModel.text;
        }
        if ((i11 & 2) != 0) {
            function0 = dSAlertActionButtonModel.onTap;
        }
        return dSAlertActionButtonModel.copy(str, function0);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onTap;
    }

    @NotNull
    public final DSAlertActionButtonModel copy(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        return new DSAlertActionButtonModel(str, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSAlertActionButtonModel)) {
            return false;
        }
        DSAlertActionButtonModel dSAlertActionButtonModel = (DSAlertActionButtonModel) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) dSAlertActionButtonModel.text) && Intrinsics.areEqual((Object) this.onTap, (Object) dSAlertActionButtonModel.onTap);
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return this.onTap;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.onTap.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSAlertActionButtonModel(text=" + this.text + ", onTap=" + this.onTap + ')';
    }
}
