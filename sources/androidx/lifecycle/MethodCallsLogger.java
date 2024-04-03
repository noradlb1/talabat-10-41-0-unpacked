package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i11) {
        int i12;
        Integer num = this.mCalledMethods.get(str);
        boolean z11 = false;
        if (num != null) {
            i12 = num.intValue();
        } else {
            i12 = 0;
        }
        if ((i12 & i11) != 0) {
            z11 = true;
        }
        this.mCalledMethods.put(str, Integer.valueOf(i11 | i12));
        return !z11;
    }
}
