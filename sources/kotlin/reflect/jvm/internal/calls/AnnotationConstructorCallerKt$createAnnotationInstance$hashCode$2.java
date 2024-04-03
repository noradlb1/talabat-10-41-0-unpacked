package kotlin.reflect.jvm.internal.calls;

import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f24442g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(Map<String, ? extends Object> map) {
        super(0);
        this.f24442g = map;
    }

    @NotNull
    public final Integer invoke() {
        int i11;
        int i12 = 0;
        for (Map.Entry entry : this.f24442g.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                i11 = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                i11 = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                i11 = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                i11 = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                i11 = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                i11 = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                i11 = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                i11 = Arrays.hashCode((double[]) value);
            } else if (value instanceof Object[]) {
                i11 = Arrays.hashCode((Object[]) value);
            } else {
                i11 = value.hashCode();
            }
            i12 += i11 ^ (str.hashCode() * 127);
        }
        return Integer.valueOf(i12);
    }
}
