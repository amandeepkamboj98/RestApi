package JsonServer_Data;

import org.testng.annotations.DataProvider;

public class Referdata {

    @DataProvider(name = "empdataprovider")
    public Object[][] dataForPost() {
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Preet";
//        data[0][1] = 1801978;
//        data[0][2] = 10;
//
//        data[1][0] = "Sandeep";
//        data[1][1] = 1802899;
//        data[1][2] = 11;
//
//        return data;

        return new Object[][]{{"Sandeep", 1801978, 10}, {"ritu", 1801979, 11}, {"Rohit", 1801980, 12}};
    }

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[] {6,7,8};
    }
}
