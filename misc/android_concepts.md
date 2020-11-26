# Android Concepts

## Radio Buttons 
- are organized using a RadioGroup 
        
- to get the checked id and value from a RadioGroup
    ```java
    RadioGroup rg = findViewById(R.iradioGroupId);

    Integer radioButtonId = rg.getCheckedRadioButtonId();

    RadioButton rb = findViewById(radioButtonId);
    ```

- to check a RadioButton programatically you need to have the radioButtonId
    ```java
	rg.check(radioButtonId);
	```

#
## Shared preferences
- are anonymous files stored inside the phone that can be used to save data
         
- to access the sharedPreferences file use
    ```java
	SharedPreferences sharedPreferences = getSharedPreferences("APP_TOKEN", MODE_PRIVATE);
	```

- to read from sharedPreferences use sharedPreferences.get() methods
    ```java
	sharedPreferences.getString("STRING_IDENTIFIER");
	```

- to write to the sharedPreferences file
    - create and Editor
        ```java
		SharedPreferences.Editor = sharedPreferences.edit();
		```
    
	- put data using the editor.put methods
        ```java
		editor.putString("STRING_IDENTIFIER", string_parameter);
		```

	- to save the data use the commit function
        - the method returns a boolean which says if the operation was succesful or not
			```java
			boolean result = editor.commit();
			```

#
## Activity's state
- to preserve the state of an activity you have to override the `OnSaveInstanceState` method

- the data is saved inside the outState bundle

- you can attach something to the bundle using `bundle.put` methods

- saved state can be accesesd inside the `OnCreate` method through the `savedInstanceState` parameter

- to get something from the bundle use `savedInstanceState.get` methods 

#
## Intents
- data can be passed form an activity to another using Intents

- a class transfered through an intent should implement the Serializable interface

#
## Working with dates
- in the Constants interface create two resources
    ```java
	String DateFormat = "dd-mm-yyyy";
    SimpleDateFormat dateFormatter = new SimpleDateFormat(DateFormat);
	```
        
- when you receive a date from a layout input, convert it to date
    ```java
	// if the value is invalid, an error will be thrown
	Date date = dateFormatter(input);
	```
        
- if you want to convert a Date back to String, use the same method
	```java
    String date = dateFormatter(date);
	```

- to get the current date 
    ```java
	Date date = new Date()
    // then format it
	```

#
## Menus
- create a new directory in the res directory and name it "menu"
    
- create a new "Menu Resource File" using the interface

- create as many MenuItems as you need

- back in the Activity where you want to implement the menu

- override the `OnCreateOptionsMenu` method and inflate the menu
	```java
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.your_menu_layout, menu);
	```

- if you want to hide an element use 
    ```java
	menu.findItem(R.id.your_menu_item).setVisible(false);
	```

- to set specific behaviour for clicking on a menu item override the `onOptionsItemsSelected` and use a switch to treat all the cases
	```java
    switch(item.getItemId()){
		case R.id.your_item_id:
            doSomething();
            return 1;
		default:
			return 0;
        }
	```

#
## Array Adapters
- it can be used with a Spinner(R.layout.) or a ListView(R.layout.)

- you have to override the toString method in the target class
	```java
	ArrayAdapter adapter = new ArrayAdapter(getApplicationContext, R.layout.resource, yourCollectionWithObjects);

	spinner.setAdapter(adapter);
	```
        
- to update the adapters data source use `adapter.notifyDataSetChange();`

- to use an adapter for array declared in the strings.xml file use
	```java
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.your_array, R.layout.support_simple_spinner_dropdown_item);
	```

- to define an array in the strings.xml file use
    ```xml
	<string-array name="array-name">
		<item>Elem1</item>
        <item>Elem2</item>
    </string-array>
	```

#
## Custom Adapters
- particular type of adapters which supports complex behaviour

- they should be implemented starting from a base class
    - example of base classes: SpinnerAdapter, ListAdapter, ArrayAdapter

- Custom Array Adapter example
    - create a new linear layout to structure the way your List View should look
    
	- create a new layout in which you place the targeted List View

    - create a new class which extends the ArrayAdapter<> base class
		```java
		class ExpenseAdapter extends ArrayAdapter<Expense>
		```
                
    - override the constructor with 3 parameters (context, resource, list of objects) then add LayoutInflater inflater as 4th parameter

    - declare a class variable for each parameter of the constructor and intialize them inside the constructor with the received parameters

    - override the `getView` method
    
	- inside the method, create a View object which will be used to display a row
		```java
		View row = inflater.inflate(resource, parent, false);
		```

    - inside this method populate all the textViews present in the linear layout structure and return the row
	
	```java
    public class ExpenseAdapter extends ArrayAdapter<Expense> {

		private Context context;
		private int resource;
		private List<Expense> expenses;
		private LayoutInflater inflater;

        public ExpenseAdapter(@NonNull Context context, int resource, @NonNull List<Expense> objects, LayoutInflater inflater){
			super(context, resource, objects);
			this.context = context;
			this.resource = resource;
			this.expenses = objects;
			this.inflater = inflater;

        }

		@NonNull
		@Override
		public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
			View row = inflater.inflate(resource, parent, false);
			
			TextView tvDate = row.findViewById(R.id.tv_date_expense_display);			
			TextView tvAmount = row.findViewById(R.id.tv_amount_expense_display);			
			TextView tvDescription = row.findViewById(R.id.tv_description_expense_display);			
			TextView tvCategory = row.findViewById(R.id.tv_category_expense_display);

			Expense expense = expenses.get(position);

            tvDate.setText(expense.getData()!=null ? Constant.simpleDateFormat.format(expense.getData()):null);
			tvDescription.setText(expense.getDescription());
			tvAmount.setText(expense.getAmount() != null ? expense.getAmount().toString():null);
			tvCategory.setText(expense.getCategory());

            return row;
        }
	}
	```		
    
	- use it in the targeted activity as follows
		```java
		CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.your_linear_layout_template, objects, getLayoutInflater());
		```

#
## AsyncTask
- the AsyncTask class allows the application to execute tasks asynchronously and return the result in the UI thread

- implementation example
    - create a new class and extend the AsyncTask class
        ```java 
		class CustomAsync extends AsyncTask<input_parameters_type, progress_parameters_type, output_parameters_type>
		```

        - override the method doInBackground
            - this is the method that will run in a separate thread

		- to use this class override the "onPostExecute" during instantiation
			```java
            CustomAsync custom = new CustomClass(){
                protected void onPostExecute(String s) {
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                } 
            }
			```

        - run the async operation 
            ```java
			custom.execute(params);
			```

        - the `onPostExecute` method will be called after the async execution has finished

#
## HTTP Manager
- HTTP operations are run using an AsyncTask implementation

- to interact with a REST web service you need to use 5 different entities
	- URL url - will open the HTTP connection
    
	- HttpURLConnection connection - will handle the HTTP connection
    
	- InputStream iStream - will receive an input stream from the network

	- InputStreamReader iReader - will parse the received stream
    
	- BufferedReader bReader - will parse smaller chunks from the InputStreamReader data
    
	- StringBuilder builder - will concatenate the HTTP response received through input stream

- they are declared in the AsyncTask implementation as attributes
	```java
    try {
		url = new URL(strings[0]);
		connection = (HttpURLConnection) url.openConnection();
		inputStream = connection.getInputStream();
		inputStreamReader = new InputStreamReader(inputStream);
		bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while((line = bufferedReader.readLine()) != null){
            builder.append(line);
        }

    } catch (MalformedURLException e) {
        e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
    } finally{
		try {
			bufferedReader.close();
            inputStreamReader.close();
			inputStream.close();
            connection.connect();
        } catch (IOException e) {
			e.printStackTrace();
        }
    }
    
	return builder.getString();
	```

#
## Parsing JSON
- fortunately, a helper class for parsing JSON is implemented by default in Java
	```java
	JSONObject obj = new JSONObject(object);
	JSONArray arr = obj.getJSONArray("key");

	obj.getJSONObject("key");
	```

#
## Databases
- for local databases, Android uses SQLite

- the easiest way to interact with a database is through the SQLiteOpenHelper class

- to do this, `3` files are needed
	- DatabaseConstants
        - interface that will hold the SQL strings and other configuration strings

    - DatabaseController
        - class that will extend the SQLiteOpenHelper and will interact with the DB
        - used for low-level SQL operations (db connection, tables creation)
        - usually implemented as a singleton 

    - Repository
		- will hold references to SQLiteDatabase and DatabaseController
		- implements open() and close() methods
        - will be used for DML operations (insert, update, delete)
			- ContentValues class is map-like class used to format the data before insertion
				- contentValues.put - used to append data to the future insertion

			- Cursor class is used to parse the results returned from a db query
				- cursor.moveToNext() - go to the next returned row
				- cursor.get - gets data from the current returned row

- example
    - DatabaseController
		- attributes 
            - private static DatabaseController controller;

        - methods
            - private constructor that can be accessed only from class
                ```java        
				private DatabaseController(@Nullable Context context) {
					super(context, DATABASE_NAME, null, DATABASE_VERSION);
				}
				```

            - public static getInstance to substitute the constructor
                        - is synchronized so it can be used on multiple threads (when AsyncTask is running, for example)
				```java
				public static DatabaseController getInstance(Context context){
					if(controller == null){
						synchronized(DatabaseController.class){
							if(controller == null){
								controller = new DatabaseController(context);
                            }
                        }
                	}
                    
					return controller;
                }
				```
                        
                - override the `onCreate` method
                    - call `sqliteDatabase.execSQL("Create tables string")`;
                        
                - override the `onUpgrade` method
                    - call the `sqliteDatabase.execSQL("Drop tables string")`;
					- call the `onCreate(sqLiteDatabase)`;

    - Repository
        - attributes
            - private DatabaseController controller;
            - private SQLiteDatabase database;

		- methods
            - public constructor
				```java
				public Repository(Context context) {
					controller = DatabaseController.getInstance(context);
                }

                public void open() {
					database = controller.getWritableStream();
            	}

                public void close() {
                    database.close();
            	}
				```

            - methods for DML operations
                - will have to use
                    - database.insert("TABLE_NAME", null, contentValues);
                    - database.query("TABLE_NAME", null, ...) - null for everything else
                    - contentValues
                    - cursor

                - Insert example
					```java
                    public long insertExpense(Expense expense){
                        if(expense == null){
                            return -1;
                        }

                        //its structure resembles a map with a key and a value
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(EXPENSE_COLUMN_DATE, expense.getData() != null ? Constant.simpleDateFormat.format(expense.getData()) : null);
                        contentValues.put(EXPENSE_COLUMN_AMOUNT, expense.getAmount());
                        contentValues.put(EXPENSE_COLUMN_CATEGORY, expense.getCategory());
                        contentValues.put(EXPENSE_COLUMN_DESCRIPTION, expense.getDescription());

                        return database.insert(EXPENSE_TABLE_NAME,null, contentValues);
                    }
					```

				- Select everything from a table example
					```java
                    public List<Expense> findAllExpense(){
                        List<Expense> results = new ArrayList<>();

                        Cursor cursor = database.query(EXPENSE_TABLE_NAME, null, null, null, null, null, null, null);

                        while(cursor.moveToNext()){
							Long id = cursor.getLong(cursor.getColumnIndex(EXPENSE_COLUMN_ID));
                            Date date = null;
                                                        
							try{
                                date = Constant.simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex(EXPENSE_COLUMN_DATE)));
                            } catch(ParseException ex){
                                ex.printStackTrace();
                            }

                            String category = cursor.getString(cursor.getColumnIndex(EXPENSE_COLUMN_CATEGORY));
                            String description = cursor.getString(cursor.getColumnIndex(EXPENSE_COLUMN_DESCRIPTION));
                            Double amount = cursor.getDouble(cursor.getColumnIndex(EXPENSE_COLUMN_AMOUNT));

							results.add(new Expense(id, date, category, amount, description));
                        }

						cursor.close();
                        
						return results;
                    }					
					```

#
## Requestion permissions
- for internet
    - `<uses-permission android:name="android.permission.INTERNET" />`

- for wi-fi only
	- `<uses-feature android:name="android.hardware.wifi" />`

- write to storage
	- `<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />`
        
- read from storage
	- `<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />`

#
## AlertDialog Example
```java
    new AlertDialog.Builder(this)
		.setTitle("Title")
		.setMessage("Do you really want to do smth?")
		.setPositiveButton(android.R.string.yes, 
			new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
				Toast.makeText(MainActivity.this, "Yaay", Toast.LENGTH_SHORT).show();
		}})
		.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				Toast.makeText(MainActivity.this, "Ok then", Toast.LENGTH_SHORT).show();
		}})
		.show();
```

#
## Screen Rotation
- you have to override the "onSaveInstanceState" and "onRestoreInstanceState" methods

- when the screen is rotated, the activity is basically destroyed so you have to repopulate all the inputs

- you have to keep references to the adapter and to the display control (the listview, for example)
