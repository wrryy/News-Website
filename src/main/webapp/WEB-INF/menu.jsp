<c:forEach items="${cats}" var="cat">
    <a href="/article/${cat.name}">${cat.name}</a>
</c:forEach>


<%--<div class="dropdown">--%>
    <%--<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Article categories--%>
        <%--<span class="caret"></span></button>--%>
    <%--<ul class="dropdown-menu">--%>
        <%--<c:forEach items="${cats}" var="cat">--%>
            <%--<li><a href=""><c:out value="${cat.name}"/></a></li>--%>
        <%--</c:forEach>--%>
    <%--</ul>--%>
<%--</div>--%>
<%--<div class="dropdown">--%>
    <%--<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Menu--%>
        <%--<span class="caret"></span></button>--%>
    <%--<ul class="dropdown-menu">--%>
        <%--<li><a href="/article/all">All articles</a></li>--%>
        <%--<li><a href="/author/all">All authors</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>