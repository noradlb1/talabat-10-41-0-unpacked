package library.talabat.com.talabatlib;

import com.talabat.helpers.SafeLetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "url", "", "urlParams", "", "invoke", "(Ljava/lang/String;[Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CreateApiUrl$createWithParameters$1 extends Lambda implements Function2<String, String[], Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f26523g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateApiUrl$createWithParameters$1(Ref.ObjectRef<String> objectRef) {
        super(2);
        this.f26523g = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String[]) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(strArr, "urlParams");
        this.f26523g.element = str;
        int i11 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                String str2 = strArr[i11];
                String str3 = strArr[i11 + 1];
                final Ref.ObjectRef<String> objectRef = this.f26523g;
                SafeLetKt.safeLet(str2, str3, new Function2<String, String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (String) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull String str, @NotNull String str2) {
                        Intrinsics.checkNotNullParameter(str, "toReplace");
                        Intrinsics.checkNotNullParameter(str2, "replacement");
                        Ref.ObjectRef<String> objectRef = objectRef;
                        objectRef.element = StringsKt__StringsJVMKt.replace$default((String) objectRef.element, str, str2, false, 4, (Object) null);
                    }
                });
                if (i11 != progressionLastElement) {
                    i11 += 2;
                } else {
                    return;
                }
            }
        }
    }
}
