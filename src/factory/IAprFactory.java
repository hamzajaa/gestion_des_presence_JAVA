package factory;

import apr.Apr;

public interface IAprFactory {
    Apr getInstance(Apr apr) throws Exception;
}
