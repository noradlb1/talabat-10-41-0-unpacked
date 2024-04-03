package zr;

import androidx.lifecycle.Observer;
import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import com.talabat.helpers.TalabatBase;

public final /* synthetic */ class w implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TalabatBase f63120a;

    public /* synthetic */ w(TalabatBase talabatBase) {
        this.f63120a = talabatBase;
    }

    public final void onChanged(Object obj) {
        this.f63120a.lambda$setupHelpCenter$0((UnreadChatMessages) obj);
    }
}
