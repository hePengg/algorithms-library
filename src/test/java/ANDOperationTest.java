/**
 * 与运算测试
 */
public class ANDOperationTest {

    public static void main(String[] args) {
        // 16位
        final int SHARED_SHIFT   = 16;
        // 0000 0000 0000 0000 1111 1111 1111 1111
        final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

        // 有符号位左移16位，高位移出，低位补0
        // 0000 0000 0000 0000 0000 0000 0000 0001   移动前
        // 0000 0000 0000 0001 0000 0000 0000 0000   移动后
        final int SHARED_UNIT = (1 << SHARED_SHIFT);

        int c = 0;

        // 模拟高16位
        c = c + SHARED_UNIT;

        // 模拟低16位
        c = c + 1;

        System.out.println(c);
        // 位 & 运算
        // 1 & 1 -> 1
        // 0 & 0 -> 0
        // 1 & 0 -> 0
        // 0000 0000 0000 0001 0000 0000 0000 0001 (c)
        // 0000 0000 0000 0000 1111 1111 1111 1111 (EXCLUSIVE_MASK)
        // 通过 & 间接获取低16位的值
        System.out.println(c & EXCLUSIVE_MASK);
    }
}
