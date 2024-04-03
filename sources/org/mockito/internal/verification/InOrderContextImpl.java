package org.mockito.internal.verification;

import org.mockito.internal.util.collections.IdentitySet;
import org.mockito.internal.verification.api.InOrderContext;
import org.mockito.invocation.Invocation;

public class InOrderContextImpl implements InOrderContext {

    /* renamed from: a  reason: collision with root package name */
    public final IdentitySet f63276a = new IdentitySet();

    public boolean isVerified(Invocation invocation) {
        return this.f63276a.contains(invocation);
    }

    public void markVerified(Invocation invocation) {
        this.f63276a.add(invocation);
    }
}
