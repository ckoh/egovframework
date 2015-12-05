# 환경설정 파일
- webapp 하나당 서블릿 1개 만들어짐.

 
	
board-WebApp
	- 소스들.....html,jsp,css, js, image : client가 접근 가능.
	- WEB-INF						   : 보안폴더.
		- classes
		- lib : 잠깐 테스트 용으로 사용해도 괜찮음. 스프링이 아니면 ..
		- web.xml
			- 각 서블릿 컨텍스트별 설정
		-src : 옵션
		-tld : 옵션
			- 테그라이브러리. 나만의 테그라이브러리. 표준화 된 테그라이브러리 많음.
		- jsp[배치가능..리졸버로 하려나.?]
	- META-INF		
	


개발진행
list.jsp 생성 : 하드코딩 jsp
servlet/DispatcherServlet.java 생성
	- java logic 추출 
	- 서블릿 사용 [서블릿에서 맞김/상속함.]
	- resqest 사용
	

# front controller 디자인 패턴 적용 : 진입점 중앙 집중. service 집중

  <servlet>
    <description></description>
    <display-name>DispatcherServlet</display-name>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/DispatcherServlet</url-pattern>
  </servlet-mapping>

  <servlet>
    <description></description>
    <display-name>DispatcherServlet</display-name>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app>

# front controlle 패턴에 따른 핸들맵핑 클래스 :  집중된 service Controller 섞기.
	- 확장 될 때 메모리에 등록 되겠 끔 한다.
	- 기능을 위한 핸들러 맵핑
	
# Command 디자인 패턴 : 폴리모피즘.
 - 서비스 사용을 추울


# spring  
web xml
  <servlet>
    <description></description>
    <display-name>action</display-name>
    <servlet-name>action</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>

 - 파일 이름 
  <servlet-name>action</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

  - action +  DispatcherServlet

- 파일 생성 
  WEB-INF/action-servlet.xml
  - 뷰 리졸퍼
  - 컨트롤러 스캔 [controller]

  controller/HelloController.java


# spring mvc 본겨 설정
 - mybatis 로딩 

web.xml
 - spring bean context 클래스 로더/리스터
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>classpath:applicationContext.xml</param-value>
</context-param>

<listener>
	<listener-class>
		org.springframework.web.context.ContextLoaderListener
	</listener-class>
</listener>

# view 생성 .jsp 
user_form.jsp
user_list.jsp
user_modify.jsp
user_view.jsp
user_write.jsp
- 서비스 연동 

- crud
- commadn 객체 : view 단에서 까지 네임을 맞추면 자동 공유 ~~^^


# web.xml
# 예외 처리
 - 컨트롤러 단에서 @ExceptionHandler(value=Exception.class) 등록 
 - 예외는 web.xml 등록하는 게  좋다.


 # tomcat 올릴 때 같이 다 올림.
 <!-- contextConfigLocation 서블릿 초기화. -->
<init-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>/WEB-INF/action-servlet.xml</param-value><!-- 이름 변경. -->
</init-param>

<!-- 톰캣 올릴 때 같이 올린다. 1은 뭐지. -->
<load-on-startup>1</load-on-startup>

# * 만약 꼬였 을 때 ...이클립스 
E:\workspace\dev\eGovFrameDev\.metadata\.plugins\org.eclipse.wst.server.core
E:\workspace\dev\eGovFrameDev\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost

- 여기를 지워야 됨. 
E:\workspace\dev\eGovFrameDev\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\eGofmvc_report\org\apache\jsp
E:\workspace\dev\eGovFrameDev\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\eGofmvc_report\org\apache\jsp\WEB_002dINF\view\user