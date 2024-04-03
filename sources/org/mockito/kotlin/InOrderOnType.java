package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.TypeCastException;
import org.mockito.InOrder;
import org.mockito.verification.VerificationMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J8\u0010\u0006\u001a\n \b*\u0004\u0018\u0001H\u0001H\u0001\"\u0010\b\u0001\u0010\u0001*\n \b*\u0004\u0018\u00010\t0\t2\u000e\u0010\n\u001a\n \b*\u0004\u0018\u0001H\u0001H\u0001H\u0001¢\u0006\u0002\u0010\u000bJH\u0010\u0006\u001a\n \b*\u0004\u0018\u0001H\u0001H\u0001\"\u0010\b\u0001\u0010\u0001*\n \b*\u0004\u0018\u00010\t0\t2\u000e\u0010\n\u001a\n \b*\u0004\u0018\u0001H\u0001H\u00012\u000e\u0010\f\u001a\n \b*\u0004\u0018\u00010\r0\rH\u0001¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0010H\u0001R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"Lorg/mockito/kotlin/InOrderOnType;", "T", "Lorg/mockito/InOrder;", "t", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "verify", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "", "p0", "(Ljava/lang/Object;)Ljava/lang/Object;", "p1", "Lorg/mockito/verification/VerificationMode;", "(Ljava/lang/Object;Lorg/mockito/verification/VerificationMode;)Ljava/lang/Object;", "verifyNoMoreInteractions", "", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class InOrderOnType<T> implements InOrder {
    private final /* synthetic */ InOrder $$delegate_0;

    /* renamed from: t  reason: collision with root package name */
    private final T f63280t;

    public InOrderOnType(T t11) {
        Object[] objArr = new Object[1];
        if (t11 != null) {
            objArr[0] = t11;
            this.$$delegate_0 = VerificationKt.inOrder(objArr);
            this.f63280t = t11;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }

    public final T verify() {
        return verify(this.f63280t);
    }

    public <T> T verify(T t11) {
        return this.$$delegate_0.verify(t11);
    }

    public <T> T verify(T t11, VerificationMode verificationMode) {
        return this.$$delegate_0.verify(t11, verificationMode);
    }

    public void verifyNoMoreInteractions() {
        this.$$delegate_0.verifyNoMoreInteractions();
    }
}
