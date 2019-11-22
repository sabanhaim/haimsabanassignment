package open_legacy.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import open_legacy.model.Item;
import open_legacy.repository.Item_repository;

@Service
public class Inventory_service {
	
	@Autowired
	private Item_repository item_repository;
	
	public List<Item> get_all() {
		return item_repository.findAll();
    }
	
	public String create_item(Item item) throws Exception{
		is_validiate_item(item);
		item_repository.save(item);
		return "success";
    }
	
	public Item get_item(@PathVariable int  id) throws Exception {
		Item item=item_repository.findById(id).get();
		is_exist_item(item);
		return item;
    }
	
	@Transactional
	public String withdrawal(@PathVariable int id,Update_item_amount amount) throws Exception {
		Item item=item_repository.findById(id).get();
		is_exist_item(item);
		valid_amount(amount);
		if (item.getAmount() - amount.getAmount() < 0) {
			throw new Exception("the amount must be a positive");
		}
		item_repository.withdrawal_amount(id,amount.getAmount());
		return "success";
    }
	
	@Transactional
	public String deposit(@PathVariable int id,Update_item_amount amount) throws Exception {
		Item item=item_repository.findById(id).get();
		is_exist_item(item);
		valid_amount(amount);
		item_repository.deposit_amount(id,amount.getAmount());
		return "success";
    }
	
	public String delete_item(@PathVariable int id) throws Exception {
		Item item=item_repository.findById(id).get();
		is_exist_item(item);
		item_repository.deleteById(id);
		return "item delete";
	}
	
	
	private void valid_amount(Update_item_amount amount) throws Exception {
		if(amount.getAmount()<0) {
			throw new Exception("amount have to be positive");
		}
	}
	
	private void is_exist_item(Item item) throws Exception{
		if(item==null) {
			throw new Exception("non exist item");
		}
	}
	private void is_validiate_item(Item item) throws Exception{
		if (item==null) {
			throw new Exception("empty item");
		}
		
		if (item.getName()==null || item.getName().length()<2) {
			throw new Exception("Give longer name");
		}
		
		if (item.getAmount()<0) {
			throw new Exception("illegal amount");
		}
		if (item.getInventoryCode()==0) {
			throw new Exception("illegal InventoryCode.");
		}
		
	}

}
