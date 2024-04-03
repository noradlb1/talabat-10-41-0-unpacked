package v3;

import com.braze.ui.contentcards.adapters.ContentCardAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContentCardAdapter f44404b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44405c;

    public /* synthetic */ a(ContentCardAdapter contentCardAdapter, int i11) {
        this.f44404b = contentCardAdapter;
        this.f44405c = i11;
    }

    public final void run() {
        ContentCardAdapter.m9203onViewDetachedFromWindow$lambda0(this.f44404b, this.f44405c);
    }
}
