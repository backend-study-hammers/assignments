package jieuny.springbasic.order;

public interface OrderService {
    Order createorder(Long memberId, String itemname, int itemprice);
}
