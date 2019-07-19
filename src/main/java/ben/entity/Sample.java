package ben.entity;

import java.util.List;

import org.seasar.doma.jdbc.tx.TransactionManager;

import ben.config.AppConfig;
import ben.dao.BenItemDao;
import ben.dao.BenItemDaoImpl;
import ben.entity.BenItem;

public class Sample {

    public static void main(String[] args) {
        
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(new Runnable(){

            @Override
            public void run() {
                BenItemDao dao = new BenItemDaoImpl();
                
                List<BenItem> list = dao.selectAll();
                for(BenItem entity : list) {
                    System.out.println(entity.toString());
                }
            }
            
        });
    }
}