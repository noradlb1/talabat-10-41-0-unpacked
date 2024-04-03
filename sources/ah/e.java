package ah;

import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f50824b;

    public /* synthetic */ e(SingleEmitter singleEmitter) {
        this.f50824b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f50824b.onSuccess((GoogleLoginRepository.GoogleLoginResult) obj);
    }
}
