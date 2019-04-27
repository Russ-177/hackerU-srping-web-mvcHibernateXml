<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <title>Список товаров</title>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${success == false}">
                    <div class="bg-error">Ошибка: ${message}</div>
                </c:when>
                <c:otherwise>
                    <h2>Список товаров</h2>
                    <hr />
                    <div style="margin-bottom: 2em" class="row">
                        <div class="col-12">
                            <a href="/list/add" class="btn btn-primary">Добавить товар</a>
                        </div>
                    </div>
                    <table class="table table-hovered table-border">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Наименование</th>
                                <th>Артикул</th>
                                <th>Место хранения</th>
                                <th>Цена</th>
                                <th colspan="2">Операции</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="list">
                            <tr>
                                <td>${list.id}</td>
                                <td>${list.name}</td>
                                <td>${list.article}</td>
                                <td>${list.storage.name}</td>
                                <td>${list.price}</td>
                                <td><a href="/list/edit/${list.id}">редактировать</a></td>
                                <td><a href="/list/delete/${list.id}">удалить</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
