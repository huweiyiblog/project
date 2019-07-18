# project
项目： spring-annotation
    
    @Configuration ： 
    告诉spring这是一个配置类（相当于配置文件bean.xml）
    
      @ComponentScans       
      value：指定要扫描的包
      excludeFilters = filter[] 指定扫描的时候按照什么规则排除那些组件
      includeFilters = filter[] 指定扫描的时候只需要包含那些组建，要配合禁用默认过滤规则（useDefaultFilters=false）
      @componentSans注解在4.1.1是没有的。
      demo:@ComponentScan(value = "com.huwy", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value =                       {Controller.class,   Service.class})})
    
    @Import:
    1）通过继承接口ImportBeanDefinitionRegistrar 来往容器中注入bean。
        demo：MyImportBeanDefinitionRegistrar
        使用地方：MainConfig 中@import注解中使用
    2）通过继承接口ImportSelector 来往容器中注入bean
        demo：MyImportSelector
        使用地方：MainConfig 中@import注解中使用
    3）通过spring中factoryBean往容器中注入bean
         demo: ColorFactory
         使用地方：Mainconfig类中colorFactory()方法。
