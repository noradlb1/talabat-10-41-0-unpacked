package com.instabug.commons.snapshot;

import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FileKtxKt {
    @NotNull
    public static final File ifNotExists(@NotNull File file, @NotNull Function1<? super File, Unit> function1) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (file.exists()) {
            file2 = file;
        } else {
            file2 = null;
        }
        if (file2 == null) {
            function1.invoke(file);
            Unit unit = Unit.INSTANCE;
        }
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r1, r2);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T readSerializable(java.io.File r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0038 }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0038 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0038 }
            r2.<init>(r5)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
            r5 = 1
            java.lang.Object r2 = r1.readObject()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "T"
            r4 = 2
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r3)     // Catch:{ all -> 0x002b }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)     // Catch:{ all -> 0x0038 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x0038 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)     // Catch:{ all -> 0x0038 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r2)     // Catch:{ all -> 0x0038 }
            goto L_0x0043
        L_0x002b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002d }
        L_0x002d:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)     // Catch:{ all -> 0x0038 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ all -> 0x0038 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)     // Catch:{ all -> 0x0038 }
            throw r3     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r5 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0043:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r5)
            if (r1 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r0 = r5
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.snapshot.FileKtxKt.readSerializable(java.io.File):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object readSerializableAsAny(@org.jetbrains.annotations.NotNull java.io.File r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0025 }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0025 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            r1.<init>(r2)     // Catch:{ all -> 0x0025 }
            java.lang.Object r3 = r1.readObject()     // Catch:{ all -> 0x001e }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x0025 }
            java.lang.Object r3 = kotlin.Result.m6329constructorimpl(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x0030
        L_0x001e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x0025 }
            throw r2     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r3 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m6329constructorimpl(r3)
        L_0x0030:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r3)
            if (r1 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r0 = r3
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.snapshot.FileKtxKt.readSerializableAsAny(java.io.File):java.lang.Object");
    }

    @Nullable
    public static final Boolean rename(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, "newName");
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return null;
        }
        return Boolean.valueOf(file.renameTo(new File(parentFile.getAbsolutePath() + File.separator + str)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeSerializable(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull java.io.Serializable r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "savable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x002c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x002c }
            r1.<init>(r2)     // Catch:{ all -> 0x002c }
            r0.<init>(r1)     // Catch:{ all -> 0x002c }
            r0.writeObject(r3)     // Catch:{ all -> 0x0025 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0025 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)     // Catch:{ all -> 0x002c }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002c }
            kotlin.Result.m6329constructorimpl(r2)     // Catch:{ all -> 0x002c }
            goto L_0x0036
        L_0x0025:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)     // Catch:{ all -> 0x002c }
            throw r3     // Catch:{ all -> 0x002c }
        L_0x002c:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            kotlin.Result.m6329constructorimpl(r2)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.snapshot.FileKtxKt.writeSerializable(java.io.File, java.io.Serializable):void");
    }
}
