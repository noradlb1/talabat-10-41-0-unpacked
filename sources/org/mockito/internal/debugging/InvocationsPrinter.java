package org.mockito.internal.debugging;

import java.util.Collection;
import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.ListUtil;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;

public class InvocationsPrinter {
    public String printInvocations(Object obj) {
        Collection<Invocation> invocations = Mockito.mockingDetails(obj).getInvocations();
        Collection<Stubbing> stubbings = Mockito.mockingDetails(obj).getStubbings();
        if (!invocations.isEmpty() || !stubbings.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = 1;
            int i12 = 1;
            for (Invocation next : invocations) {
                if (i12 == 1) {
                    sb2.append("[Mockito] Interactions of: ");
                    sb2.append(obj);
                    sb2.append(StringUtils.LF);
                }
                sb2.append(" ");
                int i13 = i12 + 1;
                sb2.append(i12);
                sb2.append(". ");
                sb2.append(next);
                sb2.append(StringUtils.LF);
                sb2.append("  ");
                sb2.append(next.getLocation());
                sb2.append(StringUtils.LF);
                if (next.stubInfo() != null) {
                    sb2.append("   - stubbed ");
                    sb2.append(next.stubInfo().stubbedAt());
                    sb2.append(StringUtils.LF);
                }
                i12 = i13;
            }
            if (ListUtil.filter(stubbings, new ListUtil.Filter<Stubbing>() {
                public boolean isOut(Stubbing stubbing) {
                    return stubbing.wasUsed();
                }
            }).isEmpty()) {
                return sb2.toString();
            }
            sb2.append("[Mockito] Unused stubbings of: ");
            sb2.append(obj);
            sb2.append(StringUtils.LF);
            for (Stubbing next2 : stubbings) {
                sb2.append(" ");
                sb2.append(i11);
                sb2.append(". ");
                sb2.append(next2.getInvocation());
                sb2.append(StringUtils.LF);
                sb2.append("  - stubbed ");
                sb2.append(next2.getInvocation().getLocation());
                sb2.append(StringUtils.LF);
                i11++;
            }
            return sb2.toString();
        }
        return "No interactions and stubbings found for mock: " + obj;
    }
}
