package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzbe;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.internal.vision.zzr;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zzb extends zzn<zzh> {
    private final zzf zzcy;

    public zzb(Context context, zzf zzf) {
        super(context, "FaceNativeHandle", "face");
        zzbe.init(context);
        this.zzcy = zzf;
        zzp();
    }

    public final /* synthetic */ Object zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzi zzi;
        if (zzr.zza(context, "com.google.android.gms.vision.dynamite.face")) {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.NativeFaceDetectorV2Creator"));
        } else {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
        }
        if (zzi == null) {
            return null;
        }
        return zzi.newFaceDetector(ObjectWrapper.wrap(context), this.zzcy);
    }

    public final Face[] zzb(ByteBuffer byteBuffer, zzp zzp) {
        Face[] faceArr;
        FaceParcel[] faceParcelArr;
        Landmark[] landmarkArr;
        Contour[] contourArr;
        int i11 = 0;
        if (!isOperational()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = ((zzh) zzp()).zzc(ObjectWrapper.wrap(byteBuffer), zzp);
            Face[] faceArr2 = new Face[zzc.length];
            int i12 = 0;
            while (i12 < zzc.length) {
                FaceParcel faceParcel = zzc[i12];
                int i13 = faceParcel.f44514id;
                PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
                float f11 = faceParcel.width;
                float f12 = faceParcel.height;
                float f13 = faceParcel.zzcz;
                float f14 = faceParcel.zzda;
                float f15 = faceParcel.zzdb;
                LandmarkParcel[] landmarkParcelArr = faceParcel.zzdc;
                if (landmarkParcelArr == null) {
                    faceParcelArr = zzc;
                    faceArr = faceArr2;
                    landmarkArr = new Landmark[i11];
                } else {
                    landmarkArr = new Landmark[landmarkParcelArr.length];
                    int i14 = i11;
                    while (i14 < landmarkParcelArr.length) {
                        LandmarkParcel landmarkParcel = landmarkParcelArr[i14];
                        landmarkArr[i14] = new Landmark(new PointF(landmarkParcel.f44515x, landmarkParcel.f44516y), landmarkParcel.type);
                        i14++;
                        zzc = zzc;
                        faceArr2 = faceArr2;
                        landmarkParcelArr = landmarkParcelArr;
                    }
                    faceParcelArr = zzc;
                    faceArr = faceArr2;
                }
                zza[] zzaArr = faceParcel.zzdd;
                if (zzaArr == null) {
                    contourArr = new Contour[0];
                } else {
                    Contour[] contourArr2 = new Contour[zzaArr.length];
                    for (int i15 = 0; i15 < zzaArr.length; i15++) {
                        zza zza = zzaArr[i15];
                        contourArr2[i15] = new Contour(zza.zzcx, zza.type);
                    }
                    contourArr = contourArr2;
                }
                faceArr[i12] = new Face(i13, pointF, f11, f12, f13, f14, f15, landmarkArr, contourArr, faceParcel.zzce, faceParcel.zzcf, faceParcel.zzcg, faceParcel.zzch);
                i12++;
                zzc = faceParcelArr;
                faceArr2 = faceArr;
                i11 = 0;
            }
            return faceArr2;
        } catch (RemoteException e11) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e11);
            return new Face[0];
        }
    }

    public final boolean zzd(int i11) {
        if (!isOperational()) {
            return false;
        }
        try {
            return ((zzh) zzp()).zzd(i11);
        } catch (RemoteException e11) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e11);
            return false;
        }
    }

    public final void zzn() throws RemoteException {
        ((zzh) zzp()).zzm();
    }
}
