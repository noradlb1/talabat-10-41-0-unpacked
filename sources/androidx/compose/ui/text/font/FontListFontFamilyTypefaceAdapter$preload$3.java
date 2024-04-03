package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class FontListFontFamilyTypefaceAdapter$preload$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f10188h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<Font> f10189i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FontListFontFamilyTypefaceAdapter f10190j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PlatformFontLoader f10191k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontListFontFamilyTypefaceAdapter$preload$3(List<Font> list, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3> continuation) {
        super(2, continuation);
        this.f10189i = list;
        this.f10190j = fontListFontFamilyTypefaceAdapter;
        this.f10191k = platformFontLoader;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FontListFontFamilyTypefaceAdapter$preload$3 fontListFontFamilyTypefaceAdapter$preload$3 = new FontListFontFamilyTypefaceAdapter$preload$3(this.f10189i, this.f10190j, this.f10191k, continuation);
        fontListFontFamilyTypefaceAdapter$preload$3.L$0 = obj;
        return fontListFontFamilyTypefaceAdapter$preload$3;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10188h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List<Font> list = this.f10189i;
            HashSet hashSet = new HashSet(list.size());
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                Font font = list.get(i12);
                if (hashSet.add(font)) {
                    arrayList.add(font);
                }
            }
            FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.f10190j;
            PlatformFontLoader platformFontLoader = this.f10191k;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FontListFontFamilyTypefaceAdapter$preload$3$2$1(fontListFontFamilyTypefaceAdapter, (Font) arrayList.get(i13), platformFontLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1>) null), 3, (Object) null));
            }
            this.f10188h = 1;
            if (AwaitKt.joinAll((Collection<? extends Job>) arrayList2, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
