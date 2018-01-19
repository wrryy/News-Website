<c:forEach items="${cats}" var="cat">
    <a href="/article/${cat.name}">${cat.name}</a>
</c:forEach>
<br>
<a href="/article/add">Add article</a>
<a href="/author/add">Add author</a>
<a href="/category/add">Add category</a>

