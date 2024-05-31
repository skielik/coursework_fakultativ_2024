<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2> Registration </h2>
    <form action="/registration" method="post">
        <br>
        <h5>Who are you?</h5>
        <a class="btn btn-primary" href="/registrationStudents" role="button">Student</a>
        <a class="btn btn-primary" href="/registrationTeachers" role="button">Teacher</a>

    </form>
</@p.pages>