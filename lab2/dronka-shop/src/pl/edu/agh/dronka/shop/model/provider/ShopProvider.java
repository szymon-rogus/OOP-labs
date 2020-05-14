package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pl.edu.agh.dronka.shop.model.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (ItemExtras item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<ItemExtras> getExampleItems() {
		List<ItemExtras> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));

		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));

		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));

		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));

		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<ItemExtras> readItems(CSVReader reader, Category category) {
		List<ItemExtras> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {

				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));

				ItemExtras item;

				if(category == Category.BOOKS) {
					item = new ItemExtras(name, category, price, quantity);
					int page = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
					boolean hardCover = Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"));
					item.setPages(page);
					item.setHardCover(hardCover);
				} else
				if(category == Category.ELECTRONICS) {
					item = new ItemExtras(name, category, price, quantity);
					boolean mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
					boolean guarantee = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
					item.setMobile(mobile);
					item.setGuarantee(guarantee);
				} else
				if(category == Category.FOOD) {
					item = new ItemExtras(name, category, price, quantity);
					SimpleDateFormat format = new SimpleDateFormat("dd-mm-yy");
					Date date = format.parse(reader.getValue(dataLine,"Data przydatności do spożycia"));
					item.setIsEatable(date);
					System.out.println(item.getIsEatable());
				} else
				if(category == Category.MUSIC) {
					item = new ItemExtras(name, category, price, quantity);
					boolean video = Boolean.parseBoolean(reader.getValue(dataLine, "Video"));
					MusicType type =  MusicType.valueOf(reader.getValue(dataLine, "Gatunek muzyczny"));
					item.setWithVideo(video);
					item.setMusicType(type);
				} else
					item = new ItemExtras(name, category, price, quantity);


				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);

				items.add(item);

			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return items;
	}

}
