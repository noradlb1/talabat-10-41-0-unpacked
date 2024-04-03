package kotlin.reflect.jvm.internal.impl.metadata.builtins;

public final class ReadPackageFragmentKt {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion> readBuiltinsPackageFragment(@org.jetbrains.annotations.NotNull java.io.InputStream r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion$Companion r0 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion     // Catch:{ all -> 0x0027 }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r0 = r0.readFrom(r3)     // Catch:{ all -> 0x0027 }
            boolean r1 = r0.isCompatible()     // Catch:{ all -> 0x0027 }
            r2 = 0
            if (r1 == 0) goto L_0x001e
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance()     // Catch:{ all -> 0x0027 }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(r1)     // Catch:{ all -> 0x0027 }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.parseFrom(r3, r1)     // Catch:{ all -> 0x0027 }
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)     // Catch:{ all -> 0x0027 }
            kotlin.io.CloseableKt.closeFinally(r3, r2)
            return r0
        L_0x0027:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt.readBuiltinsPackageFragment(java.io.InputStream):kotlin.Pair");
    }
}
