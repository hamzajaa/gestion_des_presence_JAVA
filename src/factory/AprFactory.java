package factory;

import apr.Apr;
import apr.DotnetApr;
import apr.JavaApr;
import apr.Type;

public class AprFactory implements IAprFactory {
    @Override
    public Apr getInstance(Apr apr) throws Exception {
        Type type = apr.getType();
        switch (type) {
            case JAVA -> {
                return new JavaApr(apr.getName(), apr.getYearOfBirth());
            }
            case DONTNET -> {
                return new DotnetApr(apr.getName(), apr.getYearOfBirth());
            }
            default -> throw new IllegalAccessException("Invalid Apr type: " + type);

        }
    }
}
