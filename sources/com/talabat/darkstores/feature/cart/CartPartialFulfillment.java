package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.partialFulfillment.model.Control;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartPartialFulfillment;", "", "name", "", "selectedControl", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "(Ljava/lang/String;Lcom/talabat/darkstores/data/partialFulfillment/model/Control;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSelectedControl", "()Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "setSelectedControl", "(Lcom/talabat/darkstores/data/partialFulfillment/model/Control;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartPartialFulfillment {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f56284name;
    @Nullable
    private Control selectedControl;

    public CartPartialFulfillment() {
        this((String) null, (Control) null, 3, (DefaultConstructorMarker) null);
    }

    public CartPartialFulfillment(@NotNull String str, @Nullable Control control) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f56284name = str;
        this.selectedControl = control;
    }

    public static /* synthetic */ CartPartialFulfillment copy$default(CartPartialFulfillment cartPartialFulfillment, String str, Control control, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartPartialFulfillment.f56284name;
        }
        if ((i11 & 2) != 0) {
            control = cartPartialFulfillment.selectedControl;
        }
        return cartPartialFulfillment.copy(str, control);
    }

    @NotNull
    public final String component1() {
        return this.f56284name;
    }

    @Nullable
    public final Control component2() {
        return this.selectedControl;
    }

    @NotNull
    public final CartPartialFulfillment copy(@NotNull String str, @Nullable Control control) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new CartPartialFulfillment(str, control);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartPartialFulfillment)) {
            return false;
        }
        CartPartialFulfillment cartPartialFulfillment = (CartPartialFulfillment) obj;
        return Intrinsics.areEqual((Object) this.f56284name, (Object) cartPartialFulfillment.f56284name) && Intrinsics.areEqual((Object) this.selectedControl, (Object) cartPartialFulfillment.selectedControl);
    }

    @NotNull
    public final String getName() {
        return this.f56284name;
    }

    @Nullable
    public final Control getSelectedControl() {
        return this.selectedControl;
    }

    public int hashCode() {
        int hashCode = this.f56284name.hashCode() * 31;
        Control control = this.selectedControl;
        return hashCode + (control == null ? 0 : control.hashCode());
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f56284name = str;
    }

    public final void setSelectedControl(@Nullable Control control) {
        this.selectedControl = control;
    }

    @NotNull
    public String toString() {
        String str = this.f56284name;
        Control control = this.selectedControl;
        return "CartPartialFulfillment(name=" + str + ", selectedControl=" + control + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartPartialFulfillment(String str, Control control, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? null : control);
    }
}
