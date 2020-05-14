package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class Index {

	private List<ItemExtras> items = new ArrayList<>();

	private List<Category> categories = new LinkedList<>();

	public void addItem(ItemExtras item) {
		items.add(item);
	}

	public void registerCategory(Category category) {
		categories.add(category);
	}
	
	public Category getCategory(String name) {
		for(Category category : categories) {
			if(category.getDisplayName().equals(name)) {
				return category;
			}
		}
		
		return null;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	

	public List<Item> getItems() {
		return new ArrayList<>(items);
	}

	public List<ItemExtras> getItems(Category category) {
		List<ItemExtras> categoryItems = new ArrayList<>();

		for (ItemExtras item : items) {
			if (item.getCategory().equals(category)) {
				categoryItems.add(item);
			}
		}

		return categoryItems;
	}
	

	public List<ItemExtras> getItems(ItemFilter filter) {
		List<ItemExtras> result = new LinkedList<>();
		
		for (ItemExtras item : items) {
			if (filter.appliesTo(item)) {
				result.add(item);
			}
				
		}
		
		return result;
	}
	
	
	


}
