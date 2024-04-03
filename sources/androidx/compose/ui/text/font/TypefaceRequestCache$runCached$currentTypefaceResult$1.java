package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "finalResult", "Landroidx/compose/ui/text/font/TypefaceResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends Lambda implements Function1<TypefaceResult, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypefaceRequestCache f10207g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypefaceRequest f10208h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.f10207g = typefaceRequestCache;
        this.f10208h = typefaceRequest;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypefaceResult typefaceResult) {
        Intrinsics.checkNotNullParameter(typefaceResult, "finalResult");
        SynchronizedObject lock$ui_text_release = this.f10207g.getLock$ui_text_release();
        TypefaceRequestCache typefaceRequestCache = this.f10207g;
        TypefaceRequest typefaceRequest = this.f10208h;
        synchronized (lock$ui_text_release) {
            if (typefaceResult.getCacheable()) {
                typefaceRequestCache.resultCache.put(typefaceRequest, typefaceResult);
            } else {
                typefaceRequestCache.resultCache.remove(typefaceRequest);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
