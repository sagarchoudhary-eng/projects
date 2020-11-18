<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- WC invoke ALL matching setters --%>
<jsp:setProperty property="*" name="cust" />

<%--Invoke B.L of JSP --> JB w/o scriptlet --%>
<%--response.sendRedirect(response.encodeRedirectURL(session.getAttribute("cust").authenticateCustomer().concat(".jsp")))--%>
<c:redirect url="${sessionScope.cust.authenticateCustomer()}.jsp" />
