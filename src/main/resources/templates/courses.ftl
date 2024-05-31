<#import "templ/templ.ftl" as p>
<@p.pages>
   <h2>Courses</h2>
   <div class="row" style="align-items: center; justify-content: center">
      <#if courses??>
         <#list courses as course>
            <div class="col-2">
               <div class="card" style="width: 18rem;">
                  <div class="card-body">
                     <h5 class="card-title">${course.courseName}</h5>
                     <p class="card-text">${course.teachers.firstName} ${course.teachers.lastName}</p>
                     <a href="/courses/${course.id}" class="btn btn-primary">Enroll in a course</a>
                  </div>
               </div>
            </div>
         </#list>
      </#if>
   </div>

</@p.pages>