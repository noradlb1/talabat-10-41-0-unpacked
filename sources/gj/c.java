package gj;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.home.viewholder.SwimlanesProductViewHolder;
import java.util.Map;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwimlanesProductViewHolder f56861a;

    public /* synthetic */ c(SwimlanesProductViewHolder swimlanesProductViewHolder) {
        this.f56861a = swimlanesProductViewHolder;
    }

    public final void onChanged(Object obj) {
        SwimlanesProductViewHolder.m9979bind$lambda3$lambda2(this.f56861a, (Map) obj);
    }
}
