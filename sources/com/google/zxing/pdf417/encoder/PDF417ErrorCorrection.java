package com.google.zxing.pdf417.encoder;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.firebase.database.core.ValidationPath;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.instabug.library.networkv2.RequestResponse;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import library.talabat.mvp.placeorder.PlaceOrderView;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.tukaani.xz.LZMA2Options;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, Opcodes.IINC, 295, 116, 442, 428, 295, 42, Opcodes.ARETURN, 65}, new int[]{361, 575, 922, 525, Opcodes.ARETURN, 586, 640, 321, 536, 742, 677, 742, 687, 284, Opcodes.INSTANCEOF, 517, LZMA2Options.NICE_LEN_MAX, 494, TarConstants.VERSION_OFFSET, Opcodes.I2S, 593, 800, 571, 320, 803, Opcodes.I2L, 231, 390, 685, 330, 63, ErrorCode.HTTP_GONE}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 287, 107, 505, 733, 877, 381, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 723, 476, 462, 172, 430, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 858, 822, 543, 376, 511, 400, 672, 762, 283, Opcodes.INVOKESTATIC, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, Opcodes.IFLE, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, ErrorCode.HTTP_UNSUPPORTED_TYPE, 822, 93, 217, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 516, BZip2Constants.MAX_ALPHA_SIZE, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, Opcodes.INSTANCEOF, 219, 129, Opcodes.INVOKEDYNAMIC, 236, 287, 192, 775, 278, Opcodes.LRETURN, 40, 379, 712, 463, 646, 776, Opcodes.LOOKUPSWITCH, 491, 297, 763, Opcodes.IFGE, 732, 95, 270, 447, 90, TypedValues.PositionType.TYPE_PERCENT_Y, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 754, 336, 89, 614, 87, 432, 670, 616, Opcodes.IFGT, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, TypedValues.Custom.TYPE_DIMENSION, 786, 138, 720, 858, Opcodes.MONITORENTER, 311, 913, 275, 190, 375, 850, 438, 733, Opcodes.MONITORENTER, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 540, 913, 801, 700, 799, Opcodes.L2F, 439, 418, 592, 668, 353, 859, 370, 694, 325, PsExtractor.VIDEO_STREAM_MASK, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, Opcodes.IF_ICMPGE, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, Opcodes.L2I, 538, TypedValues.Custom.TYPE_REFERENCE, 90, 2, 290, 743, Opcodes.IFNONNULL, PlaceOrderView.PLACEORDERERRORCODES.BIN_EXPIRED, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, TarConstants.VERSION_OFFSET, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 374, 601, 192, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, Opcodes.D2I, 673, 687, 234, 722, RendererCapabilities.MODE_SUPPORT_MASK, Opcodes.RETURN, 752, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 640, 455, Opcodes.INSTANCEOF, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, PlaceOrderView.PLACEORDERERRORCODES.BIN_EXPIRED, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, Opcodes.D2F, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 441, 180, 791, 893, 754, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, Opcodes.ATHROW, 910, 532, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 829, 189, 20, Opcodes.GOTO, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, Opcodes.LRETURN, 404, 251, 688, 95, 497, 555, 642, 543, 307, Opcodes.IF_ICMPEQ, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, Opcodes.MULTIANEWARRAY, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, Opcodes.INSTANCEOF, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, ErrorCode.HTTP_CLIENT_TIMEOUT, 390, 644, 102, 476, ReferAFriendReceiverFlutterActivity.RAF_REQUEST_CODE, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, ErrorCode.HTTP_PROXY_AUTH, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, Opcodes.D2I, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, 192, 516, BZip2Constants.MAX_ALPHA_SIZE, PsExtractor.VIDEO_STREAM_MASK, 518, 794, 395, ValidationPath.MAX_PATH_LENGTH_BYTES, 848, 51, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, RendererCapabilities.MODE_SUPPORT_MASK, Opcodes.JSR, 190, 826, 328, 596, 786, 303, 570, 381, ErrorCode.HTTP_UNSUPPORTED_TYPE, 641, Opcodes.IFGE, 237, Opcodes.DCMPL, RequestResponse.HttpStatusCode._4xx.RATE_LIMIT_REACHED, 531, 207, 676, 710, 89, Opcodes.JSR, 304, 402, 40, 708, 575, Opcodes.IF_ICMPGE, 864, 229, 65, 861, 841, 512, Opcodes.IF_ICMPLE, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, ReferAFriendReceiverFlutterActivity.RAF_REQUEST_CODE, 851, 543, Opcodes.DCMPG, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, TypedValues.Custom.TYPE_COLOR, 452, Opcodes.GOTO, 342, 244, Opcodes.LRETURN, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, PlaceOrderView.PLACEORDERERRORCODES.ERROR_TGODISCOUNT_USERTYPE, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, ErrorCode.HTTP_CLIENT_TIMEOUT, 842, 383, 721, 521, 560, 644, 714, 559, 62, Opcodes.I2B, 873, 663, 713, Opcodes.IF_ICMPEQ, 672, 729, 624, 59, Opcodes.INSTANCEOF, 417, Opcodes.IFLE, 209, 563, 564, 343, 693, 109, TypedValues.MotionType.TYPE_DRAW_PATH, 563, WalletSubscriptionMapperKt.DAYS_IN_A_YEAR, Opcodes.PUTFIELD, 772, 677, 310, 248, 353, 708, ErrorCode.HTTP_GONE, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, TypedValues.CycleType.TYPE_WAVE_OFFSET, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, Opcodes.INVOKESTATIC, 45, 787, 680, 18, 66, ErrorCode.HTTP_PROXY_AUTH, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, TypedValues.Custom.TYPE_DIMENSION, 789, 420, 305, 441, 207, 300, 892, 827, Opcodes.F2D, 537, 381, PlaceOrderView.PLACEORDERERRORCODES.ERROR_TGODISCOUNT_USERTYPE, InputDeviceCompat.SOURCE_DPAD, 56, 252, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, TypedValues.CycleType.TYPE_WAVE_PHASE, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, TypedValues.Custom.TYPE_DIMENSION, 303, 843, 922, 281, 73, 469, 791, 660, Opcodes.IF_ICMPGE, 498, 308, 155, 422, 907, 817, Opcodes.NEW, 62, 16, TypedValues.CycleType.TYPE_WAVE_PHASE, 535, 336, 286, 437, 375, LZMA2Options.NICE_LEN_MAX, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 296, Opcodes.INVOKESPECIAL, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, TypedValues.CycleType.TYPE_WAVE_OFFSET, 242, 749, 321, 54, 669, TypedValues.AttributesType.TYPE_PATH_ROTATE, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, TypedValues.AttributesType.TYPE_PATH_ROTATE, 486, 721, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 46, 656, 447, Opcodes.LOOKUPSWITCH, 616, 464, 190, 531, 297, 321, 762, 752, 533, Opcodes.DRETURN, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, ErrorCode.HTTP_LENGTH_REQUIRED, 877, 669, Opcodes.F2D, 919, 45, 780, ErrorCode.HTTP_PROXY_AUTH, Opcodes.IF_ICMPLE, 332, 899, Opcodes.IF_ACMPEQ, 726, 600, 325, 498, PlaceOrderView.PLACEORDERERRORCODES.BIN_EXPIRED, 357, 752, ValidationPath.MAX_PATH_LENGTH_BYTES, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, ErrorCode.HTTP_GONE, 389, 244, 31, 121, 303, TarConstants.VERSION_OFFSET}};

    private PDF417ErrorCorrection() {
    }

    public static String generateErrorCorrection(CharSequence charSequence, int i11) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i11);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i12) + cArr[i13]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i13 > 0) {
                cArr[i13] = (char) ((cArr[i13 - 1] + (929 - ((EC_COEFFICIENTS[i11][i13] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i13--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i11][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb2 = new StringBuilder(errorCorrectionCodewordCount);
        for (int i14 = errorCorrectionCodewordCount - 1; i14 >= 0; i14--) {
            char c11 = cArr[i14];
            if (c11 != 0) {
                cArr[i14] = (char) (929 - c11);
            }
            sb2.append(cArr[i14]);
        }
        return sb2.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i11) {
        if (i11 >= 0 && i11 <= 8) {
            return 1 << (i11 + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i11) throws WriterException {
        if (i11 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i11 <= 40) {
            return 2;
        } else {
            if (i11 <= 160) {
                return 3;
            }
            if (i11 <= 320) {
                return 4;
            }
            if (i11 <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }
}
