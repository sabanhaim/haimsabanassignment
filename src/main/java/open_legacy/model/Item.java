package open_legacy.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "item_id")
	private Integer  item_id;

	@Column(name = "Name", nullable = false)
	private String Name;
	
	@NotNull
	@Column(name = "Amount",nullable = false)
	private Integer Amount;
	
	@NotNull
	@Column(name = "Inventory_code",nullable = false)
	private Integer Inventory_code;

    public Integer  getNumber() {
        return item_id;
    }
    
    protected Item(){}

    public Item(String Name,Integer Amount,Integer Inventory_code) {
		this.Name = Name;
		this.Amount = Amount;
		this.Inventory_code = Inventory_code;
		
	}

    public void setNumber(Integer  item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getInventoryCode() {
        return Inventory_code;
    }

    public void setInventoryCode(int Inventory_code) {
        this.Inventory_code = Inventory_code;
    }
}
