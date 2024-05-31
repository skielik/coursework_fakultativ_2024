<#import "templ/templ.ftl" as p>
<@p.pages>
    <h2>Marks</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Student</th>
            <th scope="col">Course</th>
            <th scope="col">Teacher</th>
            <th scope="col">Mark</th>
        </tr>
        </thead>
        <tbody>
        <#if marks??>
            <#list marks as marks>
                <tr>
                    <td>${marks._students.firstName} ${marks._students.lastName}</td>
                    <td>${marks._courses.courseName}</td>
                    <td>${marks._courses.teachers.firstName}</td>
                    <td>${marks.mark}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
    <a href="/teacherLogin" class="btn btn-primary" style="margin-left: 1630px">Change marks</a>

</@p.pages>