package bi;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompactSwimlaneAdapter.ViewHolder f50862a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Product f50863b;

    public /* synthetic */ c(CompactSwimlaneAdapter.ViewHolder viewHolder, Product product) {
        this.f50862a = viewHolder;
        this.f50863b = product;
    }

    public final void onChanged(Object obj) {
        CompactSwimlaneAdapter.ViewHolder.m9638bind$lambda1(this.f50862a, this.f50863b, (Map) obj);
    }
}
