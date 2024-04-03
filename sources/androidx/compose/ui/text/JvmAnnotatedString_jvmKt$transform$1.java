package androidx.compose.ui.text;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "invoke", "(Ljava/util/List;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class JvmAnnotatedString_jvmKt$transform$1 extends Lambda implements Function1<List<? extends Integer>, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f10130g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<String, Integer, Integer, String> f10131h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f10132i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Map<Integer, Integer> f10133j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmAnnotatedString_jvmKt$transform$1(Ref.ObjectRef<String> objectRef, Function3<? super String, ? super Integer, ? super Integer, String> function3, AnnotatedString annotatedString, Map<Integer, Integer> map) {
        super(1);
        this.f10130g = objectRef;
        this.f10131h = function3;
        this.f10132i = annotatedString;
        this.f10133j = map;
    }

    @Nullable
    public final Integer invoke(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
        int intValue = list.get(0).intValue();
        int intValue2 = list.get(1).intValue();
        Ref.ObjectRef<String> objectRef = this.f10130g;
        objectRef.element = ((String) this.f10130g.element) + this.f10131h.invoke(this.f10132i.getText(), Integer.valueOf(intValue), Integer.valueOf(intValue2));
        return this.f10133j.put(Integer.valueOf(intValue2), Integer.valueOf(((String) this.f10130g.element).length()));
    }
}
