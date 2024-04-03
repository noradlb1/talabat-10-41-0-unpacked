package androidx.compose.ui.tooling;

import android.util.Log;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001a\u001a\u0010\t\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004*\u00020\nH\u0000\u001a)\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getPreviewProviderParameters", "", "", "parameterProviderClass", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "asPreviewProviderClass", "", "toArray", "Lkotlin/sequences/Sequence;", "size", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PreviewUtilsKt {
    @Nullable
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            Log.e("PreviewProvider", "Unable to find provider '" + str + '\'', e11);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r4 == false) goto L_0x0031;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object[] getPreviewProviderParameters(@org.jetbrains.annotations.Nullable java.lang.Class<? extends androidx.compose.ui.tooling.preview.PreviewParameterProvider<?>> r10, int r11) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x007b
            java.lang.reflect.Constructor[] r10 = r10.getConstructors()     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.String r1 = "parameterProviderClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            int r1 = r10.length     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            r2 = 0
            r3 = r0
            r4 = r3
            r5 = r2
        L_0x0011:
            r6 = 1
            if (r3 >= r1) goto L_0x002f
            r7 = r10[r3]     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.Class[] r8 = r7.getParameterTypes()     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.String r9 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            int r8 = r8.length     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            if (r8 != 0) goto L_0x0024
            r8 = r6
            goto L_0x0025
        L_0x0024:
            r8 = r0
        L_0x0025:
            if (r8 == 0) goto L_0x002c
            if (r4 == 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r4 = r6
            r5 = r7
        L_0x002c:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x002f:
            if (r4 != 0) goto L_0x0032
        L_0x0031:
            r5 = r2
        L_0x0032:
            java.lang.reflect.Constructor r5 = (java.lang.reflect.Constructor) r5     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            if (r5 != 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            r5.setAccessible(r6)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            r2 = r5
        L_0x003b:
            if (r2 == 0) goto L_0x006b
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.Object r10 = r2.newInstance(r10)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            if (r10 == 0) goto L_0x0063
            androidx.compose.ui.tooling.preview.PreviewParameterProvider r10 = (androidx.compose.ui.tooling.preview.PreviewParameterProvider) r10     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            if (r11 >= 0) goto L_0x0056
            kotlin.sequences.Sequence r11 = r10.getValues()     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            int r10 = r10.getCount()     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.Object[] r10 = toArray(r11, r10)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            return r10
        L_0x0056:
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            kotlin.sequences.Sequence r10 = r10.getValues()     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.Object r10 = kotlin.sequences.SequencesKt___SequencesKt.elementAt(r10, r11)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            r1[r0] = r10     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            return r1
        L_0x0063:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>"
            r10.<init>(r11)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            throw r10     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
        L_0x006b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            java.lang.String r11 = "PreviewParameterProvider constructor can not have parameters"
            r10.<init>(r11)     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
            throw r10     // Catch:{ KotlinReflectionNotSupportedError -> 0x0073 }
        L_0x0073:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle."
            r10.<init>(r11)
            throw r10
        L_0x007b:
            java.lang.Object[] r10 = new java.lang.Object[r0]
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.PreviewUtilsKt.getPreviewProviderParameters(java.lang.Class, int):java.lang.Object[]");
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int i11) {
        Iterator<? extends Object> it = sequence.iterator();
        Object[] objArr = new Object[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = it.next();
        }
        return objArr;
    }
}
