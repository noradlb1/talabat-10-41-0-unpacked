package JsonModels.Response;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"LJsonModels/Response/HomeMapAreaRM;", "", "()V", "result", "LJsonModels/Response/HomeMapAreaResponse;", "getResult", "()LJsonModels/Response/HomeMapAreaResponse;", "setResult", "(LJsonModels/Response/HomeMapAreaResponse;)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapAreaRM {
    @NotNull
    public static final HomeMapAreaRM INSTANCE = new HomeMapAreaRM();
    @Nullable
    private static HomeMapAreaResponse result;

    private HomeMapAreaRM() {
    }

    @Nullable
    public final HomeMapAreaResponse getResult() {
        return result;
    }

    public final void setResult(@Nullable HomeMapAreaResponse homeMapAreaResponse) {
        result = homeMapAreaResponse;
    }
}
