package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public abstract class ByteCodeForm {
    protected static final boolean WIDENED = true;
    protected static final ByteCodeForm[] byteCodeArray;
    protected static final Map byteCodesByName = new HashMap(256);
    private int firstOperandIndex;

    /* renamed from: name  reason: collision with root package name */
    private final String f27768name;
    private final int opcode;
    private int operandLength;
    private final int[] rewrite;

    static {
        ByteCodeForm[] byteCodeFormArr = new ByteCodeForm[256];
        byteCodeArray = byteCodeFormArr;
        int i11 = 0;
        byteCodeFormArr[0] = new NoArgumentForm(0, "nop");
        byteCodeFormArr[1] = new NoArgumentForm(1, "aconst_null");
        byteCodeFormArr[2] = new NoArgumentForm(2, "iconst_m1");
        byteCodeFormArr[3] = new NoArgumentForm(3, "iconst_0");
        byteCodeFormArr[4] = new NoArgumentForm(4, "iconst_1");
        byteCodeFormArr[5] = new NoArgumentForm(5, "iconst_2");
        byteCodeFormArr[6] = new NoArgumentForm(6, "iconst_3");
        byteCodeFormArr[7] = new NoArgumentForm(7, "iconst_4");
        byteCodeFormArr[8] = new NoArgumentForm(8, "iconst_5");
        byteCodeFormArr[9] = new NoArgumentForm(9, "lconst_0");
        byteCodeFormArr[10] = new NoArgumentForm(10, "lconst_1");
        byteCodeFormArr[11] = new NoArgumentForm(11, "fconst_0");
        byteCodeFormArr[12] = new NoArgumentForm(12, "fconst_1");
        byteCodeFormArr[13] = new NoArgumentForm(13, "fconst_2");
        byteCodeFormArr[14] = new NoArgumentForm(14, "dconst_0");
        byteCodeFormArr[15] = new NoArgumentForm(15, "dconst_1");
        byteCodeFormArr[16] = new ByteForm(16, "bipush", new int[]{16, -1});
        byteCodeFormArr[17] = new ShortForm(17, "sipush", new int[]{17, -1, -1});
        byteCodeFormArr[18] = new StringRefForm(18, "ldc", new int[]{18, -1});
        byteCodeFormArr[19] = new StringRefForm(19, "ldc_w", new int[]{19, -1, -1}, true);
        byteCodeFormArr[20] = new LongForm(20, "ldc2_w", new int[]{20, -1, -1});
        byteCodeFormArr[21] = new LocalForm(21, "iload", new int[]{21, -1});
        byteCodeFormArr[22] = new LocalForm(22, "lload", new int[]{22, -1});
        byteCodeFormArr[23] = new LocalForm(23, "fload", new int[]{23, -1});
        byteCodeFormArr[24] = new LocalForm(24, "dload", new int[]{24, -1});
        byteCodeFormArr[25] = new LocalForm(25, "aload", new int[]{25, -1});
        byteCodeFormArr[26] = new NoArgumentForm(26, "iload_0");
        byteCodeFormArr[27] = new NoArgumentForm(27, "iload_1");
        byteCodeFormArr[28] = new NoArgumentForm(28, "iload_2");
        byteCodeFormArr[29] = new NoArgumentForm(29, "iload_3");
        byteCodeFormArr[30] = new NoArgumentForm(30, "lload_0");
        byteCodeFormArr[31] = new NoArgumentForm(31, "lload_1");
        byteCodeFormArr[32] = new NoArgumentForm(32, "lload_2");
        byteCodeFormArr[33] = new NoArgumentForm(33, "lload_3");
        byteCodeFormArr[34] = new NoArgumentForm(34, "fload_0");
        byteCodeFormArr[35] = new NoArgumentForm(35, "fload_1");
        byteCodeFormArr[36] = new NoArgumentForm(36, "fload_2");
        byteCodeFormArr[37] = new NoArgumentForm(37, "fload_3");
        byteCodeFormArr[38] = new NoArgumentForm(38, "dload_0");
        byteCodeFormArr[39] = new NoArgumentForm(39, "dload_1");
        byteCodeFormArr[40] = new NoArgumentForm(40, "dload_2");
        byteCodeFormArr[41] = new NoArgumentForm(41, "dload_3");
        byteCodeFormArr[42] = new NoArgumentForm(42, "aload_0");
        byteCodeFormArr[43] = new NoArgumentForm(43, "aload_1");
        byteCodeFormArr[44] = new NoArgumentForm(44, "aload_2");
        byteCodeFormArr[45] = new NoArgumentForm(45, "aload_3");
        byteCodeFormArr[46] = new NoArgumentForm(46, "iaload");
        byteCodeFormArr[47] = new NoArgumentForm(47, "laload");
        byteCodeFormArr[48] = new NoArgumentForm(48, "faload");
        byteCodeFormArr[49] = new NoArgumentForm(49, "daload");
        byteCodeFormArr[50] = new NoArgumentForm(50, "aaload");
        byteCodeFormArr[51] = new NoArgumentForm(51, "baload");
        byteCodeFormArr[52] = new NoArgumentForm(52, "caload");
        byteCodeFormArr[53] = new NoArgumentForm(53, "saload");
        byteCodeFormArr[54] = new LocalForm(54, "istore", new int[]{54, -1});
        byteCodeFormArr[55] = new LocalForm(55, "lstore", new int[]{55, -1});
        byteCodeFormArr[56] = new LocalForm(56, "fstore", new int[]{56, -1});
        byteCodeFormArr[57] = new LocalForm(57, "dstore", new int[]{57, -1});
        byteCodeFormArr[58] = new LocalForm(58, "astore", new int[]{58, -1});
        byteCodeFormArr[59] = new NoArgumentForm(59, "istore_0");
        byteCodeFormArr[60] = new NoArgumentForm(60, "istore_1");
        byteCodeFormArr[61] = new NoArgumentForm(61, "istore_2");
        byteCodeFormArr[62] = new NoArgumentForm(62, "istore_3");
        byteCodeFormArr[63] = new NoArgumentForm(63, "lstore_0");
        byteCodeFormArr[64] = new NoArgumentForm(64, "lstore_1");
        byteCodeFormArr[65] = new NoArgumentForm(65, "lstore_2");
        byteCodeFormArr[66] = new NoArgumentForm(66, "lstore_3");
        byteCodeFormArr[67] = new NoArgumentForm(67, "fstore_0");
        byteCodeFormArr[68] = new NoArgumentForm(68, "fstore_1");
        byteCodeFormArr[69] = new NoArgumentForm(69, "fstore_2");
        byteCodeFormArr[70] = new NoArgumentForm(70, "fstore_3");
        byteCodeFormArr[71] = new NoArgumentForm(71, "dstore_0");
        byteCodeFormArr[72] = new NoArgumentForm(72, "dstore_1");
        byteCodeFormArr[73] = new NoArgumentForm(73, "dstore_2");
        byteCodeFormArr[74] = new NoArgumentForm(74, "dstore_3");
        byteCodeFormArr[75] = new NoArgumentForm(75, "astore_0");
        byteCodeFormArr[76] = new NoArgumentForm(76, "astore_1");
        byteCodeFormArr[77] = new NoArgumentForm(77, "astore_2");
        byteCodeFormArr[78] = new NoArgumentForm(78, "astore_3");
        byteCodeFormArr[79] = new NoArgumentForm(79, "iastore");
        byteCodeFormArr[80] = new NoArgumentForm(80, "lastore");
        byteCodeFormArr[81] = new NoArgumentForm(81, "fastore");
        byteCodeFormArr[82] = new NoArgumentForm(82, "dastore");
        byteCodeFormArr[83] = new NoArgumentForm(83, "aastore");
        byteCodeFormArr[84] = new NoArgumentForm(84, "bastore");
        byteCodeFormArr[85] = new NoArgumentForm(85, "castore");
        byteCodeFormArr[86] = new NoArgumentForm(86, "sastore");
        byteCodeFormArr[87] = new NoArgumentForm(87, "pop");
        byteCodeFormArr[88] = new NoArgumentForm(88, "pop2");
        byteCodeFormArr[89] = new NoArgumentForm(89, "dup");
        byteCodeFormArr[90] = new NoArgumentForm(90, "dup_x1");
        byteCodeFormArr[91] = new NoArgumentForm(91, "dup_x2");
        byteCodeFormArr[92] = new NoArgumentForm(92, "dup2");
        byteCodeFormArr[93] = new NoArgumentForm(93, "dup2_x1");
        byteCodeFormArr[94] = new NoArgumentForm(94, "dup2_x2");
        byteCodeFormArr[95] = new NoArgumentForm(95, "swap");
        byteCodeFormArr[96] = new NoArgumentForm(96, "iadd");
        byteCodeFormArr[97] = new NoArgumentForm(97, "ladd");
        byteCodeFormArr[98] = new NoArgumentForm(98, "fadd");
        byteCodeFormArr[99] = new NoArgumentForm(99, "dadd");
        byteCodeFormArr[100] = new NoArgumentForm(100, "isub");
        byteCodeFormArr[101] = new NoArgumentForm(101, "lsub");
        byteCodeFormArr[102] = new NoArgumentForm(102, "fsub");
        byteCodeFormArr[103] = new NoArgumentForm(103, "dsub");
        byteCodeFormArr[104] = new NoArgumentForm(104, "imul");
        byteCodeFormArr[105] = new NoArgumentForm(105, "lmul");
        byteCodeFormArr[106] = new NoArgumentForm(106, "fmul");
        byteCodeFormArr[107] = new NoArgumentForm(107, "dmul");
        byteCodeFormArr[108] = new NoArgumentForm(108, "idiv");
        byteCodeFormArr[109] = new NoArgumentForm(109, "ldiv");
        byteCodeFormArr[110] = new NoArgumentForm(110, "fdiv");
        byteCodeFormArr[111] = new NoArgumentForm(111, "ddiv");
        byteCodeFormArr[112] = new NoArgumentForm(112, "irem");
        byteCodeFormArr[113] = new NoArgumentForm(113, "lrem");
        byteCodeFormArr[114] = new NoArgumentForm(114, "frem");
        byteCodeFormArr[115] = new NoArgumentForm(115, "drem");
        byteCodeFormArr[116] = new NoArgumentForm(116, "");
        byteCodeFormArr[117] = new NoArgumentForm(117, "lneg");
        byteCodeFormArr[118] = new NoArgumentForm(118, "fneg");
        byteCodeFormArr[119] = new NoArgumentForm(119, "dneg");
        byteCodeFormArr[120] = new NoArgumentForm(120, "ishl");
        byteCodeFormArr[121] = new NoArgumentForm(121, "lshl");
        byteCodeFormArr[122] = new NoArgumentForm(122, "ishr");
        byteCodeFormArr[123] = new NoArgumentForm(123, "lshr");
        byteCodeFormArr[124] = new NoArgumentForm(124, "iushr");
        byteCodeFormArr[125] = new NoArgumentForm(125, "lushr");
        byteCodeFormArr[126] = new NoArgumentForm(126, "iand");
        byteCodeFormArr[127] = new NoArgumentForm(127, "land");
        byteCodeFormArr[128] = new NoArgumentForm(128, "ior");
        byteCodeFormArr[129] = new NoArgumentForm(129, "lor");
        byteCodeFormArr[130] = new NoArgumentForm(130, "ixor");
        byteCodeFormArr[131] = new NoArgumentForm(131, "lxor");
        byteCodeFormArr[132] = new IincForm(Opcodes.IINC, "iinc", new int[]{Opcodes.IINC, -1, -1});
        byteCodeFormArr[133] = new NoArgumentForm(Opcodes.I2L, "i2l");
        byteCodeFormArr[134] = new NoArgumentForm(134, "i2f");
        byteCodeFormArr[135] = new NoArgumentForm(135, "i2d");
        byteCodeFormArr[136] = new NoArgumentForm(Opcodes.L2I, "l2i");
        byteCodeFormArr[137] = new NoArgumentForm(Opcodes.L2F, "l2f");
        byteCodeFormArr[138] = new NoArgumentForm(138, "l2d");
        byteCodeFormArr[139] = new NoArgumentForm(Opcodes.F2I, "f2i");
        byteCodeFormArr[140] = new NoArgumentForm(Opcodes.F2L, "f2l");
        byteCodeFormArr[141] = new NoArgumentForm(Opcodes.F2D, "f2d");
        byteCodeFormArr[142] = new NoArgumentForm(Opcodes.D2I, "d2i");
        byteCodeFormArr[143] = new NoArgumentForm(Opcodes.D2L, "d2l");
        byteCodeFormArr[144] = new NoArgumentForm(Opcodes.D2F, "d2f");
        byteCodeFormArr[145] = new NoArgumentForm(Opcodes.I2B, "i2b");
        byteCodeFormArr[146] = new NoArgumentForm(Opcodes.I2C, "i2c");
        byteCodeFormArr[147] = new NoArgumentForm(Opcodes.I2S, "i2s");
        byteCodeFormArr[148] = new NoArgumentForm(148, "lcmp");
        byteCodeFormArr[149] = new NoArgumentForm(Opcodes.FCMPL, "fcmpl");
        byteCodeFormArr[150] = new NoArgumentForm(150, "fcmpg");
        byteCodeFormArr[151] = new NoArgumentForm(Opcodes.DCMPL, "dcmpl");
        byteCodeFormArr[152] = new NoArgumentForm(Opcodes.DCMPG, "dcmpg");
        byteCodeFormArr[153] = new LabelForm(Opcodes.IFEQ, "ifeq", new int[]{Opcodes.IFEQ, -1, -1});
        byteCodeFormArr[154] = new LabelForm(Opcodes.IFNE, "ifne", new int[]{Opcodes.IFNE, -1, -1});
        byteCodeFormArr[155] = new LabelForm(155, "iflt", new int[]{155, -1, -1});
        byteCodeFormArr[156] = new LabelForm(Opcodes.IFGE, "ifge", new int[]{Opcodes.IFGE, -1, -1});
        byteCodeFormArr[157] = new LabelForm(Opcodes.IFGT, "ifgt", new int[]{Opcodes.IFGT, -1, -1});
        byteCodeFormArr[158] = new LabelForm(Opcodes.IFLE, "ifle", new int[]{Opcodes.IFLE, -1, -1});
        byteCodeFormArr[159] = new LabelForm(Opcodes.IF_ICMPEQ, "if_icmpeq", new int[]{Opcodes.IF_ICMPEQ, -1, -1});
        byteCodeFormArr[160] = new LabelForm(Opcodes.IF_ICMPNE, "if_icmpne", new int[]{Opcodes.IF_ICMPNE, -1, -1});
        byteCodeFormArr[161] = new LabelForm(Opcodes.IF_ICMPLT, "if_icmplt", new int[]{Opcodes.IF_ICMPLT, -1, -1});
        byteCodeFormArr[162] = new LabelForm(Opcodes.IF_ICMPGE, "if_icmpge", new int[]{Opcodes.IF_ICMPGE, -1, -1});
        byteCodeFormArr[163] = new LabelForm(Opcodes.IF_ICMPGT, "if_icmpgt", new int[]{Opcodes.IF_ICMPGT, -1, -1});
        byteCodeFormArr[164] = new LabelForm(Opcodes.IF_ICMPLE, "if_icmple", new int[]{Opcodes.IF_ICMPLE, -1, -1});
        byteCodeFormArr[165] = new LabelForm(Opcodes.IF_ACMPEQ, "if_acmpeq", new int[]{Opcodes.IF_ACMPEQ, -1, -1});
        byteCodeFormArr[166] = new LabelForm(Opcodes.IF_ACMPNE, "if_acmpne", new int[]{Opcodes.IF_ACMPNE, -1, -1});
        byteCodeFormArr[167] = new LabelForm(Opcodes.GOTO, "goto", new int[]{Opcodes.GOTO, -1, -1});
        byteCodeFormArr[168] = new LabelForm(Opcodes.JSR, "jsr", new int[]{Opcodes.JSR, -1, -1});
        byteCodeFormArr[169] = new LocalForm(Opcodes.RET, "ret", new int[]{Opcodes.RET, -1});
        byteCodeFormArr[170] = new TableSwitchForm(Opcodes.TABLESWITCH, "tableswitch");
        byteCodeFormArr[171] = new LookupSwitchForm(Opcodes.LOOKUPSWITCH, "lookupswitch");
        byteCodeFormArr[172] = new NoArgumentForm(172, "ireturn");
        byteCodeFormArr[173] = new NoArgumentForm(Opcodes.LRETURN, "lreturn");
        byteCodeFormArr[174] = new NoArgumentForm(Opcodes.FRETURN, "freturn");
        byteCodeFormArr[175] = new NoArgumentForm(Opcodes.DRETURN, "dreturn");
        byteCodeFormArr[176] = new NoArgumentForm(Opcodes.ARETURN, "areturn");
        byteCodeFormArr[177] = new NoArgumentForm(Opcodes.RETURN, "return");
        byteCodeFormArr[178] = new FieldRefForm(Opcodes.GETSTATIC, "getstatic", new int[]{Opcodes.GETSTATIC, -1, -1});
        byteCodeFormArr[179] = new FieldRefForm(Opcodes.PUTSTATIC, "putstatic", new int[]{Opcodes.PUTSTATIC, -1, -1});
        byteCodeFormArr[180] = new FieldRefForm(180, "getfield", new int[]{180, -1, -1});
        byteCodeFormArr[181] = new FieldRefForm(Opcodes.PUTFIELD, "putfield", new int[]{Opcodes.PUTFIELD, -1, -1});
        byteCodeFormArr[182] = new MethodRefForm(Opcodes.INVOKEVIRTUAL, "invokevirtual", new int[]{Opcodes.INVOKEVIRTUAL, -1, -1});
        byteCodeFormArr[183] = new MethodRefForm(Opcodes.INVOKESPECIAL, "invokespecial", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[184] = new MethodRefForm(Opcodes.INVOKESTATIC, "invokestatic", new int[]{Opcodes.INVOKESTATIC, -1, -1});
        byteCodeFormArr[185] = new IMethodRefForm(Opcodes.INVOKEINTERFACE, "invokeinterface", new int[]{Opcodes.INVOKEINTERFACE, -1, -1, -1, 0});
        byteCodeFormArr[186] = new NoArgumentForm(Opcodes.INVOKEDYNAMIC, "xxxunusedxxx");
        byteCodeFormArr[187] = new NewClassRefForm(Opcodes.NEW, "new", new int[]{Opcodes.NEW, -1, -1});
        byteCodeFormArr[188] = new ByteForm(188, "newarray", new int[]{188, -1});
        byteCodeFormArr[189] = new ClassRefForm(189, "anewarray", new int[]{189, -1, -1});
        byteCodeFormArr[190] = new NoArgumentForm(190, "arraylength");
        byteCodeFormArr[191] = new NoArgumentForm(Opcodes.ATHROW, "athrow");
        byteCodeFormArr[192] = new ClassRefForm(192, "checkcast", new int[]{192, -1, -1});
        byteCodeFormArr[193] = new ClassRefForm(Opcodes.INSTANCEOF, "instanceof", new int[]{Opcodes.INSTANCEOF, -1, -1});
        byteCodeFormArr[194] = new NoArgumentForm(Opcodes.MONITORENTER, "monitorenter");
        byteCodeFormArr[195] = new NoArgumentForm(Opcodes.MONITOREXIT, "monitorexit");
        byteCodeFormArr[196] = new WideForm(196, "wide");
        byteCodeFormArr[197] = new MultiANewArrayForm(Opcodes.MULTIANEWARRAY, "multianewarray", new int[]{Opcodes.MULTIANEWARRAY, -1, -1, -1});
        byteCodeFormArr[198] = new LabelForm(Opcodes.IFNULL, "ifnull", new int[]{Opcodes.IFNULL, -1, -1});
        byteCodeFormArr[199] = new LabelForm(Opcodes.IFNONNULL, "ifnonnull", new int[]{Opcodes.IFNONNULL, -1, -1});
        byteCodeFormArr[200] = new LabelForm(200, "goto_w", new int[]{200, -1, -1, -1, -1}, true);
        byteCodeFormArr[201] = new LabelForm(201, "jsr_w", new int[]{201, -1, -1, -1, -1}, true);
        byteCodeFormArr[202] = new ThisFieldRefForm(202, "getstatic_this", new int[]{Opcodes.GETSTATIC, -1, -1});
        byteCodeFormArr[203] = new ThisFieldRefForm(203, "putstatic_this", new int[]{Opcodes.PUTSTATIC, -1, -1});
        byteCodeFormArr[204] = new ThisFieldRefForm(204, "getfield_this", new int[]{180, -1, -1});
        byteCodeFormArr[205] = new ThisFieldRefForm(205, "putfield_this", new int[]{Opcodes.PUTFIELD, -1, -1});
        byteCodeFormArr[206] = new ThisMethodRefForm(206, "invokevirtual_this", new int[]{Opcodes.INVOKEVIRTUAL, -1, -1});
        byteCodeFormArr[207] = new ThisMethodRefForm(207, "invokespecial_this", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[208] = new ThisMethodRefForm(208, "invokestatic_this", new int[]{Opcodes.INVOKESTATIC, -1, -1});
        byteCodeFormArr[209] = new ThisFieldRefForm(209, "aload_0_getstatic_this", new int[]{42, Opcodes.GETSTATIC, -1, -1});
        byteCodeFormArr[210] = new ThisFieldRefForm(210, "aload_0_putstatic_this", new int[]{42, Opcodes.PUTSTATIC, -1, -1});
        byteCodeFormArr[211] = new ThisFieldRefForm(211, "aload_0_getfield_this", new int[]{42, 180, -1, -1});
        byteCodeFormArr[212] = new ThisFieldRefForm(212, "aload_0_putfield_this", new int[]{42, Opcodes.PUTFIELD, -1, -1});
        byteCodeFormArr[213] = new ThisMethodRefForm(213, "aload_0_invokevirtual_this", new int[]{42, Opcodes.INVOKEVIRTUAL, -1, -1});
        byteCodeFormArr[214] = new ThisMethodRefForm(ModuleDescriptor.MODULE_VERSION, "aload_0_invokespecial_this", new int[]{42, Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[215] = new ThisMethodRefForm(215, "aload_0_invokestatic_this", new int[]{42, Opcodes.INVOKESTATIC, -1, -1});
        byteCodeFormArr[216] = new SuperFieldRefForm(216, "getstatic_super", new int[]{Opcodes.GETSTATIC, -1, -1});
        byteCodeFormArr[217] = new SuperFieldRefForm(217, "putstatic_super", new int[]{Opcodes.PUTSTATIC, -1, -1});
        byteCodeFormArr[218] = new SuperFieldRefForm(218, "getfield_super", new int[]{180, -1, -1});
        byteCodeFormArr[219] = new SuperFieldRefForm(219, "putfield_super", new int[]{Opcodes.PUTFIELD, -1, -1});
        byteCodeFormArr[220] = new SuperMethodRefForm(220, "invokevirtual_super", new int[]{Opcodes.INVOKEVIRTUAL, -1, -1});
        byteCodeFormArr[221] = new SuperMethodRefForm(221, "invokespecial_super", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[222] = new SuperMethodRefForm(222, "invokestatic_super", new int[]{Opcodes.INVOKESTATIC, -1, -1});
        byteCodeFormArr[223] = new SuperFieldRefForm(223, "aload_0_getstatic_super", new int[]{42, Opcodes.GETSTATIC, -1, -1});
        byteCodeFormArr[224] = new SuperFieldRefForm(224, "aload_0_putstatic_super", new int[]{42, Opcodes.PUTSTATIC, -1, -1});
        byteCodeFormArr[225] = new SuperFieldRefForm(225, "aload_0_getfield_super", new int[]{42, 180, -1, -1});
        byteCodeFormArr[226] = new SuperFieldRefForm(226, "aload_0_putfield_super", new int[]{42, Opcodes.PUTFIELD, -1, -1});
        byteCodeFormArr[227] = new SuperMethodRefForm(227, "aload_0_invokevirtual_super", new int[]{42, Opcodes.INVOKEVIRTUAL, -1, -1});
        byteCodeFormArr[228] = new SuperMethodRefForm(228, "aload_0_invokespecial_super", new int[]{42, Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[229] = new SuperMethodRefForm(229, "aload_0_invokestatic_super", new int[]{42, Opcodes.INVOKESTATIC, -1, -1});
        byteCodeFormArr[230] = new ThisInitMethodRefForm(230, "invokespecial_this_init", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[231] = new SuperInitMethodRefForm(231, "invokespecial_super_init", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[232] = new NewInitMethodRefForm(232, "invokespecial_new_init", new int[]{Opcodes.INVOKESPECIAL, -1, -1});
        byteCodeFormArr[233] = new NarrowClassRefForm(233, "cldc", new int[]{18, -1});
        byteCodeFormArr[234] = new IntRefForm(234, "ildc", new int[]{18, -1});
        byteCodeFormArr[235] = new FloatRefForm(235, "fldc", new int[]{18, -1});
        byteCodeFormArr[236] = new NarrowClassRefForm(236, "cldc_w", new int[]{19, -1, -1}, true);
        byteCodeFormArr[237] = new IntRefForm(237, "ildc_w", new int[]{19, -1, -1}, true);
        byteCodeFormArr[238] = new FloatRefForm(238, "fldc_w", new int[]{19, -1, -1}, true);
        byteCodeFormArr[239] = new DoubleForm(239, "dldc2_w", new int[]{20, -1, -1});
        byteCodeFormArr[254] = new NoArgumentForm(254, "impdep1");
        byteCodeFormArr[255] = new NoArgumentForm(255, "impdep2");
        while (true) {
            ByteCodeForm[] byteCodeFormArr2 = byteCodeArray;
            if (i11 < byteCodeFormArr2.length) {
                ByteCodeForm byteCodeForm = byteCodeFormArr2[i11];
                if (byteCodeForm != null) {
                    byteCodesByName.put(byteCodeForm.getName(), byteCodeForm);
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public ByteCodeForm(int i11, String str) {
        this(i11, str, new int[]{i11});
    }

    public static ByteCodeForm get(int i11) {
        return byteCodeArray[i11];
    }

    public void calculateOperandPosition() {
        int i11 = -1;
        this.firstOperandIndex = -1;
        this.operandLength = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = this.rewrite;
            if (i12 >= iArr.length) {
                break;
            } else if (iArr[i12] < 0) {
                this.firstOperandIndex = i12;
                i12 = iArr.length;
            } else {
                i12++;
            }
        }
        int i13 = this.firstOperandIndex;
        if (i13 != -1) {
            while (true) {
                int[] iArr2 = this.rewrite;
                if (i13 >= iArr2.length) {
                    break;
                }
                if (iArr2[i13] < 0) {
                    i11 = i13;
                }
                i13++;
            }
            int i14 = i11 - this.firstOperandIndex;
            if (i14 >= 0) {
                this.operandLength = i14 + 1;
                return;
            }
            throw new Error("Logic error: not finding rewrite operands correctly");
        }
    }

    public int firstOperandIndex() {
        return this.firstOperandIndex;
    }

    public void fixUpByteCodeTargets(ByteCode byteCode, CodeAttribute codeAttribute) {
    }

    public String getName() {
        return this.f27768name;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public int[] getRewrite() {
        return this.rewrite;
    }

    public int[] getRewriteCopy() {
        int[] iArr = this.rewrite;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public boolean hasMultipleByteCodes() {
        int[] iArr = this.rewrite;
        if (iArr.length <= 1 || iArr[0] != 42 || iArr[1] <= 0) {
            return false;
        }
        return true;
    }

    public boolean hasNoOperand() {
        return false;
    }

    public boolean nestedMustStartClassPool() {
        return false;
    }

    public int operandLength() {
        return this.operandLength;
    }

    public abstract void setByteCodeOperands(ByteCode byteCode, OperandManager operandManager, int i11);

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    public ByteCodeForm(int i11, String str, int[] iArr) {
        this.opcode = i11;
        this.f27768name = str;
        this.rewrite = iArr;
        calculateOperandPosition();
    }
}
