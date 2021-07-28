package hello.core.order;

public class Order {
    private Long memberid;
    private String itemname;
    private int itemPrice;
    private int discountamountprice;

    public Order(Long memberid, String itemname, int itemPrice, int discountamountprice) {
        this.memberid = memberid;
        this.itemname = itemname;
        this.itemPrice = itemPrice;
        this.discountamountprice = discountamountprice;
    }

    //계산로직
    private int caculatePrice(){
        return itemPrice-discountamountprice;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountamountprice() {
        return discountamountprice;
    }

    public void setDiscountamountprice(int discountamountprice) {
        this.discountamountprice = discountamountprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberid=" + memberid +
                ", itemname='" + itemname + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountamountprice=" + discountamountprice +
                '}';
    }
}
