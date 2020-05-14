package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.ItemExtras;

public class ItemFilter {

	private ItemExtras itemSpec = new ItemExtras();

	public ItemExtras getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(ItemExtras item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		if (itemSpec.isHardCover() && !item.isHardCover()) {
			return false;
		}

		if (itemSpec.isMobile() && !item.isMobile()) {
			return false;
		}

		if(itemSpec.isGuarantee() && !item.isGuarantee()) {
			return false;
		}

		if(itemSpec.isWithVideo() && !item.isWithVideo()) {
			return false;
		}

		return true;
	}

}