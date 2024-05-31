<#import "templ/templ.ftl" as p>
<@p.pages>
    <h2>Students</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Student</th>
        </tr>
        </thead>
        <tbody>
        <#if students??>
            <#list students as students>
        <tr>
            <td>${students.firstName} ${students.lastName}</td>
        </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@p.pages>