package ue;

import com.talabat.GroceryMenuScreen;

public final /* synthetic */ class p7 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen f57693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57694c;

    public /* synthetic */ p7(GroceryMenuScreen groceryMenuScreen, int i11) {
        this.f57693b = groceryMenuScreen;
        this.f57694c = i11;
    }

    public final void run() {
        this.f57693b.lambda$scrollRecyclerviewToPosition$15(this.f57694c);
    }
}
