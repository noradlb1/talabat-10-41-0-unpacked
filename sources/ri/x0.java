package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class x0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f57366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57367c;

    public /* synthetic */ x0(List list, CartFragmentViewModel cartFragmentViewModel) {
        this.f57366b = list;
        this.f57367c = cartFragmentViewModel;
    }

    public final void accept(Object obj) {
        CartFragmentViewModel.m9800initViewModel$lambda12$lambda10$lambda8(this.f57366b, this.f57367c, (CartResponse) obj);
    }
}
