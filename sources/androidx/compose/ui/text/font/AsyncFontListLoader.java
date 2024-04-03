package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010 \u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AsyncFontListLoader implements State<Object> {
    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    @NotNull
    private final List<Font> fontList;
    @NotNull
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    /* access modifiers changed from: private */
    @NotNull
    public final PlatformFontLoader platformFontLoader;
    @NotNull
    private final TypefaceRequest typefaceRequest;
    @NotNull
    private final MutableState value$delegate;

    public AsyncFontListLoader(@NotNull List<? extends Font> list, @NotNull Object obj, @NotNull TypefaceRequest typefaceRequest2, @NotNull AsyncTypefaceCache asyncTypefaceCache2, @NotNull Function1<? super TypefaceResult.Immutable, Unit> function1, @NotNull PlatformFontLoader platformFontLoader2) {
        Intrinsics.checkNotNullParameter(list, "fontList");
        Intrinsics.checkNotNullParameter(obj, "initialType");
        Intrinsics.checkNotNullParameter(typefaceRequest2, "typefaceRequest");
        Intrinsics.checkNotNullParameter(asyncTypefaceCache2, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(function1, "onCompletion");
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        this.fontList = list;
        this.typefaceRequest = typefaceRequest2;
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader2;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    @NotNull
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[SYNTHETIC, Splitter:B:27:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef A[SYNTHETIC, Splitter:B:38:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            boolean r2 = r0 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r2 = (androidx.compose.ui.text.font.AsyncFontListLoader$load$1) r2
            int r3 = r2.f10160o
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f10160o = r3
            goto L_0x001c
        L_0x0017:
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r2 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f10158m
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f10160o
            r5 = 0
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x0068
            if (r4 == r7) goto L_0x004a
            if (r4 != r6) goto L_0x0042
            int r4 = r2.f10157l
            int r9 = r2.f10156k
            java.lang.Object r10 = r2.f10154i
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r2.f10153h
            androidx.compose.ui.text.font.AsyncFontListLoader r11 = (androidx.compose.ui.text.font.AsyncFontListLoader) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x003f }
            goto L_0x0103
        L_0x003f:
            r0 = move-exception
            goto L_0x012c
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            int r4 = r2.f10157l
            int r9 = r2.f10156k
            java.lang.Object r10 = r2.f10155j
            androidx.compose.ui.text.font.Font r10 = (androidx.compose.ui.text.font.Font) r10
            java.lang.Object r11 = r2.f10154i
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r2.f10153h
            androidx.compose.ui.text.font.AsyncFontListLoader r12 = (androidx.compose.ui.text.font.AsyncFontListLoader) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0064 }
            r15 = r12
            r18 = r11
            r11 = r10
            r10 = r18
            goto L_0x00b9
        L_0x0064:
            r0 = move-exception
            r11 = r12
            goto L_0x012c
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List<androidx.compose.ui.text.font.Font> r0 = r1.fontList     // Catch:{ all -> 0x012a }
            int r4 = r0.size()     // Catch:{ all -> 0x012a }
            r15 = r1
            r14 = r8
        L_0x0073:
            if (r14 >= r4) goto L_0x010f
            java.lang.Object r9 = r0.get(r14)     // Catch:{ all -> 0x0107 }
            r13 = r9
            androidx.compose.ui.text.font.Font r13 = (androidx.compose.ui.text.font.Font) r13     // Catch:{ all -> 0x0107 }
            int r9 = r13.m5098getLoadingStrategyPKNRLFQ()     // Catch:{ all -> 0x0107 }
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r10 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion     // Catch:{ all -> 0x0107 }
            int r10 = r10.m5115getAsyncPKNRLFQ()     // Catch:{ all -> 0x0107 }
            boolean r9 = androidx.compose.ui.text.font.FontLoadingStrategy.m5111equalsimpl0(r9, r10)     // Catch:{ all -> 0x0107 }
            if (r9 == 0) goto L_0x010a
            androidx.compose.ui.text.font.AsyncTypefaceCache r9 = r15.asyncTypefaceCache     // Catch:{ all -> 0x0107 }
            androidx.compose.ui.text.font.PlatformFontLoader r11 = r15.platformFontLoader     // Catch:{ all -> 0x0107 }
            r12 = 0
            androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1 r10 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1     // Catch:{ all -> 0x0107 }
            r10.<init>(r15, r13, r5)     // Catch:{ all -> 0x0107 }
            r2.f10153h = r15     // Catch:{ all -> 0x0107 }
            r2.f10154i = r0     // Catch:{ all -> 0x0107 }
            r2.f10155j = r13     // Catch:{ all -> 0x0107 }
            r2.f10156k = r14     // Catch:{ all -> 0x0107 }
            r2.f10157l = r4     // Catch:{ all -> 0x0107 }
            r2.f10160o = r7     // Catch:{ all -> 0x0107 }
            r16 = r10
            r10 = r13
            r17 = r13
            r13 = r16
            r16 = r14
            r14 = r2
            java.lang.Object r9 = r9.runCached(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0107 }
            if (r9 != r3) goto L_0x00b3
            return r3
        L_0x00b3:
            r10 = r0
            r0 = r9
            r9 = r16
            r11 = r17
        L_0x00b9:
            if (r0 == 0) goto L_0x00ef
            androidx.compose.ui.text.font.TypefaceRequest r3 = r15.typefaceRequest     // Catch:{ all -> 0x0107 }
            int r3 = r3.m5176getFontSynthesisGVVA2EU()     // Catch:{ all -> 0x0107 }
            androidx.compose.ui.text.font.TypefaceRequest r4 = r15.typefaceRequest     // Catch:{ all -> 0x0107 }
            androidx.compose.ui.text.font.FontWeight r4 = r4.getFontWeight()     // Catch:{ all -> 0x0107 }
            androidx.compose.ui.text.font.TypefaceRequest r5 = r15.typefaceRequest     // Catch:{ all -> 0x0107 }
            int r5 = r5.m5175getFontStyle_LCdwA()     // Catch:{ all -> 0x0107 }
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(r3, r0, r11, r4, r5)     // Catch:{ all -> 0x0107 }
            r15.setValue(r0)     // Catch:{ all -> 0x0107 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0107 }
            kotlin.coroutines.CoroutineContext r2 = r2.getContext()
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r2)
            r15.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r3 = r15.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r4 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r5 = r15.getValue()
            r4.<init>(r5, r2)
            r3.invoke(r4)
            return r0
        L_0x00ef:
            r2.f10153h = r15     // Catch:{ all -> 0x0107 }
            r2.f10154i = r10     // Catch:{ all -> 0x0107 }
            r2.f10155j = r5     // Catch:{ all -> 0x0107 }
            r2.f10156k = r9     // Catch:{ all -> 0x0107 }
            r2.f10157l = r4     // Catch:{ all -> 0x0107 }
            r2.f10160o = r6     // Catch:{ all -> 0x0107 }
            java.lang.Object r0 = kotlinx.coroutines.YieldKt.yield(r2)     // Catch:{ all -> 0x0107 }
            if (r0 != r3) goto L_0x0102
            return r3
        L_0x0102:
            r11 = r15
        L_0x0103:
            r14 = r9
            r0 = r10
            r15 = r11
            goto L_0x010c
        L_0x0107:
            r0 = move-exception
            r11 = r15
            goto L_0x012c
        L_0x010a:
            r16 = r14
        L_0x010c:
            int r14 = r14 + r7
            goto L_0x0073
        L_0x010f:
            kotlin.coroutines.CoroutineContext r0 = r2.getContext()
            boolean r0 = kotlinx.coroutines.JobKt.isActive(r0)
            r15.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r2 = r15.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r3 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r4 = r15.getValue()
            r3.<init>(r4, r0)
            r2.invoke(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x012a:
            r0 = move-exception
            r11 = r1
        L_0x012c:
            kotlin.coroutines.CoroutineContext r2 = r2.getContext()
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r2)
            r11.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r3 = r11.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r4 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r5 = r11.getValue()
            r4.<init>(r5, r2)
            r3.invoke(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.f10167k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f10167k = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f10165i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10167k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.f10164h
            androidx.compose.ui.text.font.Font r7 = (androidx.compose.ui.text.font.Font) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r8 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            r8.<init>(r6, r7, r4)     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            r0.f10164h = r7     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            r0.f10167k = r3     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r8, r0)     // Catch:{ CancellationException -> 0x007a, Exception -> 0x004d }
            if (r8 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r4 = r8
            goto L_0x0085
        L_0x004d:
            r8 = move-exception
            kotlin.coroutines.CoroutineContext r1 = r0.getContext()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r2 = kotlinx.coroutines.CoroutineExceptionHandler.Key
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r2)
            kotlinx.coroutines.CoroutineExceptionHandler r1 = (kotlinx.coroutines.CoroutineExceptionHandler) r1
            if (r1 == 0) goto L_0x0085
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unable to load font "
            r3.append(r5)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r2.<init>(r7, r8)
            r1.handleException(r0, r2)
            goto L_0x0085
        L_0x007a:
            r7 = move-exception
            kotlin.coroutines.CoroutineContext r8 = r0.getContext()
            boolean r8 = kotlinx.coroutines.JobKt.isActive(r8)
            if (r8 == 0) goto L_0x0086
        L_0x0085:
            return r4
        L_0x0086:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setCacheable$ui_text_release(boolean z11) {
        this.cacheable = z11;
    }
}
