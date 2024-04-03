package com.uxcam.video.screen.codec.codecs.h264.io.model;

import com.uxcam.internals.aj;
import com.uxcam.internals.ak;
import com.uxcam.internals.aq;
import com.uxcam.internals.ar;
import com.uxcam.internals.bc;
import com.uxcam.internals.dv;
import com.uxcam.video.screen.codec.codecs.h264.io.model.VUIParameters;
import java.nio.ByteBuffer;

public class SeqParameterSet {
    public int bit_depth_chroma_minus8;
    public int bit_depth_luma_minus8;
    public bc chroma_format_idc;
    public boolean constraint_set_0_flag;
    public boolean constraint_set_1_flag;
    public boolean constraint_set_2_flag;
    public boolean constraint_set_3_flag;
    public boolean delta_pic_order_always_zero_flag;
    public boolean direct_8x8_inference_flag;
    public boolean field_pic_flag;
    public int frame_crop_bottom_offset;
    public int frame_crop_left_offset;
    public int frame_crop_right_offset;
    public int frame_crop_top_offset;
    public boolean frame_cropping_flag;
    public boolean frame_mbs_only_flag;
    public boolean gaps_in_frame_num_value_allowed_flag;
    public int level_idc;
    public int log2_max_frame_num_minus4;
    public int log2_max_pic_order_cnt_lsb_minus4;
    public boolean mb_adaptive_frame_field_flag;
    public int num_ref_frames;
    public int num_ref_frames_in_pic_order_cnt_cycle;
    public int[] offsetForRefFrame;
    public int offset_for_non_ref_pic;
    public int offset_for_top_to_bottom_field;
    public int pic_height_in_map_units_minus1;
    public int pic_order_cnt_type;
    public int pic_width_in_mbs_minus1;
    public int profile_idc;
    public boolean qpprime_y_zero_transform_bypass_flag;
    public boolean residual_color_transform_flag;
    public ScalingMatrix scalingMatrix;
    public int seq_parameter_set_id;
    public VUIParameters vuiParams;

    /* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0013 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
        static {
            /*
                com.uxcam.internals.bc[] r0 = com.uxcam.internals.bc.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace = r0
                r1 = 1
                r2 = 9
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace     // Catch:{ NoSuchFieldError -> 0x0013 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0013 }
            L_0x0013:
                int[] r0 = $SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace     // Catch:{ NoSuchFieldError -> 0x0018 }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r0 = $SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace     // Catch:{ NoSuchFieldError -> 0x001e }
                r1 = 4
                r2 = 5
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet.AnonymousClass1.<clinit>():void");
        }
    }

    public static int fromColor(bc bcVar) {
        int i11 = AnonymousClass1.$SwitchMap$com$uxcam$video$screen$codec$common$model$ColorSpace[bcVar.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 3) {
            return 2;
        }
        if (i11 == 4) {
            return 3;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    public static bc getColor(int i11) {
        if (i11 == 0) {
            return bc.MONO;
        }
        if (i11 == 1) {
            return bc.YUV420;
        }
        if (i11 == 2) {
            return bc.YUV422;
        }
        if (i11 == 3) {
            return bc.YUV444;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    public static SeqParameterSet read(ByteBuffer byteBuffer) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        aj ajVar = new aj(byteBuffer);
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.profile_idc = ajVar.b(8);
        boolean z25 = false;
        if (ajVar.a() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        seqParameterSet.constraint_set_0_flag = z11;
        if (ajVar.a() != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        seqParameterSet.constraint_set_1_flag = z12;
        if (ajVar.a() != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        seqParameterSet.constraint_set_2_flag = z13;
        if (ajVar.a() != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        seqParameterSet.constraint_set_3_flag = z14;
        ajVar.b(4);
        seqParameterSet.level_idc = ajVar.b(8);
        seqParameterSet.seq_parameter_set_id = aq.b(ajVar);
        int i11 = seqParameterSet.profile_idc;
        if (i11 == 100 || i11 == 110 || i11 == 122 || i11 == 144) {
            bc color = getColor(aq.b(ajVar));
            seqParameterSet.chroma_format_idc = color;
            if (color == bc.YUV444) {
                if (ajVar.a() != 0) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                seqParameterSet.residual_color_transform_flag = z24;
            }
            seqParameterSet.bit_depth_luma_minus8 = aq.b(ajVar);
            seqParameterSet.bit_depth_chroma_minus8 = aq.b(ajVar);
            if (ajVar.a() != 0) {
                z22 = true;
            } else {
                z22 = false;
            }
            seqParameterSet.qpprime_y_zero_transform_bypass_flag = z22;
            if (ajVar.a() != 0) {
                z23 = true;
            } else {
                z23 = false;
            }
            if (z23) {
                readScalingListMatrix(ajVar, seqParameterSet);
            }
        } else {
            seqParameterSet.chroma_format_idc = bc.YUV420;
        }
        seqParameterSet.log2_max_frame_num_minus4 = aq.b(ajVar);
        int b11 = aq.b(ajVar);
        seqParameterSet.pic_order_cnt_type = b11;
        if (b11 == 0) {
            seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 = aq.b(ajVar);
        } else if (b11 == 1) {
            if (ajVar.a() != 0) {
                z21 = true;
            } else {
                z21 = false;
            }
            seqParameterSet.delta_pic_order_always_zero_flag = z21;
            seqParameterSet.offset_for_non_ref_pic = aq.a(ajVar);
            seqParameterSet.offset_for_top_to_bottom_field = aq.a(ajVar);
            int b12 = aq.b(ajVar);
            seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle = b12;
            seqParameterSet.offsetForRefFrame = new int[b12];
            for (int i12 = 0; i12 < seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle; i12++) {
                seqParameterSet.offsetForRefFrame[i12] = aq.a(ajVar);
            }
        }
        seqParameterSet.num_ref_frames = aq.b(ajVar);
        if (ajVar.a() != 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        seqParameterSet.gaps_in_frame_num_value_allowed_flag = z15;
        seqParameterSet.pic_width_in_mbs_minus1 = aq.b(ajVar);
        seqParameterSet.pic_height_in_map_units_minus1 = aq.b(ajVar);
        if (ajVar.a() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        seqParameterSet.frame_mbs_only_flag = z16;
        if (!z16) {
            if (ajVar.a() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            seqParameterSet.mb_adaptive_frame_field_flag = z19;
        }
        if (ajVar.a() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        seqParameterSet.direct_8x8_inference_flag = z17;
        if (ajVar.a() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        seqParameterSet.frame_cropping_flag = z18;
        if (z18) {
            seqParameterSet.frame_crop_left_offset = aq.b(ajVar);
            seqParameterSet.frame_crop_right_offset = aq.b(ajVar);
            seqParameterSet.frame_crop_top_offset = aq.b(ajVar);
            seqParameterSet.frame_crop_bottom_offset = aq.b(ajVar);
        }
        if (ajVar.a() != 0) {
            z25 = true;
        }
        if (z25) {
            seqParameterSet.vuiParams = readVUIParameters(ajVar);
        }
        return seqParameterSet;
    }

    private static HRDParameters readHRDParameters(aj ajVar) {
        boolean z11;
        HRDParameters hRDParameters = new HRDParameters();
        hRDParameters.cpb_cnt_minus1 = aq.b(ajVar);
        hRDParameters.bit_rate_scale = ajVar.b(4);
        hRDParameters.cpb_size_scale = ajVar.b(4);
        int i11 = hRDParameters.cpb_cnt_minus1 + 1;
        hRDParameters.bit_rate_value_minus1 = new int[i11];
        hRDParameters.cpb_size_value_minus1 = new int[i11];
        hRDParameters.cbr_flag = new boolean[i11];
        for (int i12 = 0; i12 <= hRDParameters.cpb_cnt_minus1; i12++) {
            hRDParameters.bit_rate_value_minus1[i12] = aq.b(ajVar);
            hRDParameters.cpb_size_value_minus1[i12] = aq.b(ajVar);
            boolean[] zArr = hRDParameters.cbr_flag;
            if (ajVar.a() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zArr[i12] = z11;
        }
        hRDParameters.initial_cpb_removal_delay_length_minus1 = ajVar.b(5);
        hRDParameters.cpb_removal_delay_length_minus1 = ajVar.b(5);
        hRDParameters.dpb_output_delay_length_minus1 = ajVar.b(5);
        hRDParameters.time_offset_length = ajVar.b(5);
        return hRDParameters;
    }

    private static void readScalingListMatrix(aj ajVar, SeqParameterSet seqParameterSet) {
        boolean z11;
        seqParameterSet.scalingMatrix = new ScalingMatrix();
        for (int i11 = 0; i11 < 8; i11++) {
            if (ajVar.a() != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                ScalingMatrix scalingMatrix2 = seqParameterSet.scalingMatrix;
                ScalingList[] scalingListArr = new ScalingList[8];
                scalingMatrix2.ScalingList4x4 = scalingListArr;
                ScalingList[] scalingListArr2 = new ScalingList[8];
                scalingMatrix2.ScalingList8x8 = scalingListArr2;
                if (i11 < 6) {
                    scalingListArr[i11] = ScalingList.read(ajVar, 16);
                } else {
                    scalingListArr2[i11 - 6] = ScalingList.read(ajVar, 64);
                }
            }
        }
    }

    private static VUIParameters readVUIParameters(aj ajVar) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        VUIParameters vUIParameters = new VUIParameters();
        boolean z26 = true;
        if (ajVar.a() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        vUIParameters.aspect_ratio_info_present_flag = z11;
        if (z11) {
            AspectRatio fromValue = AspectRatio.fromValue(ajVar.b(8));
            vUIParameters.aspect_ratio = fromValue;
            if (fromValue == AspectRatio.Extended_SAR) {
                vUIParameters.sar_width = ajVar.b(16);
                vUIParameters.sar_height = ajVar.b(16);
            }
        }
        if (ajVar.a() != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        vUIParameters.overscan_info_present_flag = z12;
        if (z12) {
            if (ajVar.a() != 0) {
                z25 = true;
            } else {
                z25 = false;
            }
            vUIParameters.overscan_appropriate_flag = z25;
        }
        if (ajVar.a() != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        vUIParameters.video_signal_type_present_flag = z13;
        if (z13) {
            vUIParameters.video_format = ajVar.b(3);
            if (ajVar.a() != 0) {
                z23 = true;
            } else {
                z23 = false;
            }
            vUIParameters.video_full_range_flag = z23;
            if (ajVar.a() != 0) {
                z24 = true;
            } else {
                z24 = false;
            }
            vUIParameters.colour_description_present_flag = z24;
            if (z24) {
                vUIParameters.colour_primaries = ajVar.b(8);
                vUIParameters.transfer_characteristics = ajVar.b(8);
                vUIParameters.matrix_coefficients = ajVar.b(8);
            }
        }
        if (ajVar.a() != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        vUIParameters.chroma_loc_info_present_flag = z14;
        if (z14) {
            vUIParameters.chroma_sample_loc_type_top_field = aq.b(ajVar);
            vUIParameters.chroma_sample_loc_type_bottom_field = aq.b(ajVar);
        }
        if (ajVar.a() != 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        vUIParameters.timing_info_present_flag = z15;
        if (z15) {
            vUIParameters.num_units_in_tick = ajVar.b(32);
            vUIParameters.time_scale = ajVar.b(32);
            if (ajVar.a() != 0) {
                z22 = true;
            } else {
                z22 = false;
            }
            vUIParameters.fixed_frame_rate_flag = z22;
        }
        if (ajVar.a() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            vUIParameters.nalHRDParams = readHRDParameters(ajVar);
        }
        if (ajVar.a() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            vUIParameters.vclHRDParams = readHRDParameters(ajVar);
        }
        if (z16 || z17) {
            if (ajVar.a() != 0) {
                z21 = true;
            } else {
                z21 = false;
            }
            vUIParameters.low_delay_hrd_flag = z21;
        }
        if (ajVar.a() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        vUIParameters.pic_struct_present_flag = z18;
        if (ajVar.a() != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            VUIParameters.BitstreamRestriction bitstreamRestriction = new VUIParameters.BitstreamRestriction();
            vUIParameters.bitstreamRestriction = bitstreamRestriction;
            if (ajVar.a() == 0) {
                z26 = false;
            }
            bitstreamRestriction.motion_vectors_over_pic_boundaries_flag = z26;
            vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom = aq.b(ajVar);
            vUIParameters.bitstreamRestriction.max_bits_per_mb_denom = aq.b(ajVar);
            vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal = aq.b(ajVar);
            vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical = aq.b(ajVar);
            vUIParameters.bitstreamRestriction.num_reorder_frames = aq.b(ajVar);
            vUIParameters.bitstreamRestriction.max_dec_frame_buffering = aq.b(ajVar);
        }
        return vUIParameters;
    }

    private void writeHRDParameters(HRDParameters hRDParameters, ak akVar) {
        ar.a(akVar, hRDParameters.cpb_cnt_minus1);
        ar.a(akVar, (long) hRDParameters.bit_rate_scale, 4);
        ar.a(akVar, (long) hRDParameters.cpb_size_scale, 4);
        for (int i11 = 0; i11 <= hRDParameters.cpb_cnt_minus1; i11++) {
            ar.a(akVar, hRDParameters.bit_rate_value_minus1[i11]);
            ar.a(akVar, hRDParameters.cpb_size_value_minus1[i11]);
            akVar.b(hRDParameters.cbr_flag[i11] ? 1 : 0);
        }
        ar.a(akVar, (long) hRDParameters.initial_cpb_removal_delay_length_minus1, 5);
        ar.a(akVar, (long) hRDParameters.cpb_removal_delay_length_minus1, 5);
        ar.a(akVar, (long) hRDParameters.dpb_output_delay_length_minus1, 5);
        ar.a(akVar, (long) hRDParameters.time_offset_length, 5);
    }

    private void writeVUIParameters(VUIParameters vUIParameters, ak akVar) {
        int i11;
        int i12;
        akVar.b(vUIParameters.aspect_ratio_info_present_flag ? 1 : 0);
        if (vUIParameters.aspect_ratio_info_present_flag) {
            ar.a(akVar, (long) vUIParameters.aspect_ratio.getValue(), 8);
            if (vUIParameters.aspect_ratio == AspectRatio.Extended_SAR) {
                ar.a(akVar, (long) vUIParameters.sar_width, 16);
                ar.a(akVar, (long) vUIParameters.sar_height, 16);
            }
        }
        akVar.b(vUIParameters.overscan_info_present_flag ? 1 : 0);
        if (vUIParameters.overscan_info_present_flag) {
            akVar.b(vUIParameters.overscan_appropriate_flag ? 1 : 0);
        }
        akVar.b(vUIParameters.video_signal_type_present_flag ? 1 : 0);
        if (vUIParameters.video_signal_type_present_flag) {
            ar.a(akVar, (long) vUIParameters.video_format, 3);
            akVar.b(vUIParameters.video_full_range_flag ? 1 : 0);
            akVar.b(vUIParameters.colour_description_present_flag ? 1 : 0);
            if (vUIParameters.colour_description_present_flag) {
                ar.a(akVar, (long) vUIParameters.colour_primaries, 8);
                ar.a(akVar, (long) vUIParameters.transfer_characteristics, 8);
                ar.a(akVar, (long) vUIParameters.matrix_coefficients, 8);
            }
        }
        akVar.b(vUIParameters.chroma_loc_info_present_flag ? 1 : 0);
        if (vUIParameters.chroma_loc_info_present_flag) {
            ar.a(akVar, vUIParameters.chroma_sample_loc_type_top_field);
            ar.a(akVar, vUIParameters.chroma_sample_loc_type_bottom_field);
        }
        akVar.b(vUIParameters.timing_info_present_flag ? 1 : 0);
        if (vUIParameters.timing_info_present_flag) {
            ar.a(akVar, (long) vUIParameters.num_units_in_tick, 32);
            ar.a(akVar, (long) vUIParameters.time_scale, 32);
            akVar.b(vUIParameters.fixed_frame_rate_flag ? 1 : 0);
        }
        int i13 = 1;
        if (vUIParameters.nalHRDParams != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        akVar.b(i11);
        HRDParameters hRDParameters = vUIParameters.nalHRDParams;
        if (hRDParameters != null) {
            writeHRDParameters(hRDParameters, akVar);
        }
        if (vUIParameters.vclHRDParams != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        akVar.b(i12);
        HRDParameters hRDParameters2 = vUIParameters.vclHRDParams;
        if (hRDParameters2 != null) {
            writeHRDParameters(hRDParameters2, akVar);
        }
        if (!(vUIParameters.nalHRDParams == null && vUIParameters.vclHRDParams == null)) {
            akVar.b(vUIParameters.low_delay_hrd_flag ? 1 : 0);
        }
        akVar.b(vUIParameters.pic_struct_present_flag ? 1 : 0);
        if (vUIParameters.bitstreamRestriction == null) {
            i13 = 0;
        }
        akVar.b(i13);
        VUIParameters.BitstreamRestriction bitstreamRestriction = vUIParameters.bitstreamRestriction;
        if (bitstreamRestriction != null) {
            akVar.b(bitstreamRestriction.motion_vectors_over_pic_boundaries_flag ? 1 : 0);
            ar.a(akVar, vUIParameters.bitstreamRestriction.max_bytes_per_pic_denom);
            ar.a(akVar, vUIParameters.bitstreamRestriction.max_bits_per_mb_denom);
            ar.a(akVar, vUIParameters.bitstreamRestriction.log2_max_mv_length_horizontal);
            ar.a(akVar, vUIParameters.bitstreamRestriction.log2_max_mv_length_vertical);
            ar.a(akVar, vUIParameters.bitstreamRestriction.num_reorder_frames);
            ar.a(akVar, vUIParameters.bitstreamRestriction.max_dec_frame_buffering);
        }
    }

    public SeqParameterSet copy() {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        write(allocate);
        allocate.flip();
        return read(allocate);
    }

    public void write(ByteBuffer byteBuffer) {
        int i11;
        int i12;
        int i13;
        ak akVar = new ak(byteBuffer);
        ar.a(akVar, (long) this.profile_idc, 8);
        akVar.b(this.constraint_set_0_flag ? 1 : 0);
        akVar.b(this.constraint_set_1_flag ? 1 : 0);
        akVar.b(this.constraint_set_2_flag ? 1 : 0);
        akVar.b(this.constraint_set_3_flag ? 1 : 0);
        ar.a(akVar, 0, 4);
        ar.a(akVar, (long) this.level_idc, 8);
        ar.a(akVar, this.seq_parameter_set_id);
        int i14 = this.profile_idc;
        int i15 = 0;
        if (i14 == 100 || i14 == 110 || i14 == 122 || i14 == 144) {
            ar.a(akVar, fromColor(this.chroma_format_idc));
            if (this.chroma_format_idc == bc.YUV444) {
                akVar.b(this.residual_color_transform_flag ? 1 : 0);
            }
            ar.a(akVar, this.bit_depth_luma_minus8);
            ar.a(akVar, this.bit_depth_chroma_minus8);
            akVar.b(this.qpprime_y_zero_transform_bypass_flag ? 1 : 0);
            if (this.scalingMatrix != null) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            akVar.b(i11);
            if (this.scalingMatrix != null) {
                for (int i16 = 0; i16 < 8; i16++) {
                    if (i16 < 6) {
                        if (this.scalingMatrix.ScalingList4x4[i16] != null) {
                            i13 = 1;
                        } else {
                            i13 = 0;
                        }
                        akVar.b(i13);
                        ScalingList scalingList = this.scalingMatrix.ScalingList4x4[i16];
                        if (scalingList != null) {
                            scalingList.write(akVar);
                        }
                    } else {
                        int i17 = i16 - 6;
                        if (this.scalingMatrix.ScalingList8x8[i17] != null) {
                            i12 = 1;
                        } else {
                            i12 = 0;
                        }
                        akVar.b(i12);
                        ScalingList scalingList2 = this.scalingMatrix.ScalingList8x8[i17];
                        if (scalingList2 != null) {
                            scalingList2.write(akVar);
                        }
                    }
                }
            }
        }
        ar.a(akVar, this.log2_max_frame_num_minus4);
        ar.a(akVar, this.pic_order_cnt_type);
        int i18 = this.pic_order_cnt_type;
        if (i18 == 0) {
            ar.a(akVar, this.log2_max_pic_order_cnt_lsb_minus4);
        } else if (i18 == 1) {
            akVar.b(this.delta_pic_order_always_zero_flag ? 1 : 0);
            ar.a(akVar, dv.a(this.offset_for_non_ref_pic));
            ar.a(akVar, dv.a(this.offset_for_top_to_bottom_field));
            ar.a(akVar, this.offsetForRefFrame.length);
            int i19 = 0;
            while (true) {
                int[] iArr = this.offsetForRefFrame;
                if (i19 >= iArr.length) {
                    break;
                }
                ar.a(akVar, dv.a(iArr[i19]));
                i19++;
            }
        }
        ar.a(akVar, this.num_ref_frames);
        akVar.b(this.gaps_in_frame_num_value_allowed_flag ? 1 : 0);
        ar.a(akVar, this.pic_width_in_mbs_minus1);
        ar.a(akVar, this.pic_height_in_map_units_minus1);
        akVar.b(this.frame_mbs_only_flag ? 1 : 0);
        if (!this.frame_mbs_only_flag) {
            akVar.b(this.mb_adaptive_frame_field_flag ? 1 : 0);
        }
        akVar.b(this.direct_8x8_inference_flag ? 1 : 0);
        akVar.b(this.frame_cropping_flag ? 1 : 0);
        if (this.frame_cropping_flag) {
            ar.a(akVar, this.frame_crop_left_offset);
            ar.a(akVar, this.frame_crop_right_offset);
            ar.a(akVar, this.frame_crop_top_offset);
            ar.a(akVar, this.frame_crop_bottom_offset);
        }
        if (this.vuiParams != null) {
            i15 = 1;
        }
        akVar.b(i15);
        VUIParameters vUIParameters = this.vuiParams;
        if (vUIParameters != null) {
            writeVUIParameters(vUIParameters, akVar);
        }
        akVar.b(1);
        akVar.a();
    }
}
