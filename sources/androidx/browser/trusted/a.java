package androidx.browser.trusted;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionHolder f1012a;

    public /* synthetic */ a(ConnectionHolder connectionHolder) {
        this.f1012a = connectionHolder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f1012a.lambda$getServiceWrapper$0(completer);
    }
}
