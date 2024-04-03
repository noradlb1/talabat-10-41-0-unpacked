package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalTextApi
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    /* access modifiers changed from: private */
    @NotNull
    public static final FontMatcher fontMatcher = new FontMatcher();
    @NotNull
    private CoroutineScope asyncLoadScope;
    /* access modifiers changed from: private */
    @NotNull
    public final AsyncTypefaceCache asyncTypefaceCache;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }
    }

    public FontListFontFamilyTypefaceAdapter() {
        this((AsyncTypefaceCache) null, (CoroutineContext) null, 3, (DefaultConstructorMarker) null);
    }

    public FontListFontFamilyTypefaceAdapter(@NotNull AsyncTypefaceCache asyncTypefaceCache2, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(asyncTypefaceCache2, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(coroutineContext, "injectedContext");
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key))));
    }

    @Nullable
    public final Object preload(@NotNull FontFamily fontFamily, @NotNull PlatformFontLoader platformFontLoader, @NotNull Continuation<? super Unit> continuation) {
        FontFamily fontFamily2 = fontFamily;
        PlatformFontLoader platformFontLoader2 = platformFontLoader;
        if (!(fontFamily2 instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }
        FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily2;
        List<Font> fonts = fontListFontFamily.getFonts();
        List<Font> fonts2 = fontListFontFamily.getFonts();
        ArrayList arrayList = new ArrayList(fonts2.size());
        int size = fonts2.size();
        for (int i11 = 0; i11 < size; i11++) {
            Font font = fonts2.get(i11);
            if (FontLoadingStrategy.m5111equalsimpl0(font.m5098getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m5115getAsyncPKNRLFQ())) {
                arrayList.add(font);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Font font2 = (Font) arrayList.get(i12);
            arrayList2.add(TuplesKt.to(font2.getWeight(), FontStyle.m5121boximpl(font2.m5099getStyle_LCdwA())));
        }
        HashSet hashSet = new HashSet(arrayList2.size());
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size3 = arrayList2.size();
        for (int i13 = 0; i13 < size3; i13++) {
            Object obj = arrayList2.get(i13);
            if (hashSet.add((Pair) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size4 = arrayList3.size();
        int i14 = 0;
        while (i14 < size4) {
            Pair pair = (Pair) arrayList3.get(i14);
            FontWeight fontWeight = (FontWeight) pair.component1();
            int r42 = ((FontStyle) pair.component2()).m5127unboximpl();
            List<Font> r15 = fontMatcher.m5120matchFontRetOiIg((List<? extends Font>) fonts, fontWeight, r42);
            TypefaceRequest typefaceRequest = r1;
            TypefaceRequest typefaceRequest2 = new TypefaceRequest(fontFamily, fontWeight, r42, FontSynthesis.Companion.m5139getAllGVVA2EU(), platformFontLoader.getCacheKey(), (DefaultConstructorMarker) null);
            List list = (List) FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(r15, typefaceRequest, this.asyncTypefaceCache, platformFontLoader2, FontListFontFamilyTypefaceAdapter$preload$2$1.INSTANCE).component1();
            if (list != null) {
                arrayList4.add(CollectionsKt___CollectionsKt.first(list));
            }
            i14++;
            FontFamily fontFamily3 = fontFamily;
        }
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(arrayList4, this, platformFontLoader2, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3>) null), continuation);
        if (coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull Function1<? super TypefaceResult.Immutable, Unit> function1, @NotNull Function1<? super TypefaceRequest, ? extends Object> function12) {
        TypefaceRequest typefaceRequest2 = typefaceRequest;
        PlatformFontLoader platformFontLoader2 = platformFontLoader;
        Function1<? super TypefaceRequest, ? extends Object> function13 = function12;
        Intrinsics.checkNotNullParameter(typefaceRequest2, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader2, "platformFontLoader");
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(function13, "createDefaultTypeface");
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m5120matchFontRetOiIg((List<? extends Font>) ((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m5175getFontStyle_LCdwA()), typefaceRequest2, this.asyncTypefaceCache, platformFontLoader2, function13);
        List list = (List) access$firstImmediatelyAvailable.component1();
        Object component2 = access$firstImmediatelyAvailable.component2();
        if (list == null) {
            return new TypefaceResult.Immutable(component2, false, 2, (DefaultConstructorMarker) null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, component2, typefaceRequest, this.asyncTypefaceCache, function1, platformFontLoader);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.asyncLoadScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncFontListLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$resolve$1>) null), 1, (Object) null);
        return new TypefaceResult.Async(asyncFontListLoader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache2, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache2, (i11 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }
}
