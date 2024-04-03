package ri;

import com.talabat.darkstores.feature.cart.PostCartUseCase;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class r1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PostCartUseCase f57349b;

    public /* synthetic */ r1(PostCartUseCase postCartUseCase) {
        this.f57349b = postCartUseCase;
    }

    public final void accept(Object obj) {
        this.f57349b.saveCartId((CartResponse) obj);
    }
}
