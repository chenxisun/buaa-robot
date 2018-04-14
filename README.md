# buaa-robot
yes, tony
yes, zjg

-- 
model是用于前端页面数据展示的，而entity则是与数据库进行交互做存储用途
@Repository注解：用于标注数据访问组件，即DAO组件
@Service注解：用于标注业务层组件
@Controller注解：用于标注控制层组件（如struts中的action）
@Component注解：泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

In Spring 2.0 and later, the @Repository annotation is a marker for any class that fulfills the role or stereotype (also known as Data Access Object or DAO) of a repository. Among the uses of this marker is the automatic translation of exceptions.

Spring 2.5 introduces further stereotype annotations: @Component,  @Service, and @Controller. @Component is a generic stereotype for any Spring-managed component. @Repository, @Service, and @Controller are specializations of @Component for more specific use cases, for example, in the persistence, service, and presentation layers, respectively.

Therefore, you can annotate your component classes with @Component, but by annotating them with @Repository, @Service, or @Controller instead, your classes are more properly suited for processing by tools or associating with aspects. For example, these stereotype annotations make ideal targets for pointcuts.

Thus, if you are choosing between using @Component or @Service for your service layer, @Service is clearly the better choice. Similarly, as stated above, @Repository is already supported as a marker for automatic exception translation in your persistence layer.

