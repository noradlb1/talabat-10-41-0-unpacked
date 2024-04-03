package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import java.io.File;
import java.io.IOException;

public class x {

    /* renamed from: a  reason: collision with root package name */
    private String f49144a = q0.i().getFilesDir().getPath();

    private String a(String str) {
        return this.f49144a + "/hms/component/".replace(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY, str);
    }

    private void a(String str, String str2) {
        File file = new File(a(str));
        String a11 = a(str);
        File file2 = new File(a11, "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            v.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            k1.a(file2, str2);
        } else {
            v.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            v.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    private char[] a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = (char) (((hexStr2ByteArray[i11] ^ hexStr2ByteArray2[i11]) ^ hexStr2ByteArray3[i11]) ^ hexStr2ByteArray4[i11]);
        }
        return cArr;
    }

    private String b(String str) {
        String a11 = a(str);
        File file = new File(a11, "hianalytics_" + str);
        if (a(file)) {
            return k1.a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        k1.a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    private boolean b() {
        long a11 = d.a(q0.i(), "Privacy_MY", "assemblyFlash", -1);
        if (-1 != a11) {
            return System.currentTimeMillis() - a11 > 31536000000L;
        }
        v.c("hmsSdk", "First init components");
        return true;
    }

    private static boolean b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    v.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean c() {
        return b(new File(q0.i().getFilesDir().getPath() + "/" + "hms"));
    }

    private String d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() {
        String str;
        String str2;
        String str3;
        String str4;
        String d11 = d();
        if (b()) {
            v.c("hmsSdk", "refresh components");
            str = EncryptUtil.generateSecureRandomStr(128);
            a("aprpap", str);
            str2 = EncryptUtil.generateSecureRandomStr(128);
            a("febdoc", str2);
            str3 = EncryptUtil.generateSecureRandomStr(128);
            a("marfil", str3);
            str4 = EncryptUtil.generateSecureRandomStr(128);
            a("maywnj", str4);
            d.b(q0.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            str = b("aprpap");
            str2 = b("febdoc");
            str3 = b("marfil");
            str4 = b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(str, str2, str3, d11), HexUtil.hexStr2ByteArray(str4), 10000, 16));
    }
}
