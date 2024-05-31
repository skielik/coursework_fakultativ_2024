<#import "templ/templ.ftl" as p>
<@p.pages>
    <h2>${course.courseName}</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Student</th>
            <th scope="col">Mark</th>
        </tr>
        </thead>
        <tbody>
        <#if studentHasCourses??>
            <#list studentHasCourses as studentHasCourses>
                <tr>
                    <td>${studentHasCourses._students.firstName} ${studentHasCourses._students.lastName}</td>
                    <td>${studentHasCourses.mark}</td>
                    <td><a href="/submitMarks/${studentHasCourses.id}" class="btn btn-primary">Change mark</a></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@p.pages>