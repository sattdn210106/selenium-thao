package drafts;

import common.helpers.DataHelper;

public class Draft {
    public static void main(String[] args) {
        System.out.println(DataHelper.randomPID());
        System.out.println(DataHelper.randomEmail());
        System.out.println(DataHelper.randomText());
    }
}