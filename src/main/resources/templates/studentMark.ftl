<#import "templ/templ.ftl" as p>
<@p.pages>
    <h2>${studentsHasCourses._courses.courseName}</h2>
    <form method="post">

        <label style="font-size: x-large">Student: ${studentsHasCourses._students.firstName} ${studentsHasCourses._students.lastName}</label><br>

        <label style="font-size: x-large" for="mark">Mark:</label>
        <input type="number" name="mark" id="mark" value="${studentsHasCourses.mark}"><br>
        <br>
        <button class="btn btn-success" type="submit">Submit</button>
    </form>
</@p.pages>