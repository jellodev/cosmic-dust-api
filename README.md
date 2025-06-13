# cosmic-dust

## 기술 스택:
- Java: 21.0.7 (JVM)
- Kotlin: 1.9.25
- Spring Boot: 3.5.0
- Gradle: 최신 안정 버전 (빌드 도구)
- Spring Web: 웹 애플리케이션 개발

## getting started 
### bootRun
```shell
./gradlew bootRun
```
### build
```shell
./gradlew build
```

### lint
kotlin lint - check
```shell
./gradlew ktlintCheck
```
kotlin lint - fix
```shell
./gradlew ktlintFormat
```

test
- [kotest](https://kotest.io/)
- [mockk](https://mockk.io/)
- intelij 사용 시 플로그인 추가 
  - Preference → Plugins → ‘Kotest’ 검색 → 설치

etc 
- [ktlint](https://github.com/pinterest/ktlint)
