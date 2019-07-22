# project
项目： 
spring-annotation
------------------
### @Configuration ： 
       告诉spring这是一个配置类（相当于配置文件bean.xml）

### @ComponentScans     
       value：指定要扫描的包
       excludeFilters = filter[] 指定扫描的时候按照什么规则排除那些组件
       includeFilters = filter[] 指定扫描的时候只需要包含那些组建，要配合禁用默认过滤规则（useDefaultFilters=false）
       @componentSans注解在4.1.1是没有的。
       demo:@ComponentScan(value = "com.huwy", excludeFilters = {
                 @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class,   Service.class})
                 })

### @Import:
       1）通过继承接口ImportBeanDefinitionRegistrar 来往容器中注入bean。
       demo：MyImportBeanDefinitionRegistrar
       使用地方：MainConfig 中@import注解中使用
       2）通过继承接口ImportSelector 来往容器中注入bean
       demo：MyImportSelector
       使用地方：MainConfig 中@import注解中使用
       3）通过spring中factoryBean往容器中注入bean
       demo: ColorFactory
       使用地方：Mainconfig类中colorFactory()方法。

### bean 的生命周期
       bean创建--初始化--销毁的过程
       容器管理bean的生命周期;
       我们可以自定义初始化和销毁方法：容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
       1)指定初始化和销毁方法
       a)通过@Bean指定init-method 和 destroy-method
       b)通过让bean实现InitializingBean(定义初始化逻辑)，DisposableBean（定义销毁逻辑）两个接口
       c)BeanPostProcessor【interface】:bean的后置处理器。在bean初始化前后进行一些处理工作。
       postProcessBeforeInitialization 初始化之前工作
       postProcessAfterInitialization  初始化之后工作  

### 使用@Value+@PropertySource赋值：
       1.基本数值  @Value("张三")
       2.可以谢SpEL:#{}   @Value("#{20-2}")
       3.可以写${};取出配置文件【properties】中的值（在运行环境变量的值）
       使用注解方式加载properties文件。
       @PropertySource(value = {"classpath:person.properties"}, encoding = "utf-8")
### @profile       
         profile:
            spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能。
            开发环境、测试环境、生产环境
            1)加上环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
            2）@profile写在配置类上，只有时指定的环境的时候，整个配置类里面的所有配置才能开始生效  
          使用：
            1)在虚拟机环境下添加参数-Dspring.profiles.active=test   （test、dev、prod三种，分别为测试、开发、生产）
           2)AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
             context.getEnvironment().setActiveProfiles("dev");
             context.register(MainConfigOfProfile.class);
             context.refresh();
             备注：/* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);*/
             不能用这种方式加载配置类
       
         

