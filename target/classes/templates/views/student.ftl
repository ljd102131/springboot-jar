<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生</title>
</head>
<body>
    <#assign path= springMacroRequestContext.getContextPath()/>
    <label>hello <b>${name}</b></label>
    <#if (time > 12)>下午好</#if>
    <#if (time>8 && time<=12)>上午好</#if>
    <#if time<=8>早上好</#if>
    <br>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>性别</td>
        </tr>
        <#list list?sort_by("id")?reverse as stu>
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.sex}</td>
            </tr>
        </#list>
    </table>
</body>
</html>