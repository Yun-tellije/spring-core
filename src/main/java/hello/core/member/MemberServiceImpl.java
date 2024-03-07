package hello.core.member;

public class MemberServiceImpl implements MemberService{ // 구현체가 하나일 때는 관례상 인터페이스 이름 뒤에 임플이라고 씀(Impl)

    private final MemberRepository memberRepository;
    // MemoryMemberRepository 의존 x -> MemberRepository만 의존하도록 변경
    // 어떤 구현 객체를 주입할지는 오직 AppConfig(외부)에서 결정: DI

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
}
