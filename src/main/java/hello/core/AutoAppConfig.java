package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 컴포넌트 스캔 사용
//        basePackages = "hello.core.member", // 탐색할 패키지의 시작 위치를 지정, 여러 위치 지정 가능
//        basePackageClasses = AutoAppConfig.class, // 이 클래스의 패키지부터 탐색
        // 위치를 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치
        // 패키지 위치를 지정하지 않고 사용하는 것을 선호, 설정 정보 클래스의 위치를 프로젝트 최상단에 둠
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
