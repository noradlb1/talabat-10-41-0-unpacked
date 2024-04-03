package com.uxcam.video.screen.codec.codecs.h264.io.model;

import com.uxcam.internals.aj;
import com.uxcam.internals.ak;
import com.uxcam.internals.aq;
import com.uxcam.internals.ar;
import com.uxcam.internals.dv;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class PictureParameterSet {
    public int[] bottom_right;
    public int chroma_qp_index_offset;
    public boolean constrained_intra_pred_flag;
    public boolean deblocking_filter_control_present_flag;
    public boolean entropy_coding_mode_flag;
    public PPSExt extended;
    public int[] num_ref_idx_active_minus1 = new int[2];
    public int num_slice_groups_minus1;
    public int pic_init_qp_minus26;
    public int pic_init_qs_minus26;
    public boolean pic_order_present_flag;
    public int pic_parameter_set_id;
    public boolean redundant_pic_cnt_present_flag;
    public int[] run_length_minus1;
    public int seq_parameter_set_id;
    public boolean slice_group_change_direction_flag;
    public int slice_group_change_rate_minus1;
    public int[] slice_group_id;
    public int slice_group_map_type;
    public int[] top_left;
    public int weighted_bipred_idc;
    public boolean weighted_pred_flag;

    public static class PPSExt {
        public boolean[] pic_scaling_list_present_flag;
        public ScalingMatrix scalindMatrix;
        public int second_chroma_qp_index_offset;
        public boolean transform_8x8_mode_flag;
    }

    public static PictureParameterSet read(ByteBuffer byteBuffer) {
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
        int i11;
        aj ajVar = new aj(byteBuffer);
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.pic_parameter_set_id = aq.b(ajVar);
        pictureParameterSet.seq_parameter_set_id = aq.b(ajVar);
        if (ajVar.a() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        pictureParameterSet.entropy_coding_mode_flag = z11;
        if (ajVar.a() != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        pictureParameterSet.pic_order_present_flag = z12;
        int b11 = aq.b(ajVar);
        pictureParameterSet.num_slice_groups_minus1 = b11;
        if (b11 > 0) {
            int b12 = aq.b(ajVar);
            pictureParameterSet.slice_group_map_type = b12;
            int i12 = pictureParameterSet.num_slice_groups_minus1 + 1;
            pictureParameterSet.top_left = new int[i12];
            pictureParameterSet.bottom_right = new int[i12];
            pictureParameterSet.run_length_minus1 = new int[i12];
            if (b12 == 0) {
                for (int i13 = 0; i13 <= pictureParameterSet.num_slice_groups_minus1; i13++) {
                    pictureParameterSet.run_length_minus1[i13] = aq.b(ajVar);
                }
            } else if (b12 == 2) {
                for (int i14 = 0; i14 < pictureParameterSet.num_slice_groups_minus1; i14++) {
                    pictureParameterSet.top_left[i14] = aq.b(ajVar);
                    pictureParameterSet.bottom_right[i14] = aq.b(ajVar);
                }
            } else if (b12 == 3 || b12 == 4 || b12 == 5) {
                if (ajVar.a() != 0) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                pictureParameterSet.slice_group_change_direction_flag = z22;
                pictureParameterSet.slice_group_change_rate_minus1 = aq.b(ajVar);
            } else if (b12 == 6) {
                if (i12 > 4) {
                    i11 = 3;
                } else if (i12 > 2) {
                    i11 = 2;
                } else {
                    i11 = 1;
                }
                int b13 = aq.b(ajVar);
                pictureParameterSet.slice_group_id = new int[(b13 + 1)];
                for (int i15 = 0; i15 <= b13; i15++) {
                    pictureParameterSet.slice_group_id[i15] = ajVar.b(i11);
                }
            }
        }
        pictureParameterSet.num_ref_idx_active_minus1 = new int[]{aq.b(ajVar), aq.b(ajVar)};
        if (ajVar.a() != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        pictureParameterSet.weighted_pred_flag = z13;
        pictureParameterSet.weighted_bipred_idc = ajVar.b(2);
        pictureParameterSet.pic_init_qp_minus26 = aq.a(ajVar);
        pictureParameterSet.pic_init_qs_minus26 = aq.a(ajVar);
        pictureParameterSet.chroma_qp_index_offset = aq.a(ajVar);
        if (ajVar.a() != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        pictureParameterSet.deblocking_filter_control_present_flag = z14;
        if (ajVar.a() != 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        pictureParameterSet.constrained_intra_pred_flag = z15;
        if (ajVar.a() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        pictureParameterSet.redundant_pic_cnt_present_flag = z16;
        if (((ajVar.f12990a.remaining() << 3) + 32) - ajVar.f12991b < 32 && ajVar.a(1) == 1 && (ajVar.a(24) << 9) == 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            PPSExt pPSExt = new PPSExt();
            pictureParameterSet.extended = pPSExt;
            if (ajVar.a() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            pPSExt.transform_8x8_mode_flag = z18;
            if (ajVar.a() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                for (int i16 = 0; i16 < ((pictureParameterSet.extended.transform_8x8_mode_flag ? 1 : 0) * true) + 6; i16++) {
                    if (ajVar.a() != 0) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    if (z21) {
                        ScalingMatrix scalingMatrix = pictureParameterSet.extended.scalindMatrix;
                        ScalingList[] scalingListArr = new ScalingList[8];
                        scalingMatrix.ScalingList4x4 = scalingListArr;
                        ScalingList[] scalingListArr2 = new ScalingList[8];
                        scalingMatrix.ScalingList8x8 = scalingListArr2;
                        if (i16 < 6) {
                            scalingListArr[i16] = ScalingList.read(ajVar, 16);
                        } else {
                            scalingListArr2[i16 - 6] = ScalingList.read(ajVar, 64);
                        }
                    }
                }
            }
            pictureParameterSet.extended.second_chroma_qp_index_offset = aq.a(ajVar);
        }
        return pictureParameterSet;
    }

    public PictureParameterSet copy() {
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        write(allocate);
        allocate.flip();
        return read(allocate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
        if (!Arrays.equals(this.bottom_right, pictureParameterSet.bottom_right) || this.chroma_qp_index_offset != pictureParameterSet.chroma_qp_index_offset || this.constrained_intra_pred_flag != pictureParameterSet.constrained_intra_pred_flag || this.deblocking_filter_control_present_flag != pictureParameterSet.deblocking_filter_control_present_flag || this.entropy_coding_mode_flag != pictureParameterSet.entropy_coding_mode_flag) {
            return false;
        }
        PPSExt pPSExt = this.extended;
        if (pPSExt == null) {
            if (pictureParameterSet.extended != null) {
                return false;
            }
        } else if (!pPSExt.equals(pictureParameterSet.extended)) {
            return false;
        }
        int[] iArr = this.num_ref_idx_active_minus1;
        int i11 = iArr[0];
        int[] iArr2 = pictureParameterSet.num_ref_idx_active_minus1;
        if (i11 != iArr2[0] || iArr[1] != iArr2[1] || this.num_slice_groups_minus1 != pictureParameterSet.num_slice_groups_minus1 || this.pic_init_qp_minus26 != pictureParameterSet.pic_init_qp_minus26 || this.pic_init_qs_minus26 != pictureParameterSet.pic_init_qs_minus26 || this.pic_order_present_flag != pictureParameterSet.pic_order_present_flag || this.pic_parameter_set_id != pictureParameterSet.pic_parameter_set_id || this.redundant_pic_cnt_present_flag != pictureParameterSet.redundant_pic_cnt_present_flag || !Arrays.equals(this.run_length_minus1, pictureParameterSet.run_length_minus1) || this.seq_parameter_set_id != pictureParameterSet.seq_parameter_set_id || this.slice_group_change_direction_flag != pictureParameterSet.slice_group_change_direction_flag || this.slice_group_change_rate_minus1 != pictureParameterSet.slice_group_change_rate_minus1 || !Arrays.equals(this.slice_group_id, pictureParameterSet.slice_group_id) || this.slice_group_map_type != pictureParameterSet.slice_group_map_type || !Arrays.equals(this.top_left, pictureParameterSet.top_left) || this.weighted_bipred_idc != pictureParameterSet.weighted_bipred_idc) {
            return false;
        }
        if (this.weighted_pred_flag == pictureParameterSet.weighted_pred_flag) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int hashCode = (((Arrays.hashCode(this.bottom_right) + 31) * 31) + this.chroma_qp_index_offset) * 31;
        int i18 = 1231;
        if (this.constrained_intra_pred_flag) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        int i19 = (hashCode + i11) * 31;
        if (this.deblocking_filter_control_present_flag) {
            i12 = 1231;
        } else {
            i12 = 1237;
        }
        int i21 = (i19 + i12) * 31;
        if (this.entropy_coding_mode_flag) {
            i13 = 1231;
        } else {
            i13 = 1237;
        }
        int i22 = (i21 + i13) * 31;
        PPSExt pPSExt = this.extended;
        if (pPSExt == null) {
            i14 = 0;
        } else {
            i14 = pPSExt.hashCode();
        }
        int[] iArr = this.num_ref_idx_active_minus1;
        int i23 = (((((((((((i22 + i14) * 31) + iArr[0]) * 31) + iArr[1]) * 31) + this.num_slice_groups_minus1) * 31) + this.pic_init_qp_minus26) * 31) + this.pic_init_qs_minus26) * 31;
        if (this.pic_order_present_flag) {
            i15 = 1231;
        } else {
            i15 = 1237;
        }
        int i24 = (((i23 + i15) * 31) + this.pic_parameter_set_id) * 31;
        if (this.redundant_pic_cnt_present_flag) {
            i16 = 1231;
        } else {
            i16 = 1237;
        }
        int hashCode2 = (((((i24 + i16) * 31) + Arrays.hashCode(this.run_length_minus1)) * 31) + this.seq_parameter_set_id) * 31;
        if (this.slice_group_change_direction_flag) {
            i17 = 1231;
        } else {
            i17 = 1237;
        }
        int hashCode3 = (((((((((((hashCode2 + i17) * 31) + this.slice_group_change_rate_minus1) * 31) + Arrays.hashCode(this.slice_group_id)) * 31) + this.slice_group_map_type) * 31) + Arrays.hashCode(this.top_left)) * 31) + this.weighted_bipred_idc) * 31;
        if (!this.weighted_pred_flag) {
            i18 = 1237;
        }
        return hashCode3 + i18;
    }

    public void write(ByteBuffer byteBuffer) {
        int i11;
        int i12;
        int i13;
        ak akVar = new ak(byteBuffer);
        ar.a(akVar, this.pic_parameter_set_id);
        ar.a(akVar, this.seq_parameter_set_id);
        akVar.b(this.entropy_coding_mode_flag ? 1 : 0);
        akVar.b(this.pic_order_present_flag ? 1 : 0);
        ar.a(akVar, this.num_slice_groups_minus1);
        if (this.num_slice_groups_minus1 > 0) {
            ar.a(akVar, this.slice_group_map_type);
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            int i14 = this.slice_group_map_type;
            if (i14 == 0) {
                for (int i15 = 0; i15 <= this.num_slice_groups_minus1; i15++) {
                    ar.a(akVar, iArr3[i15]);
                }
            } else if (i14 == 2) {
                for (int i16 = 0; i16 < this.num_slice_groups_minus1; i16++) {
                    ar.a(akVar, iArr[i16]);
                    ar.a(akVar, iArr2[i16]);
                }
            } else {
                int i17 = 3;
                if (i14 == 3 || i14 == 4 || i14 == 5) {
                    akVar.b(this.slice_group_change_direction_flag ? 1 : 0);
                    ar.a(akVar, this.slice_group_change_rate_minus1);
                } else if (i14 == 6) {
                    int i18 = this.num_slice_groups_minus1 + 1;
                    if (i18 <= 4) {
                        if (i18 > 2) {
                            i17 = 2;
                        } else {
                            i17 = 1;
                        }
                    }
                    ar.a(akVar, this.slice_group_id.length);
                    int i19 = 0;
                    while (true) {
                        int[] iArr4 = this.slice_group_id;
                        if (i19 > iArr4.length) {
                            break;
                        }
                        akVar.a(iArr4[i19], i17);
                        i19++;
                    }
                }
            }
        }
        ar.a(akVar, this.num_ref_idx_active_minus1[0]);
        ar.a(akVar, this.num_ref_idx_active_minus1[1]);
        akVar.b(this.weighted_pred_flag ? 1 : 0);
        ar.a(akVar, (long) this.weighted_bipred_idc, 2);
        ar.a(akVar, dv.a(this.pic_init_qp_minus26));
        ar.a(akVar, dv.a(this.pic_init_qs_minus26));
        ar.a(akVar, dv.a(this.chroma_qp_index_offset));
        akVar.b(this.deblocking_filter_control_present_flag ? 1 : 0);
        akVar.b(this.constrained_intra_pred_flag ? 1 : 0);
        akVar.b(this.redundant_pic_cnt_present_flag ? 1 : 0);
        PPSExt pPSExt = this.extended;
        if (pPSExt != null) {
            akVar.b(pPSExt.transform_8x8_mode_flag ? 1 : 0);
            if (this.extended.scalindMatrix != null) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            akVar.b(i11);
            if (this.extended.scalindMatrix != null) {
                int i21 = 0;
                while (true) {
                    PPSExt pPSExt2 = this.extended;
                    if (i21 >= ((pPSExt2.transform_8x8_mode_flag ? 1 : 0) * true) + 6) {
                        break;
                    }
                    if (i21 < 6) {
                        if (pPSExt2.scalindMatrix.ScalingList4x4[i21] != null) {
                            i13 = 1;
                        } else {
                            i13 = 0;
                        }
                        akVar.b(i13);
                        ScalingList scalingList = this.extended.scalindMatrix.ScalingList4x4[i21];
                        if (scalingList != null) {
                            scalingList.write(akVar);
                        }
                    } else {
                        int i22 = i21 - 6;
                        if (pPSExt2.scalindMatrix.ScalingList8x8[i22] != null) {
                            i12 = 1;
                        } else {
                            i12 = 0;
                        }
                        akVar.b(i12);
                        ScalingList scalingList2 = this.extended.scalindMatrix.ScalingList8x8[i22];
                        if (scalingList2 != null) {
                            scalingList2.write(akVar);
                        }
                    }
                    i21++;
                }
            }
            ar.a(akVar, dv.a(this.extended.second_chroma_qp_index_offset));
        }
        akVar.b(1);
        akVar.a();
    }
}
