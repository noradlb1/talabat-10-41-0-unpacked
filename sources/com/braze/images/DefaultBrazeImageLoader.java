package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.widget.ImageView;
import com.appboy.R;
import com.appboy.models.cards.Card;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\r0\r2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J2\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J$\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J&\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010(\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001dH\u0007R\u0014\u0010*\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0,8G¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001d8G@BX\u000e¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b2\u00104R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u00103¨\u00069"}, d2 = {"Lcom/braze/images/DefaultBrazeImageLoader;", "Lcom/braze/images/IBrazeImageLoader;", "Landroid/content/Context;", "context", "", "imageUrl", "Landroid/widget/ImageView;", "imageView", "Lcom/braze/enums/BrazeViewBounds;", "viewBounds", "", "renderUrlIntoView", "key", "Landroid/graphics/Bitmap;", "bitmap", "kotlin.jvm.PlatformType", "putBitmapIntoMemCache", "initDiskCacheTask", "renderUrlIntoViewTask", "Lcom/appboy/models/cards/Card;", "card", "renderUrlIntoCardView", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessage", "renderUrlIntoInAppMessageView", "Landroid/os/Bundle;", "extras", "getPushBitmapFromUrl", "getInAppMessageBitmapFromUrl", "", "isOffline", "setOffline", "getBitmapFromUrl", "Landroid/net/Uri;", "imageUri", "downloadBitmapFromUrl", "getBitmapFromCache", "getBitmapFromMemCache", "getBitmapFromDiskCache", "skipDiskCache", "putBitmapIntoCache", "Ljava/util/concurrent/locks/ReentrantLock;", "diskCacheLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroid/util/LruCache;", "memoryCache", "Landroid/util/LruCache;", "getMemoryCache", "()Landroid/util/LruCache;", "<set-?>", "isDiskCacheStarting", "Z", "()Z", "<init>", "(Landroid/content/Context;)V", "Companion", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class DefaultBrazeImageLoader implements IBrazeImageLoader {
    public static final String BRAZE_LRU_CACHE_FOLDER = "appboy.imageloader.lru.cache";
    public static final b Companion = new b((DefaultConstructorMarker) null);
    private static final int DISK_CACHE_SIZE = 52428800;
    /* access modifiers changed from: private */
    public static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) DefaultBrazeImageLoader.class);
    /* access modifiers changed from: private */
    public final ReentrantLock diskCacheLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public bo.app.h diskLruCache;
    /* access modifiers changed from: private */
    public boolean isDiskCacheStarting = true;
    private boolean isOffline;
    private final LruCache<String, Bitmap> memoryCache = new a(BrazeImageUtils.getImageLoaderCacheSize());

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/braze/images/DefaultBrazeImageLoader$a", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "key", "image", "", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a extends LruCache<String, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43725a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i11) {
            super(i11);
            this.f43725a = i11;
        }

        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(bitmap, "image");
            return bitmap.getByteCount();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43728g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DefaultBrazeImageLoader f43729h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, DefaultBrazeImageLoader defaultBrazeImageLoader) {
            super(0);
            this.f43728g = str;
            this.f43729h = defaultBrazeImageLoader;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got bitmap from mem cache for key " + this.f43728g + "\nMemory cache stats: " + this.f43729h.getMemoryCache();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43730g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f43730g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Got bitmap from disk cache for key ", this.f43730g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43731g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f43731g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("No cache hit for bitmap: ", this.f43731g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43732g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f43732g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Disk cache still starting. Cannot retrieve key from disk cache: ", this.f43732g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43733g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f43733g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Getting bitmap from disk cache for key: ", this.f43733g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43734b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot retrieve bitmap with blank image url";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43735b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cache is currently in offline mode. Not downloading bitmap.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43736g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(0);
            this.f43736g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to get bitmap from url. Url: ", this.f43736g);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.images.DefaultBrazeImageLoader$initDiskCacheTask$1", f = "DefaultBrazeImageLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43737h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f43738i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ DefaultBrazeImageLoader f43739j;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f43740b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Initializing disk cache";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f43741b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Disk cache initialized";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f43742b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught exception creating new disk cache. Unable to create new disk cache";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Context context, DefaultBrazeImageLoader defaultBrazeImageLoader, Continuation<? super k> continuation) {
            super(2, continuation);
            this.f43738i = context;
            this.f43739j = defaultBrazeImageLoader;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.f43738i, this.f43739j, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f43737h == 0) {
                ResultKt.throwOnFailure(obj);
                File a11 = DefaultBrazeImageLoader.Companion.a(this.f43738i, DefaultBrazeImageLoader.BRAZE_LRU_CACHE_FOLDER);
                ReentrantLock access$getDiskCacheLock$p = this.f43739j.diskCacheLock;
                DefaultBrazeImageLoader defaultBrazeImageLoader = this.f43739j;
                access$getDiskCacheLock$p.lock();
                try {
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43740b, 14, (Object) null);
                    defaultBrazeImageLoader.diskLruCache = new bo.app.h(a11, 1, 1, 52428800);
                    BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f43741b, 14, (Object) null);
                    defaultBrazeImageLoader.isDiskCacheStarting = false;
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f43742b, 8, (Object) null);
                } catch (Throwable th2) {
                    access$getDiskCacheLock$p.unlock();
                    throw th2;
                }
                Unit unit = Unit.INSTANCE;
                access$getDiskCacheLock$p.unlock();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43743g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(0);
            this.f43743g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding bitmap to mem cache for key ", this.f43743g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43744g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(0);
            this.f43744g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Skipping disk cache for key: ", this.f43744g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43745g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f43745g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding bitmap to disk cache for key ", this.f43745g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f43746b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot retrieve bitmap with a blank image url";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43747g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(String str) {
            super(0);
            this.f43747g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to render url into view. Url: ", this.f43747g);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.images.DefaultBrazeImageLoader$renderUrlIntoViewTask$1", f = "DefaultBrazeImageLoader.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class q extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f43748h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DefaultBrazeImageLoader f43749i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Context f43750j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f43751k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ BrazeViewBounds f43752l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ ImageView f43753m;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f43754g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(0);
                this.f43754g = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Failed to retrieve bitmap from url: ", this.f43754g);
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.images.DefaultBrazeImageLoader$renderUrlIntoViewTask$1$2", f = "DefaultBrazeImageLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: h  reason: collision with root package name */
            public int f43755h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ String f43756i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ ImageView f43757j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ Bitmap f43758k;

            /* renamed from: l  reason: collision with root package name */
            public final /* synthetic */ BrazeViewBounds f43759l;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, ImageView imageView, Bitmap bitmap, BrazeViewBounds brazeViewBounds, Continuation<? super b> continuation) {
                super(2, continuation);
                this.f43756i = str;
                this.f43757j = imageView;
                this.f43758k = bitmap;
                this.f43759l = brazeViewBounds;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.f43756i, this.f43757j, this.f43758k, this.f43759l, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f43755h == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.f43756i;
                    Object tag = this.f43757j.getTag(R.string.com_braze_image_lru_cache_image_url_key);
                    if (tag != null) {
                        if (Intrinsics.areEqual((Object) str, (Object) (String) tag)) {
                            this.f43757j.setImageBitmap(this.f43758k);
                            if (this.f43759l == BrazeViewBounds.BASE_CARD_VIEW) {
                                BrazeImageUtils.resizeImageViewToBitmapDimensions(this.f43758k, this.f43757j);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(DefaultBrazeImageLoader defaultBrazeImageLoader, Context context, String str, BrazeViewBounds brazeViewBounds, ImageView imageView, Continuation<? super q> continuation) {
            super(2, continuation);
            this.f43749i = defaultBrazeImageLoader;
            this.f43750j = context;
            this.f43751k = str;
            this.f43752l = brazeViewBounds;
            this.f43753m = imageView;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((q) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new q(this.f43749i, this.f43750j, this.f43751k, this.f43752l, this.f43753m, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f43748h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                TrafficStats.setThreadStatsTag(1337);
                Bitmap bitmapFromUrl = this.f43749i.getBitmapFromUrl(this.f43750j, this.f43751k, this.f43752l);
                if (bitmapFromUrl == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(this.f43751k), 14, (Object) null);
                } else {
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    b bVar = new b(this.f43751k, this.f43753m, bitmapFromUrl, this.f43752l, (Continuation<? super b>) null);
                    this.f43748h = 1;
                    if (BuildersKt.withContext(main, bVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43760g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(boolean z11) {
            super(0);
            this.f43760g = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("DefaultBrazeImageLoader outbound network requests are now ", this.f43760g ? "disabled" : "enabled");
        }
    }

    public DefaultBrazeImageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initDiskCacheTask(context);
    }

    @JvmStatic
    public static final void deleteStoredData(Context context) {
        Companion.a(context);
    }

    public static /* synthetic */ Bitmap downloadBitmapFromUrl$default(DefaultBrazeImageLoader defaultBrazeImageLoader, Context context, Uri uri, BrazeViewBounds brazeViewBounds, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return defaultBrazeImageLoader.downloadBitmapFromUrl(context, uri, brazeViewBounds);
    }

    @JvmStatic
    public static final File getDiskCacheDir(Context context, String str) {
        return Companion.a(context, str);
    }

    private final void initDiskCacheTask(Context context) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new k(context, this, (Continuation<? super k>) null), 3, (Object) null);
    }

    private final Bitmap putBitmapIntoMemCache(String str, Bitmap bitmap) {
        return this.memoryCache.put(str, bitmap);
    }

    private final void renderUrlIntoView(Context context, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        String str2 = str;
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) o.f43746b, 7, (Object) null);
            return;
        }
        try {
            renderUrlIntoViewTask(context, imageView, brazeViewBounds, str2);
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new p(str2), 4, (Object) null);
        }
    }

    private final void renderUrlIntoViewTask(Context context, ImageView imageView, BrazeViewBounds brazeViewBounds, String str) {
        imageView.setTag(R.string.com_braze_image_lru_cache_image_url_key, str);
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new q(this, context, str, brazeViewBounds, imageView, (Continuation<? super q>) null), 3, (Object) null);
    }

    public final Bitmap downloadBitmapFromUrl(Context context, Uri uri, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        if (brazeViewBounds == null) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return BrazeImageUtils.getBitmap(context, uri, brazeViewBounds);
    }

    public final Bitmap getBitmapFromCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bitmap bitmap = this.memoryCache.get(str);
        if (bitmap == null) {
            Bitmap bitmapFromDiskCache = getBitmapFromDiskCache(str);
            if (bitmapFromDiskCache == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(str), 7, (Object) null);
                return null;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d(str), 6, (Object) null);
            putBitmapIntoMemCache(str, bitmapFromDiskCache);
            return bitmapFromDiskCache;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new c(str, this), 6, (Object) null);
        return bitmap;
    }

    public final Bitmap getBitmapFromDiskCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            bo.app.h hVar = null;
            if (isDiskCacheStarting()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new f(str), 6, (Object) null);
            } else {
                bo.app.h hVar2 = this.diskLruCache;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    hVar2 = null;
                }
                if (hVar2.a(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new g(str), 6, (Object) null);
                    bo.app.h hVar3 = this.diskLruCache;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    } else {
                        hVar = hVar3;
                    }
                    Bitmap b11 = hVar.b(str);
                    reentrantLock.unlock();
                    return b11;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Bitmap getBitmapFromMemCache(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.memoryCache.get(str);
    }

    public final Bitmap getBitmapFromUrl(Context context, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f43734b, 7, (Object) null);
            return null;
        }
        try {
            Bitmap bitmapFromCache = getBitmapFromCache(str);
            if (bitmapFromCache != null) {
                return bitmapFromCache;
            }
            if (this.isOffline) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) i.f43735b, 7, (Object) null);
            } else {
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "imageUri");
                Bitmap downloadBitmapFromUrl = downloadBitmapFromUrl(context, parse, brazeViewBounds);
                if (downloadBitmapFromUrl != null) {
                    putBitmapIntoCache(str, downloadBitmapFromUrl, BrazeFileUtils.isLocalUri(parse));
                    return downloadBitmapFromUrl;
                }
            }
            return null;
        } catch (Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th2, false, (Function0) new j(str), 4, (Object) null);
        }
    }

    public Bitmap getInAppMessageBitmapFromUrl(Context context, IInAppMessage iInAppMessage, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        return getBitmapFromUrl(context, str, brazeViewBounds);
    }

    public final LruCache<String, Bitmap> getMemoryCache() {
        return this.memoryCache;
    }

    public Bitmap getPushBitmapFromUrl(Context context, Bundle bundle, String str, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        return getBitmapFromUrl(context, str, brazeViewBounds);
    }

    public final boolean isDiskCacheStarting() {
        return this.isDiskCacheStarting;
    }

    public final void putBitmapIntoCache(String str, Bitmap bitmap, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (getBitmapFromMemCache(str) == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new l(str), 7, (Object) null);
            this.memoryCache.put(str, bitmap);
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new m(str), 7, (Object) null);
            return;
        }
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            if (!isDiskCacheStarting()) {
                bo.app.h hVar = this.diskLruCache;
                bo.app.h hVar2 = null;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    hVar = null;
                }
                if (!hVar.a(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new n(str), 7, (Object) null);
                    bo.app.h hVar3 = this.diskLruCache;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                    } else {
                        hVar2 = hVar3;
                    }
                    hVar2.a(str, bitmap);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void renderUrlIntoCardView(Context context, Card card, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        renderUrlIntoView(context, str, imageView, brazeViewBounds);
    }

    public void renderUrlIntoInAppMessageView(Context context, IInAppMessage iInAppMessage, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        renderUrlIntoView(context, str, imageView, brazeViewBounds);
    }

    public void setOffline(boolean z11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new r(z11), 6, (Object) null);
        this.isOffline = z11;
    }

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u001a\u0010\t\u001a\u00020\u00068\u0006XT¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/braze/images/DefaultBrazeImageLoader$b;", "", "Landroid/content/Context;", "context", "", "a", "", "uniqueName", "Ljava/io/File;", "BRAZE_LRU_CACHE_FOLDER", "Ljava/lang/String;", "getBRAZE_LRU_CACHE_FOLDER$annotations", "()V", "", "DISK_CACHE_SIZE", "I", "TAG", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ File f43726g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(File file) {
                super(0);
                this.f43726g = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Deleting lru image cache directory at: ", this.f43726g.getAbsolutePath());
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: com.braze.images.DefaultBrazeImageLoader$b$b  reason: collision with other inner class name */
        public static final class C0040b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0040b f43727b = new C0040b();

            public C0040b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to delete stored data in image loader";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                File file = new File(context.getCacheDir(), DefaultBrazeImageLoader.BRAZE_LRU_CACHE_FOLDER);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(file), 6, (Object) null);
                BrazeFileUtils.deleteFileOrDirectory(file);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) C0040b.f43727b, 4, (Object) null);
            }
        }

        @JvmStatic
        public final File a(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "uniqueName");
            return new File(context.getCacheDir().getPath() + File.separator + str);
        }
    }
}
