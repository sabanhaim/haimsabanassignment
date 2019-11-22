package open_legacy.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import open_legacy.model.Item;
import open_legacy.service.Inventory_service;
import open_legacy.service.Update_item_amount;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Inventory_controller {
	
	@Autowired
	private Inventory_service inventory_service;
	
	
	@GetMapping("/items")
	@ApiOperation(value = "View a list of current items", response = List.class)	
	public List<Item> get_items()
	{
	   return inventory_service.get_all();
	}
	
	@PostMapping("/add_item")
	@ApiOperation("Add item to DB")
	public String addItem(Item item) throws Exception
	{
	   return inventory_service.create_item(item);
	}

	@GetMapping("/items/{id}")
	@ApiOperation("Get item from DB")
	public Item  getProductById(@PathVariable int id) throws Exception {
		return inventory_service.get_item(id);
	}
	
	@PutMapping("/withdrawal/{id}")
	@ApiOperation("update item withdrawal amount")
	public String withdrawal(@PathVariable int id, @Valid @RequestBody Update_item_amount amount) throws Exception{
	   return inventory_service.withdrawal(id,amount);
   }
   @PutMapping("/deposit/{id}")
   @ApiOperation("update item deposit amount")
	public String deposit(@PathVariable int id, @Valid @RequestBody Update_item_amount amount) throws Exception{
	   return inventory_service.deposit(id,amount);
   }
   
   @DeleteMapping("/items/{id}")
   @ApiOperation("delete item from DB")
	public String deleteProductById(@PathVariable int id) throws Exception {
	   	String result= inventory_service.delete_item(id);
		return result;
	}
   
   
	
	

}
