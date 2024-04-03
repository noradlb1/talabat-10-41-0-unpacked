package ue;

import com.talabat.GroceryMenuScreen;

public final /* synthetic */ class n7 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryMenuScreen f57664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57665c;

    public /* synthetic */ n7(GroceryMenuScreen groceryMenuScreen, int i11) {
        this.f57664b = groceryMenuScreen;
        this.f57665c = i11;
    }

    public final void run() {
        this.f57664b.lambda$scrollTabToPosition$14(this.f57665c);
    }
}
