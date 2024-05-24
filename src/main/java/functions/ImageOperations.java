package functions;

import java.lang.reflect.InvocationTargetException;

public interface ImageOperations {
    float[] execute(float[] rgb) throws InvocationTargetException, IllegalAccessException;
}
