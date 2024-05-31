<#import "templ/templ.ftl" as p>
<@p.pages>
    <form method="post">

        <label for="username">Username</label><br>
        <input type="text" name="username" id="username" placeholder="username"><br>

        <label for="password">Password</label><br>
        <input type="password" name="password" id="password" placeholder="password"><br>
        <br>
        <button class="btn btn-success" type="submit">Submit</button>
    </form>
    <br>
    <a href="/registration"> Registration</a>

</@p.pages>