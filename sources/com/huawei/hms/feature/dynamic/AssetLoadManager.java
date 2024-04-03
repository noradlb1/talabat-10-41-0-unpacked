package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.FileUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetLoadManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48681a = "AssetLoadManager";

    /* renamed from: b  reason: collision with root package name */
    private static final String f48682b = "dynamic_modules";

    /* renamed from: c  reason: collision with root package name */
    private static final String f48683c = ".apk";

    /* renamed from: d  reason: collision with root package name */
    private static final String f48684d = "com.huawei.hms.feature.dynamic.descriptors.";

    /* renamed from: e  reason: collision with root package name */
    private static final String f48685e = ".AssetModuleDescriptor";

    private static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f48681a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(f48684d + str + f48685e).getDeclaredField("MODULE_VERSION").getInt((Object) null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f48681a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e11) {
            Logger.w(f48681a, "Get local asset module info failed.", (Throwable) e11);
            return 0;
        }
    }

    private static Bundle a(Context context, File file, String str) {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.w(f48681a, "No version in module path.");
            return new Bundle();
        }
        int i11 = 0;
        for (String parseInt : list) {
            i11 = Math.max(Integer.parseInt(parseInt), i11);
        }
        if (i11 == 0) {
            Logger.w(f48681a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(i11, canonicalPath, list, f48681a);
            if (a(context, str) > i11) {
                Logger.i(f48681a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(canonicalPath);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(i11);
            sb2.append(str2);
            sb2.append(str);
            sb2.append(f48683c);
            String sb3 = sb2.toString();
            if (!new File(sb3).exists()) {
                Logger.w(f48681a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            bundle.putString(b.f48771n, sb3);
            bundle.putInt(b.f48770m, i11);
            Logger.i(f48681a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i11 + ", ModulePath:" + sb3);
            return bundle;
        } catch (IOException e11) {
            Logger.w(f48681a, "request modulePath error: " + e11.getMessage());
            return new Bundle();
        }
    }

    private static String a(Context context, String str, int i11, String str2) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            AssetManager assets = context.getAssets();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f48682b);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(str);
            sb2.append(str3);
            sb2.append(str2);
            inputStream = assets.open(sb2.toString());
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
                bufferedInputStream = null;
                try {
                    Logger.w(f48681a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                    FileUtils.a((Closeable) bufferedInputStream);
                    FileUtils.a((Closeable) fileOutputStream);
                    FileUtils.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    FileUtils.a((Closeable) bufferedInputStream);
                    FileUtils.a((Closeable) fileOutputStream2);
                    FileUtils.a((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                FileUtils.a((Closeable) bufferedInputStream);
                FileUtils.a((Closeable) fileOutputStream2);
                FileUtils.a((Closeable) inputStream);
                throw th;
            }
            try {
                String str4 = ModuleCopy.getProtectedPath(context) + str3 + f48682b + str3 + str + str3 + i11;
                if (new File(str4).exists() || new File(str4).mkdirs()) {
                    String str5 = str4 + str3 + str + f48683c;
                    fileOutputStream = new FileOutputStream(str5);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 4096);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                Logger.i(f48681a, "Decompress module:" + str + " from assets success.");
                                FileUtils.a((Closeable) bufferedInputStream);
                                FileUtils.a((Closeable) fileOutputStream);
                                FileUtils.a((Closeable) inputStream);
                                return str5;
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        Logger.w(f48681a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                        FileUtils.a((Closeable) bufferedInputStream);
                        FileUtils.a((Closeable) fileOutputStream);
                        FileUtils.a((Closeable) inputStream);
                        return null;
                    }
                } else {
                    Logger.w(f48681a, "mkdirs local loaderPath failed.");
                    FileUtils.a((Closeable) bufferedInputStream);
                    FileUtils.a((Closeable) null);
                    FileUtils.a((Closeable) inputStream);
                    return null;
                }
            } catch (Exception e13) {
                e = e13;
                fileOutputStream = null;
                Logger.w(f48681a, "Cannot find module:" + str + " in assets.", (Throwable) e);
                FileUtils.a((Closeable) bufferedInputStream);
                FileUtils.a((Closeable) fileOutputStream);
                FileUtils.a((Closeable) inputStream);
                return null;
            } catch (Throwable th4) {
                th = th4;
                FileUtils.a((Closeable) bufferedInputStream);
                FileUtils.a((Closeable) fileOutputStream2);
                FileUtils.a((Closeable) inputStream);
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            inputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
            Logger.w(f48681a, "Cannot find module:" + str + " in assets.", (Throwable) e);
            FileUtils.a((Closeable) bufferedInputStream);
            FileUtils.a((Closeable) fileOutputStream);
            FileUtils.a((Closeable) inputStream);
            return null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            bufferedInputStream = null;
            FileUtils.a((Closeable) bufferedInputStream);
            FileUtils.a((Closeable) fileOutputStream2);
            FileUtils.a((Closeable) inputStream);
            throw th;
        }
    }

    private static Bundle b(Context context, String str) {
        try {
            AssetManager assets = context.getAssets();
            String[] list = assets.list(f48682b + File.separator + str);
            if (list != null) {
                if (list.length != 0) {
                    String str2 = list[0];
                    int a11 = a(context, str);
                    String a12 = a(context, str, a11, str2);
                    if (!TextUtils.isEmpty(a12)) {
                        if (new File(a12).exists()) {
                            if (!ExtractNativeUtils.a(context, a12) || ExtractNativeUtils.a(new File(a12), FileUtils.c(a12)) == 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString("module_name", str);
                                bundle.putString(b.f48771n, a12);
                                bundle.putInt(b.f48770m, a11);
                                Logger.i(f48681a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + a11 + ", ModulePath:" + a12);
                                return bundle;
                            }
                            Logger.w(f48681a, "Extract native to current dir failed.");
                            return new Bundle();
                        }
                    }
                    Logger.w(f48681a, "Decompress module from assets failed.");
                    return new Bundle();
                }
            }
            Logger.w(f48681a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e11) {
            Logger.i(f48681a, "getModuleFromAsset failed.", e11);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f48681a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ModuleCopy.getProtectedPath(context));
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(f48682b);
            sb2.append(str2);
            sb2.append(str);
            File file = new File(sb2.toString());
            if (file.exists()) {
                Bundle a11 = a(context, file, str);
                if (a11.getInt(b.f48770m) > 0) {
                    Logger.i(f48681a, "Successfully get module info from decompressed asset path.");
                    return a11;
                }
            }
            Bundle b11 = b(context, str);
            if (b11.getInt(b.f48770m) > 0) {
                Logger.i(f48681a, "Successfully get module info from asset.");
                return b11;
            }
        } catch (Exception e11) {
            Logger.i(f48681a, "getDataModuleInfo failed.", e11);
        }
        return new Bundle();
    }
}
