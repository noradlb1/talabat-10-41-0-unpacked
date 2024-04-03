package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements Function1<String, String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f25089g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.f25089g = str;
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            return this.f25089g + str;
        } else if (str.length() < this.f25089g.length()) {
            return this.f25089g;
        } else {
            return str;
        }
    }
}
