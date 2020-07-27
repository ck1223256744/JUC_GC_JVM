package OOM;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
public class MetaSpaceOOM {


    static class t{}

    public static void main(String[] args) {
        int i=0;
        try {
            while (true){
                i++;
                Enhancer enhancer=new Enhancer();
                enhancer.setSuperclass(t.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("exception on :"+i);
        }
    }
}
