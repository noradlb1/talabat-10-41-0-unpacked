package com.huawei.location.lite.common.security;

import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;

public class FB {
    private PreferencesHelper FB;
    private PreferencesHelper LW;
    private PreferencesHelper Vw;
    private RootKeyUtil dC;

    /* renamed from: yn  reason: collision with root package name */
    private PreferencesHelper f50153yn;

    public FB() {
        Vw();
    }

    private void Vw() {
        this.f50153yn = new PreferencesHelper("LocationCaptainA");
        this.Vw = new PreferencesHelper("LocationIronMan");
        this.FB = new PreferencesHelper("LocationCaptainM");
        this.LW = new PreferencesHelper("LocationJarvis");
        if (this.f50153yn.getString("LocationCaptainA").isEmpty() || this.Vw.getString("LocationIronMan").isEmpty() || this.FB.getString("LocationCaptainM").isEmpty() || this.LW.getString("LocationSpiderMan").isEmpty()) {
            LogConsole.i("RootKey", "generate new root and work key");
            this.f50153yn.saveString("LocationCaptainA", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.Vw.saveString("LocationIronMan", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.FB.saveString("LocationCaptainM", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
            this.LW.saveString("LocationSpiderMan", HexUtil.byteArray2HexStr(EncryptUtil.generateSecureRandom(32)));
        }
        this.dC = RootKeyUtil.newInstance(this.f50153yn.getString("LocationCaptainA"), this.Vw.getString("LocationIronMan"), this.FB.getString("LocationCaptainM"), this.LW.getString("LocationSpiderMan"));
        if (this.LW.getString("LocationJarvis").isEmpty()) {
            this.LW.saveString("LocationJarvis", WorkKeyCryptUtil.encryptWorkKey(EncryptUtil.generateSecureRandomStr(32), this.dC));
        }
    }

    public String a() {
        String str;
        if (this.dC == null) {
            str = "rootKeyUtil is null";
        } else if (!this.LW.getString("LocationJarvis").isEmpty()) {
            return WorkKeyCryptUtil.decryptWorkKey(this.LW.getString("LocationJarvis"), this.dC);
        } else {
            str = "workKey is null";
        }
        LogConsole.e("RootKey", str);
        return "";
    }
}
