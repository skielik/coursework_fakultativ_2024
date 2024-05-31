<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2> Registration </h2>
    <form action="/registrationStudents" method="post">
        <@spring.bind "users"/>
        <label>Username</label>
        <@spring.formInput "users.username"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Password</label>
        <@spring.formInput "users.password"/><br>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "students"/>
        <label>First name</label>
        <@spring.formInput "students.firstName"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Last name</label>
        <@spring.formInput "students.lastName"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Age</label>
        <@spring.formInput "students.age"/><br>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label>
        <@spring.formInput "students.email"/><br>
        <@spring.showErrors "<br>"/><br>


        <button type="submit">Submit</button>

    </form>
</@p.pages>