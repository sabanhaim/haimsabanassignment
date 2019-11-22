package open_legacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import open_legacy.model.Item;

public interface Item_repository extends  JpaRepository<Item,Integer>{
	
	
	@Modifying
	@Query("UPDATE Item SET amount= amount - :amount WHERE item_id = :item_id")
	public void withdrawal_amount(@Param("item_id") int item_id, @Param("amount") int amount);

	@Modifying
	@Query("UPDATE Item SET amount= amount + :amount WHERE item_id = :item_id")
	public void deposit_amount(@Param("item_id") int item_id, @Param("amount") int amount);
	

}
