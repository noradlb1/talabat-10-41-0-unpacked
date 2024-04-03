package com.google.i18n.phonenumbers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.huawei.wearengine.sensor.Sensor;
import com.newrelic.agent.android.Agent;
import com.talabat.helpers.GlobalConstants;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class CountryCodeToRegionCodeMap {
    public static Map<Integer, List<String>> getCountryCodeToRegionCodeMap() {
        HashMap hashMap = new HashMap(286);
        ArrayList arrayList = new ArrayList(25);
        arrayList.add(Profile.Country.US);
        arrayList.add("AG");
        arrayList.add("AI");
        arrayList.add("AS");
        arrayList.add("BB");
        arrayList.add("BM");
        arrayList.add("BS");
        arrayList.add(Profile.Country.CA);
        arrayList.add("DM");
        arrayList.add("DO");
        arrayList.add("GD");
        arrayList.add("GU");
        arrayList.add("JM");
        arrayList.add("KN");
        arrayList.add("KY");
        arrayList.add("LC");
        arrayList.add("MP");
        arrayList.add("MS");
        arrayList.add("PR");
        arrayList.add("SX");
        arrayList.add("TC");
        arrayList.add("TT");
        arrayList.add("VC");
        arrayList.add("VG");
        arrayList.add("VI");
        hashMap.put(1, arrayList);
        ArrayList arrayList2 = new ArrayList(2);
        arrayList2.add("RU");
        arrayList2.add("KZ");
        hashMap.put(7, arrayList2);
        ArrayList arrayList3 = new ArrayList(1);
        arrayList3.add("EG");
        hashMap.put(20, arrayList3);
        ArrayList arrayList4 = new ArrayList(1);
        arrayList4.add(Profile.Country.ZA);
        hashMap.put(27, arrayList4);
        ArrayList arrayList5 = new ArrayList(1);
        arrayList5.add("GR");
        hashMap.put(30, arrayList5);
        ArrayList arrayList6 = new ArrayList(1);
        arrayList6.add("NL");
        hashMap.put(31, arrayList6);
        ArrayList arrayList7 = new ArrayList(1);
        arrayList7.add("BE");
        hashMap.put(32, arrayList7);
        ArrayList arrayList8 = new ArrayList(1);
        arrayList8.add(Profile.Country.FR);
        hashMap.put(33, arrayList8);
        ArrayList arrayList9 = new ArrayList(1);
        arrayList9.add(Profile.Country.ES);
        hashMap.put(34, arrayList9);
        ArrayList arrayList10 = new ArrayList(1);
        arrayList10.add("HU");
        hashMap.put(36, arrayList10);
        ArrayList arrayList11 = new ArrayList(2);
        arrayList11.add("IT");
        arrayList11.add("VA");
        hashMap.put(39, arrayList11);
        ArrayList arrayList12 = new ArrayList(1);
        arrayList12.add("RO");
        hashMap.put(40, arrayList12);
        ArrayList arrayList13 = new ArrayList(1);
        arrayList13.add("CH");
        hashMap.put(41, arrayList13);
        ArrayList arrayList14 = new ArrayList(1);
        arrayList14.add("AT");
        hashMap.put(43, arrayList14);
        ArrayList arrayList15 = new ArrayList(4);
        arrayList15.add(Profile.Country.GB);
        arrayList15.add("GG");
        arrayList15.add("IM");
        arrayList15.add("JE");
        hashMap.put(44, arrayList15);
        ArrayList arrayList16 = new ArrayList(1);
        arrayList16.add("DK");
        hashMap.put(45, arrayList16);
        ArrayList arrayList17 = new ArrayList(1);
        arrayList17.add("SE");
        hashMap.put(46, arrayList17);
        ArrayList arrayList18 = new ArrayList(2);
        arrayList18.add(Agent.MONO_INSTRUMENTATION_FLAG);
        arrayList18.add("SJ");
        hashMap.put(47, arrayList18);
        ArrayList arrayList19 = new ArrayList(1);
        arrayList19.add(Profile.Country.PL);
        hashMap.put(48, arrayList19);
        ArrayList arrayList20 = new ArrayList(1);
        arrayList20.add("DE");
        hashMap.put(49, arrayList20);
        ArrayList arrayList21 = new ArrayList(1);
        arrayList21.add(Profile.Country.PE);
        hashMap.put(51, arrayList21);
        ArrayList arrayList22 = new ArrayList(1);
        arrayList22.add(Profile.Country.MX);
        hashMap.put(52, arrayList22);
        ArrayList arrayList23 = new ArrayList(1);
        arrayList23.add("CU");
        hashMap.put(53, arrayList23);
        ArrayList arrayList24 = new ArrayList(1);
        arrayList24.add(Profile.Country.AR);
        hashMap.put(54, arrayList24);
        ArrayList arrayList25 = new ArrayList(1);
        arrayList25.add(Profile.Country.BR);
        hashMap.put(55, arrayList25);
        ArrayList arrayList26 = new ArrayList(1);
        arrayList26.add(Profile.Country.CL);
        hashMap.put(56, arrayList26);
        ArrayList arrayList27 = new ArrayList(1);
        arrayList27.add(Profile.Country.CO);
        hashMap.put(57, arrayList27);
        ArrayList arrayList28 = new ArrayList(1);
        arrayList28.add("VE");
        hashMap.put(58, arrayList28);
        ArrayList arrayList29 = new ArrayList(1);
        arrayList29.add(Profile.Country.MY);
        hashMap.put(60, arrayList29);
        ArrayList arrayList30 = new ArrayList(3);
        arrayList30.add(Profile.Country.AU);
        arrayList30.add("CC");
        arrayList30.add("CX");
        hashMap.put(61, arrayList30);
        ArrayList arrayList31 = new ArrayList(1);
        arrayList31.add("ID");
        hashMap.put(62, arrayList31);
        ArrayList arrayList32 = new ArrayList(1);
        arrayList32.add("PH");
        hashMap.put(63, arrayList32);
        ArrayList arrayList33 = new ArrayList(1);
        arrayList33.add(Profile.Country.NZ);
        hashMap.put(64, arrayList33);
        ArrayList arrayList34 = new ArrayList(1);
        arrayList34.add(Profile.Country.SG);
        hashMap.put(65, arrayList34);
        ArrayList arrayList35 = new ArrayList(1);
        arrayList35.add("TH");
        hashMap.put(66, arrayList35);
        ArrayList arrayList36 = new ArrayList(1);
        arrayList36.add("JP");
        hashMap.put(81, arrayList36);
        ArrayList arrayList37 = new ArrayList(1);
        arrayList37.add("KR");
        hashMap.put(82, arrayList37);
        ArrayList arrayList38 = new ArrayList(1);
        arrayList38.add("VN");
        hashMap.put(84, arrayList38);
        ArrayList arrayList39 = new ArrayList(1);
        arrayList39.add(Profile.Country.CN);
        hashMap.put(86, arrayList39);
        ArrayList arrayList40 = new ArrayList(1);
        arrayList40.add("TR");
        hashMap.put(90, arrayList40);
        ArrayList arrayList41 = new ArrayList(1);
        arrayList41.add(Profile.Country.IN);
        hashMap.put(91, arrayList41);
        ArrayList arrayList42 = new ArrayList(1);
        arrayList42.add("PK");
        hashMap.put(92, arrayList42);
        ArrayList arrayList43 = new ArrayList(1);
        arrayList43.add("AF");
        hashMap.put(93, arrayList43);
        ArrayList arrayList44 = new ArrayList(1);
        arrayList44.add("LK");
        hashMap.put(94, arrayList44);
        ArrayList arrayList45 = new ArrayList(1);
        arrayList45.add("MM");
        hashMap.put(95, arrayList45);
        ArrayList arrayList46 = new ArrayList(1);
        arrayList46.add("IR");
        hashMap.put(98, arrayList46);
        ArrayList arrayList47 = new ArrayList(1);
        arrayList47.add("SS");
        hashMap.put(211, arrayList47);
        ArrayList arrayList48 = new ArrayList(2);
        arrayList48.add(RequestConfiguration.MAX_AD_CONTENT_RATING_MA);
        arrayList48.add("EH");
        hashMap.put(212, arrayList48);
        ArrayList arrayList49 = new ArrayList(1);
        arrayList49.add("DZ");
        hashMap.put(213, arrayList49);
        ArrayList arrayList50 = new ArrayList(1);
        arrayList50.add("TN");
        hashMap.put(216, arrayList50);
        ArrayList arrayList51 = new ArrayList(1);
        arrayList51.add("LY");
        hashMap.put(218, arrayList51);
        ArrayList arrayList52 = new ArrayList(1);
        arrayList52.add("GM");
        hashMap.put(220, arrayList52);
        ArrayList arrayList53 = new ArrayList(1);
        arrayList53.add("SN");
        hashMap.put(221, arrayList53);
        ArrayList arrayList54 = new ArrayList(1);
        arrayList54.add("MR");
        hashMap.put(222, arrayList54);
        ArrayList arrayList55 = new ArrayList(1);
        arrayList55.add("ML");
        hashMap.put(223, arrayList55);
        ArrayList arrayList56 = new ArrayList(1);
        arrayList56.add("GN");
        hashMap.put(224, arrayList56);
        ArrayList arrayList57 = new ArrayList(1);
        arrayList57.add("CI");
        hashMap.put(225, arrayList57);
        ArrayList arrayList58 = new ArrayList(1);
        arrayList58.add("BF");
        hashMap.put(226, arrayList58);
        ArrayList arrayList59 = new ArrayList(1);
        arrayList59.add("NE");
        hashMap.put(227, arrayList59);
        ArrayList arrayList60 = new ArrayList(1);
        arrayList60.add("TG");
        hashMap.put(228, arrayList60);
        ArrayList arrayList61 = new ArrayList(1);
        arrayList61.add("BJ");
        hashMap.put(229, arrayList61);
        ArrayList arrayList62 = new ArrayList(1);
        arrayList62.add("MU");
        hashMap.put(230, arrayList62);
        ArrayList arrayList63 = new ArrayList(1);
        arrayList63.add("LR");
        hashMap.put(231, arrayList63);
        ArrayList arrayList64 = new ArrayList(1);
        arrayList64.add("SL");
        hashMap.put(232, arrayList64);
        ArrayList arrayList65 = new ArrayList(1);
        arrayList65.add("GH");
        hashMap.put(233, arrayList65);
        ArrayList arrayList66 = new ArrayList(1);
        arrayList66.add("NG");
        hashMap.put(234, arrayList66);
        ArrayList arrayList67 = new ArrayList(1);
        arrayList67.add("TD");
        hashMap.put(235, arrayList67);
        ArrayList arrayList68 = new ArrayList(1);
        arrayList68.add("CF");
        hashMap.put(236, arrayList68);
        ArrayList arrayList69 = new ArrayList(1);
        arrayList69.add("CM");
        hashMap.put(237, arrayList69);
        ArrayList arrayList70 = new ArrayList(1);
        arrayList70.add("CV");
        hashMap.put(238, arrayList70);
        ArrayList arrayList71 = new ArrayList(1);
        arrayList71.add("ST");
        hashMap.put(239, arrayList71);
        ArrayList arrayList72 = new ArrayList(1);
        arrayList72.add("GQ");
        hashMap.put(Integer.valueOf(PsExtractor.VIDEO_STREAM_MASK), arrayList72);
        ArrayList arrayList73 = new ArrayList(1);
        arrayList73.add("GA");
        hashMap.put(241, arrayList73);
        ArrayList arrayList74 = new ArrayList(1);
        arrayList74.add("CG");
        hashMap.put(242, arrayList74);
        ArrayList arrayList75 = new ArrayList(1);
        arrayList75.add("CD");
        hashMap.put(243, arrayList75);
        ArrayList arrayList76 = new ArrayList(1);
        arrayList76.add("AO");
        hashMap.put(244, arrayList76);
        ArrayList arrayList77 = new ArrayList(1);
        arrayList77.add("GW");
        hashMap.put(245, arrayList77);
        ArrayList arrayList78 = new ArrayList(1);
        arrayList78.add("IO");
        hashMap.put(246, arrayList78);
        ArrayList arrayList79 = new ArrayList(1);
        arrayList79.add("AC");
        hashMap.put(247, arrayList79);
        ArrayList arrayList80 = new ArrayList(1);
        arrayList80.add("SC");
        hashMap.put(248, arrayList80);
        ArrayList arrayList81 = new ArrayList(1);
        arrayList81.add("SD");
        hashMap.put(249, arrayList81);
        ArrayList arrayList82 = new ArrayList(1);
        arrayList82.add("RW");
        hashMap.put(250, arrayList82);
        ArrayList arrayList83 = new ArrayList(1);
        arrayList83.add("ET");
        hashMap.put(251, arrayList83);
        ArrayList arrayList84 = new ArrayList(1);
        arrayList84.add("SO");
        hashMap.put(252, arrayList84);
        ArrayList arrayList85 = new ArrayList(1);
        arrayList85.add("DJ");
        hashMap.put(253, arrayList85);
        ArrayList arrayList86 = new ArrayList(1);
        arrayList86.add("KE");
        hashMap.put(254, arrayList86);
        ArrayList arrayList87 = new ArrayList(1);
        arrayList87.add("TZ");
        hashMap.put(255, arrayList87);
        ArrayList arrayList88 = new ArrayList(1);
        arrayList88.add("UG");
        hashMap.put(256, arrayList88);
        ArrayList arrayList89 = new ArrayList(1);
        arrayList89.add("BI");
        hashMap.put(257, arrayList89);
        ArrayList arrayList90 = new ArrayList(1);
        arrayList90.add("MZ");
        hashMap.put(Integer.valueOf(BZip2Constants.MAX_ALPHA_SIZE), arrayList90);
        ArrayList arrayList91 = new ArrayList(1);
        arrayList91.add("ZM");
        hashMap.put(260, arrayList91);
        ArrayList arrayList92 = new ArrayList(1);
        arrayList92.add("MG");
        hashMap.put(261, arrayList92);
        ArrayList arrayList93 = new ArrayList(2);
        arrayList93.add("RE");
        arrayList93.add("YT");
        hashMap.put(262, arrayList93);
        ArrayList arrayList94 = new ArrayList(1);
        arrayList94.add("ZW");
        hashMap.put(Integer.valueOf(TarConstants.VERSION_OFFSET), arrayList94);
        ArrayList arrayList95 = new ArrayList(1);
        arrayList95.add("NA");
        hashMap.put(264, arrayList95);
        ArrayList arrayList96 = new ArrayList(1);
        arrayList96.add("MW");
        hashMap.put(265, arrayList96);
        ArrayList arrayList97 = new ArrayList(1);
        arrayList97.add("LS");
        hashMap.put(266, arrayList97);
        ArrayList arrayList98 = new ArrayList(1);
        arrayList98.add("BW");
        hashMap.put(267, arrayList98);
        ArrayList arrayList99 = new ArrayList(1);
        arrayList99.add("SZ");
        hashMap.put(268, arrayList99);
        ArrayList arrayList100 = new ArrayList(1);
        arrayList100.add("KM");
        hashMap.put(269, arrayList100);
        ArrayList arrayList101 = new ArrayList(2);
        arrayList101.add("SH");
        arrayList101.add("TA");
        hashMap.put(290, arrayList101);
        ArrayList arrayList102 = new ArrayList(1);
        arrayList102.add("ER");
        hashMap.put(291, arrayList102);
        ArrayList arrayList103 = new ArrayList(1);
        arrayList103.add("AW");
        hashMap.put(297, arrayList103);
        ArrayList arrayList104 = new ArrayList(1);
        arrayList104.add("FO");
        hashMap.put(298, arrayList104);
        ArrayList arrayList105 = new ArrayList(1);
        arrayList105.add("GL");
        hashMap.put(299, arrayList105);
        ArrayList arrayList106 = new ArrayList(1);
        arrayList106.add("GI");
        hashMap.put(350, arrayList106);
        ArrayList arrayList107 = new ArrayList(1);
        arrayList107.add("PT");
        hashMap.put(351, arrayList107);
        ArrayList arrayList108 = new ArrayList(1);
        arrayList108.add("LU");
        hashMap.put(352, arrayList108);
        ArrayList arrayList109 = new ArrayList(1);
        arrayList109.add(Profile.Country.IE);
        hashMap.put(353, arrayList109);
        ArrayList arrayList110 = new ArrayList(1);
        arrayList110.add("IS");
        hashMap.put(354, arrayList110);
        ArrayList arrayList111 = new ArrayList(1);
        arrayList111.add("AL");
        hashMap.put(355, arrayList111);
        ArrayList arrayList112 = new ArrayList(1);
        arrayList112.add("MT");
        hashMap.put(356, arrayList112);
        ArrayList arrayList113 = new ArrayList(1);
        arrayList113.add("CY");
        hashMap.put(357, arrayList113);
        ArrayList arrayList114 = new ArrayList(2);
        arrayList114.add("FI");
        arrayList114.add("AX");
        hashMap.put(358, arrayList114);
        ArrayList arrayList115 = new ArrayList(1);
        arrayList115.add("BG");
        hashMap.put(359, arrayList115);
        ArrayList arrayList116 = new ArrayList(1);
        arrayList116.add("LT");
        hashMap.put(370, arrayList116);
        ArrayList arrayList117 = new ArrayList(1);
        arrayList117.add("LV");
        hashMap.put(371, arrayList117);
        ArrayList arrayList118 = new ArrayList(1);
        arrayList118.add("EE");
        hashMap.put(372, arrayList118);
        ArrayList arrayList119 = new ArrayList(1);
        arrayList119.add("MD");
        hashMap.put(373, arrayList119);
        ArrayList arrayList120 = new ArrayList(1);
        arrayList120.add("AM");
        hashMap.put(374, arrayList120);
        ArrayList arrayList121 = new ArrayList(1);
        arrayList121.add("BY");
        hashMap.put(375, arrayList121);
        ArrayList arrayList122 = new ArrayList(1);
        arrayList122.add("AD");
        hashMap.put(376, arrayList122);
        ArrayList arrayList123 = new ArrayList(1);
        arrayList123.add("MC");
        hashMap.put(377, arrayList123);
        ArrayList arrayList124 = new ArrayList(1);
        arrayList124.add("SM");
        hashMap.put(378, arrayList124);
        ArrayList arrayList125 = new ArrayList(1);
        arrayList125.add(Profile.Country.UA);
        hashMap.put(380, arrayList125);
        ArrayList arrayList126 = new ArrayList(1);
        arrayList126.add("RS");
        hashMap.put(381, arrayList126);
        ArrayList arrayList127 = new ArrayList(1);
        arrayList127.add("ME");
        hashMap.put(382, arrayList127);
        ArrayList arrayList128 = new ArrayList(1);
        arrayList128.add("XK");
        hashMap.put(383, arrayList128);
        ArrayList arrayList129 = new ArrayList(1);
        arrayList129.add(Sensor.NAME_HR);
        hashMap.put(385, arrayList129);
        ArrayList arrayList130 = new ArrayList(1);
        arrayList130.add("SI");
        hashMap.put(386, arrayList130);
        ArrayList arrayList131 = new ArrayList(1);
        arrayList131.add("BA");
        hashMap.put(387, arrayList131);
        ArrayList arrayList132 = new ArrayList(1);
        arrayList132.add("MK");
        hashMap.put(389, arrayList132);
        ArrayList arrayList133 = new ArrayList(1);
        arrayList133.add("CZ");
        hashMap.put(420, arrayList133);
        ArrayList arrayList134 = new ArrayList(1);
        arrayList134.add("SK");
        hashMap.put(421, arrayList134);
        ArrayList arrayList135 = new ArrayList(1);
        arrayList135.add("LI");
        hashMap.put(Integer.valueOf(TypedValues.CycleType.TYPE_WAVE_PERIOD), arrayList135);
        ArrayList arrayList136 = new ArrayList(1);
        arrayList136.add("FK");
        hashMap.put(500, arrayList136);
        ArrayList arrayList137 = new ArrayList(1);
        arrayList137.add("BZ");
        hashMap.put(501, arrayList137);
        ArrayList arrayList138 = new ArrayList(1);
        arrayList138.add("GT");
        hashMap.put(502, arrayList138);
        ArrayList arrayList139 = new ArrayList(1);
        arrayList139.add("SV");
        hashMap.put(503, arrayList139);
        ArrayList arrayList140 = new ArrayList(1);
        arrayList140.add("HN");
        hashMap.put(504, arrayList140);
        ArrayList arrayList141 = new ArrayList(1);
        arrayList141.add("NI");
        hashMap.put(505, arrayList141);
        ArrayList arrayList142 = new ArrayList(1);
        arrayList142.add("CR");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_X), arrayList142);
        ArrayList arrayList143 = new ArrayList(1);
        arrayList143.add("PA");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_Y), arrayList143);
        ArrayList arrayList144 = new ArrayList(1);
        arrayList144.add("PM");
        hashMap.put(508, arrayList144);
        ArrayList arrayList145 = new ArrayList(1);
        arrayList145.add("HT");
        hashMap.put(509, arrayList145);
        ArrayList arrayList146 = new ArrayList(3);
        arrayList146.add("GP");
        arrayList146.add("BL");
        arrayList146.add("MF");
        hashMap.put(590, arrayList146);
        ArrayList arrayList147 = new ArrayList(1);
        arrayList147.add("BO");
        hashMap.put(591, arrayList147);
        ArrayList arrayList148 = new ArrayList(1);
        arrayList148.add("GY");
        hashMap.put(592, arrayList148);
        ArrayList arrayList149 = new ArrayList(1);
        arrayList149.add("EC");
        hashMap.put(593, arrayList149);
        ArrayList arrayList150 = new ArrayList(1);
        arrayList150.add("GF");
        hashMap.put(594, arrayList150);
        ArrayList arrayList151 = new ArrayList(1);
        arrayList151.add("PY");
        hashMap.put(595, arrayList151);
        ArrayList arrayList152 = new ArrayList(1);
        arrayList152.add("MQ");
        hashMap.put(596, arrayList152);
        ArrayList arrayList153 = new ArrayList(1);
        arrayList153.add("SR");
        hashMap.put(597, arrayList153);
        ArrayList arrayList154 = new ArrayList(1);
        arrayList154.add("UY");
        hashMap.put(598, arrayList154);
        ArrayList arrayList155 = new ArrayList(2);
        arrayList155.add("CW");
        arrayList155.add("BQ");
        hashMap.put(599, arrayList155);
        ArrayList arrayList156 = new ArrayList(1);
        arrayList156.add("TL");
        hashMap.put(670, arrayList156);
        ArrayList arrayList157 = new ArrayList(1);
        arrayList157.add("NF");
        hashMap.put(672, arrayList157);
        ArrayList arrayList158 = new ArrayList(1);
        arrayList158.add("BN");
        hashMap.put(673, arrayList158);
        ArrayList arrayList159 = new ArrayList(1);
        arrayList159.add("NR");
        hashMap.put(674, arrayList159);
        ArrayList arrayList160 = new ArrayList(1);
        arrayList160.add(RequestConfiguration.MAX_AD_CONTENT_RATING_PG);
        hashMap.put(675, arrayList160);
        ArrayList arrayList161 = new ArrayList(1);
        arrayList161.add("TO");
        hashMap.put(676, arrayList161);
        ArrayList arrayList162 = new ArrayList(1);
        arrayList162.add("SB");
        hashMap.put(677, arrayList162);
        ArrayList arrayList163 = new ArrayList(1);
        arrayList163.add("VU");
        hashMap.put(678, arrayList163);
        ArrayList arrayList164 = new ArrayList(1);
        arrayList164.add("FJ");
        hashMap.put(679, arrayList164);
        ArrayList arrayList165 = new ArrayList(1);
        arrayList165.add("PW");
        hashMap.put(680, arrayList165);
        ArrayList arrayList166 = new ArrayList(1);
        arrayList166.add("WF");
        hashMap.put(681, arrayList166);
        ArrayList arrayList167 = new ArrayList(1);
        arrayList167.add("CK");
        hashMap.put(682, arrayList167);
        ArrayList arrayList168 = new ArrayList(1);
        arrayList168.add("NU");
        hashMap.put(683, arrayList168);
        ArrayList arrayList169 = new ArrayList(1);
        arrayList169.add("WS");
        hashMap.put(685, arrayList169);
        ArrayList arrayList170 = new ArrayList(1);
        arrayList170.add("KI");
        hashMap.put(686, arrayList170);
        ArrayList arrayList171 = new ArrayList(1);
        arrayList171.add("NC");
        hashMap.put(687, arrayList171);
        ArrayList arrayList172 = new ArrayList(1);
        arrayList172.add("TV");
        hashMap.put(688, arrayList172);
        ArrayList arrayList173 = new ArrayList(1);
        arrayList173.add("PF");
        hashMap.put(689, arrayList173);
        ArrayList arrayList174 = new ArrayList(1);
        arrayList174.add("TK");
        hashMap.put(690, arrayList174);
        ArrayList arrayList175 = new ArrayList(1);
        arrayList175.add("FM");
        hashMap.put(691, arrayList175);
        ArrayList arrayList176 = new ArrayList(1);
        arrayList176.add("MH");
        hashMap.put(692, arrayList176);
        ArrayList arrayList177 = new ArrayList(1);
        arrayList177.add("001");
        hashMap.put(800, arrayList177);
        ArrayList arrayList178 = new ArrayList(1);
        arrayList178.add("001");
        hashMap.put(808, arrayList178);
        ArrayList arrayList179 = new ArrayList(1);
        arrayList179.add("KP");
        hashMap.put(850, arrayList179);
        ArrayList arrayList180 = new ArrayList(1);
        arrayList180.add(Profile.Country.HK);
        hashMap.put(852, arrayList180);
        ArrayList arrayList181 = new ArrayList(1);
        arrayList181.add("MO");
        hashMap.put(853, arrayList181);
        ArrayList arrayList182 = new ArrayList(1);
        arrayList182.add("KH");
        hashMap.put(855, arrayList182);
        ArrayList arrayList183 = new ArrayList(1);
        arrayList183.add("LA");
        hashMap.put(856, arrayList183);
        ArrayList arrayList184 = new ArrayList(1);
        arrayList184.add("001");
        hashMap.put(870, arrayList184);
        ArrayList arrayList185 = new ArrayList(1);
        arrayList185.add("001");
        hashMap.put(878, arrayList185);
        ArrayList arrayList186 = new ArrayList(1);
        arrayList186.add("BD");
        hashMap.put(880, arrayList186);
        ArrayList arrayList187 = new ArrayList(1);
        arrayList187.add("001");
        hashMap.put(881, arrayList187);
        ArrayList arrayList188 = new ArrayList(1);
        arrayList188.add("001");
        hashMap.put(882, arrayList188);
        ArrayList arrayList189 = new ArrayList(1);
        arrayList189.add("001");
        hashMap.put(883, arrayList189);
        ArrayList arrayList190 = new ArrayList(1);
        arrayList190.add("TW");
        hashMap.put(886, arrayList190);
        ArrayList arrayList191 = new ArrayList(1);
        arrayList191.add("001");
        hashMap.put(888, arrayList191);
        ArrayList arrayList192 = new ArrayList(1);
        arrayList192.add("MV");
        hashMap.put(960, arrayList192);
        ArrayList arrayList193 = new ArrayList(1);
        arrayList193.add(ExpandedProductParsedResult.POUND);
        hashMap.put(961, arrayList193);
        ArrayList arrayList194 = new ArrayList(1);
        arrayList194.add("JO");
        hashMap.put(962, arrayList194);
        ArrayList arrayList195 = new ArrayList(1);
        arrayList195.add("SY");
        hashMap.put(963, arrayList195);
        ArrayList arrayList196 = new ArrayList(1);
        arrayList196.add("IQ");
        hashMap.put(Integer.valueOf(GlobalConstants.IRAQ_COUNTRY_CODE), arrayList196);
        ArrayList arrayList197 = new ArrayList(1);
        arrayList197.add(Profile.Country.KW);
        hashMap.put(965, arrayList197);
        ArrayList arrayList198 = new ArrayList(1);
        arrayList198.add(Profile.Country.SA);
        hashMap.put(966, arrayList198);
        ArrayList arrayList199 = new ArrayList(1);
        arrayList199.add("YE");
        hashMap.put(967, arrayList199);
        ArrayList arrayList200 = new ArrayList(1);
        arrayList200.add("OM");
        hashMap.put(968, arrayList200);
        ArrayList arrayList201 = new ArrayList(1);
        arrayList201.add("PS");
        hashMap.put(970, arrayList201);
        ArrayList arrayList202 = new ArrayList(1);
        arrayList202.add(Profile.Country.AE);
        hashMap.put(971, arrayList202);
        ArrayList arrayList203 = new ArrayList(1);
        arrayList203.add("IL");
        hashMap.put(972, arrayList203);
        ArrayList arrayList204 = new ArrayList(1);
        arrayList204.add("BH");
        hashMap.put(973, arrayList204);
        ArrayList arrayList205 = new ArrayList(1);
        arrayList205.add(Profile.Country.QA);
        hashMap.put(974, arrayList205);
        ArrayList arrayList206 = new ArrayList(1);
        arrayList206.add("BT");
        hashMap.put(975, arrayList206);
        ArrayList arrayList207 = new ArrayList(1);
        arrayList207.add("MN");
        hashMap.put(976, arrayList207);
        ArrayList arrayList208 = new ArrayList(1);
        arrayList208.add("NP");
        hashMap.put(977, arrayList208);
        ArrayList arrayList209 = new ArrayList(1);
        arrayList209.add("001");
        hashMap.put(979, arrayList209);
        ArrayList arrayList210 = new ArrayList(1);
        arrayList210.add("TJ");
        hashMap.put(992, arrayList210);
        ArrayList arrayList211 = new ArrayList(1);
        arrayList211.add("TM");
        hashMap.put(993, arrayList211);
        ArrayList arrayList212 = new ArrayList(1);
        arrayList212.add("AZ");
        hashMap.put(994, arrayList212);
        ArrayList arrayList213 = new ArrayList(1);
        arrayList213.add("GE");
        hashMap.put(995, arrayList213);
        ArrayList arrayList214 = new ArrayList(1);
        arrayList214.add(ExpandedProductParsedResult.KILOGRAM);
        hashMap.put(996, arrayList214);
        ArrayList arrayList215 = new ArrayList(1);
        arrayList215.add("UZ");
        hashMap.put(998, arrayList215);
        return hashMap;
    }
}
