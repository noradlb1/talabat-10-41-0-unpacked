package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0003¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.ui.text.ExperimentalTextApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.util.List<androidx.compose.ui.text.font.Font>, java.lang.Object> firstImmediatelyAvailable(java.util.List<? extends androidx.compose.ui.text.font.Font> r16, androidx.compose.ui.text.font.TypefaceRequest r17, androidx.compose.ui.text.font.AsyncTypefaceCache r18, androidx.compose.ui.text.font.PlatformFontLoader r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends java.lang.Object> r20) {
        /*
            r8 = r19
            int r9 = r16.size()
            r10 = 0
            r11 = 0
            r13 = r10
            r12 = r11
        L_0x000a:
            if (r12 >= r9) goto L_0x0198
            r14 = r16
            java.lang.Object r0 = r14.get(r12)
            r15 = r0
            androidx.compose.ui.text.font.Font r15 = (androidx.compose.ui.text.font.Font) r15
            int r0 = r15.m5098getLoadingStrategyPKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r1 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r2 = r1.m5116getBlockingPKNRLFQ()
            boolean r2 = androidx.compose.ui.text.font.FontLoadingStrategy.m5111equalsimpl0(r0, r2)
            if (r2 == 0) goto L_0x00b0
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r18.cacheLock
            monitor-enter(r1)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key     // Catch:{ all -> 0x00ad }
            java.lang.Object r2 = r19.getCacheKey()     // Catch:{ all -> 0x00ad }
            r0.<init>(r15, r2)     // Catch:{ all -> 0x00ad }
            androidx.compose.ui.text.caches.LruCache r2 = r18.resultCache     // Catch:{ all -> 0x00ad }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00ad }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r2 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r2     // Catch:{ all -> 0x00ad }
            if (r2 != 0) goto L_0x004a
            androidx.compose.ui.text.caches.SimpleArrayMap r2 = r18.permanentCache     // Catch:{ all -> 0x00ad }
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x00ad }
            r2 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r2 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r2     // Catch:{ all -> 0x00ad }
        L_0x004a:
            if (r2 == 0) goto L_0x0052
            java.lang.Object r0 = r2.m5087unboximpl()     // Catch:{ all -> 0x00ad }
            monitor-exit(r1)
            goto L_0x0066
        L_0x0052:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ad }
            monitor-exit(r1)
            java.lang.Object r0 = r8.loadBlocking(r15)     // Catch:{ Exception -> 0x0094 }
            r5 = 0
            r6 = 8
            r7 = 0
            r1 = r18
            r2 = r15
            r3 = r19
            r4 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache.put$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x0066:
            if (r0 == 0) goto L_0x007d
            int r1 = r17.m5176getFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontWeight r2 = r17.getFontWeight()
            int r3 = r17.m5175getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(r1, r0, r15, r2, r3)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r0)
            return r0
        L_0x007d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to load font "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0094:
            r0 = move-exception
            r1 = r0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to load font "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2, r1)
            throw r0
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x00b0:
            int r2 = r1.m5117getOptionalLocalPKNRLFQ()
            boolean r2 = androidx.compose.ui.text.font.FontLoadingStrategy.m5111equalsimpl0(r0, r2)
            if (r2 == 0) goto L_0x0131
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r18.cacheLock
            monitor-enter(r1)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key     // Catch:{ all -> 0x012e }
            java.lang.Object r2 = r19.getCacheKey()     // Catch:{ all -> 0x012e }
            r0.<init>(r15, r2)     // Catch:{ all -> 0x012e }
            androidx.compose.ui.text.caches.LruCache r2 = r18.resultCache     // Catch:{ all -> 0x012e }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x012e }
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r2 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r2     // Catch:{ all -> 0x012e }
            if (r2 != 0) goto L_0x00df
            androidx.compose.ui.text.caches.SimpleArrayMap r2 = r18.permanentCache     // Catch:{ all -> 0x012e }
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x012e }
            r2 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r2 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r2     // Catch:{ all -> 0x012e }
        L_0x00df:
            if (r2 == 0) goto L_0x00e7
            java.lang.Object r0 = r2.m5087unboximpl()     // Catch:{ all -> 0x012e }
            monitor-exit(r1)
            goto L_0x0114
        L_0x00e7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x012e }
            monitor-exit(r1)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00f5 }
            java.lang.Object r0 = r8.loadBlocking(r15)     // Catch:{ all -> 0x00f5 }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00f5 }
            goto L_0x0100
        L_0x00f5:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0100:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r0)
            if (r1 == 0) goto L_0x0107
            r0 = r10
        L_0x0107:
            r5 = 0
            r6 = 8
            r7 = 0
            r1 = r18
            r2 = r15
            r3 = r19
            r4 = r0
            androidx.compose.ui.text.font.AsyncTypefaceCache.put$default(r1, r2, r3, r4, r5, r6, r7)
        L_0x0114:
            if (r0 == 0) goto L_0x012b
            int r1 = r17.m5176getFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontWeight r2 = r17.getFontWeight()
            int r3 = r17.m5175getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(r1, r0, r15, r2, r3)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r0)
            return r0
        L_0x012b:
            r1 = r18
            goto L_0x017d
        L_0x012e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0131:
            int r1 = r1.m5115getAsyncPKNRLFQ()
            boolean r0 = androidx.compose.ui.text.font.FontLoadingStrategy.m5111equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x0181
            r1 = r18
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r0 = r1.m5079get1ASDuI8(r15, r8)
            if (r0 != 0) goto L_0x0153
            if (r13 != 0) goto L_0x014f
            r0 = 1
            androidx.compose.ui.text.font.Font[] r0 = new androidx.compose.ui.text.font.Font[r0]
            r0[r11] = r15
            java.util.List r13 = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(r0)
            goto L_0x017d
        L_0x014f:
            r13.add(r15)
            goto L_0x017d
        L_0x0153:
            java.lang.Object r2 = r0.m5087unboximpl()
            boolean r2 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.m5085isPermanentFailureimpl(r2)
            if (r2 == 0) goto L_0x015e
            goto L_0x017d
        L_0x015e:
            java.lang.Object r2 = r0.m5087unboximpl()
            if (r2 == 0) goto L_0x017d
            int r1 = r17.m5176getFontSynthesisGVVA2EU()
            java.lang.Object r0 = r0.m5087unboximpl()
            androidx.compose.ui.text.font.FontWeight r2 = r17.getFontWeight()
            int r3 = r17.m5175getFontStyle_LCdwA()
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(r1, r0, r15, r2, r3)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r0)
            return r0
        L_0x017d:
            int r12 = r12 + 1
            goto L_0x000a
        L_0x0181:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown font type "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0198:
            r1 = r17
            r2 = r20
            java.lang.Object r0 = r2.invoke(r1)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r13, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(java.util.List, androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.AsyncTypefaceCache, androidx.compose.ui.text.font.PlatformFontLoader, kotlin.jvm.functions.Function1):kotlin.Pair");
    }
}
