package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.android.logger.AndroidLogger;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.logger.Level;
import org.koin.dsl.ModuleKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", "level", "Lorg/koin/core/logger/Level;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class KoinExtKt {
    @NotNull
    public static final KoinApplication androidContext(@NotNull KoinApplication koinApplication, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(context, "androidContext");
        if (koinApplication.getKoin().getLogger().isAt(Level.INFO)) {
            koinApplication.getKoin().getLogger().info("[init] declare Android Context");
        }
        if (context instanceof Application) {
            Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt__CollectionsJVMKt.listOf(ModuleKt.module$default(false, new KoinExtKt$androidContext$1(context), 1, (Object) null)), false, 2, (Object) null);
        } else {
            Koin.loadModules$default(koinApplication.getKoin(), CollectionsKt__CollectionsJVMKt.listOf(ModuleKt.module$default(false, new KoinExtKt$androidContext$2(context), 1, (Object) null)), false, 2, (Object) null);
        }
        return koinApplication;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0097, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.koin.core.KoinApplication androidFileProperties(@org.jetbrains.annotations.NotNull org.koin.core.KoinApplication r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "koinPropertyFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            org.koin.core.Koin r1 = r6.getKoin()
            org.koin.core.registry.ScopeRegistry r1 = r1.getScopeRegistry()
            org.koin.core.scope.Scope r1 = r1.getRootScope()
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            r3 = 0
            java.lang.Object r1 = r1.get(r2, r3, r3)
            android.content.Context r1 = (android.content.Context) r1
            android.content.res.AssetManager r2 = r1.getAssets()     // Catch:{ Exception -> 0x00dd }
            r4 = 0
            if (r2 != 0) goto L_0x0030
            goto L_0x003d
        L_0x0030:
            java.lang.String r5 = ""
            java.lang.String[] r2 = r2.list(r5)     // Catch:{ Exception -> 0x00dd }
            if (r2 != 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            boolean r4 = kotlin.collections.ArraysKt___ArraysKt.contains((T[]) r2, r7)     // Catch:{ Exception -> 0x00dd }
        L_0x003d:
            if (r4 == 0) goto L_0x00ab
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x0098 }
            java.io.InputStream r1 = r1.open(r7)     // Catch:{ Exception -> 0x0098 }
            r0.load(r1)     // Catch:{ all -> 0x0091 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0091 }
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ Exception -> 0x0098 }
            org.koin.core.Koin r1 = r6.getKoin()     // Catch:{ Exception -> 0x0098 }
            org.koin.core.registry.PropertyRegistry r1 = r1.getPropertyRegistry()     // Catch:{ Exception -> 0x0098 }
            org.koin.core.registry.PropertyRegistryExtKt.saveProperties(r1, r0)     // Catch:{ Exception -> 0x0098 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0098 }
            org.koin.core.Koin r1 = r6.getKoin()     // Catch:{ Exception -> 0x0098 }
            org.koin.core.logger.Logger r1 = r1.getLogger()     // Catch:{ Exception -> 0x0098 }
            org.koin.core.logger.Level r2 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x0098 }
            boolean r1 = r1.isAt(r2)     // Catch:{ Exception -> 0x0098 }
            if (r1 == 0) goto L_0x0102
            org.koin.core.Koin r1 = r6.getKoin()     // Catch:{ Exception -> 0x0098 }
            org.koin.core.logger.Logger r1 = r1.getLogger()     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r2.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "[Android-Properties] loaded "
            r2.append(r3)     // Catch:{ Exception -> 0x0098 }
            r2.append(r0)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = " properties from assets/"
            r2.append(r0)     // Catch:{ Exception -> 0x0098 }
            r2.append(r7)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0098 }
            r1.info(r0)     // Catch:{ Exception -> 0x0098 }
            goto L_0x0102
        L_0x0091:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0098 }
            throw r2     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            r0 = move-exception
            org.koin.core.Koin r1 = r6.getKoin()     // Catch:{ Exception -> 0x00dd }
            org.koin.core.logger.Logger r1 = r1.getLogger()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r2 = "[Android-Properties] error for binding properties : "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)     // Catch:{ Exception -> 0x00dd }
            r1.error(r0)     // Catch:{ Exception -> 0x00dd }
            goto L_0x0102
        L_0x00ab:
            org.koin.core.Koin r0 = r6.getKoin()     // Catch:{ Exception -> 0x00dd }
            org.koin.core.logger.Logger r0 = r0.getLogger()     // Catch:{ Exception -> 0x00dd }
            org.koin.core.logger.Level r1 = org.koin.core.logger.Level.INFO     // Catch:{ Exception -> 0x00dd }
            boolean r0 = r0.isAt(r1)     // Catch:{ Exception -> 0x00dd }
            if (r0 == 0) goto L_0x0102
            org.koin.core.Koin r0 = r6.getKoin()     // Catch:{ Exception -> 0x00dd }
            org.koin.core.logger.Logger r0 = r0.getLogger()     // Catch:{ Exception -> 0x00dd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd }
            r1.<init>()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r2 = "[Android-Properties] no assets/"
            r1.append(r2)     // Catch:{ Exception -> 0x00dd }
            r1.append(r7)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r2 = " file to load"
            r1.append(r2)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00dd }
            r0.info(r1)     // Catch:{ Exception -> 0x00dd }
            goto L_0x0102
        L_0x00dd:
            r0 = move-exception
            org.koin.core.Koin r1 = r6.getKoin()
            org.koin.core.logger.Logger r1 = r1.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[Android-Properties] error while loading properties from assets/"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = " : "
            r2.append(r7)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r1.error(r7)
        L_0x0102:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.android.ext.koin.KoinExtKt.androidFileProperties(org.koin.core.KoinApplication, java.lang.String):org.koin.core.KoinApplication");
    }

    public static /* synthetic */ KoinApplication androidFileProperties$default(KoinApplication koinApplication, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "koin.properties";
        }
        return androidFileProperties(koinApplication, str);
    }

    @NotNull
    public static final KoinApplication androidLogger(@NotNull KoinApplication koinApplication, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        koinApplication.getKoin().setupLogger(new AndroidLogger(level));
        return koinApplication;
    }

    public static /* synthetic */ KoinApplication androidLogger$default(KoinApplication koinApplication, Level level, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            level = Level.INFO;
        }
        return androidLogger(koinApplication, level);
    }
}
