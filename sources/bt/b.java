package bt;

import com.talabat.registration.RegistrationInteractor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RegistrationInteractor f58178b;

    public /* synthetic */ b(RegistrationInteractor registrationInteractor) {
        this.f58178b = registrationInteractor;
    }

    public final void accept(Object obj) {
        this.f58178b.handleMergedResult((Pair) obj);
    }
}
