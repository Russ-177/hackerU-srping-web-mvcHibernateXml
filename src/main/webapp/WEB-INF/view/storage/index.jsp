<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <title>Склады</title>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${success == false}">
                    <div class="bg-error">Ошибка: ${message}</div>
                </c:when>
                <c:otherwise>
                    <h2>Наличие товара</h2>
                    <hr />
                    <div style="margin-bottom: 2em" class="row">
                        <div class="col-12">
                            <a href="/storage/add" class="btn btn-primary">Добавить новый склад</a>
                        </div>
                    </div>
                    <table class="table table-hovered table-border">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Склад</th>
                                <th colspan="2">Операции</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${storages}" var="storage">
                            <tr>
                                <td>${storage.id}</td>
                                <td>${storage.name}</td>
                                <td><a href="/storage/edit/${storage.id}">редактировать</a></td>
                                <td><a href="/storage/delete/${storage.id}">удалить</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
