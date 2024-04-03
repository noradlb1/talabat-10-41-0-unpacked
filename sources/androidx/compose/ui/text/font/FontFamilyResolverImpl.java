package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalTextApi
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<TypefaceRequest, Object> createDefaultTypeface;
    /* access modifiers changed from: private */
    @NotNull
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    /* access modifiers changed from: private */
    @NotNull
    public final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    @NotNull
    private final PlatformFontLoader platformFontLoader;
    @NotNull
    private final PlatformResolveInterceptor platformResolveInterceptor;
    @NotNull
    private final TypefaceRequestCache typefaceRequestCache;

    public FontFamilyResolverImpl(@NotNull PlatformFontLoader platformFontLoader2, @NotNull PlatformResolveInterceptor platformResolveInterceptor2, @NotNull TypefaceRequestCache typefaceRequestCache2, @NotNull FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter2, @NotNull PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        Intrinsics.checkNotNullParameter(platformResolveInterceptor2, "platformResolveInterceptor");
        Intrinsics.checkNotNullParameter(typefaceRequestCache2, "typefaceRequestCache");
        Intrinsics.checkNotNullParameter(fontListFontFamilyTypefaceAdapter2, "fontListFontFamilyTypefaceAdapter");
        Intrinsics.checkNotNullParameter(platformFontFamilyTypefaceAdapter, "platformFamilyTypefaceAdapter");
        this.platformFontLoader = platformFontLoader2;
        this.platformResolveInterceptor = platformResolveInterceptor2;
        this.typefaceRequestCache = typefaceRequestCache2;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter2;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new FontFamilyResolverImpl$createDefaultTypeface$1(this);
    }

    /* access modifiers changed from: private */
    public final State<Object> resolve(TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new FontFamilyResolverImpl$resolve$result$1(this, typefaceRequest));
    }

    @NotNull
    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[LOOP:0: B:21:0x006a->B:22:0x006c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object preload(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontFamily r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1) r0
            int r1 = r0.f10184l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f10184l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f10182j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f10184l
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r14 = r0.f10181i
            androidx.compose.ui.text.font.FontFamily r14 = (androidx.compose.ui.text.font.FontFamily) r14
            java.lang.Object r0 = r0.f10180h
            androidx.compose.ui.text.font.FontFamilyResolverImpl r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0055
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r14 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r15 != 0) goto L_0x0043
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0043:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r15 = r13.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r13.platformFontLoader
            r0.f10180h = r13
            r0.f10181i = r14
            r0.f10184l = r3
            java.lang.Object r15 = r15.preload(r14, r2, r0)
            if (r15 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r13
        L_0x0055:
            r15 = r14
            androidx.compose.ui.text.font.FontListFontFamily r15 = (androidx.compose.ui.text.font.FontListFontFamily) r15
            java.util.List r15 = r15.getFonts()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r15.size()
            r1.<init>(r2)
            int r2 = r15.size()
            r3 = 0
        L_0x006a:
            if (r3 >= r2) goto L_0x00a5
            java.lang.Object r4 = r15.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.TypefaceRequest r12 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r6 = r5.interceptFontFamily(r14)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r7 = r4.getWeight()
            androidx.compose.ui.text.font.FontWeight r7 = r5.interceptFontWeight(r7)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            int r4 = r4.m5099getStyle_LCdwA()
            int r8 = r5.m5147interceptFontStyleT2F_aPo(r4)
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r9 = r4.m5139getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r4 = r0.platformFontLoader
            java.lang.Object r10 = r4.getCacheKey()
            r11 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r12)
            int r3 = r3 + 1
            goto L_0x006a
        L_0x00a5:
            androidx.compose.ui.text.font.TypefaceRequestCache r14 = r0.typefaceRequestCache
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2 r15 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            r15.<init>(r0)
            r14.preWarmCache(r1, r15)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    /* renamed from: resolve-DPcqOEQ  reason: not valid java name */
    public State<Object> m5101resolveDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i11, int i12) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m5147interceptFontStyleT2F_aPo(i11), this.platformResolveInterceptor.m5148interceptFontSynthesisMscr08Y(i12), this.platformFontLoader.getCacheKey(), (DefaultConstructorMarker) null));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader2, PlatformResolveInterceptor platformResolveInterceptor2, TypefaceRequestCache typefaceRequestCache2, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter2, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader2, (i11 & 2) != 0 ? PlatformResolveInterceptor.Companion.getDefault$ui_text_release() : platformResolveInterceptor2, (i11 & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache2, (i11 & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), (CoroutineContext) null, 2, (DefaultConstructorMarker) null) : fontListFontFamilyTypefaceAdapter2, (i11 & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
