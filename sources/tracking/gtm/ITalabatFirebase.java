package tracking.gtm;

import android.content.Context;
import android.os.Bundle;
import com.talabat.talabatcore.application.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Ltracking/gtm/ITalabatFirebase;", "", "dispatchEvent", "", "context", "Landroid/content/Context;", "eventName", "", "params", "Landroid/os/Bundle;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITalabatFirebase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void dispatchEvent$default(ITalabatFirebase iTalabatFirebase, Context context, String str, Bundle bundle, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    context = BaseApplication.Companion.getInstance();
                }
                if ((i11 & 4) != 0) {
                    bundle = new Bundle();
                }
                iTalabatFirebase.dispatchEvent(context, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchEvent");
        }
    }

    void dispatchEvent(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle);
}
