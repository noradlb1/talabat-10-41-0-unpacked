package v6;

import com.facebook.internal.LockOnGetVariable;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LockOnGetVariable f34761b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f34762c;

    public /* synthetic */ m(LockOnGetVariable lockOnGetVariable, Callable callable) {
        this.f34761b = lockOnGetVariable;
        this.f34762c = callable;
    }

    public final Object call() {
        return LockOnGetVariable.m8960_init_$lambda0(this.f34761b, this.f34762c);
    }
}
