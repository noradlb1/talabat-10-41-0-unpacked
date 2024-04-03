package com.huawei.location.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.database.core.ValidationPath;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.activity.model.FB;
import com.huawei.location.activity.model.LW;
import com.huawei.location.activity.util.JniUtils;
import com.huawei.location.base.activity.AbstractARServiceManager;
import com.huawei.location.base.activity.ActivityRecognitionConstantsMapping;
import com.huawei.location.base.activity.ActivityRecognitionMappingManager;
import com.huawei.location.base.activity.ActivityTransitionMappingManager;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.entity.MovementEvent;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ObjectCheckUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RiemannSoftArService extends AbstractARServiceManager implements SensorEventListener, com.huawei.location.activity.callback.yn {
    private static final int ACQUISITION_FREQUENCY = 10000;
    public static final long ACTIVITY_TRANSITION_UPDATETIMNE = 1000;
    private static final int BASE_CONFIDENCE = 50;
    private static final int FULL_CONFIDENCE = 100;
    private static final long INIT_VALUE = -1;
    private static final int JUDGE_INVALID_TIME = 100000000;
    private static final int MAX_INVALID_TIME = 10000;
    private static final int ONE = 1;
    private static final int SAMPLE_LIST_SIZE = 100;
    private static final int SAMPLE_SIZE = 4;
    private static final int SENSOR_LIST_ALL = 656;
    private static final int SENSOR_LIST_SIZE = 256;
    private static final byte[] SYNC_LIST_LOCK = new byte[0];
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "RiemannSoftArService";
    private static final int ZERO = 0;
    private static volatile RiemannSoftArService instance;
    private Sensor acc;
    private List<LW> accRecordList = new CopyOnWriteArrayList();
    private boolean alreadyRegister = false;
    private boolean alreadyRequestAR = false;
    private com.huawei.location.activity.model.yn atProvider;
    private Context context = ContextUtil.getHMSContext();
    private long delay;
    private boolean needToWait = false;
    private Sensor ori;
    private List<LW> oriRecordList = new CopyOnWriteArrayList();
    private SensorManager sensorManager;
    private long updatTime = System.currentTimeMillis();

    public class Vw implements Runnable {
        private Vw() {
        }

        public /* synthetic */ Vw(RiemannSoftArService riemannSoftArService, yn ynVar) {
            this();
        }

        public void run() {
            try {
                Thread.currentThread().setName("Location-ACTIVITY-RiemannSoftArService");
                LogConsole.i(RiemannSoftArService.TAG, "start to get result when data is enough!");
                RiemannSoftArService.this.recognitionMappingManager.send(RiemannSoftArService.this.getDetectedActivities());
                LogConsole.i(RiemannSoftArService.TAG, "RiemannSoftArService Task run end");
            } catch (LocationServiceException e11) {
                throw e11;
            } catch (Exception unused) {
                LogConsole.e(RiemannSoftArService.TAG, "RiemannSoftArService Task run exception", true);
            }
        }
    }

    public class yn implements Comparator<DetectedActivity> {
        public yn(RiemannSoftArService riemannSoftArService) {
        }

        public int compare(Object obj, Object obj2) {
            return ((DetectedActivity) obj2).getConfidence() - ((DetectedActivity) obj).getConfidence();
        }
    }

    private RiemannSoftArService() {
        super(new ActivityTransitionMappingManager(), new ActivityRecognitionMappingManager());
        Object systemService = this.context.getSystemService("sensor");
        if (!(systemService instanceof SensorManager)) {
            LogConsole.d(TAG, "no sensorManager service");
            return;
        }
        SensorManager sensorManager2 = (SensorManager) systemService;
        this.sensorManager = sensorManager2;
        this.acc = sensorManager2.getDefaultSensor(1);
        this.ori = this.sensorManager.getDefaultSensor(3);
        this.atProvider = new com.huawei.location.activity.model.yn();
    }

    private boolean checkDateVilid(List<LW> list, List<LW> list2) {
        String str;
        if (Math.abs(list.get(0).yn() - list2.get(0).yn()) > 100000000) {
            str = "difference time  is : " + (list.get(0).yn() - list2.get(0).yn());
        } else {
            int size = list.size() - 1;
            if (Math.abs(list.get(size).yn() - list2.get(size).yn()) <= 100000000) {
                return true;
            }
            str = "difference time  is : " + (list.get(size).yn() - list2.get(size).yn());
        }
        LogConsole.i(TAG, str);
        return false;
    }

    private void checkIfValid() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (SYNC_LIST_LOCK) {
            if (currentTimeMillis - this.updatTime > 10000) {
                LogConsole.i(TAG, "sensor data is not valid !");
                this.oriRecordList.clear();
                this.accRecordList.clear();
            }
        }
    }

    private List<DetectedActivity> dealWithDatas() {
        int i11;
        boolean z11;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        int i12;
        int i13;
        int i14;
        float f11;
        int i15;
        List<DetectedActivity> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList(this.accRecordList);
        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList(this.oriRecordList);
        int i16 = 256;
        int i17 = 256;
        int i18 = 0;
        int i19 = 0;
        boolean z12 = false;
        int i21 = 0;
        while (i18 <= 4 && copyOnWriteArrayList4.size() >= i17 && copyOnWriteArrayList5.size() >= i17) {
            if (!checkDateVilid(copyOnWriteArrayList4.subList(i19, i17), copyOnWriteArrayList5.subList(i19, i17))) {
                LogConsole.i(TAG, "data not valid ! drop it ");
                i19 += 100;
                i17 += 100;
                copyOnWriteArrayList2 = copyOnWriteArrayList4;
                copyOnWriteArrayList = copyOnWriteArrayList5;
                i12 = i16;
                i11 = i18;
                z11 = true;
            } else {
                int i22 = i21 + 1;
                List subList = copyOnWriteArrayList4.subList(i19, i17);
                List subList2 = copyOnWriteArrayList5.subList(i19, i17);
                LogConsole.i("ResultPredict", "predict...");
                ArrayList arrayList = new ArrayList(i16);
                ArrayList arrayList2 = new ArrayList(i16);
                int i23 = 0;
                while (true) {
                    copyOnWriteArrayList2 = copyOnWriteArrayList4;
                    if (i23 >= i16) {
                        break;
                    }
                    float[] fArr = {((LW) subList.get(i23)).Vw(), ((LW) subList.get(i23)).FB(), ((LW) subList.get(i23)).LW()};
                    float[] fArr2 = {((LW) subList2.get(i23)).Vw(), ((LW) subList2.get(i23)).FB(), ((LW) subList2.get(i23)).LW()};
                    arrayList.add(fArr);
                    arrayList2.add(fArr2);
                    i23++;
                    copyOnWriteArrayList4 = copyOnWriteArrayList2;
                    i16 = 256;
                }
                ArrayList<float[]> yn2 = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList, i16);
                ArrayList<float[]> yn3 = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList2, i16);
                int size = yn2.size();
                int i24 = 0;
                int[] iArr = new int[2];
                iArr[1] = yn2.get(0).length;
                iArr[0] = size;
                Class cls = Float.TYPE;
                float[][] fArr3 = (float[][]) Array.newInstance(cls, iArr);
                int size2 = yn3.size();
                copyOnWriteArrayList = copyOnWriteArrayList5;
                int[] iArr2 = new int[2];
                iArr2[1] = yn3.get(0).length;
                iArr2[0] = size2;
                float[][] fArr4 = (float[][]) Array.newInstance(cls, iArr2);
                int i25 = 0;
                while (i25 < yn2.size()) {
                    System.arraycopy(yn2.get(i25), i24, fArr3[i25], i24, yn2.get(i25).length);
                    i25++;
                    i24 = 0;
                }
                for (int i26 = 0; i26 < yn3.size(); i26++) {
                    System.arraycopy(yn3.get(i26), 0, fArr4[i26], 0, yn3.get(i26).length);
                }
                char c11 = 0;
                if (fArr3.length < 1) {
                    i11 = i18;
                    i13 = i17;
                    z11 = z12;
                    i14 = i22;
                    f11 = 0.0f;
                } else {
                    int length = fArr3.length;
                    int[] iArr3 = new int[2];
                    iArr3[1] = fArr3[0].length;
                    iArr3[0] = length;
                    float[][] fArr5 = (float[][]) Array.newInstance(Float.TYPE, iArr3);
                    int i27 = 0;
                    while (i27 < fArr3.length) {
                        float[] fArr6 = new float[3];
                        float[] fArr7 = fArr4[i27];
                        fArr6[c11] = fArr7[c11];
                        float f12 = fArr7[1];
                        fArr6[1] = f12;
                        float f13 = fArr7[2];
                        fArr6[2] = f13;
                        float[][] fArr8 = fArr4;
                        float[][] fArr9 = {new float[]{fArr3[i27][0]}, new float[]{fArr3[i27][1]}, new float[]{fArr3[i27][2]}};
                        float f14 = 0.017453292f * f12;
                        float[][] fArr10 = fArr3;
                        double d11 = (double) (fArr6[0] * 0.017453292f);
                        boolean z13 = z12;
                        int i28 = i22;
                        float cos = (float) Math.cos(d11);
                        float sin = (float) Math.sin(d11);
                        double d12 = (double) (f13 * 0.017453292f);
                        boolean z14 = z13;
                        int i29 = i18;
                        float cos2 = (float) Math.cos(d12);
                        float sin2 = (float) Math.sin(d12);
                        double d13 = (double) f14;
                        int i31 = i29;
                        float cos3 = (float) Math.cos(d13);
                        float sin3 = (float) Math.sin(d13);
                        int i32 = i17;
                        float[][] fArr11 = {new float[]{cos, sin * -1.0f, 0.0f}, new float[]{sin, cos, 0.0f}, new float[]{0.0f, 0.0f, 1.0f}};
                        float[][] fArr12 = {new float[]{cos2, 0.0f, sin2}, new float[]{0.0f, 1.0f, 0.0f}, new float[]{sin2 * -1.0f, 0.0f, cos2}};
                        float[][] fArr13 = {new float[]{1.0f, 0.0f, 0.0f}, new float[]{0.0f, cos3, -1.0f * sin3}, new float[]{0.0f, sin3, cos3}};
                        ArrayList arrayList3 = new ArrayList(3);
                        for (int i33 = 0; i33 < 3; i33++) {
                            arrayList3.add(fArr13[i33]);
                        }
                        ArrayList arrayList4 = new ArrayList(3);
                        for (int i34 = 0; i34 < 3; i34++) {
                            arrayList4.add(fArr12[i34]);
                        }
                        ArrayList arrayList5 = new ArrayList(3);
                        for (int i35 = 0; i35 < 3; i35++) {
                            arrayList5.add(fArr11[i35]);
                        }
                        ArrayList<float[]> yn4 = com.huawei.location.activity.model.Vw.yn((ArrayList<float[]>) arrayList3, (ArrayList<float[]>) arrayList4, arrayList3.size());
                        ArrayList<float[]> yn5 = com.huawei.location.activity.model.Vw.yn(yn4, (ArrayList<float[]>) arrayList5, yn4.size());
                        new ArrayList(3);
                        int size3 = yn5.size();
                        int[] iArr4 = new int[2];
                        iArr4[1] = yn5.get(0).length;
                        iArr4[0] = size3;
                        float[][] fArr14 = (float[][]) Array.newInstance(Float.TYPE, iArr4);
                        for (int i36 = 0; i36 < yn5.size(); i36++) {
                            System.arraycopy(yn5.get(i36), 0, fArr14[i36], 0, yn5.get(i36).length);
                        }
                        int length2 = fArr14.length;
                        int length3 = fArr14[0].length;
                        int[] iArr5 = new int[2];
                        iArr5[1] = length2;
                        iArr5[0] = length3;
                        float[][] fArr15 = (float[][]) Array.newInstance(Float.TYPE, iArr5);
                        for (int i37 = 0; i37 < length2; i37++) {
                            for (int i38 = 0; i38 < length3; i38++) {
                                fArr15[i38][i37] = fArr14[i37][i38];
                            }
                        }
                        ArrayList arrayList6 = new ArrayList(length2);
                        for (float[] add : fArr15) {
                            arrayList6.add(add);
                        }
                        ArrayList arrayList7 = new ArrayList(3);
                        int i39 = 0;
                        for (int i41 = 3; i39 < i41; i41 = 3) {
                            arrayList7.add(fArr9[i39]);
                            i39++;
                        }
                        int size4 = arrayList6.size();
                        int[] iArr6 = new int[2];
                        iArr6[1] = ((float[]) arrayList6.get(0)).length;
                        iArr6[0] = size4;
                        float[][] fArr16 = (float[][]) Array.newInstance(Float.TYPE, iArr6);
                        for (int i42 = 0; i42 < arrayList6.size(); i42++) {
                            System.arraycopy(arrayList6.get(i42), 0, fArr16[i42], 0, ((float[]) arrayList6.get(i42)).length);
                        }
                        int size5 = arrayList7.size();
                        int[] iArr7 = new int[2];
                        iArr7[1] = ((float[]) arrayList7.get(0)).length;
                        iArr7[0] = size5;
                        float[][] fArr17 = (float[][]) Array.newInstance(Float.TYPE, iArr7);
                        for (int i43 = 0; i43 < arrayList7.size(); i43++) {
                            System.arraycopy(arrayList7.get(i43), 0, fArr17[i43], 0, ((float[]) arrayList7.get(i43)).length);
                        }
                        int i44 = 0;
                        int length4 = fArr16.length;
                        int[] iArr8 = new int[2];
                        iArr8[1] = fArr17[0].length;
                        iArr8[0] = length4;
                        float[][] fArr18 = (float[][]) Array.newInstance(Float.TYPE, iArr8);
                        int i45 = 0;
                        while (i45 < fArr16.length) {
                            int i46 = i44;
                            while (i46 < fArr17[i44].length) {
                                float f15 = 0.0f;
                                for (int i47 = 0; i47 < fArr17.length; i47++) {
                                    f15 += fArr16[i45][i47] * fArr17[i47][i46];
                                }
                                fArr18[i45][i46] = f15;
                                i46++;
                                i44 = 0;
                            }
                            i45++;
                            i44 = 0;
                        }
                        float[] fArr19 = fArr5[i27];
                        fArr19[0] = fArr18[0][0];
                        fArr19[1] = fArr18[1][0];
                        fArr19[2] = fArr18[2][0];
                        i27++;
                        fArr3 = fArr10;
                        fArr4 = fArr8;
                        i22 = i28;
                        z12 = z14;
                        i18 = i31;
                        i17 = i32;
                        c11 = 0;
                    }
                    i11 = i18;
                    i13 = i17;
                    z11 = z12;
                    i14 = i22;
                    f11 = 0.0f;
                    ArrayList<float[]> arrayList8 = new ArrayList<>(yn2.size());
                    for (float[] add2 : fArr5) {
                        arrayList8.add(add2);
                    }
                    yn2 = arrayList8;
                }
                for (int i48 = 0; i48 < 256; i48++) {
                    yn2.get(i48)[2] = (float) (((double) yn2.get(i48)[2]) - 9.81d);
                }
                int size6 = yn2.size();
                int[] iArr9 = new int[2];
                iArr9[1] = yn2.get(0).length;
                iArr9[0] = size6;
                float[][] fArr20 = (float[][]) Array.newInstance(Float.TYPE, iArr9);
                for (int i49 = 0; i49 < yn2.size(); i49++) {
                    System.arraycopy(yn2.get(i49), 0, fArr20[i49], 0, yn2.get(i49).length);
                }
                if (fArr20.length != 0) {
                    int length5 = fArr20.length;
                    int[] iArr10 = new int[2];
                    iArr10[1] = fArr20[0].length;
                    iArr10[0] = length5;
                    float[][] fArr21 = (float[][]) Array.newInstance(Float.TYPE, iArr10);
                    int i50 = 0;
                    for (int i51 = 0; i50 < fArr20[i51].length; i51 = 0) {
                        int size7 = yn2.size();
                        int[] iArr11 = new int[2];
                        iArr11[1] = yn2.get(i51).length;
                        iArr11[i51] = size7;
                        float[][] fArr22 = (float[][]) Array.newInstance(Float.TYPE, iArr11);
                        for (int i52 = 0; i52 < yn2.size(); i52++) {
                            System.arraycopy(yn2.get(i52), 0, fArr22[i52], 0, yn2.get(i52).length);
                        }
                        ArrayList arrayList9 = new ArrayList();
                        for (int i53 = 0; i53 < fArr22.length; i53++) {
                            if (i50 >= 0) {
                                float[] fArr23 = fArr22[i53];
                                if (i50 < fArr23.length) {
                                    arrayList9.add(Float.valueOf(fArr23[i50]));
                                }
                            }
                        }
                        Double valueOf = Double.valueOf(10.0d);
                        Integer valueOf2 = Integer.valueOf((int) ((valueOf.doubleValue() * 4.0d) + 0.5d));
                        double doubleValue = valueOf.doubleValue() * valueOf.doubleValue();
                        ArrayList arrayList10 = new ArrayList();
                        int i54 = -valueOf2.intValue();
                        while (i54 < valueOf2.intValue() + 1) {
                            arrayList10.add(Float.valueOf((float) Math.exp((-0.5d / doubleValue) * ((double) (i54 * i54)))));
                            i54++;
                            doubleValue = doubleValue;
                        }
                        int size8 = (arrayList10.size() - 1) / 2;
                        int size9 = arrayList9.size();
                        int i55 = (size8 * 2) + size9;
                        ArrayList arrayList11 = new ArrayList(i55);
                        for (int i56 = 0; i56 < i55; i56++) {
                            if (i56 < size8) {
                                i15 = size8 - i56;
                            } else {
                                int i57 = size9 + size8;
                                if (i56 < i57) {
                                    i15 = i56 - size8;
                                } else if (i56 >= i57) {
                                    i15 = (((i57 - 1) * 2) - i56) - size8;
                                }
                            }
                            arrayList11.add(arrayList9.get(i15));
                        }
                        ArrayList arrayList12 = new ArrayList();
                        int i58 = 0;
                        while (i58 < size9) {
                            int i59 = i58 + size8;
                            ArrayList arrayList13 = new ArrayList(arrayList11.subList(i59 - size8, i59 + size8 + 1));
                            double d14 = 0.0d;
                            double d15 = 0.0d;
                            int i60 = 0;
                            while (i60 < arrayList10.size()) {
                                d14 += (double) (((Float) arrayList13.get(i60)).floatValue() * ((Float) arrayList10.get(i60)).floatValue());
                                d15 += (double) ((Float) arrayList10.get(i60)).floatValue();
                                i60++;
                                size9 = size9;
                                arrayList11 = arrayList11;
                            }
                            arrayList12.add(Float.valueOf((float) (d14 / d15)));
                            i58++;
                            size9 = size9;
                            arrayList11 = arrayList11;
                        }
                        for (int i61 = 0; i61 < fArr20.length; i61++) {
                            fArr21[i61][i50] = ((Float) arrayList12.get(i61)).floatValue();
                        }
                        i50++;
                    }
                    ArrayList<float[]> arrayList14 = new ArrayList<>(yn2.size());
                    for (float[] add3 : fArr21) {
                        arrayList14.add(add3);
                    }
                    yn2 = arrayList14;
                }
                for (int i62 = 0; i62 < 3; i62++) {
                    int size10 = yn2.size();
                    int[] iArr12 = new int[2];
                    iArr12[1] = yn2.get(0).length;
                    iArr12[0] = size10;
                    float[][] fArr24 = (float[][]) Array.newInstance(Float.TYPE, iArr12);
                    for (int i63 = 0; i63 < yn2.size(); i63++) {
                        System.arraycopy(yn2.get(i63), 0, fArr24[i63], 0, yn2.get(i63).length);
                    }
                    int length6 = fArr24.length;
                    float[] fArr25 = new float[length6];
                    for (int i64 = 0; i64 < fArr24.length; i64++) {
                        if (i62 >= 0) {
                            float[] fArr26 = fArr24[i64];
                            if (i62 < fArr26.length) {
                                fArr25[i64] = fArr26[i62];
                            }
                        }
                    }
                    float f16 = f11;
                    for (int i65 = 0; i65 < length6; i65++) {
                        f16 += fArr25[i65];
                    }
                    float f17 = f16 / ((float) length6);
                    for (int i66 = 0; i66 < 256; i66++) {
                        yn2.get(i66)[i62] = yn2.get(i66)[i62] - f17;
                    }
                }
                i12 = 256;
                float[] fArr27 = new float[ValidationPath.MAX_PATH_LENGTH_BYTES];
                int size11 = yn2.size();
                int[] iArr13 = new int[2];
                iArr13[1] = yn2.get(0).length;
                iArr13[0] = size11;
                float[][] fArr28 = (float[][]) Array.newInstance(Float.TYPE, iArr13);
                for (int i67 = 0; i67 < yn2.size(); i67++) {
                    System.arraycopy(yn2.get(i67), 0, fArr28[i67], 0, yn2.get(i67).length);
                }
                int i68 = 0;
                int length7 = fArr28.length;
                int i69 = 0;
                int i70 = 0;
                while (i69 < length7) {
                    float[] fArr29 = fArr28[i69];
                    int i71 = i68;
                    int i72 = i70;
                    while (i71 < fArr28[i68].length) {
                        fArr27[i72] = fArr29[i71];
                        i71++;
                        i72++;
                        i68 = 0;
                    }
                    i69++;
                    i70 = i72;
                    i68 = 0;
                }
                float[][] fArr30 = (float[][]) Array.newInstance(Float.TYPE, new int[]{1, 5});
                try {
                    if (JniUtils.analysisData(fArr27, fArr30) == 0) {
                        float[] fArr31 = fArr30[0];
                        FB.f49989yn = new CopyOnWriteArrayList();
                        for (int i73 = 0; i73 < fArr31.length; i73++) {
                            DetectedActivity detectedActivity = new DetectedActivity();
                            if (i73 == 0) {
                                detectedActivity.setConfidence((int) (fArr31[i73] * 100.0f));
                                detectedActivity.setType(3);
                            }
                            if (i73 == 1) {
                                detectedActivity.setConfidence((int) (fArr31[i73] * 100.0f));
                                detectedActivity.setType(7);
                            }
                            if (i73 == 2) {
                                detectedActivity.setConfidence((int) (fArr31[i73] * 100.0f));
                                detectedActivity.setType(8);
                            }
                            if (i73 == 3) {
                                detectedActivity.setConfidence((int) (fArr31[i73] * 100.0f));
                                detectedActivity.setType(1);
                            }
                            if (i73 == 4) {
                                detectedActivity.setConfidence((int) (fArr31[i73] * 100.0f));
                                detectedActivity.setType(0);
                            }
                            FB.f49989yn.add(detectedActivity);
                        }
                        FB.f49989yn.add(new DetectedActivity(2, (int) ((fArr31[1] + fArr31[2]) * 100.0f)));
                        copyOnWriteArrayList3 = mergeList(copyOnWriteArrayList3, FB.f49989yn);
                        i19 += 100;
                        i17 = i13 + 100;
                        i21 = i14;
                    } else {
                        LogConsole.e("ResultPredict", "analysis result fail");
                        throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
                    }
                } catch (Throwable unused) {
                    LogConsole.e("ResultPredict", "init so file fail");
                    throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
                }
            }
            i18 = i11 + 1;
            i16 = i12;
            copyOnWriteArrayList4 = copyOnWriteArrayList2;
            copyOnWriteArrayList5 = copyOnWriteArrayList;
            z12 = z11;
        }
        boolean z15 = z12;
        synchronized (SYNC_LIST_LOCK) {
            if (z15) {
                this.oriRecordList.clear();
                this.accRecordList.clear();
            }
        }
        for (int i74 = 0; i74 < copyOnWriteArrayList3.size(); i74++) {
            copyOnWriteArrayList3.get(i74).setConfidence(copyOnWriteArrayList3.get(i74).getConfidence() / i21);
        }
        for (DetectedActivity confidence : copyOnWriteArrayList3) {
            if (confidence.getConfidence() >= 50) {
                return copyOnWriteArrayList3;
            }
        }
        copyOnWriteArrayList3.add(new DetectedActivity(4, 100));
        return copyOnWriteArrayList3;
    }

    private LW event2Acc(SensorEvent sensorEvent) {
        LW lw2 = new LW(0.0f, 0.0f, 0.0f);
        lw2.yn(sensorEvent.timestamp);
        lw2.yn(sensorEvent.values[0]);
        lw2.Vw(sensorEvent.values[1]);
        lw2.FB(sensorEvent.values[2]);
        return lw2;
    }

    private static void freeAssets() {
        JniUtils.freeBuffer();
    }

    /* access modifiers changed from: private */
    public List<DetectedActivity> getDetectedActivities() {
        checkIfValid();
        try {
            if (this.accRecordList.size() < 256 || this.oriRecordList.size() < 256) {
                LogConsole.i(TAG, "need to wait for data !");
                this.needToWait = true;
                byte[] bArr = SYNC_LOCK;
                synchronized (bArr) {
                    bArr.wait();
                }
                LogConsole.i(TAG, "wait end!");
                this.needToWait = false;
            }
        } catch (InterruptedException unused) {
            LogConsole.d(TAG, "InterruptedException ");
        }
        ArrayList arrayList = new ArrayList(dealWithDatas());
        Collections.sort(arrayList, new yn(this));
        return arrayList;
    }

    public static RiemannSoftArService getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new RiemannSoftArService();
                }
            }
        }
        return instance;
    }

    private List<DetectedActivity> mergeList(List<DetectedActivity> list, List<DetectedActivity> list2) {
        if (list2 == null || list2.size() == 0) {
            LogConsole.e(TAG, "ResultPredict.predict result is null !");
            return list;
        } else if (list == null || list.size() == 0) {
            return list2;
        } else {
            for (int i11 = 0; i11 < list.size(); i11++) {
                list.get(i11).setConfidence(list.get(i11).getConfidence() + list2.get(i11).getConfidence());
            }
            return list;
        }
    }

    private void register() {
        if (!this.alreadyRegister) {
            new yn().yn((com.huawei.location.activity.callback.yn) this);
        } else {
            LogConsole.i(TAG, " already registered");
        }
    }

    private void unregister() {
        try {
            if (this.alreadyRegister) {
                freeAssets();
                SensorManager sensorManager2 = this.sensorManager;
                if (sensorManager2 != null) {
                    sensorManager2.unregisterListener(this, this.acc);
                    this.sensorManager.unregisterListener(this, this.ori);
                    this.alreadyRegister = false;
                    LogConsole.i(TAG, "unregister acc & ori success");
                }
            }
        } catch (LocationServiceException e11) {
            throw e11;
        } catch (Exception unused) {
            LogConsole.e(TAG, "unregister sensor listener failed");
        }
    }

    public boolean connectService() {
        return false;
    }

    public boolean disConnectService() {
        return false;
    }

    public ActivityRecognitionResult getDetectedActivity(int i11, int i12) {
        LogConsole.i(TAG, "getDetectedActivity");
        return null;
    }

    public Vw getTask() {
        return new Vw(this, (yn) null);
    }

    public boolean isConnected() {
        return false;
    }

    public void modelFileLoadFail(int i11) {
    }

    public void modelFileLoadSuccess() {
        try {
            SensorManager sensorManager2 = this.sensorManager;
            if (sensorManager2 != null) {
                boolean registerListener = sensorManager2.registerListener(this, this.acc, 10000);
                boolean registerListener2 = this.sensorManager.registerListener(this, this.ori, 10000);
                LogConsole.i(TAG, "register accResult: " + registerListener + " register oriResult: " + registerListener2);
                if (!registerListener || !registerListener2) {
                    throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
                }
                this.alreadyRegister = true;
                if (this.scheduledExecutorService == null) {
                    this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
                }
                this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(getTask(), 0, this.delay, TimeUnit.MILLISECONDS);
                LogConsole.i(TAG, "startScheduled exit");
                return;
            }
            LogConsole.i(TAG, "sensorManager is null");
            throw new LocationServiceException(10301, ActivityErrorCode.getErrorCodeMessage(10301) + ":end request.");
        } catch (LocationServiceException e11) {
            throw e11;
        } catch (Exception unused) {
            LogConsole.e(TAG, "register sensor listener failed");
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 3) {
            checkIfValid();
            this.updatTime = System.currentTimeMillis();
            if (sensorEvent.sensor.getType() == 1) {
                this.accRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    if (this.accRecordList.size() > SENSOR_LIST_ALL) {
                        this.accRecordList.remove(0);
                    }
                }
            } else {
                this.oriRecordList.add(event2Acc(sensorEvent));
                synchronized (SYNC_LIST_LOCK) {
                    if (this.oriRecordList.size() > SENSOR_LIST_ALL) {
                        this.oriRecordList.remove(0);
                    }
                }
            }
            if (this.needToWait && this.oriRecordList.size() >= 256 && this.accRecordList.size() >= 256) {
                byte[] bArr = SYNC_LOCK;
                synchronized (bArr) {
                    bArr.notifyAll();
                }
            }
        }
    }

    public void onStatusChanged(int i11, int i12) {
        MovementEvent movementEvent = new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(Integer.valueOf(i11)), i12);
        ArrayList arrayList = new ArrayList();
        arrayList.add(movementEvent);
        if (i11 == 7 || i11 == 8) {
            arrayList.add(new MovementEvent(ActivityRecognitionConstantsMapping.getActivityType(2), i12));
        }
        this.transitionMappingManager.sendActivityTransitionMappingInfo(arrayList, this.mContext);
    }

    public void removeActivityTransitionUpdates(ATCallback aTCallback, ClientInfo clientInfo) {
        com.huawei.location.activity.model.yn ynVar;
        LogConsole.i(TAG, "removeActivityTransitionUpdates");
        this.transitionMappingManager.removeActivityTransitionMappingInfo(aTCallback);
        if (this.transitionMappingManager.getInfos().size() == 0 && (ynVar = this.atProvider) != null) {
            this.recognitionMappingManager.removeActivityUpdatesMappingInfo(ynVar.yn());
            scheduleTimer();
            this.atProvider.Vw();
            this.alreadyRequestAR = false;
            LogConsole.i(TAG, "no activity transition request ");
        }
    }

    public synchronized void removeActivityUpdates(ARCallback aRCallback, ClientInfo clientInfo) {
        LogConsole.i(TAG, "removeActivityUpdates");
        this.recognitionMappingManager.removeActivityUpdatesMappingInfo(aRCallback);
        scheduleTimer();
    }

    public void requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, ATCallback aTCallback, ClientInfo clientInfo) {
        com.huawei.location.activity.model.yn ynVar;
        ObjectCheckUtils.checkNullObject(TAG, (Object) activityTransitionRequest, ActivityTransitionRequest.class);
        List<ActivityTransition> transitions = activityTransitionRequest.getTransitions();
        if (transitions == null || transitions.size() < 1) {
            LogConsole.i(TAG, "requestActivityTransitionUpdates ,null == transitions || transitions.size() < 1");
            return;
        }
        LogConsole.i(TAG, "requestActivityTransitionUpdates");
        this.transitionMappingManager.addActivityTransitionMappingInfo(transitions, aTCallback, clientInfo);
        if (!this.alreadyRequestAR && (ynVar = this.atProvider) != null) {
            this.recognitionMappingManager.addActivityUpdatesMappingInfo(1000, ynVar.yn(), clientInfo);
            this.alreadyRequestAR = true;
        }
        scheduleTimer();
    }

    public synchronized void requestActivityUpdates(long j11, ARCallback aRCallback, ClientInfo clientInfo) {
        LogConsole.i(TAG, "requestActivityUpdates");
        this.recognitionMappingManager.addActivityUpdatesMappingInfo(j11, aRCallback, clientInfo);
        scheduleTimer();
    }

    public synchronized void scheduleTimer() {
        try {
            long minTime = this.recognitionMappingManager.getMinTime();
            if (-1 == minTime) {
                LogConsole.i(TAG, "scheduleTimer return time is " + minTime);
                this.lastTimeByTimer = -1;
                stopScheduled();
                return;
            }
            long j11 = this.lastTimeByTimer;
            if (j11 == -1) {
                LogConsole.i(TAG, "scheduleTimer begin time is " + minTime);
                this.lastTimeByTimer = minTime;
                startScheduled(minTime);
            } else if (minTime != j11) {
                LogConsole.i(TAG, "scheduleTimer begin again time is " + minTime);
                this.lastTimeByTimer = minTime;
                restartScheduled(minTime);
            } else {
                register();
            }
        } catch (LocationServiceException e11) {
            throw e11;
        } catch (Exception unused) {
            LogConsole.e(TAG, "scheduleTimer exception", true);
        }
    }

    public void startScheduled(long j11) {
        this.delay = j11;
        LogConsole.i(TAG, "startScheduled enter");
        register();
    }

    public void stopScheduled() {
        LogConsole.i(TAG, "stopScheduled enter");
        unregister();
        try {
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null) {
                if (!scheduledFuture.isCancelled()) {
                    boolean cancel = this.scheduledFuture.cancel(true);
                    LogConsole.i(TAG, "stopScheduled exit:" + cancel);
                    return;
                }
            }
            LogConsole.i(TAG, "scheduled not init or cancelled");
        } catch (LocationServiceException e11) {
            throw e11;
        } catch (Exception unused) {
            LogConsole.e(TAG, "stopScheduled exit exception", true);
        }
    }
}
