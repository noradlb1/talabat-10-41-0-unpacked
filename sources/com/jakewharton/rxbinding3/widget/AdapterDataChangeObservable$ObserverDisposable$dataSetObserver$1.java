package com.jakewharton.rxbinding3.widget;

import android.database.DataSetObserver;
import com.jakewharton.rxbinding3.widget.AdapterDataChangeObservable;
import io.reactivex.Observer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/jakewharton/rxbinding3/widget/AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1", "Landroid/database/DataSetObserver;", "onChanged", "", "rxbinding_release"}, k = 1, mv = {1, 1, 15})
public final class AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1 extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdapterDataChangeObservable.ObserverDisposable f52680a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f52681b;

    public AdapterDataChangeObservable$ObserverDisposable$dataSetObserver$1(AdapterDataChangeObservable.ObserverDisposable observerDisposable, Observer observer) {
        this.f52680a = observerDisposable;
        this.f52681b = observer;
    }

    public void onChanged() {
        if (!this.f52680a.isDisposed()) {
            this.f52681b.onNext(this.f52680a.adapter);
        }
    }
}
