
## - home
- http://www.multicampus.co.kr/

## - edu
- https://smart.edutto.net
	id/pass ID@multicampus.co.kr/????

### - 전자정부 site
	- http://www.egovframe.go.kr/cop/bbs/selectBoardArticle.do?bbsId=BBSMSTR_000000000002&nttId=1029&menu=3&submenu=2

```bin
[구성]

개발자용 개발환경 32bit/64bit(Implementation Tool) Full Version은 개발자의 코드 작성을 지원하는 도구로써, eGovFrame기반의 어플리케이션 개발을 지원하는 IDE와 Editor(SourceCode, UML, ERD, DBIO, WebFlow, Code Generation, Code Inspection, 공통컴포넌트 생성, 맞춤형 개발환경, Nexus, SVN)와 Debug(Local, Remote), Mobile IDE, Batch IDE, RDT로 구성되어 있습니다.

[개선 기능]

- Eclipse Luna 4.4 적용 및 Java 8 지원

- 배치 Template 버그 수정

- Portal, Enterprise Template 버그 수정

- 공통컴포넌트 버그 수정

- 모바일 공통컴포넌트 버그 수정


[설치방법]

개발환경을 구성할 디렉토리에 eGovFrameDev-3.5.1-xxbit.exe 파일을 실행하여 압축을 해제하고 eclipse를 실행하면 개발환경 필수요소와 선택요소가 모두 설치되어있는 개발환경을 사용할 수 있습니다.


[추가사항1]eclipse 실행 후 Failed to create the Java Virtual Machine 오류 발생 시, eclipse 설치 경로 > eclipse.ini 파일에 사용자 PC의 JDK 설치 경로를 다음과 같이 추가합니다.

(JDK는 1.7/1.8 버전을 사용을 권장합니다. 1.5/1.6버전에서는 플러그인이 정상적으로 작동하지 않습니다.)

(예시)

openFile

-vm

C:Program Files\Java\jdk1.7.0_47\bin\javaw.exe

-vmargs

-Dfile.encoding=UTF-8

-Dosgi.requiredJavaVersion=1.7

-Xms40m

-Xmx712m

-Dfile.encoding=UTF-8


[추가사항2]템플릿 생성 위저드를 이용하여 프로젝트 생성시 일부 DML파일의 한글깨짐 현상이 발생 할 수 있습니다. 위와 같은 문제 발생시 해당 DML파일의 encoding형식을 UTF-8에서 EUC-KR로 바꾸게 되면 정상적으로 사용 할 수있습니다.


*주의 : DeviceAPI 사용시 아래 개발자 가이드를 참고하여 추가 플러그인 및 android-sdk 설치 필요

http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:dev2:install_guide
```

### - 환경
```bin
	- [윈도우10/64bit]
	- [%JAVA_HOME% = C:\Program Files\Java\jdk1.7.0_79] [PATH=C:\Program Files\Java\jdk1.7.0_79\bin]
```

```bin
	- [ * 참조 : 소스관리 ]
	- [ 개발 프로그램 예시: C:\Program Dev\eGovFrameDev-3.5.1-64bit]
	- [ temp 워크스페이스 예시: C:\Program Dev\eGovFrameDev-3.5.1-64bit\workspace\egovframework]
	- [ 공통 워크스페이스 예시: C:\workspace\dev\eGovFrameDev-3.5.1-64bit\egovframework]
	- [ 레포지토리 예시: C:\workspace\repo\egovframework]
```

### - 설치
```bin
	- [eclipse install]
	- 다운파일 : http://www.egovframe.go.kr/cmm/fms/FileDown.do?atchFileId=FILE_000000000010462&fileSn=0
	- 다운파일 실행 후 C:\Program Dev 압축풀기
	- C:\Program Dev\eGovFrameDev-3.5.1-64bit\eclipse\eclipse\eclipse.exe 실행
	- C:\Program Dev\eGovFrameDev-3.5.1-64bit\workspace 워크스페이스 선택
	- eGovFrame 퍼스펙티브 열기
```
```bin
	- [workspace default JRE 설정]
	- eclipse에서 menu/Window/java/Installed JREs 에서 add > Standard VM > Directory : C:\Program Files\Java\jdk1.7.0_79
```
```bin
	- [ server]
	- server 뷰에서 create Now Server > apache/tomcat v7.0 > tomcat install Directory: C:\Program Dev\apache-tomcat-7.0.65
```

### - 소스
```bin
	- [git 저장소 클론/설정]
	- 소스경로 :  git@proits.iptime.org:ckoh/egovframework.git
	- 목적지경로 : C:\workspace\repo\egovframework
	- 저장소 클론
```
```bin
	- [프로젝트 설정]
	- eclipse 에서 git 퍼스펙티브 열기
	- add an existing local Git repository 선택
	- C:\workspace\repo\egovframework 저장소 경로 선택
	- /egovframework/working Dirctory/eGof 에서 import project
	- import as general project
	- eGovFrame 퍼스펙티브에서 eGof 우클릭 configure/Convert to Maven Project
```
```bin
	- [edu 소스 import]
	- git 퍼스펙티브에서 > env 프로젝트 import
	- [1st.zip, 2st.zip, 3st.zip, 4st.zip, 5st.zip 프로젝트들 import]
	- [ core project import] menu > import > General > Existing Projects inot Workspace/select archive file > C:\Program Dev\eGovFrameDev-3.5.1-64bit\workspace
	- [ web project import ]
	- prject 우클릭 properties/Prject Facets/Runtime/server > apply 확인
```
