package ben.config;
    
import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class AppConfig implements Config {
    
    private static final AppConfig INSTANCE = new AppConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    private AppConfig() {
        dialect = new MysqlDialect();
        dataSource = new LocalTransactionDataSource(
            "jdbc:mysql://localhost:3306/spring_webapp",
            "ben_dev",
            "ben_pass"
        );
        transactionManager = new LocalTransactionManager(
            dataSource.getLocalTransaction(getJdbcLogger())
        );
    }
    
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }
    
    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static AppConfig singleton() {
        return INSTANCE;
    }

}