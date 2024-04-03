package com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChildViewRemoveEvent;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "view", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "getChild", "()Landroid/view/View;", "getView", "()Landroid/view/ViewGroup;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class ViewGroupHierarchyChildViewRemoveEvent extends ViewGroupHierarchyChangeEvent {
    @NotNull
    private final View child;
    @NotNull
    private final ViewGroup view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewGroupHierarchyChildViewRemoveEvent(@NotNull ViewGroup viewGroup, @NotNull View view2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(viewGroup, "view");
        Intrinsics.checkParameterIsNotNull(view2, "child");
        this.view = viewGroup;
        this.child = view2;
    }

    public static /* synthetic */ ViewGroupHierarchyChildViewRemoveEvent copy$default(ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent, ViewGroup viewGroup, View view2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            viewGroup = viewGroupHierarchyChildViewRemoveEvent.getView();
        }
        if ((i11 & 2) != 0) {
            view2 = viewGroupHierarchyChildViewRemoveEvent.getChild();
        }
        return viewGroupHierarchyChildViewRemoveEvent.copy(viewGroup, view2);
    }

    @NotNull
    public final ViewGroup component1() {
        return getView();
    }

    @NotNull
    public final View component2() {
        return getChild();
    }

    @NotNull
    public final ViewGroupHierarchyChildViewRemoveEvent copy(@NotNull ViewGroup viewGroup, @NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "view");
        Intrinsics.checkParameterIsNotNull(view2, "child");
        return new ViewGroupHierarchyChildViewRemoveEvent(viewGroup, view2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewGroupHierarchyChildViewRemoveEvent)) {
            return false;
        }
        ViewGroupHierarchyChildViewRemoveEvent viewGroupHierarchyChildViewRemoveEvent = (ViewGroupHierarchyChildViewRemoveEvent) obj;
        return Intrinsics.areEqual((Object) getView(), (Object) viewGroupHierarchyChildViewRemoveEvent.getView()) && Intrinsics.areEqual((Object) getChild(), (Object) viewGroupHierarchyChildViewRemoveEvent.getChild());
    }

    @NotNull
    public View getChild() {
        return this.child;
    }

    @NotNull
    public ViewGroup getView() {
        return this.view;
    }

    public int hashCode() {
        ViewGroup view2 = getView();
        int i11 = 0;
        int hashCode = (view2 != null ? view2.hashCode() : 0) * 31;
        View child2 = getChild();
        if (child2 != null) {
            i11 = child2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "ViewGroupHierarchyChildViewRemoveEvent(view=" + getView() + ", child=" + getChild() + ")";
    }
}
