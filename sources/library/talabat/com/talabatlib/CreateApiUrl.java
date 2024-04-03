package library.talabat.com.talabatlib;

import com.talabat.helpers.SafeLetKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Llibrary/talabat/com/talabatlib/CreateApiUrl;", "", "()V", "createWithParameters", "", "inputUrl", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CreateApiUrl {
    @NotNull
    public static final CreateApiUrl INSTANCE = new CreateApiUrl();

    private CreateApiUrl() {
    }

    @JvmStatic
    @NotNull
    public static final String createWithParameters(@Nullable String str, @Nullable String[] strArr) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        SafeLetKt.safeLet(str, strArr, new CreateApiUrl$createWithParameters$1(objectRef));
        return (String) objectRef.element;
    }
}
