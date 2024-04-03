package b2;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f38208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Violation f38209c;

    public /* synthetic */ a(FragmentStrictMode.Policy policy, Violation violation) {
        this.f38208b = policy;
        this.f38209c = violation;
    }

    public final void run() {
        FragmentStrictMode.m9082handlePolicyViolation$lambda0(this.f38208b, this.f38209c);
    }
}
