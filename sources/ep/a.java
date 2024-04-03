package ep;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsCardInfoViewHolder;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproDetailsCardInfoViewHolder f61985a;

    public /* synthetic */ a(TproDetailsCardInfoViewHolder tproDetailsCardInfoViewHolder) {
        this.f61985a = tproDetailsCardInfoViewHolder;
    }

    public final void onChanged(Object obj) {
        this.f61985a.hideThePaymentWidgetLoading((Boolean) obj);
    }
}
