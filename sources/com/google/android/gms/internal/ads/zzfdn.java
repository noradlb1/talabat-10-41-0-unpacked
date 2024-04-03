package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.List;
import org.json.JSONObject;

@Instrumented
public final class zzfdn {
    public final String zzA;
    public final zzcgc zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final int zzN;
    public final int zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final String zzR;
    public final zzfei zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final int zzV;
    public final String zzW;
    public final int zzX;
    public final String zzY;
    public final boolean zzZ;
    public final List<String> zza;
    public final zzcby zzaa;
    public final boolean zzab;
    @Nullable
    public final zzbfk zzac;
    public final String zzad;
    public final boolean zzae;
    public final JSONObject zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    @Nullable
    public final String zzaj;
    public final boolean zzak;
    public final int zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final int zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final String zzl;
    @Nullable
    public final zzces zzm;
    public final List<String> zzn;
    public final List<String> zzo;
    public final List<String> zzp;
    public final List<String> zzq;
    public final int zzr;
    public final List<zzfdo> zzs;
    @Nullable
    public final zzfds zzt;
    public final List<String> zzu;
    public final List<zzfdo> zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfdn(android.util.JsonReader r72) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r71 = this;
            r0 = r71
            r71.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfss r21 = com.google.android.gms.internal.ads.zzfss.zzo()
            r72.beginObject()
            java.lang.String r22 = ""
            r23 = 0
            r24 = 0
            r25 = -1
            r26 = 1
            r27 = r16
            r28 = r17
            r29 = r18
            r30 = r19
            r31 = r20
            r32 = r21
            r38 = r22
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r53 = r42
            r57 = r53
            r59 = r57
            r62 = r59
            r64 = r62
            r37 = r23
            r43 = r37
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r49 = r48
            r51 = r49
            r52 = r51
            r54 = r52
            r55 = r54
            r56 = r55
            r60 = r56
            r63 = r60
            r65 = r63
            r66 = r65
            r67 = r66
            r68 = r67
            r19 = r24
            r33 = r19
            r34 = r33
            r35 = r34
            r36 = r35
            r50 = r25
            r58 = r50
            r61 = r26
            r21 = r11
            r20 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r11 = r64
            r12 = r11
            r13 = r68
            r14 = r13
            r15 = r36
        L_0x00d7:
            boolean r24 = r72.hasNext()
            if (r24 == 0) goto L_0x0778
            java.lang.String r24 = r72.nextName()
            if (r24 != 0) goto L_0x00e6
            r69 = r22
            goto L_0x00e8
        L_0x00e6:
            r69 = r24
        L_0x00e8:
            int r24 = r69.hashCode()
            switch(r24) {
                case -1980587809: goto L_0x0558;
                case -1965512151: goto L_0x0547;
                case -1812055556: goto L_0x0536;
                case -1662989631: goto L_0x0525;
                case -1620470467: goto L_0x0514;
                case -1550155393: goto L_0x0503;
                case -1440104884: goto L_0x04f1;
                case -1439500848: goto L_0x04df;
                case -1428969291: goto L_0x04cd;
                case -1406227629: goto L_0x04bb;
                case -1403779768: goto L_0x04a9;
                case -1375413093: goto L_0x0497;
                case -1360811658: goto L_0x0485;
                case -1306015996: goto L_0x0473;
                case -1303332046: goto L_0x0461;
                case -1289032093: goto L_0x044f;
                case -1240082064: goto L_0x043d;
                case -1234181075: goto L_0x042b;
                case -1168140544: goto L_0x0419;
                case -1152230954: goto L_0x0407;
                case -1146534047: goto L_0x03f5;
                case -1115838944: goto L_0x03e3;
                case -1081936678: goto L_0x03d1;
                case -1078050970: goto L_0x03bf;
                case -1051269058: goto L_0x03ad;
                case -982608540: goto L_0x039b;
                case -776859333: goto L_0x038a;
                case -544216775: goto L_0x0378;
                case -437057161: goto L_0x0367;
                case -404433734: goto L_0x0355;
                case -404326515: goto L_0x0343;
                case -397704715: goto L_0x0331;
                case -388807511: goto L_0x031f;
                case -369773488: goto L_0x030d;
                case -213449460: goto L_0x02fb;
                case -213424028: goto L_0x02e9;
                case -180214626: goto L_0x02d7;
                case -154616268: goto L_0x02c5;
                case -29338502: goto L_0x02b3;
                case 3107: goto L_0x02a1;
                case 3355: goto L_0x028f;
                case 3076010: goto L_0x027d;
                case 63195984: goto L_0x026b;
                case 107433883: goto L_0x0259;
                case 230323073: goto L_0x0248;
                case 418392395: goto L_0x0236;
                case 549176928: goto L_0x0224;
                case 597473788: goto L_0x0212;
                case 673261304: goto L_0x0201;
                case 754887508: goto L_0x01ef;
                case 791122864: goto L_0x01de;
                case 1010584092: goto L_0x01cc;
                case 1100650276: goto L_0x01ba;
                case 1186014765: goto L_0x01a8;
                case 1321720943: goto L_0x0196;
                case 1637553475: goto L_0x0184;
                case 1638957285: goto L_0x0173;
                case 1686319423: goto L_0x0161;
                case 1688341040: goto L_0x014f;
                case 1799285870: goto L_0x013d;
                case 1839650832: goto L_0x012b;
                case 1875425491: goto L_0x0119;
                case 2068142375: goto L_0x0107;
                case 2072888499: goto L_0x00f5;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            r70 = r9
            r24 = r10
            goto L_0x0569
        L_0x00f5:
            r24 = r10
            java.lang.String r10 = "manual_tracking_urls"
            r70 = r9
            r9 = r69
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 16
            goto L_0x056b
        L_0x0107:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 53
            goto L_0x056b
        L_0x0119:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 43
            goto L_0x056b
        L_0x012b:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = r23
            goto L_0x056b
        L_0x013d:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 49
            goto L_0x056b
        L_0x014f:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 8
            goto L_0x056b
        L_0x0161:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 56
            goto L_0x056b
        L_0x0173:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 6
            goto L_0x056b
        L_0x0184:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 41
            goto L_0x056b
        L_0x0196:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 32
            goto L_0x056b
        L_0x01a8:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 62
            goto L_0x056b
        L_0x01ba:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 12
            goto L_0x056b
        L_0x01cc:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 10
            goto L_0x056b
        L_0x01de:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 5
            goto L_0x056b
        L_0x01ef:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 18
            goto L_0x056b
        L_0x0201:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "reward_granted_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 7
            goto L_0x056b
        L_0x0212:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 28
            goto L_0x056b
        L_0x0224:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 17
            goto L_0x056b
        L_0x0236:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 37
            goto L_0x056b
        L_0x0248:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 4
            goto L_0x056b
        L_0x0259:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 25
            goto L_0x056b
        L_0x026b:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 34
            goto L_0x056b
        L_0x027d:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 23
            goto L_0x056b
        L_0x028f:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 24
            goto L_0x056b
        L_0x02a1:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 19
            goto L_0x056b
        L_0x02b3:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 33
            goto L_0x056b
        L_0x02c5:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 57
            goto L_0x056b
        L_0x02d7:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 59
            goto L_0x056b
        L_0x02e9:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 47
            goto L_0x056b
        L_0x02fb:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 61
            goto L_0x056b
        L_0x030d:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 51
            goto L_0x056b
        L_0x031f:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 60
            goto L_0x056b
        L_0x0331:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 46
            goto L_0x056b
        L_0x0343:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 39
            goto L_0x056b
        L_0x0355:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 58
            goto L_0x056b
        L_0x0367:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 3
            goto L_0x056b
        L_0x0378:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 27
            goto L_0x056b
        L_0x038a:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 2
            goto L_0x056b
        L_0x039b:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 11
            goto L_0x056b
        L_0x03ad:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 26
            goto L_0x056b
        L_0x03bf:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 9
            goto L_0x056b
        L_0x03d1:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 22
            goto L_0x056b
        L_0x03e3:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 13
            goto L_0x056b
        L_0x03f5:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 44
            goto L_0x056b
        L_0x0407:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = r26
            goto L_0x056b
        L_0x0419:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 15
            goto L_0x056b
        L_0x042b:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 31
            goto L_0x056b
        L_0x043d:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 52
            goto L_0x056b
        L_0x044f:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 30
            goto L_0x056b
        L_0x0461:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 35
            goto L_0x056b
        L_0x0473:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 21
            goto L_0x056b
        L_0x0485:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 20
            goto L_0x056b
        L_0x0497:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 55
            goto L_0x056b
        L_0x04a9:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 45
            goto L_0x056b
        L_0x04bb:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "buffer_click_url_as_ready_to_ping"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 63
            goto L_0x056b
        L_0x04cd:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 40
            goto L_0x056b
        L_0x04df:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 38
            goto L_0x056b
        L_0x04f1:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 36
            goto L_0x056b
        L_0x0503:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "nofill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 14
            goto L_0x056b
        L_0x0514:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 48
            goto L_0x056b
        L_0x0525:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 54
            goto L_0x056b
        L_0x0536:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 50
            goto L_0x056b
        L_0x0547:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 42
            goto L_0x056b
        L_0x0558:
            r70 = r9
            r24 = r10
            r9 = r69
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0569
            r9 = 29
            goto L_0x056b
        L_0x0569:
            r9 = r25
        L_0x056b:
            switch(r9) {
                case 0: goto L_0x076c;
                case 1: goto L_0x0761;
                case 2: goto L_0x075a;
                case 3: goto L_0x0753;
                case 4: goto L_0x074c;
                case 5: goto L_0x0741;
                case 6: goto L_0x073a;
                case 7: goto L_0x0734;
                case 8: goto L_0x072d;
                case 9: goto L_0x0726;
                case 10: goto L_0x071f;
                case 11: goto L_0x0718;
                case 12: goto L_0x070c;
                case 13: goto L_0x0704;
                case 14: goto L_0x06fc;
                case 15: goto L_0x06f2;
                case 16: goto L_0x06e8;
                case 17: goto L_0x06e0;
                case 18: goto L_0x06d6;
                case 19: goto L_0x06cb;
                case 20: goto L_0x06c1;
                case 21: goto L_0x06b7;
                case 22: goto L_0x06af;
                case 23: goto L_0x06a5;
                case 24: goto L_0x06a0;
                case 25: goto L_0x069b;
                case 26: goto L_0x0687;
                case 27: goto L_0x0679;
                case 28: goto L_0x0674;
                case 29: goto L_0x066a;
                case 30: goto L_0x0660;
                case 31: goto L_0x065b;
                case 32: goto L_0x0656;
                case 33: goto L_0x0651;
                case 34: goto L_0x064b;
                case 35: goto L_0x0645;
                case 36: goto L_0x063f;
                case 37: goto L_0x0639;
                case 38: goto L_0x062f;
                case 39: goto L_0x0629;
                case 40: goto L_0x0623;
                case 41: goto L_0x061d;
                case 42: goto L_0x0613;
                case 43: goto L_0x060d;
                case 44: goto L_0x0607;
                case 45: goto L_0x0601;
                case 46: goto L_0x05fb;
                case 47: goto L_0x05f5;
                case 48: goto L_0x05ef;
                case 49: goto L_0x05e9;
                case 50: goto L_0x05db;
                case 51: goto L_0x05d5;
                case 52: goto L_0x05c7;
                case 53: goto L_0x05c1;
                case 54: goto L_0x05bb;
                case 55: goto L_0x05b1;
                case 56: goto L_0x05ab;
                case 57: goto L_0x05a5;
                case 58: goto L_0x059b;
                case 59: goto L_0x0595;
                case 60: goto L_0x058b;
                case 61: goto L_0x0585;
                case 62: goto L_0x057b;
                case 63: goto L_0x0575;
                default: goto L_0x056e;
            }
        L_0x056e:
            r10 = r72
            r72.skipValue()
            goto L_0x0772
        L_0x0575:
            boolean r68 = r72.nextBoolean()
            goto L_0x06b3
        L_0x057b:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            r10 = r72
            r32 = r9
            goto L_0x0772
        L_0x0585:
            boolean r67 = r72.nextBoolean()
            goto L_0x06b3
        L_0x058b:
            java.lang.String r9 = r72.nextString()
            r10 = r72
            r36 = r9
            goto L_0x0772
        L_0x0595:
            boolean r66 = r72.nextBoolean()
            goto L_0x06b3
        L_0x059b:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r31 = r9
            goto L_0x0772
        L_0x05a5:
            boolean r65 = r72.nextBoolean()
            goto L_0x06b3
        L_0x05ab:
            java.lang.String r64 = r72.nextString()
            goto L_0x06b3
        L_0x05b1:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r30 = r9
            goto L_0x0772
        L_0x05bb:
            boolean r63 = r72.nextBoolean()
            goto L_0x06b3
        L_0x05c1:
            java.lang.String r62 = r72.nextString()
            goto L_0x06b3
        L_0x05c7:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            com.google.android.gms.internal.ads.zzbfk r9 = com.google.android.gms.internal.ads.zzbfk.zza(r9)
            r10 = r72
            r35 = r9
            goto L_0x0772
        L_0x05d5:
            boolean r61 = r72.nextBoolean()
            goto L_0x06b3
        L_0x05db:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            com.google.android.gms.internal.ads.zzcby r9 = com.google.android.gms.internal.ads.zzcby.zza(r9)
            r10 = r72
            r34 = r9
            goto L_0x0772
        L_0x05e9:
            boolean r60 = r72.nextBoolean()
            goto L_0x06b3
        L_0x05ef:
            java.lang.String r59 = r72.nextString()
            goto L_0x06b3
        L_0x05f5:
            java.lang.String r57 = r72.nextString()
            goto L_0x06b3
        L_0x05fb:
            int r58 = r72.nextInt()
            goto L_0x06b3
        L_0x0601:
            int r56 = r72.nextInt()
            goto L_0x06b3
        L_0x0607:
            boolean r55 = r72.nextBoolean()
            goto L_0x06b3
        L_0x060d:
            boolean r54 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0613:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r29 = r9
            goto L_0x0772
        L_0x061d:
            java.lang.String r53 = r72.nextString()
            goto L_0x06b3
        L_0x0623:
            boolean r52 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0629:
            int r51 = r72.nextInt()
            goto L_0x06b3
        L_0x062f:
            java.lang.String r9 = r72.nextString()
            int r50 = zzd(r9)
            goto L_0x06b3
        L_0x0639:
            boolean r49 = r72.nextBoolean()
            goto L_0x06b3
        L_0x063f:
            boolean r48 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0645:
            boolean r47 = r72.nextBoolean()
            goto L_0x06b3
        L_0x064b:
            boolean r46 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0651:
            boolean r45 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0656:
            boolean r44 = r72.nextBoolean()
            goto L_0x06b3
        L_0x065b:
            boolean r43 = r72.nextBoolean()
            goto L_0x06b3
        L_0x0660:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r28 = r9
            goto L_0x0772
        L_0x066a:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r27 = r9
            goto L_0x0772
        L_0x0674:
            java.lang.String r42 = r72.nextString()
            goto L_0x06b3
        L_0x0679:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            com.google.android.gms.internal.ads.zzcgc r9 = com.google.android.gms.internal.ads.zzcgc.zza(r9)
            r10 = r72
            r33 = r9
            goto L_0x0772
        L_0x0687:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            boolean r10 = r9 instanceof org.json.JSONObject
            if (r10 != 0) goto L_0x0694
            java.lang.String r9 = r9.toString()
            goto L_0x0698
        L_0x0694:
            java.lang.String r9 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r9)
        L_0x0698:
            r41 = r9
            goto L_0x06b3
        L_0x069b:
            java.lang.String r40 = r72.nextString()
            goto L_0x06b3
        L_0x06a0:
            java.lang.String r39 = r72.nextString()
            goto L_0x06b3
        L_0x06a5:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzby.zzh(r72)
            r10 = r72
            r16 = r9
            goto L_0x0772
        L_0x06af:
            java.lang.String r38 = r72.nextString()
        L_0x06b3:
            r10 = r72
            goto L_0x0772
        L_0x06b7:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            r10 = r72
            r18 = r9
            goto L_0x0772
        L_0x06c1:
            java.util.List r9 = com.google.android.gms.internal.ads.zzfdo.zza(r72)
            r10 = r72
            r17 = r9
            goto L_0x0772
        L_0x06cb:
            com.google.android.gms.internal.ads.zzfds r9 = new com.google.android.gms.internal.ads.zzfds
            r10 = r72
            r9.<init>(r10)
            r19 = r9
            goto L_0x0772
        L_0x06d6:
            r10 = r72
            java.util.List r9 = com.google.android.gms.internal.ads.zzfdo.zza(r72)
            r20 = r9
            goto L_0x0772
        L_0x06e0:
            r10 = r72
            int r37 = r72.nextInt()
            goto L_0x0772
        L_0x06e8:
            r10 = r72
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            r21 = r9
            goto L_0x0772
        L_0x06f2:
            r10 = r72
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            r24 = r9
            goto L_0x0772
        L_0x06fc:
            r10 = r72
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0774
        L_0x0704:
            r10 = r72
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x070c:
            r10 = r72
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzby.zze(r72)
            com.google.android.gms.internal.ads.zzces r9 = com.google.android.gms.internal.ads.zzces.zza(r9)
            r15 = r9
            goto L_0x0772
        L_0x0718:
            r10 = r72
            java.lang.String r11 = r72.nextString()
            goto L_0x0772
        L_0x071f:
            r10 = r72
            java.lang.String r12 = r72.nextString()
            goto L_0x0772
        L_0x0726:
            r10 = r72
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x072d:
            r10 = r72
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x0734:
            r10 = r72
            com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x073a:
            r10 = r72
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x0741:
            r10 = r72
            int r9 = r72.nextInt()
            int r14 = zzc(r9)
            goto L_0x0772
        L_0x074c:
            r10 = r72
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x0753:
            r10 = r72
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x075a:
            r10 = r72
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
            goto L_0x0772
        L_0x0761:
            r10 = r72
            java.lang.String r9 = r72.nextString()
            int r13 = zzb(r9)
            goto L_0x0772
        L_0x076c:
            r10 = r72
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzby.zzd(r72)
        L_0x0772:
            r9 = r70
        L_0x0774:
            r10 = r24
            goto L_0x00d7
        L_0x0778:
            r70 = r9
            r24 = r10
            r10 = r72
            r72.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            r0.zzf = r14
            r0.zzh = r5
            r0.zzi = r6
            r0.zzj = r7
            r0.zzk = r12
            r0.zzl = r11
            r0.zzm = r15
            r0.zzn = r8
            r0.zzo = r9
            r10 = r24
            r0.zzp = r10
            r11 = r21
            r0.zzq = r11
            r1 = r37
            r0.zzr = r1
            r12 = r20
            r0.zzs = r12
            r1 = r19
            r0.zzt = r1
            r13 = r18
            r0.zzu = r13
            r14 = r17
            r0.zzv = r14
            r1 = r38
            r0.zzx = r1
            r15 = r16
            r0.zzw = r15
            r1 = r39
            r0.zzy = r1
            r1 = r40
            r0.zzz = r1
            r1 = r41
            r0.zzA = r1
            r1 = r33
            r0.zzB = r1
            r1 = r42
            r0.zzC = r1
            r1 = r27
            r0.zzD = r1
            r1 = r28
            r0.zzE = r1
            r1 = r43
            r0.zzG = r1
            r1 = r44
            r0.zzH = r1
            r1 = r45
            r0.zzI = r1
            r1 = r46
            r0.zzJ = r1
            r1 = r47
            r0.zzK = r1
            r1 = r48
            r0.zzL = r1
            r1 = r49
            r0.zzM = r1
            r1 = r50
            r0.zzN = r1
            r1 = r51
            r0.zzO = r1
            r1 = r52
            r0.zzQ = r1
            r1 = r53
            r0.zzR = r1
            com.google.android.gms.internal.ads.zzfei r1 = new com.google.android.gms.internal.ads.zzfei
            r2 = r29
            r1.<init>(r2)
            r0.zzS = r1
            r1 = r54
            r0.zzT = r1
            r1 = r55
            r0.zzU = r1
            r1 = r56
            r0.zzV = r1
            r1 = r57
            r0.zzW = r1
            r1 = r58
            r0.zzX = r1
            r1 = r59
            r0.zzY = r1
            r1 = r60
            r0.zzZ = r1
            r1 = r34
            r0.zzaa = r1
            r1 = r61
            r0.zzab = r1
            r1 = r35
            r0.zzac = r1
            r1 = r62
            r0.zzad = r1
            r1 = r63
            r0.zzae = r1
            r1 = r30
            r0.zzaf = r1
            r1 = r64
            r0.zzF = r1
            r1 = r65
            r0.zzag = r1
            r1 = r31
            r0.zzah = r1
            r1 = r66
            r0.zzai = r1
            r1 = r36
            r0.zzaj = r1
            r1 = r67
            r0.zzak = r1
            r1 = r32
            r0.zze = r1
            r1 = r68
            r0.zzP = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdn.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i11) {
        switch (i11) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str) || "app_open_ad_v2".equals(str)) {
            return 6;
        }
        if ("rewarded_interstitial".equals(str)) {
            return 7;
        }
        return 0;
    }

    private static int zzc(int i11) {
        if (i11 == 0 || i11 == 1) {
            return i11;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            return 7;
        }
        return -1;
    }
}
