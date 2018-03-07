package com.astontech.console;

import com.astontech.bo.*;
import com.astontech.bo.interfaces.*;
import com.astontech.dao.PersonDAO;
import com.astontech.dao.mysql.PersonDAOImpl;
import common.helpers.MathHelper;
import common.helpers.StringHelper;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class Main {
    static byte b;
    static short s;
    static int i;
    static long l;
    static float f;
    static double d;
    static boolean bl;

    final static Logger logger = Logger.getLogger(Main.class);



    public static void main(String[] args) {

        LessonDAO();

    }

    private static void LessonDAO() {
        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl();
        List<Person> personList = personDAO.getPersonList();

        System.out.println("================================");

        for (Person person : personList) {
            System.out.println(person.getPersonId() + ") " + person.getLastName() + ", " + person.getFirstName());
        }

        System.out.println("================================");
        //endregion

        //region PROMPT USER
        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a Person from list: ");
        String personId = reader.nextLine();
        //endregion

        //region GET PERSON DETAILS
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("------PERSON DETAILS------");
        System.out.println("Full Name: " + personDetail.GetFullName());

        //endregion
    }

    private static void JBANNExecuteQuery() {
        Connection conn = DatabaseConnectionLAB();

        try {
            Statement statement = conn.createStatement();
            String sql = "select DogId, DogName, DogColor from Dogs";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                int dogId = rs.getInt(1);
                String dogName = rs.getString(2);
                String dogColor = rs.getString(3);

                logger.info(dogId + ": " + dogName + " color: " + dogColor);
            }
            conn.close();


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static Connection DatabaseConnectionLAB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            logger.error("SQL Server Driver not found! " + ex);
            return null;
        }

        logger.info("SQL Server Driver Registered");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName = JBANN; userName = sa; password = BANjo33-");
        } catch (SQLException ex) {
            logger.error("Connection failed! " + ex);
            return null;

        }

        if(connection != null) {
            logger.info("Successfully connected to SQL Server database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }

    private static void LessonGetStoredProcedure() {
           Connection conn = LessonDBConnection();
           try {
               String sp = "{call GetPerson(?, ?)}";
               CallableStatement cStmt = conn.prepareCall(sp);

               cStmt.setInt(1, 20);
               cStmt.setInt(2, 5);
               ResultSet rs = cStmt.executeQuery();

               while(rs.next()) {
                   logger.info(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3));
               }

           } catch (SQLException sqlEx) {
               logger.error(sqlEx);
           }
    }

    private static void LessonExecuteQuery() {
        Connection conn = LessonDBConnection();
        try {
        Statement statement = conn.createStatement();
        String sql = "select PersonId, FirstName, LastName from Person";

        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            int personId = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);

            logger.info(personId + ": " + firstName + " " + lastName);
        }
        conn.close();


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static Connection LessonDBConnection() {
                String dbHost = "localhost";
                String dbName = "AstonEngineer";
                String dbUser = "consoleUser";
                String dbPassword = "BANjo33-";
                String useSSL = "false";
                String procBod = "true";


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found! " + ex);
            return null;
        }

        logger.info("MySQL Driver Registered");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPassword);
        } catch (SQLException ex) {
            logger.error("Connection failed! " + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }

    private static void ReverseString() {

        String stringOne = "The quick brown fox jumps over the lazy dog";

        System.out.println(Lab5.reverseString(stringOne));
    }

    private static void PetInterfaceTest() {
        HousePet dogOne = new HousePet();
        dogOne.setName("Frankie");
        dogOne.setColor("Black");
        dogOne.setWeight(25);
        dogOne.setNumberOfPets(2);

        HousePet birdOne = new HousePet();
        birdOne.setName("Oats");
        birdOne.setColor("Green");
        birdOne.setWeight(1);
        birdOne.setNumberOfPets(2);

        PetInterface(dogOne);
        PetInterface(birdOne);
    }

    private static void PetInterface(IPet Ipet) {
        System.out.println("Pet Name: " + Ipet.getPetName());
        System.out.println("Pet color: " + Ipet.colorOfPet());
        System.out.println("Pet is large: " + Ipet.isLarge());
        System.out.println("More than one pet: " + Ipet.moreThanOnePet());

    }

    private static void StringMethodTesting() {
        System.out.println(StringHelper.noSpaces("Dude, where's my car?"));
        System.out.println(StringHelper.toString(586));

        String parentString = "The quick brown fox jumps over the lazy dog.";
        CharSequence searchString = "dog";
        if (parentString.contains("dog")) {
            System.out.println("String contains search term: " + searchString);
        }
    }

    private static void LessonLogging() {
        //notes: levels of logging
        logger.debug("This is a DEBUG log message");
        logger.info("This is an INFO log message");

        //notes: production levels
        logger.warn("This is a WARN log message");
        logger.error("This is an ERROR log message");
        logger.fatal("This is a FATAL log message");

        //notes: log an exception
        try {
            int i = 10 / 0;
        } catch (ArithmeticException ex) {
            logger.error("An exception occurred: " + ex);
        }
    }

    private static void LessonInterfacesTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachines(2);
        MN010.setConferenceRooms(1);
        MN010.setCubicles(8);
        MN010.setOffices(6);
        MN010.setTrainingDesks(36);

        Home BipsHouse = new Home();
        BipsHouse.setAddress("1 Main Street");
        BipsHouse.setOwner(new Employee("Bipin", "Butala"));

        LessonInterfaces(MN010);
        LessonInterfaces(BipsHouse);

    }

    private static void LessonInterfaces(ILocation Ilocation) {
        System.out.println("=============================");
        System.out.println("Location Name: " + Ilocation.getLocationName());
        System.out.println("Can Have Meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of Workspaces: " + Ilocation.numberOfWorkSpaces());
        System.out.println("Has Coffee: " + Ilocation.hasCoffee());

    }

    private static void LessonHashLAB() {
        Hashtable<Integer, String> hashTableOne = new Hashtable<>();
        hashTableOne.put(1, "Rubber chicken");
        hashTableOne.put(2, "Whoopie Cushion");
        hashTableOne.put(3, "Clown nose");
        hashTableOne.put(4, "Fake spider");

        for (Integer key : hashTableOne.keySet()) {
            System.out.println("key: " + key + " - value: " + hashTableOne.get(key));
        }

        System.out.println("---------------------");

        HashMap<Integer, String> hashMapOne = new HashMap<>();
        hashMapOne.put(1, "Rubber chicken");
        hashMapOne.put(2, "Whoopie Cushion");
        hashMapOne.put(3, "Clown nose");
        hashMapOne.put(4, "Fake spider");

        for (Integer key : hashMapOne.keySet()) {
            System.out.println("key: " + key + " - value: " + hashMapOne.get(key));
        }

        System.out.println("---------------------");

        HashSet<String> hashSetOne = new HashSet<>();
        hashSetOne.add("Rubber chicken");
        hashSetOne.add("Whoopie cushion");
        hashSetOne.add("Clown nose");
        hashSetOne.add("Fake spider");

        for (String s : hashSetOne) {
            System.out.println(s);
        }

    }

    private static void LessonValueVsRef() {
        //notes: reference type
        Employee firstEmp = new Employee();
        firstEmp.setFirstName("Jodie");

        Employee secondEmp = firstEmp;
        firstEmp.setFirstName("Jane");
        secondEmp.setFirstName("Andrea");

        System.out.println(secondEmp.getFirstName());

        //notes: value types
        int firstInt = 10;
        int secondInt = firstInt;

        firstInt = 20;

        System.out.println(secondInt);
    }

    private static void LessonHash() {
        //notes: key-value pairs / value list

        //todo: HashTable
        /*
            1) does NOT allow null for either key or value
            2) synchronized, thread safe, but performance is decreased
         */

        System.out.println("---HASH TABLE---");

        Hashtable<Integer, String> firstHashTable = new Hashtable<>();
        firstHashTable.put(1, "Inheritance");
        firstHashTable.put(2, "Polymorphism");
        firstHashTable.put(3, "Abstraction");
        firstHashTable.put(4, "Encapsulation");

        System.out.println(firstHashTable.get(3));

        for (Integer key : firstHashTable.keySet()) {
            System.out.println("key: " + key + " - value: " + firstHashTable.get(key));
        }

        System.out.println("----------------");
        System.out.println("----------------");

        //todo: HashMap
        /*
            1) DOES allow null for either key or value
            2) un-synchronized, not thread safe, better performance
         */
        System.out.println("---HASH MAP---");

        HashMap<Integer, String> firstHashMap = new HashMap<>();

        firstHashMap.put(1, "Inheritance");
        firstHashMap.put(2, "Polymorphism");
        firstHashMap.put(3, "Abstraction");
        firstHashMap.put(4, "Encapsulation");
        firstHashMap.put(5, null);

        System.out.println("value from given key: " + firstHashMap.get(3));

        for (Integer key : firstHashMap.keySet()) {
            System.out.println("key: " + key + " - value: " + firstHashMap.get(key));
        }

        System.out.println("----------------");
        System.out.println("----------------");

        //todo: HashSet
        /*
            1) built in mechanism for duplicates
            2) used for where you want to maintain a unique list
         */

        System.out.println("---HASH SET---");

        HashSet<String> oopPrinc = new HashSet<>();
        oopPrinc.add("Inheritance");
        oopPrinc.add("Encapsulation");
        oopPrinc.add("Encapsulation");
        oopPrinc.add("Encapsulation");

        if (oopPrinc.contains("Polymorphism"))
            System.out.println("value exists");
        else
            System.out.println("value does not exist");

        for (String s : oopPrinc) {
            System.out.println(s);
        }

    }

    private static void LessonPolymorphism() {
        //notes: compile time polymorphism - overloaded

        //notes: run-time polymorphism - override

        BaseBO baseBO = new BaseBO();
        System.out.println(baseBO.test_method());

        EntityType entityType = new EntityType();
        System.out.println(entityType.test_method());
    }

    private static void LessonInstanceVsStatic() {


        System.out.println(MathHelper.E);
        System.out.println(MathHelper.PI);

        System.out.println(MathHelper.square(4));

    }

    private static void LessonCollectionsLAB () {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();

            vehicleList.add(new Vehicle(
                    1,
                    2010,
                    "ABC123",
                    "3ABCD24GHRE573892",
                    "Blue",
                    true,
                    6000,
                    new Date(117, 0, 4),
                    new VehicleMake(1, "Toyota"),
                    new VehicleModel(1, "Camry")));

            vehicleList.add(new Vehicle(
                    2,
                    2011,
                    "XYZ789",
                    "4GHIK67RISO937285",
                    "Red",
                    true,
                    6500,
                    new Date(117, 1, 17),
                    new VehicleMake(1, "Toyota"),
                    new VehicleModel(2, "Prius")));


            System.out.println(vehicleList.toString());
        }

    private static void LessonComplexProperties() {
//        //notes: when to use inheritance (should answer the question: 'IS A?')
//        //       when to use complex (nested) objects (should answer the question: 'HAS A?')
//
        EntityType emailWorkType = new EntityType("Work");
        Email myEmail = new Email("thedude@lebowski.com");
        myEmail.setEmailType(emailWorkType);

        System.out.println(myEmail.getEmailAddress() + " Type: " + myEmail.getEmailType().getEntityTypeName());

//        //notes: collection/list of complex(nested) objects as a property
        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("dan@test.com"));
        myEmployee.getEmails().add(new Email("jason@test.com"));

        for(Email email : myEmployee.getEmails()) {
            System.out.println(email.getEmailAddress());
        }

    }

    private static void LessonCollections() {
//        //notes: List<T> - generic type 'T'
        List<Employee> employeeList = new ArrayList<Employee>();
//
        Employee emp1 = new Employee("Dan", "Simmer");          //index 0
        Employee emp2 = new Employee("James", "McRoberts");     // 1
        Employee emp3 = new Employee("Sean", "Nilsen");         // 2
        Employee emp4 = new Employee("Adrian", "Ratanyake");    // 3
//
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        employeeList.add(new Employee("John", "Doe"));      // 4
//
        System.out.println(employeeList.get(0).GetFullName());
        for(Employee e : employeeList) {
            System.out.println(e.GetFullName());
        }
    }

    private static void LessonObjectsLAB() {
        Address AddressOne = new Address();
        AddressOne.setAddressNumber(3230);
        AddressOne.setStreet("Nicollet Ave");
        AddressOne.setStreet02("Apt. 204");

        System.out.print(AddressOne.getAddressNumber());
        System.out.print(" ");
        System.out.println(AddressOne.getStreet());
        System.out.println(AddressOne.getStreet02());

        Client ClientOne = new Client();
        ClientOne.setClientName("Lebowski Industries");

        System.out.println(ClientOne.getClientName());

        ClientContact ClientContactOne = new ClientContact();
        ClientContactOne.setClientContactId(3);

        System.out.println(ClientContactOne.getClientContactId());

        Email EmailOne = new Email();
        EmailOne.setEmailAddress("thedude@lebowski.com");

        System.out.println(EmailOne.getEmailAddress());


    }

    private static void LessonMethods() {
//        //notes: method signature / declaration
//        /*
//            <access modifier> <instance/static> <return data type> <method name> (<data type> <param name>, <data type> <param name>, ...) (body)
//             private            static              void            LessonMethods   (nothing passed in)
//
//             public                                 int             getPersonId     (nothing passed in)
//
//             public                                 void            setPersonId     (int personId)
//         */
//
//        //notes: constructors are special methods with same name as class
        Employee constructorEmployee = new Employee("Jodie", "Banner");
        System.out.println(constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName());

        Employee const2Employee = new Employee("Rodriguez");
        System.out.println(const2Employee.getLastName());

        Employee employeeJames = new Employee("James", "McRoberts");
        System.out.println(employeeJames.GetFullName());
    }

    private static void LessonInheritance() {
//        //notes: 4 principles(tenets) Encapsulation, Abstraction, Inheritance, Polymorphism
//
        Employee employeeJod = new Employee();
        employeeJod.setFirstName("Jodie (e)");
        employeeJod.setLastName("Banner (e)");
        employeeJod.setEmployeeId(3);

        System.out.println(employeeJod.getEmployeeId() + ": " + employeeJod.getFirstName() + " " + employeeJod.getLastName());

        Person personJod = new Person();
        personJod.setFirstName("Jodie (p)");
        personJod.setLastName("Banner (p)");
        personJod.setPersonId(2);

        System.out.println(personJod.getPersonId() + ": " + personJod.getFirstName() + " " + personJod.getLastName());


    }

    private static void LessonClassObjects() {
//        //notes: instantiating a new object
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Jodie");
        myFirstPerson.setLastName("Banner");
        myFirstPerson.setTitle("Ms.");

        System.out.print(myFirstPerson.getTitle());
        System.out.print(" ");
        System.out.print(myFirstPerson.getFirstName());
        System.out.print(" ");
        System.out.println(myFirstPerson.getLastName());

        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Carmen");
        mySecondPerson.setLastName("Rodriguez");
        mySecondPerson.setTitle("Sra.");

        System.out.print(mySecondPerson.getTitle());
        System.out.print(" ");
        System.out.print(mySecondPerson.getFirstName());
        System.out.print(" ");
        System.out.println(mySecondPerson.getLastName());

//        //notes: setting value for super (inherited) class
        myFirstPerson.setPersonId(3);
        System.out.print(myFirstPerson.getPersonId());
    }

    private static void ThrowException() {
        String stringOne = "Dude, where's my car?";
        try {
            String subStringOne = stringOne.substring(5, 22);
            System.out.println(subStringOne);
        }
        catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Exception: String index out of bounds");
        }

    }

    private static void LessonCalculatorLAB() {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter number 0-9: ");
        int input = userInput.nextInt();


        while (input < -1 || input > 10) {
            System.out.println("INVALID");
            System.out.println("Enter number 0-9: ");
            input = userInput.nextInt();
            if(input > -1 && input < 10) {
                break;
            }
        }

        System.out.println("Enter other number 0-9: ");
        int input2 = userInput.nextInt();

        System.out.println("Enter valid operator: ");
        String input3 = userInput.next();

        while (!(input3.equals("*") || input3.equals("/") || input3.equals("+") || input3.equals("-"))) {
            System.out.println("INVALID");
            System.out.println("Enter valid operator: ");
            input3 = userInput.next();
            if (input3.equals("*") || input3.equals("/") || input3.equals("+") || input3.equals("-")) {
                break;
            }
        }

        switch (input3) {

            case "*":
                System.out.println(input * input2);
                break;

            case "/":
                System.out.println(input / input2);
                break;

            case "+":
                System.out.println(input + input2);
                break;

            case "-":
                System.out.println(input - input2);
                break;
        }

    }

    private static void LessonFizzBuzzLAB() {

       for(int x=1; x<=100; x++) {
            if (x % 3 == 0) {
                System.out.println("FIZZ");
        } else if (x % 5 == 0) {
                System.out.println("BUZZ");
            } else if(x % 15 == 0) {
                System.out.println("FIZZBUZZ");
            } else {
                System.out.println(x);}
        }
    }

    private static void LessonExceptions() throws Exception{
//        //todo: simple unhandled exception
//        String firstName = "Jodie";
//        int x = Integer.parseInt(firstName);
//
//                System.out.print("Integer value: ");
//                System.out.println(x);

//        //todo: try - catch block
//        String firstName = "Jodie";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer value: ");
//            System.out.println(x);
//        }
//        catch(NumberFormatException ex) {
//            System.out.println("Exception: Invalid Number");
//        }

//        //todo: try - catch with multiple catch blocks
//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer value: ");
//            System.out.println(x);
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: String was null or empty");
//        }
//        catch (NullPointerException ex)
//        {
//            System.out.println("Exception: Null Pointer");
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: Generic Exception");
//        }
//
//        //todo: try - catch with multiple catch and finally block
//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer value: ");
//            System.out.println(x);
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: String was null or empty");
//        }
//        catch (NullPointerException ex)
//        {
//            System.out.println("Exception: Null Pointer");
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: Generic Exception");
//        }
//        finally
//        {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }

//        //todo: exception object
//        //notes: base exception class
//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer value: ");
//            System.out.println(x);
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        catch (NullPointerException ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        finally
//        {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }

//        //todo: throwing an exception
        String firstName = null;
        try {
            int x = Integer.parseInt(firstName);

            System.out.print("Integer value: ");
            System.out.println(x);
        }
        catch (Exception ex)
        {
            throw new Exception("A custom exception from LessonExceptions method.", ex);
        }
    }

    private static void LessonFlowControl() {
//        //notes: IF-ELSE
        String name = "jodie";
        if(name == "Jane") {
            System.out.println("correct first name");
            System.out.println("another line");

        } else
            System.out.println("incorrect first name");

            if(name.length() > 10) {
                System.out.println("very long first name");
        }   else if(name.length() > 5) {
                System.out.println("long first name");
            } else {
                System.out.println("short first name");
            }

//            //notes CASE-SWITCH
            switch(name)
            {
                case "jodie":
                    System.out.println("cool first name");
                    break;

                case "jane":
                    System.out.println("first name is jane");
                            break;

                default:
                    System.out.println("some other first name");
                    break;
            }
    }

    private static void LessonOperators() {
//        //notes: plus / minus
        int val = 10;
        System.out.println(val + 10);
        System.out.println(val - 10);
//
//        //notes: modulus (%) the remainder
        int modVal = 10 % 3;  //the remainder of 10 / 3 which is 1
        System.out.println(modVal);
//
//        //notes: increment (++) / decrement (--)
        System.out.println("increment after: ");
        System.out.println(val++); //10
        System.out.println(val++); //11
        System.out.println(val++); //12
        System.out.println(val);

        val = 10;
        System.out.println("increment before: ");
        System.out.println(++val); //10
        System.out.println(++val); //11
        System.out.println(++val); //12
        System.out.println(val);

        val = 10;
        System.out.println("decrement after: ");
        System.out.println(val--); //10
        System.out.println(val--); //9
        System.out.println(val--); //8
        System.out.println(val);  //7

        val = 10;
        System.out.println("decrement before: ");
        System.out.println(--val); //9
        System.out.println(--val); //8
        System.out.println(--val); //7
        System.out.println(val);   //7

//        //notes: logical equals (==) / logical not equal (!=)
        val = 10;
        int anotherVal = 10;

        if(val != anotherVal)
            System.out.println("Not Equals");
        else
            System.out.println("Equals");

//        //notes: logical AND (&&) / logical OR (||)
        if(val == 10 && anotherVal == 10 || val == 11 || val == 13)
            System.out.println("is true");
        else
            System.out.println("not true");

//        //notes negation (!)
        boolean boolVar = true;
        if(!boolVar)
            System.out.println("is true");
        else
            System.out.println("not true");

    }

    private static void LessonFundamentalsLAB() {
//        //notes: create a Scanner object
        Scanner reader = new Scanner(System.in);
//        //notes: prompt the user
        System.out.print("Enter number 1-10: ");
//        //notes: read input from the user and store in a variable
        int input = reader.nextInt();
//        //notes: print the value back to the screen
        System.out.println(input + 1.75);
//
//        //notes: primitive data types with printed max and min values when relevant
        System.out.println("Min byte value = " + Byte.MIN_VALUE);
        System.out.println("Max byte value = " + Byte.MAX_VALUE);
        System.out.println("Min short value = " + Short.MIN_VALUE);
        System.out.println("Max short value = " + Short.MAX_VALUE);
        System.out.println("Min int value = " + Integer.MIN_VALUE);
        System.out.println("Max int value = " + Integer.MAX_VALUE);
        System.out.println("Min long value = " + Long.MIN_VALUE);
        System.out.println("Max long value = " + Long.MAX_VALUE);
        System.out.println("Min float value = " + Float.MIN_VALUE);
        System.out.println("Max flat value = " + Float.MAX_VALUE);
        System.out.println("Min double value = " + Double.MIN_VALUE);
        System.out.println("Max double value = " + Double.MAX_VALUE);

        String stringOne = "The quick brown fox jumps over the lazy dog.";
        String partOfStringOne = stringOne.substring(4, 19);
        System.out.println(partOfStringOne);

        List<String> myStringList = new ArrayList<>();
        myStringList.add("List Item One");
        myStringList.add("List Item Two");
        myStringList.add("List Item Three");
        myStringList.add("List Item Four");
        myStringList.add("List Item Five");

        for (String singleString : myStringList) {
            System.out.println(singleString);
        }

        String gameName = "Powerball";
        int gamePrice = 2;
        int drawnBallOne = 17;
        int drawnBallTwo = 26;
        int drawnBallThree = 34;
        int drawnBallFour = 18;
        int drawnBallFive = 39;
        int powerBall = 25;
        Date drawingDate = new Date(118, 1, 8);
        String jackpot = "23,000,000";

        System.out.println(gameName);
        System.out.println(gamePrice);
        System.out.println(drawnBallOne);
        System.out.println(drawnBallTwo);
        System.out.println(drawnBallThree);
        System.out.println(drawnBallFour);
        System.out.println(drawnBallFive);
        System.out.println(powerBall);
        System.out.println(drawingDate.toString());
        System.out.println(jackpot);



    }

    private static void DefaultDataValues() {


                System.out.println("Byte: " +b);
                System.out.println("Short: "+s);
                System.out.println("Int: "+i);
                System.out.println("Long: "+l);
                System.out.println("Float: "+f);
                System.out.println("Double: "+d);
                System.out.println("Boolean: "+bl);
            }

    private static void LessonLists() {
        //notes: collections / Lists
        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("1st String");
        myStringCollection.add("2nd String");
        myStringCollection.add("3rd String");
        myStringCollection.add("4th String");
        myStringCollection.add("5th String");

        System.out.println(myStringCollection);

        for(String singleString : myStringCollection) {
            System.out.println(singleString);
        }

        List<Integer> myIntCollection = new ArrayList<Integer>();

        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);

        System.out.println(myIntCollection);

        for(int singleInt : myIntCollection) {
            System.out.println(singleInt);
        }
//
//        //notes: arrays
//
        String[] myStringArray = new String[5];

        myStringArray[0] = "1st";
        myStringArray[1] = "2nd";
        myStringArray[2] = "3rd";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";

        System.out.println(myStringArray);

        for(String singleString : myStringArray) {
            System.out.println(singleString);
        }

        myStringArray[5] = "6th";
    }

    private static void LessonStrings() {

//        //notes: strings have a value or not
        String firstString = "";
        firstString = "something";
//        firstString = null;

        if(firstString == null || firstString.isEmpty()) {
            System.out.println("String is empty");}
            else {
                System.out.println("String has a value");
        }

//        //notes: immutable - unable to be changed
//        firstString = "another value"; //this creates a new string

        for(int x = 0; x <=100; x++) {
            firstString = "new value: " + Integer.toString(x);
            System.out.println(firstString); //we are creating a new string for every iteration - very inefficient
        }

//        //notes: StringBuilder()
        StringBuilder myStringBuilder = new StringBuilder();

        for(int x = 0; x <=100; x++) {
            myStringBuilder.append("new value with string builder: ")
                            .append(Integer.toString(x) + "\n")
                            .append("\n");
        }

        System.out.println(myStringBuilder);
//
//        //notes: searching strings (indexOf, lastIndexOf)
        String myName = "Jodie";
//        /*
//        string can be visualized as an array of characters
//         J   o   d   i   e
//        [0] [1] [2] [3] [4]
//
//        note that the array is zero based (starts at zero)
//
//        character at index 2 is the letter "d"
//         */
//
        int indexOf = myName.indexOf("d");
        System.out.println(indexOf);

        int lastIndexOf = myName.lastIndexOf("e");
//
////        //notes: enumerating a string
        String largeString = "This is a longer string than before";
        for(char c : largeString.toCharArray()) {
            System.out.println(c);
        }
////
////        //notes: substring (beginning index) or substring (beginning index, end index)
        String partOfLargerString = largeString.substring(8, 16);
        System.out.println(partOfLargerString);
    }

    private static void LessonDataTypes() {
//        //notes: primitive data types
        //       int (number)
        //       float (floating point .)
        //       double (larger number)
        //       boolean (true / false)
        //       char (character)
//
//        //notes: common data types
        boolean myBool = false;
        int myInt = 4;
        String myString = "some words";
        Date myDate = new Date();

        System.out.println(myBool);
        System.out.println(myInt);
        System.out.println(myString);
        System.out.println(myDate);
//
//        //notes: parsing or converting data types
//
//        //notes: string -> int
        String numberString = "341";
        int intFromString = Integer.parseInt(numberString);

    }

    private static void LessonVariables(){
//        //notes: declare multiple variables and set
        String lastName = "Banner", firstName = "Jodie";
//
//        //notes: output to the console
        System.out.println(firstName + " " + lastName);
//
//        //notes: create a Scanner object
        Scanner reader = new Scanner(System.in);
//        //notes: prompt the user
        System.out.print("Enter your name: ");
//        //notes: read input from the user and store in a variable
        String input = reader.nextLine();
//        //notes: print the value back to the screen
        System.out.println("Hello " + input);

    }

}
