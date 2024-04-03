package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class zzaz {
    private static zzba zza(File file) {
        BufferedReader bufferedReader;
        String str;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            HashMap hashMap = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        if (readLine.length() != 0) {
                            str = "Invalid: ".concat(readLine);
                        } else {
                            str = new String("Invalid: ");
                        }
                        Log.e("HermeticFileOverrides", str);
                    } else {
                        String str2 = split[0];
                        String decode = Uri.decode(split[1]);
                        String decode2 = Uri.decode(split[2]);
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new HashMap());
                        }
                        ((Map) hashMap.get(str2)).put(decode, decode2);
                    }
                } else {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
                    sb2.append("Parsed ");
                    sb2.append(valueOf);
                    Log.i("HermeticFileOverrides", sb2.toString());
                    zzba zzba = new zzba(hashMap);
                    bufferedReader.close();
                    return zzba;
                }
            }
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        } catch (Throwable th2) {
            zzds.zza(th, th2);
        }
        throw th;
    }

    public static zzcn<zzba> zzf(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z11 = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z11 = true;
        }
        if (!z11) {
            return zzcn.zzbx();
        }
        if (zzan.zzs() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcn<File> zzg = zzg(context);
        if (zzg.isPresent()) {
            return zzcn.zzb(zza(zzg.get()));
        }
        return zzcn.zzbx();
    }

    private static zzcn<File> zzg(Context context) {
        zzcn<File> zzcn;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            if (file.exists()) {
                zzcn = zzcn.zzb(file);
            } else {
                zzcn = zzcn.zzbx();
            }
            return zzcn;
        } catch (RuntimeException e11) {
            Log.e("HermeticFileOverrides", "no data dir", e11);
            return zzcn.zzbx();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
