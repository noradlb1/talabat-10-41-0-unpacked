package com.uxcam.internals;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.firebase.database.core.ValidationPath;
import com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit;
import com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnitType;
import com.uxcam.video.screen.codec.codecs.h264.io.model.PictureParameterSet;
import com.uxcam.video.screen.codec.codecs.h264.io.model.RefPicMarkingIDR;
import com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet;
import com.uxcam.video.screen.codec.codecs.h264.io.model.SliceHeader;
import com.uxcam.video.screen.codec.codecs.h264.io.model.SliceType;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class gi {

    /* renamed from: a  reason: collision with root package name */
    public final gb f13435a;

    /* renamed from: b  reason: collision with root package name */
    public final hg f13436b;

    /* renamed from: c  reason: collision with root package name */
    public final cx f13437c = new cx(new bn());

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f13438d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f13439e;

    /* renamed from: f  reason: collision with root package name */
    public final ch f13440f;

    /* renamed from: g  reason: collision with root package name */
    public final ByteBuffer f13441g = ByteBuffer.allocate(4194304);

    /* renamed from: h  reason: collision with root package name */
    public final ds f13442h;

    /* renamed from: i  reason: collision with root package name */
    public ek f13443i;

    public gi(File file) {
        hg hgVar;
        bx a11 = eb.a(file);
        this.f13435a = a11;
        ds dsVar = new ds(a11, ao.MP4.a());
        this.f13442h = dsVar;
        gb gbVar = dsVar.f13231c;
        int i11 = dsVar.f13232d;
        dsVar.f13232d = i11 + 1;
        ch chVar = new ch(gbVar, i11, 1, 1);
        dsVar.f13229a.add(chVar);
        this.f13440f = chVar;
        bc bcVar = bc.RGB;
        bc bcVar2 = bc.YUV420J;
        Map map = (Map) ((HashMap) bd.f13061a).get(bcVar);
        if (map == null) {
            hgVar = null;
        } else {
            hgVar = (hg) map.get(bcVar2);
        }
        this.f13436b = hgVar;
        this.f13438d = new ArrayList();
        this.f13439e = new ArrayList();
    }

    public void a(Bitmap bitmap, int i11) {
        ByteBuffer a11;
        int i12;
        SliceType sliceType;
        int i13 = i11;
        ek a12 = ek.a(Integer.parseInt(String.valueOf(bitmap.getWidth())), Integer.parseInt(String.valueOf(bitmap.getHeight())), bc.RGB);
        int[] iArr = a12.f13284d[0];
        int[] iArr2 = new int[(bitmap.getHeight() * bitmap.getWidth())];
        bitmap.getPixels(iArr2, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < bitmap.getHeight(); i16++) {
            int i17 = 0;
            while (i17 < bitmap.getWidth()) {
                int i18 = iArr2[i14];
                iArr[i15] = (i18 >> 16) & 255;
                iArr[i15 + 1] = (i18 >> 8) & 255;
                iArr[i15 + 2] = i18 & 255;
                i17++;
                i14++;
                i15 += 3;
            }
        }
        if (this.f13443i == null) {
            int i19 = a12.f13282b;
            int i21 = a12.f13283c;
            this.f13437c.getClass();
            this.f13443i = ek.a(i19, i21, bc.YUV420J);
        }
        int i22 = gm.f13458g;
        int i23 = i22 > 1000 ? i22 / 1000 : 1;
        this.f13436b.a(a12, this.f13443i);
        this.f13441g.clear();
        cx cxVar = this.f13437c;
        ek ekVar = this.f13443i;
        ByteBuffer byteBuffer = this.f13441g;
        cxVar.getClass();
        ByteBuffer duplicate = byteBuffer.duplicate();
        int i24 = ekVar.f13282b;
        int i25 = ekVar.f13283c;
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        int i26 = ((i24 + 15) >> 4) - 1;
        seqParameterSet.pic_width_in_mbs_minus1 = i26;
        int i27 = ((i25 + 15) >> 4) - 1;
        seqParameterSet.pic_height_in_map_units_minus1 = i27;
        seqParameterSet.chroma_format_idc = bc.YUV420;
        seqParameterSet.profile_idc = 66;
        seqParameterSet.level_idc = 40;
        seqParameterSet.frame_mbs_only_flag = true;
        int i28 = (i26 + 1) << 4;
        int i29 = (i27 + 1) << 4;
        seqParameterSet.frame_cropping_flag = (i28 == i24 && i29 == i25) ? false : true;
        seqParameterSet.frame_crop_right_offset = ((i28 - i24) + 1) >> 1;
        seqParameterSet.frame_crop_bottom_offset = ((i29 - i25) + 1) >> 1;
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        cxVar.f13176a.getClass();
        pictureParameterSet.pic_init_qp_minus26 = -6;
        duplicate.putInt(1);
        new NALUnit(NALUnitType.SPS, 3).write(duplicate);
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        seqParameterSet.write(allocate);
        allocate.flip();
        cy.a(allocate, duplicate);
        duplicate.putInt(1);
        new NALUnit(NALUnitType.PPS, 3).write(duplicate);
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        pictureParameterSet.write(allocate2);
        allocate2.flip();
        cy.a(allocate2, duplicate);
        int i31 = seqParameterSet.pic_width_in_mbs_minus1 + 1;
        cxVar.f13178c = new int[][]{new int[16], new int[8], new int[8]};
        int i32 = i31 << 3;
        cxVar.f13179d = new int[][]{new int[(i31 << 4)], new int[i32], new int[i32]};
        cxVar.f13177b = new ap[]{new ap(seqParameterSet, 2, 2), new ap(seqParameterSet, 1, 1), new ap(seqParameterSet, 1, 1)};
        cxVar.f13176a.getClass();
        cxVar.f13176a.getClass();
        duplicate.putInt(1);
        new NALUnit(NALUnitType.IDR_SLICE, 2).write(duplicate);
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.slice_type = SliceType.I;
        sliceHeader.refPicMarkingIDR = new RefPicMarkingIDR(false, false);
        sliceHeader.pps = pictureParameterSet;
        sliceHeader.sps = seqParameterSet;
        sliceHeader.pic_order_cnt_lsb = 0;
        ak akVar = new ak(ByteBuffer.allocate(ekVar.f13282b * ekVar.f13283c));
        gq gqVar = new gq();
        SeqParameterSet seqParameterSet2 = sliceHeader.sps;
        PictureParameterSet pictureParameterSet2 = sliceHeader.pps;
        ar.a(akVar, sliceHeader.first_mb_in_slice);
        ar.a(akVar, sliceHeader.slice_type.ordinal() + (sliceHeader.slice_type_restr ? 5 : 0));
        ar.a(akVar, sliceHeader.pic_parameter_set_id);
        akVar.a(sliceHeader.frame_num, seqParameterSet2.log2_max_frame_num_minus4 + 4);
        if (!seqParameterSet2.frame_mbs_only_flag) {
            akVar.b(sliceHeader.field_pic_flag ? 1 : 0);
            if (sliceHeader.field_pic_flag) {
                akVar.b(sliceHeader.bottom_field_flag ? 1 : 0);
            }
        }
        ar.a(akVar, sliceHeader.idr_pic_id);
        if (seqParameterSet2.pic_order_cnt_type == 0) {
            akVar.a(sliceHeader.pic_order_cnt_lsb, seqParameterSet2.log2_max_pic_order_cnt_lsb_minus4 + 4);
            if (pictureParameterSet2.pic_order_present_flag && !seqParameterSet2.field_pic_flag) {
                ar.a(akVar, dv.a(sliceHeader.delta_pic_order_cnt_bottom));
            }
        }
        if (seqParameterSet2.pic_order_cnt_type == 1 && !seqParameterSet2.delta_pic_order_always_zero_flag) {
            ar.a(akVar, dv.a(sliceHeader.delta_pic_order_cnt[0]));
            if (pictureParameterSet2.pic_order_present_flag && !seqParameterSet2.field_pic_flag) {
                ar.a(akVar, dv.a(sliceHeader.delta_pic_order_cnt[1]));
            }
        }
        if (pictureParameterSet2.redundant_pic_cnt_present_flag) {
            ar.a(akVar, sliceHeader.redundant_pic_cnt);
        }
        SliceType sliceType2 = sliceHeader.slice_type;
        SliceType sliceType3 = SliceType.B;
        if (sliceType2 == sliceType3) {
            akVar.b(sliceHeader.direct_spatial_mv_pred_flag ? 1 : 0);
        }
        SliceType sliceType4 = sliceHeader.slice_type;
        SliceType sliceType5 = SliceType.P;
        if (sliceType4 == sliceType5 || sliceType4 == SliceType.SP || sliceType4 == sliceType3) {
            akVar.b(sliceHeader.num_ref_idx_active_override_flag ? 1 : 0);
            if (sliceHeader.num_ref_idx_active_override_flag) {
                ar.a(akVar, sliceHeader.num_ref_idx_active_minus1[0]);
                if (sliceHeader.slice_type == sliceType3) {
                    ar.a(akVar, sliceHeader.num_ref_idx_active_minus1[1]);
                }
            }
        }
        if (sliceHeader.slice_type.isInter()) {
            akVar.b(sliceHeader.refPicReordering[0] != null ? 1 : 0);
            gqVar.a(sliceHeader.refPicReordering[0], akVar);
        }
        if (sliceHeader.slice_type == sliceType3) {
            akVar.b(sliceHeader.refPicReordering[1] != null ? 1 : 0);
            gqVar.a(sliceHeader.refPicReordering[1], akVar);
        }
        if ((pictureParameterSet2.weighted_pred_flag && ((sliceType = sliceHeader.slice_type) == sliceType5 || sliceType == SliceType.SP)) || (pictureParameterSet2.weighted_bipred_idc == 1 && sliceHeader.slice_type == sliceType3)) {
            SeqParameterSet seqParameterSet3 = sliceHeader.sps;
            ar.a(akVar, sliceHeader.pred_weight_table.luma_log2_weight_denom);
            if (seqParameterSet3.chroma_format_idc != bc.MONO) {
                ar.a(akVar, sliceHeader.pred_weight_table.chroma_log2_weight_denom);
            }
            gqVar.a(sliceHeader, akVar, 0);
            if (sliceHeader.slice_type == sliceType3) {
                gqVar.a(sliceHeader, akVar, 1);
            }
        }
        RefPicMarkingIDR refPicMarkingIDR = sliceHeader.refPicMarkingIDR;
        akVar.b(refPicMarkingIDR.isDiscardDecodedPics() ? 1 : 0);
        akVar.b(refPicMarkingIDR.isUseForlongTerm() ? 1 : 0);
        if (pictureParameterSet2.entropy_coding_mode_flag && sliceHeader.slice_type.isInter()) {
            ar.a(akVar, sliceHeader.cabac_init_idc);
        }
        ar.a(akVar, dv.a(sliceHeader.slice_qp_delta));
        SliceType sliceType6 = sliceHeader.slice_type;
        SliceType sliceType7 = SliceType.SP;
        if (sliceType6 == sliceType7 || sliceType6 == SliceType.SI) {
            if (sliceType6 == sliceType7) {
                akVar.b(sliceHeader.sp_for_switch_flag ? 1 : 0);
            }
            ar.a(akVar, dv.a(sliceHeader.slice_qs_delta));
        }
        if (pictureParameterSet2.deblocking_filter_control_present_flag) {
            ar.a(akVar, sliceHeader.disable_deblocking_filter_idc);
            if (sliceHeader.disable_deblocking_filter_idc != 1) {
                ar.a(akVar, dv.a(sliceHeader.slice_alpha_c0_offset_div2));
                ar.a(akVar, dv.a(sliceHeader.slice_beta_offset_div2));
            }
        }
        if (pictureParameterSet2.num_slice_groups_minus1 > 0 && (i12 = pictureParameterSet2.slice_group_map_type) >= 3 && i12 <= 5) {
            int i33 = (seqParameterSet2.pic_width_in_mbs_minus1 + 1) * (seqParameterSet2.pic_height_in_map_units_minus1 + 1);
            int i34 = pictureParameterSet2.slice_group_change_rate_minus1 + 1;
            int i35 = i33 / i34;
            if (i33 % i34 > 0) {
                i35++;
            }
            int i36 = (i35 + 1) - 1;
            int i37 = 0;
            while (i36 != 0) {
                i36 >>= 1;
                i37++;
            }
            akVar.a(sliceHeader.slice_group_change_cycle, i37);
        }
        char c11 = 16;
        ek a13 = ek.a(16, 16, bc.YUV420);
        int i38 = 0;
        while (true) {
            if (i38 >= seqParameterSet.pic_height_in_map_units_minus1 + 1) {
                break;
            }
            ak akVar2 = akVar;
            int i39 = 0;
            for (int i41 = 1; i39 < seqParameterSet.pic_width_in_mbs_minus1 + i41; i41 = 1) {
                ar.a(akVar2, 23);
                ak akVar3 = new ak(akVar2.f12993a.duplicate(), akVar2.f12996d, akVar2.f12995c, akVar2.f12994b);
                cxVar.f13176a.getClass();
                ar.a(akVar3, 0);
                ar.a(akVar3, dv.a(0));
                int i42 = i39 << 4;
                int i43 = i38 << 4;
                int a14 = cxVar.a(i42, i43);
                int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{16, 16});
                ak akVar4 = akVar3;
                int i44 = 0;
                while (i44 < iArr3.length) {
                    int[] iArr4 = iArr3[i44];
                    int[] iArr5 = ekVar.f13284d[0];
                    int[][] iArr6 = iArr3;
                    int i45 = ekVar.f13282b;
                    int i46 = i39;
                    bc bcVar = ekVar.f13281a;
                    cxVar.a(iArr5, i45 >> bcVar.f13059c[0], ekVar.f13283c >> bcVar.f13060d[0], i42 + cw.f13172h[i44], i43 + cw.f13173i[i44], iArr4, a14);
                    ba.a(iArr4);
                    i44++;
                    akVar2 = akVar2;
                    iArr3 = iArr6;
                    i43 = i43;
                    i38 = i38;
                    i23 = i23;
                    i39 = i46;
                    duplicate = duplicate;
                    seqParameterSet = seqParameterSet;
                    int i47 = i11;
                    akVar4 = akVar4;
                }
                int[][] iArr7 = iArr3;
                int i48 = i39;
                ak akVar5 = akVar2;
                int i49 = i38;
                SeqParameterSet seqParameterSet4 = seqParameterSet;
                ByteBuffer byteBuffer2 = duplicate;
                ak akVar6 = akVar4;
                int i50 = i23;
                int i51 = i43;
                int[] a15 = cxVar.a(iArr7);
                int i52 = i48 << 2;
                int i53 = i49 << 2;
                cx cxVar2 = cxVar;
                ak akVar7 = akVar6;
                cxVar2.a(0, akVar7, 20, i52, i53, a15);
                int i54 = 20;
                cxVar2.a(0, akVar7, i52, i53, iArr7, 20);
                cxVar.a(a15, iArr7, 20);
                int[] iArr8 = a13.f13284d[0];
                int a16 = cxVar.a(i42, i51);
                int i55 = 0;
                while (i55 < iArr7.length) {
                    cxVar.a(iArr8, a16, iArr7[i55], 4, cw.f13172h[i55], cw.f13173i[i55]);
                    i55++;
                    i54 = i54;
                }
                int i56 = i54;
                bc bcVar2 = ekVar.f13281a;
                int i57 = bcVar2.f13059c[1];
                int i58 = bcVar2.f13060d[1];
                int i59 = i48 << (4 - i57);
                int i60 = i49 << (4 - i58);
                cx cxVar3 = cxVar;
                ek ekVar2 = ekVar;
                int i61 = i57;
                int i62 = i58;
                int i63 = i59;
                int[][] a17 = cxVar3.a(ekVar2, 1, i61, i62, i63, i60);
                int[][] a18 = cxVar3.a(ekVar2, 2, i61, i62, i63, i60);
                int[] a19 = cxVar.a(a17);
                int i64 = i48 << 1;
                int i65 = i49 << 1;
                ak akVar8 = akVar6;
                int i66 = i64;
                int[] a21 = cxVar.a(a18);
                int i67 = i65;
                cxVar3.a(1, akVar8, 20, i66, i67, a19);
                cxVar3.a(2, akVar8, 20, i66, i67, a21);
                int i68 = i64;
                int i69 = i65;
                cxVar3.a(1, akVar8, i68, i69, a17, 20);
                cxVar3.a(2, akVar8, i68, i69, a18, 20);
                cxVar.a(a19, a17, i56);
                cx cxVar4 = cxVar;
                int i70 = i59;
                int i71 = i60;
                cxVar4.a(a13.f13284d[1], 1, i70, i71, a17);
                cxVar.a(a21, a18, i56);
                cxVar4.a(a13.f13284d[2], 2, i70, i71, a18);
                ev evVar = cxVar.f13176a;
                ak akVar9 = akVar6;
                akVar9.f12993a.position();
                akVar5.f12993a.position();
                evVar.getClass();
                System.arraycopy(a13.f13284d[0], PsExtractor.VIDEO_STREAM_MASK, cxVar.f13179d[0], i42, 16);
                int i72 = i48 << 3;
                System.arraycopy(a13.f13284d[1], 56, cxVar.f13179d[1], i72, 8);
                System.arraycopy(a13.f13284d[2], 56, cxVar.f13179d[2], i72, 8);
                cxVar.a(a13.f13284d[0], 15, 16, cxVar.f13178c[0]);
                cxVar.a(a13.f13284d[1], 7, 8, cxVar.f13178c[1]);
                cxVar.a(a13.f13284d[2], 7, 8, cxVar.f13178c[2]);
                i39 = i48 + 1;
                int i73 = i11;
                akVar2 = akVar9;
                c11 = 16;
                i38 = i49;
                i23 = i50;
                duplicate = byteBuffer2;
                seqParameterSet = seqParameterSet4;
            }
            int i74 = i23;
            char c12 = c11;
            SeqParameterSet seqParameterSet5 = seqParameterSet;
            ByteBuffer byteBuffer3 = duplicate;
            i38++;
            int i75 = i11;
            akVar = akVar2;
        }
        int i76 = i23;
        akVar.b(1);
        akVar.a();
        ByteBuffer byteBuffer4 = akVar.f12993a;
        byteBuffer4.flip();
        ByteBuffer byteBuffer5 = duplicate;
        cy.a(byteBuffer4, byteBuffer5);
        byteBuffer5.flip();
        this.f13438d.clear();
        this.f13439e.clear();
        ArrayList arrayList = this.f13438d;
        ArrayList arrayList2 = this.f13439e;
        ByteBuffer duplicate2 = byteBuffer5.duplicate();
        while (duplicate2.hasRemaining() && (a11 = cy.a(duplicate2)) != null) {
            NALUnitType nALUnitType = NALUnit.read(a11).type;
            if (nALUnitType != NALUnitType.PPS) {
                if (nALUnitType != NALUnitType.SPS) {
                    if (nALUnitType == NALUnitType.IDR_SLICE || nALUnitType == NALUnitType.NON_IDR_SLICE) {
                        break;
                    }
                } else {
                    if (arrayList != null) {
                        arrayList.add(a11);
                    }
                    byteBuffer5.position(duplicate2.position());
                }
            } else {
                if (arrayList2 != null) {
                    arrayList2.add(a11);
                }
                byteBuffer5.position(duplicate2.position());
            }
        }
        ByteBuffer duplicate3 = byteBuffer5.duplicate();
        ByteBuffer duplicate4 = byteBuffer5.duplicate();
        int position = duplicate4.position();
        while (true) {
            ByteBuffer a22 = cy.a(duplicate3);
            if (a22 == null) {
                int i77 = i11;
                long j11 = (long) (i77 * i76);
                this.f13440f.a(new dt(byteBuffer5, j11, 1, (long) i76, (long) i77, true, j11, 0));
                return;
            }
            int i78 = i11;
            int i79 = i76;
            duplicate4.position(position);
            duplicate4.putInt(a22.remaining());
            position += a22.remaining() + 4;
        }
    }

    public void a() {
        ab abVar;
        boolean z11;
        ch chVar = this.f13440f;
        ArrayList arrayList = this.f13438d;
        ArrayList arrayList2 = this.f13439e;
        ByteBuffer byteBuffer = (ByteBuffer) arrayList.get(0);
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.flip();
        ByteBuffer allocate2 = ByteBuffer.allocate(allocate.remaining());
        allocate2.put(allocate.duplicate());
        allocate2.flip();
        if (allocate2.remaining() >= 2) {
            ByteBuffer duplicate = allocate2.duplicate();
            ByteBuffer duplicate2 = allocate2.duplicate();
            byte b11 = duplicate.get();
            duplicate2.put(b11);
            byte b12 = duplicate.get();
            duplicate2.put(b12);
            while (duplicate.hasRemaining()) {
                byte b13 = duplicate.get();
                if (b11 != 0 || b12 != 0 || b13 != 3) {
                    duplicate2.put(b13);
                }
                b11 = b12;
                b12 = b13;
            }
            allocate2.limit(duplicate2.position());
        }
        SeqParameterSet read = SeqParameterSet.read(allocate2);
        int i11 = read.profile_idc;
        int i12 = read.level_idc;
        ah ahVar = new ah();
        ahVar.f12983b = i11;
        ahVar.f12984c = 0;
        ahVar.f12985d = i12;
        ahVar.f12986e = arrayList;
        ahVar.f12987f = arrayList2;
        int i13 = (read.pic_width_in_mbs_minus1 + 1) << 4;
        int i14 = ((read.pic_height_in_map_units_minus1 + 1) << (read.frame_mbs_only_flag ^ true ? 1 : 0)) << 4;
        boolean z12 = read.frame_cropping_flag;
        if (z12) {
            i13 -= (read.frame_crop_right_offset + read.frame_crop_left_offset) << read.chroma_format_idc.f13059c[1];
        }
        if (z12) {
            i14 -= (read.frame_crop_bottom_offset + read.frame_crop_top_offset) << read.chroma_format_idc.f13060d[1];
        }
        da daVar = r10;
        da daVar2 = new da("avc1");
        in inVar = new in(daVar, 0, 0, "jcod", 0, ValidationPath.MAX_PATH_LENGTH_BYTES, (short) i13, (short) i14, 72, 72, 1, "JCodec", 24, 1, -1);
        inVar.f13252b.add(ahVar);
        if (!chVar.f12970k) {
            chVar.f12971l.add(inVar);
            ds dsVar = this.f13442h;
            dsVar.getClass();
            dz dzVar = new dz();
            int i15 = ((ab) dsVar.f13229a.get(0)).f12962c;
            long b14 = ((ab) dsVar.f13229a.get(0)).b();
            Iterator it = dsVar.f13229a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    abVar = null;
                    break;
                }
                abVar = (ab) it.next();
                if (abVar.f12961b == 1) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            if (abVar != null) {
                i15 = abVar.f12962c;
                b14 = abVar.b();
            }
            ea eaVar = new ea(i15, b14, 1.0f, 1.0f, new Date().getTime(), new Date().getTime(), new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824}, dsVar.f13232d);
            dzVar.f13252b.add(0, eaVar);
            for (ab a11 : dsVar.f13229a) {
                am a12 = a11.a(eaVar);
                if (a12 != null) {
                    dzVar.f13252b.add(a12);
                }
            }
            gb gbVar = dsVar.f13231c;
            int i16 = du.f13236a;
            ByteBuffer allocate3 = ByteBuffer.allocate(4194304);
            dzVar.b(allocate3);
            allocate3.flip();
            ((bx) gbVar).f13097a.write(allocate3);
            ((bx) dsVar.f13231c).f13097a.position(dsVar.f13230b);
            ((bx) dsVar.f13231c).f13097a.write((ByteBuffer) ByteBuffer.allocate(8).putLong((((bx) dsVar.f13231c).f13097a.position() - dsVar.f13230b) + 8).flip());
            gb gbVar2 = this.f13435a;
            if (gbVar2 != null) {
                try {
                    ((bx) gbVar2).f13097a.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
    }
}
