package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "", "showSubscribeButton", "", "onTproSubscriptionClicked", "Lkotlin/Function0;", "", "(ZLkotlin/jvm/functions/Function0;)V", "getOnTproSubscriptionClicked", "()Lkotlin/jvm/functions/Function0;", "getShowSubscribeButton", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproSubscriptionInfoData {
    @NotNull
    private final Function0<Unit> onTproSubscriptionClicked;
    private final boolean showSubscribeButton;

    public TproSubscriptionInfoData(boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onTproSubscriptionClicked");
        this.showSubscribeButton = z11;
        this.onTproSubscriptionClicked = function0;
    }

    public static /* synthetic */ TproSubscriptionInfoData copy$default(TproSubscriptionInfoData tproSubscriptionInfoData, boolean z11, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = tproSubscriptionInfoData.showSubscribeButton;
        }
        if ((i11 & 2) != 0) {
            function0 = tproSubscriptionInfoData.onTproSubscriptionClicked;
        }
        return tproSubscriptionInfoData.copy(z11, function0);
    }

    public final boolean component1() {
        return this.showSubscribeButton;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onTproSubscriptionClicked;
    }

    @NotNull
    public final TproSubscriptionInfoData copy(boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onTproSubscriptionClicked");
        return new TproSubscriptionInfoData(z11, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TproSubscriptionInfoData)) {
            return false;
        }
        TproSubscriptionInfoData tproSubscriptionInfoData = (TproSubscriptionInfoData) obj;
        return this.showSubscribeButton == tproSubscriptionInfoData.showSubscribeButton && Intrinsics.areEqual((Object) this.onTproSubscriptionClicked, (Object) tproSubscriptionInfoData.onTproSubscriptionClicked);
    }

    @NotNull
    public final Function0<Unit> getOnTproSubscriptionClicked() {
        return this.onTproSubscriptionClicked;
    }

    public final boolean getShowSubscribeButton() {
        return this.showSubscribeButton;
    }

    public int hashCode() {
        boolean z11 = this.showSubscribeButton;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.onTproSubscriptionClicked.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.showSubscribeButton;
        Function0<Unit> function0 = this.onTproSubscriptionClicked;
        return "TproSubscriptionInfoData(showSubscribeButton=" + z11 + ", onTproSubscriptionClicked=" + function0 + ")";
    }
}
