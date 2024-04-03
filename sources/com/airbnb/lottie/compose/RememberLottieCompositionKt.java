package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aG\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a2\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012H\b\u0002\u0010 \u001aB\b\u0001\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160(\u0012\u0006\u0012\u0004\u0018\u00010)0!H\u0007ø\u0001\u0000¢\u0006\u0002\u0010*\u001a\u001a\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a!\u0010/\u001a\u0002H0\"\u0004\b\u0000\u00100*\b\u0012\u0004\u0012\u0002H00\u0014H@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\f\u00102\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u0010\u00103\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"DefaultCacheKey", "", "loadFontsFromAssets", "", "context", "Landroid/content/Context;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "fontAssetsFolder", "fontFileExtension", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadImagesFromAssets", "imageAssetsFolder", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottieComposition", "spec", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "cacheKey", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottieTask", "Lcom/airbnb/lottie/LottieTask;", "isWarmingCache", "", "maybeDecodeBase64Image", "asset", "Lcom/airbnb/lottie/LottieImageAsset;", "maybeLoadImageFromAsset", "maybeLoadTypefaceFromAssets", "font", "Lcom/airbnb/lottie/model/Font;", "rememberLottieComposition", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "onRetry", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "failCount", "", "previousException", "Lkotlin/coroutines/Continuation;", "", "(Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieCompositionResult;", "typefaceForStyle", "Landroid/graphics/Typeface;", "typeface", "style", "await", "T", "(Lcom/airbnb/lottie/LottieTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureLeadingPeriod", "ensureTrailingSlash", "lottie-compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RememberLottieCompositionKt {
    @NotNull
    private static final String DefaultCacheKey = "__LottieInternalDefaultCacheKey__";

    /* access modifiers changed from: private */
    public static final <T> Object await(LottieTask<T> lottieTask, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        lottieTask.addListener(new RememberLottieCompositionKt$await$2$1(cancellableContinuationImpl)).addFailureListener(new RememberLottieCompositionKt$await$2$2(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public static final String ensureLeadingPeriod(String str) {
        if (!StringsKt__StringsJVMKt.isBlank(str) && !StringsKt__StringsJVMKt.startsWith$default(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, false, 2, (Object) null)) {
            return Intrinsics.stringPlus(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, str);
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static final String ensureTrailingSlash(String str) {
        boolean z11;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        if (StringsKt__StringsKt.endsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            return str;
        }
        return Intrinsics.stringPlus(str, "/");
    }

    /* access modifiers changed from: private */
    public static final Object loadFontsFromAssets(Context context, LottieComposition lottieComposition, String str, String str2, Continuation<? super Unit> continuation) {
        if (lottieComposition.getFonts().isEmpty()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new RememberLottieCompositionKt$loadFontsFromAssets$2(lottieComposition, context, str, str2, (Continuation<? super RememberLottieCompositionKt$loadFontsFromAssets$2>) null), continuation);
        if (withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Object loadImagesFromAssets(Context context, LottieComposition lottieComposition, String str, Continuation<? super Unit> continuation) {
        if (!lottieComposition.hasImages()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new RememberLottieCompositionKt$loadImagesFromAssets$2(lottieComposition, context, str, (Continuation<? super RememberLottieCompositionKt$loadImagesFromAssets$2>) null), continuation);
        if (withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object lottieComposition(android.content.Context r6, com.airbnb.lottie.compose.LottieCompositionSpec r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super com.airbnb.lottie.LottieComposition> r12) {
        /*
            boolean r0 = r12 instanceof com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1 r0 = (com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1) r0
            int r1 = r0.f40610m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f40610m = r1
            goto L_0x0018
        L_0x0013:
            com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1 r0 = new com.airbnb.lottie.compose.RememberLottieCompositionKt$lottieComposition$1
            r0.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r0.f40609l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f40610m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r5) goto L_0x0050
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r6 = r0.f40605h
            com.airbnb.lottie.LottieComposition r6 = (com.airbnb.lottie.LottieComposition) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00ab
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            java.lang.Object r6 = r0.f40608k
            com.airbnb.lottie.LottieComposition r6 = (com.airbnb.lottie.LottieComposition) r6
            java.lang.Object r7 = r0.f40607j
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.f40606i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.f40605h
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0099
        L_0x0050:
            java.lang.Object r6 = r0.f40608k
            r10 = r6
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r6 = r0.f40607j
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r6 = r0.f40606i
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r6 = r0.f40605h
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0082
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = 0
            com.airbnb.lottie.LottieTask r11 = lottieTask(r6, r7, r11, r12)
            if (r11 == 0) goto L_0x00ac
            r0.f40605h = r6
            r0.f40606i = r8
            r0.f40607j = r9
            r0.f40608k = r10
            r0.f40610m = r5
            java.lang.Object r12 = await(r11, r0)
            if (r12 != r1) goto L_0x0082
            return r1
        L_0x0082:
            com.airbnb.lottie.LottieComposition r12 = (com.airbnb.lottie.LottieComposition) r12
            r0.f40605h = r6
            r0.f40606i = r9
            r0.f40607j = r10
            r0.f40608k = r12
            r0.f40610m = r4
            java.lang.Object r7 = loadImagesFromAssets(r6, r12, r8, r0)
            if (r7 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r8 = r9
            r7 = r10
            r9 = r6
            r6 = r12
        L_0x0099:
            r0.f40605h = r6
            r10 = 0
            r0.f40606i = r10
            r0.f40607j = r10
            r0.f40608k = r10
            r0.f40610m = r3
            java.lang.Object r7 = loadFontsFromAssets(r9, r6, r8, r7, r0)
            if (r7 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            return r6
        L_0x00ac:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Unable to create parsing task for "
            r6.append(r8)
            r6.append(r7)
            r7 = 46
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.RememberLottieCompositionKt.lottieComposition(android.content.Context, com.airbnb.lottie.compose.LottieCompositionSpec, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final LottieTask<LottieComposition> lottieTask(Context context, LottieCompositionSpec lottieCompositionSpec, String str, boolean z11) {
        if (lottieCompositionSpec instanceof LottieCompositionSpec.RawRes) {
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                return LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).m9181unboximpl());
            }
            return LottieCompositionFactory.fromRawRes(context, ((LottieCompositionSpec.RawRes) lottieCompositionSpec).m9181unboximpl(), str);
        } else if (lottieCompositionSpec instanceof LottieCompositionSpec.Url) {
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                return LottieCompositionFactory.fromUrl(context, ((LottieCompositionSpec.Url) lottieCompositionSpec).m9188unboximpl());
            }
            return LottieCompositionFactory.fromUrl(context, ((LottieCompositionSpec.Url) lottieCompositionSpec).m9188unboximpl(), str);
        } else if (lottieCompositionSpec instanceof LottieCompositionSpec.File) {
            if (z11) {
                return null;
            }
            LottieCompositionSpec.File file = (LottieCompositionSpec.File) lottieCompositionSpec;
            FileInputStream fileInputStream = new FileInputStream(file.m9167unboximpl());
            if (StringsKt__StringsJVMKt.endsWith$default(file.m9167unboximpl(), ArchiveStreamFactory.ZIP, false, 2, (Object) null)) {
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                    str = file.m9167unboximpl();
                }
                return LottieCompositionFactory.fromZipStream(zipInputStream, str);
            }
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                str = file.m9167unboximpl();
            }
            return LottieCompositionFactory.fromJsonInputStream(fileInputStream, str);
        } else if (lottieCompositionSpec instanceof LottieCompositionSpec.Asset) {
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                return LottieCompositionFactory.fromAsset(context, ((LottieCompositionSpec.Asset) lottieCompositionSpec).m9153unboximpl());
            }
            return LottieCompositionFactory.fromAsset(context, ((LottieCompositionSpec.Asset) lottieCompositionSpec).m9153unboximpl(), str);
        } else if (lottieCompositionSpec instanceof LottieCompositionSpec.JsonString) {
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                str = String.valueOf(((LottieCompositionSpec.JsonString) lottieCompositionSpec).m9174unboximpl().hashCode());
            }
            return LottieCompositionFactory.fromJsonString(((LottieCompositionSpec.JsonString) lottieCompositionSpec).m9174unboximpl(), str);
        } else if (lottieCompositionSpec instanceof LottieCompositionSpec.ContentProvider) {
            LottieCompositionSpec.ContentProvider contentProvider = (LottieCompositionSpec.ContentProvider) lottieCompositionSpec;
            InputStream openInputStream = context.getContentResolver().openInputStream(contentProvider.m9160unboximpl());
            if (Intrinsics.areEqual((Object) str, (Object) DefaultCacheKey)) {
                str = contentProvider.m9160unboximpl().toString();
            }
            return LottieCompositionFactory.fromJsonInputStream(openInputStream, str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final void maybeDecodeBase64Image(LottieImageAsset lottieImageAsset) {
        if (lottieImageAsset.getBitmap() == null) {
            String fileName = lottieImageAsset.getFileName();
            Intrinsics.checkNotNullExpressionValue(fileName, "filename");
            if (StringsKt__StringsJVMKt.startsWith$default(fileName, "data:", false, 2, (Object) null) && StringsKt__StringsKt.indexOf$default((CharSequence) fileName, "base64,", 0, false, 6, (Object) null) > 0) {
                try {
                    String substring = fileName.substring(StringsKt__StringsKt.indexOf$default((CharSequence) fileName, (char) AbstractJsonLexerKt.COMMA, 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    byte[] decode = Base64.decode(substring, 0);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = Opcodes.IF_ICMPNE;
                    lottieImageAsset.setBitmap(BitmapFactoryInstrumentation.decodeByteArray(decode, 0, decode.length, options));
                } catch (IllegalArgumentException e11) {
                    Logger.warning("data URL did not have correct base64 format.", e11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void maybeLoadImageFromAsset(Context context, LottieImageAsset lottieImageAsset, String str) {
        if (lottieImageAsset.getBitmap() == null && str != null) {
            try {
                InputStream open = context.getAssets().open(Intrinsics.stringPlus(str, lottieImageAsset.getFileName()));
                Intrinsics.checkNotNullExpressionValue(open, "try {\n        context.as…, e)\n        return\n    }");
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = Opcodes.IF_ICMPNE;
                    lottieImageAsset.setBitmap(Utils.resizeBitmapIfNeeded(BitmapFactoryInstrumentation.decodeStream(open, (Rect) null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                } catch (IllegalArgumentException e11) {
                    Logger.warning("Unable to decode image.", e11);
                }
            } catch (IOException e12) {
                Logger.warning("Unable to open asset.", e12);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void maybeLoadTypefaceFromAssets(Context context, Font font, String str, String str2) {
        String str3 = str + font.getFamily() + str2;
        try {
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str3);
            try {
                Intrinsics.checkNotNullExpressionValue(createFromAsset, "typefaceWithDefaultStyle");
                String style = font.getStyle();
                Intrinsics.checkNotNullExpressionValue(style, "font.style");
                font.setTypeface(typefaceForStyle(createFromAsset, style));
            } catch (Exception e11) {
                Logger.error("Failed to create " + font.getFamily() + " typeface with style=" + font.getStyle() + '!', e11);
            }
        } catch (Exception e12) {
            Logger.error("Failed to find typeface in assets with path " + str3 + '.', e12);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.airbnb.lottie.compose.LottieCompositionResult rememberLottieComposition(@org.jetbrains.annotations.NotNull com.airbnb.lottie.compose.LottieCompositionSpec r16, @org.jetbrains.annotations.Nullable java.lang.String r17, @org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.String r20, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r10 = r16
            r11 = r22
            java.lang.String r0 = "spec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1388713460(0x52c615f4, float:4.25385918E11)
            r11.startReplaceableGroup(r0)
            r0 = r24 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0016
            r4 = r1
            goto L_0x0018
        L_0x0016:
            r4 = r17
        L_0x0018:
            r0 = r24 & 4
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = "fonts/"
            r5 = r0
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r0 = r24 & 8
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = ".ttf"
            r6 = r0
            goto L_0x002c
        L_0x002a:
            r6 = r19
        L_0x002c:
            r0 = r24 & 16
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "__LottieInternalDefaultCacheKey__"
            r12 = r0
            goto L_0x0036
        L_0x0034:
            r12 = r20
        L_0x0036:
            r0 = r24 & 32
            if (r0 == 0) goto L_0x0041
            com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1 r0 = new com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1
            r0.<init>(r1)
            r2 = r0
            goto L_0x0043
        L_0x0041:
            r2 = r21
        L_0x0043:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r0 = r11.consume(r0)
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            r0 = r23 & 14
            r7 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r7)
            boolean r7 = r11.changed((java.lang.Object) r10)
            java.lang.Object r8 = r22.rememberedValue()
            if (r7 != 0) goto L_0x0068
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x0075
        L_0x0068:
            com.airbnb.lottie.compose.LottieCompositionResultImpl r7 = new com.airbnb.lottie.compose.LottieCompositionResultImpl
            r7.<init>()
            r8 = 2
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r1, r8, r1)
            r11.updateRememberedValue(r8)
        L_0x0075:
            r22.endReplaceableGroup()
            r13 = r8
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            int r1 = r23 >> 9
            r1 = r1 & 112(0x70, float:1.57E-43)
            r14 = r0 | r1
            r0 = -3686552(0xffffffffffc7bf68, float:NaN)
            r11.startReplaceableGroup(r0)
            boolean r0 = r11.changed((java.lang.Object) r10)
            boolean r1 = r11.changed((java.lang.Object) r12)
            r0 = r0 | r1
            java.lang.Object r1 = r22.rememberedValue()
            if (r0 != 0) goto L_0x009e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00a6
        L_0x009e:
            r0 = 1
            com.airbnb.lottie.LottieTask r0 = lottieTask(r3, r10, r12, r0)
            r11.updateRememberedValue(r0)
        L_0x00a6:
            r22.endReplaceableGroup()
            com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3 r15 = new com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3
            r9 = 0
            r0 = r15
            r1 = r2
            r2 = r3
            r3 = r16
            r7 = r12
            r8 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r10, r12, r15, r11, r14)
            com.airbnb.lottie.compose.LottieCompositionResultImpl r0 = m9192rememberLottieComposition$lambda1(r13)
            r22.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.RememberLottieCompositionKt.rememberLottieComposition(com.airbnb.lottie.compose.LottieCompositionSpec, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):com.airbnb.lottie.compose.LottieCompositionResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: rememberLottieComposition$lambda-1  reason: not valid java name */
    public static final LottieCompositionResultImpl m9192rememberLottieComposition$lambda1(MutableState<LottieCompositionResultImpl> mutableState) {
        return mutableState.getValue();
    }

    private static final Typeface typefaceForStyle(Typeface typeface, String str) {
        int i11 = 0;
        boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "Italic", false, 2, (Object) null);
        boolean contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "Bold", false, 2, (Object) null);
        if (contains$default && contains$default2) {
            i11 = 3;
        } else if (contains$default) {
            i11 = 2;
        } else if (contains$default2) {
            i11 = 1;
        }
        if (typeface.getStyle() == i11) {
            return typeface;
        }
        return Typeface.create(typeface, i11);
    }
}
