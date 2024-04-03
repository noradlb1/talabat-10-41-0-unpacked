package com.designsystem.ds_toast;

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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/designsystem/ds_toast/DSToastModel;", "", "label", "", "leadingIcon", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getLeadingIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "onActionLabel", "getOnActionLabel$marshmallow_release", "setOnActionLabel$marshmallow_release", "(Ljava/lang/String;)V", "onActionTap", "Lkotlin/Function0;", "", "getOnActionTap$marshmallow_release", "()Lkotlin/jvm/functions/Function0;", "setOnActionTap$marshmallow_release", "(Lkotlin/jvm/functions/Function0;)V", "onTrailingIconTap", "getOnTrailingIconTap$marshmallow_release", "setOnTrailingIconTap$marshmallow_release", "trailingIcon", "getTrailingIcon$marshmallow_release", "setTrailingIcon$marshmallow_release", "(Ljava/lang/Integer;)V", "hasAction", "", "hasAction$marshmallow_release", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSToastModel {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String label;
    @Nullable
    private final Integer leadingIcon;
    @Nullable
    private String onActionLabel;
    @Nullable
    private Function0<Unit> onActionTap;
    @Nullable
    private Function0<Unit> onTrailingIconTap;
    @Nullable
    @DrawableRes
    private Integer trailingIcon;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/designsystem/ds_toast/DSToastModel$Companion;", "", "()V", "withActionButton", "Lcom/designsystem/ds_toast/DSToastModel;", "label", "", "leadingIcon", "", "onActionTap", "Lkotlin/Function0;", "", "onActionLabel", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)Lcom/designsystem/ds_toast/DSToastModel;", "withIconButton", "onTrailingIconTap", "trailingIcon", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;I)Lcom/designsystem/ds_toast/DSToastModel;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DSToastModel withActionButton(@NotNull String str, @Nullable @DrawableRes Integer num, @NotNull Function0<Unit> function0, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "label");
            Intrinsics.checkNotNullParameter(function0, "onActionTap");
            Intrinsics.checkNotNullParameter(str2, "onActionLabel");
            DSToastModel dSToastModel = new DSToastModel(str, num);
            dSToastModel.setOnActionLabel$marshmallow_release(str2);
            dSToastModel.setOnActionTap$marshmallow_release(function0);
            return dSToastModel;
        }

        @NotNull
        public final DSToastModel withIconButton(@NotNull String str, @Nullable @DrawableRes Integer num, @NotNull Function0<Unit> function0, @DrawableRes int i11) {
            Intrinsics.checkNotNullParameter(str, "label");
            Intrinsics.checkNotNullParameter(function0, "onTrailingIconTap");
            DSToastModel dSToastModel = new DSToastModel(str, num);
            dSToastModel.setOnTrailingIconTap$marshmallow_release(function0);
            dSToastModel.setTrailingIcon$marshmallow_release(Integer.valueOf(i11));
            return dSToastModel;
        }
    }

    public DSToastModel(@NotNull String str, @Nullable @DrawableRes Integer num) {
        Intrinsics.checkNotNullParameter(str, "label");
        this.label = str;
        this.leadingIcon = num;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Integer getLeadingIcon() {
        return this.leadingIcon;
    }

    @Nullable
    public final String getOnActionLabel$marshmallow_release() {
        return this.onActionLabel;
    }

    @Nullable
    public final Function0<Unit> getOnActionTap$marshmallow_release() {
        return this.onActionTap;
    }

    @Nullable
    public final Function0<Unit> getOnTrailingIconTap$marshmallow_release() {
        return this.onTrailingIconTap;
    }

    @Nullable
    public final Integer getTrailingIcon$marshmallow_release() {
        return this.trailingIcon;
    }

    public final boolean hasAction$marshmallow_release() {
        return (this.onActionTap == null && this.onTrailingIconTap == null) ? false : true;
    }

    public final void setOnActionLabel$marshmallow_release(@Nullable String str) {
        this.onActionLabel = str;
    }

    public final void setOnActionTap$marshmallow_release(@Nullable Function0<Unit> function0) {
        this.onActionTap = function0;
    }

    public final void setOnTrailingIconTap$marshmallow_release(@Nullable Function0<Unit> function0) {
        this.onTrailingIconTap = function0;
    }

    public final void setTrailingIcon$marshmallow_release(@Nullable Integer num) {
        this.trailingIcon = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSToastModel(String str, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num);
    }
}
