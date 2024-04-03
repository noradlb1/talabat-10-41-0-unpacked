package com.designsystem.ds_text_link.composables;

import androidx.compose.ui.text.AnnotatedString;
import com.designsystem.ds_text_link.Tappable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextLinkComposablesKt$BaseParagraphWithTextLinks$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnnotatedString f33169g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, Tappable> f33170h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLinkComposablesKt$BaseParagraphWithTextLinks$1(AnnotatedString annotatedString, Map<String, Tappable> map) {
        super(1);
        this.f33169g = annotatedString;
        this.f33170h = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        Object obj;
        Function0<Unit> onTap;
        Map<String, Tappable> map = this.f33170h;
        ArrayList arrayList = new ArrayList();
        for (AnnotatedString.Range item : this.f33169g.getStringAnnotations("TextLinkUrlAnnotationTag", i11, i11)) {
            Tappable tappable = map.get(item.getItem());
            if (tappable != null) {
                arrayList.add(tappable);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Tappable) obj).isEnabled()) {
                break;
            }
        }
        Tappable tappable2 = (Tappable) obj;
        if (tappable2 != null && (onTap = tappable2.getOnTap()) != null) {
            onTap.invoke();
        }
    }
}
