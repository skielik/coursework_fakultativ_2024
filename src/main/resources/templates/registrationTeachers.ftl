<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2> Registration </h2>
    <form action="/registrationTeachers" method="post">
        <@spring.bind "users"/>
        <label>Username</label>
        <@spring.formInput "users.username"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Password</label>
        <@spring.formInput "users.password"/><br>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "teachers"/>
        <label>First name</label>
        <@spring.formInput "teachers.firstName"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Last name</label>
        <@spring.formInput "teachers.lastName"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label>
        <@spring.formInput "teachers.email"/><br>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "courses"/>
        <label>Course name</label>
        <@spring.formInput "courses.courseName"/><br>
        <@spring.showErrors "<br>"/><br>



        <button type="submit">Submit</button>

    </form>
</@p.pages>