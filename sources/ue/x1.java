package ue;

import android.widget.CompoundButton;
import com.talabat.CartScreen;

public final /* synthetic */ class x1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57819c;

    public /* synthetic */ x1(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, int i11) {
        this.f57818b = cartRecyclerviewAdapter;
        this.f57819c = i11;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f57818b.lambda$onBindViewHolder$0(this.f57819c, compoundButton, z11);
    }
}
