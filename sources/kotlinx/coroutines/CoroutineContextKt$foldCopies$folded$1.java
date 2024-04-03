package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<CoroutineContext> f25119g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f25120h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineContextKt$foldCopies$folded$1(Ref.ObjectRef<CoroutineContext> objectRef, boolean z11) {
        super(2);
        this.f25119g = objectRef;
        this.f25120h = z11;
    }

    @NotNull
    public final CoroutineContext invoke(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        CoroutineContext.Element element2 = ((CoroutineContext) this.f25119g.element).get(element.getKey());
        if (element2 == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.f25120h) {
                copyableThreadContextElement = copyableThreadContextElement.copyForChild();
            }
            return coroutineContext.plus(copyableThreadContextElement);
        }
        Ref.ObjectRef<CoroutineContext> objectRef = this.f25119g;
        objectRef.element = ((CoroutineContext) objectRef.element).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
    }
}
