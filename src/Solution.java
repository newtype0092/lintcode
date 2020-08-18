import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Object> intputs;
    public ArrayList<Object> outputs;

    public Boolean test(int i) {
        Method[] methods = this.getClass().getDeclaredMethods();
        Method m = null;
        for(Method method : methods) {
            if (Modifier.toString(method.getModifiers()).equals("public")) {
                m = method;
            }
        }
        if (m == null) {
            System.out.println("no public method!");
            return false;
        }

        try {
            ArrayList<Object> ar = (ArrayList<Object>) intputs.get(i);
            var ret = m.invoke(this, ar.toArray());
            System.out.println("result:" + ret);
            return outputs.get(i).equals(ret);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }
}
