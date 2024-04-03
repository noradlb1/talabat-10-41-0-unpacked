package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextKt$InlineChildren$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f3501g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> f3502h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3503i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextKt$InlineChildren$2(AnnotatedString annotatedString, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, int i11) {
        super(2);
        this.f3501g = annotatedString;
        this.f3502h = list;
        this.f3503i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CoreTextKt.InlineChildren(this.f3501g, this.f3502h, composer, this.f3503i | 1);
    }
}
