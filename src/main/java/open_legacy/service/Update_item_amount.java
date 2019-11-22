package open_legacy.service;

import javax.validation.constraints.NotNull;

public class Update_item_amount {
	
	@NotNull
	private Integer Amount;

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}

}
