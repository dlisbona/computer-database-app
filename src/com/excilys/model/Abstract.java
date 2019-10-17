package com.excilys.model;

public abstract class Abstract {
     private static BeanFactory beanFactory;



     protected static BeanFactory getBeanFactory() {
          return beanFactory;
     }



     public static void setBeanfactory(BeanFactory setBeanFactory) {
          beanFactory = setBeanFactory;
     }


}
