package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // OCP,DIP 위반. 구현체에도 의존되어있으면 안됨. 분리를 해야함.
  //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemname, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int   discountPrice= discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemname,itemPrice,discountPrice);
    }
}
