package com.jakewharton.rxbinding3.widget;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/jakewharton/rxbinding3/widget/AdapterViewItemSelectionEvent;", "Lcom/jakewharton/rxbinding3/widget/AdapterViewSelectionEvent;", "view", "Landroid/widget/AdapterView;", "selectedView", "Landroid/view/View;", "position", "", "id", "", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "getId", "()J", "getPosition", "()I", "getSelectedView", "()Landroid/view/View;", "getView", "()Landroid/widget/AdapterView;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class AdapterViewItemSelectionEvent extends AdapterViewSelectionEvent {

    /* renamed from: id  reason: collision with root package name */
    private final long f52684id;
    private final int position;
    @Nullable
    private final View selectedView;
    @NotNull
    private final AdapterView<?> view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdapterViewItemSelectionEvent(@NotNull AdapterView<?> adapterView, @Nullable View view2, int i11, long j11) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.view = adapterView;
        this.selectedView = view2;
        this.position = i11;
        this.f52684id = j11;
    }

    public static /* synthetic */ AdapterViewItemSelectionEvent copy$default(AdapterViewItemSelectionEvent adapterViewItemSelectionEvent, AdapterView<?> adapterView, View view2, int i11, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            adapterView = adapterViewItemSelectionEvent.getView();
        }
        if ((i12 & 2) != 0) {
            view2 = adapterViewItemSelectionEvent.selectedView;
        }
        View view3 = view2;
        if ((i12 & 4) != 0) {
            i11 = adapterViewItemSelectionEvent.position;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            j11 = adapterViewItemSelectionEvent.f52684id;
        }
        return adapterViewItemSelectionEvent.copy(adapterView, view3, i13, j11);
    }

    @NotNull
    public final AdapterView<?> component1() {
        return getView();
    }

    @Nullable
    public final View component2() {
        return this.selectedView;
    }

    public final int component3() {
        return this.position;
    }

    public final long component4() {
        return this.f52684id;
    }

    @NotNull
    public final AdapterViewItemSelectionEvent copy(@NotNull AdapterView<?> adapterView, @Nullable View view2, int i11, long j11) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        return new AdapterViewItemSelectionEvent(adapterView, view2, i11, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AdapterViewItemSelectionEvent) {
                AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = (AdapterViewItemSelectionEvent) obj;
                if (Intrinsics.areEqual((Object) getView(), (Object) adapterViewItemSelectionEvent.getView()) && Intrinsics.areEqual((Object) this.selectedView, (Object) adapterViewItemSelectionEvent.selectedView)) {
                    if (this.position == adapterViewItemSelectionEvent.position) {
                        if (this.f52684id == adapterViewItemSelectionEvent.f52684id) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getId() {
        return this.f52684id;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final View getSelectedView() {
        return this.selectedView;
    }

    @NotNull
    public AdapterView<?> getView() {
        return this.view;
    }

    public int hashCode() {
        AdapterView<?> view2 = getView();
        int i11 = 0;
        int hashCode = (view2 != null ? view2.hashCode() : 0) * 31;
        View view3 = this.selectedView;
        if (view3 != null) {
            i11 = view3.hashCode();
        }
        long j11 = this.f52684id;
        return ((((hashCode + i11) * 31) + this.position) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "AdapterViewItemSelectionEvent(view=" + getView() + ", selectedView=" + this.selectedView + ", position=" + this.position + ", id=" + this.f52684id + ")";
    }
}
