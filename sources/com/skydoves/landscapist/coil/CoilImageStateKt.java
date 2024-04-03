package com.skydoves.landscapist.coil;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toCoilImageState", "Lcom/skydoves/landscapist/coil/CoilImageState;", "Lcom/skydoves/landscapist/ImageLoadState;", "coil_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CoilImageStateKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.graphics.drawable.Drawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.graphics.drawable.Drawable} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.skydoves.landscapist.coil.CoilImageState toCoilImageState(@org.jetbrains.annotations.NotNull com.skydoves.landscapist.ImageLoadState r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof com.skydoves.landscapist.ImageLoadState.None
            if (r0 == 0) goto L_0x000c
            com.skydoves.landscapist.coil.CoilImageState$None r3 = com.skydoves.landscapist.coil.CoilImageState.None.INSTANCE
            goto L_0x004c
        L_0x000c:
            boolean r0 = r3 instanceof com.skydoves.landscapist.ImageLoadState.Loading
            if (r0 == 0) goto L_0x001d
            com.skydoves.landscapist.coil.CoilImageState$Loading r0 = new com.skydoves.landscapist.coil.CoilImageState$Loading
            com.skydoves.landscapist.ImageLoadState$Loading r3 = (com.skydoves.landscapist.ImageLoadState.Loading) r3
            float r3 = r3.getProgress()
            r0.<init>(r3)
        L_0x001b:
            r3 = r0
            goto L_0x004c
        L_0x001d:
            boolean r0 = r3 instanceof com.skydoves.landscapist.ImageLoadState.Success
            r1 = 0
            if (r0 == 0) goto L_0x0035
            com.skydoves.landscapist.coil.CoilImageState$Success r0 = new com.skydoves.landscapist.coil.CoilImageState$Success
            com.skydoves.landscapist.ImageLoadState$Success r3 = (com.skydoves.landscapist.ImageLoadState.Success) r3
            java.lang.Object r3 = r3.getData()
            boolean r2 = r3 instanceof android.graphics.drawable.Drawable
            if (r2 == 0) goto L_0x0031
            r1 = r3
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
        L_0x0031:
            r0.<init>(r1)
            goto L_0x001b
        L_0x0035:
            boolean r0 = r3 instanceof com.skydoves.landscapist.ImageLoadState.Failure
            if (r0 == 0) goto L_0x004d
            com.skydoves.landscapist.coil.CoilImageState$Failure r0 = new com.skydoves.landscapist.coil.CoilImageState$Failure
            com.skydoves.landscapist.ImageLoadState$Failure r3 = (com.skydoves.landscapist.ImageLoadState.Failure) r3
            java.lang.Object r3 = r3.getData()
            boolean r2 = r3 instanceof android.graphics.drawable.Drawable
            if (r2 == 0) goto L_0x0048
            r1 = r3
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
        L_0x0048:
            r0.<init>(r1)
            goto L_0x001b
        L_0x004c:
            return r3
        L_0x004d:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.landscapist.coil.CoilImageStateKt.toCoilImageState(com.skydoves.landscapist.ImageLoadState):com.skydoves.landscapist.coil.CoilImageState");
    }
}
