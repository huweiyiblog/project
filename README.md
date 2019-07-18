# project
项目： spring-annotation
  1）通过继承接口ImportBeanDefinitionRegistrar 来往容器中注入bean。
    demo：MyImportBeanDefinitionRegistrar
    使用地方：MainConfig 中@import注解中使用
  2）通过继承接口ImportSelector 来往容器中注入bean
    demo：MyImportSelector
    使用地方：MainConfig 中@import注解中使用
  3）通过spring中factoryBean往容器中注入bean
     demo: ColorFactory
     使用地方：Mainconfig类中colorFactory()方法。
