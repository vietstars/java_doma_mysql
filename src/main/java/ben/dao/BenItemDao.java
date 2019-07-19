package ben.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import ben.config.AppConfig;
import ben.entity.BenItem;

@Dao(config = AppConfig.class)
public interface BenItemDao {
	
	@Select
	List<BenItem> selectAll();
	
}