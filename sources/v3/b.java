package v3;

import com.braze.ui.contentcards.adapters.ContentCardAdapter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f44406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44407c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContentCardAdapter f44408d;

    public /* synthetic */ b(int i11, int i12, ContentCardAdapter contentCardAdapter) {
        this.f44406b = i11;
        this.f44407c = i12;
        this.f44408d = contentCardAdapter;
    }

    public final void run() {
        ContentCardAdapter.m9202markOnScreenCardsAsRead$lambda1(this.f44406b, this.f44407c, this.f44408d);
    }
}
