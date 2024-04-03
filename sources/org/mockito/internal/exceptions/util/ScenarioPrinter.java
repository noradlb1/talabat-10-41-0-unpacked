package org.mockito.internal.exceptions.util;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.exceptions.VerificationAwareInvocation;

public class ScenarioPrinter {
    public String print(List<VerificationAwareInvocation> list) {
        if (list.size() == 1) {
            return "Actually, above is the only interaction with this mock.";
        }
        StringBuilder sb2 = new StringBuilder("***\nFor your reference, here is the list of all invocations ([?] - means unverified).\n");
        int i11 = 0;
        for (VerificationAwareInvocation next : list) {
            i11++;
            sb2.append(i11);
            sb2.append(". ");
            if (!next.isVerified()) {
                sb2.append("[?]");
            }
            sb2.append(next.getLocation());
            sb2.append(StringUtils.LF);
        }
        return sb2.toString();
    }
}
