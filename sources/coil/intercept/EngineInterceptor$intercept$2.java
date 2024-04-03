package coil.intercept;

import coil.EventListener;
import coil.fetch.Fetcher;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcoil/request/SuccessResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {415, 438, 497}, m = "invokeSuspend", n = {"this_$iv", "fetcher$iv", "request$iv", "size$iv", "eventListener$iv", "options$iv", "type$iv", "this_$iv", "request$iv", "size$iv", "eventListener$iv", "options$iv", "fetchResult$iv", "decoder$iv", "request$iv", "size$iv", "eventListener$iv", "this_$iv$iv", "baseResult$iv", "$this$foldIndices$iv$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f39734h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39735i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39736j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39737k;

    /* renamed from: l  reason: collision with root package name */
    public Object f39738l;

    /* renamed from: m  reason: collision with root package name */
    public Object f39739m;

    /* renamed from: n  reason: collision with root package name */
    public Object f39740n;

    /* renamed from: o  reason: collision with root package name */
    public int f39741o;

    /* renamed from: p  reason: collision with root package name */
    public int f39742p;

    /* renamed from: q  reason: collision with root package name */
    public int f39743q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f39744r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f39745s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ RealMemoryCache.Value f39746t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Object f39747u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Fetcher<Object> f39748v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Interceptor.Chain f39749w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Size f39750x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ EventListener f39751y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ MemoryCache.Key f39752z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, ImageRequest imageRequest, RealMemoryCache.Value value, Object obj, Fetcher<Object> fetcher, Interceptor.Chain chain, Size size, EventListener eventListener, MemoryCache.Key key, Continuation<? super EngineInterceptor$intercept$2> continuation) {
        super(2, continuation);
        this.f39744r = engineInterceptor;
        this.f39745s = imageRequest;
        this.f39746t = value;
        this.f39747u = obj;
        this.f39748v = fetcher;
        this.f39749w = chain;
        this.f39750x = size;
        this.f39751y = eventListener;
        this.f39752z = key;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EngineInterceptor$intercept$2(this.f39744r, this.f39745s, this.f39746t, this.f39747u, this.f39748v, this.f39749w, this.f39750x, this.f39751y, this.f39752z, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SuccessResult> continuation) {
        return ((EngineInterceptor$intercept$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: coil.fetch.FetchResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: coil.fetch.DrawableResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: coil.fetch.SourceResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: coil.fetch.SourceResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: coil.fetch.SourceResult} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x036f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013d A[Catch:{ all -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0140 A[SYNTHETIC, Splitter:B:37:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0190 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0308  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r7 = r25
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f39743q
            r8 = 3
            r9 = 2
            r11 = 1
            r12 = 0
            if (r1 == 0) goto L_0x0095
            if (r1 == r11) goto L_0x0069
            if (r1 == r9) goto L_0x0042
            if (r1 != r8) goto L_0x003a
            int r1 = r7.f39742p
            int r2 = r7.f39741o
            java.lang.Object r3 = r7.f39739m
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r7.f39738l
            coil.fetch.DrawableResult r4 = (coil.fetch.DrawableResult) r4
            java.lang.Object r5 = r7.f39737k
            coil.intercept.EngineInterceptor r5 = (coil.intercept.EngineInterceptor) r5
            java.lang.Object r6 = r7.f39736j
            coil.EventListener r6 = (coil.EventListener) r6
            java.lang.Object r9 = r7.f39735i
            coil.size.Size r9 = (coil.size.Size) r9
            java.lang.Object r13 = r7.f39734h
            coil.request.ImageRequest r13 = (coil.request.ImageRequest) r13
            kotlin.ResultKt.throwOnFailure(r26)
            r10 = r7
            r15 = r8
            r8 = r2
            r2 = r26
            goto L_0x02fd
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0042:
            java.lang.Object r1 = r7.f39740n
            coil.decode.Decoder r1 = (coil.decode.Decoder) r1
            java.lang.Object r2 = r7.f39739m
            coil.fetch.FetchResult r2 = (coil.fetch.FetchResult) r2
            java.lang.Object r3 = r7.f39738l
            coil.decode.Options r3 = (coil.decode.Options) r3
            java.lang.Object r4 = r7.f39737k
            coil.EventListener r4 = (coil.EventListener) r4
            java.lang.Object r5 = r7.f39736j
            coil.size.Size r5 = (coil.size.Size) r5
            java.lang.Object r6 = r7.f39735i
            coil.request.ImageRequest r6 = (coil.request.ImageRequest) r6
            java.lang.Object r9 = r7.f39734h
            coil.intercept.EngineInterceptor r9 = (coil.intercept.EngineInterceptor) r9
            kotlin.ResultKt.throwOnFailure(r26)     // Catch:{ all -> 0x0066 }
            r10 = r1
            r1 = r26
            goto L_0x0199
        L_0x0066:
            r0 = move-exception
            goto L_0x01bb
        L_0x0069:
            int r1 = r7.f39741o
            java.lang.Object r2 = r7.f39739m
            coil.decode.Options r2 = (coil.decode.Options) r2
            java.lang.Object r3 = r7.f39738l
            coil.EventListener r3 = (coil.EventListener) r3
            java.lang.Object r4 = r7.f39737k
            coil.size.Size r4 = (coil.size.Size) r4
            java.lang.Object r5 = r7.f39736j
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            java.lang.Object r6 = r7.f39735i
            coil.fetch.Fetcher r6 = (coil.fetch.Fetcher) r6
            java.lang.Object r13 = r7.f39734h
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            kotlin.ResultKt.throwOnFailure(r26)
            r19 = r1
            r14 = r3
            r15 = r4
            r1 = r26
            r24 = r13
            r13 = r2
            r2 = r6
            r6 = r5
            r5 = r24
            goto L_0x0111
        L_0x0095:
            kotlin.ResultKt.throwOnFailure(r26)
            coil.intercept.EngineInterceptor r1 = r7.f39744r
            coil.request.ImageRequest r2 = r7.f39745s
            java.lang.Object r2 = r2.getData()
            r1.invalidateData(r2)
            coil.memory.RealMemoryCache$Value r1 = r7.f39746t
            if (r1 == 0) goto L_0x00b6
            coil.intercept.EngineInterceptor r1 = r7.f39744r
            coil.bitmap.BitmapReferenceCounter r1 = r1.referenceCounter
            coil.memory.RealMemoryCache$Value r2 = r7.f39746t
            android.graphics.Bitmap r2 = r2.getBitmap()
            r1.decrement(r2)
        L_0x00b6:
            coil.intercept.EngineInterceptor r13 = r7.f39744r
            java.lang.Object r3 = r7.f39747u
            coil.fetch.Fetcher<java.lang.Object> r14 = r7.f39748v
            coil.request.ImageRequest r15 = r7.f39745s
            coil.intercept.Interceptor$Chain r1 = r7.f39749w
            coil.intercept.RealInterceptorChain r1 = (coil.intercept.RealInterceptorChain) r1
            int r6 = r1.getRequestType()
            coil.size.Size r5 = r7.f39750x
            coil.EventListener r4 = r7.f39751y
            coil.memory.RequestService r1 = r13.requestService
            coil.util.SystemCallbacks r2 = r13.systemCallbacks
            boolean r2 = r2.isOnline()
            coil.decode.Options r2 = r1.options(r15, r5, r2)
            r4.fetchStart(r15, r14, r2)
            coil.bitmap.BitmapPool r16 = r13.bitmapPool
            r7.f39734h = r13
            r7.f39735i = r14
            r7.f39736j = r15
            r7.f39737k = r5
            r7.f39738l = r4
            r7.f39739m = r2
            r7.f39741o = r6
            r7.f39743q = r11
            r1 = r14
            r17 = r2
            r2 = r16
            r16 = r4
            r4 = r5
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r25
            java.lang.Object r1 = r1.fetch(r2, r3, r4, r5, r6)
            if (r1 != r0) goto L_0x0108
            return r0
        L_0x0108:
            r5 = r13
            r2 = r14
            r6 = r15
            r14 = r16
            r13 = r17
            r15 = r18
        L_0x0111:
            r4 = r1
            coil.fetch.FetchResult r4 = (coil.fetch.FetchResult) r4
            r14.fetchEnd(r6, r2, r13, r4)
            boolean r1 = r4 instanceof coil.fetch.SourceResult
            if (r1 == 0) goto L_0x01c7
            kotlin.coroutines.CoroutineContext r1 = r25.getContext()     // Catch:{ all -> 0x01b8 }
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r1)     // Catch:{ all -> 0x01b8 }
            if (r19 != 0) goto L_0x013a
            coil.target.Target r1 = r6.getTarget()     // Catch:{ all -> 0x0136 }
            if (r1 != 0) goto L_0x013a
            coil.request.CachePolicy r1 = r6.getMemoryCachePolicy()     // Catch:{ all -> 0x0136 }
            boolean r1 = r1.getWriteEnabled()     // Catch:{ all -> 0x0136 }
            if (r1 != 0) goto L_0x013a
            r1 = r11
            goto L_0x013b
        L_0x0136:
            r0 = move-exception
            r2 = r4
            goto L_0x01bb
        L_0x013a:
            r1 = 0
        L_0x013b:
            if (r1 == 0) goto L_0x0140
            coil.decode.EmptyDecoder r1 = coil.decode.EmptyDecoder.INSTANCE     // Catch:{ all -> 0x0136 }
            goto L_0x0161
        L_0x0140:
            coil.decode.Decoder r1 = r6.getDecoder()     // Catch:{ all -> 0x01b8 }
            if (r1 != 0) goto L_0x0161
            coil.ComponentRegistry r1 = r5.registry     // Catch:{ all -> 0x0136 }
            java.lang.Object r2 = r6.getData()     // Catch:{ all -> 0x0136 }
            r3 = r4
            coil.fetch.SourceResult r3 = (coil.fetch.SourceResult) r3     // Catch:{ all -> 0x0136 }
            okio.BufferedSource r3 = r3.getSource()     // Catch:{ all -> 0x0136 }
            r16 = r4
            coil.fetch.SourceResult r16 = (coil.fetch.SourceResult) r16     // Catch:{ all -> 0x0136 }
            java.lang.String r10 = r16.getMimeType()     // Catch:{ all -> 0x0136 }
            coil.decode.Decoder r1 = coil.util.ComponentRegistries.requireDecoder(r1, r2, r3, r10)     // Catch:{ all -> 0x0136 }
        L_0x0161:
            r10 = r1
            r14.decodeStart(r6, r10, r13)     // Catch:{ all -> 0x01b8 }
            coil.bitmap.BitmapPool r2 = r5.bitmapPool     // Catch:{ all -> 0x01b8 }
            r1 = r4
            coil.fetch.SourceResult r1 = (coil.fetch.SourceResult) r1     // Catch:{ all -> 0x01b8 }
            okio.BufferedSource r3 = r1.getSource()     // Catch:{ all -> 0x01b8 }
            r7.f39734h = r5     // Catch:{ all -> 0x01b8 }
            r7.f39735i = r6     // Catch:{ all -> 0x01b8 }
            r7.f39736j = r15     // Catch:{ all -> 0x01b8 }
            r7.f39737k = r14     // Catch:{ all -> 0x01b8 }
            r7.f39738l = r13     // Catch:{ all -> 0x01b8 }
            r7.f39739m = r4     // Catch:{ all -> 0x01b8 }
            r7.f39740n = r10     // Catch:{ all -> 0x01b8 }
            r7.f39743q = r9     // Catch:{ all -> 0x01b8 }
            r1 = r10
            r9 = r4
            r4 = r15
            r16 = r5
            r5 = r13
            r18 = r6
            r6 = r25
            java.lang.Object r1 = r1.decode(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x01b6 }
            if (r1 != r0) goto L_0x0191
            return r0
        L_0x0191:
            r2 = r9
            r3 = r13
            r4 = r14
            r5 = r15
            r9 = r16
            r6 = r18
        L_0x0199:
            coil.decode.DecodeResult r1 = (coil.decode.DecodeResult) r1     // Catch:{ all -> 0x0066 }
            r4.decodeEnd(r6, r10, r3, r1)     // Catch:{ all -> 0x0066 }
            coil.fetch.DrawableResult r10 = new coil.fetch.DrawableResult
            android.graphics.drawable.Drawable r13 = r1.getDrawable()
            boolean r1 = r1.isSampled()
            coil.fetch.SourceResult r2 = (coil.fetch.SourceResult) r2
            coil.decode.DataSource r2 = r2.getDataSource()
            r10.<init>(r13, r1, r2)
            r13 = r3
            r14 = r4
            r15 = r5
            r5 = r9
            goto L_0x01d7
        L_0x01b6:
            r0 = move-exception
            goto L_0x01ba
        L_0x01b8:
            r0 = move-exception
            r9 = r4
        L_0x01ba:
            r2 = r9
        L_0x01bb:
            coil.fetch.SourceResult r2 = (coil.fetch.SourceResult) r2
            okio.BufferedSource r1 = r2.getSource()
            java.io.Closeable r1 = (java.io.Closeable) r1
            coil.util.Extensions.closeQuietly(r1)
            throw r0
        L_0x01c7:
            r9 = r4
            r16 = r5
            r18 = r6
            boolean r1 = r9 instanceof coil.fetch.DrawableResult
            if (r1 == 0) goto L_0x03b9
            r10 = r9
            coil.fetch.DrawableResult r10 = (coil.fetch.DrawableResult) r10
            r5 = r16
            r6 = r18
        L_0x01d7:
            kotlin.coroutines.CoroutineContext r1 = r25.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r1)
            java.util.List r1 = r6.getTransformations()
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x01ea
            goto L_0x0363
        L_0x01ea:
            android.graphics.drawable.Drawable r2 = r10.getDrawable()
            boolean r2 = r2 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r3 = " to apply transformations: "
            r4 = 4
            java.lang.String r9 = "EngineInterceptor"
            if (r2 == 0) goto L_0x025d
            android.graphics.drawable.Drawable r2 = r10.getDrawable()
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            android.graphics.Bitmap r2 = r2.getBitmap()
            android.graphics.Bitmap$Config[] r11 = coil.memory.RequestService.VALID_TRANSFORMATION_CONFIGS
            java.lang.String r8 = "resultBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            android.graphics.Bitmap$Config r8 = coil.util.Bitmaps.getSafeConfig(r2)
            boolean r8 = kotlin.collections.ArraysKt___ArraysKt.contains((T[]) r11, r8)
            if (r8 == 0) goto L_0x0214
            goto L_0x02b4
        L_0x0214:
            coil.util.Logger r8 = r5.logger
            if (r8 != 0) goto L_0x021b
            goto L_0x0242
        L_0x021b:
            int r11 = r8.getLevel()
            if (r11 > r4) goto L_0x0240
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "Converting bitmap with config "
            r11.append(r4)
            android.graphics.Bitmap$Config r2 = coil.util.Bitmaps.getSafeConfig(r2)
            r11.append(r2)
            r11.append(r3)
            r11.append(r1)
            java.lang.String r2 = r11.toString()
            r3 = 4
            r8.log(r9, r3, r2, r12)
        L_0x0240:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0242:
            coil.decode.DrawableDecoderService r18 = r5.drawableDecoder
            android.graphics.drawable.Drawable r19 = r10.getDrawable()
            android.graphics.Bitmap$Config r20 = r13.getConfig()
            coil.size.Scale r22 = r13.getScale()
            boolean r23 = r13.getAllowInexactSize()
            r21 = r15
            android.graphics.Bitmap r2 = r18.convert(r19, r20, r21, r22, r23)
            goto L_0x02b4
        L_0x025d:
            boolean r2 = r6.getAllowConversionToBitmap()
            if (r2 == 0) goto L_0x033e
            coil.util.Logger r2 = r5.logger
            if (r2 != 0) goto L_0x026a
            goto L_0x029a
        L_0x026a:
            int r4 = r2.getLevel()
            r8 = 4
            if (r4 > r8) goto L_0x0298
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Converting drawable of type "
            r4.append(r8)
            android.graphics.drawable.Drawable r8 = r10.getDrawable()
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getCanonicalName()
            r4.append(r8)
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            r4 = 4
            r2.log(r9, r4, r3, r12)
        L_0x0298:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x029a:
            coil.decode.DrawableDecoderService r18 = r5.drawableDecoder
            android.graphics.drawable.Drawable r19 = r10.getDrawable()
            android.graphics.Bitmap$Config r20 = r13.getConfig()
            coil.size.Scale r22 = r13.getScale()
            boolean r23 = r13.getAllowInexactSize()
            r21 = r15
            android.graphics.Bitmap r2 = r18.convert(r19, r20, r21, r22, r23)
        L_0x02b4:
            java.lang.String r3 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r14.transformStart(r6, r2)
            int r3 = r1.size()
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x030d
            r13 = r6
            r4 = r10
            r6 = r14
            r9 = r15
            r8 = 0
            r10 = r7
            r24 = r3
            r3 = r1
            r1 = r24
        L_0x02cf:
            int r11 = r8 + 1
            java.lang.Object r8 = r3.get(r8)
            coil.transform.Transformation r8 = (coil.transform.Transformation) r8
            coil.bitmap.BitmapPool r14 = r5.bitmapPool
            java.lang.String r15 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            r10.f39734h = r13
            r10.f39735i = r9
            r10.f39736j = r6
            r10.f39737k = r5
            r10.f39738l = r4
            r10.f39739m = r3
            r10.f39740n = r12
            r10.f39741o = r11
            r10.f39742p = r1
            r15 = 3
            r10.f39743q = r15
            java.lang.Object r2 = r8.transform(r14, r2, r9, r10)
            if (r2 != r0) goto L_0x02fc
            return r0
        L_0x02fc:
            r8 = r11
        L_0x02fd:
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            kotlin.coroutines.CoroutineContext r11 = r10.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r11)
            if (r8 <= r1) goto L_0x02cf
            r18 = r4
            r14 = r6
            r6 = r13
            goto L_0x0310
        L_0x030d:
            r18 = r10
            r10 = r7
        L_0x0310:
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r14.transformEnd(r6, r2)
            android.content.Context r0 = r6.getContext()
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            r1.<init>(r0, r2)
            r20 = 0
            r21 = 0
            r22 = 6
            r23 = 0
            r19 = r1
            coil.fetch.DrawableResult r0 = coil.fetch.DrawableResult.copy$default(r18, r19, r20, r21, r22, r23)
            r24 = r10
            r10 = r0
            r0 = r24
            goto L_0x0364
        L_0x033e:
            coil.util.Logger r0 = r5.logger
            if (r0 != 0) goto L_0x0345
            goto L_0x0363
        L_0x0345:
            int r1 = r0.getLevel()
            r2 = 4
            if (r1 > r2) goto L_0x0361
            android.graphics.drawable.Drawable r1 = r10.getDrawable()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r3 = "allowConversionToBitmap=false, skipping transformations for type "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            r0.log(r9, r2, r1, r12)
        L_0x0361:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0363:
            r0 = r7
        L_0x0364:
            android.graphics.drawable.Drawable r1 = r10.getDrawable()
            boolean r2 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r2 == 0) goto L_0x036f
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            goto L_0x0370
        L_0x036f:
            r1 = r12
        L_0x0370:
            if (r1 != 0) goto L_0x0373
            goto L_0x037f
        L_0x0373:
            android.graphics.Bitmap r1 = r1.getBitmap()
            if (r1 != 0) goto L_0x037a
            goto L_0x037f
        L_0x037a:
            r1.prepareToDraw()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x037f:
            android.graphics.drawable.Drawable r1 = r10.component1()
            boolean r2 = r10.component2()
            coil.decode.DataSource r3 = r10.component3()
            coil.intercept.EngineInterceptor r4 = r0.f39744r
            r4.validateDrawable(r1)
            coil.intercept.EngineInterceptor r4 = r0.f39744r
            coil.request.ImageRequest r5 = r0.f39745s
            coil.memory.MemoryCache$Key r6 = r0.f39752z
            boolean r4 = r4.writeToMemoryCache(r5, r6, r1, r2)
            coil.request.ImageRequest r5 = r0.f39745s
            coil.memory.MemoryCache$Key r6 = r0.f39752z
            if (r4 == 0) goto L_0x03a1
            r12 = r6
        L_0x03a1:
            coil.intercept.Interceptor$Chain r0 = r0.f39749w
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            android.graphics.Bitmap r0 = r0.getCached()
            if (r0 == 0) goto L_0x03ad
            r10 = 1
            goto L_0x03ae
        L_0x03ad:
            r10 = 0
        L_0x03ae:
            coil.request.ImageResult$Metadata r0 = new coil.request.ImageResult$Metadata
            r0.<init>(r12, r2, r3, r10)
            coil.request.SuccessResult r2 = new coil.request.SuccessResult
            r2.<init>(r1, r5, r0)
            return r2
        L_0x03b9:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$intercept$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
