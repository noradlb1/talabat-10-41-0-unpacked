package com.visa.checkout;

import android.content.Context;
import android.content.SharedPreferences;
import com.visa.checkout.t;
import java.util.EnumSet;
import net.bytebuddy.jar.asm.Opcodes;
import org.json.JSONObject;

final class k {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f251 = 1;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f252;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static long f253 = -3706929301338322178L;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static char[] f254;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f255 = m6204(22, 0, 0).intern();

    /* renamed from: ˊ  reason: contains not printable characters */
    private p f256;

    /* renamed from: ˋ  reason: contains not printable characters */
    private SharedPreferences f257;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f258;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SharedPreferences f259;

    /* renamed from: ॱ  reason: contains not printable characters */
    private t f260;

    static {
        char[] cArr = new char[Opcodes.JSR];
        // fill-array-data instruction
        cArr[0] = 118;
        cArr[1] = 2717;
        cArr[2] = 5523;
        cArr[3] = 8357;
        cArr[4] = 11146;
        cArr[5] = 13971;
        cArr[6] = 16793;
        cArr[7] = 19607;
        cArr[8] = 22429;
        cArr[9] = 25228;
        cArr[10] = 28041;
        cArr[11] = 30872;
        cArr[12] = -31859;
        cArr[13] = -29054;
        cArr[14] = -26191;
        cArr[15] = -23407;
        cArr[16] = -20603;
        cArr[17] = -17748;
        cArr[18] = -14926;
        cArr[19] = -12101;
        cArr[20] = -9291;
        cArr[21] = -6477;
        cArr[22] = 20280;
        cArr[23] = 17881;
        cArr[24] = 23233;
        cArr[25] = 28629;
        cArr[26] = 25813;
        cArr[27] = 31184;
        cArr[28] = 3807;
        cArr[29] = 991;
        cArr[30] = 6357;
        cArr[31] = 11727;
        cArr[32] = 8919;
        cArr[33] = 14288;
        cArr[34] = -13099;
        cArr[35] = -15924;
        cArr[36] = -10559;
        cArr[37] = -30405;
        cArr[38] = -31799;
        cArr[39] = -25399;
        cArr[40] = -22132;
        cArr[41] = -23850;
        cArr[42] = -16441;
        cArr[43] = -14113;
        cArr[44] = -14901;
        cArr[45] = -8570;
        cArr[46] = -5178;
        cArr[47] = -6970;
        cArr[48] = -3625;
        cArr[49] = 2774;
        cArr[50] = 1997;
        cArr[51] = 4238;
        cArr[52] = 105;
        cArr[53] = 2701;
        cArr[54] = 5553;
        cArr[55] = 8339;
        cArr[56] = 11167;
        cArr[57] = 13956;
        cArr[58] = 16789;
        cArr[59] = 19590;
        cArr[60] = 22425;
        cArr[61] = 25217;
        cArr[62] = 28034;
        cArr[63] = 30894;
        cArr[64] = -31865;
        cArr[65] = -29048;
        cArr[66] = -26239;
        cArr[67] = 29364;
        cArr[68] = 30830;
        cArr[69] = 26466;
        cArr[70] = 21105;
        cArr[71] = 22880;
        cArr[72] = 17531;
        cArr[73] = 13156;
        cArr[74] = 15972;
        cArr[75] = 9575;
        cArr[76] = 4162;
        cArr[77] = 8033;
        cArr[78] = 2682;
        cArr[79] = -3715;
        cArr[80] = -916;
        cArr[81] = 118;
        cArr[82] = 2717;
        cArr[83] = 5523;
        cArr[84] = 8357;
        cArr[85] = 11165;
        cArr[86] = 13976;
        cArr[87] = 16791;
        cArr[88] = 19584;
        cArr[89] = 22409;
        cArr[90] = 25246;
        cArr[91] = 28056;
        cArr[92] = 30863;
        cArr[93] = -31860;
        cArr[94] = -28999;
        cArr[95] = -26218;
        cArr[96] = -23417;
        cArr[97] = -20602;
        cArr[98] = -17748;
        cArr[99] = -14919;
        cArr[100] = -12119;
        cArr[101] = -9296;
        cArr[102] = -6519;
        cArr[103] = -3680;
        cArr[104] = -835;
        cArr[105] = 1979;
        cArr[106] = 4779;
        cArr[107] = 7586;
        cArr[108] = 20719;
        cArr[109] = 23062;
        cArr[110] = 17665;
        cArr[111] = 28690;
        cArr[112] = 31489;
        cArr[113] = -21170;
        cArr[114] = -22602;
        cArr[115] = -18270;
        cArr[116] = -29261;
        cArr[117] = -31059;
        cArr[118] = -25684;
        cArr[119] = -4958;
        cArr[120] = -7764;
        cArr[121] = -9570;
        cArr[122] = -12169;
        cArr[123] = -12419;
        cArr[124] = -1421;
        cArr[125] = -3719;
        cArr[126] = -5000;
        cArr[127] = -25731;
        cArr[128] = -27028;
        cArr[129] = -29359;
        cArr[130] = -18329;
        cArr[131] = 28914;
        cArr[132] = 31235;
        cArr[133] = 25862;
        cArr[134] = 20489;
        cArr[135] = 23305;
        cArr[136] = 17936;
        cArr[137] = 12560;
        cArr[138] = 15380;
        cArr[139] = 9997;
        cArr[140] = 4628;
        cArr[141] = 7436;
        cArr[142] = 117;
        cArr[143] = 2701;
        cArr[144] = 5529;
        cArr[145] = 8328;
        cArr[146] = 11185;
        cArr[147] = 13976;
        cArr[148] = 16786;
        cArr[149] = 19613;
        cArr[150] = 20759;
        cArr[151] = 23550;
        cArr[152] = 17663;
        cArr[153] = 29165;
        cArr[154] = 31480;
        cArr[155] = 26592;
        cArr[156] = 4345;
        cArr[157] = 7624;
        cArr[158] = 1761;
        cArr[159] = 13284;
        cArr[160] = 15586;
        cArr[161] = 10730;
        cArr[162] = -11549;
        cArr[163] = 1612;
        cArr[164] = 3241;
        cArr[165] = 5039;
        cArr[166] = 9895;
        cArr[167] = 11694;
        f254 = cArr;
    }

    public k(Context context, t tVar) {
        this.f258 = context;
        this.f257 = context.getApplicationContext().getSharedPreferences(m6204(15, 22, 20302).intern(), 0);
        this.f259 = context.getApplicationContext().getSharedPreferences(m6204(15, 37, 35160).intern(), 0);
        this.f260 = tVar;
        this.f256 = new p(this.f258);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m6204(int i11, int i12, char c11) {
        char c12;
        int i13 = f251 + 93;
        f252 = i13 % 128;
        int i14 = 0;
        if (i13 % 2 != 0) {
        }
        char[] cArr = new char[i11];
        while (true) {
            if (i14 < i11) {
                c12 = 1;
            } else {
                c12 = 24;
            }
            if (c12 != 1) {
                return new String(cArr);
            }
            int i15 = f252 + 47;
            f251 = i15 % 128;
            if (i15 % 2 == 0) {
                cArr[i14] = (char) ((int) ((((long) f254[i12 >> i14]) * (((long) i14) | f253)) - ((long) c11)));
                i14 += 63;
            } else {
                cArr[i14] = (char) ((int) ((((long) f254[i12 + i14]) ^ (((long) i14) * f253)) ^ ((long) c11)));
                i14++;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6205(String str, boolean z11, boolean z12) throws Exception {
        String intern = m6204(8, Opcodes.D2I, 0).intern();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(m6204(8, 113, 44347).intern(), (Object) str);
        jSONObject.put(m6204(10, 121, 56044).intern(), z11);
        jSONObject.put(m6204(11, 131, 28820).intern(), z12);
        this.f260.m6301(intern, new t.a(jSONObject), EnumSet.noneOf(x.class), "");
        int i11 = f252 + 15;
        f251 = i11 % 128;
        int i12 = i11 % 2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m6206() {
        char c11;
        String str;
        char c12;
        boolean z11;
        boolean z12;
        int i11 = f252 + 63;
        f251 = i11 % 128;
        if (i11 % 2 == 0) {
            try {
                if (!this.f259.getBoolean(m6204(114, 71, 0).intern(), false)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!z12) {
                }
                int i12 = f252 + 39;
                f251 = i12 % 128;
                int i13 = i12 % 2;
            } catch (Exception e11) {
                m6204(14, 67, 29433).intern();
                e11.getStackTrace();
                return;
            }
        } else {
            if (!this.f259.getBoolean(m6204(15, 52, 0).intern(), false)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                int i122 = f252 + 39;
                f251 = i122 % 128;
                int i132 = i122 % 2;
            }
        }
        if (this.f257.getString(this.f255, (String) null) != null) {
            c11 = ')';
        } else {
            c11 = 13;
        }
        if (c11 != 13) {
            int i14 = f251 + 23;
            f252 = i14 % 128;
            int i15 = i14 % 2;
            m6205(this.f257.getString(this.f255, (String) null), true, this.f257.contains(m6204(27, 81, 0).intern()));
            this.f257.edit().remove(this.f255).apply();
        } else if (this.f257.getString(m6204(5, 108, 20636).intern(), (String) null) != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f257.getString(m6204(5, 108, 20636).intern(), ""));
                m6205(jSONObject.optString(m6204(8, 113, 44347).intern()), jSONObject.optBoolean(m6204(10, 121, 56044).intern(), false), jSONObject.optBoolean(m6204(11, 131, 28820).intern(), false));
                this.f257.edit().remove(m6204(5, 108, 20636).intern()).apply();
            } catch (Exception e12) {
                m6204(14, 67, 29433).intern();
                e12.getStackTrace();
            }
        }
        String intern = m6204(13, 150, 20837).intern();
        EnumSet<E> noneOf = EnumSet.noneOf(x.class);
        noneOf.add(x.f417);
        if (this.f257.contains(m6204(27, 81, 0).intern())) {
            int i16 = f251 + 67;
            f252 = i16 % 128;
            if (i16 % 2 != 0) {
                c12 = '8';
            } else {
                c12 = '<';
            }
            if (c12 == '<') {
                str = this.f256.m6270();
                this.f256.m6271();
            } else {
                this.f256.m6270();
                this.f256.m6271();
                throw null;
            }
        } else if (this.f257.contains(m6204(5, Opcodes.IF_ICMPGT, 1592).intern())) {
            str = this.f256.m6268();
            this.f256.m6269();
        } else {
            str = null;
        }
        this.f260.m6301(intern, str, noneOf, "");
        this.f259.edit().putBoolean(m6204(15, 52, 0).intern(), true).apply();
        int i1222 = f252 + 39;
        f251 = i1222 % 128;
        int i1322 = i1222 % 2;
    }
}
