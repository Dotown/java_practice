package www.zhang.studatetime;

/**
 * CompareTest的test2
 *
 * @author Dotown
 * @create 2020-12-26-20:11
 */

public class Good implements Comparable{
    private String name;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good() {
    }

    public Good(String name, int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Good){
            Good good = (Good) o;
            if (this.price > good.price){
                return 1;
            }else if(this.price< good.price){
                return -1;
            }else{
                return 0;
            }
        }
        throw new RuntimeException("比较的数据类型不一致");
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
