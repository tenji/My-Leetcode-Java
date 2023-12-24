package enumeration;

/**
 * 1954. 收集足够苹果的最小花园周长
 *
 * @author tenji
 */
public class CollectEnoughApples1954 {

    public static void main(String[] args) {

//        long neededApples = 13;
        // 输入：neededApples = 13
        // 输出：16

        long neededApples = 1000000000;
        // 输入：neededApples = 1000000000
        // 输出：5040

        System.out.println(new CollectEnoughApples1954().minimumPerimeter(neededApples));
    }

    public long minimumPerimeter(long neededApples) {
        /*
        1、如果正方形土地的右上角坐标为 (n, n)，即边长为 2n，周长为 8n，那么其中包含的苹果总数为：2n * (n+1) * (2n+1)
        2、从小到大枚举 n 即可
         */
        long n = 1;
        while (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }

        return 8 * n;
    }
}
