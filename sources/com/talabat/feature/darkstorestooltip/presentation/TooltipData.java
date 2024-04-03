package com.talabat.feature.darkstorestooltip.presentation;

import android.view.View;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;", "", "key", "Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "anchor", "Landroid/view/View;", "message", "", "dismissOnTimeout", "", "timeoutDurationSeconds", "", "showStrategy", "Lcom/talabat/feature/darkstorestooltip/presentation/ShowStrategy;", "(Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;Landroid/view/View;Ljava/lang/String;ZJLcom/talabat/feature/darkstorestooltip/presentation/ShowStrategy;)V", "getAnchor", "()Landroid/view/View;", "getDismissOnTimeout", "()Z", "getKey", "()Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "getMessage", "()Ljava/lang/String;", "getShowStrategy", "()Lcom/talabat/feature/darkstorestooltip/presentation/ShowStrategy;", "getTimeoutDurationSeconds", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TooltipData {
    @NotNull
    private final View anchor;
    private final boolean dismissOnTimeout;
    @NotNull
    private final TooltipKey key;
    @NotNull
    private final String message;
    @NotNull
    private final ShowStrategy showStrategy;
    private final long timeoutDurationSeconds;

    public TooltipData(@NotNull TooltipKey tooltipKey, @NotNull View view, @NotNull String str, boolean z11, long j11, @NotNull ShowStrategy showStrategy2) {
        Intrinsics.checkNotNullParameter(tooltipKey, "key");
        Intrinsics.checkNotNullParameter(view, Param.ANCHOR);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(showStrategy2, "showStrategy");
        this.key = tooltipKey;
        this.anchor = view;
        this.message = str;
        this.dismissOnTimeout = z11;
        this.timeoutDurationSeconds = j11;
        this.showStrategy = showStrategy2;
    }

    public static /* synthetic */ TooltipData copy$default(TooltipData tooltipData, TooltipKey tooltipKey, View view, String str, boolean z11, long j11, ShowStrategy showStrategy2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            tooltipKey = tooltipData.key;
        }
        if ((i11 & 2) != 0) {
            view = tooltipData.anchor;
        }
        View view2 = view;
        if ((i11 & 4) != 0) {
            str = tooltipData.message;
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            z11 = tooltipData.dismissOnTimeout;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            j11 = tooltipData.timeoutDurationSeconds;
        }
        long j12 = j11;
        if ((i11 & 32) != 0) {
            showStrategy2 = tooltipData.showStrategy;
        }
        return tooltipData.copy(tooltipKey, view2, str2, z12, j12, showStrategy2);
    }

    @NotNull
    public final TooltipKey component1() {
        return this.key;
    }

    @NotNull
    public final View component2() {
        return this.anchor;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    public final boolean component4() {
        return this.dismissOnTimeout;
    }

    public final long component5() {
        return this.timeoutDurationSeconds;
    }

    @NotNull
    public final ShowStrategy component6() {
        return this.showStrategy;
    }

    @NotNull
    public final TooltipData copy(@NotNull TooltipKey tooltipKey, @NotNull View view, @NotNull String str, boolean z11, long j11, @NotNull ShowStrategy showStrategy2) {
        Intrinsics.checkNotNullParameter(tooltipKey, "key");
        Intrinsics.checkNotNullParameter(view, Param.ANCHOR);
        Intrinsics.checkNotNullParameter(str, "message");
        ShowStrategy showStrategy3 = showStrategy2;
        Intrinsics.checkNotNullParameter(showStrategy3, "showStrategy");
        return new TooltipData(tooltipKey, view, str, z11, j11, showStrategy3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TooltipData)) {
            return false;
        }
        TooltipData tooltipData = (TooltipData) obj;
        return this.key == tooltipData.key && Intrinsics.areEqual((Object) this.anchor, (Object) tooltipData.anchor) && Intrinsics.areEqual((Object) this.message, (Object) tooltipData.message) && this.dismissOnTimeout == tooltipData.dismissOnTimeout && this.timeoutDurationSeconds == tooltipData.timeoutDurationSeconds && this.showStrategy == tooltipData.showStrategy;
    }

    @NotNull
    public final View getAnchor() {
        return this.anchor;
    }

    public final boolean getDismissOnTimeout() {
        return this.dismissOnTimeout;
    }

    @NotNull
    public final TooltipKey getKey() {
        return this.key;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final ShowStrategy getShowStrategy() {
        return this.showStrategy;
    }

    public final long getTimeoutDurationSeconds() {
        return this.timeoutDurationSeconds;
    }

    public int hashCode() {
        int hashCode = ((((this.key.hashCode() * 31) + this.anchor.hashCode()) * 31) + this.message.hashCode()) * 31;
        boolean z11 = this.dismissOnTimeout;
        if (z11) {
            z11 = true;
        }
        return ((((hashCode + (z11 ? 1 : 0)) * 31) + a.a(this.timeoutDurationSeconds)) * 31) + this.showStrategy.hashCode();
    }

    @NotNull
    public String toString() {
        TooltipKey tooltipKey = this.key;
        View view = this.anchor;
        String str = this.message;
        boolean z11 = this.dismissOnTimeout;
        long j11 = this.timeoutDurationSeconds;
        ShowStrategy showStrategy2 = this.showStrategy;
        return "TooltipData(key=" + tooltipKey + ", anchor=" + view + ", message=" + str + ", dismissOnTimeout=" + z11 + ", timeoutDurationSeconds=" + j11 + ", showStrategy=" + showStrategy2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TooltipData(TooltipKey tooltipKey, View view, String str, boolean z11, long j11, ShowStrategy showStrategy2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(tooltipKey, view, str, (i11 & 8) != 0 ? true : z11, (i11 & 16) != 0 ? 5 : j11, showStrategy2);
    }
}
