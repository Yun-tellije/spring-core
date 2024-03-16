package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{ // 구현체가 하나일 때는 관례상 인터페이스 이름 뒤에 임플이라고 씀(Impl)

    private final MemberRepository memberRepository;
    // MemoryMemberRepository 의존 x -> MemberRepository만 의존하도록 변경
    // 어떤 구현 객체를 주입할지는 오직 AppConfig(외부)에서 결정: DI

    @Autowired // ac.getBean(MemberRepository.class) | 자동으로 이 코드가 들어감
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
