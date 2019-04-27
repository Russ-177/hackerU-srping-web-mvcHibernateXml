
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <title>Детские товар</title>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${list.id == 0}">
                    Создание нового товара
                </c:when>
                <c:otherwise>
                    Редактирование товара <c:out value="${list.name}" />
                </c:otherwise>
            </c:choose>
            <div class="row" style="margin-top: 2em">
                <div class="col-6">
                    <form:form modelAttribute="list" method="POST" action="${action}">
                        <form:hidden path="id" />
                        <div class="form-group">
                             <form:input class="form-control" path="name" placeholder="Наименование" />
                        </div>
                        <div class="form-group">
                            <form:input class="form-control" path="article" placeholder="Артикул" />
                        </div>
                        <div class="form-group">
                            <form:input class="form-control" path="price" placeholder="Цена" />
                        </div>
                        <div class="form-group">
                            <form:select class="form-control" path="storage" itemLabel="name" itemValue="id" items="${storages}"  />
                        </div>
                        <div class="form-group">
                            <input class="btn btn-primary" type="submit" value="Сохранить" />
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
