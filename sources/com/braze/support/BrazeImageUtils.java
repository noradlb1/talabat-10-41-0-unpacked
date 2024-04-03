package com.braze.support;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import com.braze.enums.BrazeViewBounds;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.bytebuddy.jar.asm.Opcodes;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007\u001a,\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u000e\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014\u001a$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u000e\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0006\u0010\u001f\u001a\u00020\u0001\u001a \u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\u0016\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001\u001a\"\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020+\u001a\u0014\u0010,\u001a\u00020(*\u00020+2\b\u0010)\u001a\u0004\u0018\u00010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"MAX_IMAGE_CACHE_SIZE_BYTES", "", "MIN_IMAGE_CACHE_SIZE_BYTES", "RUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT", "getRUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT$annotations", "()V", "TAG", "", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "destinationWidth", "destinationHeight", "decodeSampledBitmapFromStream", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "imageMetadata", "getBitmap", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "viewBounds", "Lcom/braze/enums/BrazeViewBounds;", "getBitmapMetadataFromStream", "getDensityDpi", "getDestinationHeightAndWidthPixels", "Lkotlin/Pair;", "getDisplayHeightAndWidthPixels", "getDisplayWidthPixels", "getImageLoaderCacheSize", "getLocalBitmap", "getPixelsFromDensityAndDp", "dpi", "dp", "getRemoteBitmap", "populateDisplayMetricsFromDisplay", "Landroid/util/DisplayMetrics;", "resizeImageViewToBitmapDimensions", "", "bitmap", "imageView", "Landroid/widget/ImageView;", "resizeToBitmapDimensions", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BrazeImageUtils {
    private static final int MAX_IMAGE_CACHE_SIZE_BYTES = 33554432;
    private static final int MIN_IMAGE_CACHE_SIZE_BYTES = 1024;
    public static final int RUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT = 8;
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("BrazeImageUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43903b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not sampling on 0 destination width or height";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f43904g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43905h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43906i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BitmapFactory.Options options, int i11, int i12) {
            super(0);
            this.f43904g = options;
            this.f43905h = i11;
            this.f43906i = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Calculating sample size for source image bounds: (width " + this.f43904g.outWidth + " height " + this.f43904g.outHeight + ") and destination image bounds: (width " + this.f43905h + " height " + this.f43906i + ')';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f43907g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43908h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43909i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Ref.IntRef intRef, int i11, int i12) {
            super(0);
            this.f43907g = intRef;
            this.f43908h = i11;
            this.f43909i = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using image sample size of " + this.f43907g.element + ". Image will be scaled to width: " + (this.f43908h / this.f43907g.element) + " and height: " + (this.f43909i / this.f43907g.element);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f43910g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Uri uri) {
            super(0);
            this.f43910g = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Uri with unknown scheme received. Not getting image. Uri: ", this.f43910g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f43911g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Uri uri) {
            super(0);
            this.f43911g = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Local bitmap path is null. URI: ", this.f43911g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f43912g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Uri uri) {
            super(0);
            this.f43912g = uri;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Local bitmap file does not exist. URI: ", this.f43912g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f43913g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(File file) {
            super(0);
            this.f43913g = file;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Retrieving image from local path: ", this.f43913g.getAbsolutePath());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43914b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Destination bounds unset. Loading entire bitmap into memory.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43915g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43916h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(int i11, int i12) {
            super(0);
            this.f43915g = i11;
            this.f43916h = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sampling bitmap with destination image bounds: (height " + this.f43915g + " width " + this.f43916h + ')';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Uri f43917g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f43918h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Uri uri, BitmapFactory.Options options) {
            super(0);
            this.f43917g = uri;
            this.f43918h = options;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The bitmap metadata with image uri " + this.f43917g + " had bounds: (height " + this.f43918h.outHeight + " width " + this.f43918h.outWidth + "). Returning a bitmap with no sampling.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43919b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Decoding sampled bitmap";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Exception f43920g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Exception exc) {
            super(0);
            this.f43920g = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Exception occurred when attempting to retrieve local bitmap. ", this.f43920g.getMessage());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f43921b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "IOException during closing of bitmap metadata image stream.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43922g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f43922g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("SDK is in offline mode, not downloading remote bitmap with uri: ", this.f43922g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ URL f43924h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(int i11, URL url) {
            super(0);
            this.f43923g = i11;
            this.f43924h = url;
        }

        /* renamed from: a */
        public final String invoke() {
            return "HTTP response code was " + this.f43923g + ". Bitmap with url " + this.f43924h + " could not be downloaded.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43926h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(int i11, int i12) {
            super(0);
            this.f43925g = i11;
            this.f43926h = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sampling bitmap with destination image bounds: (height " + this.f43925g + " width " + this.f43926h + ')';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ URL f43927g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f43928h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(URL url, BitmapFactory.Options options) {
            super(0);
            this.f43927g = url;
            this.f43928h = options;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The bitmap metadata with image url " + this.f43927g + " had bounds: (height " + this.f43928h.outHeight + " width " + this.f43928h.outWidth + "). Returning a bitmap with no sampling.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43929g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Exception f43930h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(String str, Exception exc) {
            super(0);
            this.f43929g = str;
            this.f43930h = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception in image bitmap download for Uri: " + this.f43929g + ' ' + this.f43930h.getMessage();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s f43931b = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "IOException during closing of bitmap metadata download stream.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final t f43932b = new t();

        public t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Neither source bitmap nor ImageView may be null. Not resizing ImageView";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final u f43933b = new u();

        public u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Bitmap dimensions cannot be 0. Not resizing ImageView";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final v f43934b = new v();

        public v() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "ImageView dimensions cannot be 0. Not resizing ImageView";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f43935g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(float f11) {
            super(0);
            this.f43935g = f11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Resizing ImageView to aspect ratio: ", Float.valueOf(this.f43935g));
        }
    }

    public static final int calculateInSampleSize(BitmapFactory.Options options, int i11, int i12) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (i12 == 0 || i11 == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43903b, 14, (Object) null);
            return 1;
        }
        int i13 = options.outHeight;
        int i14 = options.outWidth;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(options, i11, i12), 14, (Object) null);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        if (i13 > i12 || i14 > i11) {
            int i15 = i13 / 2;
            int i16 = i14 / 2;
            while (true) {
                int i17 = intRef.element;
                if (i15 / i17 < i12 || i16 / i17 < i11) {
                    break;
                }
                intRef.element = i17 * 2;
            }
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(intRef, i14, i13), 14, (Object) null);
        return intRef.element;
    }

    private static final Bitmap decodeSampledBitmapFromStream(InputStream inputStream, BitmapFactory.Options options, int i11, int i12) {
        options.inSampleSize = calculateInSampleSize(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, options);
    }

    public static final Bitmap getBitmap(Context context, Uri uri, BrazeViewBounds brazeViewBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(brazeViewBounds, "viewBounds");
        Pair<Integer, Integer> destinationHeightAndWidthPixels = getDestinationHeightAndWidthPixels(context, brazeViewBounds);
        int intValue = destinationHeightAndWidthPixels.component1().intValue();
        int intValue2 = destinationHeightAndWidthPixels.component2().intValue();
        if (BrazeFileUtils.isLocalUri(uri)) {
            return getLocalBitmap(uri, intValue2, intValue);
        }
        if (BrazeFileUtils.isRemoteUri(uri)) {
            return getRemoteBitmap(uri, intValue2, intValue);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new d(uri), 12, (Object) null);
        return null;
    }

    public static /* synthetic */ Bitmap getBitmap$default(Context context, Uri uri, BrazeViewBounds brazeViewBounds, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return getBitmap(context, uri, brazeViewBounds);
    }

    public static final BitmapFactory.Options getBitmapMetadataFromStream(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, options);
        return options;
    }

    public static final int getDensityDpi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getConfiguration().densityDpi;
    }

    private static final Pair<Integer, Integer> getDestinationHeightAndWidthPixels(Context context, BrazeViewBounds brazeViewBounds) {
        Pair<Integer, Integer> displayHeightAndWidthPixels = getDisplayHeightAndWidthPixels(context);
        int intValue = displayHeightAndWidthPixels.component1().intValue();
        int intValue2 = displayHeightAndWidthPixels.component2().intValue();
        if (BrazeViewBounds.NO_BOUNDS == brazeViewBounds) {
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        int densityDpi = getDensityDpi(context);
        return new Pair<>(Integer.valueOf(Math.min(intValue, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getHeightDp()))), Integer.valueOf(Math.min(intValue2, getPixelsFromDensityAndDp(densityDpi, brazeViewBounds.getWidthDp()))));
    }

    private static final Pair<Integer, Integer> getDisplayHeightAndWidthPixels(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            WindowManager windowManager = (WindowManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                Rect a11 = windowManager.getCurrentWindowMetrics().getBounds();
                Intrinsics.checkNotNullExpressionValue(a11, "windowManager.currentWindowMetrics.bounds");
                return new Pair<>(Integer.valueOf(a11.height()), Integer.valueOf(a11.width()));
            }
            DisplayMetrics populateDisplayMetricsFromDisplay = populateDisplayMetricsFromDisplay(context);
            return new Pair<>(Integer.valueOf(populateDisplayMetricsFromDisplay.heightPixels), Integer.valueOf(populateDisplayMetricsFromDisplay.widthPixels));
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public static final int getDisplayWidthPixels(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDisplayHeightAndWidthPixels(context).getSecond().intValue();
    }

    public static final int getImageLoaderCacheSize() {
        return Math.max(1024, Math.min((int) Math.min(Runtime.getRuntime().maxMemory() / ((long) 8), 2147483647L), MAX_IMAGE_CACHE_SIZE_BYTES));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ Exception -> 0x0119, all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[Catch:{ Exception -> 0x0119, all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0131 A[SYNTHETIC, Splitter:B:56:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0151 A[SYNTHETIC, Splitter:B:65:0x0151] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap getLocalBitmap(android.net.Uri r22, int r23, int r24) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 0
            java.lang.String r4 = r22.getPath()     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            if (r4 == 0) goto L_0x001b
            int r5 = r4.length()     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            if (r5 != 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r5 = 0
            goto L_0x001c
        L_0x001b:
            r5 = 1
        L_0x001c:
            if (r5 == 0) goto L_0x0031
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r8 = 0
            r9 = 0
            r10 = 0
            com.braze.support.BrazeImageUtils$e r11 = new com.braze.support.BrazeImageUtils$e     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r12 = 14
            r13 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r6, (java.lang.String) r7, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r9, (boolean) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            return r3
        L_0x0031:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            boolean r4 = r5.exists()     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            if (r4 != 0) goto L_0x004f
            com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r8 = 0
            r9 = 0
            r10 = 0
            com.braze.support.BrazeImageUtils$f r11 = new com.braze.support.BrazeImageUtils$f     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r12 = 14
            r13 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r6, (java.lang.String) r7, (com.braze.support.BrazeLogger.Priority) r8, (java.lang.Throwable) r9, (boolean) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            return r3
        L_0x004f:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            com.braze.support.BrazeLogger$Priority r16 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r17 = 0
            r18 = 0
            com.braze.support.BrazeImageUtils$g r7 = new com.braze.support.BrazeImageUtils$g     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r20 = 12
            r21 = 0
            r14 = r4
            r15 = r6
            r19 = r7
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (boolean) r18, (kotlin.jvm.functions.Function0) r19, (int) r20, (java.lang.Object) r21)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            if (r1 <= 0) goto L_0x00fd
            if (r2 > 0) goto L_0x006f
            goto L_0x00fd
        L_0x006f:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r16 = 0
            r17 = 0
            r18 = 0
            com.braze.support.BrazeImageUtils$i r8 = new com.braze.support.BrazeImageUtils$i     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r8.<init>(r2, r1)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r20 = 14
            r21 = 0
            r14 = r4
            r15 = r6
            r19 = r8
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (boolean) r18, (kotlin.jvm.functions.Function0) r19, (int) r20, (java.lang.Object) r21)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            android.graphics.BitmapFactory$Options r8 = getBitmapMetadataFromStream(r7)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r7.close()     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r9.<init>(r5)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            int r7 = r8.outHeight     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            if (r7 == 0) goto L_0x00b6
            int r7 = r8.outWidth     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            if (r7 != 0) goto L_0x009f
            goto L_0x00b6
        L_0x009f:
            r16 = 0
            r17 = 0
            r18 = 0
            com.braze.support.BrazeImageUtils$k r19 = com.braze.support.BrazeImageUtils.k.f43919b     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r20 = 14
            r21 = 0
            r14 = r4
            r15 = r6
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (boolean) r18, (kotlin.jvm.functions.Function0) r19, (int) r20, (java.lang.Object) r21)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            android.graphics.Bitmap r0 = decodeSampledBitmapFromStream(r9, r8, r1, r2)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
        L_0x00b4:
            r1 = r0
            goto L_0x00d5
        L_0x00b6:
            com.braze.support.BrazeLogger$Priority r16 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r17 = 0
            r18 = 0
            com.braze.support.BrazeImageUtils$j r1 = new com.braze.support.BrazeImageUtils$j     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r1.<init>(r0, r8)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            r20 = 12
            r21 = 0
            r14 = r4
            r15 = r6
            r19 = r1
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (boolean) r18, (kotlin.jvm.functions.Function0) r19, (int) r20, (java.lang.Object) r21)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            java.lang.String r0 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeFile(r0)     // Catch:{ Exception -> 0x00f2, all -> 0x00ed }
            goto L_0x00b4
        L_0x00d5:
            r9.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00ec
        L_0x00d9:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r10 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r11 = TAG
            com.braze.support.BrazeLogger$Priority r12 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$m r15 = com.braze.support.BrazeImageUtils.m.f43921b
            r14 = 0
            r16 = 8
            r17 = 0
            r13 = r2
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r10, (java.lang.String) r11, (com.braze.support.BrazeLogger.Priority) r12, (java.lang.Throwable) r13, (boolean) r14, (kotlin.jvm.functions.Function0) r15, (int) r16, (java.lang.Object) r17)
        L_0x00ec:
            return r1
        L_0x00ed:
            r0 = move-exception
            r1 = r0
            r7 = r9
            goto L_0x014e
        L_0x00f2:
            r0 = move-exception
            r7 = r0
            r1 = r9
            goto L_0x011c
        L_0x00f6:
            r0 = move-exception
            r1 = r0
            goto L_0x014e
        L_0x00f9:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L_0x011c
        L_0x00fd:
            r16 = 0
            r17 = 0
            r18 = 0
            com.braze.support.BrazeImageUtils$h r19 = com.braze.support.BrazeImageUtils.h.f43914b     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            r20 = 14
            r21 = 0
            r14 = r4
            r15 = r6
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (boolean) r18, (kotlin.jvm.functions.Function0) r19, (int) r20, (java.lang.Object) r21)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            java.lang.String r0 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeFile(r0)     // Catch:{ Exception -> 0x0119, all -> 0x0117 }
            return r0
        L_0x0117:
            r0 = move-exception
            goto L_0x014c
        L_0x0119:
            r0 = move-exception
            r7 = r0
            r1 = r3
        L_0x011c:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x014a }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x014a }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x014a }
            r8 = 0
            com.braze.support.BrazeImageUtils$l r9 = new com.braze.support.BrazeImageUtils$l     // Catch:{ all -> 0x014a }
            r9.<init>(r7)     // Catch:{ all -> 0x014a }
            r10 = 8
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x014a }
            if (r1 != 0) goto L_0x0131
            goto L_0x0149
        L_0x0131:
            r1.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x0149
        L_0x0135:
            r0 = move-exception
            r1 = r0
            com.braze.support.BrazeLogger r12 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r13 = TAG
            com.braze.support.BrazeLogger$Priority r14 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$m r17 = com.braze.support.BrazeImageUtils.m.f43921b
            r16 = 0
            r18 = 8
            r19 = 0
            r15 = r1
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (boolean) r16, (kotlin.jvm.functions.Function0) r17, (int) r18, (java.lang.Object) r19)
        L_0x0149:
            return r3
        L_0x014a:
            r0 = move-exception
            r3 = r1
        L_0x014c:
            r1 = r0
            r7 = r3
        L_0x014e:
            if (r7 != 0) goto L_0x0151
            goto L_0x0167
        L_0x0151:
            r7.close()     // Catch:{ IOException -> 0x0155 }
            goto L_0x0167
        L_0x0155:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r9 = TAG
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$m r13 = com.braze.support.BrazeImageUtils.m.f43921b
            r12 = 0
            r14 = 8
            r15 = 0
            r11 = r2
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)
        L_0x0167:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getLocalBitmap(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    public static final int getPixelsFromDensityAndDp(int i11, int i12) {
        return Math.abs((i11 * i12) / Opcodes.IF_ICMPNE);
    }

    public static /* synthetic */ void getRUNTIME_MEMORY_IMAGE_LOADER_USAGE_QUOTIENT$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd A[SYNTHETIC, Splitter:B:47:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0123 A[SYNTHETIC, Splitter:B:58:0x0123] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.Bitmap getRemoteBitmap(android.net.Uri r24, int r25, int r26) {
        /*
            r0 = r25
            r1 = r26
            r2 = 1337(0x539, float:1.874E-42)
            android.net.TrafficStats.setThreadStatsTag(r2)
            java.lang.String r2 = r24.toString()
            java.lang.String r3 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.braze.Braze$Companion r3 = com.braze.Braze.Companion
            boolean r3 = r3.getOutboundNetworkRequestsOffline()
            r4 = 0
            if (r3 == 0) goto L_0x002f
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = TAG
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.I
            com.braze.support.BrazeImageUtils$n r10 = new com.braze.support.BrazeImageUtils$n
            r10.<init>(r2)
            r8 = 0
            r9 = 0
            r11 = 12
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)
            return r4
        L_0x002f:
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00de, all -> 0x00da }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00de, all -> 0x00da }
            bo.app.s6 r5 = bo.app.s6.f39358a     // Catch:{ Exception -> 0x00de, all -> 0x00da }
            java.net.HttpURLConnection r6 = r5.a(r3)     // Catch:{ Exception -> 0x00de, all -> 0x00da }
            int r7 = r6.getResponseCode()     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 == r8) goto L_0x005a
            com.braze.support.BrazeLogger r9 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            com.braze.support.BrazeLogger$Priority r11 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r12 = 0
            r13 = 0
            com.braze.support.BrazeImageUtils$o r14 = new com.braze.support.BrazeImageUtils$o     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r14.<init>(r7, r3)     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r15 = 12
            r16 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r9, (java.lang.String) r10, (com.braze.support.BrazeLogger.Priority) r11, (java.lang.Throwable) r12, (boolean) r13, (kotlin.jvm.functions.Function0) r14, (int) r15, (java.lang.Object) r16)     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            r6.disconnect()
            return r4
        L_0x005a:
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ Exception -> 0x00d6, all -> 0x00d2 }
            if (r0 == 0) goto L_0x00ad
            if (r1 == 0) goto L_0x00ad
            com.braze.support.BrazeLogger r16 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00cf }
            java.lang.String r17 = TAG     // Catch:{ Exception -> 0x00cf }
            r10 = 0
            r11 = 0
            r12 = 0
            com.braze.support.BrazeImageUtils$p r13 = new com.braze.support.BrazeImageUtils$p     // Catch:{ Exception -> 0x00cf }
            r13.<init>(r1, r0)     // Catch:{ Exception -> 0x00cf }
            r14 = 14
            r15 = 0
            r8 = r16
            r9 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ Exception -> 0x00cf }
            android.graphics.BitmapFactory$Options r8 = getBitmapMetadataFromStream(r7)     // Catch:{ Exception -> 0x00cf }
            r6.disconnect()     // Catch:{ Exception -> 0x00cf }
            java.net.HttpURLConnection r6 = r5.a(r3)     // Catch:{ Exception -> 0x00cf }
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ Exception -> 0x00cf }
            int r5 = r8.outHeight     // Catch:{ Exception -> 0x00cf }
            if (r5 == 0) goto L_0x0095
            int r5 = r8.outWidth     // Catch:{ Exception -> 0x00cf }
            if (r5 != 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            android.graphics.Bitmap r0 = decodeSampledBitmapFromStream(r7, r8, r0, r1)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00b1
        L_0x0095:
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00cf }
            r11 = 0
            r12 = 0
            com.braze.support.BrazeImageUtils$q r13 = new com.braze.support.BrazeImageUtils$q     // Catch:{ Exception -> 0x00cf }
            r13.<init>(r3, r8)     // Catch:{ Exception -> 0x00cf }
            r14 = 12
            r15 = 0
            r8 = r16
            r9 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ Exception -> 0x00cf }
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeStream(r7)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00b1
        L_0x00ad:
            android.graphics.Bitmap r0 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeStream(r7)     // Catch:{ Exception -> 0x00cf }
        L_0x00b1:
            r1 = r0
            r6.disconnect()
            if (r7 != 0) goto L_0x00b8
            goto L_0x00ce
        L_0x00b8:
            r7.close()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00ce
        L_0x00bc:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r9 = TAG
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$s r13 = com.braze.support.BrazeImageUtils.s.f43931b
            r12 = 0
            r14 = 8
            r15 = 0
            r11 = r2
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)
        L_0x00ce:
            return r1
        L_0x00cf:
            r0 = move-exception
            r11 = r0
            goto L_0x00e2
        L_0x00d2:
            r0 = move-exception
            r1 = r0
            r7 = r4
            goto L_0x0119
        L_0x00d6:
            r0 = move-exception
            r11 = r0
            r7 = r4
            goto L_0x00e2
        L_0x00da:
            r0 = move-exception
            r1 = r0
            r7 = r4
            goto L_0x011a
        L_0x00de:
            r0 = move-exception
            r11 = r0
            r6 = r4
            r7 = r6
        L_0x00e2:
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x0117 }
            java.lang.String r9 = TAG     // Catch:{ all -> 0x0117 }
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x0117 }
            r12 = 0
            com.braze.support.BrazeImageUtils$r r13 = new com.braze.support.BrazeImageUtils$r     // Catch:{ all -> 0x0117 }
            r13.<init>(r2, r11)     // Catch:{ all -> 0x0117 }
            r14 = 8
            r15 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ all -> 0x0117 }
            if (r6 != 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            r6.disconnect()
        L_0x00fa:
            if (r7 != 0) goto L_0x00fd
            goto L_0x0116
        L_0x00fd:
            r7.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0116
        L_0x0101:
            r0 = move-exception
            r1 = r0
            com.braze.support.BrazeLogger r16 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r17 = TAG
            com.braze.support.BrazeLogger$Priority r18 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$s r21 = com.braze.support.BrazeImageUtils.s.f43931b
            r20 = 0
            r22 = 8
            r23 = 0
            r19 = r1
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r16, (java.lang.String) r17, (com.braze.support.BrazeLogger.Priority) r18, (java.lang.Throwable) r19, (boolean) r20, (kotlin.jvm.functions.Function0) r21, (int) r22, (java.lang.Object) r23)
        L_0x0116:
            return r4
        L_0x0117:
            r0 = move-exception
            r1 = r0
        L_0x0119:
            r4 = r6
        L_0x011a:
            if (r4 != 0) goto L_0x011d
            goto L_0x0120
        L_0x011d:
            r4.disconnect()
        L_0x0120:
            if (r7 != 0) goto L_0x0123
            goto L_0x0139
        L_0x0123:
            r7.close()     // Catch:{ IOException -> 0x0127 }
            goto L_0x0139
        L_0x0127:
            r0 = move-exception
            r2 = r0
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r9 = TAG
            com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.E
            com.braze.support.BrazeImageUtils$s r13 = com.braze.support.BrazeImageUtils.s.f43931b
            r12 = 0
            r14 = 8
            r15 = 0
            r11 = r2
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)
        L_0x0139:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.BrazeImageUtils.getRemoteBitmap(android.net.Uri, int, int):android.graphics.Bitmap");
    }

    private static final DisplayMetrics populateDisplayMetricsFromDisplay(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public static final void resizeImageViewToBitmapDimensions(Bitmap bitmap, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        resizeToBitmapDimensions(imageView, bitmap);
    }

    public static final void resizeToBitmapDimensions(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (bitmap == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) t.f43932b, 12, (Object) null);
        } else if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) u.f43933b, 12, (Object) null);
        } else if (imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) v.f43934b, 12, (Object) null);
        } else {
            float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new w(width), 14, (Object) null);
            imageView.getLayoutParams().height = (int) (((float) imageView.getWidth()) / width);
        }
    }
}
