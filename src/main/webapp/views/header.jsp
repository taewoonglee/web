<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String uri  = request.getRequestURI();
  if(uri.equals("/login" )|| uri.equals("/user"))
  {

  }
  else
  {
    if(session.getAttribute("uid") == null) response.sendRedirect("/login");
  }
%>
<table>
  <tr>
    <td>
      <a href="/main">main</a>
    </td>
    <td>
      <a href="/login">logout</a>
    </td>
  </tr>
</table>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
</body>
</html>
