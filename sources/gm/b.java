package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62092b;

    public /* synthetic */ b(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62092b = darkstoresCartRepository;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10176getCartOwner$lambda14(this.f62092b, (String) obj);
    }
}
