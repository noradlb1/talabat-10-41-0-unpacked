package androidx.compose.ui.text.input;

import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/inputmethod/BaseInputConnection;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextInputServiceAndroid$baseInputConnection$2 extends Lambda implements Function0<BaseInputConnection> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextInputServiceAndroid f10213g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid$baseInputConnection$2(TextInputServiceAndroid textInputServiceAndroid) {
        super(0);
        this.f10213g = textInputServiceAndroid;
    }

    @NotNull
    public final BaseInputConnection invoke() {
        return new BaseInputConnection(this.f10213g.getView(), false);
    }
}
