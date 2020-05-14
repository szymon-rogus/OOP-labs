package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.ItemExtras;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(ItemExtras item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();

		Category category = item.getCategory();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		if(category == Category.BOOKS) {
			propertiesMap.put("Liczba stron", item.getPages());
			propertiesMap.put("Twarda oprawa", item.isHardCover());
		}

		if(category == Category.ELECTRONICS) {
			propertiesMap.put("Mobilny", item.isMobile());
			propertiesMap.put("Gwarancja", item.isGuarantee());
		}
		if(category == Category.FOOD) {
			propertiesMap.put("Data przydatności do spożycia", item.getIsEatable());
		}
		if(category == Category.MUSIC) {
			propertiesMap.put("Video", item.isWithVideo());
			propertiesMap.put("Gatunek muzyczny", item.getMusicType());
		}

		return propertiesMap;
	}
}
