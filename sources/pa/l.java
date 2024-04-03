package pa;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

public final /* synthetic */ class l implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Personalization f50707a;

    public /* synthetic */ l(Personalization personalization) {
        this.f50707a = personalization;
    }

    public final void accept(Object obj, Object obj2) {
        this.f50707a.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
