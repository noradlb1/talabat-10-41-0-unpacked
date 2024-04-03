package com.visa.checkout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.security.auth.x500.X500Principal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.Opcodes;

@TargetApi(19)
final class f {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f212 = 1;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static char[] f213;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static long f214 = 707705914983990975L;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int f215;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Context f216;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Cipher f217;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final KeyStore f218;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final SharedPreferences f219 = this.f216.getApplicationContext().getSharedPreferences(m6169(15, 15, 0).intern(), 0);

    /* renamed from: ॱ  reason: contains not printable characters */
    private Cipher f220;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Cipher f221 = Cipher.getInstance(m6169(17, 30, 0).intern());

    static {
        char[] cArr = new char[Opcodes.IF_ICMPGE];
        // fill-array-data instruction
        cArr[0] = 19093;
        cArr[1] = 3077;
        cArr[2] = -14386;
        cArr[3] = -24933;
        cArr[4] = 20551;
        cArr[5] = 11014;
        cArr[6] = -7478;
        cArr[7] = -23130;
        cArr[8] = 32585;
        cArr[9] = 13850;
        cArr[10] = -30223;
        cArr[11] = 16533;
        cArr[12] = 6735;
        cArr[13] = -8939;
        cArr[14] = -27453;
        cArr[15] = 99;
        cArr[16] = 18128;
        cArr[17] = -29421;
        cArr[18] = -11245;
        cArr[19] = 6794;
        cArr[20] = 25042;
        cArr[21] = -22519;
        cArr[22] = -4264;
        cArr[23] = 13782;
        cArr[24] = 31943;
        cArr[25] = -15612;
        cArr[26] = 2640;
        cArr[27] = 20626;
        cArr[28] = -26688;
        cArr[29] = -8640;
        cArr[30] = 65;
        cArr[31] = 18170;
        cArr[32] = -29395;
        cArr[33] = -11246;
        cArr[34] = 6843;
        cArr[35] = 25080;
        cArr[36] = -22473;
        cArr[37] = -4330;
        cArr[38] = 13750;
        cArr[39] = 31960;
        cArr[40] = -15578;
        cArr[41] = 2644;
        cArr[42] = 20624;
        cArr[43] = -26665;
        cArr[44] = -8677;
        cArr[45] = 9567;
        cArr[46] = 27543;
        cArr[47] = 82;
        cArr[48] = 18156;
        cArr[49] = -29377;
        cArr[50] = -11246;
        cArr[51] = 6841;
        cArr[52] = 25080;
        cArr[53] = -22472;
        cArr[54] = -4330;
        cArr[55] = 13736;
        cArr[56] = 31996;
        cArr[57] = -15563;
        cArr[58] = 2662;
        cArr[59] = 20677;
        cArr[60] = -26653;
        cArr[61] = -8685;
        cArr[62] = 9557;
        cArr[63] = 27540;
        cArr[64] = -19770;
        cArr[65] = -1792;
        cArr[66] = 16458;
        cArr[67] = 65;
        cArr[68] = 18129;
        cArr[69] = -29414;
        cArr[70] = -11185;
        cArr[71] = 6803;
        cArr[72] = 25042;
        cArr[73] = -22498;
        cArr[74] = -4234;
        cArr[75] = 13704;
        cArr[76] = 31954;
        cArr[77] = -15592;
        cArr[78] = 2662;
        cArr[79] = 20647;
        cArr[80] = -26625;
        cArr[81] = -23767;
        cArr[82] = -6727;
        cArr[83] = 11890;
        cArr[84] = 30503;
        cArr[85] = -17925;
        cArr[86] = -15686;
        cArr[87] = 2934;
        cArr[88] = 19482;
        cArr[89] = -26891;
        cArr[90] = -8282;
        cArr[91] = 24653;
        cArr[92] = -22231;
        cArr[93] = -3085;
        cArr[94] = 13481;
        cArr[95] = 32127;
        cArr[96] = -31205;
        cArr[97] = -14117;
        cArr[98] = 4496;
        cArr[99] = 23145;
        cArr[100] = -7369;
        cArr[101] = 9711;
        cArr[102] = 28322;
        cArr[103] = -18576;
        cArr[104] = -2002;
        cArr[105] = 757;
        cArr[106] = 19361;
        cArr[107] = -29590;
        cArr[108] = -19368;
        cArr[109] = -3349;
        cArr[110] = 14626;
        cArr[111] = 24678;
        cArr[112] = 65;
        cArr[113] = 18170;
        cArr[114] = -29395;
        cArr[115] = 5360;
        cArr[116] = 21072;
        cArr[117] = -26229;
        cArr[118] = -16166;
        cArr[119] = 3633;
        cArr[120] = 30040;
        cArr[121] = -17275;
        cArr[122] = -1138;
        cArr[123] = -7766;
        cArr[124] = -22764;
        cArr[125] = 27847;
        cArr[126] = 67;
        cArr[127] = 18161;
        cArr[128] = -29373;
        cArr[129] = -11189;
        cArr[130] = 6805;
        cArr[131] = 25032;
        cArr[132] = -22501;
        cArr[133] = -4238;
        cArr[134] = 13725;
        cArr[135] = 31950;
        cArr[136] = -15545;
        cArr[137] = 67;
        cArr[138] = 18161;
        cArr[139] = -29346;
        cArr[140] = -11264;
        cArr[141] = 6876;
        cArr[142] = 25037;
        cArr[143] = -22509;
        cArr[144] = -4278;
        cArr[145] = 13721;
        cArr[146] = 31996;
        cArr[147] = -15597;
        cArr[148] = 2636;
        cArr[149] = 20677;
        cArr[150] = -28343;
        cArr[151] = -10254;
        cArr[152] = 7229;
        cArr[153] = 14244;
        cArr[154] = 28986;
        cArr[155] = -17724;
        cArr[156] = -7242;
        cArr[157] = 11634;
        cArr[158] = 22069;
        cArr[159] = -24583;
        cArr[160] = -10051;
        cArr[161] = 629;
        f213 = cArr;
    }

    public f(Context context) throws Exception {
        this.f216 = context;
        KeyStore instance = KeyStore.getInstance(m6169(15, 0, 19156).intern());
        this.f218 = instance;
        instance.load((KeyStore.LoadStoreParameter) null);
    }

    @RequiresApi(api = 23)
    /* renamed from: ʽ  reason: contains not printable characters */
    private SecretKey m6168() throws Exception {
        char c11;
        char c12;
        KeyStore.Entry entry;
        if (this.f218.containsAlias(m6169(8, 115, 5254).intern())) {
            c11 = '6';
        } else {
            c11 = 12;
        }
        boolean z11 = true;
        if (c11 != 12) {
            int i11 = f212 + 71;
            f215 = i11 % 128;
            int i12 = i11 % 2;
            if (this.f218.entryInstanceOf(m6169(8, 115, 5254).intern(), KeyStore.SecretKeyEntry.class)) {
                c12 = '(';
            } else {
                c12 = '`';
            }
            if (c12 == '(') {
                int i13 = f212 + 89;
                f215 = i13 % 128;
                if (i13 % 2 != 0) {
                    z11 = false;
                }
                if (z11) {
                    entry = this.f218.getEntry(m6169(8, 115, 5254).intern(), (KeyStore.ProtectionParameter) null);
                } else {
                    entry = this.f218.getEntry(m6169(126, 21, 5254).intern(), (KeyStore.ProtectionParameter) null);
                }
                return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
            }
        }
        KeyGenerator instance = KeyGenerator.getInstance(m6169(3, 112, 0).intern(), m6169(15, 0, 19156).intern());
        instance.init(new KeyGenParameterSpec.Builder(m6169(8, 115, 5254).intern(), 3).setCertificateSubject(new X500Principal(m6169(13, Opcodes.L2F, 0).intern())).setCertificateSerialNumber(BigInteger.ONE).setKeySize(256).setBlockModes(new String[]{m6169(3, 150, 37134).intern()}).setEncryptionPaddings(new String[]{m6169(9, Opcodes.IFEQ, 14314).intern()}).setRandomizedEncryptionRequired(true).build());
        return instance.generateKey();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Cipher m6170() {
        if ((this.f217 == null ? AbstractJsonLexerKt.COLON : '5') != '5') {
            try {
                this.f217 = m6171(2);
                int i11 = f215 + 99;
                f212 = i11 % 128;
                int i12 = i11 % 2;
            } catch (Exception unused) {
            }
        }
        Cipher cipher = this.f217;
        int i13 = f212 + 3;
        f215 = i13 % 128;
        if ((i13 % 2 != 0 ? (char) 27 : 19) != 19) {
            int i14 = 95 / 0;
        }
        return cipher;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Cipher m6173() {
        char c11;
        int i11 = f215;
        int i12 = i11 + 41;
        f212 = i12 % 128;
        if (i12 % 2 != 0) {
            if (this.f220 == null) {
                c11 = 27;
            } else {
                c11 = 'M';
            }
            if (c11 == 27) {
                int i13 = i11 + 117;
                f212 = i13 % 128;
                int i14 = i13 % 2;
                try {
                    this.f220 = m6171(1);
                } catch (Exception unused) {
                }
            }
            return this.f220;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static byte[] m6174() throws Exception {
        int i11 = f215 + 71;
        f212 = i11 % 128;
        int i12 = i11 % 2;
        boolean z11 = false;
        KeyGenerator instance = KeyGenerator.getInstance(m6169(3, 112, 0).intern(), m6169(15, 0, 19156).intern());
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        int i13 = f215 + 103;
        f212 = i13 % 128;
        if (i13 % 2 == 0) {
            z11 = true;
        }
        if (!z11) {
            return encoded;
        }
        throw null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private KeyPair m6175() throws Exception {
        boolean z11;
        char c11;
        int i11 = f212 + 39;
        f215 = i11 % 128;
        int i12 = i11 % 2;
        if (this.f218.containsAlias(m6169(8, 115, 5254).intern())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 && this.f218.entryInstanceOf(m6169(8, 115, 5254).intern(), KeyStore.PrivateKeyEntry.class)) {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.f218.getEntry(m6169(8, 115, 5254).intern(), (KeyStore.ProtectionParameter) null);
            return new KeyPair((RSAPublicKey) privateKeyEntry.getCertificate().getPublicKey(), (RSAPrivateKey) privateKeyEntry.getPrivateKey());
        }
        KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(this.f216).setAlias(m6169(8, 115, 5254).intern()).setKeySize(256).setKeyType(m6169(3, 123, 57848).intern()).setSerialNumber(BigInteger.valueOf(8885)).setSubject(new X500Principal(m6169(11, 126, 0).intern())).build();
        KeyPairGenerator instance = KeyPairGenerator.getInstance(m6169(3, 123, 57848).intern(), m6169(15, 0, 19156).intern());
        instance.initialize(build);
        KeyPair generateKeyPair = instance.generateKeyPair();
        int i13 = f212 + 71;
        f215 = i13 % 128;
        if (i13 % 2 != 0) {
            c11 = 7;
        } else {
            c11 = '>';
        }
        if (c11 == '>') {
            return generateKeyPair;
        }
        throw null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Pair<byte[], byte[]> m6176(byte[] bArr) throws Exception {
        int i11 = f215 + 87;
        f212 = i11 % 128;
        int i12 = i11 % 2;
        Cipher cipher = this.f221;
        SecretKey r12 = m6168();
        int i13 = f215 + 77;
        f212 = i13 % 128;
        int i14 = i13 % 2;
        cipher.init(1, r12, new SecureRandom());
        return Pair.create(cipher.doFinal(bArr), cipher.getIV());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m6169(int i11, int i12, char c11) {
        char[] cArr;
        int i13 = f212 + 65;
        f215 = i13 % 128;
        int i14 = 0;
        if (!(i13 % 2 != 0)) {
            cArr = new char[i11];
        } else {
            cArr = new char[i11];
            i14 = 1;
        }
        while (true) {
            if ((i14 < i11 ? 'L' : 'X') == 'X') {
                return new String(cArr);
            }
            int i15 = f212 + 73;
            int i16 = i15 % 128;
            f215 = i16;
            int i17 = i15 % 2;
            cArr[i14] = (char) ((int) ((((long) f213[i12 + i14]) ^ (((long) i14) * f214)) ^ ((long) c11)));
            i14++;
            int i18 = i16 + 45;
            f212 = i18 % 128;
            int i19 = i18 % 2;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final byte[] m6177(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKey secretKey;
        Cipher cipher = this.f221;
        int i11 = f215 + 47;
        f212 = i11 % 128;
        if (i11 % 2 == 0) {
            secretKey = m6168();
            int i12 = 44 / 0;
        } else {
            secretKey = m6168();
        }
        cipher.init(2, secretKey, new GCMParameterSpec(128, bArr2));
        int i13 = f212 + 35;
        f215 = i13 % 128;
        int i14 = i13 % 2;
        byte[] doFinal = cipher.doFinal(bArr);
        int i15 = f212 + 57;
        f215 = i15 % 128;
        if (i15 % 2 == 0) {
            return doFinal;
        }
        throw null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Cipher m6171(int i11) throws Exception {
        boolean z11 = false;
        Cipher instance = Cipher.getInstance(m6169(20, 47, 0).intern(), m6169(27, 81, 41832).intern());
        KeyPair r12 = m6175();
        if (i11 == 1) {
            z11 = true;
        }
        if (!z11) {
            instance.init(i11, r12.getPrivate());
            int i12 = f215 + 75;
            f212 = i12 % 128;
            int i13 = i12 % 2;
        } else {
            instance.init(i11, r12.getPublic());
        }
        int i14 = f212 + 1;
        f215 = i14 % 128;
        int i15 = i14 % 2;
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        r0 = m6170().doFinal(android.util.Base64.decode(r8.f219.getString(m6169(4, 108, 46133).intern(), (java.lang.String) null), 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
        if ((r8.f219.contains(m6169(5, 16, 46133).intern())) != true) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if (r8.f219.contains(m6169(4, 108, 46133).intern()) == false) goto L_0x003d;
     */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.crypto.SecretKey m6172() throws java.lang.Exception {
        /*
            r8 = this;
            int r0 = f212
            int r0 = r0 + 25
            int r1 = r0 % 128
            f215 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 108(0x6c, float:1.51E-43)
            r4 = 4
            r5 = 46133(0xb435, float:6.4646E-41)
            if (r0 == 0) goto L_0x002d
            android.content.SharedPreferences r0 = r8.f219
            r6 = 5
            r7 = 16
            java.lang.String r6 = m6169(r6, r7, r5)
            java.lang.String r6 = r6.intern()
            boolean r0 = r0.contains(r6)
            r6 = 1
            if (r0 != 0) goto L_0x0029
            r0 = r2
            goto L_0x002a
        L_0x0029:
            r0 = r6
        L_0x002a:
            if (r0 == r6) goto L_0x006b
            goto L_0x003d
        L_0x002d:
            android.content.SharedPreferences r0 = r8.f219
            java.lang.String r6 = m6169(r4, r3, r5)
            java.lang.String r6 = r6.intern()
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x006b
        L_0x003d:
            byte[] r0 = m6174()
            javax.crypto.Cipher r6 = r8.m6173()
            byte[] r6 = r6.doFinal(r0)
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r1)
            android.content.SharedPreferences r7 = r8.f219
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r3 = m6169(r4, r3, r5)
            java.lang.String r3 = r3.intern()
            r7.putString(r3, r6)
            r7.apply()
            int r3 = f215
            int r3 = r3 + 31
            int r4 = r3 % 128
            f212 = r4
            int r3 = r3 % r1
            goto L_0x0086
        L_0x006b:
            android.content.SharedPreferences r0 = r8.f219
            java.lang.String r3 = m6169(r4, r3, r5)
            java.lang.String r3 = r3.intern()
            r4 = 0
            java.lang.String r0 = r0.getString(r3, r4)
            byte[] r0 = android.util.Base64.decode(r0, r1)
            javax.crypto.Cipher r1 = r8.m6170()
            byte[] r0 = r1.doFinal(r0)
        L_0x0086:
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec
            r3 = 3
            r4 = 112(0x70, float:1.57E-43)
            java.lang.String r2 = m6169(r3, r4, r2)
            java.lang.String r2 = r2.intern()
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.f.m6172():javax.crypto.SecretKey");
    }
}
