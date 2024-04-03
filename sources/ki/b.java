package ki;

import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public final /* synthetic */ class b implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56972b;

    public /* synthetic */ b(DarkstoresRepositoryImpl darkstoresRepositoryImpl, String str) {
        this.f56971a = darkstoresRepositoryImpl;
        this.f56972b = str;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        DarkstoresRepositoryImpl.m9731optString$lambda5(this.f56971a, this.f56972b, maybeEmitter);
    }
}
