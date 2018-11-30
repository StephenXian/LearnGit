package JDKproxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AServiceImpl implements AService {
    @Override
    public void update() {
        System.out.println("这个是没有增强前的update方法");
    }

    @Override
    public void add() {
        System.out.println("这个是增强前的add方法");
        List list = new ArrayList();
    }
}
