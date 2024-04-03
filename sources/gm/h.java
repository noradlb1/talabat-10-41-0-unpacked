package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Action;

public final /* synthetic */ class h implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62100b;

    public /* synthetic */ h(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62100b = darkstoresCartRepository;
    }

    public final void run() {
        DarkstoresCartRepository.m10170addProductToCart$lambda8(this.f62100b);
    }
}
