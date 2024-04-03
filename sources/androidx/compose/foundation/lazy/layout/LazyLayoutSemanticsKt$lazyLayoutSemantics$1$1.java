package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Integer> f3034g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3035h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollAxisRange f3036i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Float, Float, Boolean> f3037j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Boolean> f3038k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CollectionInfo f3039l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(Function1<Object, Integer> function1, boolean z11, ScrollAxisRange scrollAxisRange, Function2<? super Float, ? super Float, Boolean> function2, Function1<? super Integer, Boolean> function12, CollectionInfo collectionInfo) {
        super(1);
        this.f3034g = function1;
        this.f3035h = z11;
        this.f3036i = scrollAxisRange;
        this.f3037j = function2;
        this.f3038k = function12;
        this.f3039l = collectionInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.indexForKey(semanticsPropertyReceiver, this.f3034g);
        if (this.f3035h) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, this.f3036i);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, this.f3036i);
        }
        Function2<Float, Float, Boolean> function2 = this.f3037j;
        if (function2 != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, (String) null, function2, 1, (Object) null);
        }
        Function1<Integer, Boolean> function1 = this.f3038k;
        if (function1 != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semanticsPropertyReceiver, (String) null, function1, 1, (Object) null);
        }
        SemanticsPropertiesKt.setCollectionInfo(semanticsPropertyReceiver, this.f3039l);
    }
}
