package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Member member = new Member(1L, "Ruby", Grade.VIP);
        MemberService memberService = appConfig.memberService();
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member"+findMember.getName());
        System.out.println("new Member"+member.getName());

    }
}
