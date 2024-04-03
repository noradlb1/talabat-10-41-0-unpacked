package jp.wasabeef.glide.transformations.internal;

public class RSBlur {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: android.renderscript.Allocation} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap blur(android.content.Context r5, android.graphics.Bitmap r6, int r7) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 0
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch:{ all -> 0x004c }
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch:{ all -> 0x0046 }
            r1.<init>()     // Catch:{ all -> 0x0046 }
            r5.setMessageHandler(r1)     // Catch:{ all -> 0x0046 }
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0046 }
            r2 = 1
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r5, r6, r1, r2)     // Catch:{ all -> 0x0046 }
            android.renderscript.Type r2 = r1.getType()     // Catch:{ all -> 0x0043 }
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r5, r2)     // Catch:{ all -> 0x0043 }
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r5)     // Catch:{ all -> 0x003e }
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r5, r3)     // Catch:{ all -> 0x003e }
            r0.setInput(r1)     // Catch:{ all -> 0x003e }
            float r7 = (float) r7     // Catch:{ all -> 0x003e }
            r0.setRadius(r7)     // Catch:{ all -> 0x003e }
            r0.forEach(r2)     // Catch:{ all -> 0x003e }
            r2.copyTo(r6)     // Catch:{ all -> 0x003e }
            android.renderscript.RenderScript.releaseAllContexts()
            r1.destroy()
            r2.destroy()
            r0.destroy()
            return r6
        L_0x003e:
            r6 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0050
        L_0x0043:
            r6 = move-exception
            r2 = r0
            goto L_0x0049
        L_0x0046:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L_0x0049:
            r0 = r5
            r5 = r2
            goto L_0x0050
        L_0x004c:
            r6 = move-exception
            r5 = r0
            r1 = r5
            r2 = r1
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            android.renderscript.RenderScript.releaseAllContexts()
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.destroy()
        L_0x005a:
            if (r2 == 0) goto L_0x005f
            r2.destroy()
        L_0x005f:
            if (r5 == 0) goto L_0x0064
            r5.destroy()
        L_0x0064:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.internal.RSBlur.blur(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
