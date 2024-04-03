package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Action;

public final /* synthetic */ class p implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62109b;

    public /* synthetic */ p(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62109b = darkstoresCartRepository;
    }

    public final void run() {
        DarkstoresCartRepository.m10181removeProductFromCart$lambda12(this.f62109b);
    }
}
