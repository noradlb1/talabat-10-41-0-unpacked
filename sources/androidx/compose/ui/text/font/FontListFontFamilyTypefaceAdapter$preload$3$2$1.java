package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class FontListFontFamilyTypefaceAdapter$preload$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10192h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FontListFontFamilyTypefaceAdapter f10193i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Font f10194j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PlatformFontLoader f10195k;

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0000\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f10196h;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(font, platformFontLoader, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<Object> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f10196h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final PlatformFontLoader platformFontLoader = platformFontLoader;
                final Font font = font;
                AnonymousClass1 r72 = new Function2<CoroutineScope, Continuation<? super Object>, Object>((Continuation<? super AnonymousClass1>) null) {

                    /* renamed from: h  reason: collision with root package name */
                    public int f10199h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public FontListFontFamilyTypefaceAdapter$preload$3$2$1(FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, Font font, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1> continuation) {
                            super(2, continuation);
                            this.f10193i = fontListFontFamilyTypefaceAdapter;
                            this.f10194j = font;
                            this.f10195k = platformFontLoader;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new FontListFontFamilyTypefaceAdapter$preload$3$2$1(this.f10193i, this.f10194j, this.f10195k, continuation);
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
                            return ((FontListFontFamilyTypefaceAdapter$preload$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f10192h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                AsyncTypefaceCache access$getAsyncTypefaceCache$p = this.f10193i.asyncTypefaceCache;
                                final Font font = this.f10194j;
                                final PlatformFontLoader platformFontLoader = this.f10195k;
                                AnonymousClass1 r72 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f10192h = 1;
                                obj = access$getAsyncTypefaceCache$p.runCached(font, platformFontLoader, true, r72, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i11 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return obj;
                        }
                    }
