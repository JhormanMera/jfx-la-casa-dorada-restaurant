package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private static final String PEOPLE_SAVE_PATH_FILE="";
	private static final String CUSTOMES_SAVE_PATH_FILE="";
	private static final String INGREDIENTS_SAVE_PATH_FILE="";
	private static final String PRODUCTS_SAVE_PATH_FILE="";
	private static final String ORDERS_SAVE_PATH_FILE="";
	private static final String PRODUCT_TYPE_SAVE_PATH_FILE="";
	private static final String ORDER_CODE= String.format("P%04d", 100);
	private static final String FILE_SEPARATOR=";";
	private static List<Custome> customes;
	private static List<Person> people;
	private static List<Ingredients> ingredients;
	private static List<Product> products;
	private static List<ProductType> productType;
	private static List<Order> orders;
	
	
	
	public Restaurant() {
		customes = new ArrayList<>();
		people= new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();	
		orders = new ArrayList<>();
	}
	
	public void savePeople() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PEOPLE_SAVE_PATH_FILE));
       oos.writeObject(people);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadPeople() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PEOPLE_SAVE_PATH_FILE));
       people = (List<Person>) ois.readObject();
        ois.close();
    }
    public void saveCustomes() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMES_SAVE_PATH_FILE));
       oos.writeObject(customes);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadCustomes() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMES_SAVE_PATH_FILE));
       customes = (List<Custome>) ois.readObject();
        ois.close();
    }
    public void saveOrders() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDERS_SAVE_PATH_FILE));
       oos.writeObject(orders);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadOrders() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDERS_SAVE_PATH_FILE));
       orders = (List<Order>) ois.readObject();
        ois.close();
    }
    public void saveProducts() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_SAVE_PATH_FILE));
       oos.writeObject(products);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadProducts() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTS_SAVE_PATH_FILE));
       products = (List<Product>) ois.readObject();
        ois.close();
    }
    public void saveProductType() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
       oos.writeObject(productType);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadProductType() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
       productType = (List<ProductType>) ois.readObject();
        ois.close();
    }
    public void saveIngredients() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
       oos.writeObject(ingredients);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadIngredients() throws FileNotFoundException, IOException, ClassNotFoundException {
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INGREDIENTS_SAVE_PATH_FILE));
       ingredients = (List<Ingredients>) ois.readObject();
        ois.close();
    }
    
    
    public void sortByIngredients() {
		for(int i=0; i<ingredients.size(); i++) {
			int posMin=i;
			for(int j=i+1; j<ingredients.size(); j++) {
				if(ingredients.get(j).getName().compareTo(ingredients.get(posMin).getName())>0) {
					posMin=j;
				}

			}
			Ingredients aux=ingredients.get(i);
			ingredients.set(i,ingredients.get(posMin));
			ingredients.set(posMin,aux);

		}

    }
    
    public static void SortProductsByPrice() {
    	for(int i=0;i<products.size();i++) {
    		for(int j=i;j>0&&products.get(j-1).getPrice()>products.get(j).getPrice();j--) {
    			Product temp=products.get(j);
    			products.set(j,products.get(j-1));
    			products.set(j-1,temp);
    		}
    	}
    }
    
    public static void addCustomesListSorted(String name, String lastname, String ID, String address, String phone, String observations) {
    	Custome newCustome=new Custome(name, lastname, ID, address, phone, observations);
    	if(customes.isEmpty()) {
    		customes.add(newCustome);
    	}else{
    		int i=0;
    		while(i<customes.size() && newCustome.getLastname().compareTo(customes.get(i).getLastname())<0) {
    			i++;
    		}
    		customes.add(i, newCustome);
    	}
    }
    public static void addOrder (String state, String code, Custome custome, Employee employee, Date date, String observation, User creator, User lastEditor) {
    	Order newOrder = new Order( state,  code,  custome,  employee,  date,  observation,  creator,  lastEditor);
    }
    
  /*  public void importCustomes (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			addContact(parts[0],parts[1]);
			line = br.readLine();
		}
		br.close();

	}
    public void importProducts (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			addContact(parts[0],parts[1]);
			line = br.readLine();
		}
		br.close();

	}
	*/
    public void importOrders (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			
			//addOrder(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
			line = br.readLine();
		}
		br.close();

	}
	public void exportOrders(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter (fileName);
		for (int i=0;i<orders.size();i++) {
			Order myOrder = orders.get(i);
			writer.println(myOrder.getState()+FILE_SEPARATOR+myOrder.getCode()+FILE_SEPARATOR+myOrder.getCustome().getLastname()
					+FILE_SEPARATOR+myOrder.getCustome().getName()+FILE_SEPARATOR+myOrder.getEmployee().getID()+FILE_SEPARATOR+myOrder.getDate()
					+FILE_SEPARATOR+myOrder.getObservation()+FILE_SEPARATOR+myOrder.getCreator().getUserName()+FILE_SEPARATOR+myOrder.getLastEditor().getUserName());
		}
		writer.close();
	}
    /*
    public static String binarySearch(String name, String lastName) {
		Custome a=null;
		Custome b=null;
		int start =0;
		int finish=customes.size()-1;
		boolean end=true;
		for (int i=0;i<customes.size() && end;i++) {
			a=customes.get(i);
			while (start<= finish&&end) {
				int mid=(start+finish)/2;
				if(a) {
					finish=mid-1;
				}else if(a>array[mid]) {
					start=mid+1;
				}else {
					b=array[i];
					end=false;
				}
			}
		}
		return c;
	}*/


  }

