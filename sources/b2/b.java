package b2;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Violation f38211c;

    public /* synthetic */ b(String str, Violation violation) {
        this.f38210b = str;
        this.f38211c = violation;
    }

    public final void run() {
        FragmentStrictMode.m9083handlePolicyViolation$lambda1(this.f38210b, this.f38211c);
    }
}
