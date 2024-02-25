package hello.core.member;

public class MemberServiceImpl implements MemberService{ // 구현체가 하나일 때는 관례상 인터페이스 이름 뒤에 임플이라고 씀(Impl)

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
