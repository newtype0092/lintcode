import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Solution {
    public ArrayList intputs;
    public ArrayList outputs;

    public Boolean test(int i) {
        Method[] methods = this.getClass().getDeclaredMethods();
        Method m = methods[0];
        System.out.println(m.getName());

        try {
            ArrayList<Object> ar = (ArrayList<Object>) intputs.get(i);
            var ret = m.invoke(this, ar.toArray());
            System.out.println("result:" + ret);
            return outputs.get(i).equals(ret);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }
}
