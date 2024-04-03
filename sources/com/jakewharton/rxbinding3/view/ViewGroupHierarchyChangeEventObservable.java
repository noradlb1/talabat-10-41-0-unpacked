package com.jakewharton.rxbinding3.view;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEventObservable;", "Lio/reactivex/Observable;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "Listener", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
final class ViewGroupHierarchyChangeEventObservable extends Observable<ViewGroupHierarchyChangeEvent> {
    private final ViewGroup viewGroup;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0014R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000e0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEventObservable$Listener;", "Lio/reactivex/android/MainThreadDisposable;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "Landroid/view/View;", "parent", "child", "", "onChildViewAdded", "onChildViewRemoved", "a", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/ViewGroup;", "Lio/reactivex/Observer;", "Lcom/jakewharton/rxbinding3/view/ViewGroupHierarchyChangeEvent;", "observer", "Lio/reactivex/Observer;", "<init>", "(Landroid/view/ViewGroup;Lio/reactivex/Observer;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
    public static final class Listener extends MainThreadDisposable implements ViewGroup.OnHierarchyChangeListener {
        private final Observer<? super ViewGroupHierarchyChangeEvent> observer;
        private final ViewGroup viewGroup;

        public Listener(@NotNull ViewGroup viewGroup2, @NotNull Observer<? super ViewGroupHierarchyChangeEvent> observer2) {
            Intrinsics.checkParameterIsNotNull(viewGroup2, "viewGroup");
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.viewGroup = viewGroup2;
            this.observer = observer2;
        }

        public void a() {
            this.viewGroup.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
        }

        public void onChildViewAdded(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkParameterIsNotNull(view, "parent");
            Intrinsics.checkParameterIsNotNull(view2, "child");
            if (!isDisposed()) {
                this.observer.onNext(new ViewGroupHierarchyChildViewAddEvent(this.viewGroup, view2));
            }
        }

        public void onChildViewRemoved(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkParameterIsNotNull(view, "parent");
            Intrinsics.checkParameterIsNotNull(view2, "child");
            if (!isDisposed()) {
                this.observer.onNext(new ViewGroupHierarchyChildViewRemoveEvent(this.viewGroup, view2));
            }
        }
    }

    public ViewGroupHierarchyChangeEventObservable(@NotNull ViewGroup viewGroup2) {
        Intrinsics.checkParameterIsNotNull(viewGroup2, "viewGroup");
        this.viewGroup = viewGroup2;
    }

    public void subscribeActual(@NotNull Observer<? super ViewGroupHierarchyChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.viewGroup, observer);
            observer.onSubscribe(listener);
            this.viewGroup.setOnHierarchyChangeListener(listener);
        }
    }
}
